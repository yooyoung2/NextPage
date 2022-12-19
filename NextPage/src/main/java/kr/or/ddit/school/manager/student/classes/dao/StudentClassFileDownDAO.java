package kr.or.ddit.school.manager.student.classes.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.SchMemberFileVO;

// CRUD
@Mapper
public interface StudentClassFileDownDAO {
	public SchMemberFileVO selectAttatch(int attNo);
	public SchMemberFileVO selectBoard(@Param("boNo") int boNo);
}


