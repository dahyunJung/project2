<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charSet="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="anonymous" />
<link rel="stylesheet" data-href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500,700&amp;display=swap" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css"	as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" data-n-g="" />
<link rel="stylesheet" type="text/css" href="/project2/_next/static/css/login.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">
	#wrap { display: flex; align-items: center; justify-content: center; height: 100%; }
</style>	

<noscript data-n-css=""></noscript>
<script type="text/javascript">

	$(function(){
		
		$("#report").click(function(){
			alert("신고되었습니다.");
			$("#reportFrm").submit();
			window.close();
		}); //delete
		
	});// ready

</script>
</head>
<%
	/* int userNum = (Integer)session.getAttribute("userNum");
	int novelNum = Integer.parseInt(request.getParameter("novelNum"));  */
	int userNum = 3;
	int novelNum = 23;
%>

<body>
	<div class="flex rounded-t-0 relative z-1 max-h-[100%] flex-col overflow-hidden bg-white"
		data-body-scroll-lock="ignore" style="width: 502px; height: 800px; border: 1px solid #000000;">
	<div class="flex flex-col h-full overflow-hidden px-18 py-24 desktop:p-30">
		<div style="position: relative; top: 15px" class="flex-1 overflow-y-scroll scrollbar-hide desktop:px-10 desktop:pt-10">
		<img id="reportImg" src="http://localhost/project2/_next/static/images/report.png" style="width: 40px; height: 40px;" alt="신고"/>
		<div class="typo-md1 text-center desktop:typo-lg3 py-8">
			<div class="whitespace-pre-line" style="font-weight: bold; font-size: 20px">신고</div><br>
			<div>서비스 이용목적에 부합하지 않는 콘텐츠를 신고해주세요. <br>
				신고하신 내용은 운영정책에 따라 처리되며,<br> 
				허위 신고시 이용에 제한을 받을 수 있습니다.<br>
			</div>
			<br><br><br>
			
		<form id="reportFrm" action="report_process.jsp" method="post">
			<input type="hidden" id="novelNum" name="novelNum" value="<%= novelNum %>" />
			<input type="hidden" id="userNum" name="userNum" value="<%= userNum %>" />
			<input type="hidden" id="id" name="id" value="" />
			<input type="hidden" id="reportCode" name="reportCode" value="" />
			
			<div id="radi">
				<label><input type="radio" name="reportCode" value="1" />영리목적/홍보성</label><br>
				<label><input type="radio" name="reportCode" value="2" />욕설/인신공격</label><br>
				<label><input type="radio" name="reportCode" value="3" />불법정보</label><br>
				<label><input type="radio" name="reportCode" value="4" />개인정보노출</label><br>
				<label><input type="radio" name="reportCode" value="5" />음란성/선정성</label><br>
				<label><input type="radio" name="reportCode" value="6" />같은 내용 도배</label><br>
				<label><input type="radio" name="reportCode" value="7" />권리 침해 신고</label><br>
			</div>
			
			
		</form>
		</div>
		</div>
		
			<div class="w-full shrink-0" style="position: relative; bottom: 18px">
			
				<div class="flex mt-24 desktop:mt-32">
					<button class="flex items-center justify-center border-1 appearance-none px-24 py-12 typo-md2-b mr-8 flex-1"
						type="button" id="cancel" style="font-weight: bold" onclick="javascript:window.close()">취소</button>
					
					<button class="flex items-center justify-center border-1 appearance-none bg-black border-black text-white disabled:border-grey20 disabled:bg-grey20 disabled:text-grey60 px-24 py-12 typo-md2-b flex-1"
						type="button" id="report" style="font-weight: bold">신고</button>
				</div>
				
			</div>
		
		
	</div>
	</div>
</body>
</html>