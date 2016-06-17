<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="./include/header.jsp" %>

<div class="container">   
<table class="table table-striped">
<h1>목록</h1>
<h3><a href="/rest/new"> 등록 </a></h3>

<thead>
	<th> NO </th>
	<th> 제목 </th>	
	<th> 이름 </th>
	<th> 작성일 </th>
	<th> 조회수 </th>
</thead>
<tbody>

<c:forEach items="${list}" var="vo">

	<tr>
		<td>${vo.board_no }</td>
		<td><a href="/rest/${vo.board_no }">${vo.title }(${vo.reply_cnt}) </a></td>
		<td>${vo.user_name }</td>
		<td>${vo.regdate }</td>
		<td>${vo.view_cnt }</td>
	</tr>
	
</c:forEach>

</tbody>
</table>

<script type="text/javascript">
	
		var bno = '${vo.board_no}';
	
		function getRestList(page){
			
			if(page == null)
				page = currentPage;
			
			$.ajax({
				type:'get',
				url:'/rest/'+bno+'/'+page,
				headers:{
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "GET",
				},
				dataType:'json',
				data : '',
				success : function(result){
					
					setReplyLIst(result.l);
					setPagePrint(result.p);
				}
			});
			currentPage = page;
		}
		
		
		
		function setPagePrint(pm){
			var str = "<ul class='pagination'>";s
			
			if(pm.prev)
				str += "<li><a onclick='getRestList("+(pm.startPage-1)+" )'>&lt;</a></li>";
			
			for(var i = pm.startPage; i<=pm.endPage; i++){
				if(i == pm.criteria.page){
					str += "<li class='active'><a href='#'>" + i + "</a></li>";
				}else{
					str += "<li><a onclick='getRestList("+i+")' style='cursor:hand'>" + i + "</a></li>";
				}
			}
				
			if(pm.next)
				str += "<li> <a onclick='getRestList("+(pm.endPage+1)+")'> &gt;</a></li>";
				
			str +="</ul>"
			document.getElementById("rest_page").innerHTML = str;	
		}
		
		getRestList(1);
	</script>
	
</div>

<%@include file="./include/footer.jsp" %>

 