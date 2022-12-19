<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <!-- JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/templates/nextpage/lib/wow/wow.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/templates/nextpage/lib/easing/easing.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/templates/nextpage/lib/waypoints/waypoints.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/templates/nextpage/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/templates/nextpage/lib/counterup/counterup.min.js"></script>

    <!-- Template Javascript -->
    <script src="<%=request.getContextPath() %>/resources/templates/nextpage/js/main.js"></script>

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
// 		alert(message.data);
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


















