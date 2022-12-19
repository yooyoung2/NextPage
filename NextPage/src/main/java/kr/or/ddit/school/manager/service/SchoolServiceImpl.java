package kr.or.ddit.school.manager.service;


import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.dao.SchoolDAO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;



@Slf4j
//@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService {

	@Inject
	SchoolDAO dao;
	
	@Resource(name="passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	// ----------------------------------------------
	//						KEB
	// ----------------------------------------------

	private void encryptMember(SchoolVO memvo) {	//schoolvo가 파라미터일때 암호화
		String plain = memvo.getSchPw();
		String encoded = passwordEncoder.encode(plain);
		memvo.setSchPw(encoded);
	}
	
	private void encryptMember(NpMemberVO memvo) {	//npmember가 파라미터일때 암호화
		String plain = memvo.getMemPw();
		String encoded = passwordEncoder.encode(plain);
		memvo.setMemPw(encoded);
	}
	
	//회원가입
	@Transactional
	@Override
	public ServiceResult createMember(SchoolVO memvo) {
		ServiceResult result = null;
		try {
			retrieveSchoolInfo(memvo.getSchId());
			result = ServiceResult.PKDUPLICATED;
			
		} catch (UsernameNotFoundException e) {
			encryptMember(memvo);
			
			NpMemberVO npvo = new NpMemberVO();
			npvo.setNpMemId(memvo.getSchId());
			npvo.setMemPw(memvo.getSchPw());
			
			//방형준 (관리자 schMember테이블 데이터insert) 제너레이팅 홈페이지 로그인시 관리자 권한 얻기위함.
			SchMemberVO schMember = new SchMemberVO();
			schMember.setSchId(memvo.getSchId());
			schMember.setMemId(memvo.getSchId());
			schMember.setMemPw(memvo.getSchPw());
			schMember.setMemNm("학교관리자");
			//방형준끝
			
			int rowcnt = dao.insertNPMember(npvo);
			
			if(rowcnt > 0 ) {
				int cnt = dao.insertSchool(memvo);
				
				//방형준 관리자아이디 schmember 테이블에 insert
				dao.insertSchManager(schMember);
				//
				return cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
			}else {
				return ServiceResult.FAIL;
			}
		}
		return result;
	}


	// 로그인 인증
	@Override
	public NpMemberVO authenticate(NpMemberVO inputData) {
		NpMemberVO saved = dao.selectNPMember(inputData.getNpMemId());
		SchoolVO schvo = new SchoolVO();
		
		if(saved==null) {
			throw new UsernameNotFoundException(inputData.getNpMemId());
		}

		String inputPass = inputData.getMemPw();	// 내가 입력한 비밀번호
		String savePass = saved.getMemPw();	// db에 저장된 암호화된 비밀번호
		
		log.info("inputPass : {}", inputPass);
		log.info("savePass : {}", savePass);
		
		boolean ok = passwordEncoder.matches(inputPass, savePass);
		log.info("ok : {}", ok);
		
		if(passwordEncoder.matches(inputPass, savePass)) {
			return saved;
		}else {
			throw new BadCredentialsException("비밀번호가 틀렸습니다.");
		}
	}

	
	@Override
	public String authPassword(NpMemberVO inputData) {
		NpMemberVO saved = dao.selectNPMember(inputData.getNpMemId());
		
		if(saved==null) {
			throw new UsernameNotFoundException(inputData.getNpMemId());
		}

		String inputPass = inputData.getMemPw();	// 내가 입력한 비밀번호
		String savePass = saved.getMemPw();	// db에 저장된 암호화된 비밀번호
		
		log.info("inputPass : {}", inputPass);
		log.info("savePass : {}", savePass);
		
		
		if(passwordEncoder.matches(inputPass, savePass)) {
			return "true";
		}else {
			throw new BadCredentialsException("비밀번호가 틀렸습니다.");
		}
	}
	
	// 내 정보 조회(특정회원 조회)
	@Override
	public SchoolVO retrieveSchoolInfo(String schId) {
		SchoolVO schoolvo = dao.selectSchool(schId);
		if(schoolvo==null)
			throw new UsernameNotFoundException(schId);
		return schoolvo;
	}

	
	// 내 정보 수정
	@Override
	public ServiceResult modifySchool(SchoolVO vo) {
		int rowcnt = dao.updateSchool(vo);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	// 비밀번호 수정
	@Override
	public ServiceResult modifyPass(NpMemberVO vo) {
		encryptMember(vo);
		int rowcnt = dao.updatePass(vo);
		
		SchMemberVO schMember = new SchMemberVO();
		schMember.setMemId(vo.getNpMemId());
		schMember.setMemPw(vo.getMemPw());
		
		dao.updateSchManager(schMember);
		
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}


	// 탈퇴
	@Override
	public ServiceResult removeSchool(SchoolVO vo) {
		int rowcnt = dao.deleteSchool(vo);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	// 특정 회원 결제 내역 리스트 출력
	@Override
	public void retrievePayList(PagingVO<PayVO> pagingvo) {
		int totalRecord = dao.selectTotalRecord(pagingvo);
		pagingvo.setTotalRecord(totalRecord);
		List<PayVO> payList = dao.selectPayList(pagingvo);
		pagingvo.setDataList(payList);
	}


	// 비밀번호 인증용
	@Override
	public NpMemberVO retrieveMember(String schId) {
		return dao.selectNPMember(schId);
	}


	@Override
	public List<CartVO> retrueveCartList(String schId) {
		return dao.selectCartList(schId);
	}


	@Override
	public void retrieveOTOList(PagingVO<MyQuestionVO> pagingvo) {
		int totalRecord = dao.selectTotalOTO(pagingvo);
		pagingvo.setTotalRecord(totalRecord);
		List<MyQuestionVO> otoList = dao.selectOTOList(pagingvo);
		pagingvo.setDataList(otoList);
	}


	@Override
	public MyQuestionVO retrieveOTOdetail(int otoNum) {
		return dao.selectOTODetail(otoNum);
	}

	@Override
	public int checkSchId(String id) {
		return dao.checkSchId(id);
	}


	@Override
	public int checkSch(SchoolVO vo) {
		return dao.checkSch(vo);
	}

	
	// 템플릿 구매할때
	@Transactional
	@Override
	public ServiceResult pay(PayVO vo) {
		ServiceResult result = null;
		int cnt =0;
		log.info("서비스 들어옴");
		
		// 업데이트
			int rowcnt = dao.cartUpdate(vo);
			if(rowcnt > 0) {
				// 인서트
				cnt = dao.payListInsert(vo);
			}
			return cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	
	// 첫 구매시 school테이블에서 최초 구매 상태, 날짜 업뎃
	@Transactional
	@Override
	public ServiceResult saleFirstUpdate(String schId) {
		ServiceResult result = null;
		int cnt = 0;
		int rowcnt = dao.saleDateUpdate(schId);
		
		if(rowcnt>0) {
			cnt = dao.saleStatUpdate(schId);
		}
		return cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
	
	
	// 결제일자가10일 이전일때 금액 계산
	@Override
	public int beforeSaleDate() {
		return dao.beforeSaleDate();
	}

	// 결제일자가11일 이후일때 금액 계산
	@Override
	public int afterSaleDate() {
		return dao.afterSaleDate();
	}

	// 첫 구매시에 장바구니 담그기
	@Transactional
	@Override
	public ServiceResult insertFPROD(String schId) {
		ServiceResult result = null;
		int cnt = 0;
		int rowcnt = dao.insertFPROD(schId);
		if(rowcnt > 0) {
			cnt = dao.insertDPROD(schId);
		}
		return cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Transactional
	@Override
	public String firstSale(PayVO payvo) {
		ServiceResult cartInsertResult = null;	// 카트에 담길때
		ServiceResult cartUpdatetResult = null; //카트에 담긴게 샀다고 업데이트 됐는지
		ServiceResult paystatUpdatetResult = null;	// 첫 구매 상태 업데이트
		
		String message = null;
		String schId = payvo.getSchId();
		String payId = payvo.getPayId();
		
		// 카트에 먼저 담기
		cartInsertResult = insertFPROD(schId);
		
		switch (cartInsertResult) {
		case OK:
			List<CartVO> cartvo = retrueveCartList(schId);
			// 카트 buy_ok가 ok로 업데이트 pay(payvo)
			for(int i=0; i<cartvo.size(); i++) {
				payvo.setCartId(cartvo.get(i).getCartId());
				payvo.setProdId(cartvo.get(i).getProdId());
				payvo.setPayId(payId);

				cartUpdatetResult = pay(payvo);
					switch (cartUpdatetResult) {
					case OK:
						// schoolvo에 첫 날짜update
						// schoolvo에 첫 구매 상태 YES로 update
						// saleFirstUpdate(schId)
						paystatUpdatetResult = saleFirstUpdate(schId);
							if (paystatUpdatetResult == ServiceResult.OK) {
								message = "결제 성공하였습니다. 지금부터 이용 가능합니다.";
							}else {
								message = "결제상태 업데이트 실패";
							}
						break;
					default:
						message = "장바구니 상태 업데이트 실패";
						break;
					}	// 카트 업데이트 끝
			}// for문 끝
			break;

		default:	// 카트담기 실패했을때
			message = "장바구니 등록 실패";
			break;
		}
		
		return message;
	}


	@Override
	public ServiceResult cancelPay(String schId) {
		log.info("설뷔스");
		int rowcnt = dao.cancelPay(schId);
		log.info("rowcnt : {}", rowcnt);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL; 
	}

	@Override
	public ServiceResult cartDelete(CartVO vo) {
		int rowcnt = dao.cartDelete(vo);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL; 
	}
	
}
