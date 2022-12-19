package kr.or.ddit.generation.options.footer.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.SchoolVO;


@Mapper
public interface FooterDAO {

	/**
	 * 제너레이팅 푸터
	 * @param schId
	 * @return
	 */
	public SchoolVO selectFooter(String schId);
}
