<%@ include file="../include/header.jsp"%>
<style>
	#container #bookImage {
		width:210px;
		height:280px;
	}
</style>
<div id="container">
<form action="/book/modify" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th>Image</th>
				<td id="imagebox">
					<c:if test="${book.imgsrc == ''}">
						<img id="bookImage" src="${pageContext.request.contextPath}/resources/image/no_book_icon.png"><br>
					</c:if>
					<c:if test="${book.imgsrc != ''}">
						<img id="bookImage" data-src="${book.imgsrc}" src="${pageContext.request.contextPath}/upload/displayFile?filename=${book.imgsrc}"><br>
					</c:if>
					<input type="file" name="imgfile" value="${pageContext.request.contextPath}/upload/displayFile?filename=${book.imgsrc}">
					<button id="btnDel" type="button">Delete</button>
				</td>
		</tr>
		<tr>
			<th>ISBN</th>
			<td>
				${book.isbn}
				<input type="hidden" name="isbn" value="${book.isbn}">
			</td>
		</tr>
		<tr>
			<th>Type</th>
			<td>
				<select name="booktype.no" data-type="${book.booktype.no}">
					<c:forEach var="type" items="${booktype}">
						<option value="${type.no}">${type.divname}</option>	
					</c:forEach>		
				</select>
			</td>
		</tr>
		<tr>
			<th>Title</th>
			<td><input type="text" name="title" value="${book.title}"></td>
		</tr>
		<tr>
			<th>Author</th>
			<td><input type="text" name="author" value="${book.author}"></td>
		</tr>
		<tr>
			<th>Publisher</th>
			<td><input type="text" name="publisher" value="${book.publisher}"></td>
		</tr>
		<tr>
			<th>Intro</th>
			<td><textarea name="intro">${book.intro}</textarea></td>			
		</tr>
		<tr>
			<td>
				<input type="submit" value="Modify">
				<button type="button" id="btnRead" data-isbn="${book.isbn}">Go Back</button>
			</td>
		</tr>
	</table>
	</form>

	<table>
		<tr>
			<th>No</th>
			<th>Regdate</th>
			<th>Loan Available</th>
			<th>Return Expected Date</th>
		</tr>
		<tr>
			<td>${bookdetail.bno}</td>
		</tr>
		<c:forEach var="bt" items="${book.bookdetail}">
			<tr>
				<td>${bt.bno}</td>
				<fmt:formatDate var="date" value="${bt.regdate}" pattern="yyyy-MM-dd"/>
				<td>${date}</td>
				<td><c:if test="${bt.loanAvail == 0}">
						Available
					</c:if>
					<c:if test="${bt.loanAvail == 1}">
						No Available
					</c:if>
				</td>
				<td>
					<c:if test="${bt.mayEndDate != null}">
					<fmt:formatDate var="edate" value="${bt.mayEndDate}" pattern="yyyy-MM-dd"/>
						${edate}
					</c:if>
					<c:if test="${bt.mayEndDate == null}">
						-
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script>
	var typename = $("select[name='type']").attr("data-type");
	$("select[name='type']").find("option").text();
	
	$("input[name='imgfile']").change(function() {
 		
		var filename = $("#imagebox").find("#bookImage").attr("src");
		
		$("#imagebox").find("#bookImage").remove();
		
		for(var i=0; i<$(this)[0].files.length; i++) {
		
			var file = $(this)[0].files[i];
				
			var reader = new FileReader();
			reader.readAsDataURL(file); // 파일 읽기
			reader.onload = function(e) {
				var $img = $("<img>").attr("src", e.target.result).attr("id", "bookImage"); // result : image data-byte[]
				$("#imagebox").prepend($img);
			}	
		}
	})
	
	$("#btnDel").click(function() {
		var filename = $("#bookImage").attr("data-src");
		
		var $input = $("<input>").attr("type", "hidden").attr("name", "delfile").val(filename);
		$("#imagebox").append($input);
		
		$("#bookImage").remove();
		
		var $img = $("<img>").attr("src", "${pageContext.request.contextPath}/resources/image/no_book_icon.png").attr("id", "bookImage");
		$("#imagebox").prepend($img);
		
		$("input[name='imgfile']").val("");
	})
	
	$("#btnRead").click(function() {
		var isbn = $(this).attr("data-isbn");
		location.href = "${pageContext.request.contextPath}/book/read?isbn="+isbn;
	})
</script>
<%@ include file="../include/footer.jsp"%>