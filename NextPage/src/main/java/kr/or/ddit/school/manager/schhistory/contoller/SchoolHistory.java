package kr.or.ddit.school.manager.schhistory.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.schhistory.service.SchoolHistroyService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolHistoryVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class SchoolHistory {
		@Inject
		private SchoolHistroyService service;
		
	@RequestMapping("/school/manager/schoolHistory")
	public String selectDetailAsk(
			@ModelAttribute("simpleCondition") SearchVO simpleCondition
			, @RequestParam(name="page", required=false, defaultValue="1") int currentPage
			, Model model
			, HttpSession session
			) {
		
//		PagingVO<SchMemberVO> pagingVO = new PagingVO<>(10,10);
//		pagingVO.setCurrentPage(currentPage);
//		pagingVO.setSimpleCondition(simpleCondition);
//		pagingVO.setSchId((String)session.getAttribute("authSch"));
//		
//		
//		
//		int totalRecord = service.retrieveMemberCount(pagingVO);
//		pagingVO.setTotalRecord(totalRecord);
//		List<SchMemberVO> memberList = service.retrieveMemberList(pagingVO);
		String schId=(String)session.getAttribute("authSch");
		List<SchoolHistoryVO> histList= service.selectHistList(schId);
		System.out.println(histList+"받아와지는군");
		
		
		model.addAttribute("histList", histList);
		
		
		return "schoolManager/81_82_historyInsertAll/historyInsertAll";

	}
}
