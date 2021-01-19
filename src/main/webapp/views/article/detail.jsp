<jsp:include page="../shared/_layout.jsp" />



<table>
	<tr>
		<th>Article Title</th>
		<th>Article Description</th>
		<th>Written By</th>
	</tr>
	<tr>
		<td>${article.title}</td>
		<td>${article.description}</td>
		<td>${article.author.name}</td>
	</tr>
</table>


<!--this is when there is comment on html-->
<%--this is when there is comment on Object in [JSON ?] --%>


