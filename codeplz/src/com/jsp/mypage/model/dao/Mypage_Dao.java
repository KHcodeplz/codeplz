package com.jsp.mypage.model.dao;
import static com.common.connect.JDBCTemplate.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import com.jsp.board.model.vo.Board;



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

   public ArrayList<Board> myPost(Connection result, String user_nickname) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<Board> list = null;

      
      System.out.println("마이페이지 스트링값 : "+user_nickname);
      String sql = prop.getProperty("myPost");
      
      try {
         pstmt = result.prepareStatement(sql);
         pstmt.setString(1, user_nickname);
         
         rset = pstmt.executeQuery();
         
         list = new ArrayList<Board>();
         
         while ( rset.next() ) {
            Board b = new Board();
            b.setBoard_index(rset.getInt("COL_BOARD_INDEX"));
            b.setBoard_title(rset.getString("COL_BOARD_TITLE"));
            b.setBoard_category_index(rset.getInt("COL_BOARD_CATEGORY_INDEX"));
            b.setBoard_writer(rset.getString("COL_USER_NICKNAME"));
            b.setBoard_inserted_date(rset.getDate("COL_BOARD_INSERTED_DATE"));
            b.setBoard_elapsed_date(rset.getInt(6));
            
            list.add(b);
            System.out.println("b : "+b);
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