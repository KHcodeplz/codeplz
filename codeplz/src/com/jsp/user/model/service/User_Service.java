package com.jsp.user.model.service;

import java.sql.*;
import com.jsp.user.model.dao.*;
import com.jsp.user.model.vo.*;

import static com.common.connect.JDBCTemplate.*;

public class User_Service {
	
	public boolean singUp(User_Vo user) {
		Connection con = getConnection();
		User_Dao uDao = new User_Dao();
		
		boolean result = uDao.signUp(con, user);
		
		if (result) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	public User_Vo signIn(User_Vo user) {
		Connection con = getConnection();
		User_Dao uDao = new User_Dao();
		
		User_Vo result = uDao.signIn(con, user);
		
		close(con);
		
		return result;
	}
	
	public boolean dropOut(User_Vo user) {
		Connection con = getConnection();
		User_Dao uDao = new User_Dao();
		
		boolean result = uDao.dropOut(con, user);
		
		if (result) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public boolean id_Check(String user_id) {
		Connection con = getConnection();
		User_Dao uDao = new User_Dao();
		
		boolean result = uDao.id_Check(con, user_id);
		
		close(con);
		
		return result;
	}

	public boolean nickname_Check(String user_nickname) {
		Connection con = getConnection();
		User_Dao uDao = new User_Dao();
		
		boolean result = uDao.nickname_Check(con, user_nickname);
		
		close(con);
		
		return result;
	}

	public boolean password_Check(User_Vo user) {
		Connection con = getConnection();
		User_Dao uDao = new User_Dao();
		
		boolean result = uDao.passowrd_Check(con, user);
		
		close(con);
		
		return result;
	}

	public boolean modify(User_Vo user) {
		Connection con = getConnection();
		User_Dao uDao = new User_Dao();
		
		boolean result = uDao.modify(con, user);
		
		if (result) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
}