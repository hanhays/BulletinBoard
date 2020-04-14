<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reply</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="/resources/js/board.js" type="text/javascript"></script>
  
  <style type="text/css">
  	.fileDrop{
  		width: 100%; 
  		height: 200px;
  		border: 1px solid green;
  		background-color: lightslategray; 
  		margin: auto;
  	}
  	.uploadedList{
  		list-style: none;
  	}
  	.uploadedList li{
  		margin-top: 20px
  	}
  </style>
  
</head>

<body>
	<div class="container">
		<div class="row">
			<h2 class="jumbotron" style="text-align: center">Reply</h2>
			<form  method="post">
			<input type="hidden" name="curPage" value="${curPage }">
			<input type="hidden" name="parent_root" value="${vo.root }">
			<input type="hidden" name="parent_step" value="${vo.step }">
			<input type="hidden" name="parent_indent" value="${vo.indent }">
			
				<div class="form-group">
					<label for="title">Title</label>
					<input name="title" id="title" class="form-control" required>
				</div>	
				
				<div class="form-group">
					<label for="wirter">Writer</label>
					<input name="writer" id="writer" value="${login.id }" readonly="readonly" class="form-control">
				</div>
				
				<div class="form-group">
					<label for="content">Content</label>
					<textarea rows="5" name="content" id="content" class="form-control" required></textarea>
				</div>	
			</form>
			
			<div class="form-group">
				<label style="text-align: center">Drop the file you want to load</label>
				<div class="fileDrop"></div>
			</div>
			
			<ul class="uploadedList clearfix"></ul>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Reply</button>
				<button type="reset" class="btn btn-warning">Reset</button>
			</div>
			
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			$("button[type='submit']").click(function(event){
				event.preventDefault();
				
				var msg = ''
				
				$('.delbtn').each(function(index){
					var filename = $(this).attr("href");
					msg += '<input name="filenames['+index+']" value="'+filename+'" type="hidden">'
				});
				$('form').append(msg);
				$("form").submit();
			});
			
			$('button[type="reset"]').click(function(){
				$('form').each(function(){
					this.reset();
				});
			});
			
		
			$('.fileDrop').on('dragenter dragover', function(event){
				event.preventDefault();
			});
			
			$('.fileDrop').on('drop', function(event){
				event.preventDefault();
				
				var files = event.originalEvent.dataTransfer.files;
				var file = files[0];
				
				var formData = new FormData();
				formData.append("file", file);
				
				$.ajax({
					type		:	'post',
					url			:	'/uploadajax',
					data		:	formData,
					dataType	:	'text',
					processData	:	false, 
					contentType	:	false, 
					success		:	function(data){
						iconAppend(data, true);
					}
				});
			});
			
			
			$('.uploadedList').on('click', '.delbtn', function(event){
				event.preventDefault();
				var that = $(this);
				var filename = that.attr('href');
				
				$.ajax({
					type		:	'post',
					url			:	'/deletefile',
					data		:	{
						filename:filename
					},
					dataType	:	'text',
					success		:	function(data){
						alert(data);
						$(that).parents('li').remove();
					}
				});
			});
			
			
		});
	</script>
	
</body>
</html>