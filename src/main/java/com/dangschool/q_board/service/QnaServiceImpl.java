package com.dangschool.q_board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangschool.board.command.QnaVO;
import com.dangschool.q_board.mapper.QnaMapper;
import com.dangschool.util.Criteria;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaMapper mapper;
	
	//게시글 등록
	@Override
	public void register(QnaVO vo) {
		mapper.insertBoard(vo);
	}

	//게시글 불러오기
	@Override
	public ArrayList<QnaVO> getlist(Criteria cri) {

		ArrayList<QnaVO> list = mapper.getList(cri);
		
		return list;
	}
	
	//검색시 게시글 불러오기
	@Override
	public ArrayList<QnaVO> listsearch(Criteria cri) {

		ArrayList<QnaVO> list = mapper.listsearch(cri);
		
		return list;
	}

	//게시글 상세
	@Override
	public QnaVO getContent(int num) {
		
		QnaVO vo = mapper.getContent(num);
		
		return vo;
	}

	//게시글 업로드
	@Override
	public void update(QnaVO vo) {

		mapper.updateBoard(vo);
	}

	//게시글 삭제
	@Override
	public void delete(int num) {

		mapper.deleteBoard(num);
	}

	//전체 게시글 수
	@Override
	public int getTotal(Criteria cri) {

		return mapper.getTotal(cri);
	}

	//조회수
	@Override
	public void hit(int num) {

		mapper.hit(num);
	}

	//다음글, 이전글
	@Override
	public QnaVO movePage(int num) {
		
		return mapper.movePage(num);
	}

}
