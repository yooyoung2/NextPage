package kr.or.ddit.school.manager.symbol.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.symbol.dao.SchoolSymbolDAO;
import kr.or.ddit.vo.SchSymbVO;

@Service
public class SchoolSymbolServiceImpl implements SchoolSymbolService {

	@Inject
	private SchoolSymbolDAO dao;

	@Override
	public ServiceResult createSymb(SchSymbVO symbVO) {
		ServiceResult result = null;

		int rowcnt = dao.insertSymbol(symbVO);

		result = rowcnt >0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public SchSymbVO retrieveSymbol(String schId) {
		return dao.selectSymbol(schId);
	}

	@Override
	public ServiceResult modifySymb(SchSymbVO symbVO) {
		retrieveSymbol(symbVO.getSchId());

		int rowcnt = dao.updateSymbol(symbVO);

		return rowcnt >0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

}
