<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">

var onloadCallback = function() {
	 grecaptcha.render('html_element', {
         'sitekey' : '6LfHAjYhAAAAAMM7-4vT_pWOV7Gzgc7S0WDYMGDB'
       });
  };

  var isCapchaSuccess=false;
  function successCaptcha()
  {
     isCapchaSuccess=true;  
  }
  function writeOK()
  {
     if(!isCapchaSuccess)
        {
        alert('자동가입방지를 위해 reCaptcha를 확인해주세요');
        return false;
        }
     else
        {
        alert("검증이 완료되었습니다.");
        location.href="<%=request.getContextPath()%>/startbootstrap-agency-gh-pages/login/signIn.jsp";
		}
		;

	};
</script>
<script
	src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
	async defer></script>
</head>
<body id="page-top">
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">자동가입방지 확인</h4>

				<div id="html_element" data-callback="successCaptcha"></div>
				<button type="submit"
					class="btn btn-primary btn-lg btn-block btn-signin-btn"
					onclick="javascript:writeOK();">제출</button>
			</div>
		</div>
	</div>
</body>
<script>
	
</script>
</html>
