<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<html>
<head>
	<title>멤버목록</title>
</head>

<body>

<!--
<script type="text/javascript">
	function go(text, user_id){
		if(text == 'modify'){
			document.readForm.action = "/spring/memberUpdate?user_id=" + user_id;
		}else if(text == 'delete'){
			document.readForm.action = "/spring/memberDelete?user_id=" + user_id;
		}	
	}
</script>
-->

<div class="container">   
<table class="table table-striped">
<h1>멤버목록</h1>
<h3><a href="memberWrite"> 등록 </a></h3>

<thead>
	<th> ID </th>
	<th> 패스워드 </th>
	<th> 이름 </th>		
	<th> 이메일 </th>
	<th> 삭제 </th>
	<th> 수정 </th>
</thead>
<tbody>
	
<c:forEach items="${list}" var="vo">

	<tr>
		<td>${vo.user_id }</td>
		<td>${vo.pw }</td>
		<td>${vo.user_name }</td>
		<td>${vo.email }</td>
	<!--	
		<td><input type="button" value="수정" onclick="go('modify', '${vo.user_id}')" ></td>
		<td><input type="button" value="삭제" onclick="go('delete', '${vo.user_id}')" ></td>
	-->
	</tr>

	
	<form action="/spring/memberDelete" method="post">
	<input type="hidden" name="user_id" id="user_id" value="${vo.user_id }"/>
	<td><input type="submit" id="btn" name="btn" value="삭제"/></td>
	</form>
	
	<form action="/spring/memberEdit" method="post">
	<input type="hidden" name="user_id" id="user_id" value="${vo.user_id }"/>
	<td><input type="submit" id="btn" name="btn" value="수정"/></td>
	</form>

	
</c:forEach>

</tbody>
</table>   
</div>
</body>
</html>
 