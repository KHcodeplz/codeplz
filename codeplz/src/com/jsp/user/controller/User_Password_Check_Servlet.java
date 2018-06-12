package com.jsp.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.secure.EncryptUtil;
import com.jsp.user.model.service.User_Service;
import com.jsp.user.model.vo.User_Vo;

@WebServlet("/user_password_check.cp")
public class User_Password_Check_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public User_Password_Check_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "views/common/errorPage.jsp";
		String input = (String) request.getParameter("password_for_check");
						
		HttpSession session = request.getSession();
		User_Vo user = (User_Vo) session.getAttribute("user");
				
		User_Service us = new User_Service();
		
		if (input == null || user == null) {
			session.setAttribute("errorMsg", "올바른 접근이 아닙니다.");
		} else {
			input = new EncryptUtil().encrypt(input);
			user.setUser_password(input);
			
			if (us.password_Check(user)) {
				session.setAttribute("modify_Check", true);
				page = "views/mypage/userModify.jsp";
			} else {
				session.setAttribute("errorMsg", "입력한 비밀번호가 사용자의 비밀번호와 같지 않습니다.");
			}
		}
		response.sendRedirect(page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}