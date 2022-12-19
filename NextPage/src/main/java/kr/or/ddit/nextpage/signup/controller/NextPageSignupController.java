package kr.or.ddit.nextpage.signup.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.school.manager.menu.manage.service.MenuManageService;
import kr.or.ddit.school.manager.service.SchoolService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.GenAlertBrdVO;
import kr.or.ddit.vo.GenCaldVO;
import kr.or.ddit.vo.GenFooterVO;
import kr.or.ddit.vo.GenMainImgVO;
import kr.or.ddit.vo.GenMenuVO;
import kr.or.ddit.vo.GenSiteVO;
import kr.or.ddit.vo.NpMemberVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.SchLogoVO;
import kr.or.ddit.vo.SchMemberVO;
import kr.or.ddit.vo.SchoolVO;
import lombok.extern.slf4j.Slf4j;

/*
 * NextPage회원가입 페이지
 * 필요 객체 : SchoolVO
 */
@Slf4j
@Controller
@RequestMapping("nextpage/user/signup")
// 11.08 keb 수정시작
public class NextPageSignupController {

	@Inject
	private SchoolService service;
	
	@Inject
	private MenuManageService menuService;
	
	@ModelAttribute("school")
	public SchoolVO school() {
		return new SchoolVO();
	}
	
	
	@GetMapping
	public String doGet() {
		return "nextpage/nomenu/03_nextPageSignup/nextPageSignup";
	}
	
	@PostMapping
	public String nextPageSignup(
			@Validated(InsertGroup.class)@ModelAttribute ("school") SchoolVO schvo
			, Errors errors
			, RedirectAttributes redirectAttributes
			) {
		String logicalViewName = null;
		String message=null;
		
		
		//방형준작성 : 회원가입 성공시 기본정보추가(genMenu, prjct, schLogo, genMainImg, genAlertBrd, genFooter, genCald)
		GenMenuVO genMenu = new GenMenuVO();
		genMenu.setSchId(schvo.getSchId());
		genMenu.setMenuNm("최상위메뉴입니다");
		genMenu.setMenuLink("#");
		genMenu.setMenuId(0);
		genMenu.setMenuUseOk("NO");
		genMenu.setMenuType("noType");
		
		PrjctVO prjct = new PrjctVO();
		prjct.setSchId(schvo.getSchId()); 
		
		SchLogoVO schLogo = new SchLogoVO();
		schLogo.setSchId(schvo.getSchId());
		
		GenMainImgVO genMainImg = new GenMainImgVO();
		genMainImg.setSchId(schvo.getSchId());
		genMainImg.setOrdNum(1);
		
		GenAlertBrdVO genAlertBrd = new GenAlertBrdVO();
		genAlertBrd.setSchId(schvo.getSchId());
		genAlertBrd.setOrdNum(1);
		
		GenFooterVO genFooter = new GenFooterVO();
		genFooter.setSchId(schvo.getSchId());
		
		GenCaldVO genCald = new GenCaldVO();
		genCald.setSchId(schvo.getSchId());
		
		//방형준 작성끝
		
		String schEmailId = schvo.getSchEmailId();
		String schEmailAddr = schvo.getSchEmailAddr();
		String schEmail = schEmailId + "@" + schEmailAddr ;
		
		schvo.setSchEmail(schEmail);
		
		NpMemberVO memvo = new NpMemberVO();
		
		memvo.setNpMemId(schvo.getSchId());
		memvo.setMemPw(schvo.getSchPw());
		
		if(!errors.hasErrors()) {
			ServiceResult result = null;
			
			log.info("mevo : {}", memvo);
			
			result = service.createMember(schvo);
				switch (result) {
				case PKDUPLICATED:
					message = "아이디 중복";
					logicalViewName = "nextpage/nomenu/03_nextPageSignup/nextPageSignup";
					break;
				case OK:
					log.info("OK");
					
					//방형준시작(22.12.07)
					//회원가입이 완료되면 메뉴최상위정보 1개추가.
					menuService.insertMenuSignUp(genMenu);
					//회원가입이 완료되면 프로젝트 3개추가.
					for(int i = 0 ; i < 3 ; i++) {
						menuService.insertPrjctSignUp(prjct);
					}
					List<PrjctVO> prjctList = menuService.retrievePrjctList(schvo.getSchId());
					
					GenSiteVO genSite = new GenSiteVO();
					
					for(int i = 0 ; i < 3; i++) {
						String prjId = prjctList.get(i).getPrjctId();
						genSite.setPrjctId(prjId);
						
						menuService.insertGenSite(genSite);
					}
					
					menuService.insertSchLogo(schLogo);
					menuService.insertGenMainImg(genMainImg);
					menuService.insertGenAlertBrd(genAlertBrd);
					menuService.insertGenFooter(genFooter);
					menuService.insertGenCald(genCald);
					//방형준끝
					
					
					
					message="환영합니다. 넥스트페이지 입니다.";
						logicalViewName = "redirect:/nextpage/nextPageMain";
						break;
				default:
					message= "서버오류. 다시 시도해주세요.";
					logicalViewName = "nextpage/nomenu/03_nextPageSignup/nextPageSignup";
					break;
				}
			}else {
			logicalViewName = "nextpage/nomenu/03_nextPageSignup/nextPageSignup";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return logicalViewName;
	}
	
	// 아이디 중복체크!!!!!
	@PostMapping("/idCheck") 
	@ResponseBody
	public int idDupleCheck(
		HttpSession session
		, @RequestParam("schId") String schId
			) {
		log.info("중복체크 제이슨 들어오십니까?");
		
		int row = service.checkSchId(schId);
		log.info("row:????{}",row);
		return row;
	}
	
	// 학교 이름 중복체크!!!!!
	@PostMapping("/schCheck") 
	@ResponseBody
	public int schDupleCheck(
		HttpSession session
		, @RequestParam("schNm") String schNm
		, @RequestParam("schAddr1") String schAddr1
			) {
		log.info("학교 중복체크 제이슨 들어오십니까?");
		
		SchoolVO vo = new SchoolVO();
		
		vo.setSchNm(schNm);
		vo.setSchAddr1(schAddr1);
		
		int row = service.checkSch(vo);
		log.info("row:????{}",row);
		return row;
	}
}
