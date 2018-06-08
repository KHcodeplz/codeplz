package com.jsp.mypage.model.service;
import static com.common.connect.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.jsp.mypage.model.dao.Mypage_Dao;
import com.jsp.mypage.model.vo.Mypage;



public class Mypage_Service {

	public ArrayList<Mypage> myPage(String user_nickname, int index) {
		Connection result = getConnection();
		ArrayList<Mypage> list = null;
		
		if ( index == 0 ) {	
			list = new Mypage_Dao().myPost(result, user_nickname);
		} else if ( index == 1 ) {
			list = new Mypage_Dao().myReply(result, user_nickname);
		} else if ( index == 2 ) {
			list = new Mypage_Dao().myPostReply(result, user_nickname);
		}
		
		close(result);
		
		System.out.println("mypage_service : "+ list);
		return list;
	}



}
