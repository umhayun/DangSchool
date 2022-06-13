package com.dangschool.b_board.mapper;

import java.util.ArrayList;

import com.dangschool.board.command.BoardVO;
import com.dangschool.util.Criteria;

public interface BoardMapper {
	
	//�Խñ� ��ü���
	public ArrayList<BoardVO> getList(Criteria cri);
	
	//�˻� �Խñ� ��ü���
	public ArrayList<BoardVO> getListsearch(Criteria cri);
	
	//�Խñ� ���
	public void insertBoard(BoardVO vo);

	//�Խñ� �󼼺���
	public BoardVO getContent(int num);
	
	//�Խñ� ���ε�
	public int updateBoard(BoardVO vo);
	
	//�Խñ� ����
	public void deleteBoard(int num);
	
	//�Խñ� ��ü ��
	public int getTotal(Criteria cri);
	
	//������, ������
	public BoardVO movePage(int num);
	
	//member
	public BoardVO member(String id);
}