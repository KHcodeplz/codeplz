<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>글 작성</title>

	<link rel="stylesheet" href="/codeplz/resources/css/bootstrap-tagsinput.css" />
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css">
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/codeplz/resources/js/bootstrap-tagsinput.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
	<script src="/codeplz/resources/js/summernote/summernote-ko-KR.js"></script>

	<%@ include file="../common/header.jsp" %>

	<br />
	<br />

	<div class="container" style="width: 100%;">
		<form id="defaultForm" method="post" class="form-horizontal" enctype="multipart/form-data">
			<div class="row">
				<div class="col-lg-6">
					<div class="input-group">
						<div class="input-group-btn" id="example">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								------ <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Q & A</a></li>
								<li><a href="#">정보</a></li>
								<li><a href="#">잡담</a></li>
								<li><a href="#">토론</a></li>
								<li><a href="#">회사정보</a></li>
								<li><a href="#">구인구직</a></li>
							</ul>
						</div>
						<input type="text" class="form-control" name="title" id="title">
					</div>
				</div>
			</div>
			<br />
			<div class="form-group row">
				<div class="col-sm-8" >
					<input type="text" name="tags" id="tags" class="form-control" data-role="tagsinput" placeholder="태그를 등록해 주세요."/>
				</div>
				<div class="col-sm-4">
					<input type="file" class="form-control" name="file" id="file" />
				</div>
			</div>
			
			<div id="summernote"></div>

			<textarea name="content" id="content" style="display: none;"></textarea>

			<button type="button" class="btn" id="boardInputBtn" style="float: right;">등록하기</button>
		</form>
	</div>
			
	<script>
		
		var categoryIndex = 0;
		
		$(document).ready(function() {
			$('#summernote').summernote();

		});
		
		$('#example .dropdown-menu li > a').bind('click',
			function(e) {
				category = $(this).html();
				$('#example button.dropdown-toggle').html(category + ' <span class="caret"></span>');
				
				if(category == "Q &amp; A"){
					categoryIndex = 1;
				} else if(category == "정보"){
					categoryIndex = 2;
				} else if(category == "잡담"){
					categoryIndex = 3;
				} else if(category == "토론"){
					categoryIndex = 4;
				} else if(category == "회사정보"){
					categoryIndex = 5;
				} else if(category == "구인구직"){
					categoryIndex = 6;
				}
		});
		
		var insertCode = function(context) {
			var ui = $.summernote.ui;

			var button = ui
					.button({
						contents : '<span class="glyphicon glyphicon-edit"></span>',
						tooltip : '코드입력',
						click : function() {
							$('#code_modal').modal('toggle');
						}
					});

			return button.render();
		}
		
		$('#summernote').summernote({
						/* onblur : function(e) {
							$('#summercontent').html($('#summernote').code());
						}, */
						height : 500, // set editor height
						minHeight : 100, // set minimum height of editor
						maxHeight : null, // set maximum height of editor
						dialogsInBody: true,
						lang : 'ko-KR',
						toolbar : [
							['font',[ 'bold', 'italic', 'underline','clear' ] ],
							[ 'fontname', [ 'fontname' ] ],
							[ 'fintsize', [ 'fontsize' ] ],
							[ 'color', [ 'color' ] ],
							[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
							[ 'table', [ 'table' ] ],
							[ 'insertCode', [ 'insertCode' ] ],
							['insert',[ 'link', 'picture','video', 'hr' ] ] ],
						buttons : {
							insertCode : insertCode
						}, 
						callbacks: {
							onImageUpload: function(files, editor, welEditable) {
					            for (var i = files.length - 1; i >= 0; i--) {
					            	sendImage(files[i], this);
					            }
					        }
						}
		});
		
		function sendImage(file, el) {
			var form_data = new FormData();
	      	form_data.append('file', file);
	      	$.ajax({
	        	data: form_data,
	        	type: "POST",
	        	url: '/codeplz/board_insert_image.cp',
	        	cache: false,
	        	contentType: false,
	        	enctype: 'multipart/form-data',
	        	processData: false,
	        	success: function(img_name) {
	          		var image = $('<img>').attr('src', '/codeplz/upload/'+img_name);
	                $('#summernote').summernote("insertNode", image[0]);
	        	}
	      	});
	    }
		
		
		$('#boardInputBtn').on('click', function() {
			$('#content').val($('#summernote').summernote('code'));
			
			var form_data = new FormData();
			form_data.append('category', categoryIndex);
			form_data.append('tag', $('#tags').val());
			form_data.append('title', $('#title').val());
			form_data.append('content',$('#content').val());
			form_data.append('file',$('#file')[0].files[0]);
			
			$.ajax({
				url: "/codeplz/board_insert.cp",
				data: form_data, 
				cache: false,
	        	contentType: false,
	        	enctype: 'multipart/form-data',
	        	processData: false,
				type: "post",
				success: function(data) {
					location.href = '/codeplz/board_detail.cp?index='+data;
				}, error: function(data) {
					console.log("실패!");
				}
			});
		});
		
		function boardInsertCode() {

			var $s = $('#summernote').summernote('code');

			var code = $('#code').val();
			var codeArr = code.split("");
			
			for(var i = 0; i < codeArr.length; i++) {
				if(codeArr[i] == '<') {
					codeArr[i] = "&lt;";
				} else if(codeArr[i] == '>') {
					codeArr[i] = "&gt;"
				}
			}
			
			code = codeArr.join("");
			
			var node = document.createElement('pre');
			node.setAttribute('class', 'brush: '+$('#selectlang').val());
			node.innerHTML = code;

			$('#summernote').summernote('insertNode', node);
			
			$('#code_modal').modal('hide');
		}
	</script>

	

	<%@ include file="../common/footer.jsp" %>