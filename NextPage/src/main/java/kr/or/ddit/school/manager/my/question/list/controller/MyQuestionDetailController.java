package kr.or.ddit.school.manager.my.question.list.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.my.question.cmmt.service.CmntService;
import kr.or.ddit.school.manager.my.question.list.service.MyQuestionService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.OtoCmntVO;
import lombok.extern.slf4j.Slf4j;

/**
 * schoolManager 1:1문의 게시글 조회
 */

@Slf4j
@Controller
public class MyQuestionDetailController {
	@Inject
	private MyQuestionService service;

	//로그
	@Inject
	private LogService logService;

	// 답변댓글 조회
	@Inject
	private CmntService cmntService;

	/* 1:1 게시글 조회 */

	@RequestMapping(value = "/school/manager/my/question/selectDetailAsk", method = RequestMethod.GET)
	public String detailAsk(@RequestParam(name = "otoBrdNum", required = true) int otoBrdNum, Model model) {
		MyQuestionVO myQuestion = service.selectMyQuestionDetail(otoBrdNum);
		myQuestion.setOtoBrdNum(otoBrdNum);
		model.addAttribute("myQuestion", myQuestion);

		// 답변상세조회
		List<OtoCmntVO> cmnt = cmntService.retrieveCmntList(otoBrdNum);
		model.addAttribute("cmnt", cmnt);

		return "schoolManager/120_selectDetailAsk/selectDetailAsk";
	}

	@RequestMapping(value = "/school/manager/my/question/selectDetailAsk", method = RequestMethod.POST)
	public String myQuestionUpdate(@Validated(UpdateGroup.class) @ModelAttribute("myQuestion") MyQuestionVO myQuestion,
			BindingResult errors, Model model, HttpSession session) {
		String schId = ( String )session.getAttribute( "authSch" );

        // 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(4);
        inputLog.setLogCntnt("문의수정");

		log.info("jsp에서 올라옴(post) : {}", myQuestion);
		String viewName = null;
		if (!errors.hasErrors()) {
			ServiceResult result = service.updateMyQuestion(myQuestion);
			int otoBrdNum = myQuestion.getOtoBrdNum();
			String message = null;

			switch (result) {
			case OK:
				ServiceResult loginLog = logService.createLog(inputLog);
				viewName = "redirect:selectDetailAsk?otoBrdNum="+otoBrdNum;
				break;
			default:
				message = "서버 오류";
				viewName = "schoolManager/120_selectDetailAsk/selectDetailAsk";
				break;
			}
			model.addAttribute("message", message);
		} else {
			System.out.println(errors);
			viewName = "schoolManager/120_selectDetailAsk/selectDetailAsk";
		}
		return viewName;
	}

}
