package kr.or.ddit.school.manager.content.manage.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.school.manager.content.manage.service.ContentManageService;
import kr.or.ddit.vo.ContentVO;
import kr.or.ddit.vo.Criteria;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PageVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping( "/school/manager/content" )
@Controller
public class ContentManageController {
	
	@Inject
	ContentManageService service;
	
	@RequestMapping( "/list" )
	public String contentManage(
				HttpSession session,
				Model model,
				String pageNum,
				String amount
			) {
		
		log.debug( "============ ContentManageController => contentManage() [ACTIVATED] ============" );
		
		// 페이징 시작
		log.debug( "pageNum : {}", pageNum );
		log.debug( "amount : {}", amount );
		
		Criteria cri;
		if( pageNum == null && amount == null ) {
			cri = new Criteria();
		}else {
			cri = new Criteria( Integer.parseInt( pageNum ), Integer.parseInt( amount ) );
		}
		
		String id = (String) session.getAttribute( "authSch" );
		if( id != null ) {
			log.debug( "(String) session.getAttribute( \"authSch\" ) : {}", id );
			cri.setSchId( id );
		}else {
			log.debug( "(String) session.getAttribute( \"authSch\" ) : null" );
		}
		
		
		List<ContentVO> list = service.getList( cri );
		// 페이징 끝
		if( list != null && !list.isEmpty() ) {
			log.debug( "========== List<ContentVO> HAS DATA ==========" );
			for( ContentVO vo : list ) {
				log.debug( "TITLE : " + vo.getCntntsTitle() );
				log.debug( "ID : " + vo.getCntntsId());
			}
		}else {
			log.debug( "FAILED : List<ContentVO> HAS NO DATA AT ALL" );
		}
		
		// 이전, 다음 버튼
		PageVO pageVO = new PageVO( cri, service.getTotal( id ) );
		model.addAttribute( "pageVO", pageVO ); // 페이지네이션 전달
		model.addAttribute( "list", list ); // 게시글 전달
		
		NpMemberVO member = (NpMemberVO) session.getAttribute( "npMember" );
		String schId = ""; 
		if( member != null ) {
			log.debug( "NpMemberVO member has DATA" );
			schId = member.getNpMemId();
		}else {
			log.debug( "NpMemberVO member has NO DATA" );
		}
		
		List<GeneratingMainVO> menuList = service.getMenuList( schId );
		if( menuList != null && !menuList.isEmpty() ) {
			log.debug( "================ List<GeneratingMainVO> HAS DATA ================ " );
			for( GeneratingMainVO vo : menuList ) {
				log.debug( "[ NAME : " + vo.getMenuNm() + " ] [ LINK :  " + vo.getMenuLink() + " ] [ JSP PATH :  " + vo.getRtrnJsp() + " ] ");
			}
			
			log.debug( "pageVO.pageNum : {}", pageVO.getPageNum() );
			log.debug( "pageVO.startPage : {} ",pageVO.getStartPage() );
			log.debug( "pageVO.endPage : {}", pageVO.getEndPage() );
			log.debug( "pageVO.prev : {}", pageVO.isPrev() );
			log.debug( "pageVO.next : {}", pageVO.isNext() );
			
			session.setAttribute( "menuList", menuList );
			
		}else {
			log.debug( "================ List<GeneratingMainVO HAS 'NO' DATA ================ " );
		}
	
		
		return "schoolManager/92_contentManage/contentManage";
		
	} 
	
	@RequestMapping( "/delete" )
	public String delContent(
				HttpSession session,
				Model model,
				@RequestParam( value = "cntntId", required = false ) String cntntId
			) {
		
		if( cntntId != null ) {
			int result = service.delContent( cntntId );
			log.debug( "{}개 content데이터 삭제 완료", result );
		}else {
			log.debug( "[수행불가] : cntntId 파라미터 없음." );
		}
		
		return "redirect:list";
	}
	
	@RequestMapping( "/add" ) // 컨텐츠 목록에서 '컨텐츠 추가' 버튼
	public String addContent(
				HttpSession session,
				Model model,
				@RequestParam( value = "cntntId", required = false ) String cntntId
			) {
		
		log.debug( "ContentManageController => addContent() [ACTIVATED]" );
		
		if( cntntId != null ) {
			
			log.debug( "@RequestParam -> cntntId : {}", cntntId );
			ContentVO target = service.getContent( cntntId );
			
			/*String cntntTitle = target.getCntntsTitle(); // 컨텐츠 제목
			String cntntsCntnt = target.getCntntsCntnt(); // 컨텐츠 내용
*/	/*		
			// cntntId가 null이 아니면 "수정"버튼을 눌러서 온거니까 기존의 데이터를 뿌려준다.
			session.setAttribute( "cntntTitle" , cntntTitle );
			session.setAttribute( "cntntsCntnt" , cntntsCntnt );*/
			model.addAttribute( "isUpdate" , "UPDATE" );
			
			model.addAttribute( "content", target );
			
		}else {
			log.debug( "@RequestParam -> cntntId : NULL" );
			
			// cntntId가 null이면 "컨텐츠 추가"를 눌러서 온거기 때문에 새로 추가되는거라
			// 데이터가 비어있어야함.
			session.removeAttribute( "cntntTitle" );
			session.removeAttribute( "cntntsCntnt" );
			
		}
		
	
		
		return "schoolManager/93_94_contentForm/contentForm";
		
	}
	
	@RequestMapping( value = "/insert", method = RequestMethod.POST ) // 컨텐츠 등록화면에서 '컨텐츠 추가' 버튼 이벤트
	public String insertContent(
				HttpSession session,
				String textArea,
				String titleName,
				String fileName
			) {
		
		log.debug( "================= ContentManageController - insertContent() [ACTIVATED] ================= " );
		
		log.debug( " Bringing Member information ..." );
		String schId = "";
		NpMemberVO member = (NpMemberVO) session.getAttribute( "npMember" );
		if( member == null ) {
			log.debug( "RESULT : FAILED [session.getAttribute(\"npMember\")] IS NULL" );
		}else {
			log.debug( "RESULT : SUCCESS [session.getAttribute(\"npMember\")] => {} ", member.getNpMemId() );
			schId = member.getNpMemId();
		}
		

		if( service != null ) {
			ContentVO content = new ContentVO();
			
			if( textArea == null ) {
				log.debug( "textArea is NULL" );
			}else {
				log.debug( "textArea = {}", textArea );
				textArea = textArea.replace( "<p>" , "" );
				textArea = textArea.replace( "</p>" , "" );
				
				content.setCntntsCntnt( textArea ); // 컨텐츠 내용
			}
			
			
			if( titleName == null ) {
				log.debug( "titleName is NULL" );
			}else {
				log.debug( "titleName = {}", titleName );
				content.setCntntsTitle( titleName ); // 컨텐츠 제목
			}
			
			content.setFileName(fileName);
			
			content.setSchId( schId ); // 학교아이디
			
			
			log.info("입력전 데이터 : {}", content);
			
			//결과값을 위한 result값 세팅(방형준)
			Integer result = service.insertContent( content ); // DB 저장
			log.info("결과 : {}", result);
			
		
			//Integer result = service.insertContent( content ); // DB 저장
			
			
			
			log.debug( "======== DATA INSERTING ========" );
			log.debug( "schId : {}", schId );
			log.debug( "titleName : {}", titleName );
			log.debug( "textArea : {}", textArea );
			log.debug( "======== INSERTION ON PROCESS ... ========" );
			if( result == 0 ) {
				log.debug( "INSERTION RESULT : FAILED" );
			}else {
				log.debug( "INSERTION RESULT : SUCCESS" );
			}
		}else {
			log.debug( "ContentManageService service = null" );
		}
		
		
		
		
		log.debug( "=========================================================================================" );
		
		// 컨텐츠 등록을 마치면 다시 목록으로 돌아감.
		// schoolManager/92_contentManage/contentManage
		
		return "redirect:list";
		 
	}
	
	

	@RequestMapping( value = "/update", method = RequestMethod.POST )
	public String updateContent(
				HttpSession session,
				Model model, 
				@RequestParam( value = "cntntId", required = false ) String cntntId,
				@RequestParam( value = "title", required = false ) String title,
				@RequestParam( value = "content", required = false ) String content,
				@RequestParam( value = "fileName", required = false ) String fileName
			) {
		String from = "UPDATE";
		
		log.debug( "=========================  updateContent() ========================= " );
		
		log.debug( "cntntId : {}", cntntId );
		log.debug( "title : {}", title );
		log.debug( "content : {}", content );
		
		if( cntntId != null && title != null && content != null ) {
			log.debug( "@RequestParam -> cntntId : {}", cntntId );
			log.debug( "@RequestParam -> title : {}", title );
			log.debug( "@RequestParam -> content : {}", content );
			log.debug( "@RequestParam -> fileName : {}", fileName );
			
			ContentVO target = service.getContent( cntntId );
			
			log.info("타겟정보 : {}", target);
			
			//수정사항없음 체크.
			if(fileName.length() != 0) {
				log.info("파일명 수정이 있다.");
				target.setFileName(fileName);
			}
			
			target.setCntntsTitle( title );
			
			content = content.replace( "<p>" , "" );
			content = content.replace( "</p>" , "" );
			
			target.setCntntsCntnt( content );
			
			
			log.info("타겟정보 : {}", target);
			int result = service.updateContent( target );
			
			log.debug( "UPDATE RESULT : {}", result );
			
		}else {
			log.debug( "@RequestParam -> cntntId : NULL" );
		}
		
		
		
//		return "redirect:list";
		return "redirect:list";
	}
	

}
