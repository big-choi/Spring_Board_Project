package com.bigchoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ProductController {
	
	//mainPage �̵�
	@RequestMapping(value = "mainPage", method = RequestMethod.GET)
	public void mainPageGet() {
		
		log.info("���� ������ ����");
	}
}
