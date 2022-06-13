package com.dangschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guide/")
public class GuideController {

	
	//�ܼ�ȭ�鼳��
	//�����ȳ�
	@RequestMapping("/training_guide")
	public String training_guide() {
		
		return "guide/training_guide";
	}
	//���ô±�
	@RequestMapping("/guide")
	public String guide() {
		
		return "guide/guide";
	}
	//�б��Ұ�
	@RequestMapping("/intro")
	public String intro() {
		return "guide/intro";
	}
	//�ð�ǥ
	@RequestMapping("/schedule")
	public String schedule() {
		return "guide/schedule";
	}
}
