package kr.or.ddit.operator.history.log.service;

import java.util.List;
import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;


/**
 * 로그서비스
 * @author PC-06
 *
 */
public interface LogService {

	//로그추가
	public ServiceResult createLog(LogVO log);

	//전체로그리스트
	public List<LogVO> selectAllLog(PagingVO<LogVO>pagingVO);

	//타입별 로그리스트
	public List<LogVO> retrieveLog(Integer logTypeId);


}
