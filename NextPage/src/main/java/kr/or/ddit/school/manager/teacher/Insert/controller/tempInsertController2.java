package kr.or.ddit.school.manager.teacher.Insert.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.teacher.Insert.service.TeacherFileService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.SchMemberFileListVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/*
 * ★파일등록을 위함
 * -김건호
 */
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("ftpupload")
public class tempInsertController2 {
	private final TeacherFileService service;
	@Inject
	private WebApplicationContext context;
	
	@ModelAttribute("board")
	public SchMemberFileListVO board() {
		log.info("@ModelAttribute 메소드 실행.");
		return new SchMemberFileListVO();
	}
	
	@GetMapping
	public String boardForm() {
		log.info("Get 메소드 핸들러 boardForm 실행");
		return "schoolManager/106_teacherInsert/tempInsertFile";
	}
	
	@PostMapping
	public String boardInsert(
		@Validated(InsertGroup.class) @ModelAttribute("board") SchMemberFileListVO board
		, Errors errors
		, Model model
	) {
		
		log.info("Post 메소드 핸들러 boardInsert 실행");
		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createBoard222(board);
			if(ServiceResult.OK.equals(result)) {
				viewName = "redirect:/schoolManager/106_teacherInsert/InsertFile.jsp";
			}else {
				String message = "등록 실패";
				model.addAttribute("message", message);
				viewName = "schoolManager/106_teacherInsert/teacherInsert";
			}
		}else {
			viewName = "schoolManager/106_teacherInsert/teacherInsert";
		}
		
		
		return viewName;
	}
}

