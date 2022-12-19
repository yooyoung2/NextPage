package kr.or.ddit.school.manager.student.Insert.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.common.exception.UserNotFoundException;
import kr.or.ddit.school.manager.student.Insert.dao.StudentInsertDAO;
import kr.or.ddit.vo.ClassMemVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.YearClassVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentInsertServiceImpl implements StudentInsertService {
	@Inject
	private StudentInsertDAO dao;
	
	/*
	 * 암호화를 위한 메서드
	 */
	@Resource(name="passwordEncoder")
	private PasswordEncoder passwordEncoder;

	private void encryptMember(SchMemberVO member) {
		String plain = member.getMemPw();
		String encoded = passwordEncoder.encode(plain);
		member.setMemPw(encoded);
		System.out.println("암호화성공"+encoded);
	}
	
	/*
	 * 약간 반대로 하는 느낌인데
	 * 받아온 FORM 정보에 대한 아이디가 중복된다면 "아이디 정보"를 리턴하고
	 * 그게 아니라면 오히려 예외가 발생해서 그 멤버를 인설트한다.
	 */
	@Override
	public ServiceResult createMember(SchMemberVO member) {
		ServiceResult result = null;
		try {
			retrieveMember(member.getMemNm());
			result = ServiceResult.PKDUPLICATED;
		}catch (UserNotFoundException e) {
			//=======암호화===========
			member.setMemPw("1234");
			encryptMember(member);
			//======================
			int rowcnt = dao.insertMember(member);
			
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		return result;
	}
	
	
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
	public SchMemberVO retrieveMember(String memId) {
		SchMemberVO member = dao.selectMember(memId);
		if(member==null)
			throw new UserNotFoundException(memId);
		return member;
	}
	
	@Override
	public int retrieveMemberCount(PagingVO pagingVO) {
		return dao.selectTotalRecord(pagingVO);
	}
	
	@Override
	public List<SchMemberVO> retrieveMemberList(PagingVO pagingVO) {
		return dao.selectMemberList(pagingVO);
	}

	/*
	 * 받아온 멤버객체를 매개변수로 업데이트를 실행한다.
	 */
	@Override
	public ServiceResult modifyMember(SchMemberVO member) {
		int rowcnt = dao.updateMember(member);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public int insertStaff(String member) {
		return dao.insertStaff(member);
	}

	@Override
	public SchMemberVO selectMemId(SchMemberVO member) {
		return dao.selectMemId(member);
	}

	@Override
	public int insertClass(ClassMemVO yc) {
		return dao.insertClass(yc);
	}

	@Override
	public String whoClasses(String member) {
		return dao.whoClasses(member);
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
