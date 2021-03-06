package com.bigchoi.service;

import com.bigchoi.model.MemberVO;

public interface MemberService {
	
	//회원가입
	public void memberJoin(MemberVO member) throws Exception;
	
	// 아이디 중복 검사
	public int idCheck(String id) throws Exception;
	}
