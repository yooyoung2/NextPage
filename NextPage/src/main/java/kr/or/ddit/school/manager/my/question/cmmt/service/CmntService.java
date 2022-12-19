package kr.or.ddit.school.manager.my.question.cmmt.service;

import java.util.List;


import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.OtoCmntVO;

/**
 * 넥스트 페이지 답변
 * @author PC-06
 *
 */

public interface CmntService {


	/** 답변 등록
	 * @param OtoCmntVO
	 * @return
	 */
	public ServiceResult createCmnt(OtoCmntVO cmnt);

	/**
	 * 답변 조회
	 * @param otoBrdNum
	 * @return 존재하지 않는다면, null 반환
	 */
	public List<OtoCmntVO> retrieveCmntList(Integer otoBrdNum);

	/**
	 * 답변상세 조회
	 * @param cmmntId
	 * @return 존재하지 않는다면, null 반환
	 */

	public OtoCmntVO retrieveCmnt(Integer cmmntId);


	/**
	 * 답변 수정
	 * @param OtoCmntVO
	 * @return
	 */
	public ServiceResult modifyCmnt(OtoCmntVO cmnt);

	/**
	 * 답변 삭제
	 * @param cmmntId
	 * @return
	 */
	public ServiceResult  deleteCmnt(OtoCmntVO cmnt);



}
