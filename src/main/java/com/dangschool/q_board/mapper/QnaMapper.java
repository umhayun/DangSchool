package com.dangschool.q_board.mapper;

import java.util.ArrayList;

import com.dangschool.board.command.QnaVO;
import com.dangschool.util.Criteria;

public interface QnaMapper {

	//qna 전체목록
	public ArrayList<QnaVO> getList(Criteria cri);
	
	//검색시 qna 목록
	public ArrayList<QnaVO> listsearch(Criteria cri); 
		
	//qna 등록
	public void insertBoard(QnaVO vo);

	//qna 상세보기
	public QnaVO getContent(int num);
	
	//qna 업로드
	public int updateBoard(QnaVO vo);
	
	//qna 삭제
	public void deleteBoard(int num);
		
	//qna 전체 수
	public int getTotal(Criteria cri);
	
	//qna 조회수
	public int hit(int num);
		
	//이전글, 다음글
	public QnaVO movePage(int num);
		
}
