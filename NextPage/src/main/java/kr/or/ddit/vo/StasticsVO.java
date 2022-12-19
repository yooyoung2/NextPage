package kr.or.ddit.vo;

/**
 * 
 * 운영자 - 통계분석
 * 1. 방문 현황( 필요 테이블 : 학교 ) [ 일간, 주간, 월간 ] 
 * 2. 유입시간대( 필요 테이블 : 학교 )
 * 3. 탬플릿 분석( 필요 테이블 : 프로젝트, 제너레이트사이트 -> 조인 필요 )
 * 4. 수익 현황 ( 필요 테이블 : 결제내역 )
 * 
 * @author PC-04
 *
 */

/*
 * 
 * 방문자
 * 
 * 
 * 
 * 
 */


public class StasticsVO {

	private int dailyVisit;
	private int weeklyVisit;
	private int monthlyVisit;
	
}
