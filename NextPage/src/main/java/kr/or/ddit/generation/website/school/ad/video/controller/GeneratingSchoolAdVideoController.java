package kr.or.ddit.generation.website.school.ad.video.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * @author PC-04
 *
 */

@Slf4j
@Controller
public class GeneratingSchoolAdVideoController {

	//푸터적용
	@Inject
	private FooterService footerService;

	@RequestMapping( value = "generation/{id}/ad/video", method = RequestMethod.GET )
	public String generationSchoolAdVideo(
			HttpServletRequest request,
			@PathVariable("id") String id,
			Model model
			) {

		//======================footer 시작==================================
		SchoolVO footer = footerService.selectGenFooter(id);
		model.addAttribute("footer",footer);

		//======================footer 끝==================================



		// 여기부터
		String viewName = null;
		// 35_generatingMain/generatingMain
		// error/error

		String whatYouCallValue = request.getServletPath();
		log.info( "입력한 Generation main url : " + whatYouCallValue );

		// DB에서 가져온 정보
		//List<GeneratingMainVO> data = service.getOptionsURL( id );

		URLMappingHandler urlM = new URLMappingHandler();

		List<GeneratingMainVO> data = urlM.getLinksFromDB( id );

		// key : 메뉴이름, value : 메뉴아이디 ( 메뉴 이름만 알면 메뉴 아이디를 알 수 있다. )
		Map<String, String> getMenuIdByName = null;
		// key : 메뉴이름, value : 링크 ( 메뉴 이름만 알면 메뉴 링크를 알 수 있다. )
		Map<String, String> getMenuLinkByName = null;
		/**
		 * 작성자 : 최현우
		 * key값을 이름으로 준 이유는 메뉴 아이디를 하나하나 외우고 있기도 힘들고 사이트마다 아이디가
		 * 달라질테고, 링크도 외우고 있기가 힘들어서 공통적이고 외우기 시운 메뉴이름을 key값으로 정함.
		 */


		if( data != null && !data.isEmpty() ) {
			getMenuIdByName = urlM.getMenuIdByName( data );
			getMenuLinkByName = urlM.getMenuLinkByName( data );
			viewName = "35_generatingMain/generatingMain";
		}else {
			viewName = "error/error";
		}

		model.addAttribute( "id", id ); // 현재 접속한 사이트 주인의 아이디
		model.addAttribute( "getMenuIdByName", getMenuIdByName );
		model.addAttribute( "getMenuLinkByName", getMenuLinkByName );

		return viewName;
		// 여기까지 viewName빼고 공통사항

	}

}
