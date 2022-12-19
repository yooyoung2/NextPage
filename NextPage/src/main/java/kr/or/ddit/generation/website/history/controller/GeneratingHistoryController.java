package kr.or.ddit.generation.website.history.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.school.manager.schhistory.service.SchoolHistroyService;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.SchoolHistoryVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 학교연혁
 * @author PC-04
 *
 */
@Slf4j
@Controller
public class GeneratingHistoryController {

	//푸터적용
	@Inject
	private FooterService footerService;

	@Inject
	private SchoolHistroyService schService;
	
	@RequestMapping( "generation/{id}/history" )
	public String generatingHistory(
			HttpServletRequest request,
			@PathVariable("id") String id,
			Model model,
			HttpSession session
			) {
				String viewName = (String) session.getAttribute( "rtrnJsp" );

				//======================footer 시작==================================
				SchoolVO footer = footerService.selectGenFooter(id);
				model.addAttribute("footer",footer);

				//======================footer 끝==================================

				// 코드 시작 ( 여기다가 해당 컨트롤러만의 기능 짜면 됨 )
				List<SchoolHistoryVO> schHistoryList = schService.selectSchHistoryList(id) ;
				
				model.addAttribute("schHistoryList", schHistoryList);
				// 코드 끝

				return viewName;

	}

}
