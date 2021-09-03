package com.bigchoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/member")
@Log4j
public class MemberController {
	
	//�α��� ������ �̵�
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGET() {
		
		log.info("�α��� ������ ����");
	}

}
