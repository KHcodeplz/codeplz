package com.jsp.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.vo.Board;
import com.jsp.mypage.model.service.Mypage_Service;
import com.jsp.user.model.vo.User_Vo;



@WebServlet("/mypage.cp")
public class Mypage_Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public Mypage_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ArrayList<Board> list = null;
      
      String user_nickname = request.getParameter("user");
      System.out.println("서비스 유저 닉네임 : "+user_nickname);
      list = new Mypage_Service().myPost(user_nickname);
      
      System.out.println("mypage list : "+ list);
      
      String page = "";
      

      if ( list != null )
      {
         page = "views/mypage/mypage.jsp";
         request.setAttribute("list", list);
      }
      else
      {
         page = "views/common/errorPage.jsp";
         request.setAttribute("errorMsg",
               "로그인을 해주세요");
      }
      
      RequestDispatcher views = request.getRequestDispatcher(page);
      
      views.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}