package kr.or.ddit.generation.website.direction.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.ontheway.service.SchoolOnTheWayService;
import kr.or.ddit.vo.GenDrctnVO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GenerationDirectionController {
	@Inject
	private SchoolOnTheWayService service;



	//푸터적용
	@Inject
	private FooterService footerService;



	@RequestMapping( value = "generation/{id}/direction" , method = RequestMethod.GET )
	public String generationDirection(
			HttpServletRequest request,
			@PathVariable("id") String id,
			Model model,
			HttpSession session
			) {
		/*// 여기부터
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
			viewName = "generation/template01/60_generatingDirection/generatingDirection";
		}else {
			viewName = "error/error";
		}

		model.addAttribute( "id", id ); // 현재 접속한 사이트 주인의 아이디

		ViewMaker viewMaker = new ViewMaker( data );
		String view = viewMaker.headerViewMaker( id, data );
		model.addAttribute( "view", view );

		return viewName;*/


		//======================footer 시작==================================
		SchoolVO footer = footerService.selectGenFooter(id);
		model.addAttribute("footer",footer);

//======================footer 끝==================================

		String viewName = (String) session.getAttribute( "rtrnJsp" );

		// 코드 시작 ( 여기다가 해당 컨트롤러만의 기능 짜면 됨 )

		log.info("model에 담긴 값은? : {}",model );

		GenDrctnVO map = service.retrieveMap(id);

		model.addAttribute("map",map);
		log.info("model에 담긴 값은? : {}",model );

		// 코드 끝

		return viewName;


	}

}
