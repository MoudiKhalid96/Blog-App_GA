<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="windows-1256" />
	<title>Blog App</title>
	<link rel="stylesheet" href="../css/style.css" type="text/css">
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<link rel="icon" href="https://cdn0.iconfinder.com/data/icons/cosmo-culture/40/books_1-512.png"/>
</head>
<body>

<h1>${blogapp}</h1>

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.username" var="username"/>

	<a href="${appName}">Home</a>
	<a href="${appName}author/index">Author</a>
	<a href="${appName}article/index">Article</a>
	<a href="${appName}author/add">Add Author</a>
	<a href="${appName}article/add">Add Article</a>
	
	<div style="text-align:right; float:right;">
		<b>
			Hi <security:authentication property="principal.firstName" />
		</b>
		<a href="${appName}user/profile?emailAddress=${username}">Profile</a>
		<a href="${appName}logout">Logout</a>
		</div>
</security:authorize>
		
<security:authorize access="!isAuthenticated()">
	<a href="${appName}">Home</a>
	<a href="${appName}author/index">Author</a>
	<a href="${appName}article/index">Article</a>
	
	<div style="text-align:right; float:right;">
		<a href="${appName}user/login">Login</a>
		<a href="${appName}user/registration">Create new Account</a>
	</div>
	<br>
</security:authorize>
<hr>

<c:if test="${message != null}">
	<div class="alert alert-primary fade show" role="alert">
		${message}
		<%session.removeAttribute("message"); %>
	</div>
</c:if>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$('.fade').fadeOut(4000);
</script>
</body>
</html>