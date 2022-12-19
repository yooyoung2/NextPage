package kr.or.ddit.nextpage.find.id.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.nextpage.find.id.dao.NextPageFindIdDAO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class NextPageFindIdServiceImpl implements NextPageFindIdService {

	@Inject
	private NextPageFindIdDAO dao;
	@Resource(name="passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	// 비밀번호 암호화 - 은비추가
	private void encryptMember(NpMemberVO memvo) {	//npmember가 파라미터일때 암호화
		System.out.println("encrypt 두둥");
		String plain = memvo.getMemPw();
		String encoded = passwordEncoder.encode(plain);
		System.out.println("encoded : "+ encoded);
		memvo.setMemPw(encoded);
		System.out.println("끝");
	}
	
	
	@Override
	public SchoolVO getSchInfo(SchoolVO sch) {
		return dao.getSchInfo(sch);
	}

	@Override
	public SchoolVO getSchInfoPw(SchoolVO sch) {
		return dao.getSchInfoPw(sch);
	}

	@Override
	public int schPwUpdate(NpMemberVO Pw) {
		System.out.println("업데이트 입성");
		encryptMember(Pw);
		return dao.schPwUpdate(Pw);
	}

}
