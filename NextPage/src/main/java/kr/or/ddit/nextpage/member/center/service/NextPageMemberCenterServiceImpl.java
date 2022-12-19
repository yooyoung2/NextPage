package kr.or.ddit.nextpage.member.center.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.nextpage.member.center.dao.NextPageMemberCenterDAO;
import kr.or.ddit.school.manager.board.manage.dao.BoardManageDAO;
import kr.or.ddit.vo.FTP_Module;
import kr.or.ddit.vo.NoticeBoardVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchMemberFileVO;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class NextPageMemberCenterServiceImpl implements NextPageMemberCenterService {

	@Inject
	private NextPageMemberCenterDAO dao;

	@Override
	public List<NoticeBoardVO> selectNotiBoardList(PagingVO<NoticeBoardVO> pagingVO) {
		int totalRecode = dao.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecode);

		return dao.selectNotiBoardList(pagingVO);
	}

//	@Override
//	public int retrieveGenBoardCount(PagingVO pagingVO) {
//		return noticeBoardDAO.selectTotalRecord(pagingVO);
//	}

	@Override
	public ServiceResult insertNotiBoard(NoticeBoardVO notiBoard) {
		int rowcnt = dao.insertNotiBoard(notiBoard);
		
		
		List<NoticeBoardVO> attatchList = notiBoard.getAttatchList();
		if(attatchList!=null && !attatchList.isEmpty()) {
			System.out.println("파일에 뭔가 들어옴"+notiBoard);
//			if(1==1) throw new RuntimeException("트랜잭션 관리 여부 확인용 강제 예외 발생");
			// 메타데이터 저장
			int rowcnt2 = dao.insertNotiBoardFile(notiBoard);
			// 2진 데이터 저장
			for(NoticeBoardVO attatch : attatchList) {
				FTP_Module ftp=new FTP_Module();
				ftp.FileUpload(attatch.getFileName(), attatch.getSaveName(), attatch.getSavePath(), attatch.getAdaptee());
			}
		}
		else {
			System.out.println("파일에 어떤것도 들어오지 않음"+notiBoard);
		}
		
		
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public NoticeBoardVO retrieveNotiboard(Integer notisNum) {
		NoticeBoardVO noti = dao.selectNotiBoard(notisNum);
		
		return noti;
	}

	@Override
	public ServiceResult modifyNotiBoard(NoticeBoardVO noti) {
		
		NoticeBoardVO notice=retrieveNotiboard(noti.getNotisNum());
		FTP_Module ftp=new FTP_Module();
		ftp.ftpFileDelete(notice.getFileName(), notice.getSaveName(), notice.getSavePath());
		
		
		
		List<NoticeBoardVO> attatchList = noti.getAttatchList();
		if(attatchList!=null && !attatchList.isEmpty()) {
			System.out.println("파일에 뭔가 들어옴"+noti);
//			if(1==1) throw new RuntimeException("트랜잭션 관리 여부 확인용 강제 예외 발생");
			// 메타데이터 저장
			int rowcnt2 = dao.insertNotiBoardFile(noti);
			// 2진 데이터 저장
			for(NoticeBoardVO attatch : attatchList) {
				
				
				ftp.FileUpload(attatch.getFileName(), attatch.getSaveName(), attatch.getSavePath(), attatch.getAdaptee());
			}
		}
		else {
			System.out.println("파일에 어떤것도 들어오지 않음"+noti);
		}
		
		
		
		retrieveNotiboard(noti.getNotisNum());
		int rowcnt = dao.updateNotiBoard(noti);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult removeNotiBoard(Integer noti) {
		NoticeBoardVO notice=retrieveNotiboard(noti);
		FTP_Module ftp=new FTP_Module();
		ftp.ftpFileDelete(notice.getFileName(), notice.getSaveName(), notice.getSavePath());
		
		int rowcnt = dao.deleteNotiBoard(noti);
		System.out.println(rowcnt);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public Integer insertNotiBoardFile(NoticeBoardVO notiBoard) {
		return 1;
	}

}
