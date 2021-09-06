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
	private MemberMapper membermapper; // DI
	
	// 회원가입 쿼리 테스트
	@Test
	public void MemberJoin() throws Exception {
		MemberVO member = new MemberVO();
		
		member.setId("test");
		member.setPassword("test");
		member.setName("test");
		member.setEmail("test");
		member.setAddress1("test");
		member.setAddress2("test");
		member.setAddress3("test");
		
		membermapper.memberJoin(member); //쿼리 실행
	}

}
