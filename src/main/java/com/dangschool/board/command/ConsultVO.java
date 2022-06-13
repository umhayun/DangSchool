package com.dangschool.board.command;

import java.sql.Timestamp;

public class ConsultVO {

	private int num;			//������-�Խ��� ����������
	private String phone1;		//1,2��ȭ��ȣ (member�� �ִ°�� �ҷ� ����)
	private String phone2;		
	private String name;		//�� ����
	private String email; 		//�̸���
	private String consult_type;//�������
	private String visit_date;	//�湮�� �湮 ��¥
	private String dog_Kind;	//������
	private String vaccine;		//���-��������
	private String c_content;	//q&a ���α�
	private Timestamp c_regdate;//q&a �ۼ���¥
	
	//������, ������
	  private int next;		//������ ��ȣ
	  private int last;		//������ ��ȣ
	  private String nextname; //������ �̸�
	  private String lastname;	//������ �̸�
	
	public ConsultVO() {
	}

	public ConsultVO(String phone1, String phone2, String name, String email, String consult_type, String visit_date,
			String dog_Kind, String vaccine, String c_pw, String c_content, Timestamp c_regdate) {
		super();
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.name = name;
		this.email = email;
		this.consult_type = consult_type;
		this.visit_date = visit_date;
		this.dog_Kind = dog_Kind;
		this.vaccine = vaccine;
		this.c_content = c_content;
		this.c_regdate = c_regdate;
	}
	

	//getter, setter
	public int getNum() {
		return num;
	}

	public String getPhone1() {
		return phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getConsult_type() {
		return consult_type;
	}

	public String getVisit_date() {
		return visit_date;
	}

	public String getDog_Kind() {
		return dog_Kind;
	}

	public String getVaccine() {
		return vaccine;
	}

	public String getC_content() {
		return c_content;
	}

	public Timestamp getC_regdate() {
		return c_regdate;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setConsult_type(String consult_type) {
		this.consult_type = consult_type;
	}

	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}

	public void setDog_Kind(String dog_Kind) {
		this.dog_Kind = dog_Kind;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public void setC_regdate(Timestamp c_regdate) {
		this.c_regdate = c_regdate;
	}
	
	
	
	//������, ������

		public int getNext() {
			return next;
		}

		public int getLast() {
			return last;
		}

		public String getNextname() {
			return nextname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setNext(int next) {
			this.next = next;
		}

		public void setLast(int last) {
			this.last = last;
		}

		public void setNextname(String nextname) {
			this.nextname = nextname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
}
