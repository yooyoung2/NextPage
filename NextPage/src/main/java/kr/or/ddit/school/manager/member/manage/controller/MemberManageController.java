package kr.or.ddit.school.manager.member.manage.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.school.manager.member.manage.service.MemberManageService;
import kr.or.ddit.vo.ContentVO;
import kr.or.ddit.vo.Criteria;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.SchMemberVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 학교 관리자 - 회원관리 [컨트롤러]
 * @author PC-04
 *
 */

@Slf4j
@RequestMapping( "/school/manager/member" )
@Controller
public class MemberManageController {
	
	@Inject
	MemberManageService service;
	
	@RequestMapping("/list")
	public String memberManage(
				HttpSession session,
				Model model,
				String pageNum,
				String amount
			) {
		
		// 로직 시작
		log.debug( " ======================== MemberManageController - memberManage() [ACTIVATED] ========================" );
		
		
		// 페이징 시작
		/*
		 * pageNum : 현재 내가 있는 페이지 위치
		 * amount : 한 페이지에 보여질 게시물 수
		 */
		log.debug( "pageNum : {}", pageNum );
		log.debug( "amount : {}", amount );
		
		// ========== 페이징에 대한 정보 세팅 [시작] ==========
		Criteria cri; // 크라이테리아 : 페이징에 기준이 될 정보들을 저장할 객체
		/**
		 * 가지고 있는 필드 --> pageNum, amount ( SQL QUERY문에 넣을 2개의 파리미터 값 )
		 * 
		 * 아래 분기문에서 어느 페이지에서 시작할지와 한 페이지당 몇개의 게시물을 보여줄것인지가 정해진다.
		 */
		if( pageNum == null && amount == null ) {
			// 파라미터가 없다면 1페이지부터 시작
			cri = new Criteria();
		}else {
			// 파라미터가 있다면 n페이지부터 시작
			if( pageNum.equals( "0" ) ) {
				pageNum = "1";
			}
			cri = new Criteria( Integer.parseInt( pageNum ), Integer.parseInt( amount ) );
		}
		// ========== 페이징에 대한 정보 세팅 [끝] ==========
		
		
		
		// ========== 학교 아이디 가져오기 [시작] ==========
		/**
		 * 특정 학교의 구성원 목록이므로 먼저 '어떤'학교인지에 대한 정보가 필요하다.
		 * 그래서 NextPage에서 로그인한 학교관리자 계정의 아이디를 먼저 가져온다.
		 */
		String id = (String) session.getAttribute( "authSch" );
		if( id != null ) {
			log.debug( "(String) session.getAttribute( \"authSch\" ) : {}", id );
			// session으로부터 아이디를 성공적으로 가져왔다면 cri객체에 넣어준다.
			cri.setSchId( id );
		}else {
			log.debug( "(String) session.getAttribute( \"authSch\" ) : null" );
		}
		// ========== 학교 아이디 가져오기 [끝] ==========
		
		
		// ========== 페이징 처리된 리스트 가져오기 [시작] ==========
		List<SchMemberVO> list = service.getList( cri );
		// 페이징 끝
		if( list != null && !list.isEmpty() ) {
			log.debug( "========== List<ContentVO> HAS DATA ==========" );
			for( SchMemberVO vo : list ) {
				log.debug( "NAME : " + vo.getMemNm() );
				log.debug( "ID : " + vo.getMemId() );
			}
		}else {
			log.debug( "FAILED : List<SchMemberVO> HAS NO DATA AT ALL" );
		}
		// ========== 페이징 처리된 리스트 가져오기 [끝] ==========
		
		
		// ========== 페이징 - 이전, 다음버튼 기준 만들기  [시작] ==========
		PageVO pageVO = new PageVO( cri, service.getTotal( id ) );
		model.addAttribute( "pageVO", pageVO ); // 페이지네이션 전달
		model.addAttribute( "list", list ); // 게시글 전달
		
		
		log.debug( "pageVO.pageNum : {}", pageVO.getPageNum() );
		log.debug( "pageVO.startPage : {} ",pageVO.getStartPage() );
		log.debug( "pageVO.endPage : {}", pageVO.getEndPage() );
		log.debug( "pageVO.prev : {}", pageVO.isPrev() );
		log.debug( "pageVO.next : {}", pageVO.isNext() );
		// ========== 페이징 - 이전, 다음버튼 기준 만들기  [끝] ==========
			
		// 로직 끝
		log.debug( " ======================== MemberManageController - memberManage() [DEACTIVATED] ======================" );
		
		
		
		return "schoolManager/110_memberManage/memberManage";
	}
}
