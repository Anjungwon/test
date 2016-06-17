<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<html>
<head>
	<title>멤버등록</title>
</head>
<body>


<form action="/spring/member" method="post">
<div class="container">    
<table class="table table-striped">
<h1>멤버등록</h1>

	<tr>
		<th>아이디</th>
		<td><input type="text" name="user_id"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="user_name"></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" name="email"></td>
	</tr>
	
	<tr><td><input type="submit" class="btn btn-info" value="등록"/></td></tr>
	
</table>
</div>
</form>
</body>
</html>
 