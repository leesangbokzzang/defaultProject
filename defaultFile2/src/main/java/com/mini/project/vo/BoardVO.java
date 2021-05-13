package com.mini.project.vo;

public class BoardVO {
	private int idx;
	private String user_id;
	private String title;
	private String cont;
	private String regdate;
	
	public BoardVO(){}
	
	public BoardVO(int idx, String user_id, String title, String cont, String regdate) {
		this.idx = idx;
		this.user_id = user_id;
		this.title = title;
		this.cont = cont;
		this.regdate = regdate;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", user_id=" + user_id + ", title=" + title + ", cont=" + cont + ", regdate="
				+ regdate + "]";
	}
	
}
