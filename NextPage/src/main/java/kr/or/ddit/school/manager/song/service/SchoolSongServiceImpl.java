package kr.or.ddit.school.manager.song.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.song.dao.SchoolSongDAO;
import kr.or.ddit.vo.SchoolSongVO;

@Service
public class SchoolSongServiceImpl implements SchoolSongService {

	@Inject
	private SchoolSongDAO dao;

	@Override
	public ServiceResult createSong(SchoolSongVO song) {
		ServiceResult result = null;
		int rowcnt = dao.insertSong(song);

		result = rowcnt >0? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public SchoolSongVO retrieveSong(String schId) {
		return dao.selectSong(schId);
	}

	@Override
	public ServiceResult modifySong(SchoolSongVO song) {
		retrieveSong(song.getSchId());
		int rowcnt = dao.updateSong(song);
		return  rowcnt >0? ServiceResult.OK : ServiceResult.FAIL;
	}

}
