package com.dangschool.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dangschool.review.command.ReviewVO;
import com.dangschool.review.service.ReviewService;
import com.dangschool.util.Criteria;
import com.dangschool.util.PageVO;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@RequestMapping("/list")
	public String list(Model model, Criteria cri) {
		ArrayList<ReviewVO> list = service.getList(cri);
		model.addAttribute("review_list", list);
		
		int total = service.getTotal();
		
		model.addAttribute("pageMaker", new PageVO(total, cri));
		
		return "review/list";				
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(@ModelAttribute("cri") Criteria cri) {	
		return "review/register";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(ReviewVO vo) {
		service.register(vo);
		return "redirect:/review/list";
	}
	
	
	@RequestMapping("/content")
	public String content(@RequestParam("num") int num, Model model,
			@ModelAttribute("cri") Criteria cri) {

		ReviewVO vo = service.getContent(num);
		model.addAttribute("review", vo);
		
		return "review/content";
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam("num") int num, Model model,
			@ModelAttribute("cri") Criteria cri) {
		
		ReviewVO vo = service.getContent(num);
		model.addAttribute("review", vo);
		
		return "review/modify";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		
		service.delete(num);
		return "redirect:/review/list";
	}	
	
	
}
