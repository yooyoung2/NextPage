package kr.or.ddit.school.manager.my.question.list.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.my.question.list.service.MyQuestionService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.MyQuestionVO;

import lombok.extern.slf4j.Slf4j;
/**
 * schoolManager 1:1문의 게시글 추가
 */

@Slf4j
@Controller/*/NextPage2/src/main/webapp/WEB-INF/views/schoolManager/118_newPostInsert/newPostInsert.jsp*/
@RequestMapping("/school/manager/my/question/newPostInsert")
public class MyQuestionInsertController {
	@Inject
	private MyQuestionService service;

	//로그쳍크
	@Inject
	private LogService logService;


	@ModelAttribute("myQuestion")
	public MyQuestionVO myQuestionboard() {
		log.info("@ModelAttribute 메소드 실행.");
		return new MyQuestionVO();
	}

	@RequestMapping(method=RequestMethod.GET)
	public String newPostInsert() {
		log.info("Get 메소드 실행");
		return "schoolManager/118_newPostInsert/newPostInsert";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String insertMyQuestion(
			@Validated(InsertGroup.class) @ModelAttribute("myQuestion") MyQuestionVO myQuestion
			,Model model
			,Errors errors
			,HttpSession session
			) {

		String schId = ( String )session.getAttribute( "authSch" );
		myQuestion.setSchId(schId);
		String viewName = null;

        // 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("문의등록");

        log.info("학교관리자 문의 등록!!!!"+inputLog);


		if(!errors.hasErrors()) {
			ServiceResult result = service.insertMyQuestion(myQuestion);
			String message =null;

			if(ServiceResult.OK.equals(result)) {
				ServiceResult loginLog = logService.createLog(inputLog);
				viewName = "redirect:myQuestionList";
			}else {
				message="등록 실패 :)ㅎㅎ";
				model.addAttribute("message", message);
				viewName ="redirect:newPostInsert";
			}
		}else {
			System.out.println(errors);
			viewName="redirect:newPostInsert";
		}
		return viewName;
	}




}
