<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.company.fingoals.dto.User"%>
<%@ page import="com.company.fingoals.action.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Goal</title>
<meta name="viewport" content="width=device-width,initial-scale = 1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="addgoal.css">
<link rel="stylesheet" href="companyDetails.css">
</head>
<body>
<%
		User user = (User) session.getAttribute("user");
%>

	<div class="navbar navbar-inverse navbar-static-top nopaddig">					
		<div class="container">
			<div class="row">
				<div class="navbar-header">

					<a href="#" class="navbar-brand">Fin Goals</a>

					<button class="navbar-toggle" data-toggle="collapse"
						data-target=".navHeaderCollapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<div class="collapse navbar-collapse navHeaderCollapse">

					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Welcome <%=user.getFirstName()%></a></li>
						<li><a href="./goals">Goals</a></li>
						<li><a href="./investments">Investments</a></li>
						<li><a href="./logout">Logout</a></li>
					</ul>

				</div>				

			</div>
			
		</div>
		
	</div>
	
