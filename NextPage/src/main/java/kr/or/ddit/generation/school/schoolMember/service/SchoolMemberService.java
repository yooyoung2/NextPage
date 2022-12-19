package kr.or.ddit.generation.school.schoolMember.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.StudAndPrntVO;

/**
 * 11.17 강은비 
 * 
 * 제너레이팅 홈페이지 유저 CRUD
 *
 */
public interface SchoolMemberService {
	
	// ----------------------------------------------
	//						KEB
	// ----------------------------------------------
	public SchMemberVO authenticate(SchMemberVO inputData);
	public String authPass(SchMemberVO inputData);
	
	public void checkAuth(SchMemberVO vo);
	
	public ServiceResult createMember(SchMemberVO inputData);
	public ServiceResult enrollParents(SchMemberVO inputData);
	
	public int checkMem (SchMemberVO inputData);
	public ServiceResult modifyGenMemInfo (SchMemberVO vo);
	public ServiceResult modifyGenMemPassword (SchMemberVO vo);
	
	public SchMemberVO detailMember(SchMemberVO inputdata);
	public int checkStudent(SchMemberVO inputdata); 
	
	public StudAndPrntVO checkEnrollAuth(SchMemberVO vo);
	
	
	public List<SchMemberVO> selectMychildList(SchMemberVO vo);	//부모 ) 부모 슬하 학생 목록
	public List<SchMemberVO> selectMyPrnt(SchMemberVO vo);		// 학생 ) 학생 마이페이지에서 등록된 부모님 아이디 확인
	public List<SchMemberVO> selectAuthApproval(SchMemberVO vo);	// 교직원 ) 학부모 신청 들어온 목록 확인
	
	public ServiceResult approvalAuth(StudAndPrntVO vo);	// 학부모 신청 승인
	public ServiceResult returnEnroll(StudAndPrntVO vo);	// 학부모 신청 반려
	
	// ----------------------------------------------
	//						KEB.END
	// ----------------------------------------------
}
