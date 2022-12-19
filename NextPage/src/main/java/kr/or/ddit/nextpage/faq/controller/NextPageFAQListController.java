package kr.or.ddit.nextpage.faq.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.nextpage.faq.service.NextPageFAQService;
import kr.or.ddit.vo.FaqVO;
import kr.or.ddit.vo.PagingVO;

/**
 * 넥스트페이지 FAQ 전체리스트조회
 * @author PC-06
 *
 */

@Controller
public class NextPageFAQListController {
	@Inject
	private NextPageFAQService service;

	@RequestMapping("nextpage/user/faqList")
	public String faqList(
		@RequestParam(name="page", required=true, defaultValue="1") int currentPage
		, Model model
	) {

		PagingVO<FaqVO> pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);

		List<FaqVO> faqList = service.retrieveFaqList(pagingVO);
		pagingVO.setDataList(faqList);

		model.addAttribute("pagingVO",pagingVO);

	return "nextpage/customerService/23_nextPageFAQ/nextPageFAQLIst";
	}

}
