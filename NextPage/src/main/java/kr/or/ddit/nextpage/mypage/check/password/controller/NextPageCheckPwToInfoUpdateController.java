package kr.or.ddit.nextpage.mypage.check.password.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.NpMemberVO;
import lombok.extern.slf4j.Slf4j;




/**
 * 정보 변경하러가기전에 비밀번호 체크하는 컨트롤러
 *
 */
@Slf4j
@Controller
@RequestMapping("nextpage/checkPass")
public class NextPageCheckPwToInfoUpdateController {
	
	@Inject
	private SchoolService service;

	
	// 비밀번호 확인 폼
	@GetMapping("/updateInfoForm")
	public String nextPageCheckPasswordForm() {
		return "nextpage/mypage/25_nextPageCheckPwToInfoUpdate/nextPageCheckPwToInfoUpdate";
	}
	
	// 비밀번호 제출 받은거 검증 후 수정 폼으로 이동
	@PostMapping("/updateInfoGo")
	public String nextPageCheckPassword(
			@RequestParam( name="inputPass" ) String inputPass
			, HttpSession session
			, Model model
			) {
		
		String view = "";
		String message ="";
		
		String schId = (String) session.getAttribute("authSch");
		NpMemberVO memvo = new NpMemberVO();
		memvo.setMemPw(inputPass);
		memvo.setNpMemId(schId);
		
		String result = service.authPassword(memvo);
		log.info("memvo : {}",memvo);
		
		if(result.equals("true")) {
			view = "redirect:/nextpage/mypage/updateAccountForm";
		}else {
			message = "입력하신 비밀번호는 맞지 않습니다.";
			view = "redirect:/nextpage/checkPass/updateInfoForm";
		}
		
		model.addAttribute("message", message);
		
		log.info("view :{} || message : {}", view, model);
		return view;
	}

}
