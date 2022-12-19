package kr.or.ddit.generation.website.mypage.Info;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.school.schoolMember.service.SchoolMemberService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("generation/{id}/generatingMyPage/view")
public class GeneratingMypageUpdateController {
	@Inject
	private SchoolMemberService service;

	@ModelAttribute ("command")
	public String command() {
		return "UPDATE";
	}
	
	@GetMapping()
	public String generatingMyPageGet(
			@PathVariable("id") String schId
			, HttpSession session
			, Model model
			) {
		SchMemberVO vo = new SchMemberVO();
		
		String memId = (String) session.getAttribute("authMem");
		
		vo.setSchId(schId);
		vo.setMemId(memId);
		vo = service.detailMember(vo);
		
		model.addAttribute("schMem", vo);
		return "generation/template01/mypage/43_generatingUpdateInfo/generatingMypageInfoUpdate";
	}

	@PostMapping()
	public String generatingMyPagePost(
			@Validated(UpdateGroup.class) @ModelAttribute("schMem") SchMemberVO vo
			, @PathVariable("id") String id
			, HttpSession session
			, BindingResult errors
			, RedirectAttributes model
			) {
		log.info("update 시작");
		String logicalViewName = null;
		String message = null;
		
		if(!errors.hasErrors()) {
			log.info("에러 없음");
			//String schId = (String) session.getAttribute("id");
			vo.setSchId(id);
			
			ServiceResult result = service.modifyGenMemInfo(vo);
			switch (result) {
			case OK:
				log.info("오께이");
				message = "수정되었습니다";
				logicalViewName = "redirect:/generation/{id}/generatingMyPage/view";
				break;

			default:
				log.info("서버오류 힝");
				message = "서버오류";
				logicalViewName = "generation/generatingMyPage/form";
				break;
			}
		}else {
			log.info("뭐시문젣니미날어ㅣㅓㅁ 왜 에러야~!~!~!");
			logicalViewName = "generation/generatingMyPage/form";
		}
		
		model.addFlashAttribute("message", message);
		return logicalViewName;
		
	}
}
