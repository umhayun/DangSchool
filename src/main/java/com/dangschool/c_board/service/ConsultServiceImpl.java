package com.dangschool.c_board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangschool.board.command.ConsultVO;
import com.dangschool.c_board.mapper.ConsultMapper;
import com.dangschool.util.Criteria;

@Service
public class ConsultServiceImpl implements ConsultService {

	//ConsultMapper -
	@Autowired
	ConsultMapper mapper;
	
	
	//상담예약 등록
	@Override
	public void register(ConsultVO vo) {
		
		mapper.insertConsult(vo);

	}
	
	//상담예약 목록
	@Override
	public ArrayList<ConsultVO> readview(Criteria cri) {
		
		ArrayList<ConsultVO> list = mapper.readview(cri);
		
		return list;
	}
	
	//검색시 상담예약 목록
	@Override
	public ArrayList<ConsultVO> listsearch(Criteria cri) {
		ArrayList<ConsultVO> list = mapper.listsearch(cri);
		
		return list;
	}

	//상담예약 게시글 상세
	@Override
	public ConsultVO getContent(int num) {

		ConsultVO vo = mapper.getcontent(num);
		
		return vo;
	}

	//상담예약 삭제
	@Override
	public void delete(int num) {
		
		mapper.delete(num);
	}

	//상담예약 게시글 총 수 
	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotal(cri);
	}
	
	//이전글, 다음글
	@Override
	public ConsultVO movePage(int num) {
			
		return mapper.movePage(num);
	}
	
	//member
	@Override
	public ConsultVO member(String id) {
		
		return mapper.member(id);
	}

}
