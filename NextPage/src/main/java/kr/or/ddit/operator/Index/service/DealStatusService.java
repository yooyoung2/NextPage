package kr.or.ddit.operator.Index.service;

import java.util.List;

import kr.or.ddit.vo.DealStatusVO;

public interface DealStatusService {

	
	/**
	 * 거래 현황 ( 목록 반환 )
	 * @return 거래 목록
	 */
	public List<DealStatusVO> selectAllDeal();
	
	/**
	 * 거래 수 ( 정수 반환 )
	 * @return 거래 수
	 */
	public int dealCount();
	
}
