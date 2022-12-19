package kr.or.ddit.generation.website.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import kr.or.ddit.generation.website.main.dao.GeneratingMainDAO;
import kr.or.ddit.generation.website.main.dao.GeneratingMainDAOImpl;
import kr.or.ddit.vo.GeneratingMainVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 
 * generation 메인에서 링크 사이에 학교아이디를 집어넣어 generation main컨트롤러에서 비교적 쉽게 해당 아이디로
 * 저장되어있는 모든 기능들의 링크를 DB에서 꺼내올 수 있었다. 그리고 그 링크들을 tiles-generation-headerMenu에
 * 뿌려줬는데 문제는 메인에서 다른 페이지로 이동하면 아이디값을 알수가 없어 그 headerMenu가 다시 로딩될때 가져올수있는 정보가 없어서
 * 링크란이 공백이 되었다. 이 문제를 해결하기 위해 해당 클래스를 만들었고 해당 클래스의 역할은 아이디가 주어지면 그 아이디에 대한 모든
 * URL정보를 DB에서 가져온다. 그럼 다른 페이지의 컨트롤러에서도 이 클래스만 호출해서 아이디값만 집어넣어주면 된다.
 * 
 * @author PC-04
 *
 */

@Slf4j
public class URLMappingHandler {

	GeneratingMainDAO dao = new GeneratingMainDAOImpl();
	
/*	@Inject
	GeneratingMainDAO dao;*/
	
	String schId = null;

	// key : 메뉴이름, value : 메뉴아이디 ( 메뉴 이름만 알면 메뉴 아이디를 알 수 있다. )
	Map<String, String> getMenuIdByName = new HashMap<>();
	// key : 메뉴이름, value : 링크 ( 메뉴 이름만 알면 메뉴 링크를 알 수 있다. )
	Map<String, String> getMenuLinkByName = new HashMap<>();

	public List<GeneratingMainVO> getLinksFromDB(String id) {

		schId = id;

	
		
		// DB에서 가져온 정보
		List<GeneratingMainVO> data = dao.getOptionsURL( id );
		
		
		if (data != null && !data.isEmpty()) {
			// 데이터가 잘 부러와졌을 때
			for (GeneratingMainVO vo : data) {
				log.info(id + "[메뉴아이디 : " + vo.getMenuId() + "]|[메뉴이름 : " + vo.getMenuNm() + "]|" + "[메뉴링크 : "
						+ vo.getMenuLink() + "]");
				getMenuIdByName.put(vo.getMenuNm(), vo.getMenuId());
				getMenuLinkByName.put(vo.getMenuNm(), vo.getMenuLink());
			}
			return data;
		} else {
			// 데이터가 null이므로 에러페이지로 이동
			return null;
		}

	}

	/**
	 * 작성자 : 최현우
	 * DB에서 가져온 리스트를 JSP에서 편하게 사용하기 위해 <메뉴이름,메뉴아이디>의 Map형태로 저장한다.
	 * @param lst
	 * @return
	 */
	public Map<String, String> getMenuIdByName(List<GeneratingMainVO> lst) {

		Map<String, String> getMenuId = new HashMap<>();

		for (GeneratingMainVO vo : lst) {
			log.info(schId + "[메뉴아이디 : " + vo.getMenuId() + "]|[메뉴이름 : " + vo.getMenuNm() + "]|" + "[메뉴링크 : "
					+ vo.getMenuLink() + "]");
			getMenuId.put(vo.getMenuNm(), vo.getMenuId());
		}

		return getMenuId;

	}

	/**
	 * 작성자 : 최현우
	 * DB에서 가져온 리스트를 JSP에서 편하게 사용하기 위해 <메뉴이름,메뉴링크>의 Map형태로 저장한다.
	 * @param lst
	 * @return
	 */
	public Map<String, String> getMenuLinkByName( List<GeneratingMainVO> lst ) {
		
		Map<String, String> getMenuLink = new HashMap<>();

		for (GeneratingMainVO vo : lst) {
			log.info(schId + "[메뉴아이디 : " + vo.getMenuId() + "]|[메뉴이름 : " + vo.getMenuNm() + "]|" + "[메뉴링크 : "
					+ vo.getMenuLink() + "]");
			getMenuLink.put(vo.getMenuNm(), vo.getMenuLink() );
		}

		return getMenuLink;
	}

}
