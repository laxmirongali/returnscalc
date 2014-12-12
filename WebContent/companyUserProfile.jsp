<%@ page import="java.util.List"%>
<%@ page import="com.company.fingoals.dto.Company"%>
<%@include file="header.jsp"%>
<link rel="stylesheet" href="companyUserProfile.css">


	<%					
			List<String> symbolList = (List<String>) session.getAttribute("symbolList");
	%>


	<div class="container">

		<div class = "row">
		
		<div class = "col-lg-12">
		<div class = "panel panel-default">
			<div class = "panel-header">
			<center>
			<h3>Enter a company name</h3>
		</center>
		</div>
		
		<div class="panel-body">
		
			<form class="form" class = "well" name="myform" role="search"
				action="./CompanyLinks" method="post">
				<input type="hidden" name="companysymbol" />
				<div class="input-group" id = "search">
					<input type="text" class="form-control" placeholder="Company Name"
						id="query" name="companyname" value="" />
					<div class="input-group-btn">
						<button type="submit" class="btn btn-md btn-success">
							<span>Search</span>
						</button>
						</div>
					</div>
									
													
			
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="table1">
							<thead>
								<tr bgcolor = "ccccff">
									<th>Symbol</th>
									<th>Name</th>
									<th>Exchange</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									List<Company> cList = (List<Company>) request.getAttribute("clist");
																											if (cList != null) {																												for (Company c : cList) {
								%>
								<tr>
									<td><a data-target="#modal" data-toggle="modal"
										data-remote="./CompanyStockValue?symbol=<%=c.getSymbol()%>"
										href="#"><%=c.getSymbol()%></a></td>
									<td><%=c.getName()%></td>
									<td><%=c.getExchange()%></td>
									<td><button type="button" id="myButton"
											class="btn btn-sm btn-success"
											onclick="myfunction('<%=c.getSymbol()%>');">
											<span class="badge"><b>+</b></span><b> Add</b>
										</button>
								</tr>
								<%
									}

																											}
								%>
							</tbody>
						</table>
					</div>
					<hr>
					<div class = "table-responsive">			
					<table class="table table-striped table-bordered table-hover"
						id="table2">
						<thead style = "width =1080px; height = 20px;">
							<tr bgcolor = "ccccff">
								<th>Symbol</th>
								<th>From-Date</th>
								<th>To-Date</th>
								<th>Amount</th>
								<th>Day Of The Month</th>
							</tr>
						</thead>

						<tbody>
							<%
								if (symbolList != null) {
									int i = 0;
									for(String s : symbolList) {
										
							%>
							<tr>
								<td><%=s%></td>
								<td>
									<div class="input-group">
										<label class="input-group-btn" for="from-date<%=i%>"> <span
											class="btn btn-default"> <span
												class="glyphicon glyphicon-calendar"></span>
										</span>
										</label> <input type="text" class="form-control laks-date-input"
											id="from-date<%=i%>" name="fromdate<%=i%>" />
											</div>
								</td>
								<td>
									<div class="input-group">
										<label class="input-group-btn" for="to-date<%=i%>"> <span
											class="btn btn-default"> <span
												class="glyphicon glyphicon-calendar"></span>
										</span>
										</label> <input type="text" class="form-control laks-date-input"
											id="to-date<%=i%>" name="todate<%=i%>" />
										</div>
								</td>
								<td><input type="text" class = "form-control" placeholder="Should be > 0" name="amount<%=i%>"></td>
								<td><input type="text" class = "form-control" name="day<%=i%>"></td>
								<%
								  i++;
									}
																										
									}
								%>
							
						</tbody>

					</table>
					</div>
					<button type = "submit" class = "btn btn-primary pull-right" onclick = "sendvalues();"><span>Submit</span></button>
					</form>
				</div>
					
					
				</div>
				</div>
			
		</div>
	</div>
	




	<div aria-hidden="true" aria-labelledby="modalLabel" role="dialog"
		tabindex="-1" id="modal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"></div>

				<div class="modal-body"></div>
				<div class="modal-footer"></div>

			</div>
		</div>
	</div>

	
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	
	<script>
		function myfunction(cn) {
			
				document.myform.companysymbol.value = cn;
				document.myform.action = "./addCompany";
				document.myform.submit();
			
		}
		
		$(function () {
			  $(".laks-date-input").datepicker({ 
			        autoclose: true, 
			        todayHighlight: true
			  });
			});
		
		function sendvalues() {
			document.myform.action = "./getReturns";
			document.myform.submit();
		}
		
	</script>
<script
		src="./js/bootstrap-datepicker.js"></script>
</body>
</html>