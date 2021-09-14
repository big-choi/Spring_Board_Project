<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- 부트스트랩 연결 -->
<link href="${path}/resources/css/member/login.css"
	rel="stylesheet" id="bootstrap-css">
<script src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${path}/resources/static/libs/jquery-3.6.0.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->


			<!-- Login Form -->
			<form>
			<h3 style="text-align: center;">환영합니다</h3>
				<input type="text" id="login" class="fadeIn second" name="login"
					placeholder="ID"> <input type="text" id="password"
					class="fadeIn third" name="login" placeholder="Password"> <input
					type="submit" class="fadeIn fourth" value="Log In">
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>
			<!-- 회원가입 -->
			<div id="formFooter">
				<a class="underlineHover" href="/member/join">회원가입</a>
			</div>

		</div>
	</div>
</body>
</html>
