package kr.or.ddit.nextpage.template.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.genTemplateVO;

public interface nextpageTemplateService {
	public List<genTemplateVO> selectCostTemplateList(PagingVO<genTemplateVO> pagingvo);
	public List<genTemplateVO> selectFreeTemplateList(PagingVO<genTemplateVO> pagingvo);
	public ServiceResult cartInsert(CartVO vo);
}
