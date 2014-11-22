<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.company.fingoals.util.AppUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.company.fingoals.dto.Goal"%>
<%@include file="header.jsp"%>

	<div class="container">

		<div class="row">

			<div class="col-lg-12">
			
				<div class="panel-body">
				
					<div class="table-responsive">
			
						<form action="./goals" id = "myform" name = "myform" method = "post">
						<input type="hidden" name="goals" />								
					
						<table class="table table-striped table-bordered table-hover"
							id="#">
							<thead>
								<tr>
									<th>Select</th>
									<th>Goal ID</th>
									<th>User ID</th>
									<th>Goal Name</th>
									<th>Goal Desc.</th>
									<th>Goal Amount</th>
									<th>Goal Date</th>
								</tr>
							</thead>
							
							<% 
							List<Goal> goals = (List<Goal>)session.getAttribute("goals");
							
							Goal g = null;
							
							if(goals != null && goals.size() > 0) {
								for(int i = 0 ; i < goals.size() ; i++) {
									g = new Goal();
									g = goals.get(i);
							%>
							<tbody>
								<tr id = row<%=i%>>
									<td><input type="radio" name="goalId" value="<%=g.getGoalID()%>"></td>
									<td><%=g.getGoalID()%></td>
									<td><%=g.getUserID()%></td>
									<td><%=g.getGoalName()%></td>
									<td><%=g.getGoalDescription()%></td>
									<td><%=g.getGoalAmount()%></td>
									<td><%=AppUtil.timeStmpToStr(g.getGoalDate())%></td>									
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
						><span>Add Goal</span></button></label>
				</div>
				
				<div class = "col-md-4">
					<label><button type = "submit" id = "update" value="update" name="dispatch" class = "btn btn-md btn-primary"
						><span>Update Goal</span></button></label>
				</div>
				
				<div class = "col-md-4">									
					<label><button type = "submit" id = "delete" value="delete" name="dispatch"
					 onclick = "javascript:return confirm('Are you absolutely sure you want to delete?');" class = "btn btn-md btn-danger"
						><span>Delete Goal</span></button></label>
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