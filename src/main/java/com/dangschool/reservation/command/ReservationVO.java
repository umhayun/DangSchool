package com.dangschool.reservation.command;

public class ReservationVO {
	private int reservno;
	private String id;
	private String name;
	private String phone1;
	private String phone2;
	private String dogname;
	private String doggender;
	private String kind;
	private String d_size;
	private String neuter;
	private String service;
	private String reservdate;
	private String pay;
	private String sum;
	private String complete;
	/**
	 * 
	 */
	public ReservationVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 * @param phone1
	 * @param phone2
	 * @param dogname
	 * @param doggender
	 * @param kind
	 * @param d_size
	 * @param neuter
	 * @param service
	 * @param reservdate
	 * @param pay
	 * @param sum
	 */
	public ReservationVO(String id, String name, String phone1, String phone2, String dogname, String doggender,
			String kind, String d_size, String neuter, String service, String reservdate, String pay, String sum) {
		super();
		this.id = id;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.dogname = dogname;
		this.doggender = doggender;
		this.kind = kind;
		this.d_size = d_size;
		this.neuter = neuter;
		this.service = service;
		this.reservdate = reservdate;
		this.pay = pay;
		this.sum = sum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getDogname() {
		return dogname;
	}
	public void setDogname(String dogname) {
		this.dogname = dogname;
	}
	public String getDoggender() {
		return doggender;
	}
	public void setDoggender(String doggender) {
		this.doggender = doggender;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getD_size() {
		return d_size;
	}
	public void setD_size(String d_size) {
		this.d_size = d_size;
	}
	public String getNeuter() {
		return neuter;
	}
	public void setNeuter(String neuter) {
		this.neuter = neuter;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getReservdate() {
		return reservdate;
	}
	public void setReservdate(String reservdate) {
		this.reservdate = reservdate;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public int getReservno() {
		return reservno;
	}
	public void setReservno(int reservno) {
		this.reservno = reservno;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	
}
