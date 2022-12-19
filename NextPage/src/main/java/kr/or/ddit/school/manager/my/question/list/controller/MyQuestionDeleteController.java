package kr.or.ddit.school.manager.my.question.list.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.my.question.list.service.MyQuestionService;
import kr.or.ddit.vo.LogVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/school/manager/my/question/postDelete")
public class MyQuestionDeleteController {

	@Inject
	private MyQuestionService service;


	@Inject
	private LogService logService;

	  @GetMapping
	   public String memberDelete(
	      @RequestParam(name="what", required=true) Integer otoBrdNum
	      , RedirectAttributes redirectAttributes
	      ,HttpSession session
	   ){
	      ServiceResult result = service.deleteMyQuestion(otoBrdNum);

	      String schId = (String) session.getAttribute("authSch");

	      //게시물삭제 로그체크 구지현
	      LogVO inputLog = new LogVO();
	      inputLog.setLogHpnId(schId);
	      inputLog.setLogTypeId(5);
	      inputLog.setLogCntnt("문의삭제");

	      String viewName = null;

	      if(ServiceResult.OK.equals(result)) {
		      ServiceResult loginLog = logService.createLog(inputLog);
	         viewName = "redirect:myQuestionList";
	      }else {
	         redirectAttributes.addFlashAttribute("message", otoBrdNum + "삭제 처리 실패");
	         viewName = "redirect:myQuestionList";
	      }
	      return viewName;
	   }
	}