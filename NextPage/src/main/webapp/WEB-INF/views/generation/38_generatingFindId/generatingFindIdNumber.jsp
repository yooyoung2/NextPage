<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String session2=(String)session.getAttribute("id");
%>

<style>
form{
	margin-left : 20%;
}
#h2Tag{
	margin-left : 15%;
	margin-top:15%;
	margin-bottom:10%;
	color:#6E6E6E;
}
#pTag{
	margin-left:10%;
}
#subBtn{
    width: 162px;
    margin-left: 17%;
    margin-top:5%;
}
.form-control{
	width : 370px;
	margin-left: -11%;
}
label{
    margin-left: -11%;
	color:#6E6E6E;
}
#outline{
    border-radius: 10px;
    border: 2px solid #BDBDBD;
	padding-right : 8%;
	margin-top:5%;
}
input{
	border-color:#6E6E6E;
}

p {
    margin-left: -40px;
}
</style>


<div class="container">

	<div class="row justify-content-center">
		<div id="outline" class="col-md-5">
			
		<h2 id="h2Tag" class="row align-items-end justify-content-center text-center">아이디찾기</h2>

					
				<div class="row">
			<form action="number" method="post">
				<div class="col-md-12 form-group">
					<label id="text" class="form-label" for="inputAuthentication" >인증번호 : &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </label> 
					<label id="test" class="form-label" for="inputAuthentication" style="color:red;">3:00</label>
					<input type="text" name="number" class="form-control form-control-lg" placeholder="인증번호 입력">
					<p>※ 이메일로 전송 된 인증번호를 입력해주세요</p>
				</div>
				<div class="col-md-12 form-group">
					<button id="subBtn"  type="submit" class="btn btn-primary btn-lg px-3">확인</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</div>



<script>
    var i=2;
    var j=60;
    var timer1 = setInterval(function(){
    	if(j==0)
    		{
    		
    		if(i==0)
    			{
    				alert("인증시간이 초과하였습니다!");
    				location.href='<%=request.getContextPath()%>/nextpage/findId.do'
    				
    				
    				j=0;
    				i=0;
    			}
    		else{
    			i--;
        		j=60;
    		}
    		}
    	j--;
        $("#test").html(""+i+":"+j);
        if(j<10)
        	$("#test").html(""+i+":0"+j);
        
       
    }, 1000)
    </script>
		
		