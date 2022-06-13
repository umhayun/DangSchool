package com.dangschool.board.command;

import java.sql.Timestamp;

public class BoardVO {

	private int num;
	private String name;
	private String title;
	private String content;
	private Timestamp regdate;
	
	//다음글, 이전글
	  private int next;		//다음글 번호
	  private int last;		//이전글 번호
	  private String nexttitle; //다음글 제목
	  private String lasttitle;	//이전글 제목
	 
	public BoardVO() {
	}
 
	public BoardVO(String name, String title, String content, Timestamp regdate) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
	
	//이전글, 다음글

	public int getNext() {
		return next;
	}

	public int getLast() {
		return last;
	}

	public String getNexttitle() {
		return nexttitle;
	}

	public String getLasttitle() {
		return lasttitle;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public void setNexttitle(String nexttitle) {
		this.nexttitle = nexttitle;
	}

	public void setLasttitle(String lasttitle) {
		this.lasttitle = lasttitle;
	}
	
	
}
