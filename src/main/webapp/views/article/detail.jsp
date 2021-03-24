<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table>
	<tr>
		<th>Article Title</th>
		<th>Article Description</th>
		<th>Written By</th>
	</tr>
	<tr>
		<td>${article.title}</td>
		<td>${article.description}</td>
		<td>
			<c:forEach items="${article.getAuthors()}" var="author">
				- <a href="${appName}author/detail?id=${author.id}">${author.name}</a><br>
			</c:forEach>
		</td>
	</tr>
</table>


<!--this is when there is comment on html-->
<%--this is when there is comment on Object in [JSON ?] --%>


