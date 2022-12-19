package kr.or.ddit.nextpage.find.id.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.nextpage.find.id.service.NextPageFindIdService;
import kr.or.ddit.vo.SchoolVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping( value = "nextpage/findId.do" )
public class NextPageFindIdController {

	private final NextPageFindIdService service;
	

	@GetMapping
	public String nextPageFindId() {
		return "nextpage/nomenu/05_nextPageFindId/nextPageFindId";
	}
	
	
	
	 @PostMapping
	   public String NextPageFindIdsendEmail( 
			   @RequestParam(name="schNm")  String schNm,
			   @RequestParam(name="schEmail") String schEmail,
			   Model model,
			   HttpSession session
			   )
	        {
		 double random=Math.random();
         int rand=(int)(random*899999)+100000;
	      System.out.println("실행성공");
	      

	      
	      

	      System.out.println(schNm+"이름과 메일"+schEmail);
	      SchoolVO sch=new SchoolVO();
	      sch.setSchNm(schNm);
	      sch.setSchEmail(schEmail);
	      SchoolVO member=service.getSchInfo(sch);
	      
	     
	      
	      
	     
	      
	      
	      
	      
	      //if(a==null)
	      if(member!=null)
	      {
	      String host = "smtp.naver.com"; // SMTP 서비스를 해주는 메일 사이트
	      final String user = "mikmas0817@naver.com"; // SMTP 서비스로 사용할 메일
	      final String password =  "kghcomputer12!"; // 메일 비밀번호

	      String to = schEmail; // 송신 메일 수신할 이메일

	      // Get the session object
	      Properties props = new Properties();
	      props.put("mail.smtp.ssl.trust", "smtp.naver.com");
	      props.put("mail.smtp.starttls.enable", "true"); 
	      props.put("mail.smtp.host", host); // 이메일 발송을 처리해줄 SMTP 서버
	      props.put("mail.smtp.auth", "true"); // 설정한 이메일 SMTP서버에 접속할 수 있는 권한 취득

	      // 세션 : 클라이언트 별로 서버에 저장되는 정보 (
	      // 사용자 컴퓨터에 저장되던 쿠키와 다르게 서버에 저장되므로, 비교적 보안이 필요한 데이터는 쿠키보다 세션에 저장한다.
	      // 서버가 종료되거나 유효기간이 지나면 사라진다.
	      Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() { // 설정값을 저장하여 세션 생성
	         public javax.mail.PasswordAuthentication getPasswordAuthentication() {
	            return new javax.mail.PasswordAuthentication(user, password); // PASSWORD 인증
	         }
	      });

	      // Compose the message
	      try {
	         // 위에 설정한 내용을 가지고 mimeMessage클래스 생성
	         // 실질적인 메일 작성 클래스 ( 메일 제목, 내용 등등)
	         System.out.println("gg");
	         MimeMessage message = new MimeMessage(session1);
	         System.out.println("gg");
	         // 발신자 셋팅
	         message.setFrom(new InternetAddress(user)); // SMTP 발신자 이메일 주소

	         // 수신자 셋팅
	         // RecipientType = 받는사람 유형 (그룹, 사용자, 사서함, 폴더 등등)
	         // InternetAddress(받는사람 메일)
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Subject
	         // 메일 제목
	         message.setSubject("NextPage 아이디 찾기");
	         
	         
	         
	         // Text
	         // 메일 내용
	         message.setText("인증번호는 ["+rand+"]입니다."); // 텍스트 보내기
	         // message.setContent("<h1>html123123 콘텐츠입니다</h1>","text/html"); // html 형식으로
	         // 보내기
	         // message.setContent("안녕하세요. 당신의 비밀번호는 12341234","text/html"); // html 형식으로 보내기
	         // send the message
	         // 메일 전송
	         Transport.send(message);

	         // 전송완료 출력 메세지
	         System.out.println("메일 송신 완료");

	      } catch (MessagingException e) {
	         e.printStackTrace();
	         System.out.println(e.getMessage());
	      }

	      
	      session.setAttribute("findIdNumber", rand);
	      session.setAttribute("findIdNumberData", member.getSchId());
	      model.addAttribute("msg","이메일 전송에 성공하였습니다!");
	      model.addAttribute("url","/nextpage/findIdNumber.do");
	      return "schoolManager/106_teacherInsert/success";
	      }
	      else
	      {
	    	  model.addAttribute("msg","입력된 학교명, 이메일을 찾을 수 없습니다!");
		      model.addAttribute("url","/nextpage/findId.do");
	     	  return "schoolManager/106_teacherInsert/success";

	      }
	     
	   //}
	}
}
