package kr.or.ddit.school.manager.teacher.Insert.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.SchMemberFileVO;

// CRUD
@Mapper
public interface TeacherFileDownDAO {
	public SchMemberFileVO selectAttatch(int attNo);
	public SchMemberFileVO selectBoard(@Param("boNo") int boNo);
	
	
	public SchMemberFileVO ftpdown(int attNo);
}


	