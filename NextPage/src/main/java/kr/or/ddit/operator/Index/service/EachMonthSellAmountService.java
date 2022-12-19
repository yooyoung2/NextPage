package kr.or.ddit.operator.Index.service;

import java.util.List;

import kr.or.ddit.vo.EachMonthSellAmountVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/INDEX/1년 매출( 월별 출력 ) -> 그래프
 * 
 * 해당 월의 매출액을 표시한다.
 * 
 * @author PC-04
 *
 */
public interface EachMonthSellAmountService {

	/**
	 * 작성자 : 최현우
	 * 기능 : 각 월의 매출액 저장
	 * @return
	 */
	public List<EachMonthSellAmountVO> eachMonthSell();
}
