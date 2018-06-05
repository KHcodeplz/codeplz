package com.jsp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.service.Board_Comment_Service;
import com.jsp.board.model.vo.Board_Comment;


/**
 * Servlet implementation class Board_Comment_Update_servlet
 */
@WebServlet("/update_Comment.cp")
public class Board_Comment_Update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board_Comment_Update_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cIndex = Integer.parseInt(request.getParameter("cIndex"));
		int bIndex = Integer.parseInt(request.getParameter("bIndex"));
		String content = request.getParameter("content");
		
		System.out.println(cIndex+","+bIndex+","+content);
		
		Board_Comment bco = new Board_Comment();
		bco.setReply_index(cIndex);
		bco.setReply_content(content);
		
		int num  = new Board_Comment_Service().update_Comment(bco);
		
		String page= "";
		
		if(num>0){
			page = "/board_detail.cp?index="+bIndex;
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
