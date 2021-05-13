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
				<td>
					<input type="text" name="user_id">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="cont"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="글쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>