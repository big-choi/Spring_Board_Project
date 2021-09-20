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

	// ȸ������
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception {

		log.info("join ����");

		// ȸ������ ���� ����
		memberService.memberJoin(member);

		log.info("joinService ����");

		return "redirect:/mainPage";
	}

	// �α��� ������ �̵�
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGET() {

		log.info("�α��� ������ ����");
	}

	// ȸ������ ������ �̵�
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void joinGET() {

		log.info("ȸ������ ������ ����");
	}

	// ���̵� �ߺ� �˻�
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String id) throws Exception {
		
		log.info("memberIdChk() ����");
		
		int result = memberService.idCheck(id);
		
		log.info("����� : " + result);
		
		if(result != 0) {
			return "fail"; //�ߺ� ���̵� ����
		} else {
			return "success"; //�ߺ� ���̵� ����
		}

	} // memberIdChkPOST() ����
}
