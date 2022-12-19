package kr.or.ddit.nextpage.faq.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.faq.service.NextPageFAQService;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.vo.FaqVO;
import kr.or.ddit.vo.LogVO;
import lombok.extern.slf4j.Slf4j;

/**
 * faq 상세페이지 조회, 수정
 * @author PC-06
 *
 */

@Slf4j
@Controller
@RequestMapping("nextpage/FaqUpdate")
public class NextPageFAQUpdateController {

	@Inject
	private NextPageFAQService service;


	@Inject
	private LogService logService;

	//상세페이지조회
	@GetMapping
	public String doGet(
		@RequestParam(name="what", required=true) Integer faqId
		, Model model

	){

		FaqVO faq = service.retrieveFaq(faqId);
		System.out.println(faq+"임다");
		model.addAttribute("faq", faq);
		return "nextpage/customerService/23_nextPageFAQ/nextPageFAQView";

	}

	//faq 수정
	@PostMapping
	public String doPost(
		@ModelAttribute("faq") FaqVO faq
		, BindingResult errors
		, Model model
		,HttpSession session
	) {


		log.info("수정된faq"+faq);

		String adminId = (String) session.getAttribute("authSch");

        //게시물삭제 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(adminId);
        inputLog.setLogTypeId(4);
        inputLog.setLogCntnt("FAQ수정");

		String logicalViewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyFaq(faq);
			switch (result) {
			case OK:
				ServiceResult loginLog = logService.createLog(inputLog);
				logicalViewName = "redirect:/nextpage/user/faqList";
				break;

			default:
				model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
				logicalViewName = "nextpage/FaqView";
				break;
			}
		}else {
			logicalViewName = "nextpage/FaqView";
		}
		return logicalViewName;
	}


}
