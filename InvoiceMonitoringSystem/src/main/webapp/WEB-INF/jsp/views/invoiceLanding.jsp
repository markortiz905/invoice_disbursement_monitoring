<%@ include file="../common/header.jspf" %>
<body>

	<%@ include file="../common/nav.jspf" %>

	<div class="container">
		<H1>Welcome ${name}</H1>
		<a class="btn btn-default" href="/invoiceAddForm">Add Invoice</a>
		<table class="table table-bordered">
			<caption>Your Invoices are</caption>
			<thead>
				<th>Transaction #</th>
				<th>Invoice Number</th>
				<th>date</th>
				<th>Payment Date</th>
				<th>Customer Name</th>
				<th>Amount</th>
				<th>Total Paid</th>
				<th>Date Paid</th>
				<th>Outstanding Balance</th>
				<th colspan="2">Action</th>
			</thead>
			<tbody>
				<c:forEach items="${invoiceList}" var="invoice">
					<tr id="${invoice.invoiceNumber}">
						<td>${invoice.transactionNumber}</td>
						<td>${invoice.invoiceNumber}</td>
						<td>${invoice.date}</td>
						<td>${invoice.paymentDate}</td>
						<td>${invoice.customerName}</td>
						<td>${invoice.amount}</td>
						<td>${invoice.totalPaid}</td>
						<td>${invoice.datePaid}</td>
						<td>${invoice.outstanding}</td>
						<td>&nbsp;&nbsp;<a class="btn btn-default" href="invoiceViewPage/${invoice.invoiceNumber}">View</a></td>
						<td>&nbsp;&nbsp;<a class="btn btn-danger" onclick="deleteInvoice(${invoice.invoiceNumber})">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
<!-- 		<a class="btn btn-success" >Add New Todo</a> -->
	</div>

	<%@ include file="../common/footer.jspf" %>
	
	<script type="text/javascript">
		function deleteInvoice(invoiceNumber) {
			con = confirm("Are you sure to delete Invoice : " + invoiceNumber + "?");
			if (con) {
				$.ajax({
				    url: '/invoice/' + invoiceNumber,
				    type: 'DELETE',
				    success: function(result) {
				        $("#" + invoiceNumber).remove();
				    },
				    error : function(jqXHR, textStatus, errorThrown) {
				    	alert("Invoice " + invoiceNumber + " failed to delete.\n" + errorThrown);
				    }
				});
			}
		}
	</script>
</body>

</html>