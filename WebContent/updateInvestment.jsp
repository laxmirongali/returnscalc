<%@page import="com.company.fingoals.dto.Investment"%>
<%@page import="com.company.fingoals.util.AppUtil"%>
<%@include file="header.jsp"%>

	<%
		Investment investment = (Investment)request.getAttribute("investment");
	%>
	
	<div class = "container">
	
		<div class = "row">
		
			<div class = "col-md-3">
			
			</div>
			
			<div class = "col-md-6">
		
			<div class = "panel">
				
				<div class = "panel-header">
					<center><h3>Update Your Investment Here</h3></center>
				</div>
			
				<div class = "panel-body">									
				
					<form name = "updateinvestment" action="./investments" method = "post">
						<input type = "hidden" name = "invId" value = "<%=investment.getInvestmentID()%>">			
					Invested Date :<div class="input-group">
										<label class="input-group-btn" for="invDate"> <span
											class="btn btn-default"> <span
												class="glyphicon glyphicon-calendar"></span>
										</span>
										</label> <input type="text" class="form-control laks-date-input"
											id="invDate" name="invDate" value = "<%=AppUtil.timeStmpToStr(investment.getInvestedDate()) %>" />
										</div><br>
					Symbol :<input type = "text" class = "form-control"  
						name = "symbol" value = "<%=investment.getSymbol() %>" ><br>
					Amount :<input type = "text" class = "form-control" 
						name = "amount" value = "<%=investment.getAmount() %>" ><br><br>
																	
						<a class = "btn btn-md btn-primary pull-right" href =  "./investments" >Cancel</a>
						
						
						<button type = "submit" name = "dispatch" value="saveUpdate"  
						 class = "btn btn-md btn-success pull-right"><span>Save</span></button>										
					</form>
				
				</div>
			
			</div>
			
			</div>
			
			<div class = "col-md-3">
			
			</div>
		
		</div>
	
	</div>

<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		
<script type="text/javascript">

$(function () {
	  $(".laks-date-input").datepicker({ 
	        autoclose: true, 
	        todayHighlight: true
	  });
	});

</script>

<script
		src="./js/bootstrap-datepicker.js"></script>
	
</body>
</html>