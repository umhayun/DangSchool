package com.dangschool.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.dangschool.activity.command.ActivityVO;
import com.dangschool.activity.command.ImgVO;
import com.dangschool.activity.service.ActivityService;
import com.dangschool.util.Criteria;

import com.dangschool.util.PageVO;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
	
	Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	ActivityService service;
	@Resource(name="uploadPath")
    String uploadPath;
	//목록 구현
	@RequestMapping("/active")
	public String main(@ModelAttribute("cri") Criteria cri, Model model,HttpSession session,ActivityVO vo) {
		
		List<ActivityVO> list=service.list(cri);

		model.addAttribute("a_list",list);
		int total=service.getTotal(cri);
		model.addAttribute("page", new PageVO(total, cri));
		ArrayList<ImgVO> img=service.imgList();
		model.addAttribute("img",img);
		System.out.println(img);
		System.out.println(list);
		return "activity/activity";
	}
	//등록 화면구현
	@RequestMapping("/register")
	public String register(HttpSession session) {
		
		return "activity/register";
	}
	//등록 처리 구현
	@RequestMapping(value="/regform", method=RequestMethod.POST)
	public String regform(ActivityVO vo,Map<String, Object> map, MultipartFile[] file, HttpServletRequest request) throws Exception {
	        service.insert(vo);
	        for(int i=0; i<file.length; i++) {
	            log.debug("================== file start ==================");
	            log.debug("파일명: "+file[i].getName());
	            log.debug("원래파일명: "+file[i].getOriginalFilename());
	            log.debug("크기: "+file[i].getSize());
	            log.debug("content type: "+file[i].getContentType());
	            log.debug("================== file   END ==================");
	        }
	        
	        HttpSession session=request.getSession();
	        service.insertFile(map,file,session);
		return "redirect:/activity/active";
	}
	
	//컨텐츠
	@RequestMapping(value="/content")
	public String content(@RequestParam("num") int num, HttpSession session, Model model, @ModelAttribute("cri") Criteria cri) {
		String user=(String)session.getAttribute("user_id");	
		
		if(session.getAttribute("hit")==null) {
			session.setAttribute("hit",user+num);
			service.hit(num);

		}
		else {
			if(!session.getAttribute("hit").equals(user+num)) {
				session.setAttribute("hit",user+num);
				service.hit(num);
			}	
		}
		ActivityVO vo=service.content(num);
		ArrayList<ImgVO> vo2=service.uploadfile(num);
		System.out.println(vo2);
		model.addAttribute("img", vo2);
		model.addAttribute("content",vo);
		return "activity/content";
	}
	@RequestMapping(value="/search")
	public String search(@ModelAttribute("cri") Criteria cri) {
		
		return "redirect:/activity/active";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("num")int num) {
		service.delete(num);
		return "redirect:/activity/active";
			
	}
	
}
