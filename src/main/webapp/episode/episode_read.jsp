<%@page import="java.sql.SQLException"%>
<%@page import="EpisodeVO.LookEpisodeVO"%>
<%@page import="EpisodeDAO.MyPageDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charSet="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
<title> 소설 읽기 | 카카오페이지 스테이지</title>
<link rel="preconnect" href="https://fonts.gstatic.com"	crossorigin="anonymous" />
<link rel="stylesheet"	data-href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500,700&amp;display=swap" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css"	as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" data-n-g="" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/593189bb3d3dd926.css"	as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/593189bb3d3dd926.css" data-n-p="" />
<link rel="stylesheet" type="text/css" href="/project2/_next/static/css/login.css" />
<!-- jQuery CDN설정 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">
	.flex-container {
		display: flex;
		justify-content: center; /* 버튼 요소들을 수평 중앙 정렬 */
		align-items: center; /* 버튼 요소들을 수직 중앙 정렬 */
		/* flex-wrap: wrap; */ /* 크기에 따라 달라지는 창 */
	}
	
	.button { margin: 0 120px; }
	.no-gap { display: flex; align-items: center; }
	.no-gap button, .no-gap label { margin: 0; }
</style>

<noscript data-n-css=""></noscript>
<script type="text/javascript">

$(function(){
	
	$("#prev").click(function(){
		
	}); //prev
	
	$("#next").click(function(){
		
	}); //next
	
	
});// ready

</script>
</head>

<%

	/* if((Integer)session.getAttribute("userNum")==null){
	    response.sendRedirect("http://localhost/project2/episode/novel_list.jsp");
	}  */

	/* int userNum = 3;	//일단 테스트값
	int novelNum = 23; 
	int epNum = 85; */
	//int userNum = 4;
	
	int userNum = 3;
	//int userNum = (Integer)session.getAttribute("userNum");
	int novelNum = Integer.parseInt(request.getParameter("novelNum")); 
	int epNum = Integer.parseInt(request.getParameter("epNum")); 
	
	MyPageDAO mDAO = new MyPageDAO();
	LookEpisodeVO selectVO = null;
	try{
		selectVO = mDAO.selectEpisode(userNum, novelNum, epNum); 
		
	}catch(SQLException e){
		e.printStackTrace();
	}

%>

<body>
<div id="__next" data-reactroot="">
<div class="lightMode h-full">
<div class="flex flex-col h-full">

	<header class="relative bg-white border-b-1 border-grey20">
		<div class="flex mx-auto w-full max-w-default flex-row flex-wrap desktop:px-22 flex-wrap items-center desktop:min-h-[72px] desktop:flex-nowrap desktop:py-12">
		<div class="flex typo-g-sm2 flex-1 items-center text-grey60" style="display: flex; align-items: center;">
			<div class="relative overflow-visible mt-auto mb-0 desktop:my-auto">
				<a href="/project2/novel/novel_info.jsp">
					<img width="20" height="20" src="/project2/_next/static/images/list.png" style="top: 10px;" />
				</a>
				
				<span class="button" style="position: relative; top: -8px; left: 348px; text-align: center; ">
					<label style="font-size: 25px; height: 38px; color: rgb(0, 0, 0); font-weight: bold;"> <%= selectVO.getNovelTitle() %> </label>
				</span> 
				
			</div>
		</div>
		</div>
	</header>

	<main class="flex-1">
		<div class="flex mx-auto w-full max-w-default flex-row flex-wrap desktop:px-22 px-18 mt-32 desktop:mt-47">
			<div class="flex flex-col flex-1"></div>
		</div>

		<div data-obj-id="pf8A1" data-obj-type="element" data-text-editable="true" class="" style="margin: auto; width: 1000px; height: 709px;">
			<div data-text-content="true" style=" padding:20px; padding-left:40px; padding-right:40px; font-size: 16px; background-color: rgba(224, 224, 224, 0.34);" class="">
				<div style="text-align: center;">
					<span style="font-style:italic; ; font-size: x-large;"><%= selectVO.getEpTitle() %></span><br><br>
				</div>
				
				<div>
					<%= selectVO.getEpDetail().replace("\n", "<br>") %>
				</div>
				<br><br><br><br><br><br>
				
				<div style="position: relative;">
					<!-- 이전화 -->
					<input type="button" id="prev" value="← 이전 화" style="font-size:25px ; text-align: left;"/>
					
					<!-- 다음화 -->
					<input type="button" id="next" value="다음 화 →" style="font-size:25px ; float: right;"/>
					<br><br>
				</div>
				
			</div>
			<br>
		</div>
	</main>
	<!-- footer -->
	<div>
		<jsp:include page="../_next/footer.jsp"/>
	</div> 
	</div>
	</div>
	</div>
	
</body>
</html>