<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.naver.dto.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script src="/resources/js/board.js" type="text/javascript"></script>

<style type="text/css">
	.uploadedList{
		list-style: none;
	}
	.board img icon{
		cursor: pointer;
	}
</style>

</head>

<body>

<jsp:include page="../header.jsp"></jsp:include>

<h2 class="jumbotron" style="text-align: center">Read</h2>
	
	<div class="container">
		<div class="row">
		
			<div class="form-group">
				<label for="title">Title</label>
				<input class="form-control" readonly="readonly" name="title" value="${vo.title }" id="title">
			</div>
			
			<div class="form-group">
				<label for="writer">Writer</label>
				<input class="form-control" readonly="readonly" name="writer" value="${vo.writer }" id="writer">
			</div>
			
			<div class="form-group">
				<label for="title">content</label>
				<textarea rows="5" class="form-control" id="content" readonly="readonly" name="content">${vo.content }</textarea>
			</div>
			
		</div><!-- class = row -->
		
		
		<div class="form-group">
			<label>Attached Files</label>
			<ul class="uploadedList clearfix">
				<%
					BoardVO vo = (BoardVO)request.getAttribute("vo");
					String[] arr = vo.getFilenames();
					ObjectMapper mapper = new ObjectMapper();
					String filenames = mapper.writeValueAsString(arr);
					pageContext.setAttribute("filenames", filenames);
				%>
			</ul>
		</div>
		
		
		<div class="row">
			<form>
				<input type="hidden" name="bno" value="${vo.bno }">
				<input type="hidden" name="curPage" value="${curPage }">
			</form>
			
			<div class="form-group">
			
				<button class="btn btn-primary">Back to List</button>
				
				<c:if test="${vo.writer == login.id }">
					<button class="btn btn-success">Revise</button>
					<button class="btn btn-danger">Delete</button>
				</c:if>
				
				<c:if test="${not empty login }">
					<button class="btn btn-default" id="reply_form">Reply</button>
					<button class="btn btn-info" id="comment_form">comment</button>
				</c:if>
				
			</div>
		</div>
		
		<div class="row">
			<div class="collapse" id="myCollapsible">
				<div class="form-group">
					<label for="menter">Commenter</label>
					<input class="form-control" id="menter" name="menter" value="${login.id }" readonly="readonly">
				</div>
				
				<div class="form-group">
					<label for="ment">Comment</label>
					<input class="form-control" id="ment" name="ment">
				</div>
				
				<div class="form-group">
					<button class="btn btn-warning" id="insertComment">Comment</button>
					<button class="btn btn-default">cancel</button>
				</div>
			</div>
		</div><!-- class = row -->
		
		
		
		<div class="row">
			<div id="comments"></div>
		</div>
		
		
		<div class="row">
			<div id="myModal" class="modal">
				<div class="modal-dialog">
				
					<div class="modal-header">
						<button class="close" data-dismiss="modal">&times;</button>
						<p id="modal_cno">${cno }</p>
					</div>
					
					<div class="modal-body">
						<input value="${ment} " class="form-control" id="modal_ment">
					</div>
					
					<div class="modal-footer">
						<button data-dismiss="modal" id="modal_update" class="btn btn-warning btn-xs">revise</button>
						<button data-dismiss="modal" id="modal_close" class="btn btn-warning btn-xs">cancel</button>
					</div>
					
				</div>
			</div>
		</div>
		
	</div><!-- class=container -->
	
	<script type="text/javascript">
	
	var bno = ${vo.bno};
	
		$(document).ready(function(){
			
			var arr = ${filenames};
			for (var i=0; i<arr.length; i++){
				iconAppend(arr[i], false);
			}
			$('.uploadedList').on('click', '.board_img_icon', function(){
				var filename = $(this).attr('data-url');
				if(checkImg(filename)){
					filename = getImgName(filename);
				}
				location.assign('/board/display?filename='+filename);
			});

			$(".btn-primary").click(function(){
				location.assign("/board/listpage?curPage=${curPage}");				
			});
			
			$(".btn-success").click(function(){
				$("form").attr("method", "get");
				$("form").attr("action", "/board/update");
				$("form").submit();
			});
			
		    $(".btn-danger").click(function(){
		    	var result = confirm("Are you sure to delete?");
		    	if(result){
		    		$("form").attr("method", "get");
					$("form").attr("action", "/board/delete");
					$("form").submit();
					alert("Deleted..");
		    	}
			});
		    
		    $('#reply_form').click(function(){
		    	$('form').attr('method', 'get');
		    	$('form').attr('action', '/board/reply');
		    	$('form').submit();
		    });
		   
			
		    
			$('#comment_form').click(function(){
				$('#myCollapsible').collapse('toggle');
			});
			
			$('#insertComment').click(function(){
				var menter = $('#menter').val();
				var ment = $('#ment').val();
				
				$.ajax({
					type	:	'post',
					url		:	'/comments',
					headers	:	{
						'Content-Type'			: 'application/json',
						'X-HTTP-Method-Override': 'POST'
					},
					data	:	JSON.stringify({
						bno			:	bno,
						menter		:	menter,
						ment		:	ment
					}),
					dataType:	'text',
					success :	function(result){
						alert(result);
						$('#ment').val('');
						getList(bno);
					}
				});
			});
			
		    getList(bno);
		    
		    $("#comments").on("click", ".btn-delete", function(){
		    	var cno = $(this).parent().attr("data-cno");
		 
		    	$.ajax({
		    		type	:	'delete',
		    		url		:	'/comments/'+cno,
		    		headers :	{
		    			'Content-Type' 			: 'application/json',
		    			'X-HTTP-Method-Override': 'DELETE'
		    		},
		    		dataType:	'text',
		    		success :	function(result){
		    			alert(result);
		    			getList(bno);
		    		}
		    	});
		    	
		    });
		    
		    $("#comments").on("click",".btn-update", function(){
		    	$("#myModal").modal("show");
		    	
		    	var cno = $(this).parent().attr("data-cno");
		    	var ment = $(this).prev("p").text();
		    	
		    	$("#modal_cno").text(cno);
		    	$("#modal_ment").val(ment);
		    	
		    });
		    
		    $("#modal_update").click(function(){
		    	var cno = $("#modal_cno").text();
		    	var ment = $("#modal_ment").val();
		    	
		    	$.ajax({
		    		type	:	'put',
		    		url 	:	'/comments',
		    		headers	:	{
		    			'Content-Type' 			: 'application/json',
		    			'X-HTTP-Method-Override': 'PUT'
		    		},
		    		data	:	JSON.stringify({
		    			cno			:	cno,
		    			ment		:	ment
		    		}),
		    		dataType:	'text',
		    		success :	function(data){
		    			alert(data);
		    			getList(bno);
		    		}
		    	});
		    	
		    });
		    
		});
		
		function getList(bno){
			$.getJSON("/comments/"+bno, function(data){
				var str ="";
				
				for(var i=0; i<data.length; i++){
					var obj = data[i];
				
					str += '<div class="panel panel-info">';
					str += '<div class="panel-heading">';
					str += '<span>cno : '+obj.cno+', commenter : '+obj.menter+'</span>';
					str += '<span class="pull-right">'+obj.updatedate+'</span></div>';
					str += '<div class="panel-body" data-cno="'+obj.cno+'">';
					str += '<p>'+obj.ment+'</p>';
					
					str += '<button class="btn btn-link btn-update">revise</button>';
					str += '<button class="btn btn-link btn-delete">delete</button>';
					
					str += '</div></div>';
				}
				$("#comments").html(str);
			});
		}
		
	</script> 
</body>
</html>