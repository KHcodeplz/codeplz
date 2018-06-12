package com.jsp.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.mypage.model.service.Mypage_Service;
import com.jsp.mypage.model.vo.Mypage;
import com.jsp.user.model.vo.User_Vo;

@WebServlet("/mypage.cp")
public class Mypage_Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public Mypage_Servlet() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ArrayList<Mypage> mList = null;
      int index = Integer.parseInt(request.getParameter("index"));
      int logCount = 0;
      HttpSession session = request.getSession();
      User_Vo user_nick = (User_Vo)session.getAttribute("user");
//      String user_nickname = request.getParameter("user");
      
//      System.out.println("마이페이지 유저 닉네임 : "+ user_nickname);
      System.out.println("마이페이지 목록 인덱스 : "+ index);
      
      mList = new Mypage_Service().myPage(user_nick.getUser_nickname(), index);
      logCount = new Mypage_Service().logCount(user_nick.getUser_nickname());
      
      // System.out.println("logCount : "+ logCount);
      
      System.out.println("mypage list : "+ mList);
      
      String page = "";
      
      if ( user_nick.getUser_nickname() == null ) {
         page = "views/common/errorPage.jsp";
         request.setAttribute("errorMsg", "로그인을 해주세요");
      }

      if ( mList != null ) {
         page = "views/mypage/mypage.jsp";
         request.setAttribute("mList", mList);
         request.setAttribute("index", index);
         request.setAttribute("logCount", logCount);
      } else {
         page = "views/common/errorPage.jsp";
         request.setAttribute("errorMsg", "로그인을 해주세요");
      }
      
      RequestDispatcher views = request.getRequestDispatcher(page);
      
      views.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}