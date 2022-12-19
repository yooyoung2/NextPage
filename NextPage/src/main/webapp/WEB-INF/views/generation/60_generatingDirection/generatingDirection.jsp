<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
  />
<style>

dl{
	margin:20px;

}
</style>
<br>
	<div class="container">
	<div  class="row-content m-5">
		<h2><span style="border-bottom: 4px solid #51be78;">오시는 길</span></h2>
	</div>
		<div class="row justify-content-center">
			${map.drctnUrl}
		</div>

		<div class="m-5">
			<ul>
				<li class="fa-solid fa-location-dot">&nbsp;주소
					<dl >
						<dd>(${footer.schPostNum}) ${footer.schAddr1 } ${footer.schAddr2 }</dd>
					</dl>
				</li>
				<br>
				<li class="fa-solid fa-phone ">&nbsp;전화번호
					<dl>
						<dd>${footer.schTelNum}</dd>
					</dl>

				</li>
			</ul>

		</div>
	</div>
