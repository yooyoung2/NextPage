package kr.or.ddit.operator.Index.service;

import java.util.List;

import kr.or.ddit.vo.VisitCountVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/INDEX/누적 방문자수 출력
 * @author PC-04
 *
 */

public interface VisitCountService {

	public int selectVistorsAll();
	
	/**
	 * 일간 방문자 수
	 * @return
	 */
	public List<VisitCountVO> selectDailyVisitor();
	
	/**
	 * 주간 방문자 수
	 * @return
	 */
	public List<VisitCountVO> selectWeeklyVisitor();
	
	
	/**
	 * 월간 방문자 수
	 * @return
	 */
	public List<VisitCountVO> selectMonthlyVisitor();
	
}
