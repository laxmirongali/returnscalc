<%@ page import="java.util.List"%>
<%@ page import="com.company.fingoals.dto.Goal"%>
<%@include file="header.jsp"%>
<link rel="stylesheet" href="addgoal.css">

	<div class = "container">
	
		<div class = "row">
			
		
			<div class = "col-md-3">
			
			</div>
			
			<div class = "col-md-6">
				<center><h3>Add Your Investment Here</h3></center>
				<div class = "form-panel panel panel-default">
					<div class = "account-wall">
						<div class = "panel" id = "innerpanel">
						<div class = "panel-header"></div>
							<div class = "panel-body">
																						
					<form name = "saveinvestment" action="./investments" method = "post">			
					Invested Date :<div class="input-group">
										<label class="input-group-btn" for="invested-date"> <span
											class="btn btn-default"> <span
												class="glyphicon glyphicon-calendar"></span>
										</span>
										</label> <input type="text" class="form-control laks-date-input"
											id="invested-date" placeholder = "Invested Date" name="invDate" />
										</div><br>
					Symbol :<input type = "text" class = "form-control" placeholder = "Company Symbol" 
						name = "symbol" ><br>
					Amount :<input type = "text" class = "form-control" placeholder = "Invested Amount" 
						name = "amount" ><br><br>
						
						<%
						List<Goal> goals = (List<Goal>)session.getAttribute("goals");
						%>
						
						<table id="goals_investments" class = "table table-bordered table-hover">
							<thead>
								<tr bgcolor = "ccccff">
									<th></th>
									<th>Select Goal</th>
									<th>Inv Percentage</th>
									<th> </th>
								</tr>
							</thead>
							
							<tbody>	
							
							<tr>
							<td nowrap></td>
							<td>
						
						<select name="newgoal_name_0" >
							
						
						<%												
												
						Goal g = null;
						if(goals != null && goals.size() > 0) {
							for(int i = 0 ; i < goals.size() ;i++){
								g = new Goal();
								g = goals.get(i);
												
						%>
							
							<option value = "<%=g.getGoalID()%>"><%=g.getGoalName() %></option>							
							
							<%
								}
							}
							%>
							
							</select>
							</td>
							<td><input type = "text" name = "newproperty_value_0" class = "form-control"
								placeholder = "Investment%"></td>
							<td class="data_item_options"><a class="btn btn-sm btn-danger" href="javascript:deleteRow()" title="Delete row" onClick="deleteRow(this); return false;"><span class = "glyphicon glyphicon-remove"></span></a></td>
							</tr>
						
							</tbody>
							
						</table>
						
						<table id="goals_investments_rowtemplate" style="display:none" data-counter="0">
							<tr>
								<td></td>
								<td>
								<select name="newgoal_name_RWCNT" >
								
								<%												
												
						
						if(goals != null && goals.size() > 0) {
							for(int j = 0 ; j < goals.size() ;j++){
								g = new Goal();
								g = goals.get(j);
												
						%>
							
							<option value = "<%=g.getGoalID()%>"><%=g.getGoalName() %></option>							
							
							<%
								}
							}
							%>
								
								</select>
								
								<td><input type = "text" name="newproperty_value_RWCNT" value="" class = "form-control"
								placeholder = "Investment%"></td>
								
								<td><a class="btn btn-sm btn-danger" href="javascript:deleteRow()" title="Delete row" onclick="deleteRow(this); return false;"><span class = "glyphicon glyphicon-remove"></span></a></td>
							
							</tr>
						
						
						</table>
						
						
						<a class="btn btn-md btn-primary pull-center" href="javascript:addRow()" onclick="addRow('goals_investments'); return false" title="Add new row">Add row</a><br/><hr>
						<div class = "divider"></div>											
						
						<a class = "btn btn-md btn-primary pull-right" href =  "./investments" >Cancel</a>
						
						
						<button type = "submit" name = "dispatch" class = "btn btn-md btn-success pull-right"  
						value="saveAdd"><span>Save</span></button>										
					</form>
				
				</div>
				</div>				
			
			</div>
			
			</div>
			
			<div class = "col-md-3">
			
			</div>
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

function addRow(sTableId) {
    // find destination and template tables, find first <tr>
    // in template. Wrap inner html around <tr> tags.
    // Keep track of counter to give unique field names.
    var table  = $("#"+sTableId);
    var template = $("#"+sTableId+"_rowtemplate");
    var htmlCode = "<tr>"+template.find("tr:first").html()+"</tr>";
    var id = parseInt(template.data("counter"),10)+1;
    template.data("counter", id);
    htmlCode = htmlCode.replace(/RWCNT/g, id);    
    table.find("tbody:last").append(htmlCode);
}

// delete <TR> row, childElem is any element inside row
function deleteRow(childElem) {
    var row = $(childElem).closest("tr"); // find <tr> parent
    row.remove();
}

</script>

<script
		src="./js/bootstrap-datepicker.js"></script>
	
</body>
</html>