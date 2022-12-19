package kr.or.ddit.school.manager.teacher.Insert.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.SchMemberFileListVO;

// CRUD
@Mapper
public interface TeacherFileDAO {
	// insert all 
	/**
	 * 게시글의 첨부파일의 메타데이터를 한번에 insert.
	 * @param board
	 * @return
	 */
	public int insertAttatches222(SchMemberFileListVO board);
	/**
	 * 다운로드 처리를 위해 메타데이터 한건 조회.
	 * @param attNo
	 * @return
	 */
	
}

