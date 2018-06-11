package com.jsp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.user.model.vo.User_Vo;

@WebServlet("/admin_check.cp")
public class Admin_Check_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Check_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "errorPage.jsp";
		HttpSession session = request.getSession();
		
		User_Vo user = (User_Vo)session.getAttribute("user");
		String url = (String)request.getParameter("url");
		
		if (user == null || url == null) {
			session.setAttribute("errorMsg", "올바른 접근이 아닙니다.");
		} else if (user.getUser_tier_index() != 9) {
			session.setAttribute("errorMsg", "권한이 없습니다.");
		} else {
			switch(url) {
				case "userControl":
					page = request.getContextPath()+"/admin_user_control.cp";
					break;
				case "adminChat":
					page = request.getContextPath()+"/admin_chat.cp";
					break;
			}
		}
		response.sendRedirect(page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}