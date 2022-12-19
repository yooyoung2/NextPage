package kr.or.ddit.operator.payment.status.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.payment.status.dao.PaymentStatusDAO;
import kr.or.ddit.vo.LogVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {

	@Inject
	PaymentStatusDAO dao;
	
	@Override
	public List<LogVO> selectAllLog(PagingVO<LogVO> pagingVO) {
		// TODO Auto-generated method stub
		return dao.selectAllLog(pagingVO);
	}

	@Override
	public List<LogVO> retrieveLog(Integer logTypeId) {
		// TODO Auto-generated method stub
		return dao.selectLog(logTypeId);
	}

}
