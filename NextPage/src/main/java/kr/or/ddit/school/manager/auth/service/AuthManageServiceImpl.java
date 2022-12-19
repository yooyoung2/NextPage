package kr.or.ddit.school.manager.auth.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.school.manager.auth.dao.AuthManageDao;
import kr.or.ddit.vo.AuthCnctVO;

@Service
public class AuthManageServiceImpl implements AuthManageService {

	@Inject
	public AuthManageDao authManageDAO;

	@Override
	public int insertAuth(AuthCnctVO authCnct) {
		
		return authManageDAO.insertAuth(authCnct);
	}

	@Override
	public String[] retrieveAuthCnctList(AuthCnctVO authCnct) {
		
		return authManageDAO.selectAuthCnctList(authCnct);
	}

	@Override
	public int deleteAuth(AuthCnctVO authCnct) {
		
		return authManageDAO.deleteAuth(authCnct);
	}

	@Override
	public int updateAuth(AuthCnctVO authCnct) {
		return authManageDAO.updateAuth(authCnct);
	}

	@Override
	public List<AuthCnctVO> retrieveAuthList(int num) {
		
		return authManageDAO.selectAuthList(num);
	}

	@Override
	public List<AuthCnctVO> retrieveMenuAuthList(int num) {
		
		return authManageDAO.selectMenuAuthList(num);
	}
}
