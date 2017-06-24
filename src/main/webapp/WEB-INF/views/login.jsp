<%@page import="com.fatih.blogproject.model.NotificationMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AutoBLog</title>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet"
>
<link href="${pageContext.request.contextPath}/resources/css/blog.css"
	rel="stylesheet"
>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet"
/>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js"
	type="text/javascript"
></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
></script>
<script
	src="${pageContext.request.contextPath}/resources/js/blog-scripts.js"
></script>
</head>
<body>

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav">
			<a class="blog-nav-item active" href="${pageContext.request.contextPath}/register">Kayıt Ol</a> 
			<a class="blog-nav-item" href="#">Hakkımızda</a> 
				
			</nav>
	</div>
</div>
	<div class="container">
		<div class="blog-header">
			<h1 class="blog-title">AutoBLog</h1>
			<p class="lead blog-description">Hızlı bir şekilde kişisel blog oluştur.</p>
	</div>
		<div class="row">
			<div class="col-sm-7">
				<%
					List<NotificationMessage> notifyMessages = (List<NotificationMessage>) session
							.getAttribute("siteNotificationMessages");
					pageContext.setAttribute("messages", notifyMessages);
				%> <c:forEach items="${messages }" var="message">
					<div id="messages"><c:if
							test="${message.getType()=='ERROR' }"
						>
							<span class="error"> <c:out value="${message.getType() }" />:
								<c:out value="${message.getText() }" />
							</span>
						</c:if> <c:if test="${message.getType()=='INFO' }">
							<span class="info"> <c:out value="${message.getType() }" />:
								<c:out value="${message.getText() }" />
							</span>
						</c:if></div>
					<%
						request.getSession().removeAttribute("siteNotificationMessages");
					%>
				</c:forEach>
		</div>
	</div>
		<div class="row">
			<div class="col-sm-7 blog-main"><form:form id="loginForm" method="POST"
					modelAttribute="loginForm"
				>
					<table>
						<tr>
							<td><form:label path="username">Kullanıcı Adı:</form:label></td>
							<td><form:input path="username" /> <font color="red">
									<form:errors path="username" delimiter=" ," />
							</font></td>
					</tr>
						<tr>
							<td><form:label path="password">Parola:</form:label></td>
							<td><form:input type="password" path="password" /> <font color="red"><form:errors
										path="password" delimiter=" ,"
									/></font></td>
					</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Giriş" /></td>
							<td></td>
							<td></td>
					</tr>
					</table>
				</form:form></div> <!-- /.blog-main -->
			<div class="col-sm-4 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>About</h4>
					<p>Kişisel blogunuzu hızlı bir şekilde oluşturun.</p>
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
		<p>created by fatih</p> <a href="#">Back to top</a>
		</p>
</footer>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
></script>
</body>
</html>
