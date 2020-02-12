<%@ include file="../include/header.jsp" %>
<style>
	#loginForm {
		border:2px solid black;
		padding:20px;
		width:300px;
		margin:0 auto;
		margin-top:150px;
		position:relative;
	}
	#loginForm label {
		display:inline-block;
		width:68px;
		margin-right:5px;	
	}
	#loginForm input[type='submit'] {
		position:absolute;
		top:20px;
		right:10px;     
		border:1px solid black;
		font-size:18px;
		background-color:white;
		padding:12px 5px;
	}
	#loginForm input[type='submit']:hover {
		color:white;
		background-color:black;
		cursor:pointer;
	}
</style>
	<div id="wrapper">
		<form action="login" method="post">
			<div id="loginForm">
				<label>ID</label>
				<input type="text" name="userid" autofocus="autofocus"><br>
				
				<label>Password</label>
				<input type="password" name="userpw"><br>
				
				<c:if test="${msg != ''}">
					<span style="color:red;">${msg}</span>
				</c:if>
				
				<input type="submit" value="Login">
			</div>
		</form>
	</div>
	<script>
		$("form").submit(function() {
			var userid = $("input[name='userid']").val();
			var regid = /^[a-zA-Z0-9]{4,12}$/;
			if(regid.test(userid) == false) {
				alert("Please Check ID (English or Numbers 4~12)");
				return false;
			}
			
			var userpw = $("input[name='userpw']").val();
			var regpw = /^[a-zA-Z0-9]{4,20}$/;
			if(regpw.test(userpw) == false) {
				alert("Please Check Password (English or Numbers 4~20)");
				return false;
			}
		})
	</script>
<%@ include file="../include/footer.jsp" %>