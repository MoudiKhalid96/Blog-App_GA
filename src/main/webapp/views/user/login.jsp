<jsp:include page="../shared/_layout.jsp" />


<b style="color: red;">${message}</b>

<form action="${appName}login" method="post" class="form-control">

	<div class="form-group">
		<label>E-mail Address</label>
		<input type="email" name="username" class="form-control" required>
		<!-- I have changed the name from `emailAddress` to `username` so match the one in class `UserDetailsImpl`, these steps is to not redirect to security form login page .. but mine that I create it -->
	</div>
	
	<div class="form-group">
		<label>Password</label>
		<input type="password" name="password" class="form-control" required>
	</div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button type="submit" class="btn btn-primary">Submit</button>
</form>