// 회원가입 체크 영역 변수

var signup_id_check = false;
var signup_id_auth_check = false;
var signup_password_check = false;
var signup_password2_check = false;
var signup_nickname_check = false;
var signup_name_check = false;

var signup_id_auth_window = null; // auth 인증 자식 창

// 회원가입 체크 영역 변수 끝

// 접속 체크 영역 변수

var signin_id_check = false;
var signin_password_check = false;

// 접속 체크 영역 변수 끝

// 정보 수정 영역 체크 변수

var user_modify_name_check = false;
var user_modify_password_check = false;
var user_modify_password2_check = false;

// 정보 수정 영역 체크 변수 끝

$(function() {
	$('#tab_signin').on('click', function() {
		// signin init
		signin_id_check = false;
		signin_password_check = false;
		
		$('#signin_user_id').val("");
		$('#signin_user_password').val("");
		
		// signup init
		signup_id_check = false;
		signup_id_auth_check = false;
		signup_password_check = false;
		signup_password2_check = false;
		signup_nickname_check = false;
		signup_name_check = false;
		
		signup_id_auth_window = null;
		
		$('#signup_user_id').val("");
		$('#signup_user_id_message').css('display', 'none');
		$('#signup_user_id_auth_btn').css('display', 'none');
		
		$('#signup_user_password').val("");
		$('#signup_user_password_message').css('display', 'none');
		
		$('#signup_user_password2').val("");
		$('#signup_user_password2_message').css('display', 'none');
		$('#signup_user_password2').removeAttr("disabled");
		
		$('#signup_user_nickname').val("");
		$('#signup_user_nickname_message').css('display', 'none');
		
		$('#signup_user_name').val("");
		$('#signup_user_name_message').css('display', 'none');
	});
	
	$('#tab_signup').on('click', function() {
		// signup init
		signup_id_check = false;
		signup_id_auth_check = false;
		signup_password_check = false;
		signup_password2_check = false;
		signup_nickname_check = false;
		signup_name_check = false;
		
		signup_id_auth_window = null;
		
		$('#signup_user_id').val("");
		$('#signup_user_id_message').css('display', 'none');
		$('#signup_user_id_auth_btn').css('display', 'none');
		
		$('#signup_user_password').val("");
		$('#signup_user_password_message').css('display', 'none');
		
		$('#signup_user_password2').val("");
		$('#signup_user_password2_message').css('display', 'none');
		$('#signup_user_password2').removeAttr("disabled");
		
		$('#signup_user_nickname').val("");
		$('#signup_user_nickname_message').css('display', 'none');
		
		$('#signup_user_name').val("");
		$('#signup_user_name_message').css('display', 'none');
		
		// signin init
		signin_id_check = false;
		signin_password_check = false;
		
		$('#signin_user_id').val("");
		$('#signin_user_password').val("");
	});
	
	$('#sign-btn').on('click', function() {
		// signin init
		signin_id_check = false;
		signin_password_check = false;
		
		$('#signin_user_id').val("");
		$('#signin_user_password').val("");
		
		// signup init
		signup_id_check = false;
		signup_id_auth_check = false;
		signup_password_check = false;
		signup_password2_check = false;
		signup_nickname_check = false;
		signup_name_check = false;
		
		signup_id_auth_window = null;
		
		$('#signup_user_id').val("");
		$('#signup_user_id_message').css('display', 'none');
		$('#signup_user_id_auth_btn').css('display', 'none');
		
		$('#signup_user_password').val("");
		$('#signup_user_password_message').css('display', 'none');
		
		$('#signup_user_password2').val("");
		$('#signup_user_password2_message').css('display', 'none');
		$('#signup_user_password2').removeAttr("disabled");
		
		$('#signup_user_nickname').val("");
		$('#signup_user_nickname_message').css('display', 'none');
		
		$('#signup_user_name').val("");
		$('#signup_user_name_message').css('display', 'none');
	});
	
	/* 
	 * 회원가입 체크 영역
	 */
	
	// signup id check
	$('#signup_user_id').on('blur', function() {
		// regExp : 이메일 정규 표현식
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,4}$/g;
		var input_id = $('#signup_user_id').val();
		
		if (input_id == "" || input_id == null) {
			signup_id_check = false;
			$('#signup_user_id_auth_btn').css('display', 'none');
			$('#signup_user_id_message').text('필수 정보입니다.');
		} else if (!regExp.test(input_id)) { // 정규 표현식이 일치하지 않으면
			signup_id_check = false;
			$('#signup_user_id_auth_btn').css('display', 'none');
			$('#signup_user_id_message').text('이메일 양식을 확인해 주세요.');
		} else {
			$.ajax({
				data: {
					user_id : input_id
				},
				url: "/codeplz/signup_id_Check.cp",
				
				success: function(data) {
					
					console.log(data);
					
					if (data) {
						signup_id_check = false;
						$('#signup_user_id_auth_btn').css('display', 'none');
						$('#signup_user_id_message').text('이미 사용중인 ID입니다.');
					} else {
						signup_id_check = true;
						$('#signup_user_id_message').css('display', 'none');
						$('#signup_user_id_auth_btn').css('display', '');
					}
				}
			});
		}
		$('#signup_user_id_message').css("display","");
	});
	
	// signup send auth
	$('#signup_user_id_auth_btn').on('click', function() {
		var id = $('#signup_user_id').val();
		console.log(id);
		signup_id_auth_window = window.open('/codeplz/views/common/signupAuth.jsp', 'asdf', 'left=200, top=200, width=640, height=480, scrollbars=no, status=no, resizable=no, fullscreen=no, channelmode=no');
		signup_id_auth_window.onload = function() {
			signup_id_auth_window.document.getElementById('signup_auth_user_id').value = id;
		};
	});
	
	// signup password check
	$('#signup_user_password').on('blur', function() {
		var reg_Exp = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$/g;
		var input_password = $('#signup_user_password').val();
		
		if (input_password == "" || input_password == null) {
			signup_password_check = false;
			$('#signup_user_password_message').text("비밀번호를 입력해주세요.");
		} else if (!reg_Exp.test(input_password)) {
			signup_password_check = false;
			$('#signup_user_password_message').text("8~20자, 최소 1개의 대문자, 소문자, 특수문자를 포함해 입력해주세요.");
		} else {
			signup_password_check = true;
			$('#signup_user_password_message').text("유효한 비밀번호 입니다.");
			$('#signup_user_password2').removeAttr("disabled");
		}
		$('#signup_user_password_message').css("display","");
	});
	
	// signup password2 check
	$('#signup_user_password2').on('blur', function() {
		var input_password = $('#signup_user_password').val();
		var input_password2 = $('#signup_user_password2').val();
		
		if (input_password2 == "" || input_password2 == null) {
			signup_password2_check = false;
			$('#signup_user_password2_message').text("위의 비밀번호를 다시 입력해주세요.");
		} else if (input_password != input_password2) {
			signup_password2_check = false;
			$('#signup_user_password2_message').text("입력한 비밀번호가 같지 않습니다.");
		} else {
			signup_password2_check = true;
			$('#signup_user_password2_message').text("입력한 비밀번호가 같습니다.");
		}
		
		$('#signup_user_password2_message').css("display","");
	});
	
	$('#signup_user_nickname').on('blur', function() {
		var reg_Exp = /^[가-힣a-zA-Z0-9]{2,255}$/;
		var input_nickname = $('#signup_user_nickname').val();
		
		if (input_nickname == "" || input_nickname == null) {
			signup_nickname_check = false;
			$('#signup_user_nickname_message').text("사용할 닉네임을 입력해주세요.(2~255자)");
		} else if (!reg_Exp.test(input_nickname)) {
			signup_nickname_check = false;
			$('#signup_user_nickname_message').text("잘못된 양식입니다.(2~255자)");
		} else {
			$.ajax({
				data: {
					user_nickname : input_nickname
				},
				url: "/codeplz/signup_nickname_Check.cp",
				
				success: function(data) {
					
					console.log(data);
					
					if (data) {
						signup_nickname_check = false;
						$('#signup_user_nickname_message').text('이미 사용중인 닉네임입니다.');
					} else {
						signup_nickname_check = true;
						$('#signup_user_nickname_message').text('사용 가능한 닉네임입니다.');
					}
					
				}
			});
		}
		
		$('#signup_user_nickname_message').css("display","");
	});
	
	$('#signup_user_name').on('blur', function() {
		var reg_Exp = /^[가-힣a-zA-Z]{2,255}$/;
		var input_name = $('#signup_user_name').val();
		
		if (input_name == "" || input_name == null) {
			signup_name_check = false;
			$('#signup_user_name_message').text('이름을 입력해주세요.(2~255자)');
		} else if (!reg_Exp.test(input_name)) {
			signup_name_check = false;
			$('#signup_user_name_message').text('잘못된 양식입니다.(2~255자)');
		} else {
			signup_name_check = true;
			$('#signup_user_name_message').text('사용 가능한 이름입니다.');
		}
		
		console.log(input_name);
		$('#signup_user_name_message').css("display", "");
	});
	
	$('#signup-btn').on('click', function() {
		if (!signup_id_check) { // id 체크가 안되있으면
			$('#signup_user_id_message').text("값을 확인해주세요.");
			$('#signup_user_id_message').css("display", "");
			$('#signup_user_id').focus();
		} else if (!signup_id_auth_check) {
			alert('이메일 인증을 완료해주세요!');
			$('#signup_user_id_auth_btn').focus();
		} else if (!signup_password_check) {
			$('#signup_user_password_message').text("값을 확인해주세요.");
			$('#signup_user_password_message').css("display", "");
			$('#signup_user_password').focus();
		} else if (!signup_password2_check) {
			$('#signup_user_password2_message').text("값을 확인해주세요.");
			$('#signup_user_password2_message').css("display", "");
			$('#signup_user_password2').focus();
		} else if (!signup_nickname_check) {
			$('#signup_user_nickname_message').text("값을 확인해주세요.");
			$('#signup_user_nickname_message').css("display", "");
			$('#signup_user_nickname').focus();
		} else if (!signup_name_check) {
			$('#signup_user_name_message').text("값을 확인해주세요.");
			$('#signup_user_name_message').css("display", "");
			$('#signup_user_name').focus();
		} else {
			$('#signup_user_password2').attr("disabled", "true");
			
			$.ajax({
				type: "post",
				url: "/codeplz/signup.cp",
				data: $('#signup_form').serialize(),
				success: function (data) {
					if (data) {
						alert("회원가입 성공!");
					}
				}
			});
		}
	});

	/* 
	 * 회원가입 체크 영역 끝
	 */
	
	// 접속 체크 영역
	$('#signin-btn').on('click', function() {
		$('#signin_form').submit();
	});
	// 접속 체크 영역 끝
	 
	
	// 접속 해제 영역
	$('#signout-btn').on('click', function() {
		location.href="/codeplz/signout.cp";
	});
	// 접속 해제 영역 끝
	
	
	// 회원정보 변경 영역
	$('#userModify-btn').on('click', function() {
		location.href="/codeplz/views/mypage/userModify.jsp"
	});
	
	$('#password_submit').on('click', function() {
		$('#form_password_check_for_modify').submit();
	});
	
	$('#name_for_modify').on('blur', function() {
		var reg_Exp = /^[가-힣a-zA-Z]{2,255}$/;
		var input = $('#name_for_modify').val();
		
		if (reg_Exp.test(input)) {
			user_modify_name_check = true;
		} else {
			user_modify_name_check = false;
		}
	});
	
	$('#password_for_modify').on('blur', function() {
		var reg_Exp = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$/g;
		var value = $('#password_for_modify').val();
		
		if (value == null || value == "" || reg_Exp.test(value)) {
			user_modify_password_check = true;
			$('#password_for_modify_message').text("유효한 비밀번호 입니다.");
		} else {
			user_modify_password_check = false;
			$('#password_for_modify_message').text("변경을 원하시면 8~20자, 최소 1개의 대문자, 소문자, 특수문자를 포함해 입력해주세요.");
		}
	});
	
	$('#password2_for_modify').on('blur', function() {
		var value1 = $('#password_for_modify').val();
		var value2 = $('#password2_for_modify').val();
		
		if (value1 == value2) {
			user_modify_password2_check = true;
			$('#password2_for_modify_message').text("올바른 입력입니다.");
		} else {
			user_modify_password2_check = false;
			$('#password2_for_modify_message').text("변경을 원하는 두 비밀번호가 같지 않습니다.");
		}
	});
		
	$('#user_info_modify_submit').on('click', function() {
		if (!user_modify_password_check) {
			$('#password_for_modify').focus();
		} else if (!user_modify_password2_check) {
			$('#password2_for_modify').focus();
		} else if (!user_modify_name_check) {
			$('#name_for_modify').focus();
		} else {
			$.ajax({
				type: "post",
				url: "/codeplz/usermodify.cp",
				data: $('#user_info_form').serialize(),
				success: function (data) {
					if (data) {
						alert('수정 성공');
						location.href = '/codeplz/index.jsp';
					}
				}
			});
		}
	});
	
	$('#user_dropout_submit').on('click', function() {
		$.ajax({
				type: "post",
				url: "/codeplz/dropout.cp",
				success: function (data) {
					if (data) {
						alert('탈퇴 완료');
						location.href = '/codeplz/index.jsp';
					}
				}
			});
	})
	// 회원정보 변경 영역 끝
});