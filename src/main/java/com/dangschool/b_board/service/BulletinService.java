package com.dangschool.b_board.service;

import java.util.ArrayList;

import com.dangschool.board.command.BoardVO;
import com.dangschool.util.Criteria;

public interface BulletinService {
	

	// 게시글 등록
	public void register(BoardVO vo);
	
	// 게시글 전체 목록
	public ArrayList<BoardVO> getList(Criteria cri);
	
	//검색시 게시글 전체 목록
	public ArrayList<BoardVO> getListsearch(Criteria cri);
	
	// 게시글 상세보기
	public BoardVO getContent(int num);
	
	// 게시글 업로드
	public void update(BoardVO vo);
	
	// 게시글 삭제
	public void delete(int num);
	
	// 게시글 전체 수
	public int getTotal(Criteria cri);
	
	//이전글, 다음글
	public BoardVO movePage(int num);
	
	//member
	public BoardVO member(String id);
}