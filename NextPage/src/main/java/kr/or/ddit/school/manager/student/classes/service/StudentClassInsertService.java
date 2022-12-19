package kr.or.ddit.school.manager.student.classes.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.StudentClassesVO;

public interface StudentClassInsertService {
	
	public ServiceResult insertAllMember(List<SchMemberVO> member);
	
	public int setClassesMember(ClassMemVO member);
	
	public ClassMemVO retrieveMember(String memId);
	
	public int retrieveMemberCount(PagingVO pagingVO);
	
	public List<ClassMemVO> retrieveMemberList(PagingVO pagingVO);
	
	public ServiceResult modifyMember(ClassMemVO member);
	
	public ClassMemVO selectClasses(String classes);
	
	public int setClasses(ClassMemVO vo);
	
	public List<StudentClassesVO> getClassesList(String id);
	
	//public ServiceResult removeMember(SchMemberVO member);
	
}
