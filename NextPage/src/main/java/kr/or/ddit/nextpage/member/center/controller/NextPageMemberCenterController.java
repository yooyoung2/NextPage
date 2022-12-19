package kr.or.ddit.nextpage.member.center.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.vo.NoticeBoardVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 넥스트페이지 공지사항
 *
 * @author PC-06
 *
 */
@Slf4j
@Controller
public class NextPageMemberCenterController {

	@Inject
	private NextPageMemberCenterService service;


	@RequestMapping(value = "nextpage/service/memcenter.do", method = RequestMethod.GET)
	public String nextPageMemberCenter(
			@RequestParam(name = "page", required = true, defaultValue = "1") int currentPage,
			 Model model) {

		PagingVO<NoticeBoardVO> pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);

		List<NoticeBoardVO> notiBoardList = service.selectNotiBoardList(pagingVO);
		pagingVO.setDataList(notiBoardList);

		model.addAttribute("pagingVO",pagingVO );
		String view = "nextpage/customerService/22_nextPageMemberCenter/nextPageMemberCenter";
		return view;

	}

}
