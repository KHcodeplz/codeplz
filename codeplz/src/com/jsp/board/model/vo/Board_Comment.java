package com.jsp.board.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Board_Comment implements Serializable{
	private static final long serialVersionUID = 7L;
	
	
	private  int board_index;
	private  int reply_index;
	private  String reply_content;
	private  String reply_writer;
	private  Date reply_inserted_date;
	private  Date reply_modified_date;
	private  int reply_is_deleted;
	
	public Board_Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board_Comment(int board_index, int reply_index, String reply_content, String reply_writer,
			Date reply_inserted_date, Date reply_modified_date, int reply_is_deleted) {
		super();
		this.board_index = board_index;
		this.reply_index = reply_index;
		this.reply_content = reply_content;
		this.reply_writer = reply_writer;
		this.reply_inserted_date = reply_inserted_date;
		this.reply_modified_date = reply_modified_date;
		this.reply_is_deleted = reply_is_deleted;
	}

	public int getBoard_index() {
		return board_index;
	}

	public void setBoard_index(int board_index) {
		this.board_index = board_index;
	}

	public int getReply_index() {
		return reply_index;
	}

	public void setReply_index(int reply_index) {
		this.reply_index = reply_index;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getReply_writer() {
		return reply_writer;
	}

	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}

	public Date getReply_inserted_date() {
		return reply_inserted_date;
	}

	public void setReply_inserted_date(Date reply_inserted_date) {
		this.reply_inserted_date = reply_inserted_date;
	}

	public Date getReply_modified_date() {
		return reply_modified_date;
	}

	public void setReply_modified_date(Date reply_modified_date) {
		this.reply_modified_date = reply_modified_date;
	}

	public int getReply_is_deleted() {
		return reply_is_deleted;
	}

	public void setReply_is_deleted(int reply_is_deleted) {
		this.reply_is_deleted = reply_is_deleted;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_index;
		result = prime * result + ((reply_content == null) ? 0 : reply_content.hashCode());
		result = prime * result + reply_index;
		result = prime * result + ((reply_inserted_date == null) ? 0 : reply_inserted_date.hashCode());
		result = prime * result + reply_is_deleted;
		result = prime * result + ((reply_modified_date == null) ? 0 : reply_modified_date.hashCode());
		result = prime * result + ((reply_writer == null) ? 0 : reply_writer.hashCode());
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
		Board_Comment other = (Board_Comment) obj;
		if (board_index != other.board_index)
			return false;
		if (reply_content == null) {
			if (other.reply_content != null)
				return false;
		} else if (!reply_content.equals(other.reply_content))
			return false;
		if (reply_index != other.reply_index)
			return false;
		if (reply_inserted_date == null) {
			if (other.reply_inserted_date != null)
				return false;
		} else if (!reply_inserted_date.equals(other.reply_inserted_date))
			return false;
		if (reply_is_deleted != other.reply_is_deleted)
			return false;
		if (reply_modified_date == null) {
			if (other.reply_modified_date != null)
				return false;
		} else if (!reply_modified_date.equals(other.reply_modified_date))
			return false;
		if (reply_writer == null) {
			if (other.reply_writer != null)
				return false;
		} else if (!reply_writer.equals(other.reply_writer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board_Comment [board_index=" + board_index + ", reply_index=" + reply_index + ", reply_content="
				+ reply_content + ", reply_writer=" + reply_writer + ", reply_inserted_date=" + reply_inserted_date
				+ ", reply_modified_date=" + reply_modified_date + ", reply_is_deleted=" + reply_is_deleted + "]";
	}
	
	
	
	
	

	
	

}
