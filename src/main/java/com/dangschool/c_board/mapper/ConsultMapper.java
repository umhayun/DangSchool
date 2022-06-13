package com.dangschool.c_board.mapper;

import java.util.ArrayList;

import com.dangschool.board.command.ConsultVO;
import com.dangschool.util.Criteria;

public interface ConsultMapper {
	
	//상담예약 등록
	public void insertConsult(ConsultVO vo);
	
	//상담예약 전체 목록
	public ArrayList<ConsultVO> readview(Criteria cri);
	
	//검색시 상담예약 목록
	public ArrayList<ConsultVO> listsearch(Criteria cri); 
	
	//상담예약 상세
	public ConsultVO getcontent(int num);
	
	//상담예약 삭제
	public void delete(int num);
	
	//상담예약 전체 게시수
	public int getTotal(Criteria cri);
	
	//이전글, 다음글
	public ConsultVO movePage(int num);
	
	//member
	public ConsultVO member(String id);

}
