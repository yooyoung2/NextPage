package kr.or.ddit.nextpage.oto;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.PagingVO;
/**
 * 1:1문의 게시글 보는데!!!!!!!!!!!!!!!!!!!!!!
 *
 */
@Controller
public class otoListController {
	
	@Inject
	private SchoolService service;
	
	@GetMapping("nextpage/myOtoList")
	public String nextPageMyPage(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage
			,HttpSession session
			, Model model
			) {
		
		String schId = (String) session.getAttribute("authSch");
		
		PagingVO<MyQuestionVO> pagingVO = new PagingVO<>();
		pagingVO.setSchId(schId);
		pagingVO.setCurrentPage(currentPage);

		service.retrieveOTOList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "nextpage/mypage/34_nextPageOTO/nextPageOto";
	}
}
