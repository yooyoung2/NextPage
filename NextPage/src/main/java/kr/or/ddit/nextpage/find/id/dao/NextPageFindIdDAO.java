package kr.or.ddit.nextpage.find.id.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchoolVO;

@Mapper

public interface NextPageFindIdDAO {

	public SchoolVO getSchInfo(SchoolVO sch);
	public SchoolVO getSchInfoPw(SchoolVO sch);
	public int schPwUpdate(NpMemberVO Pw);
}
