<jsp:include page="../shared/_layout.jsp" />
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="article-details" id="bg-color">
	<h2>${article.title}</h2>
	Written By:
	<ul>
	<c:forEach items="${article.getAuthors()}" var="author">
					<li><a href="${appName}author/detail?id=${author.id}">${author.name}</a></li>
				</c:forEach>
	</ul>
	<security:authorize access="isAuthenticated()">
		<button class="btn btn-primary"><a style="color: white; text-decoration: none;" href="${appName}article/edit?id=${article.id}">Edit</a></button>
		<button class="btn btn-primary"><a style="color: white; text-decoration: none;" href="${appName}article/delete?id=${article.id}">Delete</a></button>
	</security:authorize>
	
	<p>
	${article.description}
	<p>
</div>