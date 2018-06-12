package com.jsp.mypage.model.service;
import static com.common.connect.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.jsp.mypage.model.dao.Mypage_Dao;
import com.jsp.mypage.model.vo.Mypage;

public class Mypage_Service {

   public ArrayList<Mypage> myPage(String user_nickname, int index) {
      Connection result = getConnection();
      ArrayList<Mypage> list = null;
      
      if ( index == 0 ) {   
         list = new Mypage_Dao().myPost(result, user_nickname);
      } else if ( index == 1 ) {
         list = new Mypage_Dao().myReply(result, user_nickname);
      } else if ( index == 2 ) {
         list = new Mypage_Dao().myPostReply(result, user_nickname);
      }
      
      close(result);
      
      System.out.println("mypage_service 댓글등등 : "+ list);
      return list;
   }

   public int logCount(String user_nickname) {
      Connection result = getConnection();
      
      Mypage_Dao mpDao = new Mypage_Dao();
      
      int num = mpDao.logCount(result, user_nickname);
      
      if ( num > 0 ) {
         commit(result);
      } else {
         rollback(result);
      }
      
      close(result);
      
      return num;
   }

   public int logUpdate(int rindex) {
      Connection result = getConnection();
      
      Mypage_Dao mpDao = new Mypage_Dao();
      
      int num = mpDao.logUpdate(result, rindex);
      
      if ( num == 1 ) {
         commit(result);
      } else {
         rollback(result);
      }
      
      close(result);
      
      return num;
   }

}