package kr.or.ddit.operator.Index.service;

import java.util.List;

import kr.or.ddit.vo.SellStatusVO;

public interface SellStatusService {

	/**
	 * 모든 매출 목록을 가져온다.
	 * 조회되는 정보는 년/월과 해당 월에 판매된 총금액수
	 * @return
	 */

	public List<SellStatusVO> selectAll();
	
	
	/**
	 * 지금까지 총 매출액
	 * @return
	 */
	public Integer sellTotalAmount();
	
}
