<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
	background: url("${contextPath}/resources/img/002.jpg")
}
</style>
</head>
<body>
	<h2>恭喜，项目搭建成功</h2>
<p> <a href="/springmvc/add">新增人员</a>  </p>
	<table>
		<tr>
			<td>姓名</td>
			<td>年龄</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${ persons}" var="person">
			<tr>
				<td>${ person.getName()}</td>
				<td>${ person.getAge()}</td>
				<td>${ person.getAddress()}</td>
				<td><a href="/springmvc/delete?userId=${ person.getUserId()}">删除</a></td>
			</tr>
		</c:forEach>

	</table>
	
</body>
</html>