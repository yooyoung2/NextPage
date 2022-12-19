package kr.or.ddit.generation.website.other;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import kr.or.ddit.generation.website.main.service.GeneratingMainService;
import kr.or.ddit.vo.GeneratingMainVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * @author PC-04
 *
 */
@Slf4j
@Component
public class ViewContainer{

	/**
	 * 작성자 : 최현우
	 * ViewSetUp클래스의 목적 :	서버가 실행됨과 동시에 모든 회원의 메뉴 정보를 생성해서 세션에 저장하고 있으면
	 * 						어느 페이지로 가든 가져올 수 있지 않을까?
	 * 
	 * 문제점 : "어떤" 회원의 메뉴를 가져와하는지가 문제인데...
	 */
	
	
	@Inject
	GeneratingMainService service;
	
	@PostConstruct
	public void init() {
		
		log.info( "ViewSetUp : 최초실행!!!" );
		
		//URLMappingHandler urlM = new URLMappingHandler();
		ViewMaker viewMaker = new ViewMaker();
	
	}
	
	
}
