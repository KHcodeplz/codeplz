package com.jsp.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.user.model.service.User_Service;
import com.jsp.user.model.vo.User_Vo;

@WebServlet("/dropout.cp")
public class User_DropOut_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public User_DropOut_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "errorPage.jsp";
		HttpSession session = request.getSession();
		
		User_Vo user = (User_Vo)session.getAttribute("user");
		
		if (user == null) {
			session.setAttribute("errorMsg", "올바른 접근이 아닙니다.");
		} else {
			User_Service us = new User_Service();
			if (us.dropOut(user)) {
				
			} else {
				
			}
		}
		
		response.sendRedirect(page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
