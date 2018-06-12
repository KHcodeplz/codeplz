package com.jsp.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jsp.mypage.model.service.Mypage_Service;
import com.jsp.user.model.vo.User_Vo;

@WebServlet("/alarm.cp")
public class Mypage_Alarm_Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public Mypage_Alarm_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      RequestDispatcher view = null;
      int logCount = 0;
      
      User_Vo user = null;
      
      if ( session.getAttribute("user") != null ) {
         user = (User_Vo)session.getAttribute("user");
      }
      

      System.out.println("세션 사용자 닉네임 : "+ user);
      
      
      logCount = new Mypage_Service().logCount(user.getUser_nickname());
      
      System.out.println("logCount : "+ logCount);
      
      
      
      response.setContentType("application/json; charset=UTF-8");
      
      JSONObject logObj = new JSONObject();
      JSONArray log = new JSONArray();
      
      log.add(logCount);
      
      if ( user.getUser_nickname() != null ) {
         session.setAttribute("logCount", log);
         response.getWriter().print(log.toJSONString());
      } else {
         view = request.getRequestDispatcher("views/common/errorPage.jsp");
         request.setAttribute("errorMsg",
               "로그인을 해주세요");
         view.forward(request, response);
      }
      
      
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}