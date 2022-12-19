package kr.or.ddit.operator.member.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.operator.member.service.SelectAllMemberService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchoolVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SelectAllMemberController {

	@Inject
	SelectAllMemberService service;

	/**
	 * 회원목록 조회
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "operator/school/list", method = RequestMethod.GET )
	public String selectAllMember(
		@RequestParam(name="page", required=true, defaultValue="1") int currentPage,
		@ModelAttribute("simpleCondition") SearchVO simpleCondition,
		Model model
	) {

		String viewName = null;

		PagingVO<SchoolVO>pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);

		List<SchoolVO> schools = service.selectAllmember(pagingVO);
		pagingVO.setDataList(schools);

		if( schools != null && !schools.isEmpty() ) {
			log.info( "=========Print school List=========" );
			for( SchoolVO school : schools ) {
				log.info( "학교 : " + school.getSchNm() );
				log.info( "최초 구매일 : " + school.getFstPchDate() );
				log.info( "=============================" );
				System.out.println( "여기가 실행되야 되는데 제발..." );
			}
			viewName = "operator/03_selectMember/selectMember";
			model.addAttribute( "pagingVO", pagingVO );
		}else {
			viewName = "500"; // 에러페이지 따로 만들어야됨
		}

		return viewName;

	}

	/**
	 * 회원 수정
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping( value = "operator/select/detail/member", method = RequestMethod.GET )
	public String selectDetailMember( Model model, String id ) {

		String viewName = "operator/04_selectDetailMember/selectDetailMember";

		SchoolVO school = service.selectDetailSchool( id );
		model.addAttribute( "school", school );

		return viewName;

	}

	@RequestMapping( value = "operator/update/detail/member", method = RequestMethod.POST )
	public String updateDetailMember( Model model,

			 	String schoolId,
				String schoolName,
				String schoolAddr1,
				String schoolApntd,
				String templateName,
				String hpLink

			) {

		// 수정 완료 후 목록으로 돌아감.
		String viewName = "redirect:/operator/school/list";

		//SchoolVO school = service.selectDetailSchool( schoolId );
		SchoolVO school = new SchoolVO();

		school.setSchId( schoolId );
		school.setSchNm( schoolName );
		school.setSchAddr1( schoolAddr1 );
		school.setSchApntd( schoolApntd );
		school.setTmpltNm( templateName );
		school.setHpLink( hpLink );

		int result = service.updateDetailSchool( school );
		if( result > 0 ) {
			log.info( "회원 수정 성공" );
		}else {
			log.info( "회원 수정 실패" );
		}

		return viewName;
	}


}
