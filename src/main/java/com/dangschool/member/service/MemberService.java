package com.dangschool.member.service;

import org.apache.ibatis.annotations.Param;

import com.dangschool.member.command.MemberVO;

public interface MemberService {

	public int join(MemberVO vo);		//회원가입
	public int login(MemberVO vo);		//로그인
	public int checkId(String id);		//아이디 중복체크
	public int myPage(String id);		//회원정보보기(마이페이지)
	public MemberVO modify(String id);	//수정페이지
	public int update(MemberVO vo);		//수정 버튼 완료
	public void changePw(MemberVO vo);	//비밀번호 변경
	public void delete(MemberVO vo);		//탈퇴
}
