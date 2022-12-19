package kr.or.ddit.generation.website.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.ProjectVO;


@Mapper
public interface ProjectDAO {

	/**
	 * 제너레이팅 메인에 레이아웃적용
	 * @param schId
	 * @return
	 */
	public ProjectVO selectProject(String schId);

	/**
	 * 적용된 레이아웃에 div값
	 * @param schId
	 * @return
	 */
	public List<ProjectVO> selectDiv(String schId);

}
