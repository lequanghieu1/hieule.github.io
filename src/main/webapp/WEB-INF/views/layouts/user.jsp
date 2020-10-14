
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="WeaponShop" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/assets/user/css/bootstrap.css" />"
	rel="stylesheet" />
	
<!-- Customize styles -->
<link href="<c:url value="/assets/user/style.css"/>" rel="stylesheet" />
<!-- font awesome styles -->
<link
	href="<c:url value="assets/user/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet">

<!-- Favicons -->
<link href="<c:url value="assets/user/ico/favicon.png"/>"
	rel="shortcut icon">

	<decorator:head/>
</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a>
					<a href="#"><span class="icon-facebook"></span></a>
					<a href="#"><span class="icon-youtube"></span></a>
					<a href="#"><span class="icon-tumblr"></span></a>
					</div>
					<a  class="menu " href="<c:url value="/trang-chu"/>"> <span class="icon-home"></span>
						Trang chủ</a> 
						<c:if test="${not empty LoginInfo }">
						<a class="menu" href="#"><span class="icon-user"></span>${LoginInfo.displayname }</a>
						<a class="menu" href="<c:url value="/dang-xuat"/>"><span class="icon-edit"></span>Đăng xuất</a>
						</c:if>
						<c:if test="${empty LoginInfo }">
						<a class="menu" id="dk"href="<c:url value="/dang-ky"/>"><span  class="icon-edit"></span>Đăng ký</a>
						</c:if>
						  <a class="menu" href="contact.html"><span class="icon-envelope"></span>
						Hỗ trợ</a>
								<ul class="nav pull-right">
						<c:if test="${empty LoginInfo }">
						<a class="menu" href="<c:url value="/dang-nhap"/>">
									Đăng nhập </a>
									
						</c:if>
						<c:if test="${not empty LoginInfo }">
						<li class="menu"><a href="#">${LoginInfo.displayname }<b class="caret"></b></a></li>
						</c:if>
							
						</ul >
						 <a class="menu" href="<c:url value="/gio-hang"/>"><span
						class="icon-shopping-cart"></span> ${ TotalQuantyCart }Sản Phẩm - <span
						class="badge badge-warning">£${ TotalPriceCart }</span></a>
				</div>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
		<%@include file="/WEB-INF/views/layouts/user/header.jsp" %>
		<decorator:body/>
		<%@include file="/WEB-INF/views/layouts/user/footer.jsp" %>
	</div>
	<!-- /container -->

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img
					src="<c:url value="/assets/user/img/maestro.png"/>" alt="payment"></a>
				<a href="#"><img src="<c:url value="/assets/user/img/mc.png"/>"
					alt="payment"></a> <a href="#"><img
					src="<c:url value="/assets/user/img/pp.png"/>" alt="payment"></a>
				<a href="#"><img
					src="<c:url value="/assets/user/img/visa.png"/>" alt="payment"></a>
				<a href="#"><img
					src="<c:url value="/assets/user/img/disc.png"/>" alt="payment"></a>
			</p>
			<span>Since for&copy; 2020<br> Powered by HieuLe
			</span>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/assets/user/js/jquery.js" />"></script>
	<script src="<c:url value="/assets/user/js/bootstrap.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.easing-1.3.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
	<script src="<c:url value="/assets/user/js/shop.js" />"></script>
	<decorator:getProperty property="page.script"></decorator:getProperty>
	<script>
	console.log("re render")
		const pathName = window.location.pathname.split("/")[2];
		const menu = document.querySelectorAll('.menu');
		if(pathName === "trang-chu") document.querySelectorAll('.menu')[0].className = "active"
		if(pathName === "dang-ky") document.querySelectorAll('.menu')[1].className = "active"
		if(pathName === "contact.html") document.querySelectorAll('.menu')[2].className = "active"
		if(pathName === "gio-hang") document.querySelectorAll('.menu')[4].className = "active"
			if(pathName === "dang-nhap") document.querySelectorAll('.menu')[3].className = "active"
		
	</script>
</body>
</html>