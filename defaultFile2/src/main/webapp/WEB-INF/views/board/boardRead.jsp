<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/boardInsert" method="POST">
		<table>
			<tr>
				<th>작성자</th>
				<td>${listView.user_id}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${listView.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${listView.cont}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${listView.regdate}</td>
			</tr>
			<tr>
				<td>
					<a href="/boardInsertFm">글쓰기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>