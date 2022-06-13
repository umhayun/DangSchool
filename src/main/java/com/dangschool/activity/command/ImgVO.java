package com.dangschool.activity.command;

import java.sql.Timestamp;

public class ImgVO {
	int idx;
	int num;
	String org_file_name;
	String save_file_name;
	String file_size;
	Timestamp update_date;
	String crea_id;
	String del_chk;
	Timestamp crea_date;
	public ImgVO() {
		// TODO Auto-generated constructor stub
	}
	public ImgVO(int idx, int num, String org_file_name, String save_file_name, String file_size, Timestamp update_date,
			String crea_id, String del_chk, Timestamp crea_date) {
		super();
		this.idx = idx;
		this.num = num;
		this.org_file_name = org_file_name;
		this.save_file_name = save_file_name;
		this.file_size = file_size;
		this.update_date = update_date;
		this.crea_id = crea_id;
		this.del_chk = del_chk;
		this.crea_date = crea_date;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOrg_file_name() {
		return org_file_name;
	}
	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}
	public String getSave_file_name() {
		return save_file_name;
	}
	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	public String getCrea_id() {
		return crea_id;
	}
	public void setCrea_id(String crea_id) {
		this.crea_id = crea_id;
	}
	public String getDel_chk() {
		return del_chk;
	}
	public void setDel_chk(String del_chk) {
		this.del_chk = del_chk;
	}
	public Timestamp getCrea_date() {
		return crea_date;
	}
	public void setCrea_date(Timestamp crea_date) {
		this.crea_date = crea_date;
	}

	
	
}
