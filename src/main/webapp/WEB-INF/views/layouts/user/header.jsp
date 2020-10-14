<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
	
<header id="header">
<link
	href="<c:url value="assets/user/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet">
	
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="<c:url value="/trang-chu"/>"><span>Weapon Shop</span> <img width="120px"
					src="<c:url value="/assets/user/img/logos.png"/>"
					alt="weapon shop"> </a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper">
				<h1 class="dotmark">
					<i class="icon-cut"></i> Our shop specializes in selling weapons of all kinds
				</h1>			
			</div>
		</div>
		<div class="span4 alignR">
			<p>
				<br> <strong> Support (24/7) : 0800 1234 678 </strong><br>
				<br>
			</p>
			<span class="btn btn-mini">[ ${ TotalQuantyCart }  ] <span
				class="icon-shopping-cart"></span></span> <span
				class="btn btn-mini">$</span> <span class="btn btn-primary btn-mini">&pound;</span>
			<span class="btn btn-mini">&euro;</span>
		</div>
	</div>
</header>
<script>
//const haha = document.querySelector('.haha');
//const home = document.querySelector('#1');
//const product = document.querySelector('#4');
//const cart = document.querySelector('#5');
//const post = document.querySelector('#6');
//const contact = document.querySelector('#9');

//product.addEventListener('click',()=>{
	//haha.classList.add('active');
	//alert()
//})

</script>