package kr.or.ddit.school.manager.homepage.main.update.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.util.concurrent.Service;

import kr.or.ddit.school.manager.board.manage.service.BoardManageService;
import kr.or.ddit.school.manager.homepage.main.update.service.HomePageMainUpdateService;
import kr.or.ddit.vo.BnrLkInfoVO;
import kr.or.ddit.vo.BoardWidgetVO;
import kr.or.ddit.vo.BrdWdgtVO;
import kr.or.ddit.vo.GenAlertBrdVO;
import kr.or.ddit.vo.GenBnrVO;
import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.GenCaldVO;
import kr.or.ddit.vo.GenFooterVO;
import kr.or.ddit.vo.GenLkLstVO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.LkLstIconVO;
import kr.or.ddit.vo.SchLogoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomePageMainUpdateController {
	
	@Inject
	public BoardManageService boardService;
	
	@Inject
	public HomePageMainUpdateService hpmuService;
	
	@RequestMapping("school/manager/homePageMainUpdate")
	public String bhj() {
		return "schoolManager/68_homePageMainUpdate/homePageMainUpdate";
	}
	
	@RequestMapping(value= "school/manager/slot/add" , method=RequestMethod.GET)
	public String slotAdd(
			@RequestParam(required=false) String layout
			,@RequestParam(value="menuid", required=true) String slotId
			, HttpSession session
			, Model model
			) {
		GenBoardVO genBoard = new GenBoardVO();
		
		
		String schId = ( String )session.getAttribute( "authSch" );
		
		log.info("학교아이디 : {}", schId );
		log.info("slotId : {}", slotId);
		log.info("슬롯add 들어옴");
		
		if(slotId.equals("mainImage")) {
			log.info("메인이미지 검색");
			
			List<GenMainImgVO> genMainImgList = hpmuService.retrieveGenMainImgList(schId);
			
			model.addAttribute("genMainImgList", genMainImgList);
			
		}
		
		if(slotId.equals("schLogo")) {
			log.info("로고 시작");
			
			SchLogoVO schLogo = hpmuService.retrieveSchLogo(schId);
			
			model.addAttribute("schLogo", schLogo);
			
		}
		
		
		if(slotId.equals("slot001")) {
			BoardWidgetVO brdWdgt1 = null;
			List<GenBoardVO> genBoardList1 = null;
			
			log.info("일반게시판1번");
			genBoard.setSchId(schId);
			genBoard.setBrdTypeId("1");
			
			//일반게시판1 현재 적용중인 데이터 출력
			brdWdgt1 = hpmuService.retrieveBrdWdgt(schId);
			
			genBoardList1 = boardService.retrieveUseBoardList(genBoard); //사용중인 게시판목록 가져옴
			model.addAttribute("genBoardList1", genBoardList1);
			model.addAttribute("brdWdgt1", brdWdgt1); 
		}
		
		if(slotId.equals("slot002")) {
			log.info("일반게시판2번");
			
			List<BoardWidgetVO> brdWdgtList2 = null;
			List<GenBoardVO> genBoardList2 = null;
			
			genBoard.setSchId(schId);
			genBoard.setBrdTypeId("1");
			genBoardList2 = boardService.retrieveUseBoardList(genBoard); //사용중인 게시판목록 전체 가져옴
			
			//일반게시판2 현재 적용중인 데이터 출력
			brdWdgtList2 = hpmuService.retrieveBrdWdgtList(schId);
			
			log.info("결과값 : {}", genBoardList2);
			model.addAttribute("genBoardList2", genBoardList2); 
			model.addAttribute("brdWdgtList2", brdWdgtList2);
		}
		
		//이미지게시판1x1 세팅
		if(slotId.equals("slot003")) {
			log.info("이미지게시판1");
			BoardWidgetVO imgBrdWdgt1 = null;
			List<GenBoardVO> genImageBoardList1 = null;
								
			genBoard.setSchId(schId);
			genBoard.setBrdTypeId("2");
			
			imgBrdWdgt1 = hpmuService.retrieveImgBrdWdgt(schId);
			
			genImageBoardList1 = boardService.retrieveUseBoardList(genBoard);
			model.addAttribute("genImageBoardList1", genImageBoardList1); 
			model.addAttribute("imgBrdWdgt1", imgBrdWdgt1);
		}
		
		//이미지게시판1x2세팅
		if(slotId.equals("slot006")) {
			log.info("이미지게시판2");
			List<BoardWidgetVO> imgBrdWdgtList2 = null;
			List<GenBoardVO> genImageBoardList2 = null;
			
			genBoard.setSchId(schId);
			genBoard.setBrdTypeId("2");
			
			imgBrdWdgtList2 = hpmuService.retrieveImgBrdWdgtList(schId);
			
			genImageBoardList2 = boardService.retrieveUseBoardList(genBoard);
			model.addAttribute("genImageBoardList2", genImageBoardList2);
			model.addAttribute("imgBrdWdgtList2", imgBrdWdgtList2); 
		}
		
		//1x2 동영상게시판
		if(slotId.equals("slot004")) {
			
			log.info("동영상게시판1");
			List<BoardWidgetVO> videoBrdWdgtList1 = null;
			List<GenBoardVO> genVideoBoardList1 = null;
			
			genBoard.setSchId(schId);
			genBoard.setBrdTypeId("3");
			
			videoBrdWdgtList1 = hpmuService.retrieveVideoBrdWdgt(schId);
			genVideoBoardList1 = boardService.retrieveUseBoardList(genBoard);
			
			model.addAttribute("videoBrdWdgtList1", videoBrdWdgtList1);
			model.addAttribute("genVideoBoardList1", genVideoBoardList1);
		}
		
		//1x3 동영상게시판
		if(slotId.equals("slot007")) {
			
			log.info("동영상게시판2");
			
			List<BoardWidgetVO> videoBrdWdgtList2 = null;
			List<GenBoardVO> genVideoBoardList2 = null;
			
			genBoard.setSchId(schId);
			genBoard.setBrdTypeId("3");
			
			videoBrdWdgtList2 = hpmuService.retrieveVideoBrdWdgtList(schId);
			
			genVideoBoardList2 = boardService.retrieveUseBoardList(genBoard);
			
			
			model.addAttribute("videoBrdWdgtList2", videoBrdWdgtList2);
			model.addAttribute("genVideoBoardList2", genVideoBoardList2);
		}
		
		if(slotId.equals("slot008")) {
			log.info("링크위젯 ㄱㄱㄱㄱ");
			
			List<LkLstIconVO> lkLstIconList = hpmuService.retrieveLkLstIconList();
			
			List<GenLkLstVO> genLkLstList = hpmuService.retrieveGenLkLstList(schId);
			
			model.addAttribute("lkLstIconList", lkLstIconList);
			model.addAttribute("genLkLstList", genLkLstList);
		}
		
		//알림판 정보출력
		if(slotId.equals("slot010")) {
			log.info("알림판 갑시다");
			
			List<GenAlertBrdVO> genAlertBrdList = null;
			
			genAlertBrdList = hpmuService.retrieveGenAlertBrdList(schId);
			
			model.addAttribute("genAlertBrdList", genAlertBrdList);
		}
		
		if(slotId.equals("slot005")) {
			log.info("달력시작 ㄱㄱㄱ");
			
			List<GenCaldVO> genCaldList = hpmuService.retrieveGenCaldList(schId);
			
			model.addAttribute("genCaldList", genCaldList);
		}
		
		//배너시작
		if(slotId.equals("banner")) {
			log.info("배너 ㄱㄱㄱㄱ");
			
			List<BnrLkInfoVO> bnrLkInfoList = hpmuService.retrieveBnrLkInfoList();
			
			List<GenBnrVO> genBnrList = hpmuService.retrieveGenBnrList(schId);
			
			model.addAttribute("genBnrList", genBnrList); //현재 내가 갖고 있는 배너정보
			model.addAttribute("bnrLkInfoList", bnrLkInfoList); //배너정보 전체
		}
		
		//푸터정보 출력
		if(slotId.equals("footer")) {
			log.info("푸터ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ");
			
			GenFooterVO genFooter = new GenFooterVO();
			
			genFooter = hpmuService.retrieveGenFooter(schId);
			model.addAttribute("genFooter", genFooter);
		}
		
		
		String viewName ="";
		if("GRID".equals(layout)) {
			viewName = "schoolManager/68_homePageMainUpdate/homePageSlotUpdate";
		}else {
			viewName = "/schoolManager/68_homePageMainUpdate/homePageSlotUpdate";
		}
		return viewName;
	}
	
	@RequestMapping(value= "school/manager/slot/add" , method=RequestMethod.POST)
	public String slotUpdate(
			HttpSession session
			, @RequestParam(required=false) Integer listBrdNum1
			, @RequestParam(required=false) Integer listBrdNum2
			, @RequestParam(required=false) Integer listBrdNum3
			, @RequestParam(required=false) Integer listBrdNum4
			, @RequestParam(required=false) Integer listBrdNum5
			, @RequestParam(required=false) Integer listBrdNum6
			, @RequestParam(required=false) Integer listBrdNum7
			, @RequestParam(required=false) Integer listBrdNum8
			, @RequestParam(required=false) Integer listBrdNum9
			, @RequestParam(required=false) Integer listBrdNum10
			, @RequestParam(required=false) Integer listBrdNum11
			, @RequestParam(required=false) List<String> genAlertBrd
			, @RequestParam(required=false) List<String> alertFiles
			, @RequestParam(required=false) List<String> bnrLk
			, @ModelAttribute("genFooter") GenFooterVO genFooter 
			, @RequestParam(required=false) List<String> lkWidget
			, @RequestParam(required=false) List<String> lkUrl
			, @RequestParam(required=false) List<String> lkTitle
			/*, @ModelAttribute("genCald") GenCaldVO genCald*/
			, @RequestParam(required=false) List<String> caldStartDate
			, @RequestParam(required=false) List<String> caldEndDate
			, @RequestParam(required=false) List<String> schedule
			, @RequestParam(required=false) String logoData
			, @RequestParam(required=false) List<String> mainFiles
			) {
		BoardWidgetVO boardWidget = new BoardWidgetVO();
		String schId = ( String )session.getAttribute( "authSch" );
		log.info("일반게시물 번호 : {}", listBrdNum1);
		log.info("일반게시물 번호 : {}, {}", listBrdNum2, listBrdNum3);
		log.info("이미지게시물 번호 : {}", listBrdNum4);
		log.info("이미지게시물 번호 : {}, {}", listBrdNum5, listBrdNum6);
		log.info("동영상게시물 번호 : {}, {}", listBrdNum7, listBrdNum8);
		log.info("동영상게시물 번호 : {}, {}", listBrdNum9, listBrdNum10, listBrdNum11);
		log.info("푸터정보 : {}", genFooter);
		log.info("배너링크정보 : {}", bnrLk);
		log.info("링크위젯정보 : {}, {}", lkWidget,lkTitle ,lkUrl);
		/*log.info("달력정보 : {}", genCald);*/
		log.info("포스트들어옴");
		
		
		log.info("알림판정보 : {}", genAlertBrd, alertFiles);
		log.info("로고데이터 : {}", logoData);
		log.info("메인이미지 데이터 : {}", mainFiles);
		
		if(mainFiles != null) {
			log.info("메인이미지 입력");
			
			GenMainImgVO genMainImg = new GenMainImgVO();
			genMainImg.setSchId(schId);
			
			hpmuService.deleteMainImage(schId);
			
			for(int i = 0 ; i < mainFiles.size() ; i++) {
				genMainImg.setFileName(mainFiles.get(i));
				genMainImg.setOrdNum(i+1);
				
				hpmuService.insertMainImage(genMainImg);
			}
			
		}
		
		if(listBrdNum1!=null) {
			log.info("일반게시판1번 입력");
			
			//일반게시판1 삭제
			hpmuService.deleteBrdDelete(schId);
			
			boardWidget.setSchId(schId);
			boardWidget.setWidgetOrd(1);
			boardWidget.setBrdNum(listBrdNum1);
			
			hpmuService.insertListBrd(boardWidget);
		}
		
		
		//리스트brdNum2,3이 둘중 하나라도 있으면 (일반게시판2)
		if(listBrdNum2!=null && listBrdNum3!=null) {
			log.info("일반게시판2번 입력");
			
			//일반게시판2 삭제
			hpmuService.deleteListBrdDelete(schId);
			
			boardWidget.setSchId(schId);
			
			boardWidget.setWidgetOrd(2);
			boardWidget.setBrdNum(listBrdNum2);
			
			hpmuService.insertListBrd(boardWidget);
			
			boardWidget.setWidgetOrd(3);
			boardWidget.setBrdNum(listBrdNum3);
			
			hpmuService.insertListBrd(boardWidget);
		}
		
		//이미지게시판1
		if(listBrdNum4!=null) {
			log.info("이미지게시판1번 입력");
			
			//일반게시판1 삭제
			hpmuService.deleteImgDelete(schId);
			
			boardWidget.setSchId(schId);
			boardWidget.setWidgetOrd(4);
			boardWidget.setBrdNum(listBrdNum4);
			
			hpmuService.insertListBrd(boardWidget);
		}
		
		
		//이미지게시판2
		if(listBrdNum5!=null && listBrdNum6!=null) {
			log.info("이미지게시판2번 입력");
			//일반게시판2 삭제
			hpmuService.deleteImgListDelete(schId);
			
			boardWidget.setSchId(schId);
			
			boardWidget.setWidgetOrd(5);
			boardWidget.setBrdNum(listBrdNum5);
			
			hpmuService.insertListBrd(boardWidget);
			
			boardWidget.setWidgetOrd(6);
			boardWidget.setBrdNum(listBrdNum6);
			
			hpmuService.insertListBrd(boardWidget);
		}
		

		//동영상게시판1
		if(listBrdNum7!=null && listBrdNum8!=null) {
			log.info("동영상게시판1번 입력");
			//일반게시판2 삭제
			hpmuService.deleteVideoDelete(schId);
			
			boardWidget.setSchId(schId);
			
			boardWidget.setWidgetOrd(7);
			boardWidget.setBrdNum(listBrdNum7);
			
			hpmuService.insertListBrd(boardWidget);
			
			boardWidget.setWidgetOrd(8);
			boardWidget.setBrdNum(listBrdNum8);
			
			hpmuService.insertListBrd(boardWidget);
		}
		
		
		//동영상게시판2
		if(listBrdNum9!=null && listBrdNum10!=null && listBrdNum11!=null) {
			log.info("동영상게시판2번 입력");
			//일반게시판2 삭제
			hpmuService.deleteVideoListDelete(schId);
			
			boardWidget.setSchId(schId);
			
			boardWidget.setWidgetOrd(9);
			boardWidget.setBrdNum(listBrdNum9);
			
			hpmuService.insertListBrd(boardWidget);
			
			boardWidget.setWidgetOrd(10);
			boardWidget.setBrdNum(listBrdNum10);
			
			hpmuService.insertListBrd(boardWidget);

			boardWidget.setWidgetOrd(11);
			boardWidget.setBrdNum(listBrdNum11);
			
			hpmuService.insertListBrd(boardWidget);
		}
		
		if(genAlertBrd != null) {
			log.info("알림판 입력시작~");
			
			//기존목록 전체 삭제
			hpmuService.deleteGenAlertBrd(schId);
			
			GenAlertBrdVO genAlert = new GenAlertBrdVO();
			genAlert.setSchId(schId);
			for(int i = 0 ; i < genAlertBrd.size() ; i++) {
				
				
				genAlert.setOrdNum(i+1);
				genAlert.setUrlInfo(genAlertBrd.get(i));
				genAlert.setFileName(alertFiles.get(i));
				
				hpmuService.insertGenAlertBrd(genAlert);
				
			}
		}
		
	
		
		if(caldStartDate != null) {
			log.info("달력시작 ㄱㄱㄱ");
			
			GenCaldVO genCald = new GenCaldVO();
			
			genCald.setSchId(schId);
			
			hpmuService.deleteGenCald(schId);
			
			for(int i = 0 ; i < caldStartDate.size() ; i++) {
				
				genCald.setCaldStartDate(caldStartDate.get(i));
				genCald.setCaldEndDate(caldEndDate.get(i));
				genCald.setSchedule(schedule.get(i));
				
				log.info("들어온데이터 : {}", genCald);
				
				hpmuService.insertGenCald(genCald);
			}
		}
		
		
		//배너시작
		if(bnrLk != null) {
			GenBnrVO genBnr = new GenBnrVO();
			genBnr.setSchId(schId);
			
			hpmuService.deleteGenBnr(schId);
			
			for( int i = 0 ; i < bnrLk.size(); i++) {
				genBnr.setBnnrOrd(i+1);
				genBnr.setBnrLkId(bnrLk.get(i));
				
				hpmuService.insertGenBnr(genBnr);
			}
		}
		
		//푸터시작
		if(genFooter.getSchTelNum() != null) {
			log.info("푸터시작ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ");
			genFooter.setSchId(schId);
			
			hpmuService.deleteGenFooter(schId);
			
			hpmuService.insertGenFooter(genFooter);
		}
		
		//링크위젯
		if(lkWidget != null && lkUrl != null && lkTitle != null) {
			GenLkLstVO genLkLst = new GenLkLstVO();
			
			genLkLst.setSchId(schId);
			 
			hpmuService.deleteGenLkLst(schId);
			for(int i = 0 ; i < lkWidget.size() ; i++) {
				genLkLst.setWidgetOrd(i+1);
				genLkLst.setIconNm(lkWidget.get(i));
				genLkLst.setLinkUrl(lkUrl.get(i));
				genLkLst.setLinkTitle(lkTitle.get(i));
				
				log.info("링크위젯데이터 : {} ",genLkLst);
				
				hpmuService.insertGenLkLst(genLkLst);
			} 
		}
		
		//로고
		if(logoData != null) {
			SchLogoVO schLogo = new SchLogoVO();
			
			schLogo.setSchId(schId);
			schLogo.setFileName(logoData);
			
			hpmuService.deleteSchLogo(schId);
			hpmuService.insertSchLogo(schLogo);
			
		}
		
		return "/schoolManager/66_homePageManage/homePageManage";
	}
	
}
