package kr.or.ddit.operator.history.stastics.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.history.stastics.dao.TemplateDAO;
import kr.or.ddit.vo.TemplateStasticsVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TemplateServiceImpl implements TemplateService{

	@Inject
	TemplateDAO dao;
	
	@Override
	public List<TemplateStasticsVO> templateSell() {
		// TODO Auto-generated method stub
		return dao.templateSell();
	}

	@Override
	public List<TemplateStasticsVO> templateUse() {
		// TODO Auto-generated method stub
		return dao.templateUse();
	}

}
