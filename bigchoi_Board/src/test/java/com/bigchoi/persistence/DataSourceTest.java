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
 * @RunWith�� jUnit �����ӿ�ũ�� �׽�Ʈ �������� Ȯ���� �� ����ϴ� ������̼��̴�.
	- SpringJUnit4ClassRunner��� Ŭ������ �������ָ� jUnit�� �׽�Ʈ�� �����ϴ� �߿� ApplicationContext�� ����� �����ϴ� �۾��� �������ش�.
	- @RunWith ������̼��� ������ �׽�Ʈ ���� ��ü�� �����Ǵ��� �̱���(Singletone)�� ApplicationContext�� �����Ѵ�.
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * @ContextConfiguration�� �ڵ����� ������� ���ø����̼� ���ؽ�Ʈ�� ����������ġ�� ������ ���̴�.
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