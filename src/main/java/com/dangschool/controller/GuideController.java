package com.dangschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guide/")
public class GuideController {

	
	//단순화면설정
	//교육안내
	@RequestMapping("/training_guide")
	public String training_guide() {
		
		return "guide/training_guide";
	}
	//오시는길
	@RequestMapping("/guide")
	public String guide() {
		
		return "guide/guide";
	}
	//학교소개
	@RequestMapping("/intro")
	public String intro() {
		return "guide/intro";
	}
	//시간표
	@RequestMapping("/schedule")
	public String schedule() {
		return "guide/schedule";
	}
}
