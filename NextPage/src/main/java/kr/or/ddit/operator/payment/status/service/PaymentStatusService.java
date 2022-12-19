package kr.or.ddit.operator.payment.status.service;

import java.util.List;

import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;

public interface PaymentStatusService {

	//전체로그리스트
	public List<LogVO> selectAllLog(PagingVO<LogVO>pagingVO);

	//타입별 로그리스트
	public List<LogVO> retrieveLog(Integer logTypeId);
	
}
