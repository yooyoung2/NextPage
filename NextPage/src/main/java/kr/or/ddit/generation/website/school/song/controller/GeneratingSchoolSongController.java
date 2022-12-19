package kr.or.ddit.generation.website.school.song.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.generation.website.other.ViewMaker;
import kr.or.ddit.school.manager.song.service.SchoolSongService;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.SchoolSongVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GeneratingSchoolSongController {
	@Inject
	private SchoolSongService service;


	//푸터적용
	@Inject
	private FooterService footerService;

	@RequestMapping( "generation/{id}/school/song" )
	public String generatingSchoolSong(
			HttpServletRequest request,
			HttpSession session,
			@PathVariable("id") String id,
			Model model
			) {
		// 여기부터
		String viewName = null;
		// 35_generatingMain/generatingMain
		// error/error

		//======================footer 시작==================================
		SchoolVO footer = footerService.selectGenFooter(id);
		model.addAttribute("footer",footer);

		//======================footer 끝==================================

		String whatYouCallValue = request.getServletPath();
		log.info( "입력한 Generation main url : " + whatYouCallValue );

		String schId = (String)session.getAttribute("authSch");
		SchoolSongVO song = service.retrieveSong(id);

		model.addAttribute("song",song);

		String templateId = (String) session.getAttribute( "templateId" );

		if( templateId != null ) {
			if( templateId.equals( "TMPLT001" ) ) {
				templateId = "template01";
			}else if( templateId.equals( "TMPLT002" ) ) {
				templateId = "template02";
			}
			viewName = "generation/" + templateId + "/53_generatingSchoolSong/generatingSchoolSong";
		}else {
			log.debug( "templateId is NULL" );
			viewName = "error/error";
		}
		
	

		model.addAttribute( "id", id ); // 현재 접속한 사이트 주인의 아이디

	/*	ViewMaker viewMaker = new ViewMaker( data );
		String view = viewMaker.headerViewMaker( id, data );
		model.addAttribute( "view", view );*/

		return viewName;
		// 여기까지 viewName빼고 공통사항

	}


}
