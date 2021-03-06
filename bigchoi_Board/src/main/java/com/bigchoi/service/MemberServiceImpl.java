package com.bigchoi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigchoi.mapper.MemberMapper;
import com.bigchoi.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper membermapper;

	@Override
	public void memberJoin(MemberVO member) throws Exception {

		membermapper.memberJoin(member);
	}
	
	@Override
	public int idCheck(String id) throws Exception {
		
		return membermapper.idCheck(id);
	}

}
