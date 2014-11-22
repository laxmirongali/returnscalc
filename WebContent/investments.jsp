<%@page import="com.company.fingoals.util.AppUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.company.fingoals.dto.Investment" %>
<%@include file="header.jsp"%>

	<div class="container">

		<div class="row">

			<div class="col-lg-12">
			
				<div class="panel-body">
				
					<div class="table-responsive">
			
						<form action="./investments" id = "myform" name = "myform" method = "post">
						<input type="hidden" name="investments" />								
					
						<table class="table table-striped table-bordered table-hover"
							id="#">
							<thead>
								<tr>
									<th>Select</th>
									<th>Investment ID</th>
									<th>User ID</th>									
									<th>Invested Date</th>
									<th>Symbol</th>
									<th>Invested Amount</th>									
								</tr>
							</thead>
							<%
								List<Investment> investments = (List<Investment>)request.getAttribute("investments");
								Investment inv = null;
								
								if(investments != null && investments.size() > 0) {
									for(int i = 0 ; i < investments.size() ; i++) {
										inv = new Investment();
										inv = investments.get(i);
							%>
							<tbody>
								<tr id = row<%=i%>>
									<td><input type="radio" name="invId" value="<%=inv.getInvestmentID()%>"></td>
									<td><%=inv.getInvestmentID()%></td>
									<td><%=inv.getUserID() %></td>
									<td><%=AppUtil.timeStmpToStr(inv.getInvestedDate())%></td>
									<td><%=inv.getSymbol() %></td>
									<td><%=inv.getAmount() %></td>
								</tr>
							<%
									}
								}
							%>
														
							</tbody>
							
						</table>
						
						<div class = row>
				
				<div class = "col-md-4">
					<label><button type = "submit" value="add" id = "add" name="dispatch" class = "btn btn-md btn-primary"
						><span>Add Investment</span></button></label>
				</div>
				
				<div class = "col-md-4">
					<label><button type = "submit" id = "update" value="update" name="dispatch" class = "btn btn-md btn-primary"
						><span>Update Investment</span></button></label>
				</div>
				
				<div class = "col-md-4">									
					<label><button type = "submit" id = "delete" value="delete" name="dispatch"
					 onclick = "javascript:return confirm('Are you absolutely sure you want to delete?');" class = "btn btn-md btn-danger"
						><span>Delete Investment</span></button></label>
				</div>								
				
			</div>
						
					</form>
					
				</div>
				
			</div>
			
		</div>
		
	</div>
	
</div>
<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		

</body>
</html>

							