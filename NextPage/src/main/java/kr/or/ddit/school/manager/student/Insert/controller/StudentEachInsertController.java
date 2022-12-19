package kr.or.ddit.school.manager.student.Insert.controller;

import java.io.IOException;

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
import kr.or.ddit.generation.school.schoolMember.classMember.vo.ClassMemberVO;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.student.Insert.service.StudentInsertService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.YearClassVO;
import lombok.extern.slf4j.Slf4j;


/*
 * ★학생 개별등록을 위함
 * 김건호
 */

@Slf4j
@Controller
@RequestMapping("school/manager/studentEachInsert")
public class StudentEachInsertController{

	/*
	 * GET방식일때는  command에 insert를 넣어주고 VO객체를 생성만 해준다.
	 * 그리고 디스패치
	 */
	@Inject
	private StudentInsertService service;

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
		return "schoolManager/105_studentEachInsert/studentEachInsert";
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
		member.setSchId(schId);

		System.out.println(member.getAddr1()+"임니다");
		System.out.println(member.getAddr2()+"임니다");
		System.out.println(member.getMemEmail()+"임니다");
		System.out.println(member.getMemId()+"임니다");
		System.out.println(member.getTelNum()+"임니다");

		System.out.println(member.getMemNm()+"임니다");
		System.out.println(member.getMemPw()+"임니다");
		System.out.println(member.getSchId()+"임니다");


		 //로그체크 구지현
		        LogVO inputLog = new LogVO();
		        inputLog.setLogHpnId(schId);
		        inputLog.setLogTypeId(3);
		        inputLog.setLogCntnt("신입생 등록");

		        log.info("신입생 등록 로그 : "+ inputLog);


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
			int idx=year.indexOf("-");
			year=year.substring(idx+1,idx+5);
			ClassMemVO yc=new ClassMemVO();

			yc.setClasses("-");
			yc.setMemId(memId.getMemId());
			yc.setStudId(memId.getMemId());
			yc.setYear(year);
			int result3 = service.insertClass(yc);
			switch (result) {
			case PKDUPLICATED:
				model.addAttribute("message", "아이디 중복");
				logicalViewName = "schoolManager/105_studentEachInsert/studentEachInsert";
				break;
			case OK:
				model.addAttribute("msg","학생 개별등록에 성공하였습니다!");
	            model.addAttribute("url","/school/manager/student/insert");
				logicalViewName = "schoolManager/104_studentInsert/success";
				break;

			default:
				model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
				logicalViewName = "schoolManager/105_studentEachInsert/studentEachInsert";
				break;
			}
		}
		//에러가 있다면 다시작성
		else {
			logicalViewName = "schoolManager/105_studentEachInsert/studentEachInsert";
		}
		return logicalViewName;
	}

}
