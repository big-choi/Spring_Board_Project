package com.bigchoi.service;

import com.bigchoi.model.MemberVO;

public interface MemberService {
	
	//ȸ������
	public void memberJoin(MemberVO member) throws Exception;
	
	// ���̵� �ߺ� �˻�
	public int idCheck(String id) throws Exception;
	}
