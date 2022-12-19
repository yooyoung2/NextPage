package kr.or.ddit.generation.website.find.Id.controller;

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
@RequestMapping( value = "generation/{id}/find/id/number" )

public class GeneratingFindIdNumberController {

	

	@GetMapping
	public String nextPageFindId() {
		return "generation/template01/nomenu/38_generatingFindId/generatingFindIdNumber";
	}
	
	@PostMapping
	public String nextPageFindIdNumber(
			Model model,
			HttpSession session,
			@RequestParam(name="number")  int number
			) {
		String sessionId=(String) session.getAttribute("id");

		if(number==(int)session.getAttribute("findIdNumber"))
		{
			String id=(String) session.getAttribute("findIdNumberData");
			model.addAttribute("msg","인증성공! 당신의 ID는 ["+id+"]입니다!");
		    model.addAttribute("url","/generation/"+sessionId+"/login");
		    return "schoolManager/106_teacherInsert/success";
		}
		else
		{
			model.addAttribute("msg","인증번호가 다릅니다!");
		    model.addAttribute("url","/generation/"+sessionId+"/find/id/number");
		    return "schoolManager/106_teacherInsert/success";
		}
	
		
	}
	
}
