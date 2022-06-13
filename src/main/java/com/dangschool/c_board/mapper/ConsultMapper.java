package com.dangschool.c_board.mapper;

import java.util.ArrayList;

import com.dangschool.board.command.ConsultVO;
import com.dangschool.util.Criteria;

public interface ConsultMapper {
	
	//��㿹�� ���
	public void insertConsult(ConsultVO vo);
	
	//��㿹�� ��ü ���
	public ArrayList<ConsultVO> readview(Criteria cri);
	
	//�˻��� ��㿹�� ���
	public ArrayList<ConsultVO> listsearch(Criteria cri); 
	
	//��㿹�� ��
	public ConsultVO getcontent(int num);
	
	//��㿹�� ����
	public void delete(int num);
	
	//��㿹�� ��ü �Խü�
	public int getTotal(Criteria cri);
	
	//������, ������
	public ConsultVO movePage(int num);
	
	//member
	public ConsultVO member(String id);

}
