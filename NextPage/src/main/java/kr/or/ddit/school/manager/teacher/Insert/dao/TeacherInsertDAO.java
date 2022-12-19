package kr.or.ddit.school.manager.teacher.Insert.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PoiVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.YearClassVO;

@Mapper
public interface TeacherInsertDAO {
	
	public int insertAllMember(List<SchMemberVO> member);
	
	public int insertMember(SchMemberVO member);
	
	public SchMemberVO selectMember(String memId);
	
	public int selectTotalRecord(PagingVO pagingVO);
	
	public List<SchMemberVO> selectMemberList(PagingVO pagingVO);
	
	public int updateMember(SchMemberVO member);

	public int insertStaff(String member);
	
	public SchMemberVO selectMemId(SchMemberVO member);
	
	public int insertClass(YearClassVO yc);
	
	public String whoClasses(String member);
	
	//public int deleteMember(@Param("memNm") String memNm);
	
}