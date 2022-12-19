package kr.or.ddit.school.manager.homepage.manage.controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import kr.or.ddit.school.manager.homepage.manage.service.HomePageManageService;
import kr.or.ddit.vo.GenSiteVO;
import kr.or.ddit.vo.LayoutVO;
import kr.or.ddit.vo.PrjctVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.SlotOptVO;
import kr.or.ddit.vo.SlotVO;
import kr.or.ddit.vo.TestttVO;
import kr.or.ddit.vo.genTemplateVO;
import lombok.extern.log4j.Log4j2;

//@MultipartConfig
@Log4j2
@Controller
public class HomePageManageController_66_67 {
	
	@Inject
	public HomePageManageService service;
	
	@RequestMapping(value = "school/manager/home/page/manage", method=RequestMethod.GET)
	public String mainpage(
			HttpSession session
			, Model model
			) {
		String schId = ( String )session.getAttribute( "authSch" ); 
		//schId = "a001"; //임시용데이터
		
		List<GenSiteVO> genSiteList = service.retrieveGenSiteList(schId);
		
		
		log.info("asdddasdasdasdasdas : {}, ",genSiteList);
		
		model.addAttribute("genSiteList", genSiteList);
		
		return "schoolManager/66_homePageManage/homePageManage";
	}
	
	@RequestMapping(value = "school/manager/homepage/make/cost", method=RequestMethod.GET)
	public String choiceTemplateCost(
			@RequestParam(required=false) String prjctId
			,HttpSession session
			, Model model
			) {
		//프로젝트 아이디 세션에 담음.

		session.setAttribute("prjctId", prjctId);
		String schId = ( String )session.getAttribute( "authSch" );
		List<genTemplateVO> costTemplateList = service.retrieveCostTemplateLists(schId);
		
		model.addAttribute("costTemplateList", costTemplateList);
		
		return "schoolManager/67_homePageManage2/homePageManageCost";
	}
	
	@RequestMapping(value = "school/manager/homepage/make/free", method=RequestMethod.GET)
	public String choiceTemplateFree(
			Model model
			) {
		
		log.info("홈페이지 만들기 + 무료템플릿 고르기");
		
		List<genTemplateVO> freeTemplateList = service.retrieveFreeTemplateList();
		
		
		model.addAttribute("freeTemplateList", freeTemplateList);
		
		return "schoolManager/67_homePageManage2/homePageManageFree";
	}
	
	@RequestMapping(value = "school/manager/homepage/choiceLayout", method=RequestMethod.GET)
	public String choiceLayout(
			@RequestParam(required=true) String tmpltId
			, Model model
			) {
		
		log.info("홈페이지만들기 + 템플릿선택함 템플릿ID : {}", tmpltId);
		log.info("-> 레이아웃고르기");
		
		genTemplateVO genTemplate = service.retrieveTemplate(tmpltId);
		List<LayoutVO> layoutList = service.retrieveLayoutList(); 
		
		model.addAttribute("layoutList", layoutList);
		model.addAttribute("genTemplate", genTemplate);
		
		
		return "schoolManager/69_contentsManage/selectLayout";
	}
	
	@RequestMapping(value = "school/manager/homepage/makeHomepage", method=RequestMethod.GET)
	public String makeHomepage(
			@RequestParam(required=true) String tmpltId
			, @RequestParam(required=true) String layoutId
			,HttpSession session
			, Model model
			) {
		
		//세션에서 프로젝트 아이디 가져옴.
		String prjctId = (String) session.getAttribute("prjctId");
		log.info("세션에서 가져온 prjctId : {}", prjctId);
		log.info("get방식 데이터 가져옴 : {}, {} ", tmpltId, layoutId);
		
		PrjctVO prjct = new PrjctVO();
		prjct.setLayoutId(layoutId);
		prjct.setPrjctId(prjctId);
		
		
		GenSiteVO genSite = new GenSiteVO();
		genSite.setPrjctId(prjctId);
		genSite.setTmpltId(tmpltId);
		genSite.setLayoutId(layoutId);
		
		log.info("genSite 자료 : {}", genSite);
		  
		int result = service.updateGenSite(genSite);
		log.info("업데이트 결과1 : {}", result);
		int result2 = service.updatePrjct(prjct);
		log.info("업데이트 결과2 : {}", result2);
		
		
		String schId = ( String )session.getAttribute( "authSch" ); 
		//schId = "a001"; //임시용데이터
		
		List<GenSiteVO> genSiteList = service.retrieveGenSiteList(schId);
		
		session.removeAttribute("prjctId");
		
		model.addAttribute("genSiteList", genSiteList);
		
		return "schoolManager/66_homePageManage/homePageManage";
	}
	
	@RequestMapping(value = "school/manager/homepage/clearProject", method=RequestMethod.GET)
	public String clearProject( 
			@RequestParam(required=true) String prjctId
			, HttpSession session
			, Model model
			) {
		String schId = ( String )session.getAttribute( "authSch" );
		log.info("프로젝트 아이디 : {}", prjctId);
		
		int result = service.clearGenSite(prjctId);
		
		log.info("프로젝트 클리어 결과 : {}", result);
		
		//
		if(result > 0) {
			
			service.deleteSlot(prjctId);
		}
		
		 
		//schId = "a001"; //임시용데이터
		
		List<GenSiteVO> genSiteList = service.retrieveGenSiteList(schId);
		
		model.addAttribute("genSiteList", genSiteList);
		
		return "schoolManager/66_homePageManage/homePageManage";
	}
	
	@RequestMapping(value = "school/manager/homepage/selectProject", method=RequestMethod.GET)
	public String selectProject( 
			@RequestParam(required=true) String prjctId
			, HttpSession session
			, Model model
			) {
		
		
		String schId = ( String )session.getAttribute( "authSch" ); 
		//schId = "a001"; //임시용데이터
		
		log.info("ppppppppprjctId : {}", prjctId);
		
		
		int delResult = service.deleteHomeSelect(schId);
		int upResult = 0;
		if(delResult > 0) {
			upResult = service.updateHomeSelect(prjctId);
		}
		
		log.info("del Result : {}, upResult : {}", delResult, upResult);
		
		
		
		List<GenSiteVO> genSiteList = service.retrieveGenSiteList(schId);
		
		model.addAttribute("genSiteList", genSiteList);
		return "schoolManager/66_homePageManage/homePageManage";
	}
	
	@RequestMapping(value = "school/manager/homepage/updateProject", method=RequestMethod.GET)
	public String updateProject( 
			@RequestParam(required=true) String prjctId
			//, HttpSession session
			, Model model
			) {
		
		log.info("홈페이지 꾸미기 ㄱㄱㄱ 프로젝트아이디 : {}", prjctId);
		
		model.addAttribute("prjctId", prjctId);
		
		LayoutVO layout = service.retrieveLayout(prjctId);
		
		genTemplateVO genTemplate = new genTemplateVO();
		genTemplate = service.selectGenTmpThmnl(prjctId);
		
		//레이아웃에 들어가지못한 옵션들
		List<SlotOptVO> slotOptList = service.retrieveSlotOptList(prjctId);
		
		//레이아웃에 들어간 옵션들
		List<SlotOptVO> divInSlotOptList = service.retrieveDivInSlotOptList(prjctId);
		
		model.addAttribute("genTemplate", genTemplate);
		model.addAttribute("slotOptList", slotOptList);
		model.addAttribute("divInSlotOptList", divInSlotOptList);
		model.addAttribute("layout", layout);
		
		return "schoolManager/68_homePageMainUpdate/homePageMainUpdate";
	}
	
	@PostMapping(value = "school/manager/homepage/updateProject",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
			)// produces=MediaType.APPLICATION_JSON_UTF8_VALUE // consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
	public String updateProject(
			//, @RequestParam String prjctId
			//@RequestBody List<TestttVO> layoutData
			@RequestBody Map<String, Object> layoutData
			) {
		// 데이터 + 잡다한것. //다 가지고 있는 VO
		// Map의 형태. //
		ArrayList<Map<String,String>> updateLayout = (ArrayList<Map<String, String>>) layoutData.get("layoutData");
		String prjctId = (String) layoutData.get("prjctId");
		
		int result = service.deleteSlot(prjctId);
		int slotCount = service.countSlotNum(prjctId);
		
		SlotVO slot = new SlotVO();
		
		slot.setPrjctId(prjctId);
		
		int resultInsert =0;
		
		//result -> 기존에 있던 데이터 삭제 성공여부, 
		//slotCount -> 첫등록시 삭제할 데이터가 없으므로 result가 0이 되어 구분을 할수없음.
		//따라서 슬롯수를 세어와서 첫등록인지 확인 함.
		if(result > 0 || slotCount == 0) {
			for(int i = 0 ; i < updateLayout.size(); i++) {
				//log.info("ss1 값들 : {}", ss1.get(i)); //id가 div1 name이 값
				log.info("ss1 값들 : {}, {}", updateLayout.get(i).get("id"), updateLayout.get(i).get("name"));
				String divNum = updateLayout.get(i).get("id");
				String divValue = updateLayout.get(i).get("name");
				
				slot.setDivNum(divNum);
				slot.setDivValue(divValue);
				
				resultInsert = service.InsertSlot(slot);
			}
		}
		
		if(resultInsert > 0) {
			log.info("인서트성공!!!!!!!!!!!!!!!!!!!");
		}
		/*if(result==1) {
			for(int i = 0 ; i < ss1.size(); i++) {
				//log.info("ss1 값들 : {}", ss1.get(i));
				log.info("ss1 값들 : {}, {}", ss1.get(i).get("id"), ss1.get(i).get("name"));
				
			}
		}*/
		
		log.info("프로젝트 아이디 : {}", prjctId);
		
		String viewName = "/schoolManager/66_homePageManage/homePageManage";
		return viewName;
	}

}
