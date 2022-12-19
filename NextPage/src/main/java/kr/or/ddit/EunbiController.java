package kr.or.ddit;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/merong")
@Slf4j
public class EunbiController {

	@GetMapping("/inputList")
	public String getInputList(){
		return "inputList";
	}
	
	
	@PostMapping(value="/getList",produces="application/json;charset=utf-8")
	@ResponseBody
	public List<Map<String, String>> getList(@RequestBody List<Map<String, String>> eunbiList) {
		log.debug("eunbi{}"+eunbiList); // 항상 넘어온 값 확인하깅
		
		for (Map<String, String> map : eunbiList) {
			// Service/Mapper 처리, VO로 받으면 Map 필요없음
		}
		
		return eunbiList;
	}
}
