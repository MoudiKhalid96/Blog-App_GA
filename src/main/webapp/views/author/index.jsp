<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

<table>

	<tr>
		<th>Author Name</th>
		<th>Email Address</th>
		<th>Gender</th>
		<th>Date of Birth</th>
		<security:authorize access="isAuthenticated()">
			<th>Actions</th>
		</security:authorize>		  			
	</tr>

	<c:forEach items="${authors}" var="author">
		<tr>
			<td><a href="${appName}author/detail?id=${author.id}">${author.name}</a></td>
			<td>${author.emailAddress}</td>
			<td>${author.gender}</td>
			<td>${author.dateofBirth}</td>
			
			<security:authorize access="isAuthenticated()">
				<td>
					<a href="${appName}author/edit?id=${author.id}">Edit</a>
	
					<security:authorize access="hasRole('ADMIN')">
			    		| <a href="${appName}author/delete?id=${author.id}">Delete</a>
					</security:authorize>
				</td>
			</security:authorize>
		</tr>
	</c:forEach>
</table>

