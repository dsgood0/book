<%@ include file="../include/header.jsp"%>
<style>
	#container #bookImage {
		width:210px;
		height:280px;
	}
</style>
<div id="container">
	<table>
		<tr>
			<th>Image</th>
			<c:if test="${book.imgsrc == ''}">
					<td>
						<img id="bookImage" src="${pageContext.request.contextPath}/resources/image/no_book_icon.png"><br>
						<input type="file" name="imgFile">
					</td>				
				</c:if>
				<c:if test="${book.imgsrc != ''}">
					<td>
						<img id="bookImage" src="${pageContext.request.contextPath}/upload/displayFile?filename=${book.imgsrc}"><br>
						<input type="file" name="imgFile">
					</td>
				</c:if>
		</tr>
		<tr>
			<th>ISBN</th>
			<td>${book.isbn}</td>
		</tr>
		<tr>
			<th>Type</th>
			<td>
				<select name="type" data-type="${book.booktype.no}">
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
	</table>

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
</script>
<%@ include file="../include/footer.jsp"%>