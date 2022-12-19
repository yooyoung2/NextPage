
package kr.or.ddit.generation.website.find.Id.controller;

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

import kr.or.ddit.generation.website.find.Id.service.GeneratingFindIdService;
import kr.or.ddit.vo.SchMemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "generation/{id}/find/pw")
public class GeneratingFindPasswordController {

	private final GeneratingFindIdService service;

	@GetMapping
	public String nextPageFindPw(
				HttpSession session
			) {

		log.debug( "GeneratingFindPasswordController - nextPageFindPw() [ACTIVATED]" );
		
		String templateId = (String) session.getAttribute( "templateId" );
		/*String viewName = (String) session.getAttribute( "rtrnJsp" ); // return jsp경로*/	
		
		String viewName = "";
		
		if( templateId != null ) {
			if( templateId.equals( "TMPLT001" ) ) {
				templateId = "template01";
			}else if( templateId.equals( "TMPLT002" ) ) {
				templateId = "template02";
			}
			viewName = "generation/" + templateId + "/nomenu/41_generatingFindPassword/generatingFindPw";
		}else {
			log.debug( "templateId is NULL" );
		}
		
		log.debug( "templateId : {}", templateId );
		log.debug( "viewName : {}", viewName );
		
		
		log.debug( "GeneratingFindPasswordController - nextPageFindPw() [DEACTIVATED]" );
		
		return viewName;
	}

	@PostMapping
	public String NextPageFindIdsendEmail(@RequestParam(name = "memId") String memId,
			@RequestParam(name = "memEmail") String memEmail, Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		System.out.println("실행성공");
		double random = Math.random();
		int rand = (int) (random * 899999) + 100000;
		String Pw = null;

		System.out.println(memId + " 이름과 메일 " + memEmail);
		SchMemberVO sch = new SchMemberVO();
		sch.setMemId(memId);
		sch.setMemEmail(memEmail);
		SchMemberVO member = service.getSchInfoPw(sch);

		System.out.println("왜그럴까");

		// if(a==null)
		if (member != null) {
			String host = "smtp.naver.com"; // SMTP 서비스를 해주는 메일 사이트
			final String user = "mikmas0817@naver.com"; // SMTP 서비스로 사용할 메일
			final String password = "kghcomputer12!"; // 메일 비밀번호

			String to = memEmail; // 송신 메일 수신할 이메일

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
				message.setSubject("제네레이션  비밀번호 찾기 메일입니다!");

				String[] str = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
						"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
				double random2 = Math.random();
				int rand2 = (int) (random2 * 26);
				String a = str[rand2];
				double random3 = Math.random();
				int rand3 = (int) (random3 * 26);
				String b = str[rand3];
				double random4 = Math.random();
				int rand4 = (int) (random4 * 26);
				String c = str[rand4];
				int divideRandom1 = rand / 1000;
				int divideRandom2 = rand % 1000;
				// Text
				// 메일 내용
				Pw = a + divideRandom1 + b + divideRandom2 + c;

				SchMemberVO updateMember = new SchMemberVO();
				updateMember.setMemPw(Pw);
				updateMember.setMemId(memId);

				int update = service.schPwUpdate(updateMember);
				message.setText("임시 비밀번호는 [" + Pw + "]입니다. "); // 텍스트 보내기
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

			session.setAttribute("findIdNumber", Pw);
			model.addAttribute("msg", "이메일 전송에 성공하였습니다! 마이페이지에서 임시 비밀번호를 바꿔주세요!");
			model.addAttribute("url", "/generation/" + id + "/login");
			return "schoolManager/106_teacherInsert/success";
		}

		model.addAttribute("msg", "입력된 학교아이디, 이메일을 찾을 수 없습니다!");
		model.addAttribute("url", "/generation/" + id + "/find/pw");
		return "schoolManager/106_teacherInsert/success";

		// }
	}
}
