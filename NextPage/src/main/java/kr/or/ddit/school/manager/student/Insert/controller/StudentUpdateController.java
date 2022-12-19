package kr.or.ddit.school.manager.student.Insert.controller;


/*
 * ★회원 정보를 수정하기 위함
 * -김건호
 */

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.student.Insert.service.StudentInsertService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("school/manager/student/update")
public class StudentUpdateController{

	@Inject
	private StudentInsertService service;
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
		        inputLog.setLogCntnt("신입생수정");

		        log.info("답변 등록 로그 : "+ inputLog);

		System.out.println("건호"+member);
		if(member.getMemEmail()==null)
		{
			System.out.println("여기로들어왔따1");
			member2 = service.retrieveMember(email);
			model.addAttribute("member", member2);

			return "schoolManager/105_studentEachInsert/studentEachUpdate";
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
						model.addAttribute("msg","학생 정보수정에 성공하였습니다!");
			            model.addAttribute("url","/school/manager/student/insert");
						logicalViewName = "schoolManager/104_studentInsert/success";
						break;

					default:
						System.out.println("여긴가2");
						model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
						logicalViewName = "schoolManager/105_studentEachInsert/studentEachUpdate";
						break;
					}
				}else {
					System.out.println("여긴가3");
					logicalViewName = "schoolManager/105_studentEachInsert/studentEachUpdate";
				}
				return logicalViewName;
		}

	}
}






