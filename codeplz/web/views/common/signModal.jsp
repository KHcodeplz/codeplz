<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="modal fade bs-modal-md zzzz" id="signmodal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" aria-expanded="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<br>
			<div class="bs-example bs-example-tabs">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#signin" id="tab_signin" data-toggle="tab" role="tab">Sign In</a></li>
					<li class=""><a href="#signup" id="tab_signup" data-toggle="tab" role="tab">Sign Up</a></li>
				</ul>
			</div>
			<div class="modal-body">
				<div id="myTabContent" class="tab-content">
					<!-- sign In div -->
					<div class="tab-pane fade active in" id="signin">
						<form class="form-horizontal" id="signin_form" action="/codeplz/signin.cp" method="post">
							<fieldset>
								<!-- Text input-->
								<div class="control-group">
									<label class="control-label" for="signin_user_id">ID:</label>
									<div class="controls">
										<input type="email" class="form-control input-medium" id="signin_user_id" name="user_id" placeholder="codeplz@example.com" required>
									</div>
								</div>
								<br />
								<!-- Password input-->
								<div class="control-group">
									<label class="control-label" for="signin_user_password">Password:</label>
									<div class="controls">
										<input type="password" class="form-control input-medium" id="signin_user_password" name="user_password" placeholder="********" required>
									</div>
								</div>
								<br />
								<!-- Multiple Checkboxes (inline) -->
								<div class="control-group">
									<div class="controls">
										<label class="checkbox inline" for="remember_me">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="checkbox" id="remember_me" name="remember_me" value="Remember me">Remember me
					                	</label>
									</div>
								</div>
								<br />
					            <!-- Button -->
								<div class="control-group">
									<label class="control-label" for="signin-btn"></label>
									<div class="controls">
										<button type="button" class="btn btn-success pull-right" id="signin-btn" name="signin-btn">Sign In</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div><!-- signIn end -->
					
					<!-- sign Up div -->
					<div class="tab-pane fade" id="signup" >
						<form class="form-horizontal" id="signup_form" action="/codeplz/signup.cp" method="post">
							<fieldset>
								<!-- ID input : user_id -->
								<div class="control-group">
									<label class="control-label" for="signup_user_id">ID:</label><p></p>
									<div class="controls">
										<input type="email" class="form-control input-large" id="signup_user_id" name="user_id" placeholder="codeplz@example.com" required>
										<br />
										<button type="button" class="btn btn-success" id="signup_user_id_auth_btn" style="display: none; float: right;">이메일 인증</button><div id="signup_user_id_message" style="display: none;"></div>
									</div>
								</div>
								<br />
								
								<!-- Password input : user_password -->
								<div class="control-group">
									<label class="control-label" for="signup_user_password">Password:</label>
									<div class="controls">
										<input type="password" class="form-control input-large" id="signup_user_password" name="user_password" placeholder="********" required>
										<div id="signup_user_password_message" style="display: none;"></div>
									</div>
								</div>
								<br />
								
								<!-- Re Enter Password input : user_password2 -->
								<div class="control-group">
									<label class="control-label" for="signup_user_password2">Re-Enter Password:</label>
									<div class="controls">
										<input type="password" class="form-control input-large" id="signup_user_password2" name="user_password2" placeholder="********" required>
										<div id="signup_user_password2_message" style="display: none;"></div>
									</div>
								</div>
								<br />
								
								<!-- NickName input : user_nickname -->
								<div class="control-group">
									<label class="control-label" for="signup_user_nickname">NickName:</label>
									<div class="controls">
										<input type="text" class="form-control input-large" id="signup_user_nickname" name="user_nickname" placeholder="한글(초성 제외) 또는 영어 또는 숫자로만 구성.(수정 불가능. 최대 255자)" required>
										<div id="signup_user_nickname_message" style="display: none;"></div>
									</div>
								</div>
								<br />
								
								<div class="control-group">
									<label class="control-label" for="signup_user_name">Name:</label>
									<div class="controls">
										<input type="text" class="form-control input-large" id="signup_user_name" name="user_name" placeholder="한글(초성 제외) 또는 영어(최대 255자)" required>
										<div id="signup_user_name_message" style="display: none;"></div>
									</div>
								</div>
								<br />
								
								<!-- Button -->
								<div class="control-group">
									<label class="control-label" for="signup-btn"></label>
									<div class="controls">
										<button type="button" class="btn btn-success pull-right" id="signup-btn" name="signup-btn">Sign Up</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>