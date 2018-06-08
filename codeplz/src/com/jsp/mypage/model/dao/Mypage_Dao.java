package com.jsp.mypage.model.dao;
import static com.common.connect.JDBCTemplate.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import com.jsp.mypage.model.vo.Mypage;




public class Mypage_Dao {

private Properties prop;
	
	public Mypage_Dao(){
		prop= new Properties();
		
		String prop_Path = Mypage_Dao.class.getResource("/com/config/mypage/mypage-query.properties").getPath();
		
		try {
			prop.load(new FileReader(prop_Path));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public ArrayList<Mypage> myPost(Connection result, String user_nickname) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Mypage> list = null;

		
		System.out.println("마이페이지 DAO 스트링값 : "+user_nickname);
		String sql = prop.getProperty("myPost");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setString(1, user_nickname);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Mypage>();
			
			while ( rset.next() ) {
				Mypage mp = new Mypage();
				mp.setBoard_index(rset.getInt("COL_BOARD_INDEX"));
				mp.setBoard_title(rset.getString("COL_BOARD_TITLE"));
				mp.setBoard_category_index(rset.getInt("COL_BOARD_CATEGORY_INDEX"));
				mp.setBoard_writer(rset.getString("COL_USER_NICKNAME"));
				mp.setBoard_inserted_date(rset.getDate("COL_BOARD_INSERTED_DATE"));
				mp.setBoard_elapsed_date(rset.getInt(6));
				
				list.add(mp);
			}
			System.out.println("마이페이지 Dao : "+list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Mypage> myReply(Connection result, String user_nickname) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Mypage> list = null;

		
		System.out.println("마이페이지 DAO 스트링값 : "+user_nickname);
		String sql = prop.getProperty("myReply");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setString(1, user_nickname);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Mypage>();
			
			while ( rset.next() ) {
				Mypage mp = new Mypage();
				
				mp.setBoard_index(rset.getInt("COL_BOARD_INDEX"));
				mp.setBoard_title(rset.getString("COL_BOARD_TITLE"));
				mp.setBoard_category_index(rset.getInt("COL_BOARD_CATEGORY_INDEX"));
				mp.setReply_writer(rset.getString("COL_REPLY_WRITER"));
				mp.setReply_index(rset.getInt("COL_REPLY_INDEX"));
				mp.setReply_content(rset.getString("COL_REPLY_CONTENT"));
				mp.setReply_inserted_date(rset.getDate("COL_REPLY_INSERTED_DATE"));
				mp.setBoard_elapsed_date(rset.getInt(8));

				
				
				list.add(mp);

			}
			System.out.println("마이페이지 Dao : "+list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Mypage> myPostReply(Connection result, String user_nickname) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Mypage> list = null;

		
		System.out.println("마이페이지 DAO 스트링값 : "+user_nickname);
		String sql = prop.getProperty("myPostReply");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setString(1, user_nickname);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Mypage>();
			
			while ( rset.next() ) {
				Mypage mp = new Mypage();
				mp.setBoard_index(rset.getInt("COL_BOARD_INDEX"));
				mp.setBoard_title(rset.getString("COL_BOARD_TITLE"));
				mp.setBoard_category_index(rset.getInt("COL_BOARD_CATEGORY_INDEX"));
				mp.setReply_writer(rset.getString("COL_REPLY_WRITER"));
				mp.setReply_index(rset.getInt("COL_REPLY_INDEX"));
				mp.setReply_content(rset.getString("COL_REPLY_CONTENT"));
				mp.setReply_inserted_date(rset.getDate("COL_REPLY_INSERTED_DATE"));
				mp.setBoard_elapsed_date(rset.getInt(8));
				
				list.add(mp);

			}
			System.out.println("마이페이지 Dao : "+list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	
}
