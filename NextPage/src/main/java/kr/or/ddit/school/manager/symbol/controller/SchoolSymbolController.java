package kr.or.ddit.school.manager.symbol.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.symbol.service.SchoolSymbolService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchSymbVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/school/manager")
public class SchoolSymbolController {

	@Inject
	private SchoolSymbolService service;

	@Inject
	private LogService logService;


	@GetMapping("/school/symbol")
	public String schoolSymbol(HttpSession session, Model model) {
		String schId = (String)session.getAttribute("authSch");
		SchSymbVO symb = service.retrieveSymbol(schId);

		model.addAttribute("symb",symb);

		return "schoolManager/83_schoolSymbol/schoolSymbol";
	}

	@PostMapping("/symbol/insert")
	@ResponseBody
	public String schoolSymbInsert(@RequestBody SchSymbVO symb, HttpSession session) {
		String schId = (String)session.getAttribute("authSch");
		symb.setSchId(schId);


		//게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(symb.getSchId());
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("학교상징등록");

		ServiceResult result = service.createSymb(symb);

		if(result.OK.equals(result)) {
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);

			return "ok";
		}else {
			String message = "등록 실패";
			log.info(message);
			return "no";
		}

	}

	@PostMapping("/symbol/modify")
	@ResponseBody
	public String schoolSymbmodify(@RequestBody SchSymbVO symb, HttpSession session) {
		String schId = (String)session.getAttribute("authSch");
		symb.setSchId(schId);
		
		log.info("올라온데이터!!! : {}", symb);
		
		//게시물수정 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(symb.getSchId());
        inputLog.setLogTypeId(4);
        inputLog.setLogCntnt("학교상징수정");

		ServiceResult result = service.modifySymb(symb);

		if(result.OK.equals(result)) {
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);
			return "ok";

		}else {
			String message = "no";
			log.info(message);
			return "message";
		}

	}
}
