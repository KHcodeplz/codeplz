package com.jsp.mypage.model.vo;

import java.io.Serializable;
import java.util.*;


public class Mypage implements Serializable {
	private static final long serialVersionUID = 10L;
	
	private int board_index;
	private String board_category_name;
	private int board_category_index;
	private String board_tags;
	private String board_title;
	private String board_content;
	private String board_file;
	private int board_hits;
	private String board_writer;
	private Date board_inserted_date;
	private Date board_modified_date;
	private int board_is_deleted;
	private int board_elapsed_date;
	private  int reply_index;
	private  String reply_content;
	private  String reply_writer;
	private  Date reply_inserted_date;
	private  Date reply_modified_date;
	private  int reply_is_deleted;
	
	public Mypage() { super(); }
	
	public int getBoard_index() {
		return board_index;
	}
	public void setBoard_index(int board_index) {
		this.board_index = board_index;
	}
	public String getBoard_category_name() {
		return board_category_name;
	}
	public void setBoard_category_name(String board_category_name) {
		this.board_category_name = board_category_name;
	}
	public int getBoard_category_index() {
		return board_category_index;
	}
	public void setBoard_category_index(int board_category_index) {
		this.board_category_index = board_category_index;
	}
	public String getBoard_tags() {
		return board_tags;
	}
	public void setBoard_tags(String board_tags) {
		this.board_tags = board_tags;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_file() {
		return board_file;
	}
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	public int getBoard_hits() {
		return board_hits;
	}
	public void setBoard_hits(int board_hits) {
		this.board_hits = board_hits;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Date getBoard_inserted_date() {
		return board_inserted_date;
	}
	public void setBoard_inserted_date(Date board_inserted_date) {
		this.board_inserted_date = board_inserted_date;
	}
	public Date getBoard_modified_date() {
		return board_modified_date;
	}
	public void setBoard_modified_date(Date board_modified_date) {
		this.board_modified_date = board_modified_date;
	}
	public int getBoard_is_deleted() {
		return board_is_deleted;
	}
	public void setBoard_is_deleted(int board_is_deleted) {
		this.board_is_deleted = board_is_deleted;
	}
	public int getBoard_elapsed_date() {
		return board_elapsed_date;
	}
	public void setBoard_elapsed_date(int board_elapsed_date) {
		this.board_elapsed_date = board_elapsed_date;
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
	

	public Mypage(int board_index, String board_category_name, int board_category_index, String board_tags,
			String board_title, String board_content, String board_file, int board_hits, String board_writer,
			Date board_inserted_date, Date board_modified_date, int board_is_deleted, int board_elapsed_date,
			int reply_index, String reply_content, String reply_writer, Date reply_inserted_date,
			Date reply_modified_date, int reply_is_deleted) {
		super();
		this.board_index = board_index;
		this.board_category_name = board_category_name;
		this.board_category_index = board_category_index;
		this.board_tags = board_tags;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_file = board_file;
		this.board_hits = board_hits;
		this.board_writer = board_writer;
		this.board_inserted_date = board_inserted_date;
		this.board_modified_date = board_modified_date;
		this.board_is_deleted = board_is_deleted;
		this.board_elapsed_date = board_elapsed_date;
		this.reply_index = reply_index;
		this.reply_content = reply_content;
		this.reply_writer = reply_writer;
		this.reply_inserted_date = reply_inserted_date;
		this.reply_modified_date = reply_modified_date;
		this.reply_is_deleted = reply_is_deleted;
	}
	@Override
	public String toString() {
		return "Mypage [board_index=" + board_index + ", board_category_name=" + board_category_name
				+ ", board_category_index=" + board_category_index + ", board_tags=" + board_tags + ", board_title="
				+ board_title + ", board_content=" + board_content + ", board_file=" + board_file + ", board_hits="
				+ board_hits + ", board_writer=" + board_writer + ", board_inserted_date=" + board_inserted_date
				+ ", board_modified_date=" + board_modified_date + ", board_is_deleted=" + board_is_deleted
				+ ", board_elapsed_date=" + board_elapsed_date + ", reply_index=" + reply_index + ", reply_content="
				+ reply_content + ", reply_writer=" + reply_writer + ", reply_inserted_date=" + reply_inserted_date
				+ ", reply_modified_date=" + reply_modified_date + ", reply_is_deleted=" + reply_is_deleted + "]";
	}
	
	
	
}
