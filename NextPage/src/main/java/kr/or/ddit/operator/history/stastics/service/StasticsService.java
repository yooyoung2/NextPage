package kr.or.ddit.operator.history.stastics.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.VisitCountVO;

/**
 * 작성자 : 최현우
 * @author PC-04
 *
 */
public interface StasticsService {
	
	/**
	 * 일간 방문
	 * @return
	 */
	public List<VisitCountVO> printDaily();
	
	/**
	 * 주간 방문
	 * @return
	 */
	public List<VisitCountVO> printWeekly();
	
	/**
	 * 월간 방문
	 * @return
	 */
	public List<VisitCountVO> printMonthly();
	
}
