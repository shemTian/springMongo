<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>regist</title>
</head>
<body>
	<form action="newPerson.do" method="get">
		姓名：<input type="text" name="name"/><br>
		年龄：<input type="text" name="age"/><br>
		性别：<select name="gender">
				<option value="male">男</option>
				<option value="female">女</option>
			</select><br>
		<input type="submit" value="提交"> <input type="reset" value="重置">
	</form>
</body>
</html>