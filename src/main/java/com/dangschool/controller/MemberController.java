package com.dangschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dangschool.member.service.MemberService;
import com.dangschool.member.command.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {

		@Autowired
		private MemberService member;
	
	
		@RequestMapping("/login")
		public String login(RedirectAttributes RA) {
			return "member/login";
		}
		

		@RequestMapping("/join")
		public String join(RedirectAttributes RA) {
			return "member/join";
		}
		
		
		@RequestMapping("/joinForm")
		public String joinForm(MemberVO vo,
				RedirectAttributes RA) {
			
			
			int result = member.join(vo);
			
			if(result == 1) {	
				RA.addFlashAttribute("msg", "회원가입에 성공했습니다.");
			}else {	
				RA.addFlashAttribute("msg", "회원가입에 실패했습니다.");
			}
			
			return "redirect:/member/join_result";
		}
		
		@RequestMapping("/join_result")
		public String join_result() {
			return "member/login";
		}
		
		
		@RequestMapping("/loginForm")
		public String loginForm(MemberVO vo,
				HttpSession session,
				RedirectAttributes RA) {
			int result = member.login(vo);
			
			if( result == 1 ) {	
				session.setAttribute("user_id", vo.getId());
				return "/home";	//home 컨트롤러의 매핑으로
			}else {
				return "redirect:/member/login";
			}
		}
		
		@RequestMapping("/checkId")
		@ResponseBody
		public int CheckId(@RequestParam("id") String id) {
			
			int result = member.checkId(id);
			return result;
		}
		
		
		@RequestMapping(value="/myPage", method=RequestMethod.GET)
		public String myPage(HttpSession session) {
			return "member/myPage";
		}
		
		
		@RequestMapping(value="/modify")
		public String modify(HttpSession session, Model model,MemberVO vo) {
			
			String id = (String)session.getAttribute("user_id");
			
			vo = member.modify(id);
			model.addAttribute("user", vo);
			
			return "member/modify";
		}
		
		
		@RequestMapping(value="/update", method=RequestMethod.POST)
		public String update(MemberVO vo, HttpSession session) {
			
			member.update(vo);
			session.setAttribute("user_id", vo.getId());
			
			return "redirect:/member/myPage";
		}
		
		@RequestMapping(value="/changePwForm", method = RequestMethod.GET)
		public String changePw() {
			return "member/changePwForm";
		}
		
		@RequestMapping(value="/changePw", method=RequestMethod.POST)
	      public String changePw(MemberVO vo, @RequestParam("oldPw") String oldPw,
	            @RequestParam("newPw") String newPw, @RequestParam("newPw2") String newPw2, HttpSession session, RedirectAttributes RA) {
	         
	         String id = (String)session.getAttribute("user_id");
	         vo = member.modify(id);
	         
	         if(!oldPw.equals(vo.getPw())) {
	            return "redirect:/member/changePwForm";
	            
	         }else {
	            if(oldPw.equals(newPw)) {
	               RA.addFlashAttribute("msg", false);
	               return "redirect:/member/changePwForm";
	            }else {
	               if(newPw.equals(newPw2)) {
	                  vo.setPw(newPw);
	                  member.changePw(vo);
	               }else {
	                  RA.addFlashAttribute("msg", false);
	                  return "redirect:/member/changePwForm";
	               }
	            }

	         }
	         session.invalidate();
	         return "redirect:/";


	      }
		
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
		@RequestMapping(value="/delete", method = RequestMethod.GET)
		public String delete() {
			return "member/delete";
		}
		
		@RequestMapping(value="/memberDelete", method = RequestMethod.POST)
		public String memberDelete(MemberVO vo, @RequestParam("pw") String pw, HttpSession session, RedirectAttributes RA) {
			
			String id = (String)session.getAttribute("user_id");
			vo = member.modify(id);
			
			if(!pw.equals(vo.getPw())) {
				RA.addFlashAttribute("msg", false);
				return "redirect:/member/delete";
			}else {
				member.delete(vo);
				session.invalidate();
				return "redirect:/";
			}
			
			 
			
		}

		   @RequestMapping(value="/pop", method = RequestMethod.GET)
		   public String pop() {
		      
		      return "pop";
		   }
	}
		


	 

