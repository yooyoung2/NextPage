package kr.or.ddit.common.socket;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import kr.or.ddit.vo.NpMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class webSocketPushMessageHandler extends TextWebSocketHandler {

	// 로그인 인원전체
	private static Set<WebSocketSession> users = Collections.synchronizedSet(new HashSet<WebSocketSession>());

	// 관리자 인원전체
	private static Set<WebSocketSession> userMngt = Collections.synchronizedSet(new HashSet<WebSocketSession>());

	// 1:1로 할 경우
	private Map<String, WebSocketSession> userSessionsMap = new HashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		Map<String, Object> httpSession = session.getAttributes();
		NpMemberVO loginUser = (NpMemberVO) httpSession.get("npMember");
		log.info("메세지를 보낸아디능??? {}", loginUser);

		String memAuth=loginUser.getMemAuth();
		String memId =loginUser.getNpMemId();
		if (loginUser != null) {
			// 관리자 권한구별
			if (memAuth.equals("ADMIN")) {
				// 관리자...
				userMngt.add(session);
				userSessionsMap.put(memId,session);
				log.debug("관리자set에 담긴값 : {}", userMngt);
			} else {
				// 일반사용자..
				users.add(session);
				userSessionsMap.put(memId,session);
				log.debug("일반set에 담긴값 : {}", users);
			}
		}

//		log.info("현재접속한 사람은?"+currentUserName(session));//현재 접속한 사람
//		String senderId = currentUserName(session);
//		userSessionsMap.put(senderId,session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		String msg = message.getPayload();
		log.info("들아와" + msg);
		if (StringUtils.isNotEmpty(msg)) {
			log.info("if문 들어옴?");
			String[] strs = msg.split(",");
			if (strs != null) {

				String replyWriter = strs[0];
				String bno = strs[1];
				String boardWriter = strs[2];

				log.info("length 성공?" + bno);
				log.info("length 성공?" + replyWriter);
				log.info("length 성공?" + boardWriter);

				// 댓글작성자에게
//				@SuppressWarnings("unused")
				WebSocketSession replyWriterSession = userSessionsMap.get(replyWriter);
				// 글작성자에게
				WebSocketSession boardWriterSession = userSessionsMap.get(boardWriter);

				// 나 자신에게 보낼경우
				// session.sendMessage(new TextMessage("님이 " + "댓글을 달았습니다!"));

				// 댓글을 단 사람이 운영자가 아니라면...
				if (!boardWriter.equals(replyWriter)&&boardWriterSession.isOpen()) {

//					synchronized (users) {
					log.info("답변등록중!@!@!");
//							for (WebSocketSession user : users) {
					TextMessage tmpMsg = new TextMessage(replyWriter + "님이 " + bno + "번 글에" + "답변 등록했습니다!");
					log.info("누구세요1111" + boardWriterSession);
//									user.sendMessage(tmpMsg);
						boardWriterSession.sendMessage(tmpMsg);

//							}
//						}

				} else {
					log.info("여기까지는 드루와?11");
//					synchronized (userMngt) {

					log.info("여기까지는 드루와?22");
					for (WebSocketSession user : userMngt) {
						log.info("누구세요2222" + user);

//					Map<String, Object> httpSession = user.getAttributes();
//					NpMemberVO loginUser = (NpMemberVO)httpSession.get("npMember");
//					log.info("관리자 아디능??? {}", loginUser);

						TextMessage tmpMsg = new TextMessage(replyWriter + "님이 " + "문의를 등록했습니다!");
						if (user.isOpen()) {
							user.sendMessage(tmpMsg);
						}

					}
//					}

				}

//				log.info("boardWirterSession"+boardWriterSession);

				// 댓글
//				if (loginUser.) {
//					log.info("onmessage되나?");
//					TextMessage tmpMsg = new TextMessage(replyWriter + "님이 "
//							+ "<a href='/board/readView?bno="+ bno +"&bgno="+bgno+"'  style=\"color: black\">"
//							+ title+" 에 댓글을 달았습니다!</a>");
//					boardWriterSession.sendMessage(tmpMsg);
//				TextMessage tmpMsg = new TextMessage(bno + "번 글에" + replyWriter + "님이 " + "댓글을 달았습니다!");
//				session.sendMessage(tmpMsg);
//
//			}

//	    TextMessage tmpMsg = new TextMessage(msg + "님이 "+ "댓글을 달았습니다!");
//	    session.sendMessage(tmpMsg);
//

				// 로그인한 사용자에게 보낼경우..

			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug(session.getId() + " 연결 종료됨");
		users.remove(session);
		userMngt.remove(session);
	}

}
