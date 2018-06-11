<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width", initial-scale="1">
		<title>코드좀-Error</title>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<%@ include file="header.jsp" %>
		
		<%
			String errorMsg = (String)session.getAttribute("errorMsg");
		%>
		
		<div class="row">
			<%=errorMsg%>
		</div>
		
		<%@ include file="footer.jsp"%>