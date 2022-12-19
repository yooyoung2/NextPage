package kr.or.ddit.operator.Index.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.Index.dao.MemberAmountDAO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/INDEX/회원 수
 * @author PC-04
 *
 */

@Slf4j
@Service
public class MemberAmountServiceImpl implements MemberAmountService {

	@Inject
	MemberAmountDAO dao;
	
	// 전체 회원 수 조회
	public int selectMemberAll() {
		// TODO Auto-generated method stub
		return dao.selectMemberAll();
	}

}
