package com.jsp.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.board.model.service.Board_Service;
import com.jsp.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Board_Update_Servlet
 */
@WebServlet("/board_update.cp")
public class Board_Update_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board_Update_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath=getServletContext().getRealPath("/upload");
		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int category = Integer.parseInt(mrequest.getParameter("category"));
		String title = mrequest.getParameter("title");
		String tag = mrequest.getParameter("tag");
		String content = mrequest.getParameter("content");
		String file = mrequest.getFilesystemName("file");
		
		HttpSession session = request.getSession();
		Board board = (Board)session.getAttribute("board");
		
		if(file == null) {
			file = board.getBoard_file();
		}

		board.setBoard_category_index(category);
		board.setBoard_title(title);
		board.setBoard_tags(tag);
		board.setBoard_content(content);
		board.setBoard_file(file);
		
		Board_Service service = new Board_Service();
		
		int result = service.updateBoard(board);
		
		if(result == 1) {
			int index = board.getBoard_index();
			
			session.removeAttribute("board");
			
			PrintWriter out = response.getWriter();
			
			out.print(index);
			
			out.flush();
			out.close();
		} else {
			System.out.println("update 실패 !");
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
