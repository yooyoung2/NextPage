	package kr.or.ddit.school.manager.teacher.Insert.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import kr.or.ddit.school.manager.teacher.Insert.dao.TeacherFileDownDAO;
import kr.or.ddit.vo.SchMemberFileVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeacherFileDownServiceImpl implements TeacherFileDownService {
	private final TeacherFileDownDAO teacherFileDownDAO;
	
	@Value("#{appInfo.attatchFolder}")
	private Resource attatchFolder;
	
	private File saveFolder;
	
	@PostConstruct
	public void init() throws IOException {
		saveFolder = attatchFolder.getFile();
	}
	

	@Override
	public SchMemberFileVO retrieveBoard(int boNo) {
		SchMemberFileVO board = teacherFileDownDAO.selectBoard(boNo);
		if(board==null)
			throw new RuntimeException(String.format("%d 글번호의 글이 없음.", boNo));
		return board;
	}


	
	
	

	@Override
	public SchMemberFileVO retrieveAttatch(int attNo) {
		SchMemberFileVO attatch = teacherFileDownDAO.selectAttatch(attNo);
		if(attatch == null)
			throw new RuntimeException("해당 파일 없음.");
		return attatch;
	}
	
	
	@Override
	public SchMemberFileVO ftpdown(int attNo) {
		SchMemberFileVO attatch = teacherFileDownDAO.ftpdown(attNo);
		if(attatch == null)
			throw new RuntimeException("해당 파일 없음.");
		return attatch;
	}

	
	

}
