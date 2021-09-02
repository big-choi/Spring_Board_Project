package com.bigchoi.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JdbcTest {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"book_ex",
				"book_ex")){
			System.out.println(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
