<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>

<jsp:include page="../header.jsp"></jsp:include>

<h2 class="jumbotron" style="text-align: center">Bulletin Board</h2>

	<div class="container">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>no.		</th>
						<th>Title	</th>
						<th>Writer	</th>
						<th>Date	</th>
						<th>Hit		</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${to.list }" var="vo">
						<tr>
							<td>${vo.bno }			</td>
							<td style="text-align: left">
								<c:forEach begin="1" end="${vo.indent }">&ensp;</c:forEach>
								<c:forEach begin="1" end="${vo.indent }">Re:</c:forEach>
								<a href="/board/read/${vo.bno }?curPage=${to.curPage}">${vo.title }</a>
							</td>
							<td>${vo.writer }		</td>
							<td>${vo.updatedate }	</td>
							<td>${vo.readcnt }		</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div> <!-- class = row -->
		
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<c:forEach begin="${to.beginPage }" end="${to.stopPage }" var="va">
						<li class="${to.curPage == va? 'active': ' ' }"><a href="/board/listpage?curPage=${va }">${va }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		
		<c:if test="${not empty login }">
			<div class="row">
				<a href="/board/insert" class="btn btn-primary">Write</a>
			</div> <!-- class = row -->
		</c:if>
		 
	</div><!-- class = container -->
	
</body>
</html>