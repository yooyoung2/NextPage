package kr.or.ddit.operator.history.log.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 로그분석 컨트롤러
 *
 */
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("operator")
public class LogController {

	private final LogService service;
	// 로그인/로그아웃 기록
//	@GetMapping(value="/login_logout_log")
//	public String logList(
//		 Model model
//	){
//		List<LogVO> logList = service.selectAllLog();
//
//		model.addAttribute("logList", logList);
//
//		return "operator/14_login_logout_log/login_logout_log";
//	}

	@GetMapping(value="/login_logout_log")
	public String selectLog(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@ModelAttribute("simpleCondition") SearchVO simpleCondition,
			Model model
	){

		PagingVO<LogVO>pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);


		//전체로그리스트
		List<LogVO> logList = service.selectAllLog(pagingVO);
		pagingVO.setDataList(logList);
		model.addAttribute("pagingVO",pagingVO );

		//타입별 로그리스트
//		List<LogVO> login = service.retrieveLog(logTypeId);
//		List<LogVO> logout = service.retrieveLog(2);
//		List<LogVO> logInsert = service.retrieveLog(3);
//		List<LogVO> logModi = service.retrieveLog(4);
//		List<LogVO> logDel = service.retrieveLog(5);
//		List<LogVO> logPay = service.retrieveLog(6);
//		List<LogVO> logPayCancle = service.retrieveLog(7);
//		List<LogVO> logSecs = service.retrieveLog(8);
//
//
//		model.addAttribute("logList", logList);
//
//		model.addAttribute("login", login);
//		model.addAttribute("logout", logout);
//		model.addAttribute("logInsert", logInsert);
//		model.addAttribute("logModi", logModi);
//		model.addAttribute("logDel", logDel);
//		model.addAttribute("logPay", logPay);
//		model.addAttribute("logPayCancle", logPayCancle);
//		model.addAttribute("logSecs", logSecs);

		return "operator/14_login_logout_log/login_logout_log";
	}



}
