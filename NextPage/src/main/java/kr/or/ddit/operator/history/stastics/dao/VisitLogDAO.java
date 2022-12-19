package kr.or.ddit.operator.history.stastics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.VisitCountVO;
import kr.or.ddit.vo.VisitLogVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/통계분석 
 * @author PC-04
 *
 */

@Mapper
public interface VisitLogDAO {
	
	//ServiceResult
	
	public int insertVisitor( VisitLogVO vo );

	
	
	
	
}
