<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.fatih.blogproject.model.NotificationMessage"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>



<title>my blogging system</title>



<!-- Custom styles for this template -->

<link href="${pageContext.request.contextPath}/resources/css/blog.css"
	rel="stylesheet" />

<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/blog-scripts.js"></script>


</head>

<body>
	
	<%
		String username=(String)session.getAttribute("usernameSessionKey");
		
		pageContext.setAttribute("loggedUser", username);
	%>

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav"><a class="blog-nav-item active"
				href="${pageContext.request.contextPath}">Anasayfa</a>
				<a class="blog-nav-item" href="#">Yazı Yaz</a> <a
				class="blog-nav-item" href="#">Blog Yönetim</a>
				<div class="pull-right"><b>Hoşgeldin <c:out value="${loggedUser}" /></b> <a
					class="blog-nav-item " href="${pageContext.request.contextPath}/logout">Çıkış</a></div></nav>
	</div>
</div>

	<div class="container">

		<div class="blog-header">
			<h1 class="blog-title">${title}</h1>
			<p class="lead blog-description">${description }</p>
	</div>

		<div class="row">
			<div class="col-sm-7">
			
			<%
		
			List<NotificationMessage> notifyMessages = (List<NotificationMessage>)session.getAttribute("siteNotificationMessages");
			pageContext.setAttribute("messages", notifyMessages);
			
			%> 
			
			<c:forEach items="${messages }" var="message">
					<div id="messages">
					
						<c:if test="${message.getType()=='ERROR' }">
							
							<span class="error"> 
					
								<c:out value="${message.getType() }" />:
							 
								<c:out value="${message.getText() }" />
						
							</span>
						
						</c:if>
						
						<c:if test="${message.getType()=='INFO' }">
							
							<span class="info"> 
					
								<c:out value="${message.getType() }" />:
							 
								<c:out value="${message.getText() }" />
						
							</span>
						
						</c:if>
					
					</div>
				
				<%
					request.getSession().removeAttribute("siteNotificationMessages");
				%>
				</c:forEach>




		</div>

	</div>

		<div class="row">

			 <div class="col-sm-7 blog-main"><form:form id="createForm" method="POST"
					modelAttribute="createForm"
				>
					<table>
					
					<tr>
							<td>
							<form:label path="title">Yazı Başlığı:</form:label><br/>
							<form:input path="title" /> 
							<font color="red">
								<form:errors path="title" delimiter=" ," />
							</font>
							</td>
							
					</tr>
					
					<tr>
							<td>
								<form:label path="body">Yazı içeriği</form:label><br/>
								<form:textarea path="body" rows="5" cols="80"/> 
								<font color="red">
									<form:errors path="body" delimiter=" ," />
								</font>
							</td>
							
					</tr>
					
					<tr>
							<td>
							<form:label path="category">Yeni Kategori</form:label><br/>
							<form:input path="category" /> 
							<font color="red">
								<form:errors path="category" delimiter=" ," />
							</font>
							</td>
							
					</tr>
					
						<tr>
							<td>
							<form:label path="draft">Taslak Olarak İşaretle</form:label>
								<form:checkbox path="draft" /> <font color="red">
									<form:errors path="draft" delimiter=" ," />
							</font>
							</td>
						
						</tr>
					
					
						
					
					
					
					
					
						<tr>
							<td colspan="2"><input type="submit" value="Yayınla" /></td>
							<td></td>
							<td></td>
					</tr>
					</table>
				</form:form></div>

			<div class="col-sm-4 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>About</h4>
					<p>blog yönetim sistemi</p>
			</div>
				
				<div class="sidebar-module">
					<h4>Sosyal Medya</h4>
					<ol class="list-unstyled">
						<li><a href="#">GitHub</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Facebook</a></li>
				</ol>
			</div>
		</div> <!-- /.blog-sidebar -->

	</div> <!-- /.row -->

</div>
	<!-- /.container -->

	<footer class="blog-footer">
		<p>created by fatih</p>
		<p>Tarih: <%=new java.util.Date()%></p> <a href="#">Yukarı dön</a>

</footer>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>


</body>
</html>
