<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<header>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">RememberBullet</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/board/listpage">Bulletin Board</a></li>
			</ul>
			<c:choose>
				<c:when test="${empty login }">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/user/login"> Sing In </a></li>
						<li><a href="/user/enroll"> Sing up </a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/user/logout"> Sing Out </a></li>
						<li><a href="/user/myinfo/${login.id}"> See My Info. </a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
</header>
</body>
</html>