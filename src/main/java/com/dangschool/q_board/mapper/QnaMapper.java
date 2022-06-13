package com.dangschool.q_board.mapper;

import java.util.ArrayList;

import com.dangschool.board.command.QnaVO;
import com.dangschool.util.Criteria;

public interface QnaMapper {

	//qna ��ü���
	public ArrayList<QnaVO> getList(Criteria cri);
	
	//�˻��� qna ���
	public ArrayList<QnaVO> listsearch(Criteria cri); 
		
	//qna ���
	public void insertBoard(QnaVO vo);

	//qna �󼼺���
	public QnaVO getContent(int num);
	
	//qna ���ε�
	public int updateBoard(QnaVO vo);
	
	//qna ����
	public void deleteBoard(int num);
		
	//qna ��ü ��
	public int getTotal(Criteria cri);
	
	//qna ��ȸ��
	public int hit(int num);
		
	//������, ������
	public QnaVO movePage(int num);
		
}
