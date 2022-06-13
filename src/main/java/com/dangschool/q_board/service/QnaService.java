package com.dangschool.q_board.service;

import java.util.ArrayList;

import com.dangschool.board.command.QnaVO;
import com.dangschool.util.Criteria;

public interface QnaService {

		//qna 등록
		public void register(QnaVO vo);
		
		//qna 목록
		public ArrayList<QnaVO> getlist(Criteria cri);
		
		//검색시 qna 목록
		public ArrayList<QnaVO> listsearch(Criteria cri); 
		
		//qna 상세보기
		public QnaVO getContent(int num);
		
		//qna 수정
		public void update(QnaVO vo);
		
		//qna 삭제
		public void delete(int num);
		
		//qna 전체글
		public int getTotal(Criteria cri);
		
		//조회수
		public void hit(int num); 
		
		//이전글, 다음글
		public QnaVO movePage(int num);
	
	
	
}
