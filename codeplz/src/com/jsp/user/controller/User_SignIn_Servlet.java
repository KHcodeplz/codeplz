package com.jsp.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jsp.user.model.vo.*;
import com.common.secure.EncryptUtil;
import com.jsp.user.model.service.*;

@WebServlet("/signin.cp")
public class User_SignIn_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public User_SignIn_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		HttpSession session = request.getSession(); // 기존에 있는 세션을 받아옴
		String page = "errorPage.jsp";
		EncryptUtil ec = new EncryptUtil();
		
		User_Vo session_User = (User_Vo)session.getAttribute("user"); // 세션의 유저 정보를 받아옴, 접속중 : not null
		
		System.out.println("session user : " + session_User);
		
		if (session_User != null) { // 접속 중인데도 불구하고 로그인을 수행하려는 경우, 즉 오류 케이스
			session.setAttribute("errorMsg", "중복 로그인 시도가 감지되었습니다.");
		} else {
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			
			user_password = ec.encrypt(user_password);
			
			User_Vo user = new User_Vo(user_id, user_password);
			
			User_Service uService = new User_Service();
			
			if ((user = uService.signIn(user)) != null) {
				session.setAttribute("user", user);
				page = "index.jsp";
			} else {
				session.setAttribute("errorMsg", "접속 실패! 아이디와 패스워드를 확인해주세요.");
			}
		}
		response.sendRedirect(page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
