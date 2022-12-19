package kr.or.ddit.operator.Index.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.Index.dao.VisitCountDAO;
import kr.or.ddit.vo.VisitCountVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/INDEX/누적 방문자수 출력
 * @author PC-04
 *
 */

@Slf4j
@Service
public class VisitCountServiceImpl implements VisitCountService {

	@Inject
	VisitCountDAO dao;
	
	/**
	 * 작성자 : 최현우
	 * 기능 : 누적 방문자 수를 반환
	 */
	public int selectVistorsAll() {
		
		return dao.selectVistorsAll();
		
	}

	
	/**
	 * 일간 방문자 수
	 */
	public List<VisitCountVO> selectDailyVisitor() {
		// TODO Auto-generated method stub
		return dao.selectDailyVisitor();
	}

	
	/**
	 * 주간 방문자 수
	 */
	public List<VisitCountVO> selectWeeklyVisitor() {
		
		return dao.selectWeeklyVisitor();
	}

	
	/**
	 * 월간 방문자 수
	 */
	public List<VisitCountVO> selectMonthlyVisitor() {
		
		return dao.selectMonthlyVisitor();
	}

}
