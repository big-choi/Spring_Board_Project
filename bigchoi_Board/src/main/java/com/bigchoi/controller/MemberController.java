package com.bigchoi.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bigchoi.model.MemberVO;
import com.bigchoi.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/member")
@Log4j
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private JavaMailSender mailSender;

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

		if (result != 0) {
			return "fail"; // �ߺ� ���̵� ����
		} else {
			return "success"; // �ߺ� ���̵� ����
		}

	} // memberIdChkPOST() ����

	/* �̸��� ���� */
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {

		/* ��(View)�κ��� �Ѿ�� ������ Ȯ�� */
		log.info("�̸��� ������ ���� Ȯ��");
		log.info("������ȣ : " + email);

		/* ������ȣ ���� */
		Random random = new Random();
		int num = random.nextInt(888888) + 100000;
		log.info("������ȣ " + num);

		/* �̸��� ������ */
		String from = "bos33210@naver.com";
		String to = email;
		String title = "ȸ������ ���� �̸��� �Դϴ�.";
		String content = "���� ��ȣ�� " + num + " �Դϴ�.";

		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// View�� �ٽ� ��ȯ�� �� ������ Ÿ���� String�� ����

		String stringNumber = Integer.toString(num);

		return stringNumber;
	}
}
