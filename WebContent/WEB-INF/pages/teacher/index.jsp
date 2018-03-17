<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<a href="/springmvc/teacher/add">新增</a>
	</p>
	<table>
		<tr>
			<td>姓名</td>
			<td>年龄</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${ teachers}" var="teacher">
			<tr>
				<td>${ teacher.getId()}</td>
				<td>${ teacher.getName()}</td>

				<td>${ teacher.getAddress()}</td>
				<td><a href="/springmvc/teacher/delete?id=${ teacher.getId()}">删除</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>