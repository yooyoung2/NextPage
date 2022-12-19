package kr.or.ddit.vo;

import lombok.Data;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/INDEX/1년 매출( 월별 출력 ) -> 그래프
 * 
 * 해당 월의 매출액을 표시한다.
 * 
 * @author PC-04
 *
 */
@Data
public class EachMonthSellAmountVO {

	private String month; // 월
	private String total; // 매출액 총합
	
	
}
