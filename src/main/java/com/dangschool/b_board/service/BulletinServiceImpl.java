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
	
	//���
		@Override
		public void register(BoardVO vo) {

			mapper.insertBoard(vo);
		}

		//�Խù���ü��� ����
		@Override
		public ArrayList<BoardVO> getList(Criteria cri) {
			
			ArrayList<BoardVO> list = mapper.getList(cri);
			
			return list;
		}
		
		//�˻��� �Խñ� ��ü ���
		@Override
		public ArrayList<BoardVO> getListsearch(Criteria cri) {
			ArrayList<BoardVO> list = mapper.getListsearch(cri);
			return list;
		}

		//�Խñ� �󼼺���
		@Override
		public BoardVO getContent(int num) {
			
			BoardVO vo = mapper.getContent(num);
			
			return vo;
		}

		//�Խñ� ���ε�
		@Override
		public void update(BoardVO vo) {
//			System.out.println("--------- ���� ���� ----------");
//			System.out.println(vo.getNum());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getContent());
//			System.out.println(vo.getRegdate());
			
			mapper.updateBoard(vo);
	 		
		}

		//�Խñ� ����
		@Override
		public void delete(int num) {
			 
			mapper.deleteBoard(num);
			
		}

		//�Խñ� �� ��
		@Override
		public int getTotal(Criteria cri) {

			return mapper.getTotal(cri);
		}
		
		//������, ������
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