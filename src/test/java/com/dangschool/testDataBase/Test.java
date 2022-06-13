package com.dangschool.testDataBase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test {

	@org.junit.Test
	public void test() {
		
	
	LocalDate todaysDate = LocalDate.now();
	LocalDate today = LocalDate.now();
	LocalDate tomorrow = todaysDate.plusDays(1);
	LocalDate tomorrow3 = todaysDate.plusDays(31);

	
	
	System.out.println(">>>>>>>>>>>>>> 날짜확인1:  : "+todaysDate);
	System.out.println(">>>>>>>>>>>>>> 날짜확인3:  : "+tomorrow);
	System.out.println(">>>>>>>>>>>>>> 날짜확인3:  : "+tomorrow3);
	
	
	
	}
}
