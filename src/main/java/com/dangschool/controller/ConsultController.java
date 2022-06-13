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
	
	//��㿹�� ��� ȭ��ó��
	@RequestMapping(value="/c_register", method=RequestMethod.GET)
	public String c_register(@ModelAttribute("cri") Criteria cri, HttpSession session,Model model) {
		
		String id = (String)session.getAttribute("user_id");
		ConsultVO vo = service.member(id);
		
		model.addAttribute("member", vo);
		
		return "consult_rs/c_register";
		}
	
	//�Խñ� ��� ��û ó��
	@RequestMapping(value="/c_register", method=RequestMethod.POST)
	public String register(ConsultVO vo) {
		System.out.println("���ó��");
		System.out.println(vo.getC_content());
			
		service.register(vo);		
	
		return "consult_rs/c_register";
	}
	
	//��㿹�� ���
	@RequestMapping("/c_list")
	public String list(Model model, @ModelAttribute("cri") Criteria cri, HttpSession session, HttpServletRequest request) {
		
		ArrayList<ConsultVO> list = service.readview(cri);
		model.addAttribute("consult_list",list);
		
		int total = service.getTotal(cri);
		model.addAttribute("pageMaker", new PageVO(total, cri));
		
		return "consult_rs/c_list";
	}
	
	//�˻�
	@GetMapping("/listsearch")
	public String search(@ModelAttribute("cri") Criteria cri, Model model, HttpSession session) {
	
		ArrayList<ConsultVO> list = service.listsearch(cri);
				
		//isEmpty() - �ڹ�SE1.6�����̻�, �ν��Ͻ������Ͽ�����, list���� �ƹ� �͵� ���� ����
		if(!list.isEmpty()) {
			//�˻��� Ű���� ���
			model.addAttribute("consult_list",list);
			
			//�˻��� �� �Խñ� ��
			int total = service.getTotal(cri);
			model.addAttribute("pageMaker", new PageVO(total, cri));
			
			System.out.println("�˻��ÿ� oracle_count �� Ȯ���ϱ�!!!!!"+ cri.getCount_oracle());
			System.out.println("�˻��ÿ� pageStart �� Ȯ��~~"+cri.getPageStart());
			
			return "consult_rs/c_list";
		}else {
			model.addAttribute("listcheck", "empty");
					
			return "consult_rs/c_list";
		}
	}
	
	
	//��㿹�� ��
	// + ������, ������
	@RequestMapping("/c_content")	
	public String content(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {
		
		ConsultVO vo = service.getContent(num);
		model.addAttribute("consult", vo);
		
		//������, ������
		ConsultVO vo2 = service.movePage(num);
		
		System.out.println("============Ȯ���մϴ�==============");
		System.out.println("������ȣ : "+vo2.getLast());
		System.out.println("������ȣ : "+vo2.getNext());
		System.out.println("������ �̸�: "+vo2.getLastname());
		System.out.println("������ �̸�: "+vo2.getNextname());
		
		model.addAttribute("move", vo2 );
		
		return "consult_rs/c_content";
	}
	
	//��㿹�� ����
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		
		service.delete(num); 
		
		return "redirect:/consult_rs/c_list";
	}
	
	
}
