package kr.or.ddit.operator.payment.status.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.Criteria;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;

@Mapper
public interface PaymentStatusDAO {

	public List<LogVO> selectAllLog(PagingVO<LogVO>pagingVO);
	
	public int selectTotalRecord(PagingVO<LogVO> pagingVO);

	/**
	 * 로그타입별 상세조회
	 * @param logTypeId
	 * @return
	 */
	public List<LogVO> selectLog(Integer logTypeId);
	
	
	/**
	 * 페이징 정보가 반영된 리스트 구하기
	 * @param cri
	 * @return
	 */
	public List<SchMemberVO> getList( Criteria cri );
	
	
}
