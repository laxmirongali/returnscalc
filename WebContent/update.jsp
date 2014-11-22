<%@page import="com.company.fingoals.util.AppUtil"%>
<%@ page import="com.company.fingoals.dto.Goal" %>
<%@include file="header.jsp"%>

	<%		
		Goal goal = (Goal) request.getAttribute("goal");
	%>

	<div class = "container">
	
		<div class = "row">
		
			<div class = "col-md-3">
			
			</div>
			
			<div class = "col-md-6">
		
			<div class = "panel">
				
				<div class = "panel-header">
					<center><h3>Update Your Goal Here</h3></center>
				</div>
			
				<div class = "panel-body">									
				
					<form name = "updategoal" action="./goals" method = "post">
						<input type = "hidden" name = "goalId" value = "<%=goal.getGoalID()%>">
					Goal Name :<input type = "text" class = "form-control"  
						name = "goalname" value = "<%=goal.getGoalName()%>"/><br>
					Goal Description :<input type = "text" class = "form-control"  
						name = "goaldesc" value = "<%=goal.getGoalDescription()%>"><br>
					Goal Amount :<input type = "text" class = "form-control"  
						name = "goalamount" value = "<%=goal.getGoalAmount()%>"/><br>
					Goal Date ::<div class="input-group">
										<label class="input-group-btn" for="goal-date"> <span
											class="btn btn-default"> <span
												class="glyphicon glyphicon-calendar"></span>
										</span>
										</label> <input type="text" class="form-control laks-date-input"
											id="goal-date" name="goaldate" value = "<%=AppUtil.timeStmpToStr(goal.getGoalDate()) %>" />
										</div><br><br>
								
						
						<a class = "btn btn-md btn-primary pull-right" href =  "./goals" >Cancel</a>
						
						
						<button type = "submit" value="saveUpdate" name = "dispatch"   
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