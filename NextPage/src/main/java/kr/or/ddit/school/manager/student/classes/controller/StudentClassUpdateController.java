	package kr.or.ddit.school.manager.student.classes.controller;


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
import kr.or.ddit.school.manager.student.classes.service.StudentClassInsertService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.LogVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("school/manager/studentClass/update")
public class StudentClassUpdateController{

	@Inject
	private StudentClassInsertService service;
	ClassMemVO member2 = null;

	//로그체크 구지현
	@Inject
		private LogService logService;

	@PostMapping
	public String doPost(
		@Validated(UpdateGroup.class) @ModelAttribute("numberId") String numberId
		, @Validated(UpdateGroup.class) @ModelAttribute("member") ClassMemVO member
		, BindingResult errors
		, Model model
		, HttpSession session

	) {

		String schId=(String) session.getAttribute("authSch");
		 //로그체크 구지현
		        LogVO inputLog = new LogVO();
		        inputLog.setLogHpnId(schId);
		        inputLog.setLogTypeId(4);
		        inputLog.setLogCntnt("학년/반 수정");

		        log.info("학년/반 수정 로그 : "+ inputLog);

		System.out.println("건호"+member);
		if(member.getMemId()==null)
		{
			System.out.println("여기로들어왔따1");
			member2 = service.retrieveMember(numberId);
			model.addAttribute("member", member2);

			return "schoolManager/103_studentClassEachInsert/studentClassEachUpdate";
		}
		else {
			System.out.println("여기로들어왔따2");
				String logicalViewName = null;






					String classesString=(String)session.getAttribute("getClasses");
					 int idx = classesString.indexOf("-"); 
					System.out.println("너 getclasses"+classesString);
					String check1=classesString.substring(0,idx);
					String check3=classesString.substring(idx+1);
					System.out.println("건호일단 학년-반"+check1+check3);
					int checkInt1=Integer.parseInt(check1);
					int checkInt3=Integer.parseInt(check3);

					String userClasses=member.getClasses();
					int idx2 = classesString.indexOf("-"); 
					int userCheck1=Integer.parseInt(userClasses.substring(0,idx2));
					String userCheck2=userClasses.substring(idx2,idx2+1);
					int userCheck3=Integer.parseInt(userClasses.substring(idx2+1));
					System.out.println("최종: 내꺼, 제한"+userCheck1+", "+checkInt1+"\n"+userCheck3+", "+checkInt3+" 마지막"+userCheck2);
					if(userCheck1>checkInt1||userCheck3>checkInt3||!"-".equals(userCheck2))
					{
						System.out.println("들어왔닝?");
						model.addAttribute("msg","해당하는 학년-반이 없습니다!");
			            model.addAttribute("url","/school/manager/studentClass/insert");
						logicalViewName = "schoolManager/102_studentClassInsert/success";
						return logicalViewName;

					}







				if(!errors.hasErrors()) {
					ServiceResult result = service.modifyMember(member);
					switch (result) {
					case OK:
						ServiceResult loginLog = logService.createLog(inputLog);
						model.addAttribute("msg","교직원 정보수정에 성공하였습니다!");
			            model.addAttribute("url","/school/manager/studentClass/insert");
						logicalViewName = "schoolManager/106_teacherInsert/success";
						break;

					case PKDUPLICATED:
						model.addAttribute("msg","중복된 학년-반 입니다!");
			            model.addAttribute("url","/school/manager/studentClass/insert");
						logicalViewName = "schoolManager/106_teacherInsert/success";
						break;

					default:
						System.out.println("여긴가2");
						model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
						logicalViewName = "schoolManager/103_studentClassEachInsert/studentClassEachUpdate";
						break;
					}
				}else {
					System.out.println("여긴가3");
					logicalViewName = "schoolManager/103_studentClassEachInsert/studentClassEachUpdate";
				}
				return logicalViewName;
		}

	}
}






