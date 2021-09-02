package com.bigchoi.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * - 
 * @RunWith는 jUnit 프레임워크의 테스트 실행방법을 확장할 때 사용하는 어노테이션이다.
	- SpringJUnit4ClassRunner라는 클래스를 지정해주면 jUnit이 테스트를 진행하는 중에 ApplicationContext를 만들고 관리하는 작업을 진행해준다.
	- @RunWith 어노테이션은 각각의 테스트 별로 객체가 새성되더라도 싱글톤(Singletone)의 ApplicationContext를 보장한다.
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * @ContextConfiguration은 자동으로 만들어줄 애플리케이션 컨텍스트의 설정파일위치를 지정한 것이다.
 */
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testConeection() {

		try (
				Connection conn = dataSource.getConnection(); 
				SqlSession sql = sqlSessionFactory.openSession();
		
		){
			System.out.println("conn = " + conn);
			System.out.println("sql = " + sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
