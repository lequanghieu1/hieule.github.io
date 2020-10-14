<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>product list</title>
</head>
<body>

	<div class="page-container">

		<div class="left-content">

			<div class="mother-grid-inner">
				<div class="inner-block">
					<div class="inbox">
						<h2>Product Manage</h2>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">
											<div class="btn btn_1 btn-default mrg5R">
												<a href="<c:url value="/admin/product-manager/add"/>"><i
													class="fa fa-plus"> </i></a>
											</div>
											<div class="clearfix"></div>
										</div>
										<div class="float-right">
											<span class="text-muted m-r-sm"> Pages</span>
											<div class="btn-group">
												<a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
												<c:set var="countList" value="${productManager.size()}" />
												<c:if test="${productManager.size()>4 }">
													<c:set var="countList" value="4" />
												</c:if>
												<c:forEach var="i" begin="1"
													end="${paginateInfo.totalPage }">
													<a class="btn btn-default"
														href="${pageContext.request.contextPath}/admin/product-manager/${i}.html"><c:out
															value="${i}" /></a>
												</c:forEach>
												<a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									
 <!-- 
<div class="container">
  <h2>Modal Example</h2>
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="open()">Open Modal</button>

   Modal 
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
       Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div> 
<script>
function open(){
	alert("haha");
$('#myModal').modal('show');
}
    
</script> -->
					

									<table class="table tab-border">
										<tbody>
											<tr>
												<td class="hidden-xs"><b>Product</b></td>
												<td class="hidden-xs" style="width: 200px;"><b>Category</b>
												</td>
												<td style="text-align: right; width: 150px;"><b>Price</b>
												</td>
												<td style="text-align: right; width: 150px;"><b>Title</b>
												</td>
												<td style="text-align: center; width: 150px;"><b>Option</b>
												</td>
											</tr>
											<c:forEach var="item" items="${ManagerPagi}">
												<tr class="unread checked">
													<td class="hidden-xs">${item.name}</td>
													<td class="hidden-xs"><c:forEach var="c"
															items="${listCategory}">
															<c:if test="${item.id_categories == c.id}">						
																${c.name}</c:if>
														</c:forEach></td>

													<td style="text-align: right; width: 150px;">
														$${item.price}</td>
													<td style="text-align: right; width: 150px;">
														${item.title}</td>
													<td style="text-align: center; width: 150px;"><a
														class="btn btn-default"
														href="${pageContext.request.contextPath}/admin/product-manager/edit/${item.id}.html"><i
															class="fa fa-edit"></i></a> <a class="btn btn-default"
														href="${pageContext.request.contextPath}/admin/product-manager/remove/${item.id}"><i
															class="fa fa-remove"></i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>

						<div class="clearfix"></div>
					</div>
				</div>


			</div>

		</div>


	</div>
	

</body>
</html>
