package kr.or.ddit.school.manager.teacher.Insert.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.teacher.Insert.service.TeacherFileDownService;
import kr.or.ddit.vo.SchMemberFileVO;

/*
 * ★양식 다운로드를 위함
 * -김건호
 * 
 */
@Controller
public class AttatchDownloadController2 {
	@Inject
	private TeacherFileDownService service;
	
	
	@RequestMapping("ftpdown")
	public String download(
		@RequestParam(name="what", required=true) int attNo
		, Model model
	)throws IOException {
		SchMemberFileVO attatch = service.ftpdown(attNo);
		model.addAttribute("attatch", attatch);
		return "downloadView3";
	}
}

















