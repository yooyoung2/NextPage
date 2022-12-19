package kr.or.ddit.generation.website.image.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.generation.website.other.ViewMaker;
import kr.or.ddit.vo.GeneratingMainVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GeneratingImageBoardController {
	@RequestMapping("generation/{id}/image/board" )
	public String generatingImageBoard(
			HttpServletRequest request,
			@PathVariable("id") String id,
			Model model
			) {
		// 여기부터
				String viewName = null;
				String tempNm = (String) request.getSession().getAttribute("templateId");
				log.info("템플릿 아이디는? {} ",tempNm);
				// 35_generatingMain/generatingMain
				// error/error
				
				String whatYouCallValue = request.getServletPath();
				log.info( "입력한 Generation main url : " + whatYouCallValue );
				
				// DB에서 가져온 정보
				//List<GeneratingMainVO> data = service.getOptionsURL( id );
				
				URLMappingHandler urlM = new URLMappingHandler();
				
				List<GeneratingMainVO> data = urlM.getLinksFromDB( id );
				
				if( data != null && !data.isEmpty() ) {
					if(tempNm.equals("template01")) {
						viewName = "generation/" + tempNm + "/54_generatingImageBoard/generatingImageBoard";
					}
					else if(tempNm.equals("template02")) {
						viewName = "generation/" + tempNm + "/54_generatingImageBoard/generatingImageBoard";
					}
					else if(tempNm.equals("template03")){
						viewName = "generation/" + tempNm + "/54_generatingImageBoard/generatingImageBoard2";
					}
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
