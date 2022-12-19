package kr.or.ddit.generation.website.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.common.enumpkg.ServiceResult;
import kr.or.ddit.generation.options.footer.service.FooterService;
import kr.or.ddit.generation.website.board.service.GeneratingBoardReplyService;
import kr.or.ddit.generation.website.board.service.GeneratingBoardService;
import kr.or.ddit.generation.website.other.URLMappingHandler;
import kr.or.ddit.generation.website.other.ViewMaker;
import kr.or.ddit.school.manager.auth.service.AuthManageService;
import kr.or.ddit.school.manager.board.manage.service.BoardManageService;
import kr.or.ddit.school.manager.menu.manage.service.MenuManageService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.AuthCnctVO;
import kr.or.ddit.vo.FTP_Module;
import kr.or.ddit.vo.GenBoardVO;
import kr.or.ddit.vo.GenCmntVO;
import kr.or.ddit.vo.GenMenuVO;
import kr.or.ddit.vo.GenPostVO;
import kr.or.ddit.vo.GeneratingMainVO;
import kr.or.ddit.vo.Image64;
import kr.or.ddit.vo.MyQuestionVO;
import kr.or.ddit.vo.OtoCmntVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SchoolVO;
import kr.or.ddit.vo.SearchVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sun.print.resources.serviceui;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GeneratingBoardListController {

	private final BoardManageService genBoardService;

	private final GeneratingBoardService genPostService;

	private final AuthManageService authService;

	private final GeneratingBoardReplyService replyService;

	//푸터적용
	@Inject
	private FooterService footerService;


	String tmpltId = "";
	

	/** ---------------- 제너레이팅- 게시판 리스트(게시판 옵션,게시물,권한처리) -이유영 ----------------------*/

	@ModelAttribute("genBoardOption")
	   public String genBoardOption(
	         @RequestParam(name="brdNum", required=true) int brdNum,
	         Model model,
	         HttpSession session,
	         @PathVariable("id") String id
	         ) {
	      GenBoardVO gen= new GenBoardVO();
	      gen = genBoardService.selectGenBoard(brdNum);
	      model.addAttribute("genBoardOption",gen);

	      List<AuthCnctVO> authCnctList = authService.retrieveAuthList(brdNum);
	      log.info("auth 리스트 데이터 : {}", authCnctList);
	      log.info("gen 리스트 데이터 : {}", gen);


	    //======================footer 시작==================================
			SchoolVO footer = footerService.selectGenFooter(id);
			model.addAttribute("footer",footer);

			//======================footer 끝==================================


	      String templateId = (String) session.getAttribute( "templateId" );
	      log.info("templateId: {}",templateId);
	      if( templateId == null ) {
	    	  log.debug( "templateId == null" );
	      }else {
	    	  log.debug( "templateId : " + templateId );
	    	  if( templateId.equals( "TMPLT001" ) ) {
	    		  tmpltId = "template01";
	    	  }else if( templateId.equals( "TMPLT002" ) ) {
	    		  tmpltId = "template02";
	    	  }else if( templateId.equals( "TMPLT003" ) ) {
	    		  tmpltId = "template03";
	    	  }
	      }


	      model.addAttribute("authCnctList", authCnctList);


	      return "generation/"+ tmpltId +"/61_generatingBoardList/generatingBoardList";
	   }

	@RequestMapping( "generation/{id}/board" )
	public String generatingBoardList(
			HttpServletRequest request,
			@RequestParam(name="brdNum", required=true) int brdNum,
			HttpSession session,
			@PathVariable("id") String id,
			@ModelAttribute("genBoard") GenBoardVO genBoard,
			Model model
			) {

				log.debug( "generationBoardList 들어와" );

				// 여기부터
				String viewName = null;
				// 35_generatingMain/generatingMain
				// error/error

				// 요청한 URL주소 ( 별로 의미없음 )
				//String whatYouCallValue = request.getServletPath();
				//log.info( "입력한 Generation main url : " + whatYouCallValue );

				// DB에서 가져온 정보
				//List<GeneratingMainVO> data = service.getOptionsURL( id );

				// 메뉴 사용여부 목록을 가져올때 사용하는 객체
				URLMappingHandler urlM = new URLMappingHandler();

				// DB에서 메뉴 사용여부가 YES인 목록만 가져옴 ( 사용할 때 사용자 아이디를 파라미터로 집어넣야함 )
				List<GeneratingMainVO> data = urlM.getLinksFromDB( id );

				genBoard =  genBoardService. selectGenBoard(brdNum);
				genBoard.setBrdNum(genBoard.getBrdNum());
				String type = genBoard.getBrdTypeId();

				if( data != null && !data.isEmpty() ) { // DB에서 사용여부 목록을 잘 가져왔나 확인하는 조건

					System.out.println("***************************"+type);
					
					viewName = (String) session.getAttribute("rtrnJsp");
					
					/*if(type.equals("1")) {
						System.out.println("1번들어옴.");
						log.debug( "tmpltId : " + tmpltId );
						viewName = "generation/" + tmpltId + "/61_generatingBoardList/generatingBoardList"; //일반게시판
					}else if(type.equals("2")){
						System.out.println("2번들어옴.");
						viewName = "generation/" + tmpltId +"/54_generatingImageBoard/generatingImageBoard"; //이미지게시판

					}else if(type.equals("3")) {
						System.out.println("3번들어옴.");
						viewName = "generation/"+ tmpltId +"/57_generatingVideoBoard/generatingVideoBoard"; //동영상게시판
					}*/

				}else {
					viewName = "error/error";
				}

				/*ViewMaker viewMaker = new ViewMaker( data );
				String view = viewMaker.headerViewMaker( id, data );
				model.addAttribute( "view", view );*/

				model.addAttribute( "id", id ); // 현재 접속한 사이트 주인의 아이디

				return viewName;

	}

	@RequestMapping(value = "generation/{id}/board", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<GenPostVO> boardPost(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(name="brdNum", required=true) int brdNum,
			@ModelAttribute("simpleCondition") SearchVO simpleCondition,
			Model model, HttpSession session,
			@PathVariable("id") String id
	){

		log.debug( "PagingVO 들어와" );

	     String memId = (String) session.getAttribute("authMem");
	     
	     log.debug( "PagingVO<GenPostVO> boardPost 메소드 실행" );
	      /* 삭제예정
	      SearchVO simpleCondition = new SearchVO();
	      int currentPage = 1;
	      */
	     
	      // ----------------게시판 옵션 --------------
	      GenBoardVO genBoardOption =genBoardService.selectGenBoard(brdNum);
	      log.info("genBoardOption이 넘어가는지???"+genBoardOption);

	      String strPageNum = genBoardOption.getPagePostNum();
	      int pageNum = 0;
	      if(genBoardOption.getBrdTypeId().equals("1")) { //일반게시판일때, 그냥 문자를 숫자로 변환하면 끝.
	         pageNum = Integer.parseInt(strPageNum);
	      }else {                                 //이미지, 동영상게시판일때, 문자값에 따라서 pageNum을 세팅해줌.
	         if(strPageNum.equals("3X3")) {
	            pageNum = 9;
	         }else if(strPageNum.equals("4X2")) {
	            pageNum = 8;
	         }
	      }

	      log.info("jsp에서 올라온 검색어 : {}",simpleCondition);

	    PagingVO<GenPostVO> pagingVO = new PagingVO<>(pageNum ,5);
		pagingVO.setBrdNum(brdNum);
		pagingVO.setMemId(memId); //나중에 에러나면 한번더 확인.
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSimpleCondition(simpleCondition);
		int totalRecord = genPostService.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<GenPostVO> genPostList = genPostService.schoolGenPostList(pagingVO);
		
		
		
		
		
		
		System.out.println("인덱스돌자");
		for(int i=0;i<genPostList.size();i++)
		{
			System.out.println("인덱스돌기"+genPostList.get(i).getFileId());
			if(genPostList.get(i).getFileId()!=null)
			{
				//genPost파일에 대한 정보를 가져옴
				genPostList.get(i).setImage(genPostService.getAttatchFileDetailNum(genPostList.get(i).getFileId()));
				System.out.println("들어왔군"+i);
				String str=genPostList.get(i).getImage().getFileName();
				System.out.println("파일네임"+str);
				str=str.substring(str.length()-3,str.length());
				System.out.println("엠피포"+str);
				if("jpg".equals(str)||"JPG".equals(str)||"PNG".equals(str)||"png".equals(str)||"mp4".equals(str))
				{
					
					Image64 img64=new Image64();	
				FTP_Module ftp = new FTP_Module();
				System.out.println("진짜파일네임"+genPostList.get(i).getImage().getFileName());
				
				img64.setFileName(genPostList.get(i).getFileName());
				String getSessionId=(String) session.getAttribute("authMem");
				String savePath="/"+id+"/POST_ATCH/";
				img64.setSaveName(ftp.FileReadImage(savePath, genPostList.get(i).getImage().getFileName()));
				genPostList.get(i).setFileName(genPostList.get(i).getImage().getFileName());
				genPostList.get(i).setRealName(img64.getSaveName());
				}
			}
			else {
				genPostList.get(i).setRealName("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");
			}
		}
		
		
		
		//건호 메인페이지 이미지 띄우기 리스트	
		
				
				/*System.out.println("리스트사이즈"+genPostList.size());
				for(int i=0;i<genPostList.size();i++)
				{
					System.out.println("인덱스돌기"+genPostList.get(i).getFileId());
					if(genPostList.get(i).getFileId()!=null)
					{
						GenPostVO genPost=genPostService.getAttatchFileDetailNum(genPostList.get(i).getFileId());
						System.out.println("들어왔군"+i);
						String str=genPost.getFileName();
						System.out.println("파일네임"+str);
						str=str.substring(str.length()-3,str.length());
						if("jpg".equals(str)||"JPG".equals(str)||"PNG".equals(str)||"png".equals(str))
						{
							
							Image64 img64=new Image64();	
						FTP_Module ftp = new FTP_Module();
						System.out.println("진짜파일네임"+genPost.getFileName());
						
						img64.setFileName(genPost.getFileName());
						img64.setSaveName(ftp.FileReadImage("/a001/POST_ATCH/", genPost.getFileName()));
						System.out.println("진짜세이브네임"+img64.getSaveName());
						ImageList.add(img64);
						}
					}
				}
				*/
				
		
		
		
		
		
		pagingVO.setDataList(genPostList);

		return pagingVO;

	}
	/** ---------------- 제너레이팅- 게시판상세 -이유영 ----------------------*/
	@GetMapping("generation/{id}/board/detail")
	public ModelAndView genPostDetail(
		@RequestParam(name="what", required=true) int postNum, Model model
	   ,@RequestParam(name="brdNum", required=true) int brdNum
	) {
		log.info("상세보기");
		GenPostVO genPost = genPostService.selectGenPost(postNum);
		GenBoardVO genBoard = genBoardService.selectGenBoard(brdNum);
		List<GenPostVO> genList=genPostService.getAttatchFile(postNum);
		int attach_num=genPostService.getAttatchNum(brdNum);

		if( genBoard == null ) {
			log.debug( "genBoard is Null" );
		}else {
			log.debug( "genBoard is NOT NULL" );
		}

		List<Image64> ImageList=new ArrayList<Image64>();

		for(int i=0;i<genList.size();i++)
		{
			String str=genList.get(i).getFileName();
			str=str.substring(str.length()-3,str.length());
			System.out.println("파일뇌임"+genList.get(i).getFileName());
			if("jpg".equals(str)||"JPG".equals(str)||"PNG".equals(str)||"png".equals(str)||"mp4".equals(str))
			{
				Image64 img64=new Image64();
			FTP_Module ftp = new FTP_Module();
			img64.setFileName(genList.get(i).getFileName());
			img64.setSaveName(ftp.FileReadImage(genList.get(i).getSavePath(), genList.get(i).getFileName()));
			ImageList.add(img64);
			}

		}



		List<GenCmntVO> replyList = replyService.generatingBoardReplyList(postNum);
		ModelAndView mav = new ModelAndView();
/*		AuthCnctVO authCnct = new AuthCnctVO();*/
	    List<AuthCnctVO> authCnctList = authService.retrieveAuthList(brdNum);
	    log.info("auth 리스트 데이터 : {}", authCnctList);

	    mav.addObject("ImageList",ImageList);
	    mav.addObject("authCnctList", authCnctList);
		mav.addObject("genPost", genPost);
		mav.addObject("genBoard", genBoard);
		mav.addObject("reply", replyList);
		mav.addObject("genList",genList);
		mav.addObject("attach_num",attach_num);



		AuthCnctVO authCnct = new AuthCnctVO();
		authCnct.setNum(brdNum);

		authCnct.setAuthType("SCRT");
		authCnct.setAuthType("BRWS");

		String type = genBoard.getBrdTypeId();
		if( type == null ) {
			log.debug( "type is null" );
		}else {
			log.debug( "type is NOT NULL" );
		}

		if(type.equals("1")) { //일반게시판
			
			log.debug(" {} {}", authCnct.getAuthType(), authCnct.getAuthType());

			if(authCnct.getAuthType().equals("BRWS") || authCnct.getAuthType().equals("SCRT")){
				
				if(authCnct.getAuthType().equals("SCRT") || StringUtils.equals("YES", genPost.getPostScrtWhether())) {
					mav.setViewName("generation/"+ tmpltId +"/63_generatingBoardDetail/generatingScrtBoardDetail");//비밀글
				}else {
					mav.setViewName("generation/"+ tmpltId +"/63_generatingBoardDetail/generatingBoardDetail"); //일반글
				}
				
			};

//			if(authCnct.getAuthType().equals("SCRT")&&genPost.getPostScrtWhether().equals("YES")) {
//					mav.setViewName("generation/"+ tmpltId +"/63_generatingBoardDetail/generatingScrtBoardDetail");//비밀글
//			}else {
//				mav.setViewName("generation/"+ tmpltId +"/63_generatingBoardDetail/generatingBoardDetail"); //일반글
//			}
			
		}else if(type.equals("2")) { //이미지게시판
			mav.setViewName("generation/"+ tmpltId +"/55_generatingDetailImageBoard/generatingDetailImageBoard");
		}else if(type.equals("3")) { //동영상게시판
			mav.setViewName("generation/"+ tmpltId +"/58_generatingVideoDetail/generatingVideoDetail");
		}




		return mav;
	}


	/** ---------------- 제너레이팅- 게시판추가 -이유영 ----------------------*/


	@ModelAttribute("genBoard")
	   public String genBoardId(
	         @RequestParam(name="brdNum", required=true) int brdNum
	         ,Model model
	         ) {
	      GenBoardVO gen= new GenBoardVO();
	      gen = genBoardService.selectGenBoard(brdNum);
	      model.addAttribute("genBoard",gen);

	      String viewName="";
	      log.info("gen 리스트 데이터 : {}", gen);
	      String type = gen.getBrdTypeId();
			if( type == null ) {
				log.debug( "type is null" );
			}else {
				log.debug( "type is NOT NULL" );
			}

			if(type.equals("1")) { //일반게시판
				viewName= "generation/"+ tmpltId +"/62_generatingWrite/generatingWrite";
			}else if(type.equals("2")) { //이미지게시판
				viewName="generation/"+ tmpltId +"/56_generatingImageBoardWrite/generatingImageBoardWrite";
			}else if(type.equals("3")) { //동영상게시판
				viewName="generation/"+ tmpltId +"/59_generatingVideoBoardWrite/generatingVideoBoardWrite";
			}

	      return viewName;
	   }

	@RequestMapping(value="generation/{id}/board/add" , method=RequestMethod.GET)
	public String generatingBoardAdd(
			@RequestParam(name="brdNum", required=true) int brdNum
			, @ModelAttribute("genBoard") GenBoardVO genBoard
			, Model model
			) {
		log.debug("generation/*/board/add 진입");
		log.info("bbbbbbbbbbbbbbbbbrdNum{}",brdNum);
		String viewName="";
		String type = genBoard.getBrdTypeId();
			if( type == null ) {
				log.debug( "type is null" );
			}else {
				log.debug( "type is NOT NULL" );
			}
			int attach_num=genPostService.getAttatchNum(brdNum);
			model.addAttribute("attach_num",attach_num);

			if(type.equals("1")) { //일반게시판
				viewName= "generation/"+ tmpltId +"/62_generatingWrite/generatingWrite";
			}else if(type.equals("2")) { //이미지게시판
				viewName="generation/"+ tmpltId +"/56_generatingImageBoardWrite/generatingImageBoardWrite";
			}else if(type.equals("3")) { //동영상게시판
				viewName="generation/"+ tmpltId +"/59_generatingVideoBoardWrite/generatingVideoBoardWrite";
			}
		return viewName;
	}

	@RequestMapping(value="generation/{id}/board/add",  method=RequestMethod.POST)
	public String generatingBoardInsert(
			 GenPostVO genPost
			,@RequestParam(name="brdNum", required=true) int brdNum
			,Model model
			,Errors errors
			,HttpSession session
			,String postTitle
			,String postCntnt
			) {
		genPost.setBoFiles(genPost.getBoFiles());
		System.out.println("건호진입");
		log.info("Post 메소드 핸들러 PostInsert 실행 : {}"+genPost);

		/*if(genPost.getPostNotisWhether() == null) {
			genPost.setPostNotisWhether("NO");
		};
		if(genPost.getPostScrtWhether() == null) {
			genPost.setPostScrtWhether("NO");
		}
		 */


		String memId = (String) session.getAttribute("authMem");
		log.info("memId_-----------{}"+memId);

		 String viewName = null;
		 if(!errors.hasErrors()) {

			 genPost.setPostWrtId(memId);
			 log.info("genPost.prgrsCndtn{}", genPost.getPostPrgrsPrsntCndtn());
			 log.info("뭔가넘어오니?{}", genPost);
			 String gunhoPath="/"+(String)session.getAttribute("authMem")+"/POST_ATCH/";
			 genPost.setSavePath(gunhoPath);
			 System.out.println("합쳐진 path:"+genPost.getSavePath());
			 ServiceResult result = genPostService.insertGenPost(genPost);

			 String message =null;
			 if(ServiceResult.OK.equals(result)) {
				 log.info("성공!!!!!!!!!!!{}"+result);
				 viewName = "redirect:/generation/{id}/board?brdNum="+genPost.getBrdNum() ;
				 log.info("성공한 viewName?----------------------------------{}" + viewName);
			 }else {
				 log.info("실패!!!!!!!!!!!{}"+result);
				 message="등록 실패 ";
				 model.addAttribute("message", message);
				 viewName ="redirect:generation/{id}/board/add";
				 log.info("실패한 viewName?{}" + viewName);
			 }
		 }else {
			 System.out.println(errors);
			 viewName ="redirect:generation/{id}/board/add";
			 log.info("왜 실패지?----------------------------------{}" + viewName);
		 }
		 return viewName;


	}

	/** ---------------- 제너레이팅- 게시판수정 -이유영 ----------------------*/

	@GetMapping("generation/{id}/board/update")
	public ModelAndView genPostEdit(
			@RequestParam(name="what", required=true) int postNum, Model model
		   ,@RequestParam(name="brdNum", required=true) int brdNum
		   ,@ModelAttribute("genPost") GenPostVO genPost
		   ,@ModelAttribute("genBoard") GenBoardVO genBoard
		) {
			log.info("상세보기");

			genPost = genPostService.selectGenPost(postNum);
			genBoard = genBoardService.selectGenBoard(brdNum);

			List<GenPostVO> genList=genPostService.getAttatchFile(postNum);
			int attach_num=genPostService.getAttatchNum(brdNum);

			ModelAndView mav = new ModelAndView();

			mav.addObject("genPost", genPost);
			mav.addObject("genBoard", genBoard);

			mav.addObject("genList",genList);
			mav.addObject("attach_num",attach_num);


			String type = genBoard.getBrdTypeId();
			if( type == null ) {
				log.debug( "type is null" );
			}else {
				log.debug( "type is NOT NULL" );
			}

			if(type.equals("1")) { //일반게시판
				mav.setViewName("generation/" + tmpltId + "/generatingBoardModify/generatingBoardModify"); //일반글
			}else if(type.equals("2")) { //이미지게시판
				mav.setViewName("generation/" + tmpltId + "/generatingBoardModify/generatingImageBoardModify");
			}else if(type.equals("3")) { //동영상게시판
				mav.setViewName("generation/" + tmpltId + "/generatingBoardModify/generatingVideoBoardModify");
			}

			return mav;
		}

	@PostMapping("generation/{id}/board/update")
	public String genPostUpdate(
		@RequestParam(name="what", required=true) int postNum
	   ,@RequestParam(name="brdNum", required=true) int brdNum
	   ,@ModelAttribute("genPost") GenPostVO genPost
	   ,@ModelAttribute("genBoard") GenBoardVO genBoard
	   , Model model, Errors errors
	) {
		genPost.setPostNum(postNum);
		String viewName = null;

		/*log.info(" UPDATE 시작 genBoard : {} ", genBoard);*/
		log.info(" UPDATE 시작 genPost : {} ", genPost);

		if(genPost.getPostNotisWhether() == null) {
			genPost.setPostNotisWhether("NO");
		};
		if(genPost.getPostScrtWhether() == null) {
			genPost.setPostScrtWhether("NO");
		}

		String type = genBoard.getBrdTypeId();
		log.info("에러스 : {}", errors);
		if(!errors.hasErrors()) {
			ServiceResult result = genPostService.modifyGenPost(genPost);
			String message = null;
			switch (result) {
			case OK:
				viewName = "redirect:/generation/{id}/board/detail?brdNum="+genPost.getBrdNum()+"&what="+genPost.getPostNum();
				break;
			default:
				message = "서버 오류";
				viewName = "generation/generatingBoardModify/generatingBoardModify";
				break;
			}
			model.addAttribute("message", message);
		}else {
			if(type.equals("1")) {
				viewName = "generation/generatingBoardModify/generatingBoardModify";
			}else if(type.equals("2")) { //이미지게시판
				viewName ="generation/" + tmpltId + "/generatingBoardModify/generatingImageBoardModify";
			}else if(type.equals("3")) { //동영상게시판
				viewName ="generation/" + tmpltId + "/generatingBoardModify/generatingVideoBoardModify";
			}
		}
		return viewName;
	}

	@GetMapping("generation/{id}/board/delete")
	public String genPostDelete(
		@RequestParam(name="what", required=true) int postNum
	   ,@RequestParam(name="brdNum", required=true) int brdNum
	   ,@ModelAttribute("genPost") GenPostVO genPost
	   ,@ModelAttribute("genBoard") GenBoardVO genBoard
	   ,HttpSession session
	) {
		List<GenPostVO> notice=genPostService.getAttatchFile(postNum);
		FTP_Module ftp=new FTP_Module();

		String gunhoPath=(String)session.getAttribute("authMem");


		for(int i=0;i<notice.size();i++)
		{
			System.out.println(notice.get(i).getFileName()+"김건호"+ notice.get(i).getSaveName()+"김건호"+ notice.get(i).getSavePath()+"임니다.");
			ftp.ftpFileDelete(notice.get(i).getFileName(), notice.get(i).getSaveName(), notice.get(i).getSavePath());
		}

		genPost.setPostNum(postNum);
		genBoard.setBrdNum(brdNum);
		genPostService.deleteGenPostFile(postNum);
		genPostService.deleteGenPost(genPost);





		return "redirect:/generation/{id}/board?brdNum="+genBoard.getBrdNum();
	}



	@PostMapping(value="generation/{id}/board/replyInsert")
	public String replyInsert(
		@RequestParam(name="what", required=true) int postNum
	   ,@RequestParam(name="brdNum", required=true) int brdNum
	   ,@ModelAttribute("genPost") GenPostVO genPost
	   ,@ModelAttribute("genBoard") GenBoardVO genBoard
	   ,@ModelAttribute("reply") GenCmntVO genCmnt
	   ,HttpSession session
	) {
		String memId = (String) session.getAttribute("authMem");
		genCmnt.setCmntId(memId);
		String viewName = null;
		log.info("값 제대로 들어오니"+genCmnt);
		replyService.createReply(genCmnt);
		viewName = "redirect:/generation/{id}/board/detail?brdNum="+genPost.getBrdNum()+"&what="+genPost.getPostNum();
		return viewName;
	}

	@GetMapping(value="generation/{id}/board/replyDelete")
	public String replyDelete(
			@RequestParam(name="what", required=true) int postNum
			,@RequestParam(name="brdNum", required=true) int brdNum
			,@RequestParam(name="reply", required=false) int cmmntId
			,@ModelAttribute("genPost") GenPostVO genPost
			,@ModelAttribute("genBoard") GenBoardVO genBoard
			,@ModelAttribute("reply") GenCmntVO genCmnt
			,HttpSession session
			) {
		String memId = (String) session.getAttribute("authMem");
		genCmnt.setCmntId(memId);
		genPost.setPostNum(postNum);
		genBoard.setBrdNum(brdNum);
		String viewName = null;
		genCmnt.setCmmntId(cmmntId);
		log.info("값 제대로 들어오니"+genCmnt);
		replyService.removeReply(genCmnt);
		viewName = "redirect:/generation/{id}/board/detail?brdNum="+genPost.getBrdNum()+"&what="+genPost.getPostNum();
		return viewName;
	}

}




