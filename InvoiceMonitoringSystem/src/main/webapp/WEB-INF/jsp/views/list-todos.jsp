<%@ include file="../common/header.jspf" %>
<body>

	<%@ include file="../common/nav.jspf" %>

	<div class="container">
		<H1>Welcome ${name}</H1>
	
	
		<table class="table table-striped">
			<caption>Your Todos are</caption>
			<thead>
				<th>Description</th>
				<th>Category</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.todo}</td>
						<td>${todo.category}</td>
						<td>&nbsp;&nbsp;<a class="btn btn-danger"
							href="/delete-todo.do?todo=${todo.todo}&category=${todo.category}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<p>
			<font color="red">${errorMessage}</font>
		</p>
		<a class="btn btn-success" href="/add-todo.do">Add New Todo</a>
	</div>

	<%@ include file="../common/footer.jspf" %>

</body>

</html>