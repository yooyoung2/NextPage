package kr.or.ddit.operator.Index.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.Index.dao.DealStatusDAO;
import kr.or.ddit.vo.DealStatusVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DealStatusServiceImpl implements DealStatusService {
	
	@Inject
	DealStatusDAO dao;
	
	
	public List<DealStatusVO> selectAllDeal() {
		
		List<DealStatusVO> lst = dao.selectAllDeal();
		return lst;
		
	}


	/**
	 * 거래 수 반환
	 */
	public int dealCount() {
		
		int dealTotal = dao.dealCount();
		return dealTotal;
		
	}

	
	
}
