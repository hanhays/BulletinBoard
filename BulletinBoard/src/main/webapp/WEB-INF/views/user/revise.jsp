<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enroll</title>
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

<jsp:include page="../header.jsp"></jsp:include>

<h2 class="jumbotron" style="text-align: center">Revise</h2>
	<div class="container">
		<div class="row">
			<form action="/user/revise" method="post">
				<div class="form-group">
					<label class="col-xs-2 control-label" for="id">ID</label>
					<div class="col-xs-10">
						<input class="form-control" id="id" name="id" readonly value="${dto.id }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="pw">PW</label>
					<div class="col-xs-10">
						<input class="form-control" id="pw" name="pw" type="password" required maxlength="30" placeholder="${dto.pw }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="name">Name</label>
					<div class="col-xs-10">
						<input class="form-control" id="name" name="name" type="text" required maxlength="10" placeholder="${dto.name }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="birth">Birth</label>
					<div class="col-xs-10">
						<input class="form-control" id="birth" name="birth" type="date" placeholder="${dto.birth }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2 control-label" for="email">Email</label>
					<div class="col-xs-10">
						<input class="form-control" id="email" name="email" type="email" placeholder="${dto.email }">
					</div>
				</div>
				<div class="form-group">
					<span class="col-xs-2"></span>
					<div class="col-xs-10">
						<input class="form-control btn btn-info" type="submit" value="Revise" >
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>