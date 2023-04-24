<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//나중에 지울것
session.setAttribute("id", "id");
%>
<%
String id=session.getAttribute("id").toString();
%>

<!DOCTYPE html>
<html lang="ko" style="height: 1000px;">
<head>
<meta charSet="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
<title>마이페이지 | 카카오페이지 스테이지</title>
<link rel="preconnect" href="https://fonts.gstatic.com"
	crossorigin="anonymous" />
<link rel="stylesheet"
	data-href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500,700&amp;display=swap" />
<link rel="preload"
	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css"
	as="style" />
<link rel="stylesheet"
	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css"
	data-n-g="" />
<link rel="preload"
	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/593189bb3d3dd926.css"
	as="style" />
<link rel="stylesheet"
	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/593189bb3d3dd926.css"
	data-n-p="" />
<link rel="stylesheet" type="text/css" href="/project2/_next/static/css/login.css" />
<noscript data-n-css=""></noscript>
<style type="text/css">
#wrap{ width: 1300px;height: 1200px;margin: 0px auto;}

#container{width:1300px; height: 800px; position: relative;display: flex;justify-content: center;align-items: center; top: 100px;}
#frame{width: 1100px;height: 700px;display: flex;position: absolute;justify-content: center;position: absolute;background-color: #E0E0E0;border-radius: 200px;}
#text_mypage{position: absolute;left: 100px;top: 60px;font-size: 30px; font-weight: bold;}
#img_change{position: absolute;top:55px;left:355px}
#text_logout{position: absolute;left: 100px;top: 90px;font-size: 15px;}
#img_profile{position: absolute;top: 170px}
#input_name{position: absolute; top: 320px}
.name{width: 200px; height: 30px;text-align: center; font-size: 20px;font-weight: bold;}
#input_button1{position: absolute; top:420px;left: 100px;}
#input_button2{position: absolute; top:420px;right: 100px;}
.button{width: 400px; height: 170px;text-align: left; font-size: 20px; font-weight: bold;background-color: #C0FAF8; border-radius: 30px;}

</style>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- jQuery CDN 끝 -->
<script type="text/javascript">

$(function() {
	$("#input_button1").click(function() {
		location.href="http://localhost/project2/novel/my_novel_space.jsp?order_novel=0";
	})
	$("#input_button2").click(function() {
		location.href="http://localhost/project2/login/like.jsp?search=";
	})
})

</script>
</head>
<body>
<div id="__next" data-reactroot="">
	<div style="display: none; background-color: canvas; color-scheme: light"></div>
	<div class="lightMode h-full">
		<div class="flex flex-col h-full">
			
			<!-- header -->
			<div>
				<jsp:include page="../_next/header_user_login_search.jsp"/> 
			</div>
	
			<div id="wrap">
				<div id="container">
					<div id="frame">
						<div id="text_mypage"><%=id %>님의 마이페이지</div>
						<div id="img_change"><img src="/project2/_next/static/images/mypage.PNG"></div>
						<div id="text_logout"><a href="">로그아웃</a></div>
						<div id="img_profile"><img src="/project2/_next/static/images/profile.PNG" class="profile"></div>
						<div id="input_name"><input type="text" readonly value="<%=id %>님" class="name"></div>
						<div id="input_button1"><input type="button"class="button" value=" 내 소설"></div>
						<div id="input_button2"><input type="button"class="button" value=" 좋아요"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div>
		<jsp:include page="../_next/footer.jsp"/>
	</div>
</div>
<div id="modal-normal"></div>
</body>
</html>