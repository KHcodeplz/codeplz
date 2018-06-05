package com.jsp.board.model.dao;

import static com.common.connect.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.jsp.board.model.vo.Board_Comment;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class Board_Comment_Dao {
	private Properties prop;

	public Board_Comment_Dao(){
		prop= new Properties();
		
		String prop_Path = Board_Dao.class.getResource("/com/config/board/board_comment-query.properties").getPath();
		
		try {
			prop.load(new FileReader(prop_Path));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public ArrayList<Board_Comment> selectList(Connection result, int index) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board_Comment> cList =null;
		
		String sql= prop.getProperty("selectList");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setInt(1, index);
	
			
			rset = pstmt.executeQuery();
			
			cList = new ArrayList<Board_Comment>();
			
			while(rset.next()){
				Board_Comment bco = new Board_Comment();
				
				bco.setReply_index(rset.getInt("COL_REPLY_INDEX"));
				bco.setBoard_index(index);
				bco.setReply_content(rset.getString("COL_REPLY_CONTENT"));
				bco.setReply_writer(rset.getString("COL_REPLY_WRITER"));
				bco.setReply_inserted_date(rset.getDate("COL_REPLY_INSERTED_DATE"));
				bco.setReply_modified_date(rset.getDate("COL_REPLY_MODIFIED_DATE"));
				
				cList.add(bco);
				
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return cList;
	}

	public int insert_Comment(Connection result, Board_Comment bco) {
		PreparedStatement pstmt = null;
		int num = 0;
		
		String sql =prop.getProperty("insertComment");
		System.out.println(bco);
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setInt(1, bco.getBoard_index());
			pstmt.setString(2, bco.getReply_content());
			pstmt.setString(3, bco.getReply_writer());
			
			num = pstmt.executeUpdate();
			System.out.println(num);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(result);
		}
		
		
		return num;
	}

	public int update_Comment(Connection result, Board_Comment bco) {
		PreparedStatement pstmt = null;
		int num = 0;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setString(1, bco.getReply_content());
			pstmt.setInt(2, bco.getReply_index());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return num;
	}

	public int delete_Comment(Connection result, int cIndex) {
		PreparedStatement pstmt = null;
		int num = 0;
		
		String sql = prop.getProperty("deleteComment");
		
		try {
			pstmt= result.prepareStatement(sql);
			pstmt.setInt(1, cIndex);
			num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			}
		System.out.println("dAOnum:" +num);
		return num;
	}
	
	

}
