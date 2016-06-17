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

// 1. 사용자가 브라우저를 통해서 URI를 호출

// 2. 톰캣에 설치된 [ 스프링 프레임웍 ] <톰캣
//	   -> Controller 들을 검색해서 @RequestMapping 애너테이션을 찾는다.
//	   -> 애너테이션의 value 의 값들을 URI 와 매칭을 시킨다.

// 3. URI와 매핑된 메서드에서 return 해주는 문자열과 이름이 같은 jsp 파일을
// 	  사용자에게 넘겨준다 


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
	
	
	// 수정 페이지 
	@RequestMapping(value = "/memberEdit", method = RequestMethod.POST)
	public String edit(@RequestParam("user_id")String user_id, Model model) {
		
		MemberVO vo = service.get(user_id) ;
		model.addAttribute("vo", vo);
		return "memberEdit";	
	}
	
	
	// 수정하면 업데이트되는 곳
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String update(MemberVO vo, Model model) {
		service.updateMember(vo);
		return "redirect:/member";
		
	}
}
