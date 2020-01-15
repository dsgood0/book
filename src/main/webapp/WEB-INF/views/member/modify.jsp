<%@ include file="../include/header.jsp"%>
	<div id="container">
	<form action="modify" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td>
					${member.userid}
					<input type="hidden" name="userid" value="${member.userid}">
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="password" name="userpw">
				</td>
			</tr>
			<tr>
				<td>Password Check</td>
				<td>
					<input type="password" name="pwcheck">
				</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>
					${member.name}
					<input type="hidden" name="name" value="${member.name}">
				</td>
			</tr>
			<tr>
				<th>Birth</th>
				<fmt:formatDate var="birth" value="${member.birth}" pattern="yyyy-MM-dd"/>
				<td>
					<input type="date" name="birth" value="${birth}">
				</td>
			</tr>
			<tr>
				<th>Gender</th>
				<td>
					<select name="gender">
					<c:if test="${member.gender == 1}">
						<option value="1" selected="selected">Male</option>
						<option value="0">Female</option>
					</c:if>
					<c:if test="${member.gender == 0}">
						<option value="1">Male</option>
						<option value="0" selected="selected">Female</option>
					</c:if>
					</select>
				</td>
			</tr>
			<tr>
				<th>Member Type</th>
				<td>${member.membertype.divname}</td>
			</tr>
		</table>
		<input type="submit" value="Modify">
		</form>
		<a href="/member/detail">Go Back</a>
	</div>
<%@ include file="../include/footer.jsp" %>