package com.dangschool.b_board.mapper;

import java.util.ArrayList;

import com.dangschool.board.command.BoardVO;
import com.dangschool.util.Criteria;

public interface BoardMapper {
	
	//게시글 전체목록
	public ArrayList<BoardVO> getList(Criteria cri);
	
	//검색 게시글 전체목록
	public ArrayList<BoardVO> getListsearch(Criteria cri);
	
	//게시글 등록
	public void insertBoard(BoardVO vo);

	//게시글 상세보기
	public BoardVO getContent(int num);
	
	//게시글 업로드
	public int updateBoard(BoardVO vo);
	
	//게시글 삭제
	public void deleteBoard(int num);
	
	//게시글 전체 수
	public int getTotal(Criteria cri);
	
	//이전글, 다음글
	public BoardVO movePage(int num);
	
	//member
	public BoardVO member(String id);
}