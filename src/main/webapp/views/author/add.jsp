<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}author/add" method="post" class="form-control" id="bg-color">

	<div class="form-group">
		<label>Author's Name </label> <input type="text" name="name" class="form-control">
	</div>

	<div class="form-group">
		<label>Email Address </label> <input type="text" name="emailAddress" class="form-control">
	</div>

	<div class="form-group"> <!-- this is to control the div of form -->
		<label>Gender </label> <input type="text" name="gender" class="form-control"> <!-- this is to control layout of input -->
	</div>

	<div class="form-group">
		<label>Date of Birth </label> <input type="date" name="dateofBirth" class="form-control">
	</div>

 	<!-- <div>
		<label>Article </label> <input type="text" name="article">
	</div> -->

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button type="submit" class="btn btn-primary">Submit</button>

</form>