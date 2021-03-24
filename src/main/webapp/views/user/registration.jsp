<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}user/registration" method="post" class="form-control">
	<div class="form-group">
		<label>First Name</label>
		<input type="text" name="firstName" class="form-control">
	</div>
	
	<div class="form-group">
		<label>Last Name </label>
		<input type="text" name="lastName" class="form-control">
	</div>
	
	<div class="form-group">
		<label>E-mail Address</label>
		<input type="email" name="emailAddress" class="form-control">
	</div>
	
	<div class="form-group" >
		<label>Password</label>
		<input type="password" name="password" class="form-control">
	</div>
	
	
	<div class="form-group">
		<label>Select Role</label>
		<select name="userRole" class="form-control">
			<option value="ROLE_ADMIN">Admin</option>
			<option value="ROLE_USER">User</option>
		</select>
	</div>
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />	<button type="submit" class="btn btn-primary">Submit</button>
</form>