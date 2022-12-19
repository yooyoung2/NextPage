package kr.or.ddit.nextpage.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.NpMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("nextpage/autoLogin")
public class nextpageAutoLoginController {

	@Inject
	private SchoolService service;
	
	String view = "redirect:/nextpage/nextPageMain";
	String message="";
	
	@RequestMapping ("/student")
	public String adminAutoLogin(
			HttpSession session
			,RedirectAttributes redirectAttributes
			) {
		String id = "admin1";
		String pw = "1111";
		
		NpMemberVO admin = new NpMemberVO();
		admin.setNpMemId(id);
		admin.setMemPw(pw);
		
		NpMemberVO authSch = service.authenticate(admin);
		session.setAttribute("npMember", authSch);	// 로그인한 모든정보 객체로 세션에 저장. 저장명 : npMember
		
		
		session.setAttribute("authSch", authSch.getNpMemId());	// 로그인한 아이디 세션에 저장. 저장명 : authSch
		session.setAttribute("nextAuth", authSch.getMemAuth());	// 로그인한 아이디의 권한 저장. 저장명 : nextAuth

		message="로그인 성공";
		redirectAttributes.addFlashAttribute("message", message);
		
		return view;
	}
	
	@RequestMapping ("/yyTest")
	public String yyTestAutoLogin(			HttpSession session
			,RedirectAttributes redirectAttributes
			) {
		String id = "yyTest";
		String pw = "1234";
		
		NpMemberVO admin = new NpMemberVO();
		admin.setNpMemId(id);
		admin.setMemPw(pw);
		
		NpMemberVO authSch = service.authenticate(admin);
		session.setAttribute("npMember", authSch);	// 로그인한 모든정보 객체로 세션에 저장. 저장명 : npMember
		
		
		session.setAttribute("authSch", authSch.getNpMemId());	// 로그인한 아이디 세션에 저장. 저장명 : authSch
		session.setAttribute("nextAuth", authSch.getMemAuth());	// 로그인한 아이디의 권한 저장. 저장명 : nextAuth

		message="로그인 성공";
		redirectAttributes.addFlashAttribute("message", message);
		
		return view;
	}
	
	@RequestMapping ("/ddit")
	public String dditAutoLogin(
			HttpSession session
			,RedirectAttributes redirectAttributes
			) {
		String id = "ddit55";
		String pw = "ddit403!";
		
		NpMemberVO admin = new NpMemberVO();
		admin.setNpMemId(id);
		admin.setMemPw(pw);
		
		NpMemberVO authSch = service.authenticate(admin);
		session.setAttribute("npMember", authSch);	// 로그인한 모든정보 객체로 세션에 저장. 저장명 : npMember
		
		
		session.setAttribute("authSch", authSch.getNpMemId());	// 로그인한 아이디 세션에 저장. 저장명 : authSch
		session.setAttribute("nextAuth", authSch.getMemAuth());	// 로그인한 아이디의 권한 저장. 저장명 : nextAuth

		message="로그인 성공";
		redirectAttributes.addFlashAttribute("message", message);
		
		return view;
	}
	
}
