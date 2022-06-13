package com.dangschool.c_board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangschool.board.command.ConsultVO;
import com.dangschool.c_board.mapper.ConsultMapper;
import com.dangschool.util.Criteria;

@Service
public class ConsultServiceImpl implements ConsultService {

	//ConsultMapper -
	@Autowired
	ConsultMapper mapper;
	
	
	//��㿹�� ���
	@Override
	public void register(ConsultVO vo) {
		
		mapper.insertConsult(vo);

	}
	
	//��㿹�� ���
	@Override
	public ArrayList<ConsultVO> readview(Criteria cri) {
		
		ArrayList<ConsultVO> list = mapper.readview(cri);
		
		return list;
	}
	
	//�˻��� ��㿹�� ���
	@Override
	public ArrayList<ConsultVO> listsearch(Criteria cri) {
		ArrayList<ConsultVO> list = mapper.listsearch(cri);
		
		return list;
	}

	//��㿹�� �Խñ� ��
	@Override
	public ConsultVO getContent(int num) {

		ConsultVO vo = mapper.getcontent(num);
		
		return vo;
	}

	//��㿹�� ����
	@Override
	public void delete(int num) {
		
		mapper.delete(num);
	}

	//��㿹�� �Խñ� �� �� 
	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotal(cri);
	}
	
	//������, ������
	@Override
	public ConsultVO movePage(int num) {
			
		return mapper.movePage(num);
	}
	
	//member
	@Override
	public ConsultVO member(String id) {
		
		return mapper.member(id);
	}

}
