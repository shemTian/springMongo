<%@ page language="java" contentType="text/html; charset=utf-8"%>

<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="description" content="">
   <meta name="author" content="">
   <link rel="icon" href="favicon.png">

   <title>
   	Metro·Share
   </title>
   <!-- Bootstrap core CSS -->
   <link href="<%=request.getContextPath() %>/resource/css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/jquery/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/bootstrap/bootstrap.min.js"></script>
</head>

<nav class="navbar navbar-default" role="navigation">
  <div class="container">
  	<div class="navbar-header">
  		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#navbar">
			<span class="sr-only">切换导航</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
         	<a class="navbar-brand" href="#">Metro</a>
       </div>
       <div id="navbar" class="navbar-collapse collapse">
         <ul class="nav navbar-nav navbar-right">
           <li><a href="<%=request.getContextPath() %>/person/signIn.do">登录</a></li>
           <li><a href="<%=request.getContextPath() %>/person/register.do">注册</a></li>
         </ul>
       </div>
  </div>
</nav>