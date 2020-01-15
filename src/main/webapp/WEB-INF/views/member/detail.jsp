<%@ include file="../include/header.jsp"%>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<td>${member.userid}</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>${member.name}</td>
			</tr>
			<tr>
				<th>Birth</th>
				<fmt:formatDate var="birth" value="${member.birth}" pattern="yyyy-MM-dd"/>
				<td>${birth}</td>
			</tr>
			<tr>
				<th>Gender</th>
				<td>${member.gender}</td>
			</tr>
			<tr>
				<th>Member Type</th>
				<td>${member.membertype.divname}</td>
			</tr>
			<tr>
				<th>Regdate</th>
				<fmt:formatDate var="date" value="${member.regdate}" pattern="yyyy-MM-dd"/>
				<td>${date}</td>
			</tr>
		</table>
		<a href="/member/modify">Modify</a>
		<a href="/member/withdraw">Withdraw</a>
	</div>
<%@ include file="../include/footer.jsp" %>