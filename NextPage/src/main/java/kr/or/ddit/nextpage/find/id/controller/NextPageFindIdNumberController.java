package kr.or.ddit.nextpage.find.id.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping( value = "nextpage/findIdNumber.do" )

public class NextPageFindIdNumberController {

	

	@GetMapping
	public String nextPageFindId() {
		return "nextpage/nomenu/05_nextPageFindId/nextPageFindIdNumber";
	}
	
	@PostMapping
	public String nextPageFindIdNumber(
			Model model,
			HttpSession session,
			@RequestParam(name="number")  int number
			) {
		if(number==(int)session.getAttribute("findIdNumber"))
		{
			String id=(String) session.getAttribute("findIdNumberData");
			model.addAttribute("msg","인증성공! 당신의 ID는 ["+id+"]입니다!");
		    model.addAttribute("url","/nextpage/user/login.do");
		    return "schoolManager/106_teacherInsert/success";
		}
		else
		{
			model.addAttribute("msg","인증번호가 다릅니다!");
		    model.addAttribute("url","/nextpage/findIdNumber.do");
		    return "schoolManager/106_teacherInsert/success";
		}
	
		
	}
	
}
