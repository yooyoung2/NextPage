package kr.or.ddit.generation.options.footer.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.generation.options.footer.dao.FooterDAO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FooterServiceImpl implements FooterService {

	@Inject
	private FooterDAO dao;

	@Override
	public SchoolVO selectGenFooter(String schId) {
		return dao.selectFooter(schId);
	}

}
