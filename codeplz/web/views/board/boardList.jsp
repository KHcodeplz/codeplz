<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="com.jsp.board.model.vo.*, java.util.*" %>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width", initial-scale="1">
<title>코드좀-공지사항</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ include file="../common/header.jsp"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int CategoryIndex = Integer.parseInt(request.getParameter("CategoryIndex"));
%>
	<script>
	$(function(){
	      $("#listArea td").mouseenter(function(){
	         $(this).parent().css({ "cursor" : "pointer"});
	      }).mouseout(function(){
	         $(this).parent().css({});
	      }).click(function(){
	         var index = $(this).parent().find("input").val();
	         location.href="<%=request.getContextPath()%>/board_detail.cp?index="+index;
	         console.log(index);
	        });
			});
	</script>

<div class="row">
	<div class="col-8">
		<caption>
			<h3>메뉴판</h3>
		</caption>
		<table class="table">
			<div class="btn-group btn-group-toggle" data-toggle="buttons">
				<label class="btn btn-secondary active"> <input type="radio"
					name="options" id="option1" autocomplete="off" checked> 최신순
				</label> <label class="btn btn-secondary"> <input type="radio"
					name="options" id="option2" autocomplete="off"> 추천순
				</label> <label class="btn btn-secondary"> <input type="radio"
					name="options" id="option3" autocomplete="off"> 조회순
				</label> <label class="btn btn-secondary " style="padding-right: 30px;">
					<input type="radio" name="options" id="option1" autocomplete="off"
					checked> 댓글순
				</label>
			
			</div>

			<thead>
				<tr>
					<th scope="col" width="10%">번호</th>
					<th scope="col" width="60%">제목</th>
					<th scope="col" width="15%">작성</th>
					<!-- 	<th scope="col" width="15%">추천수</th> -->
					<th scope="col" width="15%">조회</th>

				</tr>
			</thead>
			<%
				for (Board b : list) {
			%>
			<tbody id="listArea">
				<tr>
					<td scope="row"><%=b.getBoard_index()%>
					<input type="hidden"  value="<%=b.getBoard_index()%>"/>
					</td>
					<!-- 테그와 제목  -->
					<td><%=b.getBoard_title()%>&nbsp;<%if(b.getBoard_tags()!=null){ %><%=b.getBoard_tags() %> <%} %></td>
					
					<td><%=b.getBoard_writer()%></td>
					<%-- <td><%=b.getCol_board_count() %></td> 추천수 미구현--%>
					<td><%=b.getBoard_hits()%></td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
	</div>
	<% if(CategoryIndex == 0) {%>
	<% 	if( user.getUser_nickname().equals("관리자")) {%> 
	<button type="button" class="btn btn-outline-lightline-secondary" align="center" onclick="location.href='<%=request.getContextPath()%>/views/board/writeForm.jsp?CategoryIndex=<%= CategoryIndex%>'">글 작성</button>
	<% } }else { %>
	<button type="button" class="btn btn-outline-lightline-secondary" align="center" onclick="location.href='<%=request.getContextPath()%>/views/board/writeForm.jsp?CategoryIndex=<%= CategoryIndex%>'">글 작성</button>
	<% } %>
</div>
<!-- 페이징 처리할 부분 -->
<!-- <br><br><br><br><br> -->
<div class="pagingArea" align="center">
	<button
		onclick="location.href='<%=request.getContextPath()%>/selectList.cp?currentPage=1&CategoryIndex=<%= CategoryIndex%>'"
		class="btn btn-outline-light"><<</button>
	<%
		if (currentPage <= 1) {
	%>
	<button disabled class="btn btn-outline-light"><</button>
	<%
		} else {
	%>
	<button
		onclick="location.href='<%=request.getContextPath()%>/selectList.cp?currentPage=<%=currentPage - 1%>&CategoryIndex=<%= CategoryIndex%>'"
		class="btn btn-outline-light"><</button>
	<%}%>
	<% for (int p = startPage; p <= endPage; p++) {if (p == currentPage) {%>
	<button disabled class="btn btn-outline-light"><%=p%></button>
	<%} else {%>
	<button
		onclick="location.href='<%=request.getContextPath()%>/selectList.cp?currentPage=<%=p%>&CategoryIndex=<%= CategoryIndex%>'"
		class="btn btn-outline-light"><%=p%></button>
	<%}%>
	<%}%>
	<%if (currentPage >= maxPage) {%>
	<button disabled class="btn btn-outline-light">></button>
	<%} else {%>
	<button
		onclick="location.href='<%=request.getContextPath()%>/selectList.cp?currentPage=<%=currentPage + 1%>&CategoryIndex=<%= CategoryIndex%>'"
		class="btn btn-outline-light">></button>
	<%} %>
	<button
		onclick="location.href='<%=request.getContextPath()%>/selectList.cp?currentPage=<%=maxPage%>&CategoryIndex=<%= CategoryIndex%>'"
		class="btn btn-outline-light">>></button>
</div>
<br>
<br>

<div class="searchArea" align="center">
	<select id="searchCondition" name="searchCondition">
		<option>---</option>
		<option value="writer">작성자</option>
		<option value="title">제목</option>
		<option value="content">내용</option>
	</select> <input type="search">
	<button type="submit">검색하기</button>
	-
	<%--  <% if(m != null){ %> --%>
	
	<%-- <% } %> --%>

</div>


<!-- <div class="line"></div> -->

<!-- <div class="jumbotron index_jumbotron">
				<h1 class="text-center">CodePlz</h1>
				<br />
				<p class="text-center"><a class="btn btn-primary" href="#" role="button">들어가기</a></p>
			</div> -->

<%@ include file="../common/footer.jsp"%>