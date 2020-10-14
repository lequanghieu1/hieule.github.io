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
						<h2>Bill Manage</h2>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">
											
											<div class="clearfix"></div>
										</div>
										<div class="float-right">
											<span class="text-muted m-r-sm"> Pages</span>
											<div class="btn-group">
												<a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
												<c:set var="countList" value="${billManager.size()}" />
												<c:if test="${billManager.size()>4 }">
													<c:set var="countList" value="4" />
												</c:if>
												<c:forEach var="i" begin="1"
													end="${paginateInfo.totalPage }">
													<a class="btn btn-default"
														href="${pageContext.request.contextPath}/admin/order-manager/${i}.html"><c:out
															value="${i}" /></a>
												</c:forEach>
												<a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<table class="table tab-border">
										<tbody>
											<tr>
												<td class="hidden-xs"><b>Account</b></td>
												<td class="hidden-xs" style="width: 200px;"><b>Phone</b>
												</td>
												<td style="text-align: right; width: 150px;"><b>Address</b>
												</td>
												<td style="text-align: right; width: 150px;"><b>Total</b>
												</td>
												<td style="text-align: center; width: 150px;"><b>Quanty</b>
												</td>
												<td style="text-align: center; width: 150px;"><b>Note</b>
												</td>
											</tr>
											<c:forEach var="item" items="${ManagerPagi}">
												<tr class="unread checked">
													<td style="text-align: right; width: 150px;">
														${item.user}</td>
													<td style="text-align: right; width: 150px;">
														${item.phone}</td>
														<td style="text-align: right; width: 150px;">
														${item.address}</td>
														<td style="text-align: right; width: 150px;">
														$${item.total}</td>
														<td style="text-align: right; width: 150px;">
														${item.quanty}</td>
														<td style="text-align: right; width: 150px;">
														${item.note}</td>
													<td style="text-align: center; width: 150px;"><a
														class="btn btn-primary"
														href="${pageContext.request.contextPath}/admin/order-manager/details/${item.id}.html">View details</a></td>
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
