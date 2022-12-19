package kr.or.ddit.school.manager.teacher.classes.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;

public interface TeacherClassInsertService {
	
	public ServiceResult insertAllMember(List<SchMemberVO> member);
	
	public int setClassesMember(Join_Year_SCH_VO member);
	
	public Join_Year_SCH_VO retrieveMember(String memId);
	
	public int retrieveMemberCount(PagingVO pagingVO);
	
	public List<Join_Year_SCH_VO> retrieveMemberList(PagingVO pagingVO);
	
	public ServiceResult modifyMember(Join_Year_SCH_VO member);
	
	public Join_Year_SCH_VO selectClasses(Join_Year_SCH_VO classes);
	
	public int setClasses(Join_Year_SCH_VO vo);
	
	public List<String> getClassesList(String id);
	
	//public ServiceResult removeMember(SchMemberVO member);
	
}
