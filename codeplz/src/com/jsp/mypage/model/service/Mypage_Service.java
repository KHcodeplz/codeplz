package com.jsp.mypage.model.service;
import static com.common.connect.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.jsp.board.model.vo.Board;
import com.jsp.mypage.model.dao.Mypage_Dao;



public class Mypage_Service {

   public ArrayList<Board> myPost(String user_nickname) {
      Connection result = getConnection();
      
      ArrayList<Board> list = new Mypage_Dao().myPost(result, user_nickname);
      
      close(result);
      
      System.out.println("mypage_service myPost : "+ list);
      return list;
   }



}