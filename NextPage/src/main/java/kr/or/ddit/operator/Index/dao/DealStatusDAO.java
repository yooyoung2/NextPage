package kr.or.ddit.operator.Index.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.DealStatusVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/INDEX 거래현황
 * @author PC-04
 *
 */

@Mapper
public interface DealStatusDAO{

	/**
	 * 거래 현황 ( 목록 반환 )
	 * @return
	 */
	public List<DealStatusVO> selectAllDeal();
	
	/**
	 * 거래 수 ( 정수 반환 )
	 * @return
	 */
	public int dealCount();
	
}
