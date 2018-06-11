package com.jsp.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jsp.user.model.service.User_Service;

@WebServlet("/signup_nickname_Check.cp")
public class User_SignUp_NicknameCheck_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public User_SignUp_NicknameCheck_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean nickname_Check = false;
		response.setContentType("application/json; charset=UTF-8");
		String user_nickname = request.getParameter("user_nickname");
		
		User_Service us = new User_Service();
		
		nickname_Check = us.nickname_Check(user_nickname);
		
		PrintWriter out = response.getWriter();
		
		Gson gs = new Gson();
		
		gs.toJson(nickname_Check,out);
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
