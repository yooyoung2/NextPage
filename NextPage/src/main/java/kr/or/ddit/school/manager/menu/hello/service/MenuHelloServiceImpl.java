package kr.or.ddit.school.manager.menu.hello.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.menu.hello.dao.MenuHelloDAO;
import kr.or.ddit.vo.FTP_Module;

import kr.or.ddit.vo.SchGretngVO;

@Service
public class MenuHelloServiceImpl implements MenuHelloService {

	@Inject
	private MenuHelloDAO dao;

	@Override
	public ServiceResult createHello(SchGretngVO schGretngVO) {
		ServiceResult result = null;
		int rowcnt = dao.insertHello(schGretngVO);
		
		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public SchGretngVO selectHello(String schId) {
		return dao.selectHello(schId);
	}

	@Override
	public ServiceResult modifyHello(SchGretngVO schGretngVO) {
		selectHello(schGretngVO.getSchId());
		int rowcnt = dao.updateHello(schGretngVO);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

}
