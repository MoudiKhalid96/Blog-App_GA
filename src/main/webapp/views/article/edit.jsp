<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="${appName}article/add" method="post" >
	<div class="form-group">
		<label>Article Title </label> <input type="text" name="title" value="${article.title}" class="form-control">
	</div>
	<div class="form-group">
		<label>Article Description </label> <input type="text" name="description" value="${article.description}">
	</div>
	<div class="form-group">
		<label>Author</label>
		<select name="author">
			<c:forEach items="${authors}" var="author">
				<option value="${author.id}"> ${author.name} 
				
					<!-- if the FK of the article matches the PK in author, then make it selected(attribute in HTML) -->
					<c:if test="${article.author.id == author.id}">
						selected = "selected"
					</c:if>
					${author.name}
				</option>
			</c:forEach>	
		</select>
	</div>
	
	<input type="hidden" name="id" value="${article.id}">
	<button type="submit" class="btn btn-primary">Submit</button>
</form>