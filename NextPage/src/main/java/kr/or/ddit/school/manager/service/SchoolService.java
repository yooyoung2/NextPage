package kr.or.ddit.school.manager.service;

import java.util.List;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.ProdItemsVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolVO;

public interface SchoolService {

	//public int insertSchool( SchoolVO school );
	//public ServiceResult createSchool( SchoolVO school );
	
	//11.07 KEB
	public NpMemberVO authenticate(NpMemberVO inputData);
	
	// 11.08 KEB
	public SchoolVO retrieveSchoolInfo( String schId);
	
	// 11.10 KEB
	public ServiceResult modifySchool(SchoolVO vo);
	public ServiceResult modifyPass(NpMemberVO vo);
	
	// 11.11 KEB
	public ServiceResult removeSchool(SchoolVO vo);
	
	// 11.12 KEB
	public void retrievePayList (PagingVO<PayVO> pagingvo);
	
	// 11.14 KEB
	public NpMemberVO retrieveMember(String schId);
	
	// 11.15
	public List<CartVO> retrueveCartList(String schId); 
	
	// 11.16
	public ServiceResult createMember( SchoolVO memvo );
	public void retrieveOTOList( PagingVO<MyQuestionVO> pagingvo );
	public MyQuestionVO retrieveOTOdetail( int otoNum );
	
	public int checkSchId(String id);
	
	// 학교 중복체크
	public int checkSch(SchoolVO vo);
	
	public ServiceResult cartDelete(CartVO vo);
	public ServiceResult pay(PayVO vo);
	
	public ServiceResult saleFirstUpdate(String schId);
	
	public int beforeSaleDate();
	public int afterSaleDate();
	
	public ServiceResult insertFPROD(String schId);
	
	public String firstSale(PayVO payvo);
	
	public ServiceResult cancelPay(String schId);

	public String authPassword(NpMemberVO inputData);
	

}
