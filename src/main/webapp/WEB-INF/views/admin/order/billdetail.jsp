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
						<h2>Bill details</h2>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									
										<div class="float-right">
											<div class="clearfix"></div>
										</div>
									</div>
									<table class="table tab-border">
										<tbody>
											<tr>
												<td class="hidden-xs"><b>Account</b></td>
												<td class="hidden-xs" style="width: 200px;"><b>Product</b>
												</td>
												<td style="text-align: right; width: 150px;"><b>Quanty</b>
												</td>
												<td style="text-align: right; width: 150px;"><b>Total</b>
												</td>
											</tr>
											<c:forEach var="item" items="${bill}">
												<tr class="unread checked">
												<td class="hidden-xs"><c:forEach var="c"
															items="${bills}">
															<c:if test="${item.id_bill == c.id}">						
																${c.user}</c:if>
														</c:forEach></td>
														<td class="hidden-xs"><c:forEach var="c"
															items="${listProduct}">
															<c:if test="${item.id_product == c.id}">						
																${c.name}</c:if>
														</c:forEach></td>
														<td style="text-align: right; width: 150px;">
														${item.quanty}</td>
														<td style="text-align: right; width: 150px;">
														${item.total}</td>				
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
