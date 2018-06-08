package com.jsp.user.model.vo;

public class User_Vo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private String user_password;
	private String user_nickname;
	private String user_name;
	private int user_tier_index;
	private boolean user_is_leaved;
	private String user_authentication_key;
	
	public User_Vo() {}

	public User_Vo(String user_id, String user_password) { // using signIn servlet
		this.user_id = user_id;
		this.user_password = user_password;
	}
	
	public User_Vo(String user_id, String user_password, String user_nickname, String user_name, String user_authentication_key) { // using signUp servlet
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_nickname = user_nickname;
		this.user_name = user_name;
		this.user_is_leaved = false;
		this.user_authentication_key = user_authentication_key;
	}

	public User_Vo(String user_id, String user_password, String user_nickname, String user_name, int user_tier_index,
			boolean user_is_certified, boolean user_is_leaved) { // if signIn successed
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_nickname = user_nickname;
		this.user_name = user_name;
		this.user_tier_index = user_tier_index;
		this.user_is_leaved = user_is_leaved;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_tier_index() {
		return user_tier_index;
	}

	public void setUser_tier_index(int user_tier_index) {
		this.user_tier_index = user_tier_index;
	}


	public boolean isUser_is_leaved() {
		return user_is_leaved;
	}

	public void setUser_is_leaved(boolean user_is_leaved) {
		this.user_is_leaved = user_is_leaved;
	}

	public String getUser_authentication_key() {
		return user_authentication_key;
	}

	@Override
	public String toString() {
		return "User_Vo [user_id=" + user_id + ", user_password=" + user_password + ", user_nickname=" + user_nickname
				+ ", user_name=" + user_name + ", user_tier_index=" + user_tier_index + ", user_is_leaved="
				+ user_is_leaved + ", user_authentication_key=" + user_authentication_key + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_authentication_key == null) ? 0 : user_authentication_key.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + (user_is_leaved ? 1231 : 1237);
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_nickname == null) ? 0 : user_nickname.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + user_tier_index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User_Vo other = (User_Vo) obj;
		if (user_authentication_key == null) {
			if (other.user_authentication_key != null)
				return false;
		} else if (!user_authentication_key.equals(other.user_authentication_key))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_is_leaved != other.user_is_leaved)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_nickname == null) {
			if (other.user_nickname != null)
				return false;
		} else if (!user_nickname.equals(other.user_nickname))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_tier_index != other.user_tier_index)
			return false;
		return true;
	}
}