<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<table>
	<tr>
		<th>Author's Name</th>
		<th>Gender</th>
		<th>Date of Birth</th>
		<th>Email Address</th>		
		<th>Title</th>		
		<th>Description</th>		
	</tr>
	<tr>
		<td>${author.name}</td>
		<td>${author.gender}</td>
		<td>${author.dateofBirth}</td>
		<td>${author.emailAddress}</td>
		


<!-- author.getArticles() is working because of the bi-directional relationship [one to many and many to one that we've mentioned in the model classes] -->

<td>
<c:forEach items="${author.getArticles()}" var="article">

		${article.title}<br>
	<hr>
</c:forEach>
</td>
<td>
<c:forEach items="${author.getArticles()}" var="article">

		${article.description}<br>
		<hr>	
</c:forEach>

</td>
</tr>
</table>


<!--this shape of comment when there is comment on html-->
<%--this shape of comment when there is comment on Object in [JSON ?] --%>
