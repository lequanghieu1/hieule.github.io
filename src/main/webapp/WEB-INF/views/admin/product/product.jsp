
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product form</title>
    </head>
    <body>

        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">
                <div class="alert alert-success">
                
								<a href="#" class="close" data-dismiss="success"
									aria-label="close">&times;</a> <strong>${status }</strong>
							</div>
                
                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Product Details</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        <div class="inbox-details-heading">
                                        ${product.name}
                                    </div>
                                    <div class="inbox-details-body">
                                        <div class="alert alert-info">
                                            Please fill details to send a new message
                                        </div>
                                        <form:form  method="POST" modelAttribute="pro" action="${pageContext.request.contextPath}/admin/product-manager/save">
                                            <label>Category</label>
                                            <form:select path="id_categories">    
                                                <option value="-1">Select a type</option>
                                                <c:forEach var="c" items="${listCategory}">
                                                    <option value="${c.id}" ${product.id_categories == c.id ? 'selected=""' : ''}>${c.name}</option>
                                                </c:forEach>
                                            </form:select><br />
                                            <label>Name</label>
                                            <form:input path="name"  />
                                            <label class="visible">Name</label>
                                            <form:input path="id"  class="visible"/>
                                            <label>Price</label>
                                            <form:input path="price"  />
                                            <label>Title</label>
                                            <form:input path="title" />
                                            <label>Image</label>
                                            <form:input path="img" />
                                            <div class="form-group">
                                                <div class="btn btn-default btn-file">
                                                    <i class="fa fa-paperclip"> </i> Attachment
                                                    <input type="file" name="attachment">
                                                </div>
                                            </div>
                                            <input type="submit"> 
                                        </form:form>
                                    </div>
                                </div>
                            </div>

                            <div class="clearfix"> </div>     
                        </div>
                    </div>
                    </div>
                </div>
        </div>

    </body>

