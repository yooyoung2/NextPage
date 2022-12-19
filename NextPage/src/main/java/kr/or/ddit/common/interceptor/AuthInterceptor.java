package kr.or.ddit.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler )
			throws Exception {
		
			String operatorViewName = "";
		
			log.debug( "[ AuthInterceptor activated ]" );
			HttpSession session = request.getSession();
		
			String auth = ( String )session.getAttribute( "authVal" );
			log.debug( "VALUE OF auth : " + auth );
			if( auth == null || auth.equalsIgnoreCase( "NONE" ) ) {
				// 세션에 운영자 정보가 담겨있지 않다면
				session.setAttribute( "authVal" , "NONE" );
				log.debug( "auth is NULL, value of auth after session.setAttribute( \"authMem\", \"NONE\" ) : " + session.getAttribute( "authVal" )  );
				
				// 로그인이 안되있으면 그냥 넥스트페이지 메인으로 이동
				operatorViewName = "nextpage/nomenu/04_nextPageLogIn/nextPageLogIn";
			}else {
				// 로그인이 되있다면 운영자페이지 인덱스로 넘어간다.
				operatorViewName = "operator/01_operatorIndex/operatorIndex";
			}
			
			log.debug( "Set operatorViewName : " + operatorViewName );
			session.setAttribute( "operatorViewName" , operatorViewName );
			
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
