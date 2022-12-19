package kr.or.ddit.school.manager.post.manage.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.school.manager.post.manage.service.PostManageService;
import kr.or.ddit.vo.GenPostVO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("schoolManager/postManage")
public class PostManageController {
	@Inject
	private PostManageService service;

	//로그
	@Inject
	private LogService logService;

	/*게시물 관리 리스트 - */
	//@RequestMapping(value = "/post", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@GetMapping
	public String genPostList(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@ModelAttribute("simpleCondition") SearchVO simpleCondition,
			Model model,
			HttpSession session) {
		String schId = (String) session.getAttribute("authSch");

		PagingVO<GenPostVO> pagingVO = new PagingVO<>();
		pagingVO.setSchId(schId); //세션아이디 담는부분
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);

		List<GenPostVO> genPostList = service.selectGenPostList(pagingVO);
		pagingVO.setDataList(genPostList);
		model.addAttribute("pagingVO",pagingVO );
		return "schoolManager/91_postManage/postManage";

	}

	/**
	 * 게시물 삭제
	 * @param postNum
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping("/deletePost")
	public String genPostDelete(
		@RequestParam(name="postNum", required=true) Integer postNum
		, RedirectAttributes redirectAttributes
		,HttpSession session
	) {

		ServiceResult result = service.removeGenPost(postNum);
		String schId = (String) session.getAttribute("authSch");

	      //게시물삭제 로그체크 구지현
	      LogVO inputLog = new LogVO();
	      inputLog.setLogHpnId(schId);
	      inputLog.setLogTypeId(5);
	      inputLog.setLogCntnt("게시물삭제");

		String viewName = null;
		String message = null;

	      if(ServiceResult.OK.equals(result)) {
	    	ServiceResult loginLog = logService.createLog(inputLog);

	        viewName = "redirect:/schoolManager/postManage";
	      }else {
	        redirectAttributes.addFlashAttribute("message", postNum + "삭제 처리 실패");
	        viewName = "redirect:/schoolManager/postManage";
	      }
	      redirectAttributes.addFlashAttribute("message", message);
	      return viewName;
	   }


}
