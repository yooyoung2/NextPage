package kr.or.ddit.generation.website.templates.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.generation.website.templates.dao.TemplatesDAO;
import kr.or.ddit.vo.TemplatesVO;

@Service
public class TemplatesServiceImpl implements TemplatesService {

	@Inject
	TemplatesDAO dao;
	
	@Override
	public TemplatesVO getFooter( String tmpltId ) {
		
		return dao.getFooter( tmpltId );
		
	}

}
