package com.jsp.user.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.secure.EncryptUtil;
import com.jsp.user.model.service.User_Service;
import com.jsp.user.model.vo.User_Vo;

@WebServlet("/signup.cp")
public class User_SignUp_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public User_SignUp_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		String page = "errorPage.jsp";
		EncryptUtil ec = new EncryptUtil();
		
		String user_id = request.getParameter("user_id");
		String user_password = ec.encrypt(request.getParameter("user_password"));
		String user_nickname = request.getParameter("user_nickname");
		String user_name = request.getParameter("user_name");
		String user_authentication_key = ec.encrypt(user_id);
		
		User_Vo user = new User_Vo(user_id, user_password, user_nickname, user_name, user_authentication_key);
		
//		System.out.println("회원가입 서블렛 전달 받은 값 : " + user);
		
		User_Service uService = new User_Service();
		
		if (uService.singUp(user) != 0) {
			page = "index.jsp";
		} else {
			session.setAttribute("errorMsg", "알 수 없는 오류로 인한 회원 가입 실패!");
		}
		
		response.sendRedirect(page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}