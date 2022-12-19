package kr.or.ddit.school.manager.board.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.auth.service.AuthManageService;
import kr.or.ddit.school.manager.board.manage.service.BoardManageService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.AuthCnctVO;
import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchoolVO;
import kr.or.ddit.vo.SearchVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 :  이유영
 * 학교관리자-게시판관리
 *
 */
@Log4j2
@Controller
@RequestMapping("school/manager/board")
public class BoardManageController {

	@Inject
	public BoardManageService service;

	@Inject
	private AuthManageService aService;

	/** ---------------- 학교관리자-게시판관리-게시판 리스트 -이유영----------------------*/
	/*GET방식으로 감*/
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String listUI() {
		return "schoolManager/88_boardManage/boardManage";
	}
	/*게시판 목록 - JSON형태로 들어오면 페이징 처리*/
	@RequestMapping(value = "/manage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<GenBoardVO> boardManage(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@ModelAttribute("simpleCondition") SearchVO simpleCondition, Model model, HttpSession session) {

		String schId = (String) session.getAttribute("authSch");

		log.info(schId+"학교아이딧!!!!!!!!!!!!!!!!!!");

		PagingVO<GenBoardVO> pagingVO = new PagingVO<>();
		pagingVO.setSchId(schId); // 요기 세션아이디 담는부분
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);
		int totalRecord = service.retrieveGenBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<GenBoardVO> genBoardList = service.selectGenBoardtList(pagingVO);
		pagingVO.setDataList(genBoardList);

		return pagingVO;
	}

	/** ---------------- 학교관리자-게시판관리-게시판추가 -이유영----------------------*/
	/*게시판 추가 - GET방식으로 감*/
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String boardManageForm(
			@ModelAttribute("genBoard") GenBoardVO genBoard
			) {
		log.info( "여기까지 옴 /add의 get방식" );
		return "schoolManager/89_90_boardManageForm/boardManageForm";
	}
	/*게시판 추가-POST형식으로 추가됨*/
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String boardInsert(
			 @ModelAttribute(value="genBoard") GenBoardVO genBoard
			, Errors errors
			, Model model
			, HttpSession session
		) {

			//genBoard.setSchId("a001"); //임시데이터

			System.out.println("genBoard : " + genBoard);
			String schId = ( String )session.getAttribute( "authSch" );
			genBoard.setSchId(schId);

			System.out.println("아이디 : "+genBoard.getSchId());
			log.info("Post 메소드 핸들러 boardInsert 실행");
			String viewName = null;
			if(!errors.hasErrors()) {
				Integer result = service.insertGenBoard(genBoard); // DB에 넣는 부분(게시판 insert)
				log.info("insert 후 글번호 : {}", result);
				if(result > 0 ) {
					AuthCnctVO authCnct = new AuthCnctVO();
					authCnct.setSchId(schId);
					authCnct.setNum(genBoard.getBrdNum());

					//aService.deleteasdasdasdas(genBoard.getBrdNum());

					for(int i = 0 ; i < genBoard.getBRWS().length ; i++) {
						authCnct.setAuthType("BRWS");
						authCnct.setAuthMemId(genBoard.getBRWS()[i]);
						aService.insertAuth(authCnct);
					}
					for(int i = 0 ; i < genBoard.getWRTE().length ; i++) {
						authCnct.setAuthType("WRTE");
						authCnct.setAuthMemId(genBoard.getWRTE()[i]);
						aService.insertAuth(authCnct);
					}
					for(int i = 0 ; i < genBoard.getSCRT().length ; i++) {
						authCnct.setAuthType("SCRT");
						authCnct.setAuthMemId(genBoard.getSCRT()[i]);
						aService.insertAuth(authCnct);
					}
					for(int i = 0 ; i < genBoard.getCMMNT().length ; i++) {
						authCnct.setAuthType("CMMNT");
						authCnct.setAuthMemId(genBoard.getCMMNT()[i]);
						aService.insertAuth(authCnct);
					}

					viewName = "redirect:manage";
				}else {
					String message = "등록 실패";
					log.info(message);
					model.addAttribute("message", message);
					viewName = "schoolManager/89_90_boardManageForm/boardManageForm";
				}
			}else {
				String message = "등록 실패2";
				log.info(message);
				System.out.println(errors);
				viewName = "schoolManager/89_90_boardManageForm/boardManageForm";
			}
			return viewName;
		}

	/** ---------------- 학교관리자-게시판관리-게시판 수정 클릭시 조회&수정 -이유영 ----------------------*/
	/*게시판 조회 - GET방식으로 감*/
	@RequestMapping(value = "/datail", method = RequestMethod.GET)
	public String BoardDetail(
			@RequestParam(name="brdNum", required=true) int brdNum
			,@ModelAttribute("detailGenBoard") GenBoardVO genBoard
			, HttpSession session
			, Model model
			) {

		String schId = ( String )session.getAttribute( "authSch" );

		genBoard =  service. selectGenBoard(brdNum); //게시판 정보 조회
		AuthCnctVO authCnct = new AuthCnctVO();

		authCnct.setSchId(schId);
		authCnct.setNum(brdNum);

		String splitArr1 = "";


		authCnct.setAuthType("BRWS");
		String[] authMemList = aService.retrieveAuthCnctList(authCnct);
		genBoard.setBRWS(authMemList);
		for(int i = 0 ; i<authMemList.length; i++ ) {
			//brws값들
			if(i == authMemList.length-1) {
				splitArr1 += authMemList[i];
			}else {
				splitArr1 += authMemList[i] + ",";
			}
		}

		authCnct.setAuthType("WRTE");
		authMemList = aService.retrieveAuthCnctList(authCnct);
		genBoard.setWRTE(authMemList);
		for(int i = 0 ; i<authMemList.length; i++ ) {
			if(i == authMemList.length-1) {
				splitArr1 += authMemList[i];
			}else {
				splitArr1 += authMemList[i] + ",";
			}
		}

		authCnct.setAuthType("SCRT");
		authMemList = aService.retrieveAuthCnctList(authCnct);
		genBoard.setSCRT(authMemList);
		for(int i = 0 ; i<authMemList.length; i++ ) {
			if(i == authMemList.length-1) {
				splitArr1 += authMemList[i];
			}else {
				splitArr1 += authMemList[i] + ",";
			}
		}


		authCnct.setAuthType("CMMNT");
		authMemList = aService.retrieveAuthCnctList(authCnct);
		genBoard.setCMMNT(authMemList);
		for(int i = 0 ; i<authMemList.length; i++ ) {
			if(i == authMemList.length-1) {
				splitArr1 += authMemList[i];
			}else {
				splitArr1 += authMemList[i] + ",";
			}
		}


		/*model.addAttribute("detailGenBoard",splitArr1);
		model.addAttribute("detailGenBoard",splitArr2);
		model.addAttribute("detailGenBoard",splitArr3);
		model.addAttribute("detailGenBoard",splitArr4);*/

		log.info("데이터 보내기전 정보 : {}", genBoard);

		model.addAttribute("detailGenBoard", genBoard);
		return "schoolManager/89_90_boardManageForm/boardManageDetailForm";
	}

	/*게시판 수정 - POST형식으로 들어옴*/
	@RequestMapping(value = "/datail", method = RequestMethod.POST)
	public String genBoardUpdate(
			@Validated(UpdateGroup.class) @ModelAttribute("detailGenBoard") GenBoardVO genBoard
			,@RequestParam(name="brdNum", required=true) int brdNum
			, BindingResult errors
			, HttpSession session
			, Model model
	) {
		String schId = ( String )session.getAttribute( "authSch" );
		log.info("asdaadadad : {}", genBoard);
		String viewName = null;
		if(!errors.hasErrors()) {
		ServiceResult result = service.updateGenboard(genBoard);//DB에 넣는 부분(게시판 update)
			String message =null;

			switch(result) {
			case OK:
					AuthCnctVO authCnct = new AuthCnctVO();
					//genBoard.setSchId(schId);
					//genBoard.setBrdNum(brdNum);
					authCnct.setSchId(schId);
					authCnct.setNum(genBoard.getBrdNum());


					authCnct.setAuthType("BRWS");
					aService.updateAuth(authCnct);
					for(int i = 0 ; i < genBoard.getBRWS().length ; i++) {
						log.info("BRWS값 하나씩 뽑기 : {}", genBoard.getBRWS()[i]);
						authCnct.setAuthMemId(genBoard.getBRWS()[i]);
						aService.insertAuth(authCnct);
					}

					authCnct.setAuthType("WRTE");
					aService.updateAuth(authCnct);
					for(int i = 0 ; i < genBoard.getWRTE().length ; i++) {
						authCnct.setAuthMemId(genBoard.getWRTE()[i]);
						aService.insertAuth(authCnct);
					}

					authCnct.setAuthType("SCRT");
					aService.updateAuth(authCnct);
					for(int i = 0 ; i < genBoard.getSCRT().length ; i++) {
						authCnct.setAuthMemId(genBoard.getSCRT()[i]);
						aService.insertAuth(authCnct);
					}
					authCnct.setAuthType("CMMNT");
					aService.updateAuth(authCnct);
					for(int i = 0 ; i < genBoard.getCMMNT().length ; i++) {

						authCnct.setAuthMemId(genBoard.getCMMNT()[i]);
						aService.insertAuth(authCnct);
					}
					viewName="redirect:manage";

				break;
			default:
				message = "서버 오류";
				viewName = "schoolManager/89_90_boardManageForm/boardManageDetailForm";
				break;
			}
			model.addAttribute("message", message);
		}else {
			viewName = "schoolManager/89_90_boardManageForm/boardManageDetailForm";
		}
		return viewName;
	}

	/** ---------------- 학교관리자-게시판관리-게시판 삭제 -이유영----------------------*/

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteGenBoard(
			//@Validated(DeleteGroup.class)
			 @RequestParam(name="brdNum", required=true) String brdNum
			//, BindingResult errors
			,RedirectAttributes redirectAttributes
	) {
		String viewName = null;
		String message = null;
		int changNum = Integer.parseInt(brdNum);
		System.out.println("brdNum===============" + brdNum);
		//!errors.hasErrors()
		if(true) {
			ServiceResult result = service.deleteGenBoard(changNum);
			switch (result) {
			case OK:
				viewName = "redirect:manage";
				break;
			default:
				message = "서버 오류";
				viewName = "schoolManager/88_boardManage/boardManage";
				break;
			}
		}
		redirectAttributes.addFlashAttribute("message", message);
		return viewName;
	}

}
