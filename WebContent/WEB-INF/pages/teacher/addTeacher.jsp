<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/springmvc/teacher/add" method="post">
		<table>

			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>id：</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>

</body>
</html>