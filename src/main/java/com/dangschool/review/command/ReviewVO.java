package com.dangschool.review.command;

import java.sql.Timestamp;

public class ReviewVO {

	private int num;
	private String id;
	private String r_title;
	private String r_content;
	private String r_kind;
	private int r_weight;
	private String r_size;
	private int star;
	
	public ReviewVO() {}

	public ReviewVO(int num, String id, String r_title, String r_content, String r_kind, int r_weight, String r_size,
			int star) {
		super();
		this.num = num;
		this.id = id;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_kind = r_kind;
		this.r_weight = r_weight;
		this.r_size = r_size;
		this.star = star;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_kind() {
		return r_kind;
	}

	public void setR_kind(String r_kind) {
		this.r_kind = r_kind;
	}

	public int getR_weight() {
		return r_weight;
	}

	public void setR_weight(int r_weight) {
		this.r_weight = r_weight;
	}

	public String getR_size() {
		return r_size;
	}

	public void setR_size(String r_size) {
		this.r_size = r_size;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	
	
}
