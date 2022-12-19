<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<link rel="stylesheet" type="text/css"
	href="https://vendor-cdn.imweb.me/css/black-tie.css?1608189400">

<link rel="stylesheet" type="text/css"
	href="https://vendor-cdn.imweb.me/css/simple-line-icons.css?1608179394">

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/nextPageServuceIntro.css">

<style>
#section1{
	width:100%;
    padding-top: 56px;
}
.page-header{
	margin-left: -16%;
}
#image{
margin-left: 16%;
}
#second{
	margin-top: 10%;
	margin-left: -10%;
}
.row {
    margin-right: -20px;
    margin-left: -20px;
    width: 90%;
</style>

	<section id="section1">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header multi-line">
						<h3>손 쉬운 디자인</h3>
						<h5 class="text-gray">
							코딩을 몰라도 사이트를 만들 수 있는 비결은 넥스트페이지 덕분입니다.<br class="hidden-xs">
							내가 배치하고 꾸민 그대로 방문자들이 볼 수 있도록 사이트 제작자가 최대한 덜<br class="hidden-xs">
							신경쓰게끔 설계되었습니다. 더욱 직관적이고, 더욱 효율적이도록 말이죠.
						</h5>
					</div>
				</div>
			</div>
		</div>
		<div id="middleCont" class="container">
			<div class="row margin-bottom-xxxxxl">
				<div id="image" class="col-md-6 hidden-sm" style="float: left">
					<img alt="레이아웃" src="/NextPage/resources/img/서비스.jpg" width="600px;">
				</div>
				<div id="second" class="page-header multi-line">
					<h3>레이아웃을 뒷받침하는 간편한 기능들!</h3>
					<h5 class="text-gray">
						넥스트페이지에서는 pixel 단위로 세밀하게 조정하지 않아도 됩니다.<br class="hidden-xs"> 그래서
						사이트 본연의 목적인 콘텐츠 제작에 더 많은 일을 할 수 있습니다.<br class="hidden-xs"> 이
						모든 것이 넥스트페이지 덕분에 가능한 것이지요.
					</h5>

				</div>
			</div>
			<div id="row" class="row">
				<div class="col-md-4 col-description-sm">
					<div class="icon-36 text-primary margin-bottom-xxxl">
						<i class="btl bt-copy"></i>
					</div>
					<h4>드래그 앤 드롭</h4>
					<p class="text-gray">포토샵, 워드, 프레젠테이션 도구보다 더 쉽게 작업한 결과물 그대로
						방문객에게 보여집니다. 드래그 앤 드롭으로 이동하고 필요한 기능을 원하는 곳에 추가하세요.</p>
				</div>
				<div class="col-md-4 col-description-sm">
					<div class="icon-36 text-primary margin-bottom-xxxl">
						<i class="btl bt-magic"></i>
					</div>
					<h4>다양한 디자인</h4>
					<p class="text-gray">보통 사람들도 간단히 훌륭한 웹사이트를 만들 수 있지만, 디자이너의 실력만큼
						더 아름답게 만들 수 있도록 설계되었죠. Script를 몰라도 훌륭한 효과들을 뽐낼 수 있습니다.</p>
				</div>
				<div class="col-md-4 col-description-sm">
					<div class="icon-36 text-primary margin-bottom-xxxl">
						<i class="btl bt-sync"></i>
					</div>
					<h4>최대한 알아서</h4>
					<p class="text-gray">넥스트페이지의 철학은 사용자가 세밀하게 신경쓰지 않고도 원하는 결과물을 낼 수
						있도록 하는 것입니다. 불필요하거나 반복된 설정을 최대한 줄이면서 생산성과 품질을 높혔습니다.</p>
				</div>
			</div>
		</div>
	</section>
	<section class="section-event">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center margin-bottom-xxxxxl">
					<h3 class="no-margin-top">넥스트페이지 공식제휴사</h3>
					<h5 class="opacity-60">넥스트페이지는페이팔, KG이니시스, 네이버, KCP, 나이스페이,
						이지페이, 엑심베이 공식파트너입니다.</h5>
				</div>
				<div class="text-center">
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="naver"
								src="https://vendor-cdn.imweb.me/images/main/naver_bi_100.png"
								width="100" alt="네이버">
						</div>
					</div>
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="naver_pay"
								src="https://vendor-cdn.imweb.me/images/main/npay_bi_logo_bg_transparent.png"
								width="88" alt="네이버페이">
						</div>
					</div>
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="metapartner"
								src="https://vendor-cdn.imweb.me/images/main/mbp_logo.png?v3"
								width="164" alt="Meta Business Partners">
						</div>
					</div>
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="naver"
								src="https://vendor-cdn.imweb.me/images/main/kakao_ci_90.png"
								width="90" alt="카카오">
						</div>
					</div>
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="channel"
								src="https://vendor-cdn.imweb.me/images/main/kakaopay_140.png"
								width="140" alt="카카오페이">
						</div>
					</div>
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="awspartner"
								src="https://vendor-cdn.imweb.me/images/main/aws_bi_logo_bg_transparent.png"
								width="136" alt="AWS">
						</div>
					</div>
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="channel"
								src="https://vendor-cdn.imweb.me/images/main/channel_129.png"
								width="129" alt="채널톡">
						</div>
					</div>
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="kcp"
								src="https://vendor-cdn.imweb.me/images/main/kcp_120.png"
								width="120" alt="NHN KCP">
						</div>
					</div>
					<!--
				<div class="text-center footer-logo">
					<a  class="blocked section-event-link" href="/pg_event">
						<img class="payco_logo" src="https://vendor-cdn.imweb.me/images/main/payco_logo_footer.png" width="84">
					</a>
				</div>
				-->
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="acecounter_logo"
								src="https://vendor-cdn.imweb.me/images/main/easywinner_bi.png"
								width="150" alt="이지위너">
						</div>
					</div>
					<div class="text-center footer-logo">
						<div class="blocked section-event-link">
							<img class="acecounter_logo"
								src="https://vendor-cdn.imweb.me/images/main/acecounter_logo.png"
								width="155" alt="에이스카운터">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="palyauto_logo"
								src="https://vendor-cdn.imweb.me/images/main/playauto_logo.png"
								width="147" alt="플레이오토">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="eximbay_logo"
								src="https://vendor-cdn.imweb.me/images/main/eximbay-logo.svg"
								width="172" alt="엑심베이">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="paypal"
								src="https://vendor-cdn.imweb.me/images/main/paypal_122.png"
								width="122" alt="Paypal">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="kg_inicis"
								src="https://vendor-cdn.imweb.me/images/main/ini_bi_logo_bg_transparent.png"
								width="105" alt="KG이니시스">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="eximbay_logo"
								src="https://vendor-cdn.imweb.me/images/main/fassto_146.png"
								width="146" alt="파스토">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="kg_inicis"
								src="https://vendor-cdn.imweb.me/images/main/goodsflow_94.png"
								width="94" alt="굿스플로">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="sabangnet_logo"
								src="https://vendor-cdn.imweb.me/images/main/sabangnet_184.png"
								width="184" alt="사방넷">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="eximbay_logo"
								src="https://vendor-cdn.imweb.me/images/main/logo-sellmate.png"
								width="140" alt="셀메이트" style="margin-top: -3px;">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="ecpay_logo"
								src="https://vendor-cdn.imweb.me/images/main/ecpay_106.png"
								width="106" alt="ECPay">
						</div>
					</div>
					<div class="text-center footer-logo footer_logo_second">
						<div class="blocked section-event-link">
							<img class="nicepay_logo"
								src="https://vendor-cdn.imweb.me/images/main/nicepay_logo.png"
								width="128" alt="나이스페이">
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>


