<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<meta name="viewport" content="width=device-width,initial-scale = 1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="login.css">
</head>
<body>


<div class="navbar navbar-default navbar-static-top">
		<div class="container">

			<a href="#" class="navbar-brand">Fin Goals</a>

		</div>
	</div>

	<div class="container">

		<div class="row">
			
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				
				<center><h4>Sign in to continue to Fin Goals</h4></center>
				<div class="login-panel panel panel-default">
					<div class="account-wall">
						<img class = "profile-img" src =" https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
							alt="">
						
						<div class="panel-body">
							<form role="form" action = "./validateUser" method = "post">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="E-mail" name="email"
											type="email" autofocus value="teemp@gmail.cc">
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password"
											name="password" type="password" value="ertyy">
									</div>
									
									 ${message}									
									  
									<div class="checkbox">
										<label> <input name="remember" type="checkbox"
											value="Remember Me">Remember Me
										</label>
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<button type = "submit" class="btn btn-lg btn-info btn-block">Login</button>
								</fieldset>
								
							</form>
						</div>
					</div>
				</div>
					<center><a href = "register.jsp">Create an Account</a></center>
			</div>
		</div>
	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


</body>
</html>