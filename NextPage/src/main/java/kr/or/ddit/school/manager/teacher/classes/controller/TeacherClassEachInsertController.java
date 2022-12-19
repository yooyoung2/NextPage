package kr.or.ddit.school.manager.teacher.classes.controller;

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
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.teacher.classes.service.TeacherClassInsertService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.LogVO;
import lombok.extern.slf4j.Slf4j;


/*
 * ★선생님 개별등록을 위함
 * 김건호
 */
@Slf4j
@Controller
@RequestMapping("school/manager/teacherClass/EachInsert")
public class TeacherClassEachInsertController{

	/*
	 * GET방식일때는  command에 insert를 넣어주고 VO객체를 생성만 해준다.
	 * 그리고 디스패치
	 */
	@Inject
	private TeacherClassInsertService service;

	//로그체크 구지현
	@Inject
		private LogService logService;

	@ModelAttribute("command")
	public String command() {
		return "INSERT";
	}

	@ModelAttribute("member")
	public Join_Year_SCH_VO member() {
		return new Join_Year_SCH_VO();
	}

	@GetMapping
	public String doGet(){
		return "schoolManager/109_teacherClassEachInsert/teacherClassEachInsert";
	}

	/*
	 * POST방식일때는 에러를 가지고 있지 않다면 받아온 memberVO객체를 매개변수로
	 * INSERT를 실행해라. 그러면 dao와 service를 거쳐 중복 OR 성공 OR 오류 메시지를 출력한다.
	 */
	@PostMapping
	public String doPost(
		@Validated(InsertGroup.class) @ModelAttribute("member") Join_Year_SCH_VO member
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
        inputLog.setLogCntnt("담임개별등록");

        log.info("답변 등록 로그 : "+ inputLog);

		String classesString=null;
		if(member.getClasses()==null) {
			member.setClasses("6-6");
			classesString=member.getClasses();
		}

		else {
			classesString=member.getClasses();
			System.out.println("학년반"+classesString);
		}
		String logicalViewName = null;

		try {
			int idx = classesString.indexOf("-"); 
			String check1=classesString.substring(0,idx);
			String check2=classesString.substring(idx,idx+1);
			String check3=classesString.substring(idx+1);
			System.out.println("일단 학년-반"+check1+check3);
			int checkInt1=Integer.parseInt(check1);
			int checkInt2=Integer.parseInt(check3);
			if(!"-".equals(check2))
			{
				throw new Exception();
			}
			Join_Year_SCH_VO vo=new Join_Year_SCH_VO();
			vo.setClasses(check1);
			vo.setEdupsnId(check3);
			vo.setStudId(schId);
			System.out.println("넣기전확인"+check1+check3);
			System.out.println(vo);
			int update=service.setClasses(vo);

			session.setAttribute("getClasses",classesString );
			model.addAttribute("msg","학년-반 생성에 성공하였습니다!");
            model.addAttribute("url","/school/manager/teacherClass/insert");
			logicalViewName = "schoolManager/108_teacherClassInsert/success";
		}
		catch (Exception e) {
			model.addAttribute("msg","잘못된 학년-반 입니다!");
            model.addAttribute("url","/school/manager/teacherClass/insert");
			logicalViewName = "schoolManager/108_teacherClassInsert/success";
		}
		ServiceResult loginLog = logService.createLog(inputLog);




		//만일 에러가 없다면 insert해라


		return logicalViewName;
	}

}
