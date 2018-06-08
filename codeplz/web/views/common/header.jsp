<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jsp.user.model.vo.*"%>
<%
	User_Vo user = (User_Vo)session.getAttribute("user");
%>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/codeplz.css?ver=1" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/mypage.css?ver=1" />
	</head>
	<body>
		<script type="text/javascript">
			$(document).ready(function () {
				$('#sidebarCollapse').on('click', function () {
					$('#sidebar').toggleClass('active');
					$(this).toggleClass('active');
				});
				$('#logo_btn_top').on('click', function () {
					location.href="/codeplz/index.jsp";
				});
				
			});
		</script>
		
		<div class="wrapper">
			<nav id="sidebar">
				<div class="sidebar-header">
					<% if (user == null) { %>
					<!-- 접속하지 않았으므로 로그인 버튼 출력 -->
					<div class="before-login">
						<ul class="list-unstyled CTAs">						
							<li>
								<!-- #signmodal has been signModal.jsp -->
								<a class="btn sign-btn" id="sign-btn" data-target="#signmodal" data-toggle="modal">로그인 / 회원가입</a>
							</li>
						</ul>
					</div>
                	
                	<% } else { %>
                	<!-- 접속한 유저의 정보 출력 -->
					<div>
						<div class="after-signin" align="center">
							<img class="profile-img" src="/codeplz/resources/images/profile.png"/>
							<p>닉네임 : <a class="message-btn" href="#"><span class="glyphicon glyphicon-envelope"></span></a>   
								<span class="badge badge-pill badge-danger new-message">12</span>
								<a class="news-btn" href="#"><span class="glyphicon glyphicon-bell"></span></a>
								<span class="badge badge-pill badge-danger new-news">12</span>
							</p>
							<p>Tier : </p>
							<p>Exp : </p>
							<button type="button" class="btn mypage-btn" onclick="location.href='<%=request.getContextPath()%>/mypage.cp?user=<%=user.getUser_nickname()%>&index=0'">My Page</button>
							<button type="button" class="btn signout-btn" id="signout-btn">Sign Out</button>
						</div>
					</div>
					<% } %>
					<div class="search-wraper">
  						<div class="input-group">
    						<input type="text" class="form-control" placeholder="Search">
    						<div class="input-group-btn">
      							<button class="btn btn-default" id="search-btn" type="submit">
        							<i class="glyphicon glyphicon-search"></i>
      							</button>
    						</div>
  						</div>
        			</div>
				</div>

				<ul class="list-unstyled components">
				<!-- <p>Dummy Heading</p> -->
					<li>
						<a href="<%=request.getContextPath() %>/selectList.cp?CategoryIndex=0">공지사항</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/selectList.cp?CategoryIndex=1">Q & A</a>
					</li>
					<li>
						<a href="<%=request.getContextPath() %>/selectList.cp?CategoryIndex=2">정보</a>
					</li>
					<li>
						<a class="dropdown-toggle collapsed" href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">커뮤니티</a>
						<ul class="collapse list-unstyled" id="pageSubmenu">
							<li><a href="<%=request.getContextPath() %>/selectList.cp?CategoryIndex=3">잡담</a></li>
							<li><a href="<%=request.getContextPath() %>/selectList.cp?CategoryIndex=4">토론</a></li>
							<li><a href="<%=request.getContextPath() %>/selectList.cp?CategoryIndex=5">회사정보</a></li>
							<li><a href="<%=request.getContextPath() %>/selectList.cp?CategoryIndex=6">구인구직</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			
			<div id="content">	
				<nav class="navbar navbar-default" id="navbarTop">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" id="sidebarCollapse" class="navbar-btn">
								<span></span>
								<span></span>
								<span></span>
							</button>
							<button class="logo-Btn-Top navbar-fixed-top btn-lg" id="logo_btn_top">
								<img src="/codeplz/resources/images/text_logo.png"/>
							</button>
						</div>
					</div>
				</nav>