package kr.or.ddit.nextpage.mypage.check.password.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;


/**
 * 비밀번호 변경 전
 * 비밀번호 확인 폼
 * 이후 비밀번호 입력한거 체크 후에 폼으로 보내주는거
 */
@Slf4j
@Controller
@RequestMapping( "nextpage/checkPass" )
public class NextPageCheckPwToPwUpdateController {
	
	@Inject
	private SchoolService service;
	
	//비밀번호 확인 폼
	@GetMapping( "/updatePass" )
	public String nextPageCheckPasswordForm() {
		return "nextpage/mypage/27_nextPageCheckPwToPwUpdate/nextPageCheckPwToPwUpdate";
	}

	// 비밀번호 제출 받은거 검증 후 수정 폼으로 이동
		@PostMapping("/updatePassFormGo")
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
				view = "redirect:/nextpage/user/update/passwordForm";
				log.info("아니면 맞은거니?");
			}else {
				message = "입력하신 비밀번호는 맞지 않습니다.";
				view = "redirect:/nextpage/checkPass/updatePass";
				log.info("안맞았니");
			}
			log.info("view : {}",view);
			model.addAttribute("message", message);
			
			log.info("view :{} || message : {}", view, model);
			return view;
		}
}
