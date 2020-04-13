<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.naver.dto.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Revise</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/resources/js/board.js"></script>

<style type="text/css">
	.uploadedList{
		list-style: none;
	}
	
	.uploadedList li{
		margin-top: 20px;
	}
	
	.fileDrop{
		width: 100%;
		height: 200px;
		border: 2px solid purple;
		background-color: lightpink;
	}
</style>

</head>

<body>
	<div class="container">
		<div class="row">
		
		<h2 class="jumbotron" style="text-align: center">Revise</h2>
		
			<form method="post" class="form-horizonal">
			<input type="hidden" name="curPage" value="${curPage }">
			
				<div class="form-group">
					<label class="col-xs-2 control-lable" for="bno">no.</label>
					<div class="col-xs-10">
						<input class="form-control" id="bno" name="bno" value="${vo.bno }" readonly="readonly">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-lable" for="writer">Writer</label>
					<div class="col-xs-10">
						<input class="form-control" id="writer" name="writer" value="${vo.writer }">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-lable" for="title">Title</label>
					<div class="col-xs-10">
						<input class="form-control" id="title" name="title" value="${vo.title}">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-xs-2 control-lable" for="content">Content</label>
					<div class="col-xs-10">
						<textarea class="form-control" rows="5" id="content" name="content">${vo.content }</textarea>
					</div>
				</div>
				
			</form>
			
			<div class="form-group">
				<label>Please drop the file you want to add..</label>
				<div class="fileDrop">
				
				</div>
			</div>
			
			<div class="form-group">
				<label>Uploaded File List</label>	
				<ul class="uploadedList clearfix">
					<%
						BoardVO vo = (BoardVO)request.getAttribute("vo");
						String[] filenames = vo.getFilenames(); 
						ObjectMapper mapper = new ObjectMapper();
						String filename = mapper.writeValueAsString(filenames);
						pageContext.setAttribute("filename", filename);
					%>
				</ul>		
			</div>
			
			
			<br>
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<button class="btn btn-primary">Revise</button>
					<button class="btn btn-warning">Cancel</button>
				</div>
			</div>
			
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			$(".btn-primary").click(function(){
				$("form").attr("action", "/board/update");
				
				var msg = ''
					
				$('.delbtn').each(function(index){
					var filename = $(this).attr("href");
					msg += '<input name="filenames['+index+']" value="'+filename+'" type="hidden">'
				});
				$('form').append(msg);
				$("form").submit();
			});
			
			$(".btn-warning").click(function(){
				location.assign("/board/listpage");
			});
			
			
			var arr = ${filename};
			for (var i = 0 ; i < arr.length ; i++ ){
				iconAppend(arr[i], true)
			}
			
			
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
					processData :	false,
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
				
				if(confirm('Attention : Are you sure to delete the file?')){
					$.ajax({
						type		:	'post',
						url			:	'/board/deletefile/${vo.bno}',
						data		:	{
							filename:filename
						},
						dataType	:	'text',
						success		:	function(data){
							alert(data);
							that.parents('li').remove();
						}
					});
				}
				
			});
			
			
		});
	</script>
	
</body>
</html>