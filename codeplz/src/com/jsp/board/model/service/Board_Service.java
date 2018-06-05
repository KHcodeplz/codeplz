package com.jsp.board.model.service;

import static com.common.connect.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.jsp.board.model.dao.Board_Dao;
import com.jsp.board.model.vo.Board;

public class Board_Service {

	public int insertBoard(Board board) {
		Connection con = getConnection();
		
		Board_Dao bdao = new Board_Dao();
		int result = bdao.insertBoard(con, board);
		
		if(result == 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	public int getBoardIndex(String writer, String title) {
		Connection result =getConnection();
		
		int index = new Board_Dao().getBoardIndex(result, writer, title);
		
		close(result);
		
		return index;
	}

	public ArrayList<Board> selectList(int currentPage, int limit ,int CategoryIndex){
		Connection result = getConnection();
		
		ArrayList<Board> list = new Board_Dao().selectList(result, currentPage , limit, CategoryIndex);
		
		System.out.println(list);
		close(result);
		return list;
		
	}

	public int getListCount() {
		Connection result =getConnection();
		
		int listCount = new Board_Dao().getListCount(result);
		
		close(result);
		
		return listCount;
	}

	public Board boardDetail(int index) {
		Connection result = getConnection();
		Board b = new Board_Dao().boardDetail(result, index);
		System.out.println("dao b:"+b);
		int num  = 0;
		// Detail 에서 호출 했을 경우를 탐색
		StackTraceElement[] a = new Throwable().getStackTrace();
		
		if(b !=null && a[1].getClassName().contains("Detail")){
			num = new Board_Dao().updateHits(result , index);
		}
		if(num > 0) commit(result);
		else rollback(result);
		
		return b;
	}
	
	public int deleteBoard(int index) {
		Connection result = getConnection();
		int num= new Board_Dao().deleteBoard(result,index);
		
		if(num== 1) 
			commit(result);
		else rollback(result);
		

		return num;
	}
}
