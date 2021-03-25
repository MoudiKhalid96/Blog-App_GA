<jsp:include page="../shared/_layout.jsp" />

<div id="bg-color" class="grid">
	<div>
		<img class="picture" src="${user.picture}" />
	</div>
	<div>
		<p>Name: ${user.firstName} ${user.lastName}</p>
		<p>E-mail: ${user.emailAddress}</p>
	</div>
</div>

