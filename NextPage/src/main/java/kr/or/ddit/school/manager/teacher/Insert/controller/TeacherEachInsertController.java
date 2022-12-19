package kr.or.ddit.school.manager.teacher.Insert.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.teacher.Insert.service.TeacherInsertService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.YearClassVO;
import lombok.extern.slf4j.Slf4j;


/*
 * ★선생님 개별등록을 위함
 * 김건호
 */
@Slf4j
@Controller
@RequestMapping("school/manager/teacherEachInsert")
public class TeacherEachInsertController{

	/*
	 * GET방식일때는  command에 insert를 넣어주고 VO객체를 생성만 해준다.
	 * 그리고 디스패치
	 */
	@Inject
	private TeacherInsertService service;

	//로그체크 구지현
	@Inject
		private LogService logService;


	@ModelAttribute("command")
	public String command() {
		return "INSERT";
	}

	@ModelAttribute("member")
	public SchMemberVO member() {
		return new SchMemberVO();
	}

	@GetMapping
	public String doGet(){
		return "schoolManager/107_teacherEachInsert/teacherEachInsert";
	}

	/*
	 * POST방식일때는 에러를 가지고 있지 않다면 받아온 memberVO객체를 매개변수로
	 * INSERT를 실행해라. 그러면 dao와 service를 거쳐 중복 OR 성공 OR 오류 메시지를 출력한다.
	 */
	@PostMapping
	public String doPost(
		@Validated(InsertGroup.class) @ModelAttribute("member") SchMemberVO member
		, Errors errors
		, Model model
		, HttpSession session
	)
			throws ServletException, IOException {

		String schId=(String) session.getAttribute("authSch");
		 //로그체크 구지현
		        LogVO inputLog = new LogVO();
		        inputLog.setLogHpnId(schId);
		        inputLog.setLogTypeId(3);
		        inputLog.setLogCntnt("선생님등록");

		        log.info("t쌤 등록 로그 : "+ inputLog);

		member.setSchId(schId);
		System.out.println(member.getAddr1()+"임니다");
		System.out.println(member.getAddr2()+"임니다");
		System.out.println(member.getMemEmail()+"임니다");
		System.out.println(member.getMemId()+"임니다");
		System.out.println(member.getTelNum()+"임니다");

		System.out.println(member.getMemNm()+"임니다");
		System.out.println(member.getMemPw()+"임니다");
		System.out.println(member.getSchId()+"임니다");


		String logicalViewName = null;
		//만일 에러가 없다면 insert해라
		if(!errors.hasErrors()) {
			ServiceResult loginLog = logService.createLog(inputLog);
			ServiceResult result = service.createMember(member);
			//EDU_PSN에 등록
			SchMemberVO memId=service.selectMemId(member);
			System.out.println("거노임"+memId.getMemId());
			int result2 = service.insertStaff(memId.getMemId());
			//YEAR_CLASS에 등록 a001-20229001
			String year=memId.getMemId();
			int idx = year.indexOf("-"); 
			year=year.substring(idx+1,idx+5);
			YearClassVO yc=new YearClassVO();

			yc.setClasses("-");
			yc.setEdupsnId(memId.getMemId());
			yc.setYear(year);
			int result3 = service.insertClass(yc);


			switch (result) {
			case PKDUPLICATED:
				model.addAttribute("message", "아이디 중복");
				logicalViewName = "schoolManager/107_teacherEachInsert/teacherEachInsert";
				break;
			case OK:
				model.addAttribute("msg","교직원 개별등록에 성공하였습니다!");
	            model.addAttribute("url","/school/manager/teacher/insert");
				logicalViewName = "schoolManager/106_teacherInsert/success";
				break;

			default:
				model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
				logicalViewName = "schoolManager/107_teacherEachInsert/teacherEachInsert";
				break;
			}
		}
		//에러가 있다면 다시작성
		else {
			System.out.println("오류발생?");
			logicalViewName = "schoolManager/107_teacherEachInsert/teacherEachInsert";
		}
		return logicalViewName;
	}

}
