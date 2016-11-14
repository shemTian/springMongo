<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <jsp:include page="../common/header.jsp"></jsp:include>
  <link href="<%=request.getContextPath() %>/resource/css/sign/signin.css" rel="stylesheet">


    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">注册 </h2>
        <input type="email" class="form-control" placeholder="用户名" required autofocus name="userName">
        <input type="password" class="form-control" placeholder="密码" required name="password1">
        <input type="password" class="form-control" placeholder="密码" required name="password2">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
      </form>
      <h4 class="text-center">已有账号<a href="<%=request.getContextPath() %>/signIn.do">登录</a>    |  忘记密码</h4>
    </div>

</html>
