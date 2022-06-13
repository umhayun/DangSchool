package com.dangschool.board.command;

import java.sql.Timestamp;

public class QnaVO {

	private int num;
	private int q_hit;
	private String id;
	private int q_pw;
	private String q_title;
	private String q_content;
	private Timestamp q_regdate;
	private int bulletinNo;	//공지사항글일경우 상단 고정 
	
	
	//다음글, 이전글
	  private int next;		//다음글 번호
	  private int last;		//이전글 번호
	  private String nexttitle; //다음글 제목
	  private String lasttitle;	//이전글 제목

	public QnaVO() {
	}

	public QnaVO(int num, int q_hit, String id, int q_pw, String q_title, String q_content, Timestamp q_regdate,
			int bulletionNo) {
		super();
		this.num = num;
		this.q_hit = q_hit;
		this.id = id;
		this.q_pw = q_pw;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_regdate = q_regdate;
		this.bulletinNo = bulletionNo;
	}

	//setter, getter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getQ_hit() {
		return q_hit;
	}

	public void setQ_hit(int q_hit) {
		this.q_hit = q_hit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQ_pw() {
		return q_pw;
	}

	public void setQ_pw(int q_pw) {
		this.q_pw = q_pw;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public Timestamp getQ_regdate() {
		return q_regdate;
	}

	public void setQ_regdate(Timestamp q_regdate) {
		this.q_regdate = q_regdate;
	}

	public int getBulletinNo() {
		return bulletinNo;
	}

	public void setBulletinNo(int bulletinNo) {
		this.bulletinNo = bulletinNo;
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
