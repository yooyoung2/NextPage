	package kr.or.ddit.school.manager.teacher.Insert.controller;


/*
 * ★회원 정보를 수정하기 위함
 * -김건호
 */

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.teacher.Insert.service.TeacherInsertService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("school/manager/teacher/update")
public class TeacherUpdateController{

	@Inject
	private TeacherInsertService service;
	SchMemberVO member2 = null;

	//로그체크 구지현
	@Inject
		private LogService logService;


	@PostMapping
	public String doPost(
		@Validated(UpdateGroup.class) @ModelAttribute("email") String email
		, @Validated(UpdateGroup.class) @ModelAttribute("member") SchMemberVO member
		, BindingResult errors
		, Model model
		, HttpSession session

	) {


		String schId=(String) session.getAttribute("authSch");
	 //로그체크 구지현
	        LogVO inputLog = new LogVO();
	        inputLog.setLogHpnId(schId);
	        inputLog.setLogTypeId(4);
	        inputLog.setLogCntnt("선생님정보수정");

	        log.info("선생님정보수정 로그 : "+ inputLog);


		System.out.println("건호"+member);
		if(member.getMemEmail()==null)
		{
			System.out.println("여기로들어왔따1");
			member2 = service.retrieveMember(email);
			model.addAttribute("member", member2);

			return "schoolManager/107_teacherEachInsert/teacherEachUpdate";
		}
		else {
			System.out.println("여기로들어왔따2");
				String logicalViewName = null;

				member.setMemId(member2.getMemId());
				if(!errors.hasErrors()) {
					ServiceResult result = service.modifyMember(member);
					switch (result) {
					case OK:
						ServiceResult loginLog = logService.createLog(inputLog);
						model.addAttribute("msg","교직원 정보수정에 성공하였습니다!");
			            model.addAttribute("url","/school/manager/teacher/insert");
						logicalViewName = "schoolManager/106_teacherInsert/success";
						break;

					default:
						System.out.println("여긴가2");
						model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
						logicalViewName = "schoolManager/107_teacherEachInsert/teacherEachUpdate";
						break;
					}
				}else {
					System.out.println("여긴가3");
					logicalViewName = "schoolManager/107_teacherEachInsert/teacherEachUpdate";
				}
				return logicalViewName;
		}

	}
}






