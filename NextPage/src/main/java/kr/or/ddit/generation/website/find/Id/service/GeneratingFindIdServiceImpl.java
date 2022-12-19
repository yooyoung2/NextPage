package kr.or.ddit.generation.website.find.Id.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.generation.website.find.Id.dao.GeneratingFindIdDAO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchMemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeneratingFindIdServiceImpl implements GeneratingFindIdService {
	
	@Inject
	GeneratingFindIdDAO dao;
	@Resource(name="passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	// 비밀번호 암호화 - 은비추가
	private void encryptMember(SchMemberVO memvo) {	//npmember가 파라미터일때 암호화
		System.out.println("encrypt 두둥");
		String plain = memvo.getMemPw();
		String encoded = passwordEncoder.encode(plain);
		System.out.println("encoded : "+ encoded);
		memvo.setMemPw(encoded);
		System.out.println("끝");
	}
	
	
	@Override
	public SchMemberVO getSchInfo(SchMemberVO sch) {
		return dao.getSchInfo(sch);
	}

	@Override
	public SchMemberVO getSchInfoPw(SchMemberVO sch) {
		return dao.getSchInfoPw(sch);
	}

	@Override
	public int schPwUpdate(SchMemberVO Pw) {
		encryptMember(Pw);
		return dao.schPwUpdate(Pw);
	}

}
