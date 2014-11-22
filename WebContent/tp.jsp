<!DOCTYPE html>
<html lang="eng">
<head>
<title>Contact form</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">


  <body>
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
            <li><a href="#">Page 3</a></li>
          </ul>
        </div>
      </div>
    </nav>
  
    <div class="container">
      <div class="jumbotron">
        <h1>My first Bootstrap website!</h1>      
        <p>This page will grow as we add more and more components from Bootstrap...</p>      
        <a href="#" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-search"></span> Search</a>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </div>
        <div class="col-md-3"> 
          <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
        <div class="col-md-3"> 
          <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
        </div>
        <div class="col-md-3">
          <ul class="nav nav-pills nav-stacked">
            <li class="active"><a href="#">Home</a></li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Submenu 1-1</a></li>
                <li><a href="#">Submenu 1-2</a></li>
                <li><a href="#">Submenu 1-3</a></li>                        
              </ul>
            </li>
            <li><a href="#">Menu 2</a></li>
            <li><a href="#">Menu 3</a></li>
          </ul>
        </div>
        <div class="clearfix visible-lg"></div>
      </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


	<br />
	<!-- a row has to be in a container -->
	<div class="container">
		<!-- Contacts -->
		<div id="contacts">
			<div class="row">
				<!-- Alignment -->
				<div class="col-sm-offset-3 col-sm-6">
					<!-- Form itself -->
					<form name="myform" class="well" id="myform" method="post"
						action="./CompanyLinks">
						<input type="hidden" name="companyname" />
						<legend>Contact me</legend>
						<div class="control-group">
							<div class="controls">
								<input type="text" class="form-control" placeholder="Full Name"
									id="name" required
									data-validation-required-message="Please enter your name" />
								<p class="help-block"></p>
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="email" class="form-control" placeholder="Email"
									id="email" required
									data-validation-required-message="Please enter your mail id" />
								<p class="help-block"></p>
							</div>
						</div>

						<div class="control-group">
							<div class="controls">
								<textarea rows="10" cols="100" class="form-control"
									placeholder="Message" id="message" required
									data-validation-required-message="Please enter your message"
									minlength="5"
									data-validation-minlength-message="Min 5 characters"
									maxlength="999" style="resize: none"></textarea>
								<p class="help-block"></p>
							</div>
						</div>
						<div class="input-group">
							<label class="input-group-btn" for="date-fld"> 
							<span
								class="btn btn-default"> <span
									class="glyphicon glyphicon-calendar"></span>
							</span>
							</label> <input type="text" class="form-control laks-date-input" id="date-fld" />
							
						</div>
						<p class="help-block"></p>
						<div id="success"></div>
						<!-- For success/fail messages -->
						<button type="button" id="myButton" data-loading-text="Loading..."
							class="btn btn-primary" autocomplete="off"
							onclick="myfunc('Apple');">Add</button>
						<br />
					</form>
				</div>-
			</div>
		</div>
	</div>


	<!-- JS FILES -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script>
		function myfunc(cn) {
			alert('df');
			document.myform.companyname.value = cn;
			document.myform.submit();
		}

			
		$(function () {
			  $(".laks-date-input").datepicker({ 
			        autoclose: true, 
			        todayHighlight: true
			  });
			});
	</script>

	<script
		src="https://raw.githubusercontent.com/eternicode/bootstrap-datepicker/master/js/bootstrap-datepicker.js"></script>
</body>
</html>
