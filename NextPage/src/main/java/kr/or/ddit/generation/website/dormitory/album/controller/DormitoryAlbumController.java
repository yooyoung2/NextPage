package kr.or.ddit.generation.website.dormitory.album.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.generation.website.hello.controller.GeneratingHelloController;
import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.generation.website.other.ViewMaker;
import kr.or.ddit.vo.GeneratingMainVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 기능 : 제너레이션 해더 링크 / 기숙사 앨범
 * @author PC-04
 *
 */
@Slf4j
@Controller
public class DormitoryAlbumController {

	@RequestMapping( value = "generation/{id}/dormitory/album", method = RequestMethod.GET )
	public String dormitoryAlbum(
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
					viewName = "generation/template01/47_generatingHello/generatingHello";
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
