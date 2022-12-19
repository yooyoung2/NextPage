<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.buttonStart{
    margin-left: 44%;
    border-radius: 25px;
    margin-right: 15px;
    white-space: normal;
    padding: 8px 16px;
    float: left;
    width: auto;
    border: none;
    display: block;
    outline: 0;
    background-color: #7796dd!important;
    color:white;
}
    .star {
        display: inline-block;
        position: absolute;
    }
</style>




<!-- <div id="wrap" onmousemove="xyCheck()"> -->
	<div class="container-fluid hero-header py-5 mb-5" style="background-color: ghostwhite; background-image: var(--bg-gradient);">
        <div class="container py-5" style="height: 530px;">
            <div>
                <div class="col-lg-12">
<!--                     <h1 class="display-4 mb-3 animated slideInDown">NEXTPAGE</h1> -->
					<h1 class="display-4 mb-3 animated slideInDown" style="text-align: center;">
						전문적인 학교홈페이지
						<br>
						만들기	
					</h1>
					<p style="text-align: center;">내가 원하는 방식으로 웹 존재를 생성, 디자인, 관리 및 개발할 수 있는 자유를 제공하는 플랫폼을 경험하세요.</p>
                    <a href="" class="buttonStart" style="margin-bottom: 2%;">시작하기</a>
                    
                    <img src="<%=request.getContextPath() %>/resources/templates/nextpage/img/main.png" style="height: 285px; margin-left: 20%;">
                    <br>
                    
                </div>

<!--                     <h1 class="display-4 mb-3 animated slideInDown">누구나 쉽고</h1>
                    <br>
                    <h1 class="display-4 mb-3 animated slideInDown">간편한</h1>
                    <br>
                    <h1 class="display-4 mb-3 animated slideInDown">학교 홈페이지 제작!</h1>
                    <h3 class="animated slideInDown">포토샵을 몰라도! 코드를 몰라도!</h3>
                    <h4 class="animated slideInDown">넥스트페이지에서 누구나 만들 수 있습니다!</h4> -->
<%--                 <div class="col-lg-6 animated fadeIn">
                    <img class="img-fluid animated pulse infinite" style="animation-duration: 3s; height: 500px;" src="<%=request.getContextPath() %>/resources/img/배경.jpg"
                        alt="">
                </div> --%>
            </div>
        </div>
    </div>

    <!-- Features Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <h1 class="display-6">Why Us!</h1>
                <p class="text-primary fs-5 mb-5" style="color: #999 !important;">Home page production industry's best</p>
            </div>
            <div class="row g-5">
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="d-flex align-items-start">
                        <img class="img-fluid flex-shrink-0" src="<%=request.getContextPath() %>/resources/templates/nextpage/img/item.gif" alt="" style="width:64px; height:64px;">
                        <div class="ps-4">
                            <h5 class="mb-3">쉬운 홈페이지 제작</h5>
                            <span>
                            	<li>프로그래밍을 몰라도 클릭만으로 홈페이지 제작 가능해요!</li>
                            	</span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="d-flex align-items-start">
                        <img class="img-fluid flex-shrink-0" src="<%=request.getContextPath() %>/resources/templates/nextpage/img/item2.gif" alt="" style="width:64px; height:64px;">
                        <div class="ps-4">
                            <h5 class="mb-3">언제든 자유자재로 변경 가능한 템플릿</h5>
                            <span>다양하게 꾸며보고 선택하세요!<br>
                           	<li>프로젝트를 임시저장 가능한 슬롯을 여러개 제공하고 있어요<br>
                           	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;최종 선택을 통하여 홈페이지 적용해보세요!
                           	</li>
                           	</span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="d-flex align-items-start">
                        <img class="img-fluid flex-shrink-0" src="<%=request.getContextPath() %>/resources/templates/nextpage/img/item3.gif" alt="" style="width:64px; height:64px;">
                        <div class="ps-4">
                            <h5 class="mb-3">다양한 위젯 레이아웃 제공</h5>
                            <span>
                            	위젯 구성도 변경 할 수 있다고?<br>
                            	<li>템플릿을 선택하고 <br>
                            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;다양한 레이아웃도 직접 선택해서 나만의 위젯 구성을 해보세요!
                            	</li>
                            	</span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s" style="margin-bottom: 7%;">
                    <div class="d-flex align-items-start">
                        <img class="img-fluid flex-shrink-0" src="<%=request.getContextPath() %>/resources/templates/nextpage/img/item4.gif" alt="" style="width:64px; height:64px;">
                        <div class="ps-4">
                            <h5 class="mb-3">나도 관리자</h5>
                            <span>
                            	<li>홈페이지 관리</li>
	                           	<li>메뉴 관리</li>
	                           	<li>기능 관리</li>
	                           	<li>게시판 관리,게시물 관리</li>
	                           	<li>콘텐츠 관리</li>
	                           	<li>회원 관리 등 다양한 기능을 제공합니다.</li>
	                           	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전문가의 도움없이도 직접 관리할 수 있어요!
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="d-flex align-items-start">
                        <img class="img-fluid flex-shrink-0" src="<%=request.getContextPath() %>/resources/templates/nextpage/img/item5.gif" alt="" style="width:64px; height:64px;">
                        <div class="ps-4">
                            <h5 class="mb-3">다양한 게시판 옵션 제공</h5>
                            <span>
                            	<li>게시판의 다양한 옵션과 <br>
                            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시판 별 여러가지 권한 설정을 할 수 있어 <br> 
                            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용도에 맞게 커스터 마이징이 가능한 게시판! 
                            	</li>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="d-flex align-items-start">
                        <img class="img-fluid flex-shrink-0" src="<%=request.getContextPath() %>/resources/templates/nextpage/img/item6.gif" alt="" style="width:64px; height:64px;">
                        <div class="ps-4">
                            <h5 class="mb-3">1:1문의를 통한 실시간 지원</h5>
                            <span>
                            <li>홈페이지중 불편함이 있나요?</li>
                            <li>예상치 못한 오류가 있나요?</li>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1:1 문의를 통하여 편하게 물어보세요!
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Features End -->
<!-- </div> -->

<script>
	/* var da = new Date("2022-12-01").toISOString();
	console.log(da);  */

  (function() {
    var w = window;
    if (w.ChannelIO) {
      return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
    }
    var ch = function() {
      ch.c(arguments);
    };
    ch.q = [];
    ch.c = function(args) {
      ch.q.push(args);
    };
    w.ChannelIO = ch;
    function l() {
      if (w.ChannelIOInitialized) {
        return;
      }
      w.ChannelIOInitialized = true;
      var s = document.createElement('script');
      s.type = 'text/javascript';
      s.async = true;
      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
      s.charset = 'UTF-8';
      var x = document.getElementsByTagName('script')[0];
      x.parentNode.insertBefore(s, x);
    }
    if (document.readyState === 'complete') {
      l();
    } else if (window.attachEvent) {
      window.attachEvent('onload', l);
    } else {
      window.addEventListener('DOMContentLoaded', l, false);
      window.addEventListener('load', l, false);
    }
  })();
  ChannelIO('boot', {
    "pluginKey": "df08023b-4dec-48d9-b085-5701de499daf"
  });
 /*  var my_message = "**** NEXT 페이지에 오신 것을 환영합니다 ****";
  var colors = function(){
	  return "rgb(" + Math.floor(Math.random()*256) + ","
	                + Math.floor(Math.random()*256) + ","
	                + Math.floor(Math.random()*256) + ")";
  } 
  my_message = my_message.split("");
  var xpos = [];
  var ypos = [];
  var xdist = 30;   // 글자 사이 간격!
  var x,y;
  for(var i=0; i< my_message.length; i++){
      xpos[i] = -100;
      ypos[i] = -100;
  }

  var wrapDiv = document.getElementById("wrap");
  var strDiv;
  for(var i=0; i< my_message.length; i++){
      strDiv = "<div id=silver" + i + " class=star >";
      strDiv += my_message[i] + "</div>";
      wrapDiv.innerHTML += strDiv;
  }
  
  function xyCheck(){
      x= event.clientX;
      y= event.clientY;
      console.log("merong",x,y);
  }

  function mvMouse(){

      xpos[0] = x + xdist;
      ypos[0] = y;


      for(var i=(my_message.length-1); i>=1; i--){
          xpos[i] = xpos[i-1]+xdist;
          ypos[i] = ypos[i-1];
          console.log("x="+ xpos[i]+" y="+ ypos[i]);
      }

      for(var i=0;i<my_message.length; i++){
          var silver= document.getElementById("silver"+i);
          silver.style.left = xpos[i]+"px";
          silver.style.top = ypos[i]+"px";
          silver.style.color = colors();
          silver.style.fontSize = "2em";
         /*  silver.style.fontSize = Math.floor(Math.random()*5+1) + "em"; 
      }
      setTimeout(mvMouse,30);
  }
window.onload = mvMouse;
 */
</script>
<!-- End Channel Plugin -->

