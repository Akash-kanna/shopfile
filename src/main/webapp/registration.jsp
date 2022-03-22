<%@page import="shoppingcart.ApplicationLogic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Register here...</title>

<link rel="stylesheet" href="registerStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />

<style>
.error {
  width  : 100%;
  padding: 0;
  font-size: 80%;
  color: white;
  background-color: #900;
  border-radius: 0 0 5px 5px;
  box-sizing: border-box;
}
.error.active {
  padding: 0.3em;
}
</style>

</head>


<body>

	<div class="container">
		<div class="header">
			<h2 style="text-align: center;">Create account</h2>
		</div>
		<form class="form" id="form" action="RegisterServlet" method="post">

			<div class="form-control">
				<label>User name</label> 
				<input type="text" placeholder="user name" id="name" name="name" required minlength="3">
				<span class="error" aria-live="polite"></span>
			</div>

			<div class="form-control">
				<label>Email</label> 
				<input type="text" placeholder="example@gmail.com" id="email" name="email" required  minlength="12">
				<span class="error" aria-live="polite"></span>
			</div>

			<div class="form-control">
				<label>Password</label> 
				<input type="password"	placeholder="password" id="password" name="password" required  minlength="8"> 
				<span class="error" aria-live="polite"></span>
			</div>

			<div class="form-control">
				<label>Confirm Password</label> 
				<input type="password" placeholder="Retype the password" id="password2" name="password2"  minlength="8">
				<span class="error" aria-live="polite"></span>
			</div>

			<input type="submit" value="Register" id="button">
			
			<h5 style="text-align: center;">
				Already have an account?<a style="text-decoration: none;"
					href="login.jsp"> sigin</a>
			</h5>
		</form>
	</div>
</body>
<script src=registrationValidation.js></script>
</html>