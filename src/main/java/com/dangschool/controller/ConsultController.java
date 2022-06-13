package com.dangschool.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dangschool.board.command.ConsultVO;
import com.dangschool.c_board.service.ConsultService;
import com.dangschool.util.Criteria;
import com.dangschool.util.PageVO;

@Controller
@RequestMapping("/consult_rs/")
public class ConsultController {

	//ConsultService - 
	@Autowired
	private ConsultService service;
	
	//상담예약 등록 화면처리
	@RequestMapping(value="/c_register", method=RequestMethod.GET)
	public String c_register(@ModelAttribute("cri") Criteria cri, HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		ConsultVO vo = service.member(id);
		
		model.addAttribute("member", vo);
		
		return "consult_rs/c_register";
		}
	
	//게시글 등록 요청 처리
	@RequestMapping(value="/c_register", method=RequestMethod.POST)
	public String register(ConsultVO vo) {
		System.out.println("등록처리");
		System.out.println(vo.getC_content());
			
		service.register(vo);		
	
		return "consult_rs/c_register";
	}
	
	//상담예약 목록
	@RequestMapping("/c_list")
	public String list(Model model, @ModelAttribute("cri") Criteria cri, HttpSession session, HttpServletRequest request) {
		
		ArrayList<ConsultVO> list = service.readview(cri);
		model.addAttribute("consult_list",list);
		
		int total = service.getTotal(cri);
		model.addAttribute("pageMaker", new PageVO(total, cri));
		
		return "consult_rs/c_list";
	}
	
	//검색
	@GetMapping("/listsearch")
	public String search(@ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
	
		ArrayList<ConsultVO> list = service.listsearch(cri);
				
		//isEmpty() - 자바SE1.6버전이상, 인스턴스생성하였으나, list에는 아무 것도 없는 상태
		if(!list.isEmpty()) {
			//검색한 키워드 출력
			model.addAttribute("consult_list",list);
			
			//검색한 총 게시글 수
			int total = service.getTotal(cri);
			model.addAttribute("pageMaker", new PageVO(total, cri));
			
			System.out.println("검색시에 oracle_count 값 확인하기!!!!!"+ cri.getCount_oracle());
			System.out.println("검색시에 pageStart 값 확인~~"+cri.getPageStart());
			
			return "consult_rs/c_list";
		}else {
			model.addAttribute("listcheck", "empty");
					
			return "consult_rs/c_list";
		}
	}
	
	
	//상담예약 상세
	// + 이전글, 다음글
	@RequestMapping("/c_content")	
	public String content(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {
		
		ConsultVO vo = service.getContent(num);
		model.addAttribute("consult", vo);
		
		//이전글, 다음글
		ConsultVO vo2 = service.movePage(num);
		
		System.out.println("============확인합니다==============");
		System.out.println("이전번호 : "+vo2.getLast());
		System.out.println("다음번호 : "+vo2.getNext());
		System.out.println("이전글 이름: "+vo2.getLastname());
		System.out.println("다음글 이름: "+vo2.getNextname());
		
		model.addAttribute("move", vo2 );
		
		return "consult_rs/c_content";
	}
	
	//상담예약 삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		
		service.delete(num); 
		
		return "redirect:/consult_rs/c_list";
	}
	
	
}
