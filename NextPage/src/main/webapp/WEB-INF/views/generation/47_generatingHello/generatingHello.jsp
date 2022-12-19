<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--
	작성자 : 최현우
	학교장인사말
 -->
 <style>

.contentArea{
    float: left;
    width: 800px;
    height: 501px;
    margin-top:60px;
    margin-left:20px;
}
.content {
	margin-left:0px;
    min-height: 1000px;
}
#mainArea{
    margin-top: 90px;
    margin-left : 20px;
	width: 90%; 
}
main{
	margin-top:10%;
}
#imgDiv{
    float: left;
    width: 45%;
    height: 45%;
    padding-top: 10%;
    padding-left: 4%;
}
#hello{
	margin-left : 30px;
}
</style>
<div id="mainArea">
	<h2 id="hello"><span style="border-bottom: 4px solid #51be78;">학교장인사말</span></h2>
	<div class="contentArea">
		<div id="imgDiv" class="content">
			<img src="<%=request.getContextPath()%>/resources/templatesPreview/images/sch/${hello.fileName}" alt="Image" class="img-fluid hello2" style="height: 220px;">
		</div>
		<div class="content">
			<div>${hello.cntnt}</div>
		</div>
	</div>
</div>
<main>
