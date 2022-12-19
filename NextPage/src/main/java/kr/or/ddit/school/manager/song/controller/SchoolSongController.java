package kr.or.ddit.school.manager.song.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.song.service.SchoolSongService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.SchoolSongVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/school/manager")
public class SchoolSongController {

	@Inject
	private SchoolSongService service;

	@Inject
	private LogService logService;

	@GetMapping("/school/song")
	public String schoolSong(HttpSession session, Model model) {
		String schId = (String)session.getAttribute("authSch");
		SchoolSongVO song = service.retrieveSong(schId);

		model.addAttribute("song",song);

		return "schoolManager/84_schoolSong/schoolSong";
	}

	//교가 등록
	@PostMapping("/school/song")
	@ResponseBody
	public String insertSong(@RequestBody SchoolSongVO songVO, HttpSession session) {
		String schId = (String)session.getAttribute("authSch");

		log.info("뭔데용? : {}",songVO);


		//게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(3);
        inputLog.setLogCntnt("교가등록");

        songVO.setSchId(schId);

        ServiceResult result = service.createSong(songVO);
        if(result.OK.equals(result)) {
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);

		}else {
			String message = "등록 실패";
			log.info(message);
		}

		return "ok";
	}

	@PostMapping(value= "/modify/song", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String modifySong(@RequestBody SchoolSongVO songVO,  HttpSession session) {

		String schId=(String) session.getAttribute("authSch");
		songVO.setSchId(schId);

		ServiceResult result = service.modifySong(songVO);

		//게시물등록 로그체크 구지현
        LogVO inputLog = new LogVO();
        inputLog.setLogHpnId(schId);
        inputLog.setLogTypeId(4);
        inputLog.setLogCntnt("교가수정");

        if(result.OK.equals(result)) {
			ServiceResult loginLog = logService.createLog(inputLog);
			log.info("loging Log : {} ", loginLog);

			return "ok";
		}else {
			String message = "등록 실패";
			log.info(message);

			return "ng";
		}



	}
}
