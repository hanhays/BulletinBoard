<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyInfo.</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.form-group{
	padding : 15px;
}
</style>
</head>

<body>

<jsp:include page="../header.jsp"></jsp:include>

<h2 class="jumbotron" style="text-align: center">My Info.</h2>
	<div class="container">
		<div class="row">
			<div class="form-group">
				<label class="col-xs-2 control-label" for="id">ID</label>
				<div class="col-xs-10">
					<input class="form-control" id="id" readonly value="${dto.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label" for="pw">PW</label>
				<div class="col-xs-10">
					<input class="form-control" id="pw" type="password" readonly value="${dto.pw }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label" for="name">Name</label>
				<div class="col-xs-10">
					<input class="form-control" id="name" readonly value="${dto.name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label" for="birth">Birth</label>
				<div class="col-xs-10">
					<c:set value="${fn:split(dto.birth,' ')[0] }" var="birth"/>
					<input class="form-control" id="birth" readonly value="${ birth }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label" for="email">Email</label>
				<div class="col-xs-10">
					<input class="form-control" id="email" readonly value="${dto.email }">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-2 control-label" ></label>
				<div class="col-xs-10">
					<a class="btn btn-info" href="/user/revise/${dto.id }">Revise My Info.</a>
					<a class="btn btn-success" data-toggle="modal" href="#mydelete">Delete My Account..</a>
				</div>
				<div class="modal fade" id="mydelete" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button style="align-content: right;" type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body" style="text-align: center;">
								<h3>Are you sure to delete Your Account?</h3><br>
								<a class="btn btn-warning" href="/user/delete/${dto.id }">Yes, I'm sure</a><br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>