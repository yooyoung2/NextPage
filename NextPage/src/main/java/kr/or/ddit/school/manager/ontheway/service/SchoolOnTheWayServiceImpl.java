package kr.or.ddit.school.manager.ontheway.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.ontheway.dao.SchoolOnTheWayDAO;
import kr.or.ddit.vo.GenDrctnVO;


@Service
public class SchoolOnTheWayServiceImpl implements SchoolOnTheWayService {

	@Inject
	private SchoolOnTheWayDAO dao;

	ServiceResult result = null;

	@Override
	public ServiceResult createMap(GenDrctnVO gendrctnVO) {
		int rowcnt = dao.insertMap(gendrctnVO);

		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public GenDrctnVO retrieveMap(String schId) {
		return dao.selectMap(schId);
	}

	@Override
	public ServiceResult modifyMap(GenDrctnVO gendrctnVO) {
		int rowcnt = dao.updateMap(gendrctnVO);

		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

}
