package com.dangschool.activity.command;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

public class ActivityVO {
	int num;
	String title;
	String content;
	String id;
	Timestamp regdate;
	int hit;
	int last;
	int first;
	int fileCnt;
	ArrayList<String> filename;
	@Resource(name="uploadPath")
    String uploadPath;
	public ActivityVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActivityVO(int num, String title, String content, String id, Timestamp regdate, int hit) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.id = id;
		this.regdate = regdate;
		this.hit = hit;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getFileCnt() {
		return fileCnt;
	}
	public void setFileCnt(int fileCnt) {
		this.fileCnt = fileCnt;
	}
	public ArrayList<String> getFilename() {
		return filename;
	}
	public void setFilename(ArrayList<String> filename) {
		this.filename = filename;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	
}
