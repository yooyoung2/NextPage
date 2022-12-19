package kr.or.ddit.operator.Index.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.Index.dao.SellStatusDAO;
import kr.or.ddit.vo.SellStatusVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 기능 : 결제현황
 * @author PC-04
 *
 */
@Slf4j
@Service
public class SellStatusServiceImpl implements SellStatusService {

	@Inject
	SellStatusDAO dao;
	
	
	public List<SellStatusVO> selectAll() {

		List<SellStatusVO> lst = dao.selectAll();
		
		if( lst != null && !lst.isEmpty() ) {
			log.info( "dao.selectAll() 성공" );
		}else {
			log.info( "dao.selectAll() 실패" );
		}
		
		return lst;
		
	}


	/**
	 * 지금까지 총 매출액
	 * @return
	 */
	public Integer sellTotalAmount() {
		
		Integer total = dao.sellTotalAmount();
		
		if( total > 0 ) {
			return dao.sellTotalAmount();			
		}else {
			return 0;
		}
		
	}

}
