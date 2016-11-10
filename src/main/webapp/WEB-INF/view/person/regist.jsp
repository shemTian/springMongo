<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/resource/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/resource/css/sign/signin.css" rel="stylesheet">

  </head>

  <body>

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
      <h4 class="text-center">已有账号<a href="signIn.do">登录</a>    |  忘记密码</h4>
    </div>

  </body>
</html>
