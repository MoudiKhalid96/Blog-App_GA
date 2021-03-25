<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}user/registration" method="post" class="form-control">
	<div class="form-group">
		<label>First Name</label>
		<input type="text" name="firstName" class="form-control">
	</div>
	
	<div class="form-group">
		<label>Last Name </label>
		<input type="text" name="lastName" class="form-control" required>
	</div>
	
	<div class="form-group">
		<label>E-mail Address</label>
		<input type="email" name="emailAddress" class="form-control" required>
	</div>
	
	<div class="form-group" >
		<label>Password</label>
		<input type="password" name="password" class="form-control" required>
	</div>
	
	
	
	<input type="hidden" name="userRole" value="ROLE_USER" />		
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
	<button type="submit" class="btn btn-primary">Submit</button>
</form>