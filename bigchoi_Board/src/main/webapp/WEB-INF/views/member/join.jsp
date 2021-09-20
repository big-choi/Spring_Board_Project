<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- 부트스트랩 연결 -->
<script src="${path}/resources/static/libs/jquery-3.6.0.min.js"></script>
<link href="${path}/resources/css/member/join.css" rel="stylesheet"
	id="bootstrap-css">
<script src="${path}/resources/bootstrap/js/bootstrap.min.js"></script>

<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<form id="/join_form" method="post">
		<div class="container">
			<h1>회원가입</h1>
			<hr>

			<div class="id_wrap">
				<label for="id"><b>아이디</b></label><br> <input type="text"
					placeholder="아이디를 입력해주세요" name="id" class="id_input" required
					style="width: 250px;">
			</div>
			<span class="id_input_re_1">사용 가능한 아이디입니다.</span> <span
				class="id_input_re_2">아이디가 이미 존재합니다.</span><br> 
			<div class ="pwd_wrap">
				<label
				for="pwd"><b>비밀번호</b></label> <input type="password"
				placeholder="비밀번호를 입력해주세요" name="password" required> <label
				for="pwd-repeat"><b>비밀번호 확인</b></label> <input type="password"
				placeholder="비밀번호를 다시 입력해주세요" name="pwd-repeat"> 
				</div>
			<div class="name_wrap">
				<label
				for="name"><b>이름</b></label> <input type="text"
				placeholder="이름을 입력해주세요" name="name" required>
			</div>
			
			
			<div class="mail_wrap">
				<label class="mail_name"><b>이메일</b></label> <br>
			<div class="mail_check_input_box">
					<input class="mail_input" type="text" placeholder="이메일을 입력해주세요" name="userEmail" required
				style="width: 300px;"> </div>
			<div class="mail_check_wrap">
			<div class="mail_check_input_box" id="mail_check_input_box_false" style="width:150px;">
				<input class="mail_check_input" disabled="disabled" type="text" placeholder=""
				name="email" required style="width: 150px;">
				</div>
			<button id="userEmail" type="button" class="mail_check_button" style="width: 200px;">인증번호
				발송</button>
				<span id="mail_check_input_box_warn"></span>
				</div>
			</div>
				
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
				<button type="button" class="cancelbtn"
					onclick="location.href='/mainPage' ">돌아가기</button>
				<button type="submit" class="signupbtn">가입하기</button>
			</div>
		</div>
	</form>

	<script>
		//jQuery
		
		var code = "";
		$(document).ready(function() {
			//회원가입 버튼(기능 작동)
			$(".signupbtn").click(function() {
				$("#join_form").attr("action", "/member/join");
				$("#join_form").submit();
			});
		});

		//아이디 중복검사
		$('.id_input').on(
				"propertychange change keyup paste input",
				function() {

					/* console.log("keyup 테스트"); */

					var id = $('.id_input').val(); // .id_input에 입력되는 값
					var data = {
						id : id
					} // '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'

					$.ajax({
						type : "post",
						url : "/member/memberIdChk",
						data : data,
						success : function(result) {
							if (result != 'fail') {
								$('.id_input_re_1').css("display",
										"inline-block");
								$('.id_input_re_2').css("display", "none");
							} else {
								$('.id_input_re_2').css("display",
										"inline-block");
								$('.id_input_re_1').css("display", "none");
							}
							
						}// success 종료
						
					}); // ajax 종료
					
				}); //fuction 종료
				
		/* 인증번호 이메일 전송 */
		$(".mail_check_button").click(function(){
			
			var email = $(".mail_input").val(); //입력한 이메일
			var checkBox = $(".mail_check_input"); //인증번호 입력란
			var boxWrap = $(".mail_check_input_box"); // 입력란 박스
			
			$.ajax({
				
				type:"GET",
				url:"mailCheck?email=" + email, //url : mailCheck
				success:function(data){
					checkBox.attr("disabled",false);
					boxWrap.attr("id", "mail_check_input_box_true");
					code = data;
				}
			});
			
		});
				
 	//인증번호 일치 여부
 	$(".mail_check_input").blur(function(){
    	
 		var inputCode = $(".mail_check_input").val();        // 입력코드    
 	    var checkResult = $("#mail_check_input_box_warn");    // 비교 결과
 	    
 	   if(inputCode == code){                            // 일치할 경우
 	        checkResult.html("인증번호가 일치합니다.");
 	        checkResult.attr("class", "correct");        
 	    } else {                                            // 일치하지 않을 경우
 	        checkResult.html("인증번호를 다시 확인해주세요.");
 	        checkResult.attr("class", "incorrect");
 	    }
    
	});
	</script>



</body>
</html>
