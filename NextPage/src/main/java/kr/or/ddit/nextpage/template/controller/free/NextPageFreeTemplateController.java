package kr.or.ddit.nextpage.template.controller.free;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.nextpage.template.service.nextpageTemplateService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.genTemplateVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NextPageFreeTemplateController {

	@Inject
	public nextpageTemplateService service;
	
	@RequestMapping( value = "nextpage/template/free.do", method = RequestMethod.GET )
	public String nextPageFreeTemplate(
			@RequestParam (name="page", required=true, defaultValue="1") int currentPage,
			Model model
			) {
		
		
		String viewName = null;
		String message = null;
		
		PagingVO<genTemplateVO> pagingvo = new PagingVO<>(6,3);
		pagingvo.setCurrentPage(currentPage);
		
		List<genTemplateVO> templateList = service.selectFreeTemplateList(pagingvo);
		
		pagingvo.setDataList(templateList);
		
		
		
		if (templateList != null && !templateList.isEmpty()) {
			viewName = "nextpage/14_nextPageFreeTemplate/nextPageFreeTemplate";
			model.addAttribute("pagingvo", pagingvo);
		}else {
			viewName = "nextpage/14_nextPageFreeTemplate/nextPageFreeTemplate";
			message = "템플릿이 없습니다!!ㅠㅠ";
			model.addAttribute("message", message);
		}
		
		return viewName;
	
	}
}