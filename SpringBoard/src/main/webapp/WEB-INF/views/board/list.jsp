<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>게시글 목록</title>
</head>
<body>
<h1>
	게시글 목록
</h1>
	<p><form>
			<input type="text" placeholder="검색" name="keyword" value="${keyword}">
			<input type="submit" value="검색">
		</form>
	</p>
	<table>
		<thead>
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>닉네임</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${data}">
				<tr>
					<td>${row.board_id}</td>
					<td><a href="/detail?boardId=${row.board_id}">${row.title}</a></td>
					<td>${row.nickname}</td>
					<td>${row.view }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="/create">생성</a></p>
		
	
</body>
</html>

