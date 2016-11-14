<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <jsp:include page="../common/header.jsp"></jsp:include>
  <link href="<%=request.getContextPath() %>/resource/css/sign/signin.css" rel="stylesheet">
  <body>
    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">请登录 </h2>
        <input type="email" class="form-control" placeholder="用户名" required autofocus>
        <input type="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
      <h4 class="text-center"><a href="<%=request.getContextPath() %>/person/regist.do">注册</a>    |  忘记密码</h4>
    </div>
 
  </body>
</html>
