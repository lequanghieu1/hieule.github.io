<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<head>

<title>Thanh toán</title>
</head>
<body>
<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fashion</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Watches</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fine Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fashion Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Engagement & Wedding</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Men's Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Vintage & Antique</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Loose Diamonds </a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Loose Beads</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>See All Jewelry & Watches</a></li>
		<li style="border:0"> &nbsp;</li>
		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
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

	</div>
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	<h3> Người dùng</h3>	
	<hr class="soft"/>
	
	<div class="row">
		<div class="span4">
			<div class="well">
			<br/>
			<form:form action="checkout" method="post" modelAttribute="bills" class="form-horizontal">
			<h3>Thanh toán </h3>
		<div class="control-group">
			<label class="control-label">Họ tên<sup>*</sup></label>
			<div class="controls">
			  <form:input type="text" placeholder="Nhập họ tên" class="span3" path="displayname" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Email<sup>*</sup></label>
			<div class="controls">
			  <form:input type="email" placeholder="Nhập Email" class="span3" path="user" />
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label">Số Điện Thoại<sup>*</sup></label>
			<div class="controls">
			  <form:input type="text" placeholder="Nhập số điện thoại" class="span3" path="phone" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Địa chỉ <sup>*</sup></label>
			<div class="controls">
			  <form:textarea path="address" rows="5" col="30"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Ghi chú <sup>*</sup></label>
			<div class="controls">
			  <form:textarea path="note" rows="5" col="30"/>
			</div>
		</div>
	<div class="control-group">
		<div class="controls">
		 <input type="submit" name="submitAccount" value="Đặt hàng" class="btn btn-primary">
		</div>
	</div>
	</form:form>
	
		</div>
		</div>
		<div class="span1"> &nbsp;</div>
		
	
	
</div>
</div>
</body>
