package kr.or.ddit.generation.website.main.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.generation.options.board.widget.service.BoardWidgetService;
import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.generation.website.main.service.GeneratingMainService;
import kr.or.ddit.generation.website.other.ViewMaker;
import kr.or.ddit.generation.website.project.service.ProjectService;
import kr.or.ddit.vo.FTP_Module;
import kr.or.ddit.vo.GenBrdWdgtVO;
import kr.or.ddit.vo.GenLkLstVO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SchLogoVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우 기능 : 제너레이션/ 제너레이팅 되는 모든 부분의 view를 담당한다.
 *
 * @author PC-04
 *
 *
 */

@Slf4j
@Controller
//@WebServlet(name="frontServletApp", urlPatterns={"generation/"}, loadOnStartup = 1)
@RequestMapping("generation/")
public class GeneratingMainController {

	@Inject
	GeneratingMainService service;

	// 메인에 레이아웃적용
	@Inject
	private ProjectService prjService;

	// 메인에 게시판 위젯불러오기
	@Inject
	private BoardWidgetService brdWdgService;

	//메인에 푸터적용
	@Inject
	private FooterService footerService;

//	ApplicationContext ac = new AnnotationConfigApplicationContext( ViewMaker.class );
//
//	ViewMaker viewMaker = ac.getBean( ViewMaker.class );

	@RequestMapping(value = "{id}/main", method = RequestMethod.GET)
	public String generatingMain(HttpServletRequest request, @PathVariable("id") String id, Model model,
			HttpSession session, GenBrdWdgtVO genBrdWdgtVO) {
		
		
		System.out.println("받아쥐냐?");
		System.out.println(session.getAttribute("test123"));
		
		
		log.debug( "id : {}", id );
		
		
		
//--------레이아웃 적용 시작 구지현---------------------
		// 세션아이디 받아서 보내주기
		String schId = (String) session.getAttribute("authSch");

		// 레이아웃 틀
		ProjectVO project = prjService.projectView(id);
		log.info("project1 : {}", project);
		model.addAttribute("prj", project);

		// 레이아웃정보
		List<ProjectVO> project2 = prjService.divView(id);
		log.info("project2 : {}", project2);
		model.addAttribute("prjDiv", project2);

		// --------레이아웃 적용 끝---------------------

//------------------위젯적용 시작 구지현------------------------------

		FTP_Module ftp = new FTP_Module();
		String savePath="/"+id+"/POST_ATCH/";
//	genBrdWdgtVO.setSchId(id);
//2개 목록형 게시판
		List<GenBrdWdgtVO> brdRtWdg = brdWdgService.brdWgtRtView(id);

		log.info("project3 : {}", brdRtWdg);
		model.addAttribute("brdRtWdg", brdRtWdg);

		List<GenBrdWdgtVO> brdLtWdg = brdWdgService.brdWgtLtView(id);

		log.info("project3 : {}", brdLtWdg);
		model.addAttribute("brdLtWdg", brdLtWdg);

//1개목록형 게시판
		List<GenBrdWdgtVO> brdOneWdg = brdWdgService.brdWgtOneView(id);

		
		log.info("project3 : {}", brdOneWdg);
		model.addAttribute("brdOneWdg", brdOneWdg);


//1개이미지형 게시판
		List<GenBrdWdgtVO> imgOneWdg = brdWdgService.brdWgtOneImg(id);
		

		try
		{
			System.out.println("메인넘어와 "+savePath);
			imgOneWdg.get(0).setRealName(ftp.FileReadImage(savePath, imgOneWdg.get(0).getFileName()));
			imgOneWdg.get(1).setRealName(ftp.FileReadImage(savePath, imgOneWdg.get(1).getFileName()));
		}
		catch(Exception e)
		{
			System.out.println("아무런 이미지가 없음");
		}
		

		
		model.addAttribute("imgOneWdg", imgOneWdg);



//2개 이미지형 게시판
		List<GenBrdWdgtVO> imgLtWdg = brdWdgService.imgWgtLtView(id);

		
		try {
			imgLtWdg.get(0).setRealName(ftp.FileReadImage(savePath, imgLtWdg.get(0).getFileName()));
			imgLtWdg.get(1).setRealName(ftp.FileReadImage(savePath, imgLtWdg.get(1).getFileName()));
			imgLtWdg.get(2).setRealName(ftp.FileReadImage(savePath, imgLtWdg.get(2).getFileName()));
			
		}
		catch(Exception e)
		{
			System.out.println("아무런 이미지가 없음");
		}
		
		
		model.addAttribute("imgLtWdg", imgLtWdg);


		List<GenBrdWdgtVO> imgRtWdg = brdWdgService.imgWgtRtView(id);

		
		try {
			imgRtWdg.get(0).setRealName(ftp.FileReadImage(savePath, imgRtWdg.get(0).getFileName()));
			imgRtWdg.get(1).setRealName(ftp.FileReadImage(savePath, imgRtWdg.get(1).getFileName()));
			imgRtWdg.get(2).setRealName(ftp.FileReadImage(savePath, imgRtWdg.get(2).getFileName()));
			
		}
		catch(Exception e)
		{
			System.out.println("아무런 이미지가 없음");
		}
		
		
		model.addAttribute("imgRtWdg", imgRtWdg);

//2개 동영상형 게시판
		List<GenBrdWdgtVO> vdLtWdg = brdWdgService.vdWgtLtView(id);
		
		
	try {
		vdLtWdg.get(0).setRealName(ftp.FileReadImage(savePath, vdLtWdg.get(0).getFileName()));
		vdLtWdg.get(1).setRealName(ftp.FileReadImage(savePath, vdLtWdg.get(1).getFileName()));
		
	}
	catch(Exception e)
	{
		System.out.println("아무런 이미지가 없음");
	}
	
	
		model.addAttribute("vdLtWdg", vdLtWdg);
		

		List<GenBrdWdgtVO> vdRtWdg = brdWdgService.vdWgtRtView(id);

		
		try {
			vdRtWdg.get(0).setRealName(ftp.FileReadImage(savePath, vdRtWdg.get(0).getFileName()));
			vdRtWdg.get(1).setRealName(ftp.FileReadImage(savePath, vdRtWdg.get(1).getFileName()));
			
		}
		catch(Exception e)
		{
			System.out.println("아무런 이미지가 없음");
		}
		
		
		model.addAttribute("vdRtWdg", vdRtWdg);




//3개 동영상형 게시판
		List<GenBrdWdgtVO> vdTriLt = brdWdgService.triVdWgtLt(id);

		
		try {
			vdTriLt.get(0).setRealName(ftp.FileReadImage(savePath, vdTriLt.get(0).getFileName()));
			vdTriLt.get(1).setRealName(ftp.FileReadImage(savePath, vdTriLt.get(1).getFileName()));
			
		}
		catch(Exception e)
		{
			System.out.println("아무런 이미지가 없음");
		}
		
		
		model.addAttribute("vdTriLt", vdTriLt);


		List<GenBrdWdgtVO> vdTriMd = brdWdgService.triVdWgtMd(id);

		
		try {
			vdTriMd.get(0).setRealName(ftp.FileReadImage(savePath, vdTriMd.get(0).getFileName()));
			vdTriMd.get(1).setRealName(ftp.FileReadImage(savePath, vdTriMd.get(1).getFileName()));
			
		}
		catch(Exception e)
		{
			System.out.println("아무런 이미지가 없음");
		}
		
		
		model.addAttribute("vdTriMd", vdTriMd);


		
		List<GenBrdWdgtVO> vdTriRt = brdWdgService.triVdWgtRt(id);

		
		try {
			vdTriRt.get(0).setRealName(ftp.FileReadImage(savePath, vdTriRt.get(0).getFileName()));
			vdTriRt.get(1).setRealName(ftp.FileReadImage(savePath, vdTriRt.get(1).getFileName()));
			
		}
		catch(Exception e)
		{
			System.out.println("아무런 이미지가 없음");
		}
		
		
		model.addAttribute("vdTriRt", vdTriRt);


//알림판
		List<GenBrdWdgtVO> notice = brdWdgService.noticeView(id);

		
		try {
			notice.get(0).setRealName(ftp.FileReadImage(savePath, notice.get(0).getFileName()));
			notice.get(1).setRealName(ftp.FileReadImage(savePath, notice.get(1).getFileName()));
			notice.get(2).setRealName(ftp.FileReadImage(savePath, notice.get(2).getFileName()));
			notice.get(3).setRealName(ftp.FileReadImage(savePath, notice.get(3).getFileName()));
			notice.get(4).setRealName(ftp.FileReadImage(savePath, notice.get(4).getFileName()));
			
		}
		catch(Exception e)
		{
			System.out.println("아무런 이미지가 없음");
		}
		
		
		log.info("notice : {}", notice);
		model.addAttribute("notice", notice);



//식단
		GenBrdWdgtVO diet = brdWdgService.dietBrd(id);

		log.info("diet : {}", diet);
		model.addAttribute("diet", diet);

//링크리스트
		List<GenLkLstVO> linkList  = brdWdgService.linkListView(id);

		log.info("linkList : {}", linkList);
		model.addAttribute("linkList", linkList);

//알림판
		List<GenBrdWdgtVO> calendar = brdWdgService.calendarView(id);

		log.info("calendar : {}", calendar);
		model.addAttribute("calendar", calendar);


//------------------위젯적용 끝------------------------------


//======================하단배너 시작==================================
		List<GenBrdWdgtVO> banner = brdWdgService.underBannerList(id);

		log.info("banner : {}", banner);
		model.addAttribute("banner", banner);

//======================하단배너 끝==================================

//======================footer 시작==================================
		SchoolVO footer = footerService.selectGenFooter(id);
		log.info("footer : {}", footer);
		model.addAttribute("footer",footer);

//======================footer 끝==================================
		String viewName = "";
/*		String viewName = "generation/template01/nomenu/35_generatingMain/generatingMain";*/

		/*
		 * String topMenuId = request.getParameter( "topMenuId" ); String link =
		 * request.getParameter( "link" );
		 */

		/**
		 * 작성자 : 최현우
		 *
		 * 프로세스 흐름 1. 사용자가 어떤 탬플릿을 사용하는지에 대한 정보를 가져온다. 2. 탬플릿 정보에 맞춰 viewMaker를 통해 view를
		 * 만들어준다.( html코드 ) - ViewMaker객체로 함수 호출할때 template 아이디도 같이 넘겨줘여 하기 때문에 template
		 * 아이디를 먼저 구한다. 3. 탬플릿에 맞춰 viewName도 설정해준다.
		 *
		 *
		 */

		// 프로젝트에 대한 정보를 가지고 있다. ( 학교아이디, 프로젝트아이디, 탬플릿아이디 )
		ProjectVO pVo = service.selectProjectInfo(id);

		String templateId = "";
		if (pVo != null) { // pVo객체에서 template아이디를 추출하기 전에 null체크 먼저 해준다.
			templateId = pVo.getTmpltId();

			// templateId는 이제부터 거의 모든 페이지에서 필요하므로 세션에 담아준다.
			session.setAttribute("templateId", templateId);

			log.info("template 아이디 : " + templateId);
		} else {
			viewName = "error/error";
		}
		
		
		String fileName = "";
		List<GenMainImgVO> mainImages = null;
		
		try {
			SchLogoVO vo = service.getLogoImage( id );
			mainImages = service.getMainImages( id );
			if( mainImages != null && !mainImages.isEmpty() ) {
				for( GenMainImgVO mainImage : mainImages ) {
					log.debug( "Main Images File name : " + mainImage.getFileName() );
				}
			}
			log.debug( "SchLogoVo is not null" );
			fileName = vo.getFileName();
			
			log.debug( "fileName : {}", fileName );
		}catch( NullPointerException e ) {
			e.printStackTrace();
			log.debug( "SchLogoVo is null" );
		}

		session.setAttribute( "fileName", fileName );
		//model.addAttribute( "fileName", fileName );
		model.addAttribute( "mainImages", mainImages );
		
		session.setAttribute("id", id);

		// String rootPath = "/NextPage";

		/*
		 * log.info( "@RequestParam topMenuId : " + topMenuId ); log.info(
		 * "@RequestParam controller : " + link );
		 */

		String whatYouCallValue = request.getServletPath();
		log.info("입력한 Generation main url : " + whatYouCallValue);

		// DB에서 가져온 정보
		List<GeneratingMainVO> data = service.getOptionsURL(id);

		ViewMaker viewMaker = new ViewMaker(data);

		String headerView = viewMaker.headerViewMaker(id, data, templateId);
		// String leftView2 = viewMaker.leftViewMaker( id, data, "1" );

		session.setAttribute("headerView", headerView);
		/**
		 * 작성자 : 최현우 leftViewMaker() 메소드는 왼쪽 메뉴바를 동적으로 만들어주는 메소드이다.
		 *
		 * 첫 번쨰 파라미터 : id는 사용자의 아이디 두 번째 파라미터 : 사용자가 선택한 옵션에 대한 리스트 세 번째 파라미터 : 왼쪽
		 * 사이드메뉴는 헤더의 상단메뉴의 하위 메뉴들이므로 파라미터로 상위 메뉴의 아이디를 전달한다.
		 *
		 */
		/* String leftView = ""; */

		/*
		 * log.info(
		 * "======================== HEADER VIEW CODE ========================" );
		 * log.info( "header view : " + headerView ); log.info(
		 * "===========================================================" );
		 */

		/*
		 * if( topMenuId == null && link == null ) { // 아직 파라미터가 들어오지 않았다면 viewName =
		 * "generation/template01/nomenu/35_generatingMain/generatingMain";
		 *
		 * // 탬플릿 01번 //template02/1_template02/template02Main }else { // 파라미터가 들어온 상태라면
		 * log.info( "topMenuId : " + topMenuId ); log.info( "link : " + link );
		 * viewName = "redirect:" + link; log.info( "final link : " + viewName );
		 * leftView = viewMaker.leftViewMaker( id, data, topMenuId );
		 * session.setAttribute( "leftView" , leftView ); log.info(
		 * "======================== LEFT VIEW CODE ========================" );
		 * log.info( "left view : " + leftView ); log.info(
		 * "===========================================================" ); }
		 */

		if (templateId.equalsIgnoreCase("TMPLT001")) {
			// 탬플릿 01
			viewName = "generation/template01/nomenu/35_generatingMain/generatingMain";
		} else if (templateId.equalsIgnoreCase("TMPLT002")) {
			// 탬플릿 02
			// 탬플릿 02는 메인에도 left menu가 있기 때문에 만들어줘야 한다.
			viewName = "generation/template02/nomenu/1_template02/template02Main";
			// String leftView = viewMaker.leftViewMaker( id, data, "1", templateId );
			// session.setAttribute( "leftView" , leftView );
		}else if( templateId.equals( "TMPLT003" ) ) {
			viewName = "generation/template03/nomenu/1_template03/template03Main";
		}

		session.setAttribute("dataList", data);

		return viewName;

	}

//=================================================================================================

}
