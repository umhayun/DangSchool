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

	// 게시글 전체 목록
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute("cri") Criteria cri, HttpSession session,
			HttpServletRequest request) {

		ArrayList<BoardVO> list = service.getList(cri);
		model.addAttribute("board_list", list);

		int total = service.getTotal(cri);
		model.addAttribute("pageMaker", new PageVO(total, cri));

		return "bulletin_board/list";
	}

	// 검색시 게시글 전체 목록
	@RequestMapping("/listsearch")
	public String search(Criteria cri, Model model) {

		ArrayList<BoardVO> list = service.getListsearch(cri);

		// isEmpty() - 자바SE1.6버전이상, 인스턴스생성하였으나, list에는 아무 것도 없는 상태
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

	// 등록 화면처리
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@ModelAttribute("cri") Criteria cri, HttpSession session, HttpServletRequest request,
			Model model) {
		System.out.println("등록화면처리");
		System.out.println("페이지번호 : " + cri.getPageNum() + cri.getCount());
		System.out.println("===========유저아이디=======" + session.getAttribute("user_id"));

		String id = (String) session.getAttribute("user_id");

		BoardVO vo = service.member(id);
		model.addAttribute("member", vo);

		return "bulletin_board/register";
	}

	// 게시글 등록 요청 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(BoardVO vo) {
		System.out.println("등록처리");
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());

		service.register(vo);

		return "redirect:/bulletin_board/list";
	}

	// 게시글 상세
	// + 이전글, 다음글
	@RequestMapping("/content")
	public String content(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {

		BoardVO vo = service.getContent(num);
		model.addAttribute("board", vo);
		
		System.out.println("cri에 키워드값이 남아 있는지 확인+++++"+cri.getKeyword());
		
		// 이전글, 다음글
		BoardVO vo2 = service.movePage(num);

		System.out.println("============확인합니다==============");
		System.out.println("이전번호 : " + vo2.getLast());
		System.out.println("다음번호 : " + vo2.getNext());
		System.out.println("이전글 제목: " + vo2.getLasttitle());
		System.out.println("다음글 제목: " + vo2.getNexttitle());

		model.addAttribute("move", vo2);


		return "bulletin_board/content";
	}

	// 게시글 수정화면 처리
	@RequestMapping("/modify")
	public String update(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {

		BoardVO vo = service.getContent(num);
		model.addAttribute("board", vo);

		return "bulletin_board/modify";
	}

	// 게시글 수정처리
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo) {
//		System.out.println("----------컨트롤계층----------");
//		System.out.println(vo.getNum());
//		System.out.println(vo.getTitle());
//		System.out.println(vo.getContent());
//		System.out.println(vo.getRegdate());

		service.update(vo);

		return "redirect:/bulletin_board/list";
	}

	// 게시글 삭제처리
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {

		service.delete(num);

		return "redirect:/bulletin_board/list";
	}

}