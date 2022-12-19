package kr.or.ddit.generation.website.find.Id.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolVO;

@Mapper
public interface GeneratingFindIdDAO {

	public SchMemberVO getSchInfo(SchMemberVO sch);
	public SchMemberVO getSchInfoPw(SchMemberVO sch);
	public int schPwUpdate(SchMemberVO Pw);
	
}
