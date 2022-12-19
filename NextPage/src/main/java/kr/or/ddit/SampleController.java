package kr.or.ddit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String sample() {
		System.out.println( "여기가 과연 실행이 될까?" );
		return "index";
	}
	
	@RequestMapping(value="/ajaxTest.do")
	public ModelAndView test(HttpServletRequest req, HttpServletResponse resp, @RequestParam Map<String, Object> param) throws IOException{
	
		System.out.println("##########################");
		System.out.println(param.toString());
		System.out.println("##########################");
		
		
		ModelAndView mav = new ModelAndView();
		List<Map<String, String>> resultList = new ArrayList<>();
		for(int index=0; index < 10; index++) {			
			Map data = new HashMap();
			data.put("header1", "데이터1");
			data.put("header2", "데이터2");
			data.put("header3", "데이터3");
			resultList.add(data);
		}
		mav.addObject("resultList", resultList);

		mav.setViewName("jsonView");	
		return mav;

	}

	 
	
	
	
}
