<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Home</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<section>
	<div class="container">
		<h3>Life's Carousel</h3><br>
		<div class="carousel slide" data-ride="carousel" id="myCarousel">
	
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li class="active" data-target="#myCarousel" data-slide-to="0"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>
	
		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img alt="modena" src="/resources/img/acetaia.jpg" style="width: 100%;">
				<div class="carousel-caption">
					<h3>Accetaia in Modena, Emilia-Romagna</h3>
					<p>Got the sweet sour-aromatic precious thing.</p>				
				</div>
			</div>
			<div class="item">
				<img alt="assisi" src="/resources/img/brokenprc.JPG" style="width: 100%;">
				<div class="carousel-caption">
					<h3>Assisi in Umbria</h3>
					<p>The precious thing was broken.</p>
				</div>
			</div>
		</div>
	
		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
			<span class="sr-only">Next</span>
		</a>
	
		</div>
	</div>
</section>
<br>
 <footer>
	<P style="text-align: center;">The time on the server is ${serverTime}.</P>
 </footer>

</body>
</html>
