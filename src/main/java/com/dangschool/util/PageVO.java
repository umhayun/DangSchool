package com.dangschool.util;

public class PageVO {
	
	  private int startPage;	//시작되는 번호
	  private int endPage;		//끝나는 번로
	  private int total;		//전체 게시글 개수
	  
	  private int pageNum;	//현재조회하는 페이지
	  private boolean next;	//다음, 이전 버튼 활성화 여부
	  private boolean prev;	//이전 버튼 활성화 여부
	  private Criteria cri;	//페이지 기준
	  
	  
	  public PageVO(int total, Criteria cri) {
		  this.total = total;
		  this.cri = cri;
		  this.pageNum = cri.getPageNum();
		  this.endPage = (int)Math.ceil(cri.getPageNum()/(double)10)*10;
		  this.startPage = endPage -9;
		  
		  int realEnd = (int)Math.ceil(this.total/(double)10);	//페이지 번호가 적을때 나타나는 진짜 끝 번호
	  
		  if(this.endPage > realEnd) {
			  this.endPage = realEnd;
		  }
		  
		  this.prev = this.startPage > 1;
		  this.next = realEnd > this.endPage;
		  
	  	}
	  
	//getter, setter
			public int getStartPage() {
				return startPage;
			}

			public void setStartPage(int startPage) {
				this.startPage = startPage;
			}

			public int getEndPage() {
				return endPage;
			}

			public void setEndPage(int endPage) {
				this.endPage = endPage;
			}

			public int getTotal() {
				return total;
			}
			
			public void setTotal(int total) {
				this.total = total;
			}

			public int getPageNum() {
				return pageNum;
			}

			public void setPageNum(int pageNum) {
				this.pageNum = pageNum;
			}
		
			public boolean isNext() {
				return next;
			}
			public void setNext(boolean next) {
				this.next = next;
			}

			public boolean isPrev() {
				return prev;
			}

			public void setPrev(boolean prev) {
				this.prev = prev;
			}

			public Criteria getCri() {
				return cri;
			}

			public void setCri(Criteria cri) {
				this.cri = cri;
			}
				
				
				
			}