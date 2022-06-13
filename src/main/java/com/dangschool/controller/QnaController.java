package com.dangschool.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dangschool.board.command.QnaVO;
import com.dangschool.q_board.service.QnaService;
import com.dangschool.util.Criteria;
import com.dangschool.util.PageVO;

@Controller
@RequestMapping("/qna_board/")
public class QnaController {

	@Autowired
	private QnaService service;
	
	//qna 전체 목록 불러오기
		@RequestMapping("/list")
		public String list(Model model, @ModelAttribute("cri") Criteria cri, HttpSession session) {
			
			//총 게시물
			ArrayList<QnaVO> list = service.getlist(cri);
			model.addAttribute("qna_list", list);
			
			//총게시글 수
			int total = service.getTotal(cri);
			model.addAttribute("pageMaker", new PageVO(total, cri));
			
			return "qna_board/list";
		}
	
		//검색
		@GetMapping("/listsearch")
		public String search(@ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
					
			ArrayList<QnaVO> list = service.listsearch(cri);
					
			if(!list.isEmpty()) {
				//검색한 키워드 출력
				model.addAttribute("qna_list",list);
				
				//총 게시글 수
				int total = service.getTotal(cri);
				model.addAttribute("pageMaker", new PageVO(total, cri));
				
				System.out.println("검색시에 oracle_count 값 확인하기!!!!!"+ cri.getCount_oracle());
				System.out.println("검색시에 pageStart 값 확인~~"+cri.getPageStart());
				
				return "qna_board/list";
				
			}else {
				model.addAttribute("listcheck", "empty");
				return "qna_board/list";
			}
		}
	
		//게시글 등록 화면
		@RequestMapping(value="/register", method=RequestMethod.GET)
		public String register(@ModelAttribute("cri") Criteria cri, HttpSession session) {
			
			return "qna_board/register";
		}
		
		//게시글 등록 처리
		@RequestMapping(value="/register", method=RequestMethod.POST)
		public String register(QnaVO vo) {
			
			service.register(vo); 
			
			return "redirect:/qna_board/list";
		}
		
		
		//상세보기 
		//이전글+다음글+조회수
		@RequestMapping("/content")
		public String content(@RequestParam("num") int num, @RequestParam("num") String num2, Model model, @ModelAttribute("cri") Criteria cri
				, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
			
			QnaVO vo = service.getContent(num);
			model.addAttribute("board", vo);
			System.out.println("==================오류가 어디서???? ++++++++++++++++++++++++");
			System.out.println(vo.getId());
			
			//이전글, 다음글
			QnaVO vo2 = service.movePage(num);
			model.addAttribute("move", vo2);
			
			System.out.println("++++++++++++++++++++++++ 이전글 다음글++++++++++++++++++++++++++++++++");
			System.out.println(vo2.getNexttitle());
			
			//조회수
			Cookie[] arr = request.getCookies();
			
			boolean bool = true;
			 for(Cookie c : arr) {
				 if(c.getName().contentEquals("hitNum"+num2)) {	//num은 글번호/게시물번호 - 쿠키이름 게시번호의 쿠키인지 확인
					 			//contentEquals 문자열 자체를 비교할 떄 사용
					 bool = false;	//false면 클릭한적이 있다.
					 break;			//증가시키지 않음
					 
				 }
			 }
			//조회수 업데이트 + 중복 방지
			if(bool) {
				service.hit(num);
				System.out.println("조회수 확인-----------------------"+vo.getQ_hit());
			}
			//중복 증가를 방지하기 위한 쿠키 생성(1);
			Cookie hitcoo = new Cookie("hitNum"+num2, num2);	
					hitcoo.setMaxAge(86400);//중복방지 24시간 설정
			response.addCookie(hitcoo);
			 
			session= request.getSession();
			
			return "qna_board/content";
		}
		
		//수정 화면처리
		@RequestMapping(value="/modify", method = RequestMethod.GET)
		public String update(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {
			
			QnaVO vo = service.getContent(num);
			model.addAttribute("board", vo);
			
			return "qna_board/modify"; 
		}
		
		//비밀번호 확인 화면창
		@RequestMapping(value="/pw_check", method = RequestMethod.GET)
		public String showPopup(@RequestParam("num") int num, RedirectAttributes RA, @ModelAttribute("cri") Criteria cri) {
			
			return "qna_board/pw_check"; 
		}
		 
		//비밀번호 확인 처리
		@RequestMapping(value="/pw_check", method = RequestMethod.POST)
		public String pw_check(@RequestParam("num") int num, @RequestParam("q_pw") int q_pw, Model model,
							   @ModelAttribute("cri") Criteria cri) {
			
			System.out.println("번호 넘겨 받았는지 확인"+num);
		
			QnaVO vo = service.getContent(num);
			System.out.println("비밀번호 가져왔는지 확인: "+vo.getQ_pw());
			System.out.println("페이지 가져왔는지 확인: "+cri.getPageNum());
			System.out.println("페이지 가운트: "+cri.getCount());
			
			if(vo.getQ_pw() == q_pw) { 
				model.addAttribute("num", num);
				return "qna_board/pw_ok"; 
			}else {
				return "qna_board/pw_check";  
			} 
		}
		
		@RequestMapping("pw_ok")
		public String pw_ok(@RequestParam("num") int num, RedirectAttributes RA, @ModelAttribute("cri") Criteria cri) {
			
			return "pw_ok";
		}
		
		//수정처리
		@RequestMapping(value="/update", method = RequestMethod.POST)
		public String update(QnaVO vo) {
			
			service.update(vo);
			return "redirect:/qna_board/list"; 
		}
		
		//삭제처리
		@RequestMapping("/delete")
		public String delete(QnaVO vo, @RequestParam("num") int num) {
			
			service.delete(num);
			return "redirect:/qna_board/list";
		}
		
		
	}