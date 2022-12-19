package kr.or.ddit.school.manager.content.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.ContentVO;
import kr.or.ddit.vo.Criteria;
import kr.or.ddit.vo.GenCntntVO;
import kr.or.ddit.vo.GeneratingMainVO;

@Mapper
public interface ContentManageDAO {
	/** 작성자 : 방형준(22.11.14)
	 * 
	 * 메뉴관리(셀렉터 - 옵션)에서 사용할  데이터 출력
	 * 
	 * @param SchId
	 * @return
	 */
	public List<GenCntntVO> selectGenCntntOptionList(String schId);
	
	/**
	 * 작성자 : 최현우
	 * 
	 * 컨텐츠 DB에 저장
	 * 
	 * @param content
	 * @return
	 */
	public Integer insertContent( ContentVO content );
	
	public List<ContentVO> getList( Criteria cri );
	public int getTotal( String schId ); // 총 게시글 수 구하기
	
	/**
	 * 작성자 : 최현우
	 * 메뉴정보 가져옴
	 * @return
	 */
	public List<GeneratingMainVO> getMenuList( String schId );
	
	/**
	 * 작성자 : 최현우
	 * 컨텐츠 하나 가져옴
	 * @param cntntId
	 * @return
	 */
	public ContentVO getContent( String cntntId );
	
	
	public int updateContent( ContentVO content );
	
	/**
	 * 컨텐츠 삭제
	 * @param cntntId
	 * @return
	 */
	public int delContent( String cntntId );
	

	
}
