package com.jsp.user.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jsp.user.model.service.User_Service;

@WebServlet("/signup_id_Check.cp")
public class User_SignUp_IdCheck_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public User_SignUp_IdCheck_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean id_Check = false;
		response.setContentType("application/json; charset=UTF-8");
		String user_id = request.getParameter("user_id");
		
		User_Service us = new User_Service();
		
		id_Check = us.id_Check(user_id);
		
		PrintWriter out = response.getWriter();
		
		Gson gs = new Gson();
		
		gs.toJson(id_Check,out);
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
