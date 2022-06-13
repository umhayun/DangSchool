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
	
	//qna ��ü ��� �ҷ�����
		@RequestMapping("/list")
		public String list(Model model, @ModelAttribute("cri") Criteria cri, HttpSession session) {
			
			//�� �Խù�
			ArrayList<QnaVO> list = service.getlist(cri);
			model.addAttribute("qna_list", list);
			
			//�ѰԽñ� ��
			int total = service.getTotal(cri);
			model.addAttribute("pageMaker", new PageVO(total, cri));
			
			return "qna_board/list";
		}
	
		//�˻�
		@GetMapping("/listsearch")
		public String search(@ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
					
			ArrayList<QnaVO> list = service.listsearch(cri);
					
			if(!list.isEmpty()) {
				//�˻��� Ű���� ���
				model.addAttribute("qna_list",list);
				
				//�� �Խñ� ��
				int total = service.getTotal(cri);
				model.addAttribute("pageMaker", new PageVO(total, cri));
				
				System.out.println("�˻��ÿ� oracle_count �� Ȯ���ϱ�!!!!!"+ cri.getCount_oracle());
				System.out.println("�˻��ÿ� pageStart �� Ȯ��~~"+cri.getPageStart());
				
				return "qna_board/list";
				
			}else {
				model.addAttribute("listcheck", "empty");
				return "qna_board/list";
			}
		}
	
		//�Խñ� ��� ȭ��
		@RequestMapping(value="/register", method=RequestMethod.GET)
		public String register(@ModelAttribute("cri") Criteria cri, HttpSession session) {
			
			return "qna_board/register";
		}
		
		//�Խñ� ��� ó��
		@RequestMapping(value="/register", method=RequestMethod.POST)
		public String register(QnaVO vo) {
			
			service.register(vo); 
			
			return "redirect:/qna_board/list";
		}
		
		
		//�󼼺��� 
		//������+������+��ȸ��
		@RequestMapping("/content")
		public String content(@RequestParam("num") int num, @RequestParam("num") String num2, Model model, @ModelAttribute("cri") Criteria cri
				, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
			
			QnaVO vo = service.getContent(num);
			model.addAttribute("board", vo);
			System.out.println("==================������ ���???? ++++++++++++++++++++++++");
			System.out.println(vo.getId());
			
			//������, ������
			QnaVO vo2 = service.movePage(num);
			model.addAttribute("move", vo2);
			
			System.out.println("++++++++++++++++++++++++ ������ ������++++++++++++++++++++++++++++++++");
			System.out.println(vo2.getNexttitle());
			
			//��ȸ��
			Cookie[] arr = request.getCookies();
			
			boolean bool = true;
			 for(Cookie c : arr) {
				 if(c.getName().contentEquals("hitNum"+num2)) {	//num�� �۹�ȣ/�Խù���ȣ - ��Ű�̸� �Խù�ȣ�� ��Ű���� Ȯ��
					 			//contentEquals ���ڿ� ��ü�� ���� �� ���
					 bool = false;	//false�� Ŭ�������� �ִ�.
					 break;			//������Ű�� ����
					 
				 }
			 }
			//��ȸ�� ������Ʈ + �ߺ� ����
			if(bool) {
				service.hit(num);
				System.out.println("��ȸ�� Ȯ��-----------------------"+vo.getQ_hit());
			}
			//�ߺ� ������ �����ϱ� ���� ��Ű ����(1);
			Cookie hitcoo = new Cookie("hitNum"+num2, num2);	
					hitcoo.setMaxAge(86400);//�ߺ����� 24�ð� ����
			response.addCookie(hitcoo);
			 
			session= request.getSession();
			
			return "qna_board/content";
		}
		
		//���� ȭ��ó��
		@RequestMapping(value="/modify", method = RequestMethod.GET)
		public String update(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {
			
			QnaVO vo = service.getContent(num);
			model.addAttribute("board", vo);
			
			return "qna_board/modify"; 
		}
		
		//��й�ȣ Ȯ�� ȭ��â
		@RequestMapping(value="/pw_check", method = RequestMethod.GET)
		public String showPopup(@RequestParam("num") int num, RedirectAttributes RA, @ModelAttribute("cri") Criteria cri) {
			
			return "qna_board/pw_check"; 
		}
		 
		//��й�ȣ Ȯ�� ó��
		@RequestMapping(value="/pw_check", method = RequestMethod.POST)
		public String pw_check(@RequestParam("num") int num, @RequestParam("q_pw") int q_pw, Model model,
							   @ModelAttribute("cri") Criteria cri) {
			
			System.out.println("��ȣ �Ѱ� �޾Ҵ��� Ȯ��"+num);
		
			QnaVO vo = service.getContent(num);
			System.out.println("��й�ȣ �����Դ��� Ȯ��: "+vo.getQ_pw());
			System.out.println("������ �����Դ��� Ȯ��: "+cri.getPageNum());
			System.out.println("������ ����Ʈ: "+cri.getCount());
			
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
		
		//����ó��
		@RequestMapping(value="/update", method = RequestMethod.POST)
		public String update(QnaVO vo) {
			
			service.update(vo);
			return "redirect:/qna_board/list"; 
		}
		
		//����ó��
		@RequestMapping("/delete")
		public String delete(QnaVO vo, @RequestParam("num") int num) {
			
			service.delete(num);
			return "redirect:/qna_board/list";
		}
		
		
	}