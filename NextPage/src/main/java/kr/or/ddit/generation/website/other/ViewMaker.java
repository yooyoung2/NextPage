package kr.or.ddit.generation.website.other;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.generation.website.main.service.GeneratingMainService;
import kr.or.ddit.generation.website.main.service.GeneratingMainServiceImpl;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.SchLogoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * view와 관련된 기능들은 여기에 작성한다.
 * @author PC-04
 *
 *
 * TEMPLATE 03번 후보
 * 1. https://www.free-css.com/free-css-templates/page284/built-better
 * 2. https://www.free-css.com/free-css-templates/page280/sungla
 * 3. https://www.free-css.com/free-css-templates/page285/gymster
 */

@Slf4j
//@RestController
//@RequiredArgsConstructor
//@Controller
//@RequestMapping( "view/maker" )
public class ViewMaker {

	//@Inject
	GeneratingMainService service = new GeneratingMainServiceImpl();
	
	String rootPath = "/NextPage";
	
	List<GeneratingMainVO> data = null;
	
	public List<GeneratingMainVO> getData() {
		return data;
	}

	public void setData(List<GeneratingMainVO> data) {
		this.data = data;
	}

	public ViewMaker( List<GeneratingMainVO> data ) {
		this.data = data;
	}

	public ViewMaker() {}
	
	/**
	 * 작성자 : 최현우
	 * 사수 : 방형준
	 * @param id : 사용자 아이디
	 * @param data : 사용자가 선택한 헤더메뉴 옵션에 대한 데이터 리스트 ( List<GeneratingMainVO> )
	 * @return String view [ [Header Menu] 가공한 문자열의 html태그 데이터 ]
	 * 
	 * 
	 * template아이디를 넘겨서 template아이디 별로 만들어줄까? ( if문으로 분기처리 해서 )
	 * 그러면 GeneratingMainController에서 template아이디를 먼저 가져와야겠군 ( 그래야 여기있는 메소드 호출하면서 파라미터로 넘겨주니까 )
	 * 
	 */
	@RequestMapping( value = "/header", method = RequestMethod.GET )
	public String headerViewMaker( String id, List<GeneratingMainVO> data, String tmpltId ) {
		
		/**
		 * 	TEMPLATE 01 -> 로고, 메인 이미지 headerView에 코딩 되어있음.
		 * 	TEMPLATE 02 -> 로고, 메인 이미지 headerView에 코딩 되어있음.
		 * 	TEMPLATE 03 -> 로고, 메인 이미지 headerView에 코딩 되어있음.
		 */
		
/*		if( service == null ) {
			log.debug( "service is null" );
		}		
		else {
			SchLogoVO logoPath = service.getLogoImage( id );
			
			if( logoPath.getFileName() != null ) {
				log.debug( "FILE NAME : " + logoPath.getFileName() );
			}else {
				log.debug( "logPath is null" );
			}
			log.debug( "FILE NAME IS NULL" );
		}*/
		
		String view = "";

		// ======================== HEADER [ TMPLT001 ] ========================
		if( tmpltId.equalsIgnoreCase( "TMPLT001" ) ) { // template 01번
			
			// 정적부분
			view += "<ul class=\"site-menu main-menu js-clone-nav mr-auto d-none d-lg-block\" style='width: 170%;'>";
			
			// 공통 부분
			/*view +=	"<li class=\"active\">" +
					" <a href=\"/NextPage/generation/main/" + id + "/generatingMain\" class=\"nav-link text-left\">홈</a>" +
					"</li>";*/
			
			for( GeneratingMainVO top : data ) {
				
				if( top.getTopMenuId() == null ) { // 사용자가 선택한 top menu가 있다면
					
		/*			log.info( "상위메뉴( Template 01 ) : " + top.getMenuNm() );
					log.info( "메뉴아이디( Template 01 ) : " + top.getMenuId() );
					log.info( "상위 메뉴 아이디( Template 01 ) : " + top.getTopMenuId() );*/
					
					// 1차 메뉴생성
					view += "<li class=\"has-children\" style='margin-right: 7%;'>\r\n" + 
							"<a href=\"javascript:void(0)\"" + "\r\n" + 
							"class=\"nav-link text-left\">" + top.getMenuNm() +"</a>";
					
					//view += "<li class=\"has-children\">\r\n";
					
					view += "<ul class=\"dropdown\">";
					
					for( GeneratingMainVO bot : data ) {

						if( bot.getTopMenuId() != null && bot.getTopMenuId().equals( top.getMenuId() ) ) {
						
							if( bot.getMenuType().equalsIgnoreCase( "link" ) ) {
								
								log.info( "bot.getTopMenuId [" + bot.getTopMenuId() + "] == [ " + top.getMenuId() + " ]" );
								
								// 위에 1차메뉴에 맞는 <하위>메뉴 생성 ( link O )
								view += "<li><a href=\"" + bot.getMenuLink() + "\">" + bot.getMenuNm() + "</a></li>";
								
							}else {
								/*log.info( "bot.getTopMenuId [" + bot.getTopMenuId() + "] == [ " + top.getMenuId() + " ]" );*/
								
								// 위에 1차메뉴에 맞는 하위메뉴 생성 ( link X )
								view += "<li><a href=\"" + rootPath + bot.getMenuLink() + "\">" + bot.getMenuNm() + "</a></li>";								
							}
							
							
							/*log.info( top.getMenuNm() + " ==> " + bot.getMenuNm() );*/
						}
					}
					
					view += "</ul>";
					view += "</li>";
					
					
					
				}
			}
			
			view += "</ul>";
			
/*			log.info( "================== HEADER VIEW [ TEAMPLATE 01 ] ( ViewMaker ) ==================" );
			log.info( "left view : " + view );
			log.info( "===============================================" );*/
			
			
		} // template 01번 끝
		
		// template 02번 시작
		// ======================== HEADER [ TMPLT002 ] ========================
		else if( tmpltId.equalsIgnoreCase( "TMPLT002" ) ){
			
			// 정적부분
//			view += "   <nav class=\"navbar navbar-expand-lg bg-white navbar-light sticky-top px-4 px-lg-5 py-lg-0\">\r\n" + 
//					"            <a href=\"" + rootPath + "/generation/" + id + "/main\"" + " class=\"navbar-brand\">\r\n" + 
//					"                <h1 class=\"m-0 text-primary\"><i class=\"fa fa-book-reader me-3\"></i>DDIT Highschool</h1>\r\n" + 
//					"            </a>\r\n" + 
//					"            <button type=\"button\" class=\"navbar-toggler\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\">\r\n" + 
//					"                <span class=\"navbar-toggler-icon\"></span>\r\n" + 
//					"            </button>";
//			
//			view += "<a href=\"\" class=\"btn btn-primary rounded-pill px-3 d-none d-lg-block\">Join Us<i class=\"fa fa-arrow-right ms-3\"></i></a>";
//
//			view += "<div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">";
			
			// 동적부분 
			for( GeneratingMainVO top : data ) {
				
				if( top.getTopMenuId() == null ) {
			
/*					log.info( "상위메뉴( Template 02 ) : " + top.getMenuNm() );
					log.info( "메뉴아이디( Template 02 ) : " + top.getMenuId() );
					log.info( "상위 메뉴 아이디( Template 02 ) : " + top.getTopMenuId() );*/
					
					// 1차 메뉴 open
					view += " <div class=\"nav-item dropdown\">";
					view += "<a href=\"javascript:void(0)\" class=\"dropdown-toggle\" data-bs-toggle=\"dropdown\">" + top.getMenuNm() + "</a>";
							
					view += "<div class=\"dropdown-menu rounded-0 rounded-bottom border-0 shadow-sm m-0\">";
					
					for( GeneratingMainVO bot : data ) {
						
						if( bot.getTopMenuId() != null && bot.getTopMenuId().equals( top.getMenuId() ) ) {
							
							// 1차 메뉴의 <하위> 메뉴 생성
							if( bot.getMenuType().equalsIgnoreCase( "link" ) ) {
								// link O
								view += " <a href=\"" + bot.getMenuLink() + "\" class=\"dropdown-item\">" + bot.getMenuNm() + "</a>";
								
							}else {
								// link X
								view += " <a href=\"" + rootPath + bot.getMenuLink() + "\" class=\"dropdown-item\">" + bot.getMenuNm() + "</a>";
							}
							
						}
						
					}
					
					view += "</div>";
					
					
					
					// 1차 메뉴 close
					view += "</div>";
				}
			}
			
			// close~
			view += "</div>";
			view += "</nav>"; 
			
			
	/*		log.info( "================== HEADER VIEW [ TEAMPLATE 02 ] ( ViewMaker ) ==================" );
			log.info( "header view : " + view );
			log.info( "===============================================" );*/
			
		}
		// ======================== HEADER [ TMPLT003 ] ========================
		else if( tmpltId.equalsIgnoreCase( "TMPLT003" ) ) {
			
			/*
			 * 
			 * 			<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="dropdown-a" data-toggle="dropdown">Course </a>
							<div class="dropdown-menu" aria-labelledby="dropdown-a">
								<a class="dropdown-item" href="course-grid-2.html">Course Grid 2 </a>
								<a class="dropdown-item" href="course-grid-3.html">Course Grid 3 </a>
								<a class="dropdown-item" href="course-grid-4.html">Course Grid 4 </a>
							</div>
						</li>
			 * 
			 * 
			 */
			
			view += "<div class=\"collapse navbar-collapse\" id=\"navbars-host\">";
			view += "<ul class=\"navbar-nav ml-auto\">";
			
			for( GeneratingMainVO top : data ) {
				
				
				if( top.getTopMenuId() == null ) {
					
					
/*					log.info( "=====================================================" );
					log.info( "상위메뉴( Template 03 ) : " + top.getMenuNm() );
					log.info( "메뉴아이디( Template 03 ) : " + top.getMenuId() );
					log.info( "상위 메뉴 아이디( Template 03 ) : " + top.getTopMenuId() );
					log.info( "=====================================================" );*/
					
					// 1차 메뉴 open
					view += "<li class=\"nav-item dropdown\">";
					view += "<a class=\"nav-link dropdown-toggle\" href=\"javascript:void(0)\" id=\"dropdown-a\" data-toggle=\"dropdown\">" + top.getMenuNm() + "</a>";
					view += "<div class=\"dropdown-menu\" aria-labelledby=\"dropdown-a\">";
				
					
					for( GeneratingMainVO bot : data ) {
						
						if( bot.getTopMenuId() != null && bot.getTopMenuId().equals( top.getMenuId() ) ) {
							
							// 1차 메뉴의 <하위> 메뉴 생성
							if( bot.getMenuType().equalsIgnoreCase( "link" ) ) {
								// link O
								//view += " <a href=\"" + bot.getMenuLink() + "\" class=\"dropdown-item\">" + bot.getMenuNm() + "</a>";
								view += "<a class=\"dropdown-item\" href=\"" + bot.getMenuLink() + "\">" + bot.getMenuNm() + "</a>";
							}else {
								// link X
								//view += " <a href=\"" + rootPath + bot.getMenuLink() + "\" class=\"dropdown-item\">" + bot.getMenuNm() + "</a>";
								view += "<a class=\"dropdown-item\" href=\"" + rootPath + bot.getMenuLink() + "\">" + bot.getMenuNm() + "</a>";
							}
							
						}
						
					}
					view += "</div>";
					
					
					// 목록 close
					view += "</li>";
				}
			}
			
			
			
			view += "</ul>";
			
			/*view += "	<ul class=\"nav navbar-nav navbar-right\">\r\n" + 
					"                        <li><a class=\"hover-btn-new log orange\" href=\"#\" data-toggle=\"modal\" data-target=\"#login\"><span>LOGIN</span></a></li>\r\n" + 
					"                    </ul>\r\n" + 
					"				</div>";*/
			
	/*		log.info( "================== HEADER VIEW [ TEAMPLATE 03 ] ( ViewMaker ) ==================" );
			log.info( "header view : " + view );
			log.info( "===============================================" );*/
			
		}
		
		
		return view;
	}
	
	/**
	 * 작성자 : 최현우
	 * 사수 : 이유영
	 * 
	 * leftViewMaker은 기본적으로 headerViewMaker로 인해 헤더 메뉴가 생성된 후 실행한다.
	 * 
	 * 왼쪽 메뉴사이드바 같은 경우 헤더에서 클릭하는 1차 메뉴에 대한 하위 메뉴를 보여주기 때문에
	 * 어떤 사이드메뉴를 가져올지는 헤더의 메뉴아이디에 의해 결정된다. 그래서 leftViewMaker메소드는
	 * 다음과 같은 파라미터를 받는다.
	 * 
	 * @param id : 사용자
	 * @param data : DB에서 사용자가 선택한 메뉴만 가져온 리스트
	 * @param topMenuId : 헤더에서 클릭한 메뉴 아이디 ( 이 아이디의 하위 메뉴들을 가져올 예정 )
	 * @return
	 */
	@RequestMapping( value = "left", method = RequestMethod.GET )
	public String leftViewMaker( String id, List<GeneratingMainVO> data, String topMenuId, String tmpltId ) {
		
		String view = "";
		
		// TEMPLATE 01
		if( tmpltId.equalsIgnoreCase( "TMPLT001" ) ) {
			// LEFT MENU정적 부분
			/*	view += " <div class=\"d-flex flex-column flex-shrink-0 p-3 bg-light\" style=\"width: 280px;\">\r\n" + 
						"    <a href=\"#\" class=\"align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none\">\r\n" + 
						"      <svg class=\"bi me-2\" width=\"40\" height=\"32\"></svg>\r\n" + 
						"      <span class=\"fs-4\">메뉴</span>\r\n" + 
						"    </a>";
				
				view += "<hr>";*/
						
				view += "<ul class=\"nav nav-pills flex-column mb-auto\">";
				
				/**
				 * 작성자 : 최현우
				 * count의 목적 :	첫번째 li태그는 그 후에 오는 나머지 li태그와 속성이 다르기 때문에 첫 번째 li태그임을
				 *  			판별하기 위한 변수
				 */
				int count = 1;
				
				/*log.info( "leftViewMaker -> topMenuId : " + topMenuId );*/
				for( GeneratingMainVO menu : data ) {
					
					/**
					 * 처음부터 태그를 만들 때 각 요소의 topMenuId를 숨겨놓는다.
					 */
					
					// 파라미터로 받은 topMenuId와 리스트를 순회하며 각 요소가 가지고 있는 topMenuId를 비교한다.
					/*log.info( "menu.getTopMenuId : " + menu.getTopMenuId() );*/
					if( menu.getTopMenuId() != null ) {
						if( menu.getTopMenuId().equals( topMenuId )) {
							// 메뉴 시작 ( 사이트 메뉴라서 상위 메뉴는 출력안함 )
							if( count == 1 ) {
								
								if( menu.getMenuType().equalsIgnoreCase( "link" ) ) {
									view += " <li class=\"nav-item\">\r\n" + 
											"        <a href=\"" + menu.getMenuLink() + "\"" + "title=" + "\"" + menu.getTopMenuId() + " " + menu.getMenuLink() + "\"" + " class=\"nav-link\" onclick = \"resolver(this)\" aria-current=\"page\">\r\n" +
											"          <svg class=\"bi me-2\" width=\"16\" height=\"16\"><use xlink:href=\"\"/></svg>\r\n" + 
											menu.getMenuNm() + "\r\n" + 
											"        </a>\r\n" + 
											"      </li>";		
								}else {
									// link X
									view += " <li class=\"nav-item\">\r\n" + 
											"        <a href=\"" + rootPath + menu.getMenuLink() + "\"" + "title=" + "\"" + menu.getTopMenuId() + " " + menu.getMenuLink() + "\"" + " class=\"nav-link\" onclick = \"resolver(this)\" aria-current=\"page\">\r\n" +
											"          <svg class=\"bi me-2\" width=\"16\" height=\"16\"><use xlink:href=\"\"/></svg>\r\n" + 
											menu.getMenuNm() + "\r\n" + 
											"        </a>\r\n" + 
											"      </li>";									
								}
								
								
								count += 1;
								
								log.info( "leftViewMaker -> bottoMenuId : " + menu.getMenuNm() );
								// javascript:void(0)
							}else {
								
								if( menu.getMenuType().equalsIgnoreCase( "link" ) ) {
									/**
									 * 수정자 :최현우
									 * 날짜 : 2022-11-24
									 * 내용 : 팀장님 지시로 LINK들어가있는 부분 rootPath 제외시킴
									 */
									// link O
									view += " <li>\r\n" + 
											"        <a href=\"" + menu.getMenuLink() + "\"" + "title=" + "\"" + menu.getTopMenuId() + " " + menu.getMenuLink() + "\"" + "class=\"nav-link link-dark\" onclick = \"resolver(this)\">\r\n" +
											"          <svg class=\"bi me-2\" width=\"16\" height=\"16\"><use xlink:href=\"\"/></svg>\r\n" + 
											menu.getMenuNm() + "\r\n" + 
											"        </a>\r\n" + 
											"      </li>";		
								}else {
									// link X
									view += " <li>\r\n" + 
											"        <a href=\"" + rootPath + menu.getMenuLink() + "\"" + "title=" + "\"" + menu.getTopMenuId() + " " + menu.getMenuLink() + "\"" + "class=\"nav-link link-dark\" onclick = \"resolver(this)\">\r\n" +
											"          <svg class=\"bi me-2\" width=\"16\" height=\"16\"><use xlink:href=\"\"/></svg>\r\n" + 
											menu.getMenuNm() + "\r\n" + 
											"        </a>\r\n" + 
											"      </li>";									
								}
								
							}
						}
						
					
					}
				}
				
				
				// 마무리
				view += "</ul>";
				
				view += "<hr>";
				
				/*view += "</div>";*/
		} // TMPLT001 끝
		
		// TEMPLATE 02
		else if( tmpltId.equalsIgnoreCase( "TMPLT002" ) ) {
			
			// 정적부분
			view += "<a href=\"#\" class=\"d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none\">\r\n" + 
					"      <svg class=\"bi me-2\" width=\"40\" height=\"32\"></svg>\r\n" + 
					"      <span class=\"fs-4\">메뉴</span>\r\n" + 
					"    </a>\r\n" + 
					"    <hr>";
			
			view += "<ul class=\"nav nav-pills flex-column mb-auto\">";
			
			/*log.info( "leftViewMaker -> topMenuId : " + topMenuId );*/
			for( GeneratingMainVO menu : data ) {
				if( menu.getTopMenuId() != null ) {
					if( menu.getTopMenuId().equals( topMenuId )) {
						
						
						if( menu.getMenuType().equalsIgnoreCase( "link" ) ) {
							// LINK O
							view += " <li class=\"nav-item\">\r\n" + 
									"        <a href=\"" + menu.getMenuLink() + "\" class=\"nav-link\" aria-current=\"page\">\r\n" + 
									"          <svg class=\"bi me-2\" width=\"16\" height=\"16\"><use xlink:href=\"\"/></svg>\r\n" + 
									menu.getMenuNm() + "\r\n" + 
									"        </a>\r\n" + 
									"      </li>";

						}else {
							// LINK X
							view += " <li class=\"nav-item\">\r\n" + 
									"        <a href=\"" + rootPath + menu.getMenuLink() + "\" class=\"nav-link\" aria-current=\"page\">\r\n" + 
									"          <svg class=\"bi me-2\" width=\"16\" height=\"16\"><use xlink:href=\"\"/></svg>\r\n" + 
									menu.getMenuNm() + "\r\n" + 
									"        </a>\r\n" + 
									"      </li>";
						}
						
						
					}
					
				}
			}
			
			
			// 마무리
			view += "</ul>";
			
			view += "</hr>";
			
			
		}
		
/*		log.info( "================== LEFT VIEW ( ViewMaker ) ==================" );
		log.info( "left view : " + view );
		log.info( "===============================================" );*/
		
		return view;
	}// TEMPLATE 02 끝
	
	
	/**
	 * 작성자 : 최현우
	 * 하위메뉴 컨트롤러에서 leftViewMaker 메소드를 사용하기 위해선 자신의 topMenuId를 알아야한다.
	 * topMenuId를 알아내기 위해 자신의 링크 끝에 있는 이름을 집어넣어 그 이름과 일치하는 링크의 아이디를 반환한다.
	 * 
	 * 예시 : 학교장인사말의 링크는 /generation/a001/hello 이다. 그럼 menuIdExtractor에
	 * "hello"를 집어넣는다. 그럼 해당 메소드는 학교장인사말의 상위 메뉴인 "학교소개" 메뉴의 아이디를 반환한다.
	 * 
	 * 
	 * menuIdExtractor( "hello" ) ==> 1 
	 * 
	 * 그럼 board나 contents로 끝나는 애들은 어떻게 하지?
	 * ( 얘네는 이름이 겹치는 애들 )
	 * 
	 * @param name, List<GeneratingMainVO>
	 * @return
	 */
	public String menuIdExtractor( String name, List<GeneratingMainVO> data ) {
		
		for( GeneratingMainVO menu : data ) {
			
			String[] urlSplit = menu.getMenuLink().split( "/" );
			
			String word = urlSplit[ urlSplit.length - 1 ]; // 배열의 마지막 단어가 구분 키워드이다.
			
			if( name.equals( word ) ) {
				
			}
			
			
		}
		
		return "";
	}
	
}
