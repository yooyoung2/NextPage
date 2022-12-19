package kr.or.ddit.operator.Index.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/INDEX/회원 수
 * @author PC-04
 *
 */
@Mapper
public interface MemberAmountDAO {

	public int selectMemberAll();
	
}
