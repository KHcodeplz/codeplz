package com.jsp.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.service.Board_Comment_Service;
import com.jsp.board.model.service.Board_Service;
import com.jsp.board.model.vo.Board;
import com.jsp.board.model.vo.Board_Comment;

@WebServlet("/board_detail.cp")
public class Board_Detail_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Board_Detail_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("index"));
		System.out.println(index); 
			
		Board b = new Board_Service().boardDetail(index);
		ArrayList<Board_Comment> cList = new Board_Comment_Service().selectList(index);
		
		System.out.println(b);
		String page= "";
		if(b !=null){
			page="views/board/boardDetail.jsp";
			request.setAttribute("b", b);
			request.setAttribute("cList", cList);
		}else{
			
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
