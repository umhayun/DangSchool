package com.dangschool.review.service;

import java.util.ArrayList;

import com.dangschool.review.command.ReviewVO;
import com.dangschool.util.Criteria;

public interface ReviewService {

	public ArrayList<ReviewVO> getList(Criteria cri);	//페이징 처리 리스트 가져오기
	public int getTotal();					//전체 게시물 수
	
	public void register(ReviewVO vo);		//게시판 등록 
	public ReviewVO getContent(int num);	//게시물 상세보기(반환유형 생각)
	public void delete(int num);			//게시물 삭제
}
