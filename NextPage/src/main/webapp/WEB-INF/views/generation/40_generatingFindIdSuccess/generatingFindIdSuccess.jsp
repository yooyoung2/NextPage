<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="site-section">
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-5">
				<div class="row">
					<div class="col-md-12 form-group">
						<label for="fname">ID</label> <input type="text" id="sucsId"
							placeholder="아이디는입니다.">
					</div>
					<div class="row">
						<div class="col-12">
							<a
								href="<%=request.getContextPath()%>/generation/generatingFindPassword"
								class="btn btn-primary btn-lg px-5">비밀번호찾기</a> <a
								href="<%=request.getContextPath()%>/generation/generatingLogin"
								class="btn btn-primary btn-lg px-5" style="float: right;">로그인</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>	