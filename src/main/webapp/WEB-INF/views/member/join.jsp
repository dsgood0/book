<%@ include file="../include/header.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<div id="wrapper">
		<form action="join" method="post" id="frm">
		 	<div id="joinBox">
		 		<label>ID</label>
				<input type="text" name="userid">
				<button type="button" id="idcheck">ID Check</button><br>
				
				<label>Password</label>
				<input type="password" name="userpw"><br>
				
				<label>Password Check</label>
				<input type="password" id="pwcheck"><br>
				
				<label>Name</label>
				<input type="text" name="name"><br>
				
				<label>Gender</label>
				<select name="gender">
					<option value="1" selected="selected">Male</option>
					<option value="0">Female</option>
				</select><br>
				
				<label>Birth</label>
				<input type="date" name="birth"><br>
				
				<input type="submit" value="Join">
		 	</div>
	 	</form>
	 </div>
	 	<script>
	 		var idchk = 0;
	 		
	 		$("input[name='userid']").change(function() {
	 			idchk = 0;
	 		})
	 	
	 		$("#idcheck").click(function() {
	 			var userid = $("input[name='userid']").val();
	 			
	 			$.ajax({
	 				url:"${pageContext.request.contextPath}/member/idcheck?userid="+userid,
	 				type:"get",
	 				datatype:"text",
	 				success:function(res) {
	 					console.log(res);
	 					if(res == "success") {
	 						alert("Available ID");
	 						idchk = 1;
	 					} else {
	 						alert("Exists ID");
	 					}
	 				}, error:function(e) {
	 					console.log(e);
	 				}
	 			})
	 		})
	 		
	 		/* $("form").submit(function() {
	 			if(idchk == 0) {
	 				alert("ID Check Please");
	 				return false;
	 			} 
	 		}) */
	 		
	 		
	 	</script>
<%@ include file="../include/footer.jsp" %>