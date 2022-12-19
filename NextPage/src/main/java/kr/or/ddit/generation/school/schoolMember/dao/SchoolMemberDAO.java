package kr.or.ddit.generation.school.schoolMember.dao;
/**
 * 11.17 강은비 
 * 
 * 제너레이팅 홈페이지 로그인, 로그아웃, 학부모 회원가입 진행
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.StudAndPrntVO;

/**
 * generating 홈페이지내 회원 crud
 *
 */
@Mapper
public interface SchoolMemberDAO {
	
	// ----------------------------------------------
	//						KEB
	// ----------------------------------------------
	public SchMemberVO selectSchMember(SchMemberVO vo);	// 교내 유저 정보 불러오기
	
	public int checkStudent(SchMemberVO vo);	// 학생인지
	public int checkTeacher(SchMemberVO vo);	// 교직원인지
	public int checkParents(SchMemberVO vo);	// 학부모인지
	
	public int insertMember(SchMemberVO vo);	// 일반 회원가입
	
	public int insertParents(SchMemberVO vo);	// 학부모 신청 등록
	public int insertParentsAndStudent(SchMemberVO vo);
	
	public int checkMem(SchMemberVO vo);		// 회원가입시 중복검사
	
	public int updateGenMemPassword(SchMemberVO vo); //비번수정
	public int updateGenMemInfo(SchMemberVO vo); //정보수정
	public int isThereMychild(SchMemberVO vo);
	
	public StudAndPrntVO checkPrntAuth(SchMemberVO vo);	// 이미 신청했는지 체크
	
	public List<SchMemberVO> selectMychildList(SchMemberVO vo);	//부모 ) 부모 슬하 학생 목록
	public List<SchMemberVO> selectMyPrnt(SchMemberVO vo);		// 학생 ) 학생 마이페이지에서 등록된 부모님 아이디 확인
	public List<SchMemberVO> selectAuthApproval(SchMemberVO vo);	// 교직원 ) 학부모 신청 들어온 목록 확인
	
	public int approvalAuth(StudAndPrntVO vo);	// 학부모 신청 승인
	public int returnEnroll(StudAndPrntVO vo);	// 학부모 신청 반려
	// ----------------------------------------------
	//						KEB.END
	// ----------------------------------------------
	
}
