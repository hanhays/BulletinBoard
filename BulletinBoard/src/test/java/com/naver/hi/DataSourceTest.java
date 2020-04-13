package com.naver.hi;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 
//**:no matter whatever directory all .xml files  
public class DataSourceTest {

	@Inject
	//@Autowired
	private DataSource dataFactory;
	
	@Test
	public void testConnection() {
		Connection conn = null;
		try {
			conn = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//must be public + void + no parameter 
}
