package kr.or.ddit.generation.website.edu.purpose.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GeneratingEduPurposeController {
	@RequestMapping( "generation/{id}/contents" )
	public String generatingEduPurpose(
			HttpServletRequest request,
			@PathVariable("id") String id,
			Model model,
			HttpSession session
			) {
		String viewName = (String) session.getAttribute( "rtrnJsp" );
		
		// 코드 시작 ( 여기다가 해당 컨트롤러만의 기능 짜면 됨 )
		
		// 코드 끝
		
		return viewName;

		
	}

}
