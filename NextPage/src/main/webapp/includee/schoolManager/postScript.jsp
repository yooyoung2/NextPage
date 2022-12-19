<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath()%>/resources/templates/operator/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>


	<%-- 부트스트랩 경고메시지 때문에 부스트스탭 최신버전 삽입 --%>
	<%-- <script src="<%=request.getContextPath()%>/resources/templates/operator/assets/js/bootstrap.bundle.min.js"></script> --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<%--     <script src="<%=request.getContextPath()%>/resources/templates/operator/assets/vendors/apexcharts/apexcharts.js"></script> --%>
    <script src="<%=request.getContextPath()%>/resources/templates/operator/assets/js/pages/dashboard.js"></script>

    <script src="<%=request.getContextPath()%>/resources/templates/operator/assets/js/main.js"></script>


<!-- 실시간알림 -->
<script type="text/javascript" defer="defer">



	//소켓연결시작
	let webSocket = null;

	$(document).ready(function() {

		//var url = 'ws://' + window.location.host + '${pageContext.request.contextPath}/usersServerEndpoint';
// 		var url = 'ws://localhost:81/NextPage/alram';
		var url = 'ws://192.168.143.14/NextPage/alram';

		webSocket = connection(url);
		webSocket.onopen = function(){ processOpen(); };
		webSocket.onmessage = function(message) { processMessage(message); };
		webSocket.onerror = function(message) { processError(message); };

	});


	function connection(url) {
		var webSocket = null;
		if ('WebSocket' in window) {
			webSocket = new WebSocket(url);
		} else if ('MozWebSocket' in window) {
			webSocket = new MozWebSocket(url);
		} else {
			Console.log('Error: WebSocket is not supported by this browser.');
	        return null;
		}
		return webSocket;
	}

	function processOpen() {
		connectionType = "firstConnection";
		console.log("소켓연결성공!!");
		//username = "${loginVO.name}";
		//webSocket.send(JSON.stringify({ "connectionType" : connectionType, "username" : username }));
	}

	//server에서 메시지가 넘어왔을때
	function processMessage(message) {
		console.log("메세지전송성공!!");
		toastr.success(JSON.stringify(message.data));
		console.log("processMessage : ", message);
// 		webSocket.close();
	}

	function processError(message) {
		/* messagesTextArea.value += "error...\n"; */
		console.log("processError : ", message);
	}

	window.onbeforeunload = function() {
		webSocket.close();
	};



</script>







