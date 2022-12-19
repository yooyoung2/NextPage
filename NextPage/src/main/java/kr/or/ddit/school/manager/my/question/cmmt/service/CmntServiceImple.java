package kr.or.ddit.school.manager.my.question.cmmt.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.my.question.cmmt.dao.CmntDAO;
import kr.or.ddit.vo.OtoCmntVO;

/**
 * 넥스트 페이지 답변 서비스
 * 구지현
 * @author PC-06
 *
 */


@Service
public class CmntServiceImple implements CmntService {

	@Inject
	private CmntDAO dao;

	@Override
	public ServiceResult createCmnt(OtoCmntVO cmnt) {
		ServiceResult result = null;
		int rowcnt = dao.insertCmnt(cmnt);

		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;

		return result;
	}

	@Override
	public List<OtoCmntVO> retrieveCmntList(Integer otoBrdNum) {

		return dao.selectCmntList(otoBrdNum);
	}

	@Override
	public ServiceResult modifyCmnt(OtoCmntVO cmnt) {
		retrieveCmntList(cmnt.getCmmntId());

		int rowcnt = dao.updateCmnt(cmnt);

		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult deleteCmnt(OtoCmntVO cmnt) {
		retrieveCmntList(cmnt.getCmmntId());

		int rowcnt = dao.deleteCmnt(cmnt.getCmmntId());

		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public OtoCmntVO retrieveCmnt(Integer cmmntId) {
		OtoCmntVO cmnt = dao.selectCmnt(cmmntId);
		if(cmmntId ==null) {
			throw new RuntimeException();
		}

		return cmnt;
	}





}
