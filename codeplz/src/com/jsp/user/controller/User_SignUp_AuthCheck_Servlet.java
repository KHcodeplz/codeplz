package com.jsp.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/signup_auth_check.cp")
public class User_SignUp_AuthCheck_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public User_SignUp_AuthCheck_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String auth_key = (String) session.getAttribute("auth_key");
		String input = (String) request.getParameter("input");
		boolean result = auth_key.equals(input);
//		System.out.println("현재 auth 키 : " + auth_key);
//		System.out.println("auth 체크 서블릿에서 전달받은 값 : " + input);
//		System.out.println("같은 지 ? " + result);
		
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		gson.toJson(result, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
