<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../shared/_layout.jsp" />
<table>
	<tr>
		<th>Author's Name</th>
		<th>Gender</th>
		<th>Date of Birth</th>
		<th>Email Address</th>		
		<th>Articles</th>		
		<th>Actions</th>		
	</tr>
	<tr>
		<td>${author.name}</td>
		<td>${author.gender}</td>
		<td>${author.dateofBirth}</td>
		<td>${author.emailAddress}</td>

		

<!-- this comment is for the 1:m relationship  -->
<!-- author.getArticles() is working because of the bi-directional relationship [one to many and many to one that we've mentioned in the model classes] -->

<td>
<c:forEach items="${author.getArticles()}" var="article">

		<ul>
			<li><a href="${appName}article/detail?id=${article.id}">${article.title}</a></li>
		</ul>
</c:forEach>
</td>
<security:authorize access="isAuthenticated()">

	<td>
		<a href="${appName}author/edit?id=${author.id}">Edit</a> | 
		<a href="${appName}author/delete?id=${author.id}">Delete</a>
	</td>
	</security:authorize>
</tr>
</table>


<!--this shape of comment when there is comment on html-->
<%--this shape of comment when there is comment on Object in [JSON ?] --%>
