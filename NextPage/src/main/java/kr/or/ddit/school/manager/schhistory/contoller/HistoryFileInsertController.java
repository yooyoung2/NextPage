package kr.or.ddit.school.manager.schhistory.contoller;

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
import kr.or.ddit.school.manager.schhistory.service.SchoolHistroyService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.SchMemberFileListVO;
import kr.or.ddit.vo.SchoolHistoryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/*
 * ★파일등록을 위함
 * -김건호
 */
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("school/manager/history/fileInsert")
public class HistoryFileInsertController {
	private final SchoolHistroyService service;
	@Inject
	private WebApplicationContext context;
	
	@ModelAttribute("board")
	public SchoolHistoryVO board() {
		log.info("@ModelAttribute 메소드 실행.");
		return new SchoolHistoryVO();
	}
	
	@GetMapping
	public String boardForm() {
		log.info("Get 메소드 핸들러 boardForm 실행");
		return "schoolManager/81_82_historyInsertAll/InsertFile";
	}
	
//	@PostMapping
//	public String boardInsert(
//		@Validated(InsertGroup.class) @ModelAttribute("board") SchoolHistoryVO board
//		, Errors errors
//		, Model model
//	) { 
//		
//		log.info("Post 메소드 핸들러 boardInsert 실행");
//		String viewName = null;
//		if(!errors.hasErrors()) {
//			ServiceResult result = service.insertHistory(board);
//			if(ServiceResult.OK.equals(result)) {
//				viewName = "redirect:/schoolManager/102_studentClassInsert/InsertFile.jsp";
//			}else {
//				String message = "등록 실패";
//				model.addAttribute("message", message);
//				viewName = "schoolManager/102_studentClassInsert/studentClassInsert";
//			}
//		}else {
//			viewName = "schoolManager/102_studentClassInsert/studentClassInsert";
//		}
//		
//		
//		return viewName;
//	}
}

