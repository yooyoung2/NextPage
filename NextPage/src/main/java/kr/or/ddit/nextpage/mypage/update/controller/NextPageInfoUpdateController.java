package kr.or.ddit.nextpage.mypage.update.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;
/**
 * 정보 수정 폼 불러오고
 * 제출해서 업데이트하는데
 *
 */

@Slf4j
@Controller
@RequestMapping("nextpage/mypage")
public class NextPageInfoUpdateController {

	@Inject
	private SchoolService service;
	
	@GetMapping ("/updateAccountForm")
	public String nextPageUpdateForm(
			HttpSession session
			, Model model
			) {
		String schId = (String) session.getAttribute("authSch");
		
		SchoolVO schvo = service.retrieveSchoolInfo(schId);
		
		model.addAttribute("schInfo", schvo);
		
		return "nextpage/mypage/26_nextPageMyPageUpdate/nextPageMyInfoUpdate";
	}

	@PostMapping("/updateAccount")
	public String nextPageUpdate(
			@Validated(UpdateGroup.class) @ModelAttribute("schInfo") SchoolVO vo
			, BindingResult errors
			, Model model
			, HttpSession session
			) {
		log.info("들어는 와주셨습니까");
		
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			log.info("에러는 없으셨군요");
			ServiceResult result = service.modifySchool(vo);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/nextpage/mypage/info";
				log.info("에러없이 OK");
				break;

			default:
				model.addAttribute("message", "서버 오류");
				logicalViewName = "redirect:/nextpage/mypage/updateAccountForm";
				log.info("에러는 없는데 서버가 에바");
				break;
			}
		}else {
			logicalViewName = "redirect:/nextpage/mypage/updateAccountForm";
			log.info("에러 그득하니");
			log.info("에러가 뭐죠? : {}",errors);
		}
		return logicalViewName;
	}

}
