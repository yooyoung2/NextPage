package kr.or.ddit.generation.website.contents.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.content.manage.service.ContentManageService;
import kr.or.ddit.vo.ContentVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * @author PC-04
 *
 */
@Slf4j
@Controller
@RequestMapping( "generation" )
public class ContentsController {	

	@Inject
	ContentManageService contentService;
	
	@RequestMapping( value = "/{id}/contents", method = RequestMethod.GET )
	public String contents(
			@PathVariable("id") String id,
			@RequestParam( name="cntntsId", required = false ) String cntntsId,
			HttpSession session,
			Model model
			) {
		
		log.debug( "======================= ContentsController - contents() [ACTIVATED] =======================" );
		
		
		
		ContentVO content = contentService.getContent( cntntsId ); 
		// VALIDATION CHECK
		if( content != null ) {
			// content가 null이 아닐 경우
			log.debug( "title : {}", content.getCntntsTitle() );
			log.debug( "content : {}", content.getCntntsCntnt() );
			/*
			model.addAttribute( "title" , content.getCntntsTitle() );
			model.addAttribute( "content", content.getCntntsCntnt() );*/
			
			model.addAttribute("content", content);
			
/*			session.setAttribute( "title" , content.getCntntsTitle()  );
			session.setAttribute( "content" , content.getCntntsCntnt() );
*/		}else {
			// content가 null일 경우
			
		}
		
		
		
		
		String viewName = (String) session.getAttribute( "rtrnJsp" ); // return jsp경로
		log.debug( "viewName : {}", viewName );
		
		return viewName;
	}
	
}
