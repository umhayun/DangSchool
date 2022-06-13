package com.dangschool.reservation.service;

import java.util.ArrayList;

import com.dangschool.reservation.command.ReservationVO;

public interface ReservationService {
	public void reservation(ReservationVO vo); 
	public ArrayList<ReservationVO> select(String id);
	public void check(int reservno);
	public ArrayList<ReservationVO> manage();
}
