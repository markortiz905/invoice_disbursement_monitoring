<%@ include file="../common/header.jspf" %>

<body>

	<%@ include file="../common/nav.jspf" %>
	
	<div class="container">
		Your New Invoice Item:
		<form id="addForm" class="">
			<div class="row">
				<div class="col">
					<fieldset class="form-group col-md-6">
						<label>Invoice Number</label> <input name="invoiceNumber" type="text"
							class="form-control" /> <BR />
					</fieldset>
				</div>
					<fieldset class="form-group col-md-6">
						<label>Date</label>
						<div class="input-group date"  >
							 <input id="dp1" name="date" type="text" class="form-control" />
							<div class="input-group-addon">
						        <span class="glyphicon glyphicon-th"></span>
						    </div>
						 </div>
						 <BR />
					</fieldset>
			</div>
			<div class="row">
				<div class="col">
					<fieldset class="form-group col-md-6">
						<label>Payment Date</label> 
						<div class="input-group date"  >
							 <input id="dp2" name="paymentDate" type="text" class="form-control" />
							<div class="input-group-addon">
						        <span class="glyphicon glyphicon-th"></span>
						    </div>
						 </div>
						  <BR />
					</fieldset>
					<fieldset class="form-group col-md-6">
						<label>Customer Name</label> <input name="customerName" type="text"
							class="form-control" /> <BR />
					</fieldset>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<fieldset class="form-group col-md-6">
						<label>Amount</label> <input name="amount" type="text"
							class="form-control" /> <BR />
					</fieldset>
					<fieldset class="form-group col-md-6">
						<label>Total Paid</label> <input name="totalPaid" type="text"
							class="form-control" /> <BR />
					</fieldset>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<fieldset class="form-group col-md-6">
						<label>Date Paid</label> 
						<div class="input-group date"  >
							 <input id="dp3" name="datePaid" type="text" class="form-control" />
							<div class="input-group-addon">
						        <span class="glyphicon glyphicon-th"></span>
						    </div>
						 </div>
						 <BR />
					</fieldset>
					<fieldset class="form-group col-md-6">
						<label>Outstanding Balance</label> <input name="outstanding" type="text"
							class="form-control" /> <BR />
					</fieldset>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<fieldset class="form-group col-md-6">
						<input name="add" type="submit" class="btn btn-success" value="Submit" />
					</fieldset>
				</div>
			</div>
		</form>
	</div>

	<%@ include file="../common/footer.jspf" %>
<script type="text/javascript">
	$(document).ready(function() {
	    $('#dp1').datepicker({
	    	dateFormat: 'yy-mm-dd'
	    });
	    $('#dp2').datepicker({
	    	dateFormat: 'yy-mm-dd'
	    });
	    $('#dp3').datepicker({
	    	dateFormat: 'yy-mm-dd'
	    });
	});
	function objectiFy(form) {
		var object={};
		$.each($("#" + form).serializeArray(), 
		function (i,o){
			object[o.name] = o.value;
		});
		return object
	}
	
	$( "#addForm" ).submit(function( event ) {
	  event.preventDefault();
	  console.log();
	  $.post('/invoice/', $('#addForm').serialize());
		 $.ajax({
		    url: '/invoice/',
		    type: 'POST',
		    contentType: "application/json",
		    data : JSON.stringify( objectiFy("addForm") ),
		    success: function(data, textStatus, request) {
		       //alert(result);
		       //console.log(request.getAllResponseHeaders());
		       window.location = request.getResponseHeader('Location');
		    },
		    error : function(jqXHR, textStatus, errorThrown) {
		    	//alert(textStatus);
		    }
		});
		 return false;
	});
</script>
</body>

</html>