<%@ include file="../common/header.jspf" %>
<body>

	<%@ include file="../common/nav.jspf" %>

	<div class="container">
		<form action="/login.do" method="post">
			<p>
				<font color="red">${errorMessage}</font>
			</p>
			Name: <input type="text" name="name" /> Password:<input
				type="password" name="password" /> <input type="submit"
				value="Login" />
		</form>

	</div>

	<%@ include file="../common/footer.jspf" %>

</body>

</html>