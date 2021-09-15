package com.bigchoi.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bigchoi.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {

	@Autowired
	private MemberMapper membermapper; // MemberMapper DI
	
	/*
	 * // 회원가입 쿼리 테스트
	 * 
	 * @Test public void memberJoin() throws Exception { MemberVO member = new
	 * MemberVO();
	 * 
	 * member.setId("test2"); member.setPassword("test2"); member.setName("test2");
	 * member.setEmail("test2"); member.setAddress1("test2");
	 * member.setAddress2("test2"); member.setAddress3("test2");
	 * 
	 * membermapper.memberJoin(member); //쿼리 실행 }
	 */
	
	@Test
	public void memberIdChk() throws Exception{
		String id = "test";	// 존재하는 아이디
		String id2 = "test123";	// 존재하지 않는 아이디
		membermapper.idCheck(id);
		membermapper.idCheck(id2);
	}
}
