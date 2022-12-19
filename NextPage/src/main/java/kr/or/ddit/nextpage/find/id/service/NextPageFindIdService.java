package kr.or.ddit.nextpage.find.id.service;

import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchoolVO;

public interface NextPageFindIdService {

	public SchoolVO getSchInfo(SchoolVO sch);
	public SchoolVO getSchInfoPw(SchoolVO sch);
	public int schPwUpdate(NpMemberVO Pw);
}
