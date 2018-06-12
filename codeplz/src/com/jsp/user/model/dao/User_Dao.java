package com.jsp.user.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.jsp.user.model.vo.*;
import static com.common.connect.JDBCTemplate.*;

public class User_Dao {
	
	private Properties prop = new Properties();
	
	public User_Dao() {
		String propURL = User_Dao.class.getResource("/com/config/user/user-sql.properties").getPath();
				
		try {
			prop.load(new FileReader(propURL));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean signUp(Connection con, User_Vo user) {
		PreparedStatement pstmt = null;
		
		boolean result = false;

		try {
			String sql = prop.getProperty("signUp");
			
			/* 
			 * sql Index in this Query
			 * 
			 * COL_USER_ID : 1
			 * COL_USER_PASSWORD : 2
			 * COL_USER_NICKNAME : 3
			 * COL_USER_NAME : 4
			 * COL_USER_AUTHENTICATION_KEY : 5
			 * 
			 * */
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_password());
			pstmt.setString(3, user.getUser_nickname());
			pstmt.setString(4, user.getUser_name());
			pstmt.setString(5, user.getUser_authentication_key());
			
			if (pstmt.executeUpdate() > 0) result = true;
//			
//			System.out.println("sqlresult = " + result);
//			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public User_Vo signIn(Connection con, User_Vo user) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		User_Vo result = null;
		
		try {
			String sql = prop.getProperty("signIn");
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_password());
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = new User_Vo();
				
				/* 
				 * ResultSet Index in this Query
				 * 
				 * COL_USER_ID : 1
				 * COL_USER_NICKNAME : 2
				 * COL_USER_NAME : 3
				 * COL_USER_TIER_INDEX : 4
				 * COL_USER_IS_LEAVED : 5
				 * 
				 * */
				
				result.setUser_id(rset.getString(1));
				result.setUser_nickname(rset.getString(2));
				result.setUser_name(rset.getString(3));
				result.setUser_tier_index(rset.getInt(4));
				result.setUser_is_leaved(rset.getInt(5) == 1 ? true : false);
				
//				System.out.println("signin dao result : " + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public boolean id_Check(Connection con, String user_id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		boolean result = false;
		
		String sql = prop.getProperty("id_Check");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				int temp = rset.getInt(1);
				
				if (temp != 0) {
					result = true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public boolean nickname_Check(Connection con, String user_nickname) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		boolean result = false;
		
		String sql = prop.getProperty("nickname_Check");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_nickname);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				int temp = rset.getInt(1);
				
				if (temp != 0) {
					result = true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public boolean dropOut(Connection con, User_Vo user) {	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql = prop.getProperty("dropOut");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			
			if (pstmt.executeUpdate() > 0) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public boolean passowrd_Check(Connection con, User_Vo user) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		boolean result = false;
		
		String sql = prop.getProperty("password_Check");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_password());
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				int temp = rset.getInt(1);
				
				if (temp != 0) {
					result = true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public boolean modify(Connection con, User_Vo user) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql = "";
		
		System.out.println("User Dao modify password : " + user.getUser_password());
		
		try {
			if (user.getUser_password().equals("")) {
				sql = prop.getProperty("modify_without_password");
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, user.getUser_name());
				pstmt.setString(2, user.getUser_id());
			} else {
				sql = prop.getProperty("modify");
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, user.getUser_name());
				pstmt.setString(2, user.getUser_password());
				pstmt.setString(3, user.getUser_id());
			}
			
			if (pstmt.executeUpdate() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}