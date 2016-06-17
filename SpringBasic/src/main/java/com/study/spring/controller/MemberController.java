package com.study.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.domain.MemberVO;
import com.study.spring.service.MemberService;

// 1. ����ڰ� �������� ���ؼ� URI�� ȣ��

// 2. ��Ĺ�� ��ġ�� [ ������ �����ӿ� ] <��Ĺ
//	   -> Controller ���� �˻��ؼ� @RequestMapping �ֳ����̼��� ã�´�.
//	   -> �ֳ����̼��� value �� ������ URI �� ��Ī�� ��Ų��.

// 3. URI�� ���ε� �޼��忡�� return ���ִ� ���ڿ��� �̸��� ���� jsp ������
// 	  ����ڿ��� �Ѱ��ش� 


@Controller
public class MemberController {
	
	@Inject
	private MemberService service;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<MemberVO> member_list = service.getList();
		model.addAttribute("list", member_list);	
		return "member_list";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String memberInsert(MemberVO vo , Model model) {
		
		service.insertMember(vo);
		
		return "redirect:/member";
	}
	
	@RequestMapping(value="/memberWrite",method = RequestMethod.GET)
	public void memberWirte() {
		
	}
	@RequestMapping(value = "/memberDelete", method = RequestMethod.POST)
	public String memberDelete(@RequestParam("user_id") String user_id, Model model) {
		
		service.deleteMember(user_id);
		
		return "redirect:/member";	
	}
	
	
	// ���� ������ 
	@RequestMapping(value = "/memberEdit", method = RequestMethod.POST)
	public String edit(@RequestParam("user_id")String user_id, Model model) {
		
		MemberVO vo = service.get(user_id) ;
		model.addAttribute("vo", vo);
		return "memberEdit";	
	}
	
	
	// �����ϸ� ������Ʈ�Ǵ� ��
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String update(MemberVO vo, Model model) {
		service.updateMember(vo);
		return "redirect:/member";
		
	}
}
