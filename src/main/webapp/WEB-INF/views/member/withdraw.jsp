<%@ include file="../include/header.jsp"%>
	<div>
		<form action="withdraw" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td>${member.userid}</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>
						<input type="password" name="userpw">
					</td>
				</tr>
			</table>
		<input type="submit" value="Withdraw">
		</form>
		<c:if test="${msg != null}">
			<span style="color:red;">${msg}</span>
		</c:if>
		<a href="/member/detail">Go Back</a>
	</div>
<%@ include file="../include/footer.jsp" %>