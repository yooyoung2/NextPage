package kr.or.ddit.operator.Index.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.SellStatusVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자 INDEX / 매출( 수익 )현황
 * @author PC-04
 *
 */

@Mapper
public interface SellStatusDAO {

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
