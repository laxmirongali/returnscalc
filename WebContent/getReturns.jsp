<%@page import="java.math.BigDecimal"%>
<%@page import="com.company.fingoals.util.AppUtil"%>
<%@page import="com.company.fingoals.dto.Holding"%>
<%@page import="com.company.fingoals.dto.HoldingsGroup"%>
<%@ page import="java.util.List"%>
<%@ page import="com.company.fingoals.dto.XIRRReturns" %>
<%@include file="header.jsp"%>
<script src="http://code.jquery.com/jquery.min.js"></script>

	<%
		List<HoldingsGroup> hgList = (List<HoldingsGroup>) request.getAttribute("hgList");
	%>
		

	<div class="container">

		<div class="row">
		
			<div class="col-lg-12">
			
				<div class="panel-group" id="accordion">
				
					<div class="panel panel-default">
																														
								<div class="panel-title" class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
										id="#">
								
										<thead>
											<tr bgcolor = "ccccff">
												<th>Name</th>
												<th>Inv.Date</th>
												<th>Total Quantity</th>
												<th>Inv.Value</th>
												<th>Curr.Value</th>
												<th>Gain(Gain%)</th>
												<th>XIRR%</th>
											</tr>
										</thead>
										<%
											HoldingsGroup hg = null;
											
											for(int i = 0 ; i < hgList.size() ; i++) {											
												hg = new HoldingsGroup();
												hg = hgList.get(i);
											
										%>
										
										<tbody>
											
											<tr class = "clickable" data-toggle="collapse" id="row<%=i%>"
											    data-target=".row<%=i%>" >
												
												<td><button type = "button" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-plus"></span></button><b>&nbsp;<%=hg.getCompanyName()%></b></td>
												<td>---</td>
												<td><b><%=AppUtil.numFormat(hg.getTotalQuantity())%></b></td>
												<td><b><%=AppUtil.numFormat(hg.getTotalInvestedAmount())%></b></td>
												<td><b><%=AppUtil.numFormat(hg.getCurrentValue())%></b></td>
												<td><b><%=AppUtil.numFormat(hg.getOverallGain())%>(<%=AppUtil.numFormat(hg.getOverallGainPercent())%>%)</b></td>
												<td><b><%=AppUtil.numFormat(new BigDecimal(hg.getXIRR()))%>%</b></td>
												
											</tr>
											
												<%
													List<Holding> holdings = hg.getHoldings();
													if (holdings != null) {

														for (Holding holding : holdings) {
												%>
											
												<tr class = "collapse row<%=i%>">
													<td><%=holding.getCompanyName()%></td>
													<td><%=holding.getDateString()%></td>
													<td><%=AppUtil.numFormat(holding.getQuantity())%></td>
													<td><%=AppUtil.numFormat(holding.getInvestedValue())%></td>
													<td><%=AppUtil.numFormat(holding.getCurrentValue())%></td>
													<td><%=AppUtil.numFormat(holding.getReturn())%>(<%=AppUtil.numFormat(holding.getReturnPercentage())%>%)</td>
													<td><%=AppUtil.numFormat(new BigDecimal(holding.getXIRR()))%>%</td>
												</tr>
												<%
													}
													}
											}
												%>
									
									</tbody>

								</table>

							
						</div>
							
					</div>

				</div>

			</div>
			
		</div>
		
	</div>
	
</div>			
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="js/plugins/metisMenu/metisMenu.min.js"></script>
	<script src="js/sb-admin-2.js"></script>
	<script type='text/javascript'>
		$(document).ready(
				function() {
					$('.collapse').on(
							'shown.bs.collapse hidden.bs.collapse',
							function() {
								$(this).prev().find('.glyphicon').toggleClass(
										'glyphicon-plus glyphicon-minus');
							});
				});
	</script>
</body>
</html>