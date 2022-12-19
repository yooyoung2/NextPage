package kr.or.ddit.generation.website.find.Id.service;

import kr.or.ddit.vo.SchMemberVO;

public interface GeneratingFindIdService {

	public SchMemberVO getSchInfo(SchMemberVO sch);
	public SchMemberVO getSchInfoPw(SchMemberVO sch);
	public int schPwUpdate(SchMemberVO Pw);
}
