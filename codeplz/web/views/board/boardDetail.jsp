<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="com.jsp.board.model.vo.*, java.util.*"%>
<%
	Board b = (Board)request.getAttribute("b"); 
ArrayList<Board_Comment> cList = (ArrayList<Board_Comment>) request.getAttribute("cList");
%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">

<title>제목 - codeplz</title>

<script src="/codeplz/resources/js/syntaxhighlighter/shCore.js"></script>
<script src="/codeplz/resources/js/syntaxhighlighter/shBrushJava.js"></script>
<script src="/codeplz/resources/js/syntaxhighlighter/shBrushCpp.js"></script>
<script src="/codeplz/resources/js/syntaxhighlighter/shBrushPython.js"></script>

<link rel="stylesheet" href="/codeplz/resources/css/syntaxhighlighter/shCore.css" />
<link rel="stylesheet" href="/codeplz/resources/css/syntaxhighlighter/shThemeDefault.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%@ include file="../common/header.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('fieldset').on('keyup', 'textarea', function(e) {
			$(this).css('height', 'auto');
			$(this).height(this.scrollHeight);
		});
		
		$('fieldset').find('textarea').keyup();
		
		$('#ModifyComment').on('keyup', 'textarea', function(e) {
			$(this).css('height', 'auto');
			$(this).height(this.scrollHeight);
		});
		
	    $('#ModifyComment').find('textarea').keyup();
	});
   
	SyntaxHighlighter.defaults['smart-tabs'] = true; // 탭 사이즈를 자동조절   
	SyntaxHighlighter.all();
   
	$('.btn-modify').on('click', function() {
		<% session.setAttribute("board", b); %>
		location.href = "/codeplz/views/board/writeForm.jsp";
	});
	
	function updateReply(obj){
		   $(obj).parent().parent().prev().find('article').removeAttr('readonly');
			$(obj).css('display','none');  
			$(obj).siblings('.updateConfirm').css('display','inline');
			$(obj).parent().parent().find("#ModifyComment").css('display','block');
			$(obj).parent().parent().find("#firstComment").css('display','none');
	   }
	function updateComfirm(obj){
		   var content = $(obj).parent().parent().find("#ModifyComment").val();
		   
		   var cIndex =$(obj).siblings('.cIndex').val();
		   
		   var bIndex = '<%=b.getBoard_index()%>';
		   
		   location.href="/codeplz/update_Comment.cp?cIndex="+cIndex +"&bIndex="+bIndex+"&content="+content;
		   
	   }
	   function deleteReply(obj){
		   
	 		var cIndex =$(obj).siblings('.cIndex').val();
		   
		   var bIndex = '<%=b.getBoard_index()%>';
		   
		   location.href="/codeplz/delete_Comment.cp?cIndex="+cIndex+"&bIndex="+bIndex;
	   }
</script>

<h3><a href="/codeplz/board_selectList.cp"><%=b.getBoard_category_index() %></a></h3>
<div class="col-12" class="panel panel-default clearfix">
   <div class="panel-heading clearfix" id="boardInfo">
      <div class="avatar avatar-medium clearfix pull-left">
         <div class="avatar-info">
            <h2 class="panel-title"><%=b.getBoard_title() %></h2>
            <div class="date-created">
               <p><span class="timeago"><%=b.getBoard_inserted_date() %></span></p>
            </div>
         </div>
      </div>
      <div class="tag-container">
         <div class="content-tags" id="tags">
         <% if(b.getBoard_tags() != null ) {
         		String[] tagArr = b.getBoard_tags().split(",");
         		for (int i = 0; i < tagArr.length; i++) { %>
            	<a href="#" class="list-group-item-text item-tag label label-info"><%=tagArr[i]%></a>
         <% }}%>
         </div>
      </div>
      <div class="content-identity pull-right">
        <div class="content-identity-count">조회수 &nbsp; <%=b.getBoard_hits() %></div>
      </div>
   </div>

   <div class="content-container clearfix">
		<div class="panel-body content-body pull-left content-form">
			<a href="#"><%=b.getBoard_writer()%></a>(티어)
			<hr />
			<article class="content-text" ><%=b.getBoard_content()%></article>
		</div>
		<br />
		<br />
	<!-- 게시판 작성자와 유저 아이디가 같을떄 -->
		<%if (user != null && user.getUser_nickname().equals(b.getBoard_writer())) {%>
		
		<button class="btn-delete pull-right btn btn-success" onclick="location.href='/codeplz/delete.cp?BIndex=<%=b.getBoard_index()%>'">삭제하기</button>
		<button class="btn-modify pull-right btn btn-success">수정하기</button>
		<%}%>
	</div>

   <br /><br /><br />
   
   	<!-- 댓글창 -->
	<div class="panel panel-default clearfix"">
		<ul class="list-group">
			<li class="list-group-item note-title">
				<h3 class="panel-title">댓글</h3>
			</li>
				<%
					if (cList != null) {
						for (Board_Comment bco : cList) {
				%>
			<li class="list-group-item note-item clearfix">
			
				<div class="content-body panel-body pull-left" id="panel-body">
					<div class="avatar avatar-medium clearfix">
						<div class="avatar-info">
							<a href="#"><%=bco.getReply_writer()%> </a>(티어) <input
								type="hidden" name="name" /> <input type="hidden" name="writer" />
							<div class="date-created">
								<p id="p">
									<span class="timeago"><%=bco.getReply_inserted_date()%></span>&nbsp;작성&nbsp;&nbsp;
									<% if(bco.getReply_modified_date()!=null) {%>
									<span class="timeago"><%=bco.getReply_modified_date()%></span>&nbsp;수정됨
									<%} %>
								</p>
							</div>
						</div>
					</div>
					
					<fieldset class="form">
						<article class="list-group-item-text note-text" id="firstComment" name="replyContent"
							name="" readonly="readonly"><%=bco.getReply_content()%>
						</article>
					</fieldset>
				</div>
				
					<textarea class="comment-content form-control" placeholder="내용을 입력하세요." id="ModifyComment"
						style="display:none;" ><%=bco.getReply_content()%>
						</textarea>
				<!-- 커맨트 작성자와 유저 아이디가 같을떄 -->
				<%if(user.getUser_nickname().equals(bco.getReply_writer())){ %>
				<div class="content-function-cog note-submit-buttons clearfix">
						
						<input type="submit" class="btn btn-success btn-wide pull-right" id="Comment_DeleteBnt"  value="삭제"  onclick="deleteReply(this);"/>
						<input type="submit" class="btn btn-success btn-wide pull-right" id="Comment_ModifyBnt" value="수정"  onclick="updateReply(this);"/>
						<input type="submit" class="updateConfirm  btn btn-success btn-wide pull-right" id="Comment_ModifyBnt" value="완료"  onclick="updateComfirm(this);" style="display:none;"/>
						<input type="hidden" class="cIndex" " value="<%=bco.getReply_index()%>"/>
						
				</div>
				<%} %>
			 <%}} %>
					
			</li>

			<%if(session.getAttribute("user") == null){ %>
			<!-- 비회원 댓글창 -->
			<div class="panel-body">
            <h5 class="text-center"><a href="#">로그인</a>을 하시면 답변을 등록할 수 있습니다.</h5>
         </div>
			<%} else{ %>	
			<!-- 로그인 시 댓글창 -->
			<li class="list-group-item note-form clearfix">
				<form action="/codeplz/Comment_Insert.cp" method="post"
					class="note-create-form">
					<div class="content-body panel-body pull-left comment-content"
						style="padding: 0;">
						<div>
							<div class="avatar-info">
								<a href="#"><%=user.getUser_nickname()%></a>(티어) <input
									type="hidden" name="writer"
									value="<%=user.getUser_nickname()%>" /> <input type="hidden"
									name="bIndex" value="<%=b.getBoard_index()%>" />
							</div>
						</div>
						<fieldset class="form">
							<textarea class="form-control" placeholder="내용을 입력하세요."
								style="margin-top: 10px; height: auto;" name="replyContent"></textarea>
						</fieldset>
					</div>
					<div class="content-function-cog note-submit-buttons clearfix">
						<input type="submit" class="btn btn-success btn-wide pull-right"
							value="댓글쓰기" />


					</div>
				</form>

			</li>
			<%} %>
		</ul>

	</div>

</div>


<%@ include file="../common/footer.jsp"%>