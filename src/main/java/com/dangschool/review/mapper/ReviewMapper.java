package com.dangschool.review.mapper;

import java.util.ArrayList;

import com.dangschool.review.command.ReviewVO;
import com.dangschool.util.Criteria;

public interface ReviewMapper {

	public void insertReview(ReviewVO vo);		//게시물 등록
	public ReviewVO getContent(int num);		//게시물 상세보기 가져오기
	public void deleteReview(int num);			//게시물 삭제
	
	//페이징 쿼리
	//매개변수로 Criteria 클래스를 받음(페이징 기준의 대한 설정 클래스)
	public ArrayList<ReviewVO> pagingList(Criteria cri);
	
	//전체 게시물의 수
	public int getTotal();
	
}
