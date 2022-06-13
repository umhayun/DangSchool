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
	
	//�Խñ� ���
	@Override
	public void register(QnaVO vo) {
		mapper.insertBoard(vo);
	}

	//�Խñ� �ҷ�����
	@Override
	public ArrayList<QnaVO> getlist(Criteria cri) {

		ArrayList<QnaVO> list = mapper.getList(cri);
		
		return list;
	}
	
	//�˻��� �Խñ� �ҷ�����
	@Override
	public ArrayList<QnaVO> listsearch(Criteria cri) {

		ArrayList<QnaVO> list = mapper.listsearch(cri);
		
		return list;
	}

	//�Խñ� ��
	@Override
	public QnaVO getContent(int num) {
		
		QnaVO vo = mapper.getContent(num);
		
		return vo;
	}

	//�Խñ� ���ε�
	@Override
	public void update(QnaVO vo) {

		mapper.updateBoard(vo);
	}

	//�Խñ� ����
	@Override
	public void delete(int num) {

		mapper.deleteBoard(num);
	}

	//��ü �Խñ� ��
	@Override
	public int getTotal(Criteria cri) {

		return mapper.getTotal(cri);
	}

	//��ȸ��
	@Override
	public void hit(int num) {

		mapper.hit(num);
	}

	//������, ������
	@Override
	public QnaVO movePage(int num) {
		
		return mapper.movePage(num);
	}

}
