package kr.or.ddit.school.manager.teacher.classes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.teacher.classes.service.TeacherClassInsertService;
import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SearchVO;
import lombok.RequiredArgsConstructor;


/*
 * ★회원 리스트를 불러오고 페이징처리 검색을 위함
 * -김건호
 */
@RequiredArgsConstructor
@Controller
public class TeacherClassInsertController{
	
	private final TeacherClassInsertService service;
	
	/*
	 * searchVO(타입, 검색어)와 현재페이지를 받는다.
	 * pagingVO에 현재페이지와 searchVO를 set해준다.
	 * pagingVO를 매개변수로 토탈레코드 수를 구한다.
	 * 
	 */
	@RequestMapping("school/manager/teacherClass/insert")
	public String memberList(
		@ModelAttribute("simpleCondition") SearchVO simpleCondition
		, @RequestParam(name="page", required=false, defaultValue="1") int currentPage
		, Model model
		, HttpSession session
		
	){
		if(session.getAttribute("getClasses")==null)
			session.setAttribute("getClasses","3-6" );
		System.out.println("현재 세션:"+session.getAttribute("getClasses"));
		String id=(String)session.getAttribute("authSch");
		System.out.println("나오냠"+id);
		List<String> classes=service.getClassesList(id);
		
		for(int i=0;i<classes.size();i++)
		{
			System.out.println(classes.get(i)+"님");
		}
		session.setAttribute("classesList", classes);
		
		PagingVO<Join_Year_SCH_VO> pagingVO = new PagingVO<>(10,10);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);
		pagingVO.setSchId((String)session.getAttribute("authSch"));
		
		int totalRecord = service.retrieveMemberCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<Join_Year_SCH_VO> memberList = service.retrieveMemberList(pagingVO);
		
		pagingVO.setDataList(memberList);
		

		model.addAttribute("pagingVO", pagingVO);
		
		return "schoolManager/108_teacherClassInsert/teacherClassInsert";
	}
}
