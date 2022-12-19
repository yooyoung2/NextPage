package kr.or.ddit.school.manager.history.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.history.dao.GenLogDAO;
import kr.or.ddit.vo.GenRCRDVO;
import kr.or.ddit.vo.PagingVO;

@Service
@Transactional
public class GenLogServiceImpl implements GenLogService {

	@Inject
	private GenLogDAO dao;

	@Override
	public ServiceResult createLog(GenRCRDVO log) {
		ServiceResult result = null;
		int rowcnt = dao.insertLog(log);
		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public List<GenRCRDVO> selectAllLog(PagingVO<GenRCRDVO>pagingVO) {

		int totalRecord = dao.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecord);

		return dao.selectAllLog(pagingVO);
	}

	@Override
	public List<GenRCRDVO> retrieveLog(Integer recrdType) {
		return dao.selectLog(recrdType);
	}

}
