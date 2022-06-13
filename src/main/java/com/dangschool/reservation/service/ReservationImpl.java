package com.dangschool.reservation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangschool.reservation.command.ReservationVO;
import com.dangschool.reservation.mapper.ReservationMapper;
@Service
public class ReservationImpl implements ReservationService {
	@Autowired
	ReservationMapper mapper;
	@Override
	public void reservation(ReservationVO vo) {
		mapper.reservation(vo);
		// TODO Auto-generated method stub
		
	}@Override
	public ArrayList<ReservationVO> select(String id) {
		ArrayList<ReservationVO> list=mapper.select(id);
		return list;
	}
	@Override
	public void check(int reservno) {
		mapper.check(reservno);
	}
 @Override
public ArrayList<ReservationVO> manage() {
	 ArrayList<ReservationVO> list=mapper.manage();
	return list;
}
}
