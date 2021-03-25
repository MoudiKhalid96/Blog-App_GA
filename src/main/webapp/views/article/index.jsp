<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />
<link rel="stylesheet" href="css/style.css">


<table style="width: 50%; text-align: center;">
	<tr>
		<th>Article Title</th>	
	</tr>
	<c:forEach items="${articles}" var="article">
		<tr>
			<td><a href="${appName}article/detail?id=${article.id}">${article.title}</a></td>	
		</tr>
	</c:forEach>
</table>