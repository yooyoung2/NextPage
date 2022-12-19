package kr.or.ddit.school.manager.history.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.GenRCRDVO;
import kr.or.ddit.vo.PagingVO;


@Mapper
public interface GenLogDAO {

	/**
	 * 로그찍기
	 * @param log
	 * @return
	 */
	public int insertLog(GenRCRDVO log);

	/**
	 * 로그전체목록
	 * @return
	 */
	public List<GenRCRDVO> selectAllLog(PagingVO<GenRCRDVO>pagingVO);
	public int selectTotalRecord(PagingVO<GenRCRDVO> pagingVO);

	/**
	 * 로그타입별 상세조회
	 * @param logTypeId
	 * @return
	 */
	public List<GenRCRDVO> selectLog(Integer recrdType);



}
