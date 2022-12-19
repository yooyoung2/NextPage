package kr.or.ddit.operator.history.stastics.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import kr.or.ddit.operator.history.stastics.dao.VisitLogDAO;
import kr.or.ddit.operator.history.stastics.dao.VisitLogDAOImpl;
import kr.or.ddit.vo.VisitLogVO;

public class VisitCounter implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		VisitLogDAO dao = new VisitLogDAOImpl();

		HttpSession session = se.getSession();
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(session.getServletContext());
		// 등록되어있는 빈을 사용할수 있도록 설정

		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		// request를 파라미터에 넣지 않고도 사용할수 있도록 설정

		VisitLogVO vo = new VisitLogVO();
		try {
			InetAddress ipAddress = InetAddress.getLocalHost();
			vo.setVisit_ip(ipAddress.getHostAddress());
			vo.setVisit_agent(req.getHeader("User-Agent")); // 브라우저 정보
			vo.setVisit_refer(req.getHeader("refer")); // 접속 전 사이트 정보

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("IP : " + vo.getVisit_id());
		System.out.println("BROWSER : " + vo.getVisit_agent());
		System.out.println("BEFORE : " + vo.getVisit_refer());

		dao.insertVisitor(vo);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
