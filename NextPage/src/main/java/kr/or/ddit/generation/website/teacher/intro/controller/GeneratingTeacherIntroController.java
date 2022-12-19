package kr.or.ddit.generation.website.teacher.intro.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GeneratingTeacherIntroController {

	//푸터적용
	@Inject
	private FooterService footerService;

	@RequestMapping( "generation/{id}/teacher/intro" )
	public String generatingTeacherIntro(
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

		// 코드 끝

		return viewName;


	}

}

