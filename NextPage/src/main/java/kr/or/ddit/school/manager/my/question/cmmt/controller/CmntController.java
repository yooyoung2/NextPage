package kr.or.ddit.school.manager.my.question.cmmt.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.WebSocketHandler;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.my.question.cmmt.service.CmntService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.OtoCmntVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("school/manager/my/question")
public class CmntController {
	@Autowired
	private WebSocketHandler websocketHandler;

	@Inject
	private CmntService service;

	@Inject
	private LogService logService;

	@ModelAttribute("cmnt")
	public OtoCmntVO cmnt() {
		return new OtoCmntVO();
	}

	@GetMapping
	public String doGet(){
		log.info("들어오는지????");
		return "schoolManager/120_selectDetailAsk/selectDetailAsk";
	}

//답변등록
	@PostMapping("/insert")
	public String doPost(
		@ModelAttribute("cmnt") OtoCmntVO cmnt
		, Errors errors
		, Model model
		, HttpSession session
	)
		throws ServletException, IOException{

		log.info("들어오는지????");

		String logicalViewName = null;
		String schId=(String) session.getAttribute("authSch");
		Integer otoBrdNum = cmnt.getOtoBrdNum();

        //게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("문의댓글등록");

        log.info("답변 등록 로그 : "+ inputLog);


	if(!errors.hasErrors()) {
		cmnt.setCmntId(schId);
		ServiceResult result = service.createCmnt(cmnt);

		if(ServiceResult.OK.equals(result)) {
			model.addAttribute("result",result);
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);



			logicalViewName = "redirect:/school/manager/my/question/selectDetailAsk?otoBrdNum=" + otoBrdNum;

		}else {
			String message = "등록 실패";
			log.info(message);
			model.addAttribute("message", message);
			logicalViewName = "schoolManager/120_selectDetailAsk/selectDetailAsk";
		}
	}else {
		String message = "등록 실패2";
		log.info(message);
		System.out.println(errors);
		logicalViewName = "schoolManager/120_selectDetailAsk/selectDetailAsk";
	}

	return logicalViewName;
	}


}