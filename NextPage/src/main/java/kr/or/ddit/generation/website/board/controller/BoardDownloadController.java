package kr.or.ddit.generation.website.board.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.generation.website.board.service.GeneratingBoardService;
import kr.or.ddit.vo.GenPostVO;

/*
 * ★양식 다운로드를 위함
 * -김건호
 * 
 */
@Controller
public class BoardDownloadController {
	@Inject
	private GeneratingBoardService service;
	
	
	@RequestMapping("board/download")
	public String download(
		@RequestParam(name="what", required=true) String saveName
		, Model model
		, HttpSession session
	)throws IOException {
		GenPostVO attatch = service.getAttatchFileDetail(saveName);
		String gunhoPath=(String)session.getAttribute("authMem");
		System.out.println(attatch.getSavePath()+"건호패쓰");
		model.addAttribute("attatch", attatch);
		System.out.println("들어오니?");
		return "BoardDown";
	}
}

















