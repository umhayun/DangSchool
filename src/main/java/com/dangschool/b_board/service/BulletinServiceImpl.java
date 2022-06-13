package com.dangschool.b_board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangschool.b_board.mapper.BoardMapper;
import com.dangschool.board.command.BoardVO;
import com.dangschool.util.Criteria;

@Service
public class BulletinServiceImpl implements BulletinService {

	@Autowired
	public BoardMapper mapper;
	
	//등록
		@Override
		public void register(BoardVO vo) {

			mapper.insertBoard(vo);
		}

		//게시물전체목록 보기
		@Override
		public ArrayList<BoardVO> getList(Criteria cri) {
			
			ArrayList<BoardVO> list = mapper.getList(cri);
			
			return list;
		}
		
		//검색시 게시글 전체 목록
		@Override
		public ArrayList<BoardVO> getListsearch(Criteria cri) {
			ArrayList<BoardVO> list = mapper.getListsearch(cri);
			return list;
		}

		//게시글 상세보기
		@Override
		public BoardVO getContent(int num) {
			
			BoardVO vo = mapper.getContent(num);
			
			return vo;
		}

		//게시글 업로드
		@Override
		public void update(BoardVO vo) {
//			System.out.println("--------- 서비스 계층 ----------");
//			System.out.println(vo.getNum());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getContent());
//			System.out.println(vo.getRegdate());
			
			mapper.updateBoard(vo);
	 		
		}

		//게시글 삭제
		@Override
		public void delete(int num) {
			 
			mapper.deleteBoard(num);
			
		}

		//게시글 총 수
		@Override
		public int getTotal(Criteria cri) {

			return mapper.getTotal(cri);
		}
		
		//이전글, 다음글
		@Override
		public BoardVO movePage(int num) {
			
			return mapper.movePage(num);
		}
		
		//member
		@Override
		public BoardVO member(String id) {
			
			BoardVO vo = mapper.member(id);
			
			return vo;
		}

	}