package com.dangschool.testDataBase;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JDBCTemplateTest {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testTemplate() {
		try {
			Connection conn = datasource.getConnection();
			//히카리 커넷션 풀 불러와서 사용하는 것
			System.out.println(">>>>>>>>>>>>>> connection 출력 : "+conn);
			
			System.out.println(">>>>>>>>>>>>>> 템플릿 객체 생성 "+jdbcTemplate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

