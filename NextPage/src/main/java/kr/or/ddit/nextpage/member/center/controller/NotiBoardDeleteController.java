
package kr.or.ddit.nextpage.member.center.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.member.center.service.NextPageMemberCenterService;
import kr.or.ddit.operator.history.log.service.LogService;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.NoticeBoardVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NotiBoardDeleteController{

   private final NextPageMemberCenterService service;

	@Inject
	private LogService logService;

   @GetMapping("nextpage/postingDelete")
   public String memberDelete(
      @RequestParam(name="who", required=true) Integer notisNum
      , RedirectAttributes redirectAttributes
      ,HttpSession session
   ){
      ServiceResult result = service.removeNotiBoard(notisNum);

      String adminId = (String) session.getAttribute("authSch");

      //게시물삭제 로그체크 구지현
      LogVO inputLog = new LogVO();
      inputLog.setLogHpnId(adminId);
      inputLog.setLogTypeId(5);
      inputLog.setLogCntnt("공지사항삭제");



      String viewName = null;

      if(ServiceResult.OK.equals(result)) {
	      ServiceResult loginLog = logService.createLog(inputLog);
         viewName = "redirect:/nextpage/service/memcenter.do";
      }else {
         redirectAttributes.addFlashAttribute("message", notisNum + "삭제 처리 실패");
         viewName = "redirect:/nextpage/service/memcenter.do";
      }
      return viewName;
   }
}