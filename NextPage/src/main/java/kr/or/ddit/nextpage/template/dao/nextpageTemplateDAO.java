package kr.or.ddit.nextpage.template.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.genTemplateVO;

@Mapper
public interface nextpageTemplateDAO {
	public int selectTotalRecord(PagingVO vo);
	public List<genTemplateVO> selectCostTemplateList(PagingVO<genTemplateVO> pagingvo);
	public List<genTemplateVO> selectFreeTemplateList(PagingVO<genTemplateVO> pagingvo);
	public int cartInsert(CartVO vo);
}
