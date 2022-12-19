package kr.or.ddit.school.manager.history.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.history.service.GenLogService;
import kr.or.ddit.vo.GenRCRDVO;
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
@RequestMapping("/school/manager/Log")
public class GenLogController {

	private final GenLogService service;



	@GetMapping
	public String selectLog(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@ModelAttribute("simpleCondition") SearchVO simpleCondition,
			Model model,
			HttpSession session

	){

		String schId = (String) session.getAttribute("authSch");

		PagingVO<GenRCRDVO>pagingVO = new PagingVO<>();
		pagingVO.setSchId(schId);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);


		//전체로그리스트
		List<GenRCRDVO> logList = service.selectAllLog(pagingVO);
		pagingVO.setDataList(logList);
		model.addAttribute("pagingVO",pagingVO );

		return "schoolManager/95_memberHistory/memberHistory";
	}



}
