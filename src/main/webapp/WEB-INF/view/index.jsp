<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<jsp:include page="common/header.jsp"></jsp:include>
  	<div id="myCarousel" class="carousel slide">
	    <!-- 轮播（Carousel）指标 -->
	    <ol class="carousel-indicators">
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	    </ol>   
	    <!-- 轮播（Carousel）项目 -->
	    <div class="carousel-inner">
	        <div class="item active">
	            <img src="<%=request.getContextPath() %>/resource/image/homeBanner1.jpg" alt="First slide">
	        </div>
	        <div class="item">
	            <img src="<%=request.getContextPath() %>/resource/image/homeBanner2.jpg" alt="Second slide">
	        </div>
	        <div class="item">
	            <img src="<%=request.getContextPath() %>/resource/image/homeBanner2.jpg" alt="Third slide">
	        </div>
	    </div>
	    <!-- 轮播（Carousel）导航 -->
	    <a class="carousel-control left" href="#myCarousel" 
	        data-slide="prev">&lsaquo;
	    </a>
	    <a class="carousel-control right" href="#myCarousel" 
	        data-slide="next">&rsaquo;
	    </a>
	</div>
</html>
