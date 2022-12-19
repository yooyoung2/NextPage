package kr.or.ddit.school.manager.student.classes.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.StudentClassesVO;

@Mapper
public interface StudentClassInsertDAO {
	
	public int insertAllMember(List<SchMemberVO> member);
	
	public int setClassesMember(ClassMemVO member);
	
	public ClassMemVO selectMember(String memId);
	
	public int selectTotalRecord(PagingVO pagingVO);
	
	public List<ClassMemVO> selectMemberList(PagingVO pagingVO);
	
	public int updateMember(ClassMemVO member);
	
	public ClassMemVO selectClasses(String classes);
	
	public int setClasses(ClassMemVO vo);
	
	public List<StudentClassesVO> getClassesList(String id);
	
	//public int deleteMember(@Param("memNm") String memNm);
	
}