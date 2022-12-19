package kr.or.ddit.nextpage.template.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.template.dao.nextpageTemplateDAO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.genTemplateVO;

@Service
public class nextpageTemplateServiceImpl implements nextpageTemplateService {
	
	@Inject
	public nextpageTemplateDAO dao;
	
	public List<genTemplateVO> selectCostTemplateList(PagingVO<genTemplateVO> vo){
		int count = dao.selectTotalRecord(vo);
		vo.setTotalRecord(count);
		return dao.selectCostTemplateList(vo);
	}

	@Override
	public ServiceResult cartInsert(CartVO vo) {
		ServiceResult result = null;
		int res = dao.cartInsert(vo);
		return res > 0 ? result.OK : result.FAIL;
	}

	@Override
	public List<genTemplateVO> selectFreeTemplateList(PagingVO<genTemplateVO> pagingvo) {
		int count = dao.selectTotalRecord(pagingvo);
		pagingvo.setTotalRecord(count);
		return dao.selectFreeTemplateList(pagingvo);
	}
}
