package kr.or.ddit.nextpage.mypage.update.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;



/**
 * 패스워드 수정 폼 불러오고
 * 제출해서 업데이트하는데
 *
 */
@Slf4j
@Controller
@RequestMapping( "nextpage/user/update" )
public class NextPageUpdatePasswordController {

	@Inject
	private SchoolService service;
	
	@GetMapping( "/passwordForm" )
	public String nextPageUpdatePasswordForm(

			) {
//		String schId = (String) session.getAttribute("authSch");
//		
//		NpMemberVO vo = service.retrieveMember(schId);
//		
//		model.addAttribute("schInfo", vo);
		
		return "nextpage/mypage/28_nextPageUpdatePassword/nextPageUpdatePassword";
	}
	
	@PostMapping ( "/updatePassword" )
	public String nextPageUpdatePassword(
			@RequestParam("memPw") String schPw
			,HttpSession session
			, Model model
			) {
		log.info("들어왔나");
		String logicalViewName = null;
		String schId = (String) session.getAttribute("authSch");
		NpMemberVO vo = new NpMemberVO();
		
				vo.setNpMemId(schId);
				vo.setMemPw(schPw);
				
				ServiceResult result = service.modifyPass(vo);
				switch (result) {
				case OK:
					logicalViewName = "redirect:/nextpage/mypage/info";
					log.info("OK?");
					break;
					
				default:
					model.addAttribute("message", "서버 오류");
					logicalViewName = "redirect:/nextpage/user/update/passwordForm";
					log.info("NO...");
					break;
				}
		return logicalViewName;
	}
}
