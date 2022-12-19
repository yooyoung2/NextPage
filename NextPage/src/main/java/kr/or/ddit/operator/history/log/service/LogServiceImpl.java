package kr.or.ddit.operator.history.log.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.operator.history.log.dao.LogDAO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class LogServiceImpl implements LogService {

	@Inject
	private LogDAO dao;

	@Override
	public ServiceResult createLog(LogVO log) {
		ServiceResult result = null;
		int rowcnt = dao.insertLog(log);
		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public List<LogVO> selectAllLog(PagingVO<LogVO>pagingVO) {
		int totalRecord = dao.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecord);

		return dao.selectAllLog(pagingVO);
	}

	@Override
	public List<LogVO> retrieveLog(Integer logTypeId) {

		return dao.selectLog(logTypeId);
	}


}
