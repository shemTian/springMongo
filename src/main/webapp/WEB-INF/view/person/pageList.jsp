<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr> <td>ID</td><td>姓名</td><td>年龄</td><td>性别</td></tr>
		<c:forEach items="${personList }" var="person">
			<tr>
				<td>${person.id }</td>
				<td>${person.name }</td>
				<td>${person.age }</td>
				<td>${person.gender }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>