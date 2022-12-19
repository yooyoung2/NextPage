package kr.or.ddit.school.manager.teacher.classes.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.common.exception.UserNotFoundException;
import kr.or.ddit.operator.systemAlert_02.controller.copy.systemAlertController;
import kr.or.ddit.school.manager.teacher.classes.dao.TeacherClassInsertDAO;
import kr.or.ddit.vo.Join_Year_SCH_VO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherClassInsertServiceImpl implements TeacherClassInsertService {
	@Inject
	private TeacherClassInsertDAO dao;
	
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
	public Join_Year_SCH_VO retrieveMember(String memId) {
		Join_Year_SCH_VO member = dao.selectMember(memId);
		return member;
	}
	
	@Override
	public int retrieveMemberCount(PagingVO pagingVO) {
		return dao.selectTotalRecord(pagingVO);
	}
	
	@Override
	public List<Join_Year_SCH_VO> retrieveMemberList(PagingVO pagingVO) {
		return dao.selectMemberList(pagingVO);
	}

	/*
	 * 받아온 멤버객체를 매개변수로 업데이트를 실행한다.
	 */
	
	@Override
	public Join_Year_SCH_VO selectClasses(Join_Year_SCH_VO classes) {
		return dao.selectClasses(classes);
	}
	
	
	@Override
	public int setClassesMember(Join_Year_SCH_VO member) {
			
			
			
			
			int rowcnt=0;
			Join_Year_SCH_VO check=selectClasses(member);
			
			if(check==null)
			{
				System.out.println("ok임다");
				rowcnt = dao.setClassesMember(member);
				return 1;
			}
			else
			{
				System.out.println("dup임다");
				rowcnt=0;
				return 0;
			}
			
			
			
			
		//return rowcnt;
	}
	
	
	@Override
	public ServiceResult modifyMember(Join_Year_SCH_VO member) {
		Join_Year_SCH_VO check=selectClasses(member);
		int rowcnt=-1;
		System.out.println(check+"임다123");
		if(check==null)
		{
			System.out.println("ok임다123");
			rowcnt = dao.updateMember(member);
			return ServiceResult.OK;
		}
		else
		{
			System.out.println("dup임다");
			rowcnt=0;
			return ServiceResult.PKDUPLICATED;
		}
		
	}

	@Override
	public int setClasses(Join_Year_SCH_VO vo) {
		return dao.setClasses(vo);
	}

	@Override
	public List<String> getClassesList(String id) {
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
