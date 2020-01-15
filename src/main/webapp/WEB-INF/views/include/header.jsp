<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${titleName}</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
	@import url('https://fonts.googleapis.com/css?family=Courier+Prime&display=swap');
	
	#wrapper {
		width: 100%;
		margin: 0;
		padding: 0;
	}
	header {
		
	}
	header #logoBox {
		width: 200px;
		height: 100%;
		float: left;
		font-family: 'Courier Prime', monospace;
		position: relative;
	}
	
	header #logoBox:hover {
		cursor: pointer;
	}
	
	header #logoBox #roofImg {
		position: absolute;
		width: 150px;
		top: 5px;
		left: 10px;
	}
	
	header #logoBox #bottomImg {
		position: absolute;
		width: 150px;
		top: 125px;
		left: 10px;
	}
	
	header #logoBox #logoText {
		display: inline-block;
		padding-top: 70px;
		padding-left: 5px;
		font-size: 40px;
	}
	
	#searchBox {
		margin-top:25px;
		margin-bottom:40px;
		text-align:center;
	}
	
	#searchBox select, #searchBox input{
		font-size:20px;
	}
	
	#headerContainer {
		display: flex;
		padding: 10px 50px;
		height:150px;
		margin-bottom:20px;
		border-bottom:2px solid black;
	}
	
	#headerContainer > #searchBoxContainer {
		flex-grow: 1;
		padding-left: 50px;
		padding-right: 50px;
	}
	nav ul {
		list-style: none;
		width:100%;
		height:100%;
		margin-top:20px;
	}
	
	nav ul li {
		float: left;
		width: 18%;
		height: 100%;
		text-align:center;
	}
	nav ul li a {
		text-decoration: none;
		color:black;
		font-size:20px;
		display:block;
	}
	nav ul li a:hover {
		text-decoration: underline;
	}
	#loginBox {
		float: left;
		padding-top: 10px;
		margin-top: 40px;
	}
	
	.loginBox {
		display: inline-block;
		color: black;
		border: 1px solid black;
		padding: 5px;
		text-decoration: none;
	}
	
	.loginBox:hover {
		color:white;
		background:black;
	}
	
	#loginBox #loginState a {
		border: none;
		color: #6799FF;
	}
	
	#loginBox #loginState a:hover {
		text-decoration: underline;
	}
</style>
<script>
	$(function() {
		$("#logoBox").click(function() {
			location.href = "${pageContext.request.contextPath}/book/home";
		})
	})	
</script>
<body>
	<div id="wrapper">
		<header id="headerContainer">
			<div id="logoBox">
				<img id="roofImg"
					src="${pagContext.request.contextPath}/resources/image/roof.png">
				<span id="logoText">Library</span> <img id="bottomImg"
					src="${pagContext.request.contextPath}/resources/image/bottom.png">
			</div>
			<div id="searchBoxContainer">
				<div id="searchBox">
					<form action="search" method="post">
						<select name="type">
							<option value="title">Title</option>
							<option value="author">Author</option>
							<option value="publisher">Publisher</option>
						</select> 
						<input type="text" name="text">
						<input type="submit" value="Search">
					</form>
				</div>
				<nav>
					<ul>
						<li><a href="/book/list">Find Book</a></li>
						<li><a href="#">Program</a></li>
						<li><a href="#">Open Place</a></li>
						<li><a href="#">Introduction</a></li>
						<li><a href="#">My Library</a></li>
					</ul>
				</nav>
			</div>
			<div id="loginBox">
				<c:if test="${Auth == null}">
					<a class="loginBox" href="/member/login">LOGIN</a>
					<a class="loginBox" href="/member/join">JOIN</a>
				</c:if>
				<c:if test="${Auth != null}">
					<span id="loginState"><a href="/member/detail">${Auth}</a>,
						Hi</span>
					<a class="loginBox" href="/member/logout">LOGOUT</a>
				</c:if>
			</div>
		</header>