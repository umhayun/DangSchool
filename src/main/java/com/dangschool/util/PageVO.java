package com.dangschool.util;

public class PageVO {
	
	  private int startPage;	//���۵Ǵ� ��ȣ
	  private int endPage;		//������ ����
	  private int total;		//��ü �Խñ� ����
	  
	  private int pageNum;	//������ȸ�ϴ� ������
	  private boolean next;	//����, ���� ��ư Ȱ��ȭ ����
	  private boolean prev;	//���� ��ư Ȱ��ȭ ����
	  private Criteria cri;	//������ ����
	  
	  
	  public PageVO(int total, Criteria cri) {
		  this.total = total;
		  this.cri = cri;
		  this.pageNum = cri.getPageNum();
		  this.endPage = (int)Math.ceil(cri.getPageNum()/(double)10)*10;
		  this.startPage = endPage -9;
		  
		  int realEnd = (int)Math.ceil(this.total/(double)10);	//������ ��ȣ�� ������ ��Ÿ���� ��¥ �� ��ȣ
	  
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