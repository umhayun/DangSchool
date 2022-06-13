package com.dangschool.c_board.service;

import java.util.ArrayList;

import com.dangschool.board.command.ConsultVO;
import com.dangschool.util.Criteria;

public interface ConsultService {

	//��㿹�� ���
	public void register(ConsultVO vo);
	
	//��㿹�� ���
	public ArrayList<ConsultVO> readview(Criteria cri);
	
	//�˻��� ��㿹�� ���
	public ArrayList<ConsultVO> listsearch(Criteria cri); 
	
	//��㿹�� �󼼺���
	public ConsultVO getContent(int num);
	
	//��㿹�� ����
	public void delete(int num);
	
	//��㿹�� ��ü �Խñ� �� 
	public int getTotal(Criteria cri);
	
	//������, ������
	public ConsultVO movePage(int num);
	
	//member
	public ConsultVO member(String id);
	
}
