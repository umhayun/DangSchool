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
			//��ī�� Ŀ�ݼ� Ǯ �ҷ��ͼ� ����ϴ� ��
			System.out.println(">>>>>>>>>>>>>> connection ��� : "+conn);
			
			System.out.println(">>>>>>>>>>>>>> ���ø� ��ü ���� "+jdbcTemplate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

