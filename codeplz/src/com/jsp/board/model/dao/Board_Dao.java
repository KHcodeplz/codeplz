package com.jsp.board.model.dao;

import static com.common.connect.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.jsp.board.model.vo.Board;

public class Board_Dao {

	private Properties prop;

	public Board_Dao() {
		prop = new Properties();

		String fileName = Board_Dao.class.getResource("/com/config/board/board-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertBoard(Connection con, Board board) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertBoard");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, board.getBoard_category_index());
			pstmt.setString(2, board.getBoard_tags());
			pstmt.setString(3, board.getBoard_title());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setString(5, board.getBoard_file());
			pstmt.setString(6, board.getBoard_writer());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public int updateBoard(Connection con, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateBoard");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, board.getBoard_category_index());
			pstmt.setString(2, board.getBoard_tags());
			pstmt.setString(3, board.getBoard_title());
			pstmt.setString(4, board.getBoard_content());
			pstmt.setString(5, board.getBoard_file());
			pstmt.setInt(6, board.getBoard_index());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int getBoardIndex(Connection result, String writer, String title) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int index = 0;
		
		System.out.println(writer + ", " + title);
		
		String query = prop.getProperty("getBoardIndex");
		
		try {
			pstmt = result.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				index = rset.getInt("COL_BOARD_INDEX");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(index);
		
		return index;
	}

	public ArrayList<Board> selectList(Connection result, int currentPage, int limit, int CategoryIndex) {
	      // Statement stmt = null;
	      PreparedStatement pstmt = null;

	      ResultSet rset = null;
	      ArrayList<Board> list = null;

	      String sql = prop.getProperty("selectList");

	      System.out.println(sql);

	      try {
	        
	         
	         pstmt = result.prepareStatement(sql);
	         
	         
	         
	         //조회 시작할 행 번호와 마지막 행 번호 계산 
	         int startRow = (currentPage - 1) * limit + 1;
	         int endRow = startRow + limit - 1;
	         
	         pstmt.setInt(1, CategoryIndex);
	         pstmt.setInt(2, startRow);
	         pstmt.setInt(3, endRow);
	         
	         rset = pstmt.executeQuery();
	          
	         
	         list = new ArrayList<Board>();

	         while (rset.next()) {
	            Board b = new Board();
	            //넘버 타이틀 작성자 추천수 조회수
	            b.setBoard_index(rset.getInt("COL_BOARD_INDEX"));
	            b.setBoard_title(rset.getString("COL_BOARD_TITLE"));
	            b.setBoard_writer(rset.getString("COL_USER_NICKNAME"));
	            b.setBoard_hits(rset.getInt("COL_BOARD_HITS"));
	            b.setBoard_category_index(rset.getInt("COL_BOARD_CATEGORY_INDEX"));
	            b.setBoard_file(rset.getString("COL_BOARD_FILE"));
	            list.add(b);
	            
	            System.out.println(b);
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         
	         close(pstmt);
	      }

	      return list;
	   }

	public int getListCount(Connection result, int CategoryIndex) {
		PreparedStatement pstmt = null;

		int listCount = 0;
		ResultSet rset = null;

		String sql = prop.getProperty("listCount");

		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setInt(1, CategoryIndex);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println(listCount);
		return listCount;
	}

	public Board boardDetail(Connection result, int index) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String sql = prop.getProperty("Detail");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setInt(1, index);
			rset=pstmt.executeQuery();
			
			if(rset.next()){
				b =  new Board();
				b.setBoard_index(rset.getInt("COL_BOARD_INDEX"));
				b.setBoard_category_index(rset.getInt("COL_BOARD_CATEGORY_INDEX"));
				b.setBoard_tags(rset.getString("COL_BOARD_TAGS"));
				b.setBoard_title(rset.getString("COL_BOARD_TITLE"));
				b.setBoard_content(rset.getString("COL_BOARD_CONTENT"));
				b.setBoard_file(rset.getString("COL_BOARD_FILE"));
				b.setBoard_writer(rset.getString("COL_USER_NICKNAME"));
				b.setBoard_inserted_date(rset.getDate("COL_BOARD_INSERTED_DATE"));
				b.setBoard_hits(rset.getInt("COL_BOARD_HITS"));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public int updateHits(Connection result, int index) {
		PreparedStatement pstmt = null;
		int num =0;
		String sql = prop.getProperty("updateHits");
		
		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setInt(1, index);
			
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return num;
	}
	
	public int deleteBoard(Connection result, int index) {
		PreparedStatement pstmt = null;
		int num = 0;
		String sql = prop.getProperty("boardDelete");

		try {
			pstmt = result.prepareStatement(sql);
			pstmt.setInt(1, index);

			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("last:"+num);
		return num;
	}

}
