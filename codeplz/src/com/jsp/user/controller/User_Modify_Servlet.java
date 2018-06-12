package com.jsp.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.secure.EncryptUtil;
import com.jsp.user.model.service.User_Service;
import com.jsp.user.model.vo.User_Vo;

@WebServlet("/usermodify.cp")
public class User_Modify_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public User_Modify_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "views/common/errorPage.jsp";
		HttpSession session = request.getSession();
		User_Vo user = (User_Vo) session.getAttribute("user");
		
		if (user != null) {
			String name_for_modify = request.getParameter("name_for_modify");
			String password_for_modify = request.getParameter("password_for_modify");
			
			System.out.println("수정을 위한 패스워드 : " + password_for_modify);
			
			if (name_for_modify == null) name_for_modify = user.getUser_name();
			if (!password_for_modify.equals("")) password_for_modify = new EncryptUtil().encrypt(password_for_modify);
			
			user.setUser_name(name_for_modify);
			user.setUser_password(password_for_modify);
			
			User_Service us = new User_Service();
			
			if (us.modify(user)) {
				PrintWriter out = response.getWriter();
				
				out.print(true);
				out.flush();
				out.close();
			} else {
				session.setAttribute("errorMsg", "변경 실패!");
				response.sendRedirect(page);
			}
		} else {
			session.setAttribute("errorMsg", "올바른 접근이 아닙니다.");
			response.sendRedirect(page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}