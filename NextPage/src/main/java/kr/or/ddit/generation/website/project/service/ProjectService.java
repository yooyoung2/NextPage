package kr.or.ddit.generation.website.project.service;

import java.util.List;

import kr.or.ddit.vo.ProjectVO;

public interface ProjectService {

	/**
	 * 제너레이팅 메인에 레이아웃적용
	 * @param schId
	 * @return
	 */
	public ProjectVO projectView(String schId);

	/**
	 * 적용된 레이아웃에 div값
	 * @param schId
	 * @return
	 */
	public List<ProjectVO> divView(String schId);

}
