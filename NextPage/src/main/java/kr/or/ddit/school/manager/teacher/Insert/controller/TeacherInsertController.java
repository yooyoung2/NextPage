package kr.or.ddit.school.manager.teacher.Insert.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.teacher.Insert.service.TeacherInsertService;
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
public class TeacherInsertController{
	
	private final TeacherInsertService service;
	
	/*
	 * searchVO(타입, 검색어)와 현재페이지를 받는다.
	 * pagingVO에 현재페이지와 searchVO를 set해준다.
	 * pagingVO를 매개변수로 토탈레코드 수를 구한다.
	 * 
	 */
	@RequestMapping("school/manager/teacher/insert")
	public String memberList(
		@ModelAttribute("simpleCondition") SearchVO simpleCondition
		, @RequestParam(name="page", required=false, defaultValue="1") int currentPage
		, Model model
		, HttpSession session
		
	){
		
		
		PagingVO<SchMemberVO> pagingVO = new PagingVO<>(10,10);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);
		pagingVO.setSchId((String)session.getAttribute("authSch"));
		
		int totalRecord = service.retrieveMemberCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<SchMemberVO> memberList = service.retrieveMemberList(pagingVO);
		
		pagingVO.setDataList(memberList);
		
		List<String> situationList= new ArrayList<String>();
		for(int i=0;i<memberList.size();i++)
		{
			System.out.println("삽입전:"+memberList.get(i));
			String list=service.whoClasses(memberList.get(i).getMemId());
			if(list==null||"-".equals(list))
			{
				System.out.println("어디가니1?"+list);
				situationList.add("교직원");
			}
			else
			{
				System.out.println("어디가니2?"+list);
				situationList.add("교사");
			}
		}
		
		model.addAttribute("situationList", situationList);
		model.addAttribute("pagingVO", pagingVO);
		
		return "schoolManager/106_teacherInsert/teacherInsert";
	}
}
