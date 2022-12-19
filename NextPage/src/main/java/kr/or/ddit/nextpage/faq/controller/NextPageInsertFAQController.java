package kr.or.ddit.nextpage.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 넥스트페이지 FAQ 등록
 * @author PC-06
 *
 */

@Slf4j
@Controller
@RequestMapping("nextpage/faqInsert")
public class NextPageInsertFAQController {
	@Inject
	private NextPageFAQService service;

	@Inject
	private LogService logService;

	@ModelAttribute("faq")
	public FaqVO faq() {
		return new FaqVO();
	}

	@GetMapping
	public String doGet(){
		return "nextpage/customerService/23_nextPageFAQ/nextPageFAQForm";
	}

	@PostMapping
	public String doPost(
		@ModelAttribute("faq") FaqVO faq
		, Errors errors
		, Model model
		, HttpSession session
	)
		throws ServletException, IOException{
		String logicalViewName = null;
		String adminId=(String) session.getAttribute("authSch");

		log.info("faq등록 : {}", faq);

        //게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(adminId);
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("FAQ등록");

        log.info("FAQ등록 로그 : "+ inputLog);


	if(!errors.hasErrors()) {
		faq.setAdminId(adminId);
		ServiceResult result = service.createFaq(faq);

		if(ServiceResult.OK.equals(result)) {
			model.addAttribute("faq",result);
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);
			logicalViewName = "redirect:/nextpage/user/faqList";

		}else {
			String message = "등록 실패";
			log.info(message);
			model.addAttribute("message", message);
			logicalViewName = "nextpage/customerService/23_nextPageFAQ/nextPageFAQForm";
		}
	}else {
		String message = "등록 실패2";
		log.info(message);
		System.out.println(errors);
		logicalViewName = "nextpage/customerService/23_nextPageFAQ/nextPageFAQForm";
	}

	return logicalViewName;
}
//		if(!errors.hasErrors()) {
//
//			switch (result) {
//			case OK:
//				logicalViewName = "redirect:/nextpage/user/faqList";
//				break;
//
//			default:
//				model.addAttribute("message", "서버가 불안정합니다. 잠시 후 다시 시도해주세요.");
//				logicalViewName = "nextpage/customerService/23_nextPageFAQ/nextPageFAQForm";
//				break;
//			}
//		}else {
//			logicalViewName = "nextpage/customerService/23_nextPageFAQ/nextPageFAQForm";
//		}
//	}


}
