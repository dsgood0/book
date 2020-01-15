<%@ include file="../../include/header.jsp"%>
<style>
	#loanMenu div {
		float:left;
		font-size:22px;
		padding:10px;
	}
	#loanMenu div:hover {
		cursor:pointer;
		background-color:#BDBDBD;
	}
	#loanMenu .selectMenu {
		border-bottom:none;
		background-color:#EAEAEA;
	}
	#loanBox #selectBox {
		clear:both;
	}
	#selectBox table {
		background-color:#EAEAEA;
	}
</style>

<div id="container">
	<div id="loanBox">
		<div id="loanMenu">
			<div class="selectMenu">Loaning Book</div>
			<div data-link="">Loaned Book</div>
			<div data-link="">Reserved Book</div>
			<div data-link="">Hope Book</div>
		</div>
		
		<div id="selectBox">
			<table>
				<tr>
					<th>Book Detail</th>
					<th>Loan Date</th>
					<th>Expected Return Date</th>
					<th>Return State</th>
				</tr>
				<c:forEach var="loan" items="${loan}">
					<tr>
						<td>
							<a href="/book/read?isbn=${loan.isbn}">
								<span class="title">${loan.book.title}</span><br>
								<span class="author">${loan.book.author}</span><br>
								<span class="publisher">${loan.book.publisher}</span>
							</a>
						</td>
						<fmt:formatDate var="sdate" value="${loan.startdate}" pattern="yyyy-MM-dd"/>
						<fmt:formatDate var="maydate" value="${loan.mayEndDate}" pattern="yyyy-MM-dd"/>
						<td>
							${sdate}
						</td>
						<td>				
							${maydate}
						</td>
						<td>
							<c:if test="${loan.extend == 1}">
								Extending
							</c:if>
							<c:if test="${loan.extend == 0}">
								Loaning
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<%@ include file="../../include/footer.jsp"%>