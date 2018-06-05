package com.jsp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.service.Board_Service;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/delete.cp")
public class Board_Delete_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Board_Delete_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dd");
		int index = Integer.parseInt(request.getParameter("BIndex"));
		int num =new Board_Service().deleteBoard(index);
		System.out.println(index);
		
		String page="";
		if(num>0){
			
			page = "selectList.cp";
		}else{
			
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
