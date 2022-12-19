package kr.or.ddit.nextpage.faq.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.faq.service.NextPageFAQService;
import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.vo.FaqVO;
import kr.or.ddit.vo.LogVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * faq삭제
 * @author PC-06
 *
 */


@Slf4j
@Controller
@RequiredArgsConstructor

public class NextPageFAQDeleteController {


	private final NextPageFAQService service;

	@Inject
	private LogService logService;

	   @GetMapping("nextpage/faqDelete")
	   public String memberDelete(
	      @RequestParam(name="what", required=true) Integer faqId
	      , RedirectAttributes redirectAttributes
	      ,HttpSession session
	   ){

		   String adminId = (String) session.getAttribute("authSch");

	        //게시물삭제 로그체크 구지현
	        LogVO inputLog = new LogVO();
	        inputLog.setLogHpnId(adminId);
	        inputLog.setLogTypeId(5);
	        inputLog.setLogCntnt("FAQ삭제");

	        log.info("log가져와라고~~~~"+inputLog);



		  FaqVO faq = new FaqVO();
		  faq.setFaqId(faqId);

	      ServiceResult result = service.deleteFaq(faq);
	      ServiceResult loginLog = logService.createLog(inputLog);

	      log.info("faq삭제키 가져와? " +faqId);

	      String viewName = null;

	      if(ServiceResult.OK.equals(result)) {
	         viewName = "redirect:/nextpage/user/faqList";
	      }else {
	         redirectAttributes.addFlashAttribute("message", faqId + "삭제 처리 실패");
	         viewName = "redirect:/nextpage/user/faqList";
	      }
	      return viewName;
	   }
}
