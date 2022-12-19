package kr.or.ddit.school.manager.student.Insert.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.student.Insert.service.StudentInsertService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;


/*
 * ★일괄등록을 위함
 * 김건호
 */
@Slf4j
@Controller
@RequestMapping("school/manager/studentRealInsert")
public class StudentRealInsertController{

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
		, RedirectAttributes redirectAttributes
	)
			throws ServletException, IOException {

		ArrayList<SchMemberVO> list = (ArrayList) session.getAttribute("poi_list");

		String schId=(String) session.getAttribute("authSch");
		 //로그체크 구지현
		        LogVO inputLog = new LogVO();
		        inputLog.setLogHpnId(schId);
		        inputLog.setLogTypeId(4);
		        inputLog.setLogCntnt("신입생 일괄등록");

		        log.info("답변 등록 로그 : "+ inputLog);

		SchMemberVO data = new SchMemberVO();

		String logicalViewName = null;
		//ServiceResult result = service.insertAllMember(list);
		ServiceResult result = ServiceResult.OK;

		//리스트 갯수만큼 = 엑셀파일의 row수만큼 // for문돌면서 값을 1건씩입력한다.
		// 시퀀스 쓸수있어.
		for(int i = 0 ; i < list.size() ; i ++) {
			try {
			list.get(i).setSchId(schId);
			System.out.println("리스트1개씩 " + list.get(i));
			data = list.get(i);
			service.createMember(data);

			//STUD에 삽입함
			SchMemberVO memId=service.selectMemId(data);
			System.out.println("거노임"+memId.getMemId());
			int result2 = service.insertStaff(memId.getMemId());

			//YEAR_CLASSES에 삽입함

			String year=memId.getMemId();
			 int idx = year.indexOf("-"); 
			year=year.substring(idx+1,idx+5);
			
			ClassMemVO yc=new ClassMemVO();

			yc.setStudId(memId.getMemId());
			yc.setClasses("-");
			yc.setYear(year);
			System.out.println(memId.getMemId()+"와 "+"-와 "+year);
			int result3 = service.insertClass(yc);
			}
			catch(Exception e){
				model.addAttribute("msg","완전히 중복되는 데이터가 존재합니다!");
	            model.addAttribute("url","/school/manager/teacher/fileInsert");
				logicalViewName = "schoolManager/106_teacherInsert/success";
			}
		}


			switch (result) {
			case PKDUPLICATED:
				System.out.println("수빈중복");
				model.addAttribute("message", "아이디 중복");
				logicalViewName = "schoolManager/105_studentEachInsert/studentEachInsert";
				break;
			case OK:
				ServiceResult loginLog = logService.createLog(inputLog);
				redirectAttributes.addFlashAttribute("msg","학생 일괄등록에 성공하였습니다! 삽입된 학생 수: "+list.size()+"명");
				logicalViewName = "redirect:/school/manager/student/insert";
				break;

			default:
				System.out.println("수빈오류");
				model.addAttribute("message", "서버 오류, 쫌따 다시 하셈.");
				logicalViewName = "schoolManager/105_studentEachInsert/studentEachInsert";
				break;
			}

		//에러가 있다면 다시작성
		return logicalViewName;
	}

}
