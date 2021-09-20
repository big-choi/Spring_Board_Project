package com.bigchoi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.bigchoi.model.MemberVO;
import com.bigchoi.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/member")
@Log4j
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception {

		log.info("join 진입");

		// 회원가입 서비스 진행
		memberService.memberJoin(member);

		log.info("joinService 성공");

		return "redirect:/mainPage";
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGET() {

		log.info("로그인 페이지 진입");
	}

	// 회원가입 페이지 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void joinGET() {

		log.info("회원가입 페이지 진입");
	}

	// 아이디 중복 검사
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String id) throws Exception {
		
		log.info("memberIdChk() 진입");
		
		int result = memberService.idCheck(id);
		
		log.info("결과값 : " + result);
		
		if(result != 0) {
			return "fail"; //중복 아이디 존재
		} else {
			return "success"; //중복 아이디 없음
		}

	} // memberIdChkPOST() 종료
}
