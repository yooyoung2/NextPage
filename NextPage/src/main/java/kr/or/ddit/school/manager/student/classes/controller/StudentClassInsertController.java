package kr.or.ddit.school.manager.student.classes.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.student.classes.service.StudentClassInsertService;
import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.FTP_Module;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import kr.or.ddit.vo.StudentClassesVO;
import lombok.RequiredArgsConstructor;


/*
 * ★회원 리스트를 불러오고 페이징처리 검색을 위함
 * -김건호
 */
@RequiredArgsConstructor
@Controller
public class StudentClassInsertController{
	
	static String test;
	
	private final StudentClassInsertService service;
	
	/*
	 * searchVO(타입, 검색어)와 현재페이지를 받는다.
	 * pagingVO에 현재페이지와 searchVO를 set해준다.
	 * pagingVO를 매개변수로 토탈레코드 수를 구한다.
	 * 
	 */
	@RequestMapping("school/manager/studentClass/insert")
	public String memberList(
		@ModelAttribute("simpleCondition") SearchVO simpleCondition
		, @RequestParam(name="page", required=false, defaultValue="1") int currentPage
		, Model model
		, HttpSession session
		
	){
		System.out.println("뭔가들어오니?"+test);
		if(session.getAttribute("getClasses")==null)
			session.setAttribute("getClasses","3-6" );
		System.out.println("현재 세션:"+session.getAttribute("getClasses"));
		
		String id=(String)session.getAttribute("authSch");
		System.out.println("나오냠"+id);
		
		List<StudentClassesVO> classes=service.getClassesList(id);
		
		
		
		for(int i=0;i<classes.size();i++)
		{
			System.out.println(classes.get(i)+"님");
		}
		session.setAttribute("classesList", classes);
		
		PagingVO<ClassMemVO> pagingVO = new PagingVO<>(30,30);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);
		pagingVO.setSchId((String)session.getAttribute("authSch"));
		
		int totalRecord = service.retrieveMemberCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<ClassMemVO> memberList = service.retrieveMemberList(pagingVO);
		
		pagingVO.setDataList(memberList);
		
		
		
		
		
    	FTP_Module ftp = new FTP_Module();
    	ftp.FileReadList("/aaa/bbb/");
    	test=ftp.FileReadImage("/aaa/bbb/","cute5.JPG");
    	model.addAttribute("test",test);
		
		
		
		
		
		
		
		
		
		
		
    	
		model.addAttribute("pagingVO", pagingVO);
		
		return "schoolManager/102_studentClassInsert/studentClassInsert";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	  
	