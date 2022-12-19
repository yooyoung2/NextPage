package kr.or.ddit.school.manager.my.question.list.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.school.manager.my.question.list.service.MyQuestionService;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;
/**
 * schoolManager 1:1문의 리스트 
 */

@Slf4j
@Controller
@RequestMapping("/school/manager/my/question")
public class MyQuestionListController {
	@Inject
	private MyQuestionService service;

	@RequestMapping(value="myQuestionList", method=RequestMethod.GET)
	public String listUI() {
		return "schoolManager/117_myQuestionList/myQuestionList";
	}
	
	@RequestMapping(value="myQuestionList", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	PagingVO<MyQuestionVO> myQuestion(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@ModelAttribute("simpleCondition") SearchVO simpleCondition, Model model, HttpSession session) {
		String schId = (String) session.getAttribute("authSch");

		PagingVO<MyQuestionVO> pagingVO = new PagingVO<>();
		pagingVO.setSchId(schId);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);
		int totalRecord = service.retrieveMyQuestionCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<MyQuestionVO> otoList = service.selectMyQuestionList(pagingVO);
		pagingVO.setDataList(otoList);

		return pagingVO;
	}
	
		
		
}
