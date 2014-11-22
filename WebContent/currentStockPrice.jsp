<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.company.fingoals.dto.Quote"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Stock Price</title>
<meta name="viewport" content="width=device-width,initial-scale = 1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="companyDetails.css">
</head>
<body>


<div class="modal-header">
 				<center><h3>Current Stock Price</h3></center>
            </div>



<div class = "modal-body">		
	<div class="row">
		<div class="col-lg-12">
			
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="#">
							<thead>
								<tr>
									<th>Name</th>
									<th>Symbol</th>
									<th>Current Price</th>
								</tr>
							</thead>
							<tbody>
<%Quote q =(Quote)request.getAttribute("quote");%>
<tr>
<td><%=q.getCompanyName() %></td>
<td><%=q.getSymbol() %></td>
<td><%=q.getAdjClose().toString()%></td>

								
							</tbody>
						</table>
					</div>
				</div>
		</div>
	</div>
</div>
<div class = "modal-footer">
	<a class = "btn btn-primary" data-dismiss = "modal">Close</a>
</div>
	 

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="js/plugins/metisMenu/metisMenu.min.js"></script>
	<script src="js/sb-admin-2.js"></script>
</body>
</html>