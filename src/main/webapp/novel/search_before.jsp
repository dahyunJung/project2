<%@page import="novel.SearchVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="novel.SearchDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charSet="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
<title>검색 | 카카오페이지 스테이지</title>
<link rel="preconnect" href="https://fonts.gstatic.com"	crossorigin="anonymous" />
<link rel="stylesheet" data-href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500,700&amp;display=swap" />
<link rel="preload" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" data-n-g="" />
<link rel="stylesheet" type="text/css" href="/project/_next/static/css/login.css" />
<noscript data-n-css=""></noscript>
<script type="text/javascript">
$(function () {
	$("#searchimg").click(function () {
		alert("sdfadsf");
		$("#frm").submit();
	})
})
function selectNovel(num_novel){
	location.href="/project2/novel/novel_info.jsp?num_novel="+num_novel;
}
</script>
</head>
<body>
	<div id="__next" data-reactroot="">
		<div
			style="display: none; background-color: canvas; color-scheme: light"></div>
		<div class="lightMode h-full">
			<div class="flex flex-col h-full">
<!-- header -->
	<div>
		<jsp:include page="../_next/header_user_login_search.jsp"/>
	</div>	
				<main class="flex-1">
					<div
						class="flex mx-auto w-full max-w-default flex-row flex-wrap desktop:px-22 max-w-[848px]">
						<div class="flex flex-col mb-120 flex-1">
							<div
								class="mt-40 mb-32 px-18 desktop:mt-50 desktop:mb-42 desktop:px-0">
								<div class="w-full">
									<form id="frm">
										<div
											class="flex items-center rounded-4 border-1 border-grey30 py-4 px-16">
											<div class="flex h-16 w-16 items-center text-grey60">
												<svg id="searchimg" width="20" height="20" viewBox="0 0 20 20" fill="none"
													xmlns="http://www.w3.org/2000/svg" role="img">
                                                        <path
														fill-rule="evenodd" clip-rule="evenodd"
														d="M12.739 2.966a7 7 0 10-9.9 9.9 7 7 0 009.9-9.9zm-9.193 9.192a6 6 0 118.486-8.485 6 6 0 01-8.486 8.485z"
														fill="#666"></path>
                                                        <path
														d="M13.168 12.087l4.95 4.95-.708.707-4.95-4.95.708-.707z"
														fill="#666"></path>
                                                    </svg>
											</div>
											<input type="search"
												class="typo-md3 py-14 px-16 outline-none rounded-3 border-1 border-grey30 placeholder:text-grey60 w-full border-0 text-16 outline-none desktop:!text-16"
												name="search" placeholder="검색어 입력" maxLength="100" />
										</div>
										<button type="submit" class="hidden">검색</button>
									</form>
								</div>
							</div>
							<div class="px-18 desktop:px-0"></div>
						</div>
						
						<div class="col-span-full grid gap-x-64 desktop:grid-cols-2">
								
								<%
																SearchDAO sDAO=new SearchDAO();
																						try{
																							List<SearchVO> selectList=sDAO.selectNovelAll(request.getParameter("search"));
																							pageContext.setAttribute("selList", selectList);
																%>
								
								<c:forEach var="select" items="${selList}" >
									<div class="px-18 py-12 desktop:px-0 desktop:py-24">
										<div
											class="flex items-center flex-row w-full flex-row-reverse"
											data-testid="skeleton">
											<div
												class="relative overflow-hidden rounded-3 bg-grey10 w-80 h-122 desktop:h-125 ml-16" style="background-color: #fff"><button
											class="typo-sm1 mr-8 rounded-20 py-[3.5px] px-10 bg-black text-white" onclick="deleteNovel('${select.num_novel}')">삭제</button></div>
											<div class="flex flex-col w-full flex-1" onclick="selectNovel('${select.num_novel}')">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate" style="font-size: 18px">${select.subject}</span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">${select.id}</p><br/>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                <span class="typo-g-sm2 -mb-[0.2em] ml-4"><fmt:formatDate value="${select.make}" pattern="yyyy-MM-dd HH:mm"/></span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                최신화 : ${select.episode}화
                                                                            </span>
                                                                        </div>
											</div>
											<div class="relative overflow-hidden rounded-3 bg-grey10 w-80 h-122 desktop:h-125 ml-16" onclick="selectNovel('${select.num_novel}')">
												<img
														alt="ㄴㄹㅇㄹ"
														srcset="/project2/_next/static/images/${select.photo}"
														src="/project2/_next/static/images/${select.photo}" decoding="async"
														data-nimg="fixed"
														style="position: absolute; inset: 0px; box-sizing: border-box; padding: 0px; border: none; margin: auto; display: block; width: 0px; height: 0px; min-width: 100%; max-width: 100%; min-height: 100%; max-height: 100%; object-fit: cover;"
														>
											</div>
										</div>
									</div>
								</c:forEach>
									
									<% 
								}catch(Exception e){
									e.printStackTrace();
								}
								%>
								</div>
						
					</div>
				</main>


			<!-- footer -->
	<div>
		<jsp:include page="../_next/footer.jsp"/>
	</div>


			</div>
		</div>
		<div id="modal-normal"></div>
	</div>
	<!--  <script id="__NEXT_DATA__" type="application/json">
            {"props":{"pageProps":{}},"page":"/search","query":{},"buildId":"DTTq-pEjkraM1eJOqnaey","assetPrefix":"https://pagestage-cdn.kakaoent.com/web","nextExport":true,"autoExport":true,"isFallback":false,"scriptLoader":[]}
        </script> -->
</body>
</html>
