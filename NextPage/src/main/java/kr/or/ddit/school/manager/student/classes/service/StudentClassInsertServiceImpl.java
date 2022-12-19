package kr.or.ddit.school.manager.student.classes.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.student.classes.dao.StudentClassInsertDAO;
import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.StudentClassesVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentClassInsertServiceImpl implements StudentClassInsertService {
	@Inject
	private StudentClassInsertDAO dao;
	
	/*
	 * 암호화를 위한 메서드
	 */
	@Resource(name="passwordEncoder")
	private PasswordEncoder passwordEncoder;

	private void encryptMember(SchMemberVO member) {
		String plain = member.getMemPw();
		String encoded = passwordEncoder.encode(plain);
		member.setMemPw(encoded);
	}
	
	/*
	 * 약간 반대로 하는 느낌인데
	 * 받아온 FORM 정보에 대한 아이디가 중복된다면 "아이디 정보"를 리턴하고
	 * 그게 아니라면 오히려 예외가 발생해서 그 멤버를 인설트한다.
	 */
	
	
	@Override
	public ServiceResult insertAllMember(List<SchMemberVO> member) {
		ServiceResult result = null;
			int rowcnt = dao.insertAllMember(member);
			
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}
	
	
	/*
	 * 특정 아이디를 가진 회원의 정보를 출력
	 */
	@Override
	public ClassMemVO retrieveMember(String memId) {
		ClassMemVO member = dao.selectMember(memId);
		return member;
	}
	
	@Override
	public int retrieveMemberCount(PagingVO pagingVO) {
		return dao.selectTotalRecord(pagingVO);
	}
	
	@Override
	public List<ClassMemVO> retrieveMemberList(PagingVO pagingVO) {
		return dao.selectMemberList(pagingVO);
	}

	/*
	 * 받아온 멤버객체를 매개변수로 업데이트를 실행한다.
	 */
	
	@Override
	public ClassMemVO selectClasses(String classes) {
		return dao.selectClasses(classes);
	}
	
	
	@Override
	public int setClassesMember(ClassMemVO member) {
			
		System.out.println("ok임다");
		dao.setClassesMember(member);
		return 1;
			
	}
	
	
	@Override
	public ServiceResult modifyMember(ClassMemVO member) {
		System.out.println("ok임다");
		dao.updateMember(member);
		return ServiceResult.OK;
		
	}

	@Override
	public int setClasses(ClassMemVO vo) {
		return dao.setClasses(vo);
	}

	@Override
	public List<StudentClassesVO> getClassesList(String id) {
		return dao.getClassesList(id);
	}

	



	/*
	 * 받아온 멤버객체를 매개변수로 삭제를 실행한다.
	 */
	/*@Override
	public ServiceResult removeMember(SchMemberVO member) {
		retrieveMember(member.getMemId());
		int rowcnt = dao.deleteMember(member.getMemId());
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}*/
	
	
	
	

}
