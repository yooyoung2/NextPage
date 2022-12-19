package kr.or.ddit.generation.website.mypage.password;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.school.schoolMember.service.SchoolMemberService;
import kr.or.ddit.generation.website.mypage.Info.GeneratingMypageUpdateController;
import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("generation/{id}/generatingMyPage")
public class GeneratingPasswordUpdateController {

	@Inject
	private SchoolMemberService service;
	
	// 비밀번호 변경 전에 먼저 체크 하는 폼으로
	@GetMapping("/passwordUpdate")
	public String checkPw(
			@PathVariable("id") String schId
			, HttpSession session
			, Model model
			) {
		SchMemberVO vo = new SchMemberVO();
		String view = null;
		
		String memId = (String) session.getAttribute("authMem");
		
		vo.setSchId(schId);
		vo.setMemId(memId);
		
		model.addAttribute("schMem", vo);
		view = "generation/template01/mypage/44_generatingUpdatePw/generatingMyPageCheckPw";
		
		return view;
	}
	
	// 비밀번호 체크 제출하고 맞을 시에 업데이트 폼으로
	@PostMapping("/passwordOk")
	public String checkPwEnter(
			@RequestParam("memPw") String inputPw
			, HttpSession session
			, Model model
			, RedirectAttributes redirectAttributes
			) {
		
		String view = null;
		String message = null;
		
		String schId = (String) session.getAttribute("id");
		String memId = (String) session.getAttribute("authMem");
		
		SchMemberVO vo = new SchMemberVO();
		
		// 해당 멤버의 아이디와 학교 아이디로 정보를 불러옴
		vo.setSchId(schId);
		vo.setMemId(memId);
		vo.setMemPw(inputPw);
		
		String result = service.authPass(vo);
		
		if(result.equals("true")) {
			log.info("true리턴");
			view = "redirect:/generation/"+schId+"/generatingMyPage/updateForm";
		}else {
			message = "비밀번호가 틀렸습니다.";
			view = "generation/template01/mypage/44_generatingUpdatePw/generatingMyPageCheckPw";
		}
		redirectAttributes.addAttribute("message", message);
		
		return view;
	}
	
	
	// 업데이트 폼 불러오기
	@GetMapping("/updateForm")
	public String updateForm() {
		return "generation/template01/44_generatingUpdatePw/generatingMyPagePasswordUpdate";
	}
	
	
	// 재설정한 비밀번호 아니면 돌아가고 맞으면 로그아웃
	@PostMapping("/updatePassword")
	public String update(
		@RequestParam("memPw") String inputPw
		, HttpSession session
		, RedirectAttributes model
			) {
		log.info("비번 업데이트 시작!");
		ServiceResult result = null;
		
		String view = null;
		String message = null;
		
		String schId = (String) session.getAttribute("id");
		String memId = (String) session.getAttribute("authMem");
		
		SchMemberVO vo = new SchMemberVO();
		
		// 해당 멤버의 아이디와 학교 아이디로 정보를 불러옴
		vo.setSchId(schId);
		vo.setMemId(memId);
		vo.setMemPw(inputPw);
		
		result = service.modifyGenMemPassword(vo);
		switch (result) {
			case OK:
				log.info("변경!!!");
				message = "변경되었습니다.";
				view = "redirect:/generation/"+schId+"/generatingMyPage/view";
				break;
			default:
				log.info("변경실패");
				message = "변경 실패";
				view = "redirect:/generation/"+schId+"/generatingMyPage/updateForm";
				break;
			}		
		model.addFlashAttribute("message", message);
		
		return view;
	}
}
