<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>멤버수정</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>
	멤버수정
</h1>
<form action="/spring/memberUpdate" method="post">
<table class="table table-striped">
		<tr>
			<th>ID</th>
			<td><input type="text" id="user_id" name="user_id" value="${vo.user_id }"/></td>
		</tr>
		<tr>
			<th>Name</th>
			<td><input type="text" id="user_name" name="user_name" value="${vo.user_name }"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="pw" name="pw" value="${vo.pw }"/></td>
		</tr>
		<tr>
			<th>email</th>
			<td><input type="text" id="eamil" name="eamil" value="${vo.email }"/></td>
		</tr>
		<tr>
			<td><input type="submit" id="btn" name="btn" value="수정"/></td>
		</tr>
</table>
</form>
</div>

</body>
</html>
