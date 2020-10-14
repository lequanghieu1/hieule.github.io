<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sản Phẩm</title>
<style>
.pagination {
	  display: flex;
    	justify-content: center;
	}
	.pagination a {
	  color: black;
	  float: left;
	  padding: 8px 16px;
	  text-decoration: none;
	  transition: background-color .3s;
	  border: 1px solid #ddd;
	}
	.pagination a.active {
	  background-color: #4CAF50;
	  color: white;
	  border: 1px solid #4CAF50;
	}
	.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
</head>
<body>
	<h1>${ AllProductsByid.size() }</h1>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;">Danh sách sản phẩm</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>

		<c:if test="${ ProductsPaginate.size() > 0  }">
			<div class="row-fluid">
				<ul class="thumbnails">
					<c:forEach var="item" items="${ProductsPaginate }" varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="product_details.html" class="overlay"></a> <a
									class="zoomTool" href="<c:url value="/product-details/${item.id }"/>"
									title="add to cart"><span class="icon-search"></span> QUICK
									VIEW</a> <a href="<c:url value="/product-details/${item.id }"/>"><img
									src="<c:url value="/assets/user/img/${item.img }"/>" alt=""></a>
								<div class="caption cntr">
									<p>${item.name }</p>
									<p>
										<strong>£<fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = " ${item.price }" /> </strong>
									</p>
									<h4>
										<a class="btn btn-primary" href="<c:url value="/AddCart/${item.id }"/>" title="add to cart"> Add to
											cart </a>
									</h4>
									<div class="actionList">
										<a class="pull-left" href="#">Add to Wish List </a> <a
											class="pull-left" href="#"> Add to Compare </a>
									</div>
									<br class="clr">
								</div>
							</div>
						</li>
						<c:if
							test="${(loop.index+1)%3 == 0||(loop.index+1) == ProductsPaginate.size() }">
				</ul>
			</div>
			<c:if test="${loop.index+1 < ProductsPaginate.size()}">
				<div class="row-fluid">
					<ul class="thumbnails">
			</c:if>
		</c:if>
		</c:forEach>
		</c:if>

	</div>
	
	<div class="pagination">
	<c:forEach var="item" begin="1" end="${paginateInfo.totalPage }" varStatus="loop">
	<c:if test="${ loop.index == paginateInfo.currentPage  }">
	<a href="<c:url value="/product/${idCategory }/${loop.index }"/>" class="active">${loop.index }</a>
	</c:if>
	<c:if test="${ loop.index != paginateInfo.currentPage  }">
	<a href="<c:url value="/product/${idCategory }/${loop.index }"/>" >${loop.index }</a>
	</c:if>
  </c:forEach>
</div>
</body>
</html>