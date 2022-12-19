package kr.or.ddit.common.interceptor;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.generation.website.main.service.GeneratingMainService;
import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.generation.website.other.ViewMaker;
import kr.or.ddit.school.manager.auth.service.AuthManageService;
import kr.or.ddit.vo.AuthCnctVO;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SchLogoVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우 ( Jack Snider )
 * 
 * 
 * 
 * ============== 참고 ==============
 * 
 * 인터셉터 순서( 참고링크 :
 * https://velog.io/@totw5701/Spring-%EC%9D%B8%ED%84%B0%EC%85%89%ED%84%B0Interceptor
 * ) request -> preHandle -> controller -> postHandle -> view -> afterCompletion
 * 
 * @author PC-04
 *
 */

@Slf4j
public class MenuInterceptor extends HandlerInterceptorAdapter {

	@Inject
	GeneratingMainService service;

	// 22.11.29추가(방형준) - auth 정보 취득을 위한 서비스 선언
	@Inject
	AuthManageService aService;

	String headerView = ""; // 헤더 메뉴
	String leftView = ""; // 왼쪽 사이드 메뉴

	String id = ""; // 학교 아이디
	String topMenuId = ""; // 상위 메뉴 아이디
	String templateId = ""; // 탬플릿 아이디 ( 2022.11.21 추가 )
	String rtrnJsp = ""; // 뷰 랜더링 경로 ( 2022.11.23 추가 )

	URLMappingHandler urlm = new URLMappingHandler();
	ViewMaker viewMaker = new ViewMaker();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		
		
		log.debug("저는 전처리 인터셉터에요. {}", request.getParameterMap());

		HttpSession session = request.getSession(); // 세션객체 생성

		String requestURI = request.getRequestURI();

		String address = requestURI.replace("/NextPage", "");

		GeneratingMainVO vo = null;

		// ================================ [board, contents 알고리즘] 시작 ================================
		vo = temp( address, request );
		// ================================ [board, contents 알고리즘] 끝 ================================

		log.debug("[MenuInterceptor] address ==> " + address);

		if (vo != null) {
			log.debug("전처리 [ vo.getTopMenuId() {} ] ", vo.getTopMenuId());
			log.debug("전처리 [ vo.getSchId() {} ] ", vo.getSchId());
			id = vo.getSchId();
			topMenuId = vo.getTopMenuId();

			// 뷰 랜더링 경로
			rtrnJsp = vo.getRtrnJsp();
			log.debug("[MenuInterceptor] ==> rtrnJsp from Database : " + rtrnJsp);

		} else {
			log.debug("전처리 [ vo == null ]");
		}

		
/*		if( service != null ) {
			log.debug( "service is not null" );
			SchLogoVO logoPath = service.getLogoImage( id );
			if( logoPath != null ) {
				log.debug( "LOGO FILE NAME : {}", logoPath.getFileName() );				
			}else {
				log.debug( "logoPath is null" );
			}
		}else {
			log.debug( "service is null" );
		}*/
		
		/*SchLogoVO logoPath = service.getLogoImage( id );
		log.debug( "LOGO FILE NAME : {}", logoPath.getFileName() );*/
		
		// ProjectVO : 학교아아디, 프로젝트아이디, 탬플릿아이디 ( 2022.11.21 추가 )
		ProjectVO pVo = service.selectProjectInfo(id);

		if (pVo != null) {
			templateId = pVo.getTmpltId();

			// templateId는 거의 모든 페이지에서 사용해서 세션에 담아둔다.
			session.setAttribute("templateId", templateId);

			String tmp_tmpltId = "";
			if (templateId.equals("TMPLT001")) {
				tmp_tmpltId = "template01";
			} else if (templateId.equals("TMPLT002")) {
				tmp_tmpltId = "template02";
			} else if ( templateId.equals( "TMPLT003" ) ) {
				tmp_tmpltId = "template03";
			}
			// 여기서 뷰 랜더링 주소를 완성 시켜줘야함.( rtrnJsp사이에 templateId 추가해줘야함 )
			/**
			 * generation/ + 탬플릿아이디 + /...
			 */
			if (rtrnJsp != null) {

				String head = "";
				for (int i = 0; i < rtrnJsp.length(); i++) {
					if (rtrnJsp.charAt(i) != '/') { // 첫 번째 / 를 만나면
						head += rtrnJsp.charAt(i);
					} else {
						head += "/";
						break;
					}
				}

				// head -> generation/
				log.debug("MenuInterceptor - preHandle : head => " + head);

				// 전체에서 head( generation/ )을 ""으로 바꿔주면 나머지 문자열을 구할 수 있다.
				String tail = "/" + rtrnJsp.replace(head, "");
				log.debug("MenuInterceptor - preHandle : tail => " + tail);

				// 작성자 : 방형준 2022.11.29
				// 세션에 담긴 권한에따른 메뉴 접근제어용

				
				
				log.info("authVal 세션에담긴 권한정보 : {}", session.getAttribute("authVal"));
				log.info("menuId 출력 {}", vo.getMenuId());
				String menuAuthVal = (String) session.getAttribute("authVal");
				log.debug( "menuAuthVal : {}", menuAuthVal );
				List<AuthCnctVO> authCnctList = aService.retrieveMenuAuthList(Integer.parseInt(vo.getMenuId()));
				
				boolean authPass = false;

				log.debug( "================ menuAthVal : authCnctList ================" );
				for (AuthCnctVO auth : authCnctList) {
					if(id.equals(auth.getSchId())) {
						if (auth.getAuthMemId().equals(menuAuthVal)) {
							log.debug( "{} == {} = {}", menuAuthVal, auth.getAuthMemId(), auth.getAuthMemId().equals(menuAuthVal) );
							authPass = true;
						}else {
							log.debug( "{} == {} = {}", menuAuthVal, auth.getAuthMemId(), auth.getAuthMemId().equals(menuAuthVal) );
						}
					}
				}
				log.debug( "============================================================" );

				log.info("권한 결과 : {}", authPass);
				// 방형준 끝

				
				// 최현우 : 방형준 코드 이어서 작성
				// authPass의 결과에 따라 rtrnJsp를 결정해준다.
				if( authPass ) {
					// 그리고 rtrnJsp에 head + 탬플릿아이디 + tail을 해주면 중간에 탬플릿아이디를 끼워넣을 수 있다.
					// 최현우작성, 최종가는 rtrnJsp정보.
					rtrnJsp = head + tmp_tmpltId + tail;
					log.info("최종rtrnJsp : {}", rtrnJsp);
					log.info("head: {}", head);
					log.info("tmp_tmpltId: {}", tmp_tmpltId);
					log.info("tail: {}", tail);
					
				}else {
					
					rtrnJsp = "generation/" + tmp_tmpltId + "/common/access";
					
				}
				
			}

			log.debug("MenuInterceptor - preHandle : rtrnJsp => " + rtrnJsp);
			
			// request로 rtrnJsp 값 ( 뷰 랜더링 값 )을 넣어준다.
			session.setAttribute("rtrnJsp", rtrnJsp);

			if (session.getAttribute("templateId") != null) {
				log.info("MenuInterceptor : sessioin.templateId is NOT NULL, VALUE = " + templateId);
			} else {
				log.info("MenuInterceptor : sessioin.templateId is NULL, VALUE = " + templateId);
			}

		} else {
			log.info("MenuInterceptor : ProjectVO pVo is NULL");
		}

		return super.preHandle(request, response, handler);
	}

	// ================================ [후처리] ================================
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.debug("저는 후처리 인터셉터에요. {}", request.getParameterMap());

		log.debug("후처리 [ 요청 URI : {} ]", request.getRequestURI());
		log.debug("후처리 [ 요청 URL : {} ]", request.getRequestURL());
		log.debug("후처리 [ 요청 URL ( getQueryString() ) : {} ]", request.getQueryString()); // ? 뒤에 파라미터까지 줌
		String requestURI = request.getRequestURI();

		/**
		 * /NextPage/generation/a001/history -> 이렇게 바뀜 /generation/a001/history
		 */
		String address = requestURI.replace("/NextPage", "");

		GeneratingMainVO vo = null;

		// ================================ [board, contents 알고리즘] 시작 ================================
		// 요청 url이 contents 타입이나 board타입이면
		vo = temp( address, request );
		// ================================ [board, contents 알고리즘] 끝 ================================

		log.debug("후처리 [ address 변수 : {} ] ", address);

		/**
		 * 
		 * 1. URLMappingHander 호출해서 메뉴목록 가져옴 2. ViewMaker로 header와 left 만듬 3. 세션에 담음 4.
		 * address변수에 담은 주소의 컨트롤러 호출
		 */

		// uri로 매칭되는 튜플 가져와서 그 튜플의 topMenuId를 추출한다.
		// GeneratingMainVO vo = service.selectSchoolByUri(address);

		if (vo != null) {
			log.debug("후처리 [ vo.getTopMenuId() {} ] ", vo.getTopMenuId());
			log.debug("후처리 [ vo.getSchId() {} ] ", vo.getSchId());
			id = vo.getSchId();
			topMenuId = vo.getTopMenuId();
		} else {
			log.debug("후처리 [ vo == null ]");
		}

		HttpSession session = request.getSession(); // 세션객체 생성
	
		List<GeneratingMainVO> data = urlm.getLinksFromDB(vo.getSchId());

		if (data != null && !data.isEmpty()) {

			log.debug("후처리 [ data is NOT null ]");

			headerView = viewMaker.headerViewMaker(id, data, templateId);
			log.debug("후처리 [ headerView ] =========================");
			leftView = viewMaker.leftViewMaker(id, data, topMenuId, templateId);

			session.setAttribute("headerView", headerView);
			session.setAttribute("leftView", leftView);

		}

		// generation/a001/history
		super.postHandle(request, response, handler, modelAndView);
	}

	
	/**
	 * 작성자 : 최현우
	 * @param address
	 * @return
	 */
	public GeneratingMainVO temp( String address, HttpServletRequest request ) {
		
		GeneratingMainVO vo = null;
		
		
		if (address.contains("contents") || address.contains("board")) {
			/*
			 * address += "?" + request.getQueryString();
			 * 
			 * // ?brdNum=173&page=1&searchWord=1
			 * 
			 * String temp = ""; for (int i = 0; i < address.length(); i++) { if
			 * (address.charAt(i) != '&') { temp += address.charAt(i); } else { break; } }
			 * 
			 * address = temp;
			 */

			// brdNum만 추출하는 로직 시작 ( 잭스나이더 알고리즘 ) 시작
			String key = "";
			log.debug("최초 uri : " + address);
			log.debug("parameter : " + request.getQueryString());

			String tmpAddress = address + "?" + request.getQueryString();
			log.debug("FULL REQUEST ADDRESS : " + tmpAddress);

			// /generation/a001/board/detail?brdNum=173&what=48
			if (tmpAddress.contains("brdNum")) {
				// 일단 ? 뒤에 문자열만 추출
				String extractStr = "";
				for (int i = 0; i < tmpAddress.length(); i++) {
					if (tmpAddress.charAt(i) == '?') { // ?를 만나면 그 이후부터의 문자열을 더한다.
						int start = i + 1;
						for (int j = start; j < tmpAddress.length(); j++) {
							extractStr += tmpAddress.charAt(j);
						}
					}
				}
				log.debug("EXTRACTED STRING : " + extractStr);

				// &를 기준으로 문자열을 자른다.
				String[] arr = extractStr.split("&");
				for (int n = 0; n < arr.length; n++) {
					if (arr[n].contains("brdNum")) {
						key = arr[n];
					}
				}
			} else if (tmpAddress.contains("cntntsId")) {

				// 일단 ? 뒤에 문자열만 추출
				String extractStr = "";
				for (int i = 0; i < tmpAddress.length(); i++) {
					if (tmpAddress.charAt(i) == '?') { // ?를 만나면 그 이후부터의 문자열을 더한다.
						int start = i + 1;
						for (int j = start; j < tmpAddress.length(); j++) {
							extractStr += tmpAddress.charAt(j);
						}
					}
				}
				log.debug("EXTRACTED STRING : " + extractStr);

				// &를 기준으로 문자열을 자른다.
				String[] arr = extractStr.split("&");
				for (int n = 0; n < arr.length; n++) {
					if (arr[n].contains("cntntsId")) {
						key = arr[n];
					}
				}

			}
			log.debug("KEY : " + key);
			// brdNum만 추출하는 로직 시작 ( 잭스나이더 알고리즘 ) 끝

			// uri로 매칭되는 튜플 가져와서 그 튜플의 topMenuId를 추출한다.
			// board나 contents로 들어왔다면 brdNum만으로 가져온다.
			log.debug("board영역 실행!");
			vo = service.selectSchoolByBrdNum(key);
		} else {
			// board나 contents로 들어온게 아니면
			log.debug("board외의 다른 영역 실행!!");
			vo = service.selectSchoolByUri(address);

		}
		
		
		return vo;
	}
	
	
}
