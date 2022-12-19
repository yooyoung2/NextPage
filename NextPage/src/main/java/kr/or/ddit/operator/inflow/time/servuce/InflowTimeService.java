package kr.or.ddit.operator.inflow.time.servuce;

import java.util.List;

import kr.or.ddit.vo.InflowTimeVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/통계분석/유입시간대 분석
 * 설명 : 00시 ~ 23시의 방문자 수 통계
 * @author choim
 *
 */

public interface InflowTimeService {

	/**
	 * 작성자 : 최현우
	 * 시간대,방문자 수 반환
	 * @return
	 */
	public List<InflowTimeVO> getData();
	
}
