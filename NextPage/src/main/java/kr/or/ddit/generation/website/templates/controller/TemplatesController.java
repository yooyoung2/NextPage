package kr.or.ddit.generation.website.templates.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.generation.website.templates.service.TemplatesService;
import kr.or.ddit.vo.TemplatesVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TemplatesController {

	@Inject
	TemplatesService service;
	
	@RequestMapping( value = "youyoung.do", method = RequestMethod.GET )
	public String getTemplate( Model model ) {
		
		TemplatesVO vo = service.getFooter( "tmp" );
		
		model.addAttribute( "vo", vo );
		
		String viewName = "test";
		
		
		
		
		return viewName;
	}
	
	
}
