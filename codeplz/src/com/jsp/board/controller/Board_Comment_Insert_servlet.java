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
 * Servlet implementation class Board_Comment_Insert_servlet
 */
@WebServlet("/Comment_Insert.cp")
public class Board_Comment_Insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board_Comment_Insert_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String writer = request.getParameter("writer");
		int bIndex = Integer.parseInt(request.getParameter("bIndex"));
		String content = request.getParameter("replyContent");
		
		Board_Comment bco = new Board_Comment();
		bco.setBoard_index(bIndex);
		bco.setReply_writer(writer);
		bco.setReply_content(content);
		
		int result = new Board_Comment_Service().insert_Comment(bco);
		
		if(result >0){
			response.sendRedirect(request.getContextPath()+"/board_detail.cp?index="+bIndex);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
