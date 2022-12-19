package kr.or.ddit.generation.website.hello.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.generation.website.other.ViewMaker;
import kr.or.ddit.school.manager.menu.hello.service.MenuHelloService;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.SchGretngVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우 학교인사말
 *
 * @author PC-04
 *
 */

@Slf4j
@Controller
public class GeneratingHelloController {

	//푸터적용
	@Inject
	private FooterService footerService;

	@Inject
	private MenuHelloService service;

	@RequestMapping(value = "generation/{id}/hello", method = RequestMethod.GET)
	public String generatingHello(HttpServletRequest request, @PathVariable("id") String id, Model model,
			HttpSession session) {

		String viewName = (String) session.getAttribute( "rtrnJsp" ); // return jsp경로

		//======================footer 시작==================================
		SchoolVO footer = footerService.selectGenFooter(id);
		model.addAttribute("footer",footer);

		//======================footer 끝==================================

		// 코드 시작 ( 여기다가 해당 컨트롤러만의 기능 짜면 됨 )
		String schId = (String)session.getAttribute("authSch");


		SchGretngVO  hello = service.selectHello( id ); // 여기에 이미지랑 내용 담겨있음

		model.addAttribute("hello",hello);
		// 코드 끝

		return viewName;

	}
}
