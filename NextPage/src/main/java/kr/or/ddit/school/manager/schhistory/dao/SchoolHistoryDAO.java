package kr.or.ddit.school.manager.schhistory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.SchMemberFileListVO;
import kr.or.ddit.vo.SchMemberFileVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolHistoryVO;

@Mapper
public interface SchoolHistoryDAO {

	public List<SchoolHistoryVO> selectHistList(String schId);
	
	public int insertHist(SchoolHistoryVO member);
	
	public int deleteHist(String schId);
	
	/** 작성자 : 방형준(22.12.13)
	 * 
	 * 	학교아이디를 입력받아 연혁정보를 가져옴
	 * 
	 * @param schId
	 * @return
	 */
	public List<SchoolHistoryVO> selectSchHistoryList(String schId);
	
}
