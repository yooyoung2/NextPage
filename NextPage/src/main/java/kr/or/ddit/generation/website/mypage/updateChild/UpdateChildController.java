package kr.or.ddit.generation.website.mypage.updateChild;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.generation.website.mypage.insertChild.GetPrntAuthController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("generation/{id}/generatingMyPage/UpdateChild")
public class UpdateChildController {
	@GetMapping
	public String insertForm(
			@PathVariable("id") String schId
			, HttpSession session
			, Model model
			) {
		return "generation/template01/mypage/45_generatingMyPage/updateChild";
	}

	@PostMapping
	public String insert() {
		String view = null;
		return view;
	}
}
