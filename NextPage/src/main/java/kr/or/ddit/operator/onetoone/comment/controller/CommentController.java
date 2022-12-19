package kr.or.ddit.operator.onetoone.comment.controller;

import java.io.IOException;

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
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.my.question.cmmt.service.CmntService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.OtoCmntVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("operator/cmnt")
public class CommentController {
	@Inject
	private CmntService service;

	@Inject
	private LogService logService;



	@ModelAttribute("cmnt")
	public OtoCmntVO cmnt() {
		return new OtoCmntVO();
	}

	@GetMapping
	public String doGet(
		@RequestParam(name="what", required=true) Integer cmmntId
		, Model model

	){
		log.info("들어오는지????"+cmmntId);

		OtoCmntVO cmnt = service.retrieveCmnt(cmmntId);
		model.addAttribute("cmnt",cmnt);



		log.info("들어오는지????"+cmnt);

		return "operator/18_detailOnetoOneAsk/view/detailOnetoOneAskView";
	}

	//답변등록
	@PostMapping("/insert")
	public String doPost(
		@ModelAttribute("cmnt") OtoCmntVO cmnt
		//,@ModelAttribute("oto") MyQuestionVO myQuestion
		, Errors errors
		, Model model
		, HttpSession session
	)
		throws ServletException, IOException{

		log.info("들어오는지????");

		String logicalViewName = null;
		String adminId=(String) session.getAttribute("authSch");
		Integer otoBrdNum = cmnt.getOtoBrdNum();


        //게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(adminId);
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("답변등록");

        log.info("답변 등록 로그 : "+ inputLog);


	if(!errors.hasErrors()) {
		cmnt.setCmntId(adminId);
		ServiceResult result = service.createCmnt(cmnt);


		if(ServiceResult.OK.equals(result)) {
			model.addAttribute("result",result);

			//로그찍기
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);

			logicalViewName = "redirect:/operator/onetoOneAskDetail?oto=" + otoBrdNum;

		}else {
			String message = "등록 실패";
			log.info(message);
			model.addAttribute("message", message);
			logicalViewName = "operator/18_detailOnetoOneAsk/detailOnetoOneAsk";
		}
	}else {
		String message = "등록 실패2";
		log.info(message);
		System.out.println(errors);
		logicalViewName = "operator/18_detailOnetoOneAsk/detailOnetoOneAsk";
	}

	return logicalViewName;
	}


	//답변수정
	@PostMapping("/modify")
	public String modiCmmntCntnt(
		@ModelAttribute("cmnt") OtoCmntVO cmnt
		, Errors errors
		, Model model
		, HttpSession session
	) {

		Integer otoBrdNum = cmnt.getOtoBrdNum();

		log.info("수정정보가 넘어가나요??"+cmnt);

		String logicalViewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyCmnt(cmnt);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/operator/onetoOneAskDetail?oto=" + otoBrdNum;
				break;

			default:
				model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
				logicalViewName = "operator/18_detailOnetoOneAsk/detailOnetoOneAsk";
				break;
			}
		}else {
			logicalViewName = "operator/18_detailOnetoOneAsk/detailOnetoOneAsk";
		}
		return logicalViewName;
	}


	//답변



}
