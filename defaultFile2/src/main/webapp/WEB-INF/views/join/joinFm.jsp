<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>

<script>
$(function(){
	$("#boardViewNum").change(function(){
		var viewNum = $("#boardViewNum option:selected").val();
		location.href= "/board?viewNum="+ viewNum;
	});
	
	//id로 select 선택하고 value가 postNum  값인 option 선택
	$("#boardViewNum").val(${postNum}).prop("selected", true);
	
})


</script>
</head>
<body>
	<a href="/boardInsertFm">글쓰기</a>
	<div class="board-viewNum" style="float:right; width: 1513px;">
     	<select id="boardViewNum" name="boardViewNum">
     		<option value="5">5개</option>
     		<option value="10">10개</option>
     		<option value="20">20개</option>
     		<option value="30">30개</option>
     	</select>
     </div>
	<table>
		<c:forEach var="list2" items="${list}">
				<tr>
					<td>${list2.getIdx()}</td>
					<td>${list2.getUser_id()}</td>
					<td><a href="/boardRead?idx=${list2.getIdx()}">${list2.getTitle()}</a></td>
					<td>${list2.getRegdate()}</td>
				</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${prev}">
		 <span>[ <a href="/board?num=${startPageNum - 1}">이전</a> ]</span>
		</c:if>
		
		<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
		  <span>
		  	<c:if test="${select != num}">
			  	 <a href="/board?num=${num}&viewNum=${postNum}">${num}</a>
		  	</c:if>
		  	<c:if test="${select == num}">
			  	 <b>${num}</b>
		  	</c:if>
		 </span>
		</c:forEach>
		
		<c:if test="${next}">
		 <span>[ <a href="/board?num=${endPageNum + 1}">다음</a> ]</span>
		</c:if>
	</div>

</body>
</html>