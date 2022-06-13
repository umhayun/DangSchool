package com.dangschool.q_board.service;

import java.util.ArrayList;

import com.dangschool.board.command.QnaVO;
import com.dangschool.util.Criteria;

public interface QnaService {

		//qna ���
		public void register(QnaVO vo);
		
		//qna ���
		public ArrayList<QnaVO> getlist(Criteria cri);
		
		//�˻��� qna ���
		public ArrayList<QnaVO> listsearch(Criteria cri); 
		
		//qna �󼼺���
		public QnaVO getContent(int num);
		
		//qna ����
		public void update(QnaVO vo);
		
		//qna ����
		public void delete(int num);
		
		//qna ��ü��
		public int getTotal(Criteria cri);
		
		//��ȸ��
		public void hit(int num); 
		
		//������, ������
		public QnaVO movePage(int num);
	
	
	
}
