package kr.or.ddit.nextpage.mypage.delete.account.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("nextpage/mypage/delete")
public class NextPageMyPageDeleteAccountController {
	@Inject
	private LogService logService;
	@Inject
	private SchoolService service;
	@Resource(name="passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/checkPass")
	public String nextPageDeleteAccountForm(
			HttpSession session
			, Model model
		) {

		String schId = (String) session.getAttribute("authSch");

		NpMemberVO memvo = service.retrieveMember(schId);

		model.addAttribute("memvo",memvo);

		return "nextpage/mypage/29_nextPageMyPageDeleteAccount/nextPageMyPageDeleteAccount";
	}

	@PostMapping("/delAccountCheckPass")
	public String nextPageDeleteAccountCheckPass(
			@Validated(UpdateGroup.class) @ModelAttribute("memvo") NpMemberVO inputInfo
			, BindingResult errors
			, HttpSession session
			, RedirectAttributes redirectAttributes
		) {

		log.info("BindingResult : {} ", errors);
		String view = "";
		String message = "";


		// 비교할 비밀번호 만들기 (저장되어있는 비밀번호 끌어오기)
		String schId = (String) session.getAttribute("authSch");
		NpMemberVO memvo = service.retrieveMember(schId);

		String savedPass = memvo.getMemPw();


		// 입력된 패스워드만 뽑아오기
		String inputPass = inputInfo.getMemPw();

		// "탈퇴" 업데이트 시 필요할 세션아이디의 상세 정보 불러오기
		SchoolVO schvo = service.retrieveSchoolInfo(schId);
		
		if (!passwordEncoder.matches(inputPass, savedPass)) {			// 입력 비밀번호(inputpass)와 저장된 비밀번호(savedPass)가 같지 않을경우
			message = "입력하신 비밀번호는 맞지 않습니다.";
			view = "redirect:/nextpage/mypage/delete/checkPass";
			log.info("안맞았니");
		} else {									// 입력 비밀번호(inputpass)와 저장된 비밀번호(savedPass)가 같을경우
			message = "삭제합니다.";
			ServiceResult result = service.removeSchool(schvo);
			if (ServiceResult.OK.equals(result)) {
				redirectAttributes.addFlashAttribute("message", schId + "는 정상적으로 삭제 처리 되었습니다.");
				LogVO inputLog = new LogVO();
				inputLog.setLogHpnId(schId);
				inputLog.setLogTypeId(8);
				inputLog.setLogCntnt("탈퇴");

				ServiceResult loginLog = logService.createLog(inputLog);
				//session.setAttribute("log", log);

				log.info("세션 {}, authSch {}, ",session,loginLog);
				redirectAttributes.addFlashAttribute("message");
				session.invalidate();
				view="redirect:/nextpage/nextPageMain";
			} else {
				redirectAttributes.addFlashAttribute("message", schId + "삭제 처리 실패");
				view = "redirect:/nextpage/mypage/info";
			}
			log.info("아니면 맞은거니?");
		}

		redirectAttributes.addAttribute("message", message);

		log.info("view :{} || message : {}", view, redirectAttributes);

		return view;
	}
}