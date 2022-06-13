package com.dangschool.member.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangschool.member.mapper.MemberMapper;
import com.dangschool.member.command.MemberVO;

@Service("memberService")
public class MemberServieImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int join(MemberVO vo) {
		int result = mapper.join(vo);
		return result;
	}
	
	@Override
	public int login(MemberVO vo) {
		int result = mapper.login(vo);
		return result;
	}
	
	@Override
	public int checkId(String id) {
		int result = mapper.checkId(id);
		return result;
	}
	
	@Override
	public int myPage(String id) {
		int result = mapper.myPage(id);
		return result;
	}
	
	@Override
	public MemberVO modify(String id) {
		MemberVO vo = mapper.modify(id);
		return vo;
    }
	
	@Override
	public int update(MemberVO vo) {
		int result = mapper.update(vo);
		return result;
	}
	

	@Override
	public void changePw(MemberVO vo) {
		mapper.changePw(vo);	
	}
	
	@Override
	public void delete(MemberVO vo) {
		mapper.delete(vo);
	}

}
