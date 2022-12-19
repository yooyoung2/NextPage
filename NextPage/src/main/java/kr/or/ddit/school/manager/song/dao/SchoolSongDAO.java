package kr.or.ddit.school.manager.song.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.SchoolSongVO;


/**
 * 학교 관리자 교가
 * @author PC-06
 *
 */
@Mapper
public interface SchoolSongDAO {
	/**
	 * 교가등록
	 * @param SchoolSongVO
	 * @return
	 */
	public int insertSong(SchoolSongVO song);

	/**
	 * 교가조회
	 * @param schId
	 * @return
	 */
	public SchoolSongVO selectSong(String schId);



	/**
	 * 교가 수정
	 * @param song
	 * @return
	 */
	public int updateSong(SchoolSongVO song);





}
