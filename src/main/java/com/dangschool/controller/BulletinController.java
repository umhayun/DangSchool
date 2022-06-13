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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dangschool.b_board.service.BulletinService;
import com.dangschool.board.command.BoardVO;
import com.dangschool.util.Criteria;
import com.dangschool.util.PageVO;

@Controller
@RequestMapping("/bulletin_board/")
public class BulletinController {

	@Autowired
	private BulletinService service;

	// �Խñ� ��ü ���
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute("cri") Criteria cri, HttpSession session,
			HttpServletRequest request) {

		ArrayList<BoardVO> list = service.getList(cri);
		model.addAttribute("board_list", list);

		int total = service.getTotal(cri);
		model.addAttribute("pageMaker", new PageVO(total, cri));

		return "bulletin_board/list";
	}

	// �˻��� �Խñ� ��ü ���
	@RequestMapping("/listsearch")
	public String search(Criteria cri, Model model) {

		ArrayList<BoardVO> list = service.getListsearch(cri);

		// isEmpty() - �ڹ�SE1.6�����̻�, �ν��Ͻ������Ͽ�����, list���� �ƹ� �͵� ���� ����
		if (!list.isEmpty()) {
			model.addAttribute("board_list", list);

			int total = service.getTotal(cri);
			model.addAttribute("pageMaker", new PageVO(total, cri));

			return "bulletin_board/list";

		} else {
			model.addAttribute("listcheck", "empty");

			return "bulletin_board/list";
		}
	}

	// ��� ȭ��ó��
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("cri") Criteria cri, HttpSession session, HttpServletRequest request,
			Model model) {
		System.out.println("���ȭ��ó��");
		System.out.println("��������ȣ : " + cri.getPageNum() + cri.getCount());
		System.out.println("===========�������̵�=======" + session.getAttribute("user_id"));

		String id = (String) session.getAttribute("user_id");

		BoardVO vo = service.member(id);
		model.addAttribute("member", vo);

		return "bulletin_board/register";
	}

	// �Խñ� ��� ��û ó��
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(BoardVO vo) {
		System.out.println("���ó��");
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());

		service.register(vo);

		return "redirect:/bulletin_board/list";
	}

	// �Խñ� ��
	// + ������, ������
	@RequestMapping("/content")
	public String content(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {

		BoardVO vo = service.getContent(num);
		model.addAttribute("board", vo);
		
		System.out.println("cri�� Ű���尪�� ���� �ִ��� Ȯ��+++++"+cri.getKeyword());
		
		// ������, ������
		BoardVO vo2 = service.movePage(num);

		System.out.println("============Ȯ���մϴ�==============");
		System.out.println("������ȣ : " + vo2.getLast());
		System.out.println("������ȣ : " + vo2.getNext());
		System.out.println("������ ����: " + vo2.getLasttitle());
		System.out.println("������ ����: " + vo2.getNexttitle());

		model.addAttribute("move", vo2);


		return "bulletin_board/content";
	}

	// �Խñ� ����ȭ�� ó��
	@RequestMapping("/modify")
	public String update(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {

		BoardVO vo = service.getContent(num);
		model.addAttribute("board", vo);

		return "bulletin_board/modify";
	}

	// �Խñ� ����ó��
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo) {
//		System.out.println("----------��Ʈ�Ѱ���----------");
//		System.out.println(vo.getNum());
//		System.out.println(vo.getTitle());
//		System.out.println(vo.getContent());
//		System.out.println(vo.getRegdate());

		service.update(vo);

		return "redirect:/bulletin_board/list";
	}

	// �Խñ� ����ó��
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {

		service.delete(num);

		return "redirect:/bulletin_board/list";
	}

}