package kr.or.ddit.generation.website.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.generation.school.schoolMember.service.SchoolMemberService;
import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("generation/{id}")
public class GeneratingAutoLoginController {

	@Inject
	private SchoolMemberService service;
	
	String view = null;
	String message="";
	
	
	//학생 자동로그인
	@RequestMapping ("/login/autoStudent")
	public String studentAutoLogin(
			@PathVariable("id") String schId
			,HttpSession session
			,RedirectAttributes redirectAttributes
			) {
		String id = "yyTest-20221624";
		String pw = "1234";
		
		view = "redirect:/generation/"+schId+"/main";
		
		
		SchMemberVO stud = new SchMemberVO();
		stud.setSchId(schId);
		stud.setMemId(id);
		stud.setMemPw(pw);
		
		SchMemberVO authMem = service.authenticate(stud);
		log.info("authMem ???? ",authMem);
		
		service.checkAuth(authMem);
		
		
		session.setAttribute("authMem", authMem.getMemId());	// 로그인한 아이디 세션에 저장. 저장명 : authSch
		session.setAttribute("authVal", authMem.getAuthMem());	// 로그인한 아이디의 권한 저장. 저장명 : nextAuth
		log.info("authVal : {}", session.getAttribute("authVal"));

		message="로그인 성공";
		redirectAttributes.addFlashAttribute("message", message);
		
		return view;
	}
	
	
	// 학부모 로그인
	@RequestMapping ("/login/autoParents")
	public String PrntAutoLogin(
			@PathVariable("id") String schId
			,HttpSession session
			,RedirectAttributes redirectAttributes
			) {
		String id = "testPrnt";
		String pw = "ddit403!";
		
		view = "redirect:/generation/"+schId+"/main";
		
		
		SchMemberVO stud = new SchMemberVO();
		stud.setSchId(schId);
		stud.setMemId(id);
		stud.setMemPw(pw);
		
		SchMemberVO authMem = service.authenticate(stud);
		// 학생, 선생님, 학부모인지 알아보고 세션에 저장.
		service.checkAuth(authMem);
		
		session.setAttribute("authMem", authMem.getMemId());	// 로그인한 아이디 세션에 저장. 저장명 : authSch
		session.setAttribute("authVal", authMem.getAuthMem());	// 로그인한 아이디의 권한 저장. 저장명 : nextAuth

		message="로그인 성공";
		redirectAttributes.addFlashAttribute("message", message);
		
		return view;
	}
	
	
	
	// 교직원 자동로그인
	@RequestMapping ("/login/autoEdu")
	public String EduAutoLogin(
			@PathVariable("id") String schId
			,HttpSession session
			,RedirectAttributes redirectAttributes
			) {
		String id = "yyTest-20229785";
		String pw = "1234";
		
		view = "redirect:/generation/"+schId+"/main";
		
		
		SchMemberVO stud = new SchMemberVO();
		stud.setSchId(schId);
		stud.setMemId(id);
		stud.setMemPw(pw);
		
		SchMemberVO authMem = service.authenticate(stud);
		// 학생, 선생님, 학부모인지 알아보고 세션에 저장.
		service.checkAuth(authMem);
		
		
		session.setAttribute("authMem", authMem.getMemId());	// 로그인한 아이디 세션에 저장. 저장명 : authSch
		session.setAttribute("authVal", authMem.getAuthMem());	// 로그인한 아이디의 권한 저장. 저장명 : nextAuth

		message="로그인 성공";
		redirectAttributes.addFlashAttribute("message", message);
		
		return view;
	}
	
	
	// 학교 운영자 자동로그인
	@RequestMapping ("/login/autoAdmin")
	public String adminAutoLogin(
			@PathVariable("id") String schId
			,HttpSession session
			,RedirectAttributes redirectAttributes
			) {
		String id = "yyTest";
		String pw = "1234";
		
		view = "redirect:/generation/"+schId+"/main";
		
		
		SchMemberVO stud = new SchMemberVO();
		stud.setSchId(schId);
		stud.setMemId(id);
		stud.setMemPw(pw);
		
		SchMemberVO authMem = service.authenticate(stud);
		// 학생, 선생님, 학부모인지 알아보고 세션에 저장.
		service.checkAuth(authMem);
		
		
		session.setAttribute("authMem", authMem.getMemId());	// 로그인한 아이디 세션에 저장. 저장명 : authSch
		session.setAttribute("authVal", authMem.getAuthMem());	// 로그인한 아이디의 권한 저장. 저장명 : nextAuth

		message="로그인 성공";
		redirectAttributes.addFlashAttribute("message", message);
		
		return view;
	}
}