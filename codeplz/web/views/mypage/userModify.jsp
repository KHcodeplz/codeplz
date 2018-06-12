<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<title>코드좀-회원정보변경</title>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<%@ include file="../common/header.jsp" %>
		
		<%
			boolean modify_Check = (boolean) session.getAttribute("modify_Check");
		%>
		
		<% if (modify_Check) { %>
			<div class="bs-example bs-example-tabs">
				<ul id="modifyTab" class="nav nav-tabs">
					<li class="active"><a href="#user_info" id="tab_user_info" data-toggle="tab" role="tab">내 정보</a></li>
					<li class=""><a href="#user_dropOut" id="tab_dropOut" data-toggle="tab" role="tab">회원탈퇴</a></li>
				</ul>
			</div>
			<div id="modifyTabContent" class="tab-content">
				<div class="tab-pane fade active in" id="user_info">
					<form class="form-horizontal" id="user_info_form">
						<fieldset>
							<div class="control-group">
								<label class="control-label" for="id_for_modify">ID:</label>
								<div class="controls">
									<input type="text" class="form-control input-small" id="id_for_modify" value="<%=user.getUser_id()%>" disabled>
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="nickname_for_modify">Nickname:</label>
								<div class="controls">
									<input type="text" class="form-control input-small" id="nickname_for_modify" value="<%=user.getUser_nickname()%>" disabled>
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="name_for_modify">Name:</label>
								<div class="controls">
									<input type="text" class="form-control input-small" id="name_for_modify" name="name_for_modify" value="<%=user.getUser_name()%>">
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="password_for_modify">Password For Modify:</label>
								<div class="controls">
									<input type="password" class="form-control input-small" id="password_for_modify" name="password_for_modify" placeholder="********">
									<div id="password_for_modify_message" style="display: none;"></div>
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="password2_for_modify">Re-Enter Password For Modify:</label>
								<div class="controls">
									<input type="password" class="form-control input-small" id="password2_for_modify" name="password2_for_modify" placeholder="********">
									<div id="password2_for_modify_message" style="display: none;"></div>
								</div>
							</div>
							
							<br />
				            <!-- Button -->
							<div class="control-group">
								<label class="control-label" for="user_info_modify_submit"></label>
								<div class="controls">
									<button type="button" class="btn btn-success pull-right" id="user_info_modify_submit">Modify</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<div class="tab-pane fade" id="user_dropOut">
					<form class="form-horizontal" id="dropout-form">
						<div class="controls">
							<br />
							<p>정말로 탈퇴하시겠습니까? 삭제하시면 다시는 되돌릴 수 없습니다.</p>
							<button type="button" class="btn btn-success pull-right" id="user_dropout_submit">Drop Out</button>
							<br />
						</div>
					</form>
				</div>
			</div>
						
		<% } else { %>
		<p>비밀번호 확인</p>
		<form class="form-horizontal" id="form_password_check_for_modify" action="/codeplz/user_password_check.cp" method="post">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="password_for_check">Password:</label>
					<div class="controls">
						<input type="password" class="form-control input-small" id="password_for_check" name="password_for_check" placeholder="********" required>
					</div>
				</div>
				<br />
	            <!-- Button -->
				<div class="control-group">
					<label class="control-label" for="signin-btn"></label>
					<div class="controls">
						<button type="button" class="btn btn-success pull-right" id="password_submit">Check</button>
					</div>
				</div>
			</fieldset>
		</form>
		<% } %>
		
		<%@ include file="../common/footer.jsp" %>