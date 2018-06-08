<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="com.jsp.mypage.model.vo.*,  java.util.*" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width", initial-scale="1">
		<title>코드좀-myPage</title>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<%@ include file="../common/header.jsp" %>
<%
	int index = (int)request.getAttribute("index");
	ArrayList<Mypage> list = (ArrayList<Mypage>) request.getAttribute("list");
	String category_name = "";
	String content_name = "";
%>
<script>
	$(function() {
		var $a = $(".mypage-content:LAST-CHILD");
		$a.append("<div style='height: 5px;'></div>");
	});
	$(function() {
		$("#myPostBtn").on('click', function() {
			location.href='<%=request.getContextPath() %>/mypage.cp?user=<%=user.getUser_nickname()%>&index=0';
		});
		$("#myReplyBtn").on('click', function() {
			location.href='<%=request.getContextPath() %>/mypage.cp?user=<%=user.getUser_nickname()%>&index=1';
		});
		$("#myPostReplyBtn").on('click', function() {
			location.href='<%=request.getContextPath() %>/mypage.cp?user=<%=user.getUser_nickname()%>&index=2';
		});
	});
</script>
<div class="mypage-contains">
	<div class="mypage-wrap">
		<div class="mypage-img">
			<img class="profile-img" src="/codeplz/resources/images/profile.png"/>
		</div>
		<br>
		<div class="mypage-profile">
			<p>닉네임 : <%=user.getUser_nickname() %>
			<a class="message-btn" href="#">
			<span class="glyphicon glyphicon-envelope"></span></a>	
			<span class="badge badge-pill badge-danger new-message">12</span>
			<a class="news-btn" href="#"><span class="glyphicon glyphicon-bell"></span></a>
			<span class="badge badge-pill badge-danger new-news">12</span></p>
					<p>Tier : <%=user.getUser_tier_index() %></p>
					<p>Exp : </p>
  			<div class="mypage-portfolio-wrap">
  				<button type="button" class="portfolio_btn" onclick="portfolio_open();">포트폴리오</button>
  			</div>
		</div>
		<hr>
	</div>
	
	<div class="mypage-content-btn">	
		<button id="myPostBtn">내가 쓴 글</button>			
		<button id="myReplyBtn">내가 쓴 댓글</button>
		<button id="myPostReplyBtn">내 글에 댓글</button>
		<hr>		
	</div>
	
		<div class="mypage-content">
			<div class="mypage-content-title-wrap">
				<div class="mypage-content-title">
					<span class="glyphicon glyphicon-tags" style="margin-right:15px;"></span>
							<% if ( index == 0 ) {
									content_name = "내가 쓴 글";
								} else if ( index == 1 ) {
									content_name = "내가 쓴 댓글";
								} else if ( index == 2 ) {
									content_name = "내 글에 댓글";
								}
							%>
							<%=content_name %>
				</div>
			</div>
		<% if ( index == 0 ) { %>
		<% for ( Mypage mp : list ) { %>
		<div class="mypage-content-body-wrap">
			<div class="mypage-content-body">
				<table>
					<tbody>
						<tr class="mypage-table-line">
							<td class="line-name"><%=mp.getBoard_writer() %></td>
							<td>님께서</td>
							<td class="line-day"> <%=mp.getBoard_elapsed_date() %>일</td>
							<td>전에</td>
							<td class="line-board"> 
								<% if ( mp.getBoard_category_index()==0 ) {
										category_name = "공지사항";
									} else if ( mp.getBoard_category_index()==1 ) {
										category_name = "Q&A";
									} else if ( mp.getBoard_category_index()==2 ) {
										category_name = "정보";
									} else if ( mp.getBoard_category_index()==3 ) {
										category_name = "잡담";
									} else if ( mp.getBoard_category_index()==4 ) {
										category_name = "토론";
									} else if ( mp.getBoard_category_index()==5 ) {
										category_name = "회사정보";
									} else if ( mp.getBoard_category_index()==6 ) {
										category_name = "구인구직";
									} 
								%>
								<%=category_name %>
							</td>
							<td>에</td>
							<td class="line-board">
								<a href="<%=request.getContextPath()%>/board_detail.cp?index=<%=mp.getBoard_index()%>">
									<%=mp.getBoard_title() %>
								</a>
							</td>
							<td>올림</td>
						</tr>
					</tbody>
				</table>
				<div class="line-sysday"><%=mp.getBoard_inserted_date() %></div>
			</div>
		</div>
		<% } %>
		<% } else if ( index == 1 ) { for ( Mypage mp : list ) { %>
		<!--  내가 쓴 댓글 -->
		<div class="mypage-content-body-wrap">
			<div class="mypage-content-body">
				<table>
					<tbody>
						<tr class="mypage-table-line">
							<td class="line-board">
								<% if ( mp.getBoard_category_index()==0 ) {
										category_name = "공지사항";
									} else if ( mp.getBoard_category_index()==1 ) {
										category_name = "Q&A";
									} else if ( mp.getBoard_category_index()==2 ) {
										category_name = "정보";
									} else if ( mp.getBoard_category_index()==3 ) {
										category_name = "잡담";
									} else if ( mp.getBoard_category_index()==4 ) {
										category_name = "토론";
									} else if ( mp.getBoard_category_index()==5 ) {
										category_name = "회사정보";
									} else if ( mp.getBoard_category_index()==6 ) {
										category_name = "구인구직";
									} 
								%>
								<%=category_name %>
							</td>
							<td>에 있는</td>
							<td class="line-board">
								<a href="<%=request.getContextPath()%>/board_detail.cp?index=<%=mp.getBoard_index()%>">
									<%=mp.getBoard_title() %>
								</a>
							</td>
							<td>에</td>
							<td class="line-day"><%=mp.getBoard_elapsed_date() %>일</td>
							<td>전</td>
							<td class="line-board">
								<a href="<%=request.getContextPath()%>/board_detail.cp?index=<%=mp.getBoard_index()%>&rindex=<%=mp.getReply_index()%>">
									<%=mp.getReply_content() %>
								</a>
							</td>
							<td>댓글작성</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="line-sysday"><%=mp.getReply_inserted_date() %></div>
		</div>
		<% } } else if ( index == 2 ) { for ( Mypage mp : list ) {  %>
		<!--  내 글에 답글 -->
		<div class="mypage-content-body-wrap">
			<div class="mypage-content-body">
				<table>
					<tbody>
						<tr class="mypage-table-line">
							<td class="line-name"><%=mp.getReply_writer() %></td>
							<td>님이</td>
							<td class="line-board">
								<% if ( mp.getBoard_category_index()==0 ) {
										category_name = "공지사항";
									} else if ( mp.getBoard_category_index()==1 ) {
										category_name = "Q&A";
									} else if ( mp.getBoard_category_index()==2 ) {
										category_name = "정보";
									} else if ( mp.getBoard_category_index()==3 ) {
										category_name = "잡담";
									} else if ( mp.getBoard_category_index()==4 ) {
										category_name = "토론";
									} else if ( mp.getBoard_category_index()==5 ) {
										category_name = "회사정보";
									} else if ( mp.getBoard_category_index()==6 ) {
										category_name = "구인구직";
									} 
								%>
								<%=category_name %>
							</td>
							<td>에 있는</td>
							<td class="line-board">
								<a href="<%=request.getContextPath()%>/board_detail.cp?index=<%=mp.getBoard_index()%>">
									<%=mp.getBoard_title() %>
								</a>
							</td>
							<td>게시글에</td>
							<td class="line-day"><%=mp.getBoard_elapsed_date() %>일</td>
							<td>전</td>
							<td class="line-board">
								<a href="<%=request.getContextPath()%>/board_detail.cp?index=<%=mp.getBoard_index()%>">
									<%=mp.getReply_content()%>
								</a>
							</td>
							<td>댓글을 남겼습니다.</td>
						</tr>
					</tbody>
				</table>
				<div class="line-sysday"><%=mp.getReply_inserted_date() %></div>
			</div>
		</div>	
		<% } } %>
	<!--  body 닫는곳 -->
	</div>
</div>
		<%@ include file="../common/footer.jsp" %>