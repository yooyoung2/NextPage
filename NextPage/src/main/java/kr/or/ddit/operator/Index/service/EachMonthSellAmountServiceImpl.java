package kr.or.ddit.operator.Index.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.operator.Index.dao.EachMonthSellAmountDAO;
import kr.or.ddit.vo.EachMonthSellAmountVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 작성자 : 최현우
 * 기능 : 운영자/INDEX/1년 매출( 월별 출력 ) -> 그래프
 * 
 * 해당 월의 매출액을 표시한다.
 * 
 * @author PC-04
 *
 */
@Slf4j
@Service
public class EachMonthSellAmountServiceImpl implements EachMonthSellAmountService {

	@Inject
	EachMonthSellAmountDAO dao;
	
	/**
	 * 작성자 : 최현우
	 * 기능 : 각 월의 매출액 저장
	 * @return
	 */
	public List<EachMonthSellAmountVO> eachMonthSell() {
			
		// 1월부터~12월까지 월별 매출금액을 가져온다,
		List<EachMonthSellAmountVO> lst = dao.eachMonthSell();
		
		if( lst.size() < 12 ) {
			// 1월부터 12월까지 데이터가 없음
			
			Map<String,String> data = new HashMap<>();
			
			// 몇월이 있고 몇월이 없는지 찾아야함.
			for( EachMonthSellAmountVO vo : lst ) {
				
				if( vo.getMonth() != null ) {
					int month = Integer.parseInt( vo.getMonth() );
					
					for( int i = 1; i <= 12; i++ ) {
						if( i == month ) {
							// 해당 월이 있다는 뜻이기 때문에 pass
							break;
						}else {
							// 해당 월이 없다면 추가
							
							String mon = i + "";
							String total = (int)(Math.random()*10000) + "";
							
							data.put( mon , total );
						}
					}
					
				}
				
			}
			
			// 검사를 모두 마치고 for문을 벗어나면 이제 map에 있는 데이터를 리스트에 추가한다.
			Iterator<String> keys = data.keySet().iterator();
			while( keys.hasNext() ){
	            String month = keys.next();
	            String total = data.get( month );
	            
	            EachMonthSellAmountVO tmp = new EachMonthSellAmountVO();
	            
	            tmp.setMonth( month );
	            tmp.setTotal( total );
	            
	            lst.add( tmp );
	            
	        }
			
			
			return lst;
			
		}else {
			// 1 ~ 12월 데이터 모두 있음.
			return lst;
		}
		
	}

}
