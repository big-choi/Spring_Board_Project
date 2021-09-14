<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- 부트스트랩 연결 -->
<link href="${path}/resources/css/member/join.css" rel="stylesheet"
	id="bootstrap-css">
<script src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${path}/resources/static/libs/jquery-3.6.0.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<form id="/join_form" method="post">
		<div class="container">
			<h1>회원가입</h1>
			<hr>

			<label for="id"><b>아이디</b></label> <input type="text"
				placeholder="아이디를 입력해주세요" name="id" required> <label
				for="pwd"><b>비밀번호</b></label> <input type="password"
				placeholder="비밀번호를 입력해주세요" name="password" required> <label
				for="pwd-repeat"><b>비밀번호 확인</b></label> <input type="password"
				placeholder="비밀번호를 다시 입력해주세요" name="pwd-repeat"> <label
				for="name"><b>이름</b></label> <input type="text"
				placeholder="이름을 입력해주세요" name="name" required> <label
				for="email"><b>이메일</b></label> <br> <input type="text"
				placeholder="이메일을 입력해주세요" name="email" required
				style="width: 300px;"> @ <input type="text" placeholder=""
				name="email" required style="width: 150px;">
			<button type="button" class="emailNumber" style="width: 200px;">인증번호
				발송</button>
			<br> <label for="address"><b>주소</b></label> <br> <input
				type="text" placeholder="주소를 입력해주세요" name="address1" required
				style="width: 300px;">
			<button type="button" class="searchAddress" style="width: 100px;">주소찾기</button>
			<br> <input type="text" placeholder="" name="address2" required
				style="width: 300px;"> <input type="text" placeholder=""
				name="address3" required>

			<p>
				이미 아이디가 있으신가요? <a href="/member/login" style="color: dodgerblue">Login</a>.
			</p>

			<div class="clearfix">
				<button type="button" class="cancelbtn" onclick="location.href='/mainPage' ">돌아가기</button>
				<button type="submit" class="signupbtn">가입하기</button>
			</div>
		</div>
	</form>

	<script>
	
	//jQuery
	$(document).ready(function(){
		//회원가입 버튼(기능 작동)
		$(".signupbtn").click(function(){
			$("#join_form").attr("action", "/member/join");
			$("#join_form").submit();
		});
	});
	
	</script>
</body>
</html>
