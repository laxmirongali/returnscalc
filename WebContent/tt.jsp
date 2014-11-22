<%@include file="header.jsp"%>
	<center>
		<h2>This is sample table</h2>
	</center>
	<br />
	<table class="table table-responsive table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Inv.Date</th>
				<th>Total Quantity</th>
				<th>Inv.Value</th>
				<th>Curr.Value</th>
				<th>Gain(Gain%)</th>
			</tr>
		</thead>
		<tbody>
			<tr class="clickable" data-toggle="collapse" id="row1"
				data-target=".row1">
				<td><i class="glyphicon glyphicon-plus">Apple Inc.</i></td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
			</tr>
			<tr class="collapse row1">
				<td>Apple Inc.</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
			</tr>
			<tr class="collapse row1">
				<td>Apple Inc.</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
			</tr>
			<tr class="clickable" data-toggle="collapse" id="row2"
				data-target=".row2">
				<td><i class="glyphicon glyphicon-plus">Netflix</i></td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
				<td>data</td>
			</tr>
			<tr class="collapse row2">
				<td>Netflix</td>
				<td>data 2</td>
				<td>data 2</td>
				<td>data 2</td>
				<td>data</td>
				<td>data</td>
			</tr>
			<tr class="collapse row2">
				<td>Netflix</td>
				<td>data 2</td>
				<td>data 2</td>
				<td>data 2</td>
				<td>data</td>
				<td>data</td>
			</tr>
		</tbody>
	</table>


	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

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