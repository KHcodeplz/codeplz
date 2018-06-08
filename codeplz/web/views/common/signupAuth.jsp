<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String auth_key = "asdf";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>코드좀: 이메일 인증</title>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
	</head>
	<body>
		
		<script>
			$(document).ready(function () { // document가 다 받아지면 실행 가능
				/* $('#signup_auth_user_id').attr('readonly','true'); */
				$('#signup_send_auth').on('click', function() {
					
					alert($('#signup_auth_user_id').val());
					
					$.ajax({
						data: {
							to_email : $('#signup_auth_user_id').val()
						},
						url: "/codeplz/signup_auth_send.cp",
						
						success: function (data) {
							if (data) { // 이메일 전송 성공, session에 저장되어있음.
								alert("이메일 전송 성공!");
								$('#signup_auth_input').focus();
							} else { // 이메일 전송 실패
								alert("이메일 전송 에러!");
							}
						}
					});
				});
				
				$('#signup_auth_submit').on('click', function () {
					$.ajax({
						data: {
							input: $('#signup_auth_input').val()
						},
						url: "/codeplz/signup_auth_check.cp",
						success: function (data) {
							if (data) {
								alert("일치!");
								opener.signup_id_auth_check = true;
								$(opener.document).find("#signup_user_id_auth_btn").attr("disabled","disabled");
								opener.document.getElementById('signup_user_password').focus();
								window.close();
							} else {
								alert("불일치");
							}
						}
					});
				});
	        });
			
		</script>
		<div class="wrapper">
						
			<div style="margin: 20px;">
				<p class="text-center">코드좀: 이메일 인증</p>
				<div class="control-group">
					<label class="control-label" for="signup_auth_user_id">ID:</label>
					<div class="controls">
						<input type="email" class="form-control input-medium" id="signup_auth_user_id" required>
						<br />
						<button type="button" class="btn btn-warning" id="signup_send_auth" style="float: right;">인증메일 전송</button>
					</div>
				</div>
				<form class="form-horizontal">
					<br />
					<br />
					<!-- Password input-->
					<div class="control-group">
						<label class="control-label" for="signup_auth_key">인증번호:</label>
						<div class="controls">
							<input type="text" class="form-control input-medium" id="signup_auth_input" placeholder="이메일을 확인하고 인증키를 입력해주세요." required>
							<br />
							<button type="button" class="btn btn-success pull-right" id="signup_auth_submit" onclick="">인증</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
	
	<script>
		$(function () {
			$('#signup_auth_user_id').attr('readonly','true');
		});
	</script>
</html>