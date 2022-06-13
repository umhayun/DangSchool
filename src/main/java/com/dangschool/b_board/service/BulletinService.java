package com.dangschool.b_board.service;

import java.util.ArrayList;

import com.dangschool.board.command.BoardVO;
import com.dangschool.util.Criteria;

public interface BulletinService {
	

	// �Խñ� ���
	public void register(BoardVO vo);
	
	// �Խñ� ��ü ���
	public ArrayList<BoardVO> getList(Criteria cri);
	
	//�˻��� �Խñ� ��ü ���
	public ArrayList<BoardVO> getListsearch(Criteria cri);
	
	// �Խñ� �󼼺���
	public BoardVO getContent(int num);
	
	// �Խñ� ���ε�
	public void update(BoardVO vo);
	
	// �Խñ� ����
	public void delete(int num);
	
	// �Խñ� ��ü ��
	public int getTotal(Criteria cri);
	
	//������, ������
	public BoardVO movePage(int num);
	
	//member
	public BoardVO member(String id);
}