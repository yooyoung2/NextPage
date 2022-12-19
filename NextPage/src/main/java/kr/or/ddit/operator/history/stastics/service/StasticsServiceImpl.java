package kr.or.ddit.operator.history.stastics.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.history.stastics.dao.StasticsDAO;
import kr.or.ddit.vo.VisitCountVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * @author PC-04
 *
 */

@Slf4j
@Service
public class StasticsServiceImpl implements StasticsService {
	
	@Inject
	StasticsDAO dao;
	
	public List<VisitCountVO> printDaily() {
		
		List<VisitCountVO> daily = dao.printDaily();
		
		return daily;
	}

	@Override
	public List<VisitCountVO> printWeekly() {
		
		List<VisitCountVO> weekly = dao.printWeekly();
		
		return weekly;
	}

	@Override
	public List<VisitCountVO> printMonthly() {
		
		List<VisitCountVO> monthly = dao.printMonthly();
		
		return monthly;
	}

	

	
	
}
