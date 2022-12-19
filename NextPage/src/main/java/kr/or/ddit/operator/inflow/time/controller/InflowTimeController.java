package kr.or.ddit.operator.inflow.time.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.operator.inflow.time.servuce.InflowTimeService;
import kr.or.ddit.vo.InflowTimeVO;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/통계분석/유입시간대 분석
 * 설명 : 00시 ~ 23시의 방문자 수 통계
 * @author choim
 *
 */

@Controller
public class InflowTimeController {

	@Inject
	InflowTimeService service;
	
	@RequestMapping("operator/inflowTime")
	public String inflowTime( Model model ) {
		
		// 작성자  : 최현우
		
		
		// 먼저 DB에서 시간대와 방문자 수의 데이터를 가져온다.
		List<InflowTimeVO> list = service.getData();
		
		if( list.size() < 24 ) {
			list = makeData( list ); // 원래 있는 데이터는 건들지 않는다, 시간대가 없는 데이터만 생성해서 저장
		}
		
		for( InflowTimeVO vo : list ) {
			System.out.println( "=================================" );
			System.out.println( "TIME : " + vo.getTime() );
			System.out.println( "VISITORS : " + vo.getVisitors() );
			System.out.println( "=================================" );
		}
		
		model.addAttribute( "list", list );
		
		return "operator/07_inflowTime/inflowTime";
	}
	
	
	/**
	 * 작성자 : 최현우
	 * 기능 : 00시 ~ 23시까지의 데이터가 모두 없을 경우 없는 시간대의 데이터를 임의로 생성해서 저장한다.
	 * 설명 : 아직 데이터가 부족한 관계로 더미데이터를 만드는 함수라 해당 함수 사용은 선택사항이다.
	 * ( 나중에 데이터가 충분히 쌓이면 사용할 필요 없음 )
	 * 
	 * @param list
	 * @return
	 */
	public List<InflowTimeVO> makeData( List<InflowTimeVO> list ){
		
		if( list.size() < 24 ) {
			
			int i = 0;
			while( list.size() != 24 ) {
				boolean hasToAdd = false;
				for( InflowTimeVO vo : list ) {
					int tmp = Integer.parseInt( vo.getTime() );
					if(	tmp	!= i ) {
						hasToAdd = true;
						break;
					}
				}
				if( hasToAdd ) {
					InflowTimeVO tempVo = new InflowTimeVO();
					tempVo.setTime( i + "" );
					int visitors = (int) (Math.random() * 100) + 1;
					tempVo.setVisitors( visitors + "");
					list.add( tempVo );
					hasToAdd = false;
				}
				i++;
			}
			
			
		}
		
		return list;
	}
	
}
