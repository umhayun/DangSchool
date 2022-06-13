package com.dangschool.util;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {

	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//�Ǿտ� �ִ� *�� ���� �����ڸ� �ǹ��ϰ�, �ǵڿ� *�� �޼��带 �ǹ���. 
	@Before("execution(* com.dangschool.review.service.ReviewServiceImpl*.*(..))")
	//@Before("execution(* com.dangschool.controller.*Controller*.*(..))")
	public void beforeLog() {
		logger.info("-----Before-----");
	}
	
	//���� AOP����!
	@After("execution(* com.dangschool.review.service.ReviewServiceImpl.*(..))")
	public void afterLog() {
		logger.info("-----After-----");
		
	}
	
	//�ż��� ���� ������ ������ , ������, ���� �� ó���� ����
	//@Around�� ����ȴ� �޼���(�����̽�)�� �ݵ�� ������ �־�� �մϴ�. 
	@Around("execution(* com.dangschool.review.service.ReviewServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		long start = System.currentTimeMillis();
		
		//�ش� ����� ���ؼ� �޼��� ������ ����� Ȯ�� �� �� ����. 
		//System.out.println("����Ŭ����: " + jp.getTarget());
		//System.out.println("�����Ķ���� : "+ Arrays.toString(jp.getArgs()));
		
		logger.info("����Ŭ���� : " + jp.getTarget());
		logger.info("�����Ķ���� : "+ Arrays.toString(jp.getArgs()));
		
		Object result = null;
		
		try {
			//proceed()�� Ÿ�ٸ޼��带 ��Ī�Ѵ�. �ش� �޼��带 ���� ���Ѿ� Ÿ���� �Ǵ� �޼��尡 ����ȴ�. 
			//�ش� �޼��带 ������ ������ Before �����̽��� ����ȴ�. 
			result = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		//System.out.println("�޼�����࿡ �ɸ� �ð� : " + (end - start));
		logger.info("�޼�����࿡ �ɸ� �ð� : " + (end - start));
		
		return result;
		
	}
	
	//�ش� ������̼��� ���ܰ� �߻��ϸ� �����ϴ� ������̼�
	//pointcut - � �޼��忡 ������ ����
	//throwing - ó���� ���� ����
	@AfterThrowing(pointcut="execution(* com.dangschool.service.memberService*.*(..))"
			, throwing = "e")
	public void errorLog(Exception e) {
		System.out.println("���� ��� : "+ e);
	}
}