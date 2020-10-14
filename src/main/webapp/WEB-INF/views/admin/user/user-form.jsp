
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user form</title>
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
                                <h2>User Details</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        <div class="inbox-details-heading">
                                        ALL USERS
                                    </div>
                                    <div class="inbox-details-body">
                                        <div class="alert alert-info">
                                            Please fill details to send a new message
                                        </div>
                                        <form:form  method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/admin/user-manager/save">
                                            <label>Role</label>
                                            <form:select path="id_role">    
                                                <option value="-1">Select a role</option>
                                                <c:forEach var="c" items="${listRole}">
                                                    <option value="${c.id}" ${user.id_role == c.id ? 'selected=""' : ''}>${c.name}</option>
                                                </c:forEach>
                                            </form:select><br />
                                            <label>Email</label>
                                            <form:input path="user"  />
                                            <label >Displayname</label>
                                            <form:input path="displayname"/>
                                            <label class="visible">Name</label>
                                            <form:input path="id"  class="visible"/>
                                            <label>Address</label>
                                            <form:input path="address"  />
                                            <label>Password</label>
                                            <form:input path="password" />
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

