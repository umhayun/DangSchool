package com.dangschool.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dangschool.reservation.command.ReservationVO;
import com.dangschool.reservation.service.ReservationService;

@Controller
@RequestMapping("/reservation/")
public class ReservationController {
	@Autowired
	ReservationService reserv;
	
	@RequestMapping("/reserve")
	public String reserve(HttpSession session) {
		
		return "reservation/reserve";
	}
	@RequestMapping("/payment")
	public String reservform(ReservationVO vo,HttpSession session,Model model) {
		
		reserv.reservation(vo);

		model.addAttribute("reserv",vo);
		
			return "/reservation/payment";
	}

	@RequestMapping("/myreserve")
	public String myreserve(HttpSession session,Model model) {
		String id=(String)session.getAttribute("user_id");
		ArrayList<ReservationVO> list=reserv.select(id);
		model.addAttribute("list", list);
		return "reservation/myreserve";
	}
	@RequestMapping("/adminreserve")
	public String admin(Model model) {
		 ArrayList<ReservationVO> list =reserv.manage();
		 model.addAttribute("list", list);
		return "/reservation/adminreserve";
	}
	@RequestMapping("/check")
	public String check(@RequestParam("reservno") int reservno) {
		 reserv.check(reservno);
		return "redirect:/reservation/adminreserve";
	}
	
}
