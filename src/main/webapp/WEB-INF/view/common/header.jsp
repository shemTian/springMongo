<%@ page language="java" contentType="text/html; charset=utf-8"%>

<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="description" content="">
   <meta name="author" content="">
   <link rel="icon" href="<%=request.getContextPath() %>/favicon.png">
   
   <title>
   	Metro·Share
   </title>
   <!-- Bootstrap core CSS -->
   <link href="<%=request.getContextPath() %>/resource/css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/jquery/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resource/js/bootstrap/bootstrap.min.js"></script>
	
	<!-- navbar-fixed-top类的导航栏固定头部时候  body必须保留50px内边距 navbar-static-top不用设置body的内边距， nav和body直接回有50px的空白行 
	<style type="text/css">
    	body{
    		padding: 50px;
    	}
    </style>
    
    -->
</head>
<!-- navbar-inverse 黑底白字 -->
<nav class="navbar navbar-default navbar-static-top" role="navigation">
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
       	<form class="navbar-form navbar-right" role="search" action="<%=request.getContextPath() %>/person/register.do">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="搜索">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>
         <ul class="nav navbar-nav navbar-right">
           <li><a href="<%=request.getContextPath() %>/person/signIn.do"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
           <li><a href="<%=request.getContextPath() %>/person/register.do"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
         </ul>
       </div>
  </div>
</nav>