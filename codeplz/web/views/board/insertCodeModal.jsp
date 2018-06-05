<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal" id="code_modal" tabindex="-1">
	<div class="modal-dialog" style="width: 800px;">
		<div class="modal-content">
			<div class="modal-header">
				코드입력란
				<button class="close" data-target="#code_modal" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body" align="center">
				<form action="javascript: boardInsertCode();">
					<select name="selectlang" id="selectlang">
						<option value="java">java</option>
						<option value="cpp">c++</option>
						<option value="python">python</option>
					</select> <br /><br />
					<textarea name="code" id="code" cols="100" rows="15" style="resize: none;"></textarea><br /> 
					
					<br />
					
					<div class="control-group">
						<div class="controls">
							<input class="btn btn-primary" type="submit" value="등록" />&nbsp;&nbsp;
							<button class="btn btn-default" type="reset">취소</button>		
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
