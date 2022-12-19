package kr.or.ddit.operator.history.stastics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.VisitCountVO;

@Mapper	
public interface StasticsDAO {

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
