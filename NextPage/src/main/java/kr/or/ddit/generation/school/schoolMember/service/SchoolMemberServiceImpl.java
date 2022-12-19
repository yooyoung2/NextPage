package kr.or.ddit.generation.school.schoolMember.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.school.schoolMember.dao.SchoolMemberDAO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolVO;
import kr.or.ddit.vo.StudAndPrntVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 11.17 강은비
 * 
 * 제너레이팅 홈페이지 유저 CRUD
 *
 */
@Slf4j
@Service
public class SchoolMemberServiceImpl implements SchoolMemberService {

	@Inject
	private SchoolMemberDAO dao;
	@Resource(name="passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	// ----------------------------------------------
	//						KEB
	// ----------------------------------------------

	private void encryptMember(SchMemberVO vo) {	//schoolvo가 파라미터일때 암호화
		log.info("암호화 들어옴");
		String plain = vo.getMemPw();
		String encoded = passwordEncoder.encode(plain);
		vo.setMemPw(encoded);
		log.info("암호화 완료");
	}
	@Override
	public String authPass(SchMemberVO inputData) {
		SchMemberVO vo = dao.selectSchMember(inputData);
		
		if(vo == null)
			throw new UsernameNotFoundException(inputData.getMemId());
		
		String inputPass = inputData.getMemPw();	// 내가 입력한 비밀번호
		String savePass = vo.getMemPw();	// db에 저장된 암호화된 비밀번호
		log.info("inputPass : {}", inputPass);
		log.info("savePass : {}", savePass);
		
		if(passwordEncoder.matches(inputPass, savePass)) {
			log.info("매치!");
			return "true";
		}else {
			log.info("땡");
			throw new BadCredentialsException("비밀번호가 틀렸습니다.");
		}
	}
	
	// 인증하기
	@Override
	public SchMemberVO authenticate(SchMemberVO inputData) { // 입력받은 데이터를 매개로 받음

		log.info("authenticate 입성");

		// 입력받은 정보 중, ID를 빼서 해당 맴버가 있다면 정보를 불러옴
		SchMemberVO saved = dao.selectSchMember(inputData);
		log.info("saved ?? : {}", saved);

		if (saved == null) { // 만약 없으면 없는 계정
			log.info("saved가 null");
			throw new UsernameNotFoundException(inputData.getMemId());
		}
		// 입력한 비밀번호
		String inputPass = inputData.getMemPw();

		// 저장되어있는 정보의 비밀번호
		String savedPass = saved.getMemPw();

		// 저장되어있는 비번과 ㅇ비력한 비번이 같으면 위에서 불러온 데이터를 리턴
		if (passwordEncoder.matches(inputPass, savedPass)) {
			return saved;
		} else {
			log.info("비번틀림");
			throw new BadCredentialsException("비밀번호가 틀렸습니다.");

		}
	}

	// 로그인한 유저의 권한 체크 (학생,교직원,학부모)
	@Override
	public void checkAuth(SchMemberVO vo) {
		String auth = null;

		String schId = vo.getSchId();
		String memId = vo.getMemId();
		
		int stud = dao.checkStudent(vo);
		int edu = dao.checkTeacher(vo);
		int parents = dao.checkParents(vo);

		
		if(memId.equals(schId)){
			auth = "SCH";
			vo.setAuthMem(auth);
			return;
		} else if (stud == 1) {
			auth = "STUD";
			vo.setAuthMem(auth);
			return;
		} else if (edu == 1) {
			auth = "EDUPSN";
			vo.setAuthMem(auth);
			return;
		} else if (parents == 1) {
			auth = "PRNT";
			vo.setAuthMem(auth);
			return;
		} else {
			auth = "NORMAL";
			vo.setAuthMem(auth);
			return;
		}

	}

	// 학부모 회원가입
	@Transactional
	@Override
	public ServiceResult createMember(SchMemberVO inputData) {
		ServiceResult result = null;
		int rowcnt = 0;
		try {
			rowcnt = dao.checkMem(inputData);
			if (rowcnt < 1) {
				encryptMember(inputData);
				rowcnt = dao.insertMember(inputData);
				if (rowcnt > 0) {
					rowcnt = dao.insertParents(inputData);
				}
			}else{
				return result.PKDUPLICATED;
			}
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
		}
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	// 학부모 테이블에 넣기
	@Transactional
	@Override
	public ServiceResult enrollParents(SchMemberVO inputData) {
		ServiceResult result = null;
		int rowcnt = 0;
		log.info("enrollParnets 입성");

		StudAndPrntVO sapvo = dao.checkPrntAuth(inputData); // 이미 신청했는지 확인하기
		log.info("이미 신청했는지 확인완료");
		log.info("sapvo : {}", sapvo);
		if (sapvo == null) {
			log.info("신청안함! 진행");
			try {
				rowcnt = dao.insertParentsAndStudent(inputData);
				log.info("신청~!!!");
			} catch (UsernameNotFoundException e) {
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			log.info("이미 신청했다던대?");
			return result.PKDUPLICATED;
		}
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;

	}

	// 중복체크
	@Override
	public int checkMem(SchMemberVO inputData) {
		int rowcnt = dao.checkMem(inputData);
		return rowcnt;
	}

	// 비밀번호수정
	@Override
	public ServiceResult modifyGenMemInfo(SchMemberVO vo) {
		int rowcnt = dao.updateGenMemInfo(vo);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	// 정보 확인
	@Override
	public SchMemberVO detailMember(SchMemberVO inputdata) {
		return dao.selectSchMember(inputdata);
	}

	// 비밀번호 수정
	@Override
	public ServiceResult modifyGenMemPassword(SchMemberVO vo) {
		encryptMember(vo);
		log.info(vo.getMemPw());
		int rowcnt = dao.updateGenMemPassword(vo);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;

	}

	@Override
	public int checkStudent(SchMemberVO inputdata) {
		return dao.isThereMychild(inputdata);
	}

	

	@Override
	public StudAndPrntVO checkEnrollAuth(SchMemberVO vo) {
		return dao.checkPrntAuth(vo);
	}

	
	// 부모가 슬하 학생 확인
	@Override
	public List<SchMemberVO> selectMychildList(SchMemberVO vo) {
		return dao.selectMychildList(vo);
	}

	// 나를 슬하로 등록한 부모 목록 
	@Override
	public List<SchMemberVO> selectMyPrnt(SchMemberVO vo) {
		return dao.selectMyPrnt(vo);
	}

	// 학생 등록 신청을 한 부모 승인 목록
	@Override
	public List<SchMemberVO> selectAuthApproval(SchMemberVO vo) {
		return dao.selectAuthApproval(vo);
	}

	@Override
	public ServiceResult approvalAuth(StudAndPrntVO vo) {
		int rowcnt = dao.approvalAuth(vo);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult returnEnroll(StudAndPrntVO vo) {
		int rowcnt = dao.returnEnroll(vo);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}


	// ----------------------------------------------
	// KEB.END
	// ----------------------------------------------

}
