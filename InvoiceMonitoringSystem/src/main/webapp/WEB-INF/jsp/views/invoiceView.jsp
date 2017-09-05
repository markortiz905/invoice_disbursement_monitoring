<%@ include file="../common/header.jspf" %>
<body>

	<%@ include file="../common/nav.jspf" %>

	<div class="container">
		<div class="row">
				<div class="col col-md-6">
					<label>Transaction Number : </label>
				</div>
				<div class="col col-md-6">
					${invoice.transactionNumber}
				</div>
		</div>
	</div>

	<%@ include file="../common/footer.jspf" %>

</body>

</html>