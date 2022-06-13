package com.dangschool.member.service;

import org.apache.ibatis.annotations.Param;

import com.dangschool.member.command.MemberVO;

public interface MemberService {

	public int join(MemberVO vo);		//ȸ������
	public int login(MemberVO vo);		//�α���
	public int checkId(String id);		//���̵� �ߺ�üũ
	public int myPage(String id);		//ȸ����������(����������)
	public MemberVO modify(String id);	//����������
	public int update(MemberVO vo);		//���� ��ư �Ϸ�
	public void changePw(MemberVO vo);	//��й�ȣ ����
	public void delete(MemberVO vo);		//Ż��
}
