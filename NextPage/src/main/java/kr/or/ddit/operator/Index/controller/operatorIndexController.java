package kr.or.ddit.operator.Index.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.operator.Index.service.DealStatusService;
import kr.or.ddit.operator.Index.service.EachMonthSellAmountService;
import kr.or.ddit.operator.Index.service.MemberAmountService;
import kr.or.ddit.operator.Index.service.SellStatusService;
import kr.or.ddit.operator.Index.service.VisitCountService;
import kr.or.ddit.vo.DealStatusVO;
import kr.or.ddit.vo.EachMonthSellAmountVO;
import kr.or.ddit.vo.SellStatusVO;
import lombok.extern.slf4j.Slf4j;

/*
 * 작성자 : 최현우
 * 작업페이지 : 운영자 INDEX 페이지
 * 작업시작 : 1869년 11월 09일
 * 특이사항 : INDEX를 제외한 운영자 페이지 전반적으로 비어보임, 그래서 채워야함
 * 작업목록 : 
 * 			1.	매출현황 ( 그래프 )
 * 				필요테이블 : 결제내역( PAY_BRKDWN ), 상품( PRD_ITEMS ) 
 * 
 * 			2.	방문자수 ( 그래프 ) -> 월,화,수,목,금,토,일 
 * 				필요테이블 : VISITOR
 * 
 * 			3.	거래현황 ( 목록 )
 *  			필요테이블 : 탬플릿, 학교, 상품  
 *  			언제, 어떤것을, 누가, 얼마에, 구매( 결제 성공여부 )
 *  			
 * 			4.	탬플릿별 판매현황 
 * 				필요테이블 :
 * 				어떤 유저가 어떤 탬플릿을 구매했는지 
 * 
 * 			5.	유입자수 ( 그래프 ) -> 회원수 하면 될듯 ( 표현은 신규로 하지만 걍 회원수 뿌림 )
 * 				필요테이블 : VISITOR
 * 
 */

@Slf4j
@Controller
@RequestMapping( "/operator" )
public class operatorIndexController {
	
	@Inject
	SellStatusService sellService; // 매출현황
	
	@Inject
	DealStatusService dealService; // 거래현황
	
	@Inject
	VisitCountService visitService; // 방문자 수
	
	@Inject
	MemberAmountService memService; // 회원 수
	
	@Inject
	EachMonthSellAmountService monthService; // 월별 매출액
	
	@RequestMapping( "/index" )
	public ModelAndView operatorIndex(
			HttpSession session
			) {
		
		log.debug( "============ CLASS : [operatorIndexController] ACTIVATED ============" );
		
		ModelAndView mav = new ModelAndView();
		if( !mav.isEmpty() && mav != null ) {
			log.debug( "ModelAndView mav is not NULL" );
		}else {
			log.debug( "ModelAndView mav is NULL" );
		}
		
		String operatorViewName = ( String )session.getAttribute( "operatorViewName" );
		log.debug( "======================================================" );
		log.debug( "String operatorViewName = " + operatorViewName );
		log.debug( "======================================================" );
		
		String auth = (String) session.getAttribute( "nextAuth" );
		
		if( auth != null ) {
			// 누군가 로그인 한 상태
			if( auth.equals( "ADMIN" ) ) {
				mav.setViewName( "operator/01_operatorIndex/operatorIndex" ); // 운영자 index뷰							
			}else {
				mav.setViewName( "nextpage/nomenu/02_nextPageMain/nextPageMain" ); // 넥스트페이지 메인	
			}
		}else {
			// 아무도 로그인 하고 있지 않은 상태
			mav.setViewName( "nextpage/nomenu/02_nextPageMain/nextPageMain" ); // 넥스트페이지 메인
		}
		
		/*mav.setViewName( operatorViewName );*/
		log.debug( "operatorViewName set into mav as [" + operatorViewName + "]" );
		
		log.debug( "======================================================" );
		log.debug( "=============== DATA LIST OBJECT CHECK ===============" );
		
		// 판매현황
		List<SellStatusVO> lst = sellStatus();
		if( !lst.isEmpty() && lst != null ) {
			log.debug( "List<SellStatusVO> lst IS NOT NULL" );
		}else {
			log.debug( "List<SellStatusVO> lst IS NULL" );
		}
		
		
		// 누적방문자 수
		int totalVisitors = totalVisitorsNumber();
		if( totalVisitors > 0 ) {
			log.debug( "int totalVisitors : " + totalVisitors );
		}else {
			log.debug( "FAILED BRINGING DATA FROM totalVisitors " );
		}
			
		
		// 회원 수
		int totalMem = totalMemberAmount();
		
		
		// 총 판매금액
		Integer totalSell = totalSellAmount();
		if( totalSell == null ) {
			totalSell = (int) Math.random() * 100000; 
		}
		
		// 거래 수 반환
		int dealTotal = dealTotalNumber();
		
		// 거래현황 ( 인덱스 페이지 )
		List<DealStatusVO> dealList = dealStatus();
		
		// 월별 매출금액
		List<EachMonthSellAmountVO> eachMonth = eachMonthSellTotal(); 
		
		mav.addObject( "sellList" , lst );
		mav.addObject( "totalVisitors", totalVisitors );
		mav.addObject( "totalMem", totalMem );
		mav.addObject( "totalSell", totalSell );
		mav.addObject( "dealTotal", dealTotal );
		mav.addObject( "eachMonth", eachMonth );
		mav.addObject( "dealList", dealList );
		
		log.debug( "============ CLASS : [operatorIndexController] DEACTIVATED ============" );
		
		return mav;
		
	}
	

	
	// 매출현황 조회
	// 어노테이션 없는 이유는 얘는 매핑이 필요없음.
	public List<SellStatusVO> sellStatus() {
		
		List<SellStatusVO> lst = sellService.selectAll();
		
		if( lst != null && !lst.isEmpty() ) {
			log.info( "매출현황 Select Success" );
		}else {
			log.info( "매출현황 Select Fail" );
		}
		
		return lst;
		
	}
	
	// 거래현황 조회
	public List<DealStatusVO> dealStatus(){
		
		List<DealStatusVO> lst = dealService.selectAllDeal();
		
		if( lst != null && !lst.isEmpty() ) {
			log.info( "거래현황 Select Success" );
		}
		
		return lst;
		
	}
	
	// 누적 방문자수
	public int totalVisitorsNumber() {
		
		int totalNum = visitService.selectVistorsAll();
		
		if( totalNum > 0 ) {
			log.info( "누적 방문자 수  : " + totalNum );
		}
		
		return totalNum;
		
	}
	
	
	
	
	// 전체 회원 수
	public int totalMemberAmount() {
		
		int memTotal = memService.selectMemberAll();
		if( memTotal > 0 ) {
			log.info( "회원 수 : " + memTotal );
		}
		
		return memTotal;
		
	}
	
	// 총 판매 금액
	public Integer totalSellAmount() {
		
		Integer sellTotal = sellService.sellTotalAmount();
		if( sellTotal > 0 ) {
			log.info( "총 판매금액  : " + sellTotal );
		}
		
		return sellTotal;
		
	}
	
	// 거래 수 반환
	public int dealTotalNumber() {
		
		int dealTotal = dealService.dealCount();
		if( dealTotal > 0 ) {
			log.info( "총 거래 수 : " + dealTotal );
			return dealTotal;
		}else {
			return 0;
		}
		
	}
	
	// 월별 매출액 ( 1월 ~ 12월 )
	public List<EachMonthSellAmountVO> eachMonthSellTotal() {
		
		List<EachMonthSellAmountVO> lst = monthService.eachMonthSell();
		log.info( "12월 ---> " + lst.size() );
		if( lst != null && !lst.isEmpty() ) {
			for( EachMonthSellAmountVO vo : lst ) {
				log.info( vo.getMonth() + "월 : $" +  vo.getTotal() );
				log.info( "=========================================" );
			}
		}
		
		return lst;
		
	}
	
	
	
	
	
	
	
	
	
	

}
