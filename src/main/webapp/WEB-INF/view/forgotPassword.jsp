<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>

	<!------ Include the above in your HEAD tag ---------->
	<link rel="stylesheet" type="text/css" href="forgotPassword.css">

<form action="post">
<h4 style="color:red;">${msg}</h4>
	<div class="form-gap"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-center">
							<h3>
								<i class="fa fa-lock fa-4x"></i>
							</h3>
							<h2 class="text-center">Forgot Password?</h2>
							<p>You can reset your password here.</p>
							<div class="panel-body">

								<form id="register-form" role="form" autocomplete="off"
									class="form" method="post">

									<div class="form-group">
										<div class="input-group">
											<!--  <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span> -->
											<div class="form-group">
												<input type="text" class="form-control"
													placeholder="Username *" value="" name="username" />
											</div>
											<div class="form-group">
												<select class="form-control" name="question">
													<option class="hidden" selected disabled>Please
														select your Sequrity Question</option>
													<option>What is your Birthdate?</option>
													<option>What is Your old Phone Number</option>
													<option>What is your Pet Name?</option>
												</select>
											</div>
											<div class="form-group">
												<input type="text" class="form-control"
													placeholder="Enter Your Answer *" value="" name="answer" />
											</div>
											<div class="form-group">
												<input type="text" class="form-control"
													placeholder="New Password *" value="" name="password" />
											</div>
											<div class="form-group">
												<input type="password" class="form-control"
													placeholder="Confirm Password *" value="" />
											</div>


										</div>
									</div>
									<!-- <div class="form-group">
										<input name="recover-submit"
											class="btn btn-lg btn-primary btn-block"
											value="Reset Password" type="submit">
									</div> -->

									<div class="form-group">
										<input type="submit" class="btnRegister"
											value="Reset Password" formaction="forgotPasswordOfUser"
											formmethod="post">
									</div>
									<br>
									<br>
									<br>
									<br>

									<!-- <div class="form-group">
										<input type="submit" class="btnRegister" value="Login"
											formaction="/">
									</div> -->
									
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</html>
