<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="${appName}article/add" method="post" id="bg-color">
	<div class="form-group">
		<label>Article Title </label> <input type="text" name="title" class="form-control">
	</div>
	<div class="form-group">
		<label>Article</label>
		<textarea name="description" class="form-control" rows="10"></textarea>
	</div >
	<div class="form-group">
		<label>Authors</label>
		<select name="authors" class="form-control" multiple="multiple">
			<c:forEach items="${authors}" var="author">
				<option value="${author.id}"> ${author.name} </option>
			</c:forEach>	
		</select>
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button type="submit" class="btn btn-primary">Submit</button>
</form>