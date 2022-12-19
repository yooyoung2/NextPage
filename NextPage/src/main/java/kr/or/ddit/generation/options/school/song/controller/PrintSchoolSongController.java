package kr.or.ddit.generation.options.school.song.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrintSchoolSongController {

	@RequestMapping( value = "generation/options/school/song",
					method = RequestMethod.GET )
	public String printSchoolSong() {
		
		String viewName = null;
		
		return viewName;
		
	}
	
}
