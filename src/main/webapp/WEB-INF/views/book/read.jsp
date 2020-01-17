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
					<img id="bookImage" src="${pageContext.request.contextPath}/resources/image/no_book_icon.png">
				</td>				
			</c:if>
			<c:if test="${book.imgsrc != ''}">
				<td>
					<img id="bookImage" src="${pageContext.request.contextPath}/upload/displayFile?filename=${book.imgsrc}">
				</td>
			</c:if>
		</tr>
		<tr>
			<th>ISBN</th>
			<td>${book.isbn}</td>
		</tr>
		<tr>
			<th>Type</th>
			<td>${book.booktype.divname}</td>
		</tr>
		<tr>
			<th>Title</th>
			<td>${book.title}</td>
		</tr>
		<tr>
			<th>Author</th>
			<td>${book.author}</td>
		</tr>
		<tr>
			<th>Publisher</th>
			<td>${book.publisher}</td>
		</tr>
		<tr>
			<th>Intro</th>
			<td>${book.intro}</td>			
		</tr>
	</table>
	
	<div>
		<a href="/book/modify?isbn=${book.isbn}">Modify</a>
		<a href="/book/removeAll?isbn=${book.isbn}">Remove</a>
	</div>

	<table>
		<tr>
			<th>No</th>
			<th>Regdate</th>
			<th>Loan Available</th>
			<th>Return Expected Date</th>
			<th>Exist</th>
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
				<td>
					<c:if test="${bt.exist == 0}">
						-
					</c:if>
					<c:if test="${bt.exist == 1}">
						<a href="${pageContext.request.contextPath}/book/remove?bno=${bt.bno}">Remove</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../include/footer.jsp"%>