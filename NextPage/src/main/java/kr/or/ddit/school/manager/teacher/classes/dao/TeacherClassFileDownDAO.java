package kr.or.ddit.school.manager.teacher.classes.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.SchMemberFileVO;

// CRUD
@Mapper
public interface TeacherClassFileDownDAO {
	public SchMemberFileVO selectAttatch(int attNo);
	public SchMemberFileVO selectBoard(@Param("boNo") int boNo);
}


