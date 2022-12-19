package kr.or.ddit.school.manager.song.service;
/**
 * 학교관리자 교가
 * @author PC-06
 *
 */

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.SchoolSongVO;

public interface SchoolSongService {


	/**
	 * 교가등록
	 * @param SchoolSongVO
	 * @return
	 */
	ServiceResult createSong(SchoolSongVO song);

	/**
	 * 교가 조회
	 * @param schId
	 * @return
	 */
	SchoolSongVO retrieveSong(String schId);


	/**
	 * 교가수정
	 * @param song
	 * @return
	 */
	ServiceResult modifySong(SchoolSongVO song);

}
