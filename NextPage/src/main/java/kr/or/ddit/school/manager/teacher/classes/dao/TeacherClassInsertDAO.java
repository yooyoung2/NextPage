package kr.or.ddit.school.manager.teacher.classes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;

@Mapper
public interface TeacherClassInsertDAO {
	
	public int insertAllMember(List<SchMemberVO> member);
	
	public int setClassesMember(Join_Year_SCH_VO member);
	
	public Join_Year_SCH_VO selectMember(String memId);
	
	public int selectTotalRecord(PagingVO pagingVO);
	
	public List<Join_Year_SCH_VO> selectMemberList(PagingVO pagingVO);
	
	public int updateMember(Join_Year_SCH_VO member);
	
	public Join_Year_SCH_VO selectClasses(Join_Year_SCH_VO classes);
	
	public int setClasses(Join_Year_SCH_VO vo);
	
	public List<String> getClassesList(String id);
	
	//public int deleteMember(@Param("memNm") String memNm);
	
}