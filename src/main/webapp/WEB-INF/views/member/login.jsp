<%@ include file="../include/header.jsp" %>
	<form action="login" method="post">
		<div id="loginBox">
			<label>ID</label>
			<input type="text" name="userid"><br>
			
			<label>Password</label>
			<input type="password" name="userpw"><br>
			
			<c:if test="${msg != null}">
				<span style="color:red;">${msg}</span>
			</c:if>
			
			<input type="submit" value="Login">
		</div>
	</form>
<%@ include file="../include/footer.jsp" %>