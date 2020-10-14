<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<div class="sidebar-menu">
		  	<div class="logo"> <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
			      <!--<img id="logo" src="" alt="Logo"/>--> 
			  </a> </div>		  
		    <div class="menu">
		      <ul id="menu" >
		        <li id="menu-home" ><a href="http://localhost:8080/Weapon/admin"><i class="fa fa-tachometer"></i><span>Home</span></a></li>
		        <li id="menu-comunicacao" ><a href="<c:url value="/admin/user-manager"/>"><i class="fa fa-book nav_icon"></i><span>Users</span></a>
		        </li>
		        <li id="menu-academico" ><a href="<c:url value="/admin/product-manager"/>"><i class="fa fa-file-text"></i><span>Products</span></a>
		        </li>
		        <li><a href="<c:url value="/admin/order-manager"/>"><i class="fa fa-shopping-cart"></i><span>Order</span></a>
		         </li>
		        <li><a href="<c:url value="/admin/report"/>"><i class="fa fa-bar-chart"></i><span>Report</span></a></li>
		        <li><a href="#"><i class="fa fa-envelope"></i><span>Mailbox</span><span class="fa fa-angle-right" style="float: right"></span></a>
		        	 <ul id="menu-academico-sub" >
			            <li id="menu-academico-avaliacoes" ><a href="inbox.html">Inbox</a></li>
			            <li id="menu-academico-boletim" ><a href="inbox-details.html">Compose email</a></li>
		             </ul>
		        </li>
		         <li><a href="#"><i class="fa fa-cog"></i><span>System</span><span class="fa fa-angle-right" style="float: right"></span></a>
		         	 <ul id="menu-academico-sub" >
			            <li id="menu-academico-avaliacoes" ><a href="404.html">404</a></li>
			            <li id="menu-academico-boletim" ><a href="blank.html">Blank</a></li>
		             </ul>
		         </li>
		         
		      </ul>
		    </div>
	 </div>