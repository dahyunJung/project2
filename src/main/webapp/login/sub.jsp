<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
%>
<!DOCTYPE html>
<html>
<head>
<meta charSet="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
<title>좋아요 작품 | 카카오페이지 스테이지</title>
<link rel="preconnect" href="https://fonts.gstatic.com"	crossorigin="anonymous" />
<link rel="stylesheet" data-href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500,700&amp;display=swap" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" as="style" />
<link rel="stylesheet"href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" data-n-g="" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/593189bb3d3dd926.css"	as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/593189bb3d3dd926.css" data-n-p="" />
<link rel="stylesheet" type="text/css" href="http://localhost/project/_next/static/css/login.css" />
<noscript data-n-css=""></noscript>
<style type="text/css">

#wrap{ width: 1000px;height: 350px;margin: 0px auto;}
#header{height: 150px;position: relative;}

#container{height: 350px;display: flex;position: relative;}
#zoa{width: 150px; height: 70px; position: absolute;bottom: 420px;
    background:#FFFFFF url(\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\images\1/zoa.PNG);background-size : 100% 100%;}
#loginId{width: 50%;height: 70%;position: relative;display: flex;justify-content: center;}
#login_table{width: 70%; height: 100px;position: absolute; top: 60px;}
#chb{position: absolute; width: 100px;height: 30px;top:170px;right:325px;}
#loginButton{position: absolute;width:70%; top:190px;}
#loginButton2{position: absolute;width:70%; top:250px;}
#newmember{position: absolute; top: 290px;right: 375px;}
#idpass{position: absolute; top: 290px;left: 280px;}
.input_id{width: 100%; height: 30px; border-radius: 3px; background-color: #e8f0fe;border-left-width:0;
    border: none;border-bottom: 1px solid #CCC;}
.input_pass{width: 100%; height: 30px; border-radius: 3px;background-color: #e8f0fe;
    border: none;border-bottom: 1px solid #CCC;}
.input_button{width:100%; height:50px; border-radius: 10px; background-color: #808080;}

</style>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- jQuery CDN 끝 -->
<script type="text/javascript">
	$(function(){
		$("#change").click(function(){
			let pw=$("#pw").val();
			let pw_dup=$("#pw_dup").val();
			if(pw == null || pw == "" || pw_dup == null || pw_dup == ""){
				alert("비밀번호를 입력해주세요.");
			}else if(pw.length < 8){
				alert("비밀번호는 8자 이상 써주세요");
			}else if(pw !=pw_dup){
				alert("비밀번호가 같지 않습니다.");
			}else{
				$("#frm").submit();
			}
		});
	});
	
	function cancel() {
		window.close();
	}
</script>
</head>

<body>
		<div style="display: none; background-color: canvas; color-scheme: light"></div>
				<form action="sub_dao.jsp" method="post" id="frm" name="frm">
    <div id="wrap">
        <div id="container">
            <div id="loginId">
                <table id="login_table">
                    <tr height="10px">
              <td><input type="text" class="input_id"placeholder="비밀번호" id="pw" name="pw"></td>
              </tr>
              <tr height="10px">
               <td><input type="text" class="input_pass"placeholder="비밀번호 확인" id="pw_dup"></td>
               </tr>
               </table>
               <div id="loginButton">
                <input type="button" class="input_button" value="변경" id="change" style='cursor:pointer'>
               </div>
               <div id="loginButton2">
                <input type="button" class="input_button" value="취소" onclick="cancel()" style='cursor:pointer'>
               </div>
            </div>
        
        </div>
    </div>
</form>
		<div id="modal-normal"></div>
</body>
</html>