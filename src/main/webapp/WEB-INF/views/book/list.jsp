<%@ include file="../include/header.jsp"%>
<style>
	.bookInfo img {
		width:80px;
		height:120px;
	}
</style>
<div>
	<table>
		<tr>
			<th>Image</th>
			<th>ISBN</th>
			<th>Type</th>
			<th>Title</th>
			<th>Author</th>
			<th>Publisher</th>
			<th>Regdate</th>
			<th>Loan Count</th>
			<th>Book Count</th>
		</tr>
		<c:forEach var="book" items="${booklist}">
			<tr data-isbn="${book.isbn}" class="bookInfo">
				<c:if test="${book.imgsrc == ''}">
					<td>
						<img src="${pageContext.request.contextPath}/resources/image/no_book_icon.png">
					</td>				
				</c:if>
				<c:if test="${book.imgsrc != ''}">
					<td>
						<img src="${pageContext.request.contextPath}/upload/displayFile?filename=${book.imgsrc}">
					</td>
				</c:if>
				<td>${book.isbn}</td>
				<td>${book.booktype.divname}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.publisher}</td>
				<fmt:formatDate var="date" value="${book.bookdetail.regdate}" pattern="yyyy-MM-dd"/>
				<td>${date}</td>
				<td>${book.loancnt}</td>
				<td>${book.cnt}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script>
	$(".bookInfo").click(function() {
		var isbn = $(this).attr("data-isbn");
		location.href = "/book/read?isbn="+isbn;
	});
</script>
<%@ include file="../include/footer.jsp" %>

