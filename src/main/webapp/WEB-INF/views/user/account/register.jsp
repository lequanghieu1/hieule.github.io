<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<head>

<title>Đăng ký tài khoản</title>
</head>
<body>
<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
				<ul class="nav nav-list">
				
				<c:forEach var="item" items="${ categories }">
					<li><a href='<c:url value="/product/${item.id }" />'><span
							class="icon-chevron-right"></span>${ item.name }</a></li>	
					</c:forEach> 
								
					<li><a class="totalInCart" href="<c:url value="/gio-hang"/>"><strong>Total
								Amount <span class="badge badge-success pull-right"
								style="line-height: 18px;">£${ TotalPriceCart }
</span>
						</strong></a></li>
				</ul>
			</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a href="#"><img src="assets/img/paypal.jpg" alt="payment method paypal"></a></div>
			
			<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/bootstrap-ecommerce-templates.png" alt="bootstrap ecommerce templates">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/shopping-cart-template.png" alt="shopping cart template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/bootstrap-template.png" alt="bootstrap template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
		  </ul>

	</div>
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	<h3> Người dùng ${statusLogin }</h3>	
	<hr class="soft"/>
	
	<div class="row">
		<div class="span4">
			<div class="well">
			<h5>Đăng ký</h5><br/>
			<form:form action="dang-ky" method="POST" modelAttribute="user">
			  <div class="control-group">
				<label class="control-label" for="inputEmail">E-mail</label>
				<div class="controls">
				  <form:input type="email" placeholder="Nhập Email" class="span3" path="user" />  
				</div>
				<label class="control-label" for="inputEmail">Mật khẩu</label>
				<div class="controls">
				  <form:input type="password" class="span3" placeholder="Nhập mật khẩu" path="password" />
				</div>
				<label class="control-label" for="inputEmail">Họ và Tên</label>
				<div class="controls">
				  <form:input type="text" class="span3" placeholder="Nhập họ tên" path="displayname" />
				</div>
				<label class="control-label" for="inputEmail">Địa chỉ</label>
				<div class="controls">
				  <form:input type="text" class="span3" placeholder="Nhập địa chỉ" path="address" />
				</div>
			  </div>
			  <div class="controls">
			  <button type="submit" class="btn btn-success">Đăng ký</button>
			  </div>
			</form:form>
		</div>
		</div>
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
			<h5>Đăng nhập </h5></br>
			<form:form action="dang-nhap" method="POST" modelAttribute="user">
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Tài khoản</label>
				<div class="controls">
				  <form:input type="email" placeholder="Nhập Email" class="span3" path="user" />
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="inputPassword">Mật Khẩu</label>
				<div class="controls">
				  <form:input type="password" class="span3" placeholder="Nhập mật khẩu" path="password" />
				</div>
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="btn btn-primary">Đăng nhập</button> <a href="#">Quên mật khẩu</a>
				</div>
			  </div>
			</form:form>
		</div>
		</div>
	</div>	
	
</div>
</div>
</body>
