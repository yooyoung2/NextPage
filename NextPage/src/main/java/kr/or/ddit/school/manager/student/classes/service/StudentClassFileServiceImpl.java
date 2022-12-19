	package kr.or.ddit.school.manager.student.classes.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.student.Insert.dao.StudentFileDAO;
import kr.or.ddit.vo.SchMemberFileListVO;
import kr.or.ddit.vo.SchMemberFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentClassFileServiceImpl implements StudentClassFileService {
	//private final BoardDAO boardDAO;
	private final StudentFileDAO attatchDAO;
	
	@Value("#{appInfo.attatchFolder}")
	private Resource attatchFolder;
		
	private File saveFolder;
	
	@PostConstruct
	public void init() throws IOException {
		saveFolder = attatchFolder.getFile();
	}
	
	private int processAttatchList(SchMemberFileListVO board) {
		int rowcnt = 0;
		List<SchMemberFileVO> attatchList = board.getAttatchList();
		if(attatchList!=null && !attatchList.isEmpty()) {
//			if(1==1) throw new RuntimeException("트랜잭션 관리 여부 확인용 강제 예외 발생");
			// 메타데이터 저장
			rowcnt = attatchDAO.insertAttatches222(board);
			// 2진 데이터 저장
			for(SchMemberFileVO attatch : attatchList) {
				try {
					attatch.saveTo(saveFolder);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return rowcnt;
	}
	
	@Transactional // 선언적 프로그래밍 기법(AOP)
	@Override
	public ServiceResult createBoard222(SchMemberFileListVO board) {
		//int rowcnt = boardDAO.insertBoard222(board);  // 1.
		int rowcnt=0;
		rowcnt += processAttatchList(board);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}


}
