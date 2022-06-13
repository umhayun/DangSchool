package com.dangschool.util;


public class Criteria {
	
	//페이징
	private int pageNum;	//페이지 번호
	private int count;		//보여줄 페이지 수
	private int imgcount;
	//검색 추가
	private String searchType="";
	private String keyword="";

	public Criteria() {
		this.pageNum = 1;	//시작되는 페이지 번호
		this.count = 10;	//보여줄 페이지 개수
		this.imgcount=9;	
		this.searchType = null;
		this.keyword = null;
			
	}
	
	public Criteria(int pageNum, int count) {
		super();
		this.pageNum = pageNum;
		this.count = count;
	}

	public int getPageStart() {
		return ((pageNum-1)*count)+1;
	}

	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}
	public int getCount_oracle() {
		return (pageNum*count);
	}
	public int getImg_oracle() {
		return (pageNum*imgcount);
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	//검색을 위한 getter, setter
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public int getImgcount() {
		return imgcount;
	}

	public void setImgcount(int imgcount) {
		this.imgcount = imgcount;
	}
	
	
	
	
}
