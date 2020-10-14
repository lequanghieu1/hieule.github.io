<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>   
<head>
<title>Giỏ hàng</title>
</head>
<body>
<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Giỏ hàng</li>
    </ul>
	<div class="well well-small">
	<span class="badge badge-success">${statuscheckout }</span>

		<h1>Giỏ hàng <small class="pull-right"> ${ TotalQuantyCart } Sản phẩm trong giỏ hàng </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Hình ảnh</th>
                  <th>Mô tả</th>
                  <th>Giá bán</th>
                  <th>Số lượng </th>
                
                  <th>Xóa </th>
                  <th>Tổng tiền</th>
				</tr>
              </thead>
              <tbody>

				<c:forEach var="item" items="${ Cart }">
					<tr>
	                  <td><img width="100" src="<c:url value="/assets/user/img/${ item.value.product.img }"/>" alt=""></td>
	                  <td>${ item.value.product.title }</td>
	                  <td>£ <fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = " ${ item.value.product.price }" /> </td>
	                  <td>
						<input type="number" min="0" max="1000" class="span1" style="max-width:34px" placeholder="1" id="quanty-cart-${item.key }" size="16" type="text" value="${ item.value.quanty }">
						<button data-id="${ item.key }" class="btn btn-mini btn-success edit-cart" type="button">
	                  		<span class="icon-edit"></span>
	                  	</button>
					  </td>
	                  <td>
	                  	<a href="<c:url value="/DeleteCart/${ item.key }"/>" class="btn btn-mini btn-danger" type="button">
	                  		<span class="icon-remove"></span>
	                  	</a>
	                  </td>
	                  <td>£<fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = " ${ item.value.totalPrice }" />  </td>
         
	                </tr>
				</c:forEach>

				</tbody>
			
	<!-- 			<td> 
	 		<form class="form-inline">
				  <label style="min-width:159px"> VOUCHERS Code: </label> 
				<input type="text" class="input-medium" placeholder="CODE">
				<p id="demo"></p>
				<button type="submit" data-id="${ TotalPriceCart }"class="shopBtn" id="btn"> ADD</button>
				
				</form>
				</td>-->
            </table><br/>
	<a href="<c:url value="/trang-chu"/>" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Tiếp tục mua sắm </a>
	<c:choose>
	<c:when test="${TotalQuantyCart==null || TotalQuantyCart==0  }"><a href="#" id="fail"class="btn btn-danger pull-right">Giỏ hàng trống <span class="icon-arrow-up"></span></a></c:when>
	<c:when test="${TotalQuantyCart!=0 }"><a href="<c:url value="/checkout"/>" class="shopBtn btn-large pull-right">Thanh toán <span class="icon-arrow-right"></span></a></c:when>
	
	</c:choose>


</div>
</div>
</div>
<content tag="script">

<script>
$(".edit-cart").on("click",function(){
	var id=$(this).data("id");
	var quanty=$("#quanty-cart-"+id).val();
	window.location="EditCart/"+id+"/"+quanty;
});
</script>
<script>
var TotalPriceCart=$(this).data("id").val();
document.getElementById("btn").addEventListener("click", function() {
	myFunction(TotalPriceCart);
	});
function myFunction(a) {
	  var result = a - a*0.1;
	  document.getElementById("demo").innerHTML = "6";
	  alert("haha");
	}
</script>
</script>
</content>
</body> 