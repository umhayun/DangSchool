package com.dangschool.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardManagerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		
		if( user_id == null ) {
			response.sendRedirect("/DangSchool");		//
			//���̵� null
			return false;
			//return false�� �ǹ̴� �ڵ鷯 �޼��� �������� Controller �������� ����
		}else if(!(user_id.equals("dangschool"))){
			//���̵� "dangschool"�� �ƴ�
			response.sendRedirect("/DangSchool");	
			return false;
		}else {
			return true;
			//return true�� �ǹ̴� �ڵ鷯 �޼��带 ���� �� �� Controller ����
		}
		
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("����Ȯ��!!");
		//super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	
	
	
}
