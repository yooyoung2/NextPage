package kr.or.ddit.operator.history.log.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;

@Mapper
public interface LogDAO {
	/**
	 * 로그찍기
	 * @param log
	 * @return
	 */
	public int insertLog(LogVO log);

	/**
	 * 로그전체목록
	 * @return
	 */
	public List<LogVO> selectAllLog(PagingVO<LogVO>pagingVO);
	public int selectTotalRecord(PagingVO<LogVO> pagingVO);

	/**
	 * 로그타입별 상세조회
	 * @param logTypeId
	 * @return
	 */
	public List<LogVO> selectLog(Integer logTypeId);




}
