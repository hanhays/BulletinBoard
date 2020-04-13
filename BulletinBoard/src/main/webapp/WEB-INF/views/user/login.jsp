<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <style type="text/css">
  	.row{
  		align-content: center;
  		margin: 50px;
  	}
  	.form-group{
  		padding: 15px;
  	}
  
  </style>
  
</head>

<body>
	<div class="container">
		<div class="row">
			<form action="/user/loginPost" method="post">
			
				<div class="form-group">
					<label class="col-xs-2 control-label"  for="id">ID</label>
					<div class="col-xs-10 " >
						<input class="form-control" id="id" name="id">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-label"  for="pw">PW</label>
					<div class="col-xs-10">
						<input class="form-control" id="pw" name="pw" type="password">
					</div>
				</div>
				
				<div class="form-group">
					<span class="col-xs-2"></span>
					<div class="col-xs-10">
						<input class="form-control btn btn-info" type="submit" value="Login" >
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>