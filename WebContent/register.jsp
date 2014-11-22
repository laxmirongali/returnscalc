<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<meta name="viewport" content="width=device-width,initial-scale = 1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="register.css">
</head>
<body>
<div class="navbar navbar-default navbar-static-top">
		<div class="container">

			<a href="#" class="navbar-brand">Fin Goals</a>
			<a href = "login.jsp" class = "btn btn-sm btn-primary pull-right">Sign in</a>

		</div>
	</div>
	
	<div class = "container">
	
		<div class = "row">
		
			<center><h3>Create your FinGoals Account</h3></center>
		
			<div class = "col-md-4">
			
			</div>
			<div class = "col-md-4">
				
				<div class = "form-panel panel panel-default">
					<div class = "account-wall">
					
					<form name = "myform" action="./registerUser" method = "post">
					
					<b> Name</b><br>
					<input type = "text" name = "fname" class = "form-control"
						placeholder = "First Name"><br>
					
					<input type = "text" name = "lname" class = "form-control"
						placeholder = "Last Name"><br>
					
					<b> Your E-mail ID</b>
					<input type = "email" name = "email" class = "form-control"
						placeholder = "E-mail"><br>
					
					<b> Create a password</b>
					<input type = "password" name = "password1" class = "form-control"><br>
					
					<b> Confirm your password</b>
					<input type = "password" name = "password2" class = "form-control"><br>
					
					<b> Date of Birth</b>
					<input type = "text" name = "dob" class = "form-control">
					
					<button type = "submit" class = "btn btn-sm btn-primary pull-right" >Submit</button>
					
					
					
					</form>
				
				</div>
				</div>
			
			</div>
			<div class = "col-md-4">
			
			</div>
		
		</div>
		
	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>