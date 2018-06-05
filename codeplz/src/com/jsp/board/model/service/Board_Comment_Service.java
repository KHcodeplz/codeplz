package com.jsp.board.model.service;

import com.jsp.board.model.dao.Board_Comment_Dao;
import com.jsp.board.model.vo.Board_Comment;
import static com.common.connect.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;


public class Board_Comment_Service {

	public ArrayList<Board_Comment> selectList(int index) {
		Connection result  = getConnection();
		Board_Comment_Dao bcDao =  new Board_Comment_Dao();
		
		ArrayList<Board_Comment> cList = bcDao.selectList(result,index);
		
		close(result);
		return cList;
	}
	public int insert_Comment(Board_Comment bco) {
		Connection result = getConnection();
		Board_Comment_Dao bcDao = new Board_Comment_Dao();
		
		int num = bcDao.insert_Comment(result , bco);
		
		if(num>0) commit(result);
		else rollback(result);
		
		close(result);
				
		return num;
	}
	public int update_Comment(Board_Comment bco) {
		Connection result = getConnection();
	  
		Board_Comment_Dao bcDao = new Board_Comment_Dao();
		
		int num = bcDao.update_Comment(result,bco);
		
		if(num >0) commit(result);
		else rollback(result);
		
		close(result);
		
		return num;
	}
	
	public int delete_Comment(int cIndex) {
		Connection result = getConnection();
		System.out.println(cIndex);
		Board_Comment_Dao bcDao = new Board_Comment_Dao();
		
		int num = bcDao.delete_Comment(result,cIndex);	
		
		System.out.println("삭제 커맨트:"+num);
		if(num >0) commit(result);
		else rollback(result);
		
		close(result);
		return num;
	}





}
