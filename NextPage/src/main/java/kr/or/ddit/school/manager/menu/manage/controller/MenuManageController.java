package kr.or.ddit.school.manager.menu.manage.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.auth.service.AuthManageService;
import kr.or.ddit.school.manager.board.manage.service.BoardManageService;
import kr.or.ddit.school.manager.content.manage.service.ContentManageService;
import kr.or.ddit.school.manager.menu.manage.service.MenuManageService;
import kr.or.ddit.vo.AuthCnctVO;
import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.GenCntntVO;
import kr.or.ddit.vo.GenMenuVO;
import lombok.extern.log4j.Log4j2;

@MultipartConfig
@Log4j2
@Controller
public class MenuManageController {
	
	@Inject
	public MenuManageService service;
	
	@Inject
	public AuthManageService aService;
	
	@Inject
	public BoardManageService bService;
	
	@Inject
	public ContentManageService cService;

	
	
	@RequestMapping(value="school/manager/menu/manage", method=RequestMethod.GET)
	public String bhj(
			HttpSession session
			, Model model
			) {
		String schId = ( String )session.getAttribute( "authSch" );
		//List<GenMenuVO> genMenuList = service.retrieveGenMenuList(schId);
		
		String genMenuList = service.retrieveGenMenuList(schId);
		
		model.addAttribute("genMenuList", genMenuList);
		
		return "schoolManager/76_menuManage/menuManage";
	}
	 
	/*@RequestMapping(value="school/manager/menu/add", method=RequestMethod.GET)
	public String UIlist() {
		return "schoolManager/77_menuAdd/menuAdd";
	}*/
	
	
	
	//@RequestMapping(value="school/manager/menu/add", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(value="school/manager/menu/add", method=RequestMethod.GET)
	public String detailMenu(
			@RequestParam(required=false) String layout
			, HttpSession session
			, @RequestParam(value="menuid", required=true) String menuId
			, Model model
			) {
		GenMenuVO preGenMenu = new GenMenuVO();
		System.out.println("메뉴아이디 : "+menuId);
		
		String schId = ( String )session.getAttribute( "authSch" );
		preGenMenu.setSchId(schId); //세션에서 아이디 담은거 넣어야함. 지금은 테스트용으로 함.
		
		preGenMenu.setMenuId( Integer.parseInt(menuId)); 
		GenMenuVO genMenu = service.retrieveGenMenu(preGenMenu);
		
		model.addAttribute("genMenu",genMenu);
		System.out.println(genMenu.getMenuNm());
		
		String viewName = null;
		
		if("GRID".equals(layout)) {
			viewName = "schoolManager/77_menuAdd/menuAdd";
		}else {
			viewName = "/schoolManager/77_menuAdd/menuAdd";
		}
		System.out.println("뷰네임 : " + viewName);
		return viewName;
		
	}
	
	@RequestMapping(value="school/manager/menu/add", method=RequestMethod.POST)
	public String menuInsert(
			@RequestParam(required=false) String layout
			, HttpSession session
			, @RequestParam(value="checkList[]") List<String> arrayParams  //체크리스트 값
			, @ModelAttribute(value="data") GenMenuVO genMenu
			, Error errors
			) {
		System.out.println("jsp에서 올라옴 : " + genMenu);
		GenBoardVO genBoard = new GenBoardVO();
		String schId = ( String )session.getAttribute( "authSch" );
		genMenu.setSchId(schId);
		//genMenu.setSchId("a001"); //세션에서 아이디 담은거 넣어야함. 지금은 테스트용으로 함.
		
		
		
		Integer topId = 0;
		
		String link = genMenu.getMenuLink();
		log.info("올라온 링크 : {}", link);
		
		String type = genMenu.getMenuType();
		log.info("올라온 타입 : {}", type);
		
		//링크타입과 타잆없음은 데이터가 바뀌지 않는다.
		if(!(type.equals("link") || type.equals("noType"))) {
			 link = link.replace("//", "/"+genMenu.getSchId()+"/");			
		}
		log.info("replace링크 : {}", link);
		genMenu.setMenuLink(link);
		
		int boardNum ;
		String rtrnType = "";
		//board일때 일반,이미지,동영상 게시판 구분해서 값세팅
		if(type.equals("board")) {
			log.info(" 글번호 : {}", link.substring(link.indexOf("=")+1) );
			genBoard = bService.selectGenBoard(Integer.parseInt(link.substring(link.indexOf("=")+1)));
			//타입
			boardNum = Integer.parseInt(genBoard.getBrdTypeId());
			
			if(boardNum==1) {
				rtrnType = "normalBoard";
			}else if(boardNum == 2){
				rtrnType = "imageBoard";
			}else if(boardNum == 3) {
				rtrnType = "videoBoard";
			}
		}else {
			rtrnType = type;
		}
		
		String rtrnJSP = service.retrieveRtrnJSP(rtrnType);
		
		genMenu.setRtrnJsp(rtrnJSP);
		
		log.info("rtrnJSP : {}", rtrnJSP);
		
		//0 :  들어왔다(상위메뉴 추가임 아니면 하위메뉴 추가)
		if(genMenu.getTopMenuId()==0) {
			topId = service.retrieveTopMaxMenuId(genMenu.getSchId());
			genMenu.setTopMenuId(null);
			genMenu.setMenuId(topId+1);
			genMenu.setTop("OK");
		}else { //하위메뉴추가
			System.out.println("하위메뉴추가시도");
			topId = service.retrieveSubMaxMenuId(genMenu);
			if(topId == null) {
				topId = genMenu.getTopMenuId()*100;
			}
			genMenu.setMenuId(topId+1);
		}
		
		log.info("입력시도 데이터 : " + genMenu);
		
		int result = service.insertGenMenu(genMenu);
		
		System.out.println("결과: " + result);
		
		
		// 권한정보넣는거는 결과값이 정상일때만 insert 시도
		AuthCnctVO authCnct = new AuthCnctVO();
		
		authCnct.setSchId(genMenu.getSchId());
		authCnct.setNum(genMenu.getMenuId());
		authCnct.setAuthType("MENU");
		
		
		for(int i = 0 ; i < arrayParams.size() ; i++) {
			log.info("올라온 데이터 배열 : {}", arrayParams.get(i));
			authCnct.setAuthMemId(arrayParams.get(i));
			aService.insertAuth(authCnct);
		}
		
		
		
		String viewName = null;
		if("GRID".equals(layout)) {
			viewName = "schoolManager/77_menuAdd/menuAdd";
		}else {
			viewName = "/schoolManager/77_menuAdd/menuAdd";
		}
		return viewName;
	}
	
	@RequestMapping(value="school/manager/menu/menuType", method=RequestMethod.GET)
	public String menuType(
			HttpSession session
			, String menuType
			, Model model
			) {
		List<GenBoardVO> genBoard = null;
		List<GenCntntVO> genCntnt = null;
		
		
		String schId = ( String )session.getAttribute( "authSch" );
		//String schId="a001"; //세션에서 아이디 담은거 넣어야함. 지금은 테스트용으로 함.
		
		
		log.info("jsp에서 올라온데이터 {}", menuType);
		
		if(menuType.equals("board")) {
			log.info("게시판시작");
			genBoard = bService.retrieveGenBoardOptionList(schId);
			model.addAttribute("options", genBoard);
		}else if(menuType.equals("contents")) {
			log.info("콘텐츠시작");
			genCntnt = cService.retrieveGenCntntOptionList(schId);
			model.addAttribute("options", genCntnt);
		}else if(menuType.equals("link")){
			log.info("링크시작");
		}else {
			log.info("나머지시작");
		}
		
		return "jsonView";
	}
	
	@RequestMapping(value="school/manager/menu/update", method=RequestMethod.GET)
	public String menuSelect(
			@RequestParam(required=false) String layout
			, HttpSession session
			, @RequestParam(value="menuid", required=true) String menuId
			, Error errors
			, Model model
			) {
		String schId = ( String )session.getAttribute( "authSch" );
		//String schId="a001"; //세션에서 아이디 담은거 넣어야함. 지금은 테스트용으로 함.
		
		GenMenuVO genMenu = new GenMenuVO();
		AuthCnctVO authCnct = new AuthCnctVO();
		
		authCnct.setSchId(schId);
		authCnct.setNum(Integer.parseInt(menuId));
		authCnct.setAuthType("MENU");
		
		genMenu.setSchId(schId);
		genMenu.setMenuId(Integer.parseInt(menuId));
		     
		log.info("jsp에서 올라온 데이터 : {}", genMenu);
		
		GenMenuVO respMenu = service.retrieveSetGenMenu(genMenu);
		
		String[] authMemList = aService.retrieveAuthCnctList(authCnct);
		
		String splitArr = "";

		
		for(int i = 0 ; i < authMemList.length ; i++) {
			if(i == authMemList.length-1) {
				splitArr += authMemList[i];
			}else {
				splitArr += authMemList[i] + ",";
			}
		}	
		
		model.addAttribute("respMenu", respMenu);
		model.addAttribute("authMemList", splitArr);
		String viewName = null;
		if("GRID".equals(layout)) {
			viewName = "schoolManager/79_menuUpdate/menuUpdate";
		}else {
			viewName = "/schoolManager/79_menuUpdate/menuUpdate";
		}
		System.out.println("뷰네임 : " + viewName);
		return viewName;		
	}
	
	@RequestMapping(value="school/manager/menu/update", method=RequestMethod.POST)
	public String menuUpdate(
			@RequestParam(required=false) String layout
			, HttpSession session
			, @RequestParam(value="checkList[]") List<String> arrayParams  //체크리스트 값
			, @ModelAttribute(value="data") GenMenuVO genMenu
			, Error errors
			) {
		System.out.println("jsp에서 올라옴11111111 : " + genMenu);
		AuthCnctVO authCnct = new AuthCnctVO();
		String schId = ( String )session.getAttribute( "authSch" );
		genMenu.setSchId(schId);
		//String schId="a001";
		//genMenu.setSchId("a001"); //세션에서 아이디 담은거 넣어야함. 지금은 테스트용으로 함.
		
		String link = genMenu.getMenuLink();
		String type = genMenu.getMenuType();
		//링크타입과 타잆없음은 데이터가 바뀌지 않는다.
		
		GenBoardVO genBoard = new GenBoardVO();
		
		if(!(type.equals("link") || type.equals("noType"))) {
			 link = link.replace("//", "/"+genMenu.getSchId()+"/");			
		}
		log.info("replace링크 : {}", link);
		genMenu.setMenuLink(link);
		
		int boardNum ;
		String rtrnType = "";
		//board일때 일반,이미지,동영상 게시판 구분해서 값세팅
		if(type.equals("board")) {
			log.info(" 글번호 : {}", link.substring(link.indexOf("=")+1) );
			genBoard = bService.selectGenBoard(Integer.parseInt(link.substring(link.indexOf("=")+1)));
			//타입
			boardNum = Integer.parseInt(genBoard.getBrdTypeId());
			
			if(boardNum==1) {
				rtrnType = "normalBoard";
			}else if(boardNum == 2){
				rtrnType = "imageBoard";
			}else if(boardNum == 3) {
				rtrnType = "videoBoard";
			}
		}else {
			rtrnType = type;
		}
		
		String rtrnJSP = service.retrieveRtrnJSP(rtrnType);
		
		genMenu.setRtrnJsp(rtrnJSP);
		
		log.info("rtrnJSP : {}", rtrnJSP);
		
		
		authCnct.setSchId(schId);
		authCnct.setNum(genMenu.getMenuId());
		authCnct.setAuthType("MENU");
		aService.deleteAuth(authCnct);
		
		for(int i = 0 ; i < arrayParams.size() ; i++) {
			log.info("올라온 데이터 배열 : {}", arrayParams.get(i));
			authCnct.setAuthMemId(arrayParams.get(i));
			aService.insertAuth(authCnct);
		}
		
		service.updateGenMenu(genMenu);
		
		
		
		
		String viewName = null;
		if("GRID".equals(layout)) {
			viewName = "schoolManager/77_menuAdd/menuAdd";
		}else {
			viewName = "/schoolManager/77_menuAdd/menuAdd";
		}
		return viewName;
		
	}
	
	@RequestMapping(value="school/manager/menu/delete", method=RequestMethod.POST)
	public String menuDelete(
			@RequestParam(required=false) String layout
			, HttpSession session
			, @RequestParam(value ="menuId", required=true) String menuId
			, Error errors
			) {
		GenMenuVO genMenu = new GenMenuVO();
		AuthCnctVO authCnct = new AuthCnctVO();
		
		String schId = ( String )session.getAttribute( "authSch" );
		genMenu.setSchId(schId);
		//String schId="a001";
		//genMenu.setSchId("a001"); //세션에서 아이디 담은거 넣어야함. 지금은 테스트용으로 함.
		
		log.info("Delete - jsp에서 메뉴아이디 : {}", menuId);
		genMenu.setMenuId(Integer.parseInt(menuId));
		//1. 메뉴아이디를 가지고 최상위메뉴인지 아닌지 판별
		//2. if(최상위아닐때) else(최상위일때)
		//3.    최상위가 아닐때 - 메뉴1개만 삭제, (권한정보 + 메뉴정보)
		//4. 	최상위 - 하위메뉴들도 같이 삭제(권한정보 + 메뉴정보)
		//
		
		Integer topMenuId = service.retrieveTopMenuId(genMenu);
		log.info("검색된 데이터 : {}", topMenuId);
		
		//계정정보+타입은 동일함.
		authCnct.setSchId(schId);
		authCnct.setAuthType("MENU");
		authCnct.setNum(genMenu.getMenuId());
		
		
		
		log.info("genMMMMMMMMMMenu : {}", genMenu);
		
		//하위메뉴일때
		if(!(topMenuId==null)) {
			log.info("하위메뉴시작");
			aService.deleteAuth(authCnct); //권한삭제.
			service.deleteMenuId(genMenu); //메뉴정보삭제
		}else {//상위메뉴일때
			log.info("상위메뉴시작");
			aService.deleteAuth(authCnct); //상위권한삭제.
			service.deleteMenuId(genMenu); //상위메뉴정보삭제
			
			genMenu.setTopMenuId(Integer.parseInt(menuId)); // 셀렉트해야함  ㅁㄴㅇㅇㅁㄴㅁㄴㅇㄴㅁㅇㄴㅁㅇㄴㅁㅇㄴㅁㅇㄴㅁㅇㅁㄴㅇ
			Integer[] menuIds = service.retrieveMenuId(genMenu);
			
			for(int i = 0 ; i < menuIds.length; i++) {
				authCnct.setNum(menuIds[i]);
				genMenu.setMenuId(menuIds[i]);
				aService.deleteAuth(authCnct); //하위권한삭제.
				service.deleteMenuId(genMenu); //하위메뉴삭제.
			}
			
		}
		
		String viewName = null;
		if("GRID".equals(layout)) {
			viewName = "schoolManager/77_menuAdd/menuAdd";
		}else {
			viewName = "/schoolManager/77_menuAdd/menuAdd";
		}
		return viewName;
	}
	
	
			
}
