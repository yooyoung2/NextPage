package kr.or.ddit.generation.website.school.online.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.generation.website.other.ViewMaker;
import kr.or.ddit.vo.GeneratingMainVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SchoolOnlineController {

	@RequestMapping( value = "generation/{id}/school/online" , method = RequestMethod.GET )
	public String schoolOnline(
			HttpServletRequest request,
			@PathVariable("id") String id,
			Model model
			) {
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
				
			
				
				
				if( data != null && !data.isEmpty() ) {
					viewName = "generation/template01/53_generatingSchoolSong/generatingSchoolSong";
				}else {
					viewName = "error/error";
				}
				
				model.addAttribute( "id", id ); // 현재 접속한 사이트 주인의 아이디
				
				/*ViewMaker viewMaker = new ViewMaker( data );
				String view = viewMaker.headerViewMaker( id, data );
				model.addAttribute( "view", view );*/
				
				return viewName;
				// 여기까지 viewName빼고 공통사항
		
	}
	
}
