package kr.or.ddit.school.manager.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.ProdItemsVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolVO;

@Mapper
public interface SchoolDAO {

	public int insertSchool( SchoolVO school );
	
	// 11.07 KEB
	public SchoolVO selectSchool(String id);
	
	// 11.10 KEB
	public int updateSchool(SchoolVO vo);
	public int updatePass(NpMemberVO vo);
	
	// 11.11 KEB
	public int deleteSchool(SchoolVO vo);
	
	// 11.12 KEB
	public List<PayVO> selectPayList(PagingVO<PayVO> pagingvo);
	public int selectTotalRecord(PagingVO<PayVO> pagingVO);
	
	public NpMemberVO selectNPMember(String id);
	
	// 11.15
	public List<CartVO> selectCartList (String id);
	public int cartDelete(CartVO vo);
	
	// 11.16
	public int insertNPMember(NpMemberVO memvo);
	public List<MyQuestionVO> selectOTOList (PagingVO<MyQuestionVO> pagingvo);
	public int selectTotalOTO(PagingVO<MyQuestionVO> pagingvo);
	public MyQuestionVO selectOTODetail(int otonum);
	
	// 아이디 중복체크
	public int checkSchId(String id);
	
	// 학교 중복체크
	public int checkSch(SchoolVO vo);
	
	public int payListInsert(PayVO vo);
	public int cartUpdate(PayVO vo);
	
	public int saleDateUpdate(String schId);
	public int saleStatUpdate(String schId);
	
	public int beforeSaleDate();
	public int afterSaleDate();
	
	public int insertFPROD(String schId);
	public int insertDPROD(String schId);
	
	public int cancelPay(String schId);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 * 회원가입이후 sch_member 테이블에 학교관리자 계정정보 입력
	 * 
	 * 
	 * @param schmember
	 * @return
	 */
	public int insertSchManager(SchMemberVO schMember);
	
	/** 작성자 : 방형준(22.12.07)
	 * 
	 * 	NP 페이지에서 비밀번호 변경시, 제너레이팅 페이지의 비밀번호도 적용 
	 * 
	 * @param schMember
	 * @return
	 */
	public int updateSchManager(SchMemberVO schMember);
	
}
