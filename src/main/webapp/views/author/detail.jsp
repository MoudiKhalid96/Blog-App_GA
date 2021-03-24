<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<table>
	<tr>
		<th>Author's Name</th>
		<th>Gender</th>
		<th>Date of Birth</th>
		<th>Email Address</th>		
		<th>Articles</th>		
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
</tr>
</table>


<!--this shape of comment when there is comment on html-->
<%--this shape of comment when there is comment on Object in [JSON ?] --%>
