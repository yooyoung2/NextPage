package kr.or.ddit.operator.select.authority.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.operator.select.authority.service.SelectAuthorityService;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SelectAuthorityController {

	@Inject
	private SelectAuthorityService service;

	@RequestMapping("operator/selectAuthority")
	public String SelectAuthority(
		@RequestParam(name="page", required=true, defaultValue="1") int currentPage,
		@ModelAttribute("simpleCondition") SearchVO simpleCondition,
		Model model

	) {
		String viewName = null;

		PagingVO<NpMemberVO>pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);

		log.info( pagingVO+"컨틀롤러에서 널ㅇ???" );

		List<NpMemberVO> npMem = service.selectAllMemAuth(pagingVO);
		log.info( "권한리스트조회11111111!!." );
		pagingVO.setDataList(npMem);

		log.info( "권한리스트조회2222222222!!." );
		viewName = "operator/05_selectAuthority/selectAuthority";
		model.addAttribute( "pagingVO", pagingVO );


		return viewName;

	}
}
