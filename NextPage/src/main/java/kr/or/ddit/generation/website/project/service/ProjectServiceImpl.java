package kr.or.ddit.generation.website.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.generation.website.project.dao.ProjectDAO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

	@Inject
	private ProjectDAO dao;

	@Override
	public ProjectVO projectView(String schId) {

		ProjectVO projectVO = dao.selectProject(schId);

		return projectVO;
	}

	@Override
	public List<ProjectVO> divView(String schId) {
		return dao.selectDiv(schId);
	}

}
