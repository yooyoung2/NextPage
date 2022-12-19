package kr.or.ddit.school.manager.history.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.GenRCRDVO;
import kr.or.ddit.vo.PagingVO;

/**
 * 제너레이팅 사이트 로그
 * @author PC-06
 *
 */
public interface GenLogService {

	//로그추가
	public ServiceResult createLog(GenRCRDVO log);

	//전체로그리스트
	public List<GenRCRDVO> selectAllLog(PagingVO<GenRCRDVO>pagingVO);

	//타입별 로그리스트
	public List<GenRCRDVO> retrieveLog(Integer recrdType);

}
