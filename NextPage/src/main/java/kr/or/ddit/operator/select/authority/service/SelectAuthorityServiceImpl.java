package kr.or.ddit.operator.select.authority.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.select.authority.dao.SelectAuthorityDAO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SelectAuthorityServiceImpl implements SelectAuthorityService {

	@Inject
	private SelectAuthorityDAO dao;

	@Override
	public List<NpMemberVO> selectAllMemAuth(PagingVO<NpMemberVO> pagingVO) {
		int totalRecode = dao.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecode);
		log.info(pagingVO+"값이넘어가는지????");

		return  dao.selectAllmember(pagingVO);
	}

}
