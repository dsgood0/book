<%@ include file="../include/header.jsp" %>
	<style>
		#imagebox img{
			width:180px;
			height:250px;
		}
	</style>
	 	<div id="container">
	 		<form action="register" method="post" enctype="multipart/form-data">
		 		<label>ISBN</label>
		 		<span id="booktype"></span>
		 		<span id="today">${today}</span>
		 		<input type="text" name="isbn"><br>
		 		
		 		<label>Type</label>
		 		<select name="booktype.no">
		 			<c:forEach var="bt" items="${booktype}">
		 				<option value="${bt.no}" data-type="${bt.type}">${bt.divname}</option>
		 			</c:forEach>
		 		</select><br>
		 		
		 		<label>Title</label>
		 		<input type="text" name="title"><br>
		 		
		 		<label>Introduce</label>
		 		<textarea name="intro" rows="5" cols="30"></textarea><br>
		 		
		 		<label>Author</label>
		 		<input type="text" name="author"><br>
		 		
		 		<label>Publisher</label>
		 		<input type="text" name="publisher"><br>
		 		
		 		<label>Img File</label>
		 		<input type="file" name="imgfile"><br>
		 		
		 		<div id="imagebox">
		 		</div>
		 		
		 		<input type="submit" value="Regist">
	 		</form>
	 	</div>
	 
	 <script>
	 	$("select[name='booktype.no']").find("option").eq(0).attr("selected", "selected");
	 	var type = $("select[name='booktype.no']").find("option").eq(0).attr("data-type");
	 	$("#booktype").text(type);
	 	
	 	$("select[name='booktype.no']").change(function() {
	 		var type = $(this).find("option").eq($(this).prop("selectedIndex")).attr("data-type");
	 		$("#booktype").text(type);
	 	})
	 	
	 	$("input[name='imgfile']").change(function() {
	 	
		$("#imagebox").empty();
		$("#imagebox").css("display", "block");
		
		for(var i=0; i<$(this)[0].files.length; i++) {
		
			var file = $(this)[0].files[i];
			
			var reader = new FileReader();
			reader.readAsDataURL(file); // 파일 읽음
			reader.onload = function(e) {
				var $img = $("<img>").attr("src", e.target.result); // result : image data-byte[]
				$("#imagebox").append($img);
				}	
			}
	 	})
	 </script>
</body>
</html>