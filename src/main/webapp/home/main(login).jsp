<%@page import="java.sql.SQLException"%>
<%@page import="novel.RankingVO"%>
<%@page import="java.util.List"%>
<%@page import="novel.RankingDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
<title>메인-로그인 | 소설조아</title>
<link rel="preconnect" href="https://fonts.gstatic.com"	crossorigin="anonymous" />
<link rel="stylesheet"	data-href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500,700&amp;display=swap" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css"	as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" data-n-g="" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/593189bb3d3dd926.css"	as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/593189bb3d3dd926.css" data-n-p="" />
<link rel="stylesheet" type="text/css" href="/project2/_next/static/css/login.css" />
<noscript data-n-css=""></noscript>

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
				<main class="flex-1">
                        <div>
                            <div class="flex mx-auto w-full max-w-default flex-row flex-wrap desktop:px-22 px-18">
                                <div class="grid grid-cols-12 grid-rows-[auto] gap-x-12  w-full mt-56 mb-62 gap-y-64 gap-x-0">
                                    <div class="flex flex-col col-[1/9] pr-26">
                                        <section>
                                            <div class="flex flex-wrap w-full items-start desktop:items-center pb-16">
                                                <h2 class="typo-lg3-b flex-1 break-normal desktop:typo-lg1 desktop:flex-initial">일간 랭킹</h2>
                                            </div>
                                            <%
                                            	RankingDAO rDAO=new RankingDAO();
                                            	try{
                                            		List<RankingVO> list=rDAO.selectRanking();
                                            %>
                                            <div class="grid grid-cols-1 gap-y-16 px-0 desktop:grid-cols-2 desktop:gap-x-34 desktop:gap-y-24 desktop:pl-30">
                                                <div class="col-span-2">
                                                    <a class="flex flex-col bg-grey10 py-20 px-18 desktop:-ml-30 desktop:py-30 desktop:px-30" href="/novels/48497284">
                                                        <article class="flex items-center items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden ml-15 h-125 w-80 desktop:ml-0 desktop:h-[233px] desktop:w-149 order-1" style="height:233px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:149px;height:233px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="썸네일 이미지" src="http://localhost/project/_next/static/images/<%=list.get(0).getPhoto() %>" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="스트리밍 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=250&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=350&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=350&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                                <%=list.get(0).getAge()==1?"<img class='absolute top-4 right-4' src='/project/_next/static/icons/badge_thumbnail_adult15_s.svg' alt='15세 관람가 아이콘'/>":""%>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center !typo-g-lg1 mr-16 w-16 desktop:ml-24 desktop:w-26">
                                                                        <span>1</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-lg3 mb-2 desktop:mb-4">
                                                                            <span class="truncate"><%=list.get(0).getTitle()%></span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 mb-16 text-grey70 desktop:typo-md3 desktop:mb-8">
                                                                            <div class="truncate after:inline-block after:w-0"><%=list.get(0).getId()%></div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60 desktop:mb-20">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4"><%=list.get(0).getVisit()%></span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4"><%=list.get(0).getLike()%></span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60" style="-webkit-line-clamp:4"><%=list.get(0).getStory()%></p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <%for(int i=1;i<5;i++){ %>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/54699805">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="" src="http://localhost/project/_next/static/images/<%=list.get(i).getPhoto() %>" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="서림동 편지 가게 : 유난히 긴 밤을 걷는 자들을 위해 열립니다. 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                                <%=list.get(i).getAge()==1?"<img class='absolute top-4 right-4' src='/project/_next/static/icons/badge_thumbnail_adult15_s.svg' alt='15세 관람가 아이콘'/>":""%>
                                                            
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span><%=i %></span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate"><%=list.get(i).getTitle()%></span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0"><%=list.get(i).getId()%></div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4"><%=list.get(i).getVisit()%></span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4"><%=list.get(i).getLike()%></span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2"><%=list.get(i).getStory()%></p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <%} %>
                                            </div>
                                        </section>
                                    </div>
                                    <div class="flex flex-col col-[9/-1] ml-30">
                                        <section>
                                            <div class="flex flex-wrap w-full items-start desktop:items-center border-b-1 border-black pb-16">
                                                <h2 class="typo-lg3-b flex-1 break-normal desktop:typo-lg1 desktop:flex-initial">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </h2>
                                                <a class="typo-md3 ml-auto flex items-center text-black desktop:text-grey60" href="/project2/home/ranking_day(login).jsp">
                                                    <span class="mr-4 hidden desktop:inline">더보기</span>
                                                    <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg" role="img">
                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M11 8.00064L6.06282 13.0013L4.99541 11.9474L8.8921 8.00064L4.99541 4.05387L6.06282 3L11 8.00064Z" fill="currentColor"></path>
                                                    </svg>
                                                </a>
                                                <div class="flex ml-auto border-1 border-grey20">
                                                </div>
                                            </div>
                                            <div class="flex flex-col">
                                            <%for(int i=6;i<11;i++){ %>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);"><%=i%></span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate"><%=list.get(i).getTitle()%></span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0"><%=list.get(i).getId()%></div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4"><%=list.get(i).getVisit()%></span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4"><%=list.get(i).getLike()%></span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            <%} %>
                                            </div>
                                            <%
                                            	}catch(SQLException se){
                                            		se.printStackTrace();
                                            	}
                                            %>
                                        </section>
                                    </div>
<!--																				-->
                                    <div class="flex flex-col col-[1/9] pr-26">
                                        <section>
                                            <div class="flex flex-wrap w-full items-start desktop:items-center pb-16">
                                                <h2 class="typo-lg3-b flex-1 break-normal desktop:typo-lg1 desktop:flex-initial">주간 랭킹</h2>
                                            </div>
                                            <div class="grid grid-cols-1 gap-y-16 px-0 desktop:grid-cols-2 desktop:gap-x-34 desktop:gap-y-24 desktop:pl-30">
                                                <div class="col-span-2">
                                                    <a class="flex flex-col bg-grey10 py-20 px-18 desktop:-ml-30 desktop:py-30 desktop:px-30" href="/novels/48497284">
                                                        <article class="flex items-center items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden ml-15 h-125 w-80 desktop:ml-0 desktop:h-[233px] desktop:w-149 order-1" style="height:233px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:149px;height:233px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="스트리밍 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="스트리밍 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=250&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=350&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=350&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                                <img class="absolute top-4 right-4" src="\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\icons/badge_thumbnail_adult15_s.svg" alt="15세 관람가 아이콘"/>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center !typo-g-lg1 mr-16 w-16 desktop:ml-24 desktop:w-26">
                                                                        <span>1</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-lg3 mb-2 desktop:mb-4">
                                                                            <span class="truncate">스트리밍</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 mb-16 text-grey70 desktop:typo-md3 desktop:mb-8">
                                                                            <div class="truncate after:inline-block after:w-0">허스</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60 desktop:mb-20">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">1,530</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">9</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60" style="-webkit-line-clamp:4">실시간으로 스트리밍 되는 사건과 음모
날이 갈수록 커져가는 사람들의 욕망과 갈망 
그리고 그것들에 휘말리게 된 주인공의 이야기</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/54699805">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="서림동 편지 가게 : 유난히 긴 밤을 걷는 자들을 위해 열립니다. 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="서림동 편지 가게 : 유난히 긴 밤을 걷는 자들을 위해 열립니다. 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span>2</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">서림동 편지 가게 : 유난히 긴 밤을 걷는 자들을 위해 열립니다.</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">애리옹</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">519</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">15</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">5년째 신림동 고시생, 더 나아질 것도 희망도 없는 내가 로또에 당첨되어버렸다.

로또 당첨이라니… 나 이걸로 뭘 하지?
공부를 계속해야 하나? 카페를 차려볼까?
막막한 인생에 찾아온 실낱같은 행운. 

그래, 남은 돈으로는 ‘소원을 적는 편지점’을 운영해봐야겠다.

#드라마 #힐링물 #삶 #청춘물

작가메일 : lyss272@naver.com</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/96261792">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="새하얀 자정의 호랑이 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="새하얀 자정의 호랑이 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FZoWxw%2FbtrZzMpjIbR%2FaYntTfACIk4SH8u2QXQCk0%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FZoWxw%2FbtrZzMpjIbR%2FaYntTfACIk4SH8u2QXQCk0%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FZoWxw%2FbtrZzMpjIbR%2FaYntTfACIk4SH8u2QXQCk0%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span>3</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">새하얀 자정의 호랑이</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">ParkTakeNovel</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">251</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">3</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">어린 나이에 모든 것을 잃은 구민과 
구민의 암울한 삶을 행복하게 만들어주려는 수현.
두 소년의 성장소설이다.
구민이 본 수수께끼의 호랑이의 정체는
과연 무엇일까?

연재: 수,금,일
수위: 12세 이상 감상 가능
시즌: 6개로 구성됨. 이 작품은 시즌 1이다.
시즌 1: 총 26화
시즌 2: 총 30화 (예정)
시즌 3: 총 51화 (예정)
시즌 4: 총 16화 (예정)
시즌 5 (외전): 총 27화 (예정)
시즌 6 (외전): 총 3화 (예정)</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/83616880">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="죽음의 경계 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="죽음의 경계 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FbWRhHF%2Fbtr0kk6OxFv%2FXyfRyeE4bckIK8pLW8y4e1%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FbWRhHF%2Fbtr0kk6OxFv%2FXyfRyeE4bckIK8pLW8y4e1%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FbWRhHF%2Fbtr0kk6OxFv%2FXyfRyeE4bckIK8pLW8y4e1%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                                <img class="absolute top-4 right-4" src="\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\icons/badge_thumbnail_adult15_s.svg" alt="15세 관람가 아이콘"/>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span>4</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <img class="mr-2 inline shrink-0" src="\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\icons/badge_list_new_s.svg" width="16" height="16" alt="new 뱃지"/>
                                                                            <span class="truncate">죽음의 경계</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">J하로</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">103</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">6</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">죽음의 경계에 오신 것을 환영합니다

당신이 이곳에서의 임무를 소개해 드리겠습니다

게임을 클리어하고 포인트를 적립하여 현실 세계로 돌아가세요

참! 죽음의 경계에서 죽음은 언제 어디서나 당신의 곁에 맴돌고 있다는 것을 주의하십시오

그럼 행운을 빌게요, 플레이어 여러분


#미스테리 #공포 #추리 #클리어or사망 #약간의잔인함 #흥미진진 #공포만있는게아님


작가 메일 : iora0220@naver.com</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/64927984">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="모텔 피플 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="모텔 피플 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsbfSz%2FbtrZ9MuS9Y1%2FWPUMKHHPHbZCZfUgB7IzW1%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsbfSz%2FbtrZ9MuS9Y1%2FWPUMKHHPHbZCZfUgB7IzW1%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsbfSz%2FbtrZ9MuS9Y1%2FWPUMKHHPHbZCZfUgB7IzW1%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span>5</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <img class="mr-2 inline shrink-0" src="\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\icons/badge_list_new_s.svg" width="16" height="16" alt="new 뱃지"/>
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">전쟁이 끝나고 모텔에 수용된 사람들, 전쟁은 아직 끝나지 않았다.</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                            </div>
                                        </section>
                                    </div>
                                    <div class="flex flex-col col-[9/-1] ml-30">
                                        <section>
                                            <div class="flex flex-wrap w-full items-start desktop:items-center border-b-1 border-black pb-16">
                                                <h2 class="typo-lg3-b flex-1 break-normal desktop:typo-lg1 desktop:flex-initial">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </h2>
                                                <a class="typo-md3 ml-auto flex items-center text-black desktop:text-grey60" href="/project2/home/ranking_week(login).jsp">
                                                    <span class="mr-4 hidden desktop:inline">더보기</span>
                                                    <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg" role="img">
                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M11 8.00064L6.06282 13.0013L4.99541 11.9474L8.8921 8.00064L4.99541 4.05387L6.06282 3L11 8.00064Z" fill="currentColor"></path>
                                                    </svg>
                                                </a>
                                                <div class="flex ml-auto border-1 border-grey20">
                                                </div>
                                            </div>
                                            <div class="flex flex-col">
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">6</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">7</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">8</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">9</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">10</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </section>
                                    </div>
<!--																				-->
                                    <div class="flex flex-col col-[1/9] pr-26">
                                        <section>
                                            <div class="flex flex-wrap w-full items-start desktop:items-center pb-16" >
                                                <h2 class="typo-lg3-b flex-1 break-normal desktop:typo-lg1 desktop:flex-initial">월간 랭킹</h2>
                                            </div>
                                            <div class="grid grid-cols-1 gap-y-16 px-0 desktop:grid-cols-2 desktop:gap-x-34 desktop:gap-y-24 desktop:pl-30">
                                                <div class="col-span-2">
                                                    <a class="flex flex-col bg-grey10 py-20 px-18 desktop:-ml-30 desktop:py-30 desktop:px-30" href="/novels/48497284">
                                                        <article class="flex items-center items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden ml-15 h-125 w-80 desktop:ml-0 desktop:h-[233px] desktop:w-149 order-1" style="height:233px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:149px;height:233px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="스트리밍 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="스트리밍 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=250&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=350&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FrdsqY%2FbtrXVRY8hQm%2F2v5pbDaqEgWlFV6HlrnK00%2Foriginal.jpeg&amp;w=350&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                                <img class="absolute top-4 right-4" src="\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\icons/badge_thumbnail_adult15_s.svg" alt="15세 관람가 아이콘"/>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center !typo-g-lg1 mr-16 w-16 desktop:ml-24 desktop:w-26">
                                                                        <span>1</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-lg3 mb-2 desktop:mb-4">
                                                                            <span class="truncate">스트리밍</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 mb-16 text-grey70 desktop:typo-md3 desktop:mb-8">
                                                                            <div class="truncate after:inline-block after:w-0">허스</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60 desktop:mb-20">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">1,530</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">9</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60" style="-webkit-line-clamp:4">실시간으로 스트리밍 되는 사건과 음모
날이 갈수록 커져가는 사람들의 욕망과 갈망 
그리고 그것들에 휘말리게 된 주인공의 이야기</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/54699805">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="서림동 편지 가게 : 유난히 긴 밤을 걷는 자들을 위해 열립니다. 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="서림동 편지 가게 : 유난히 긴 밤을 걷는 자들을 위해 열립니다. 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsWOwd%2FbtrZclrilZ3%2FJr5jLK8U4HCSDRSK47nsK1%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span>2</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">서림동 편지 가게 : 유난히 긴 밤을 걷는 자들을 위해 열립니다.</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">애리옹</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">519</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">15</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">5년째 신림동 고시생, 더 나아질 것도 희망도 없는 내가 로또에 당첨되어버렸다.

로또 당첨이라니… 나 이걸로 뭘 하지?
공부를 계속해야 하나? 카페를 차려볼까?
막막한 인생에 찾아온 실낱같은 행운. 

그래, 남은 돈으로는 ‘소원을 적는 편지점’을 운영해봐야겠다.

#드라마 #힐링물 #삶 #청춘물

작가메일 : lyss272@naver.com</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/96261792">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="새하얀 자정의 호랑이 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="새하얀 자정의 호랑이 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FZoWxw%2FbtrZzMpjIbR%2FaYntTfACIk4SH8u2QXQCk0%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FZoWxw%2FbtrZzMpjIbR%2FaYntTfACIk4SH8u2QXQCk0%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FZoWxw%2FbtrZzMpjIbR%2FaYntTfACIk4SH8u2QXQCk0%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span>3</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">새하얀 자정의 호랑이</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">ParkTakeNovel</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">251</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">3</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">어린 나이에 모든 것을 잃은 구민과 
구민의 암울한 삶을 행복하게 만들어주려는 수현.
두 소년의 성장소설이다.
구민이 본 수수께끼의 호랑이의 정체는
과연 무엇일까?

연재: 수,금,일
수위: 12세 이상 감상 가능
시즌: 6개로 구성됨. 이 작품은 시즌 1이다.
시즌 1: 총 26화
시즌 2: 총 30화 (예정)
시즌 3: 총 51화 (예정)
시즌 4: 총 16화 (예정)
시즌 5 (외전): 총 27화 (예정)
시즌 6 (외전): 총 3화 (예정)</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/83616880">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="죽음의 경계 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="죽음의 경계 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FbWRhHF%2Fbtr0kk6OxFv%2FXyfRyeE4bckIK8pLW8y4e1%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FbWRhHF%2Fbtr0kk6OxFv%2FXyfRyeE4bckIK8pLW8y4e1%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FbWRhHF%2Fbtr0kk6OxFv%2FXyfRyeE4bckIK8pLW8y4e1%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                                <img class="absolute top-4 right-4" src="\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\icons/badge_thumbnail_adult15_s.svg" alt="15세 관람가 아이콘"/>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span>4</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <img class="mr-2 inline shrink-0" src="\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\icons/badge_list_new_s.svg" width="16" height="16" alt="new 뱃지"/>
                                                                            <span class="truncate">죽음의 경계</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">J하로</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">103</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">6</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">죽음의 경계에 오신 것을 환영합니다

당신이 이곳에서의 임무를 소개해 드리겠습니다

게임을 클리어하고 포인트를 적립하여 현실 세계로 돌아가세요

참! 죽음의 경계에서 죽음은 언제 어디서나 당신의 곁에 맴돌고 있다는 것을 주의하십시오

그럼 행운을 빌게요, 플레이어 여러분


#미스테리 #공포 #추리 #클리어or사망 #약간의잔인함 #흥미진진 #공포만있는게아님


작가 메일 : iora0220@naver.com</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                                <div class="col-start-1 desktop:col-[span_1/auto]">
                                                    <a class="flex items-center" href="/novels/64927984">
                                                        <article class="flex items-center">
                                                            <div class="flex relative shrink-0 items-start overflow-hidden h-98 w-64 desktop:h-125 desktop:w-80 order-1" style="height:125px">
                                                                <span style="box-sizing:border-box;display:inline-block;overflow:hidden;width:80px;height:125px;background:none;opacity:1;border:0;margin:0;padding:0;position:relative">
                                                                    <img alt="모텔 피플 썸네일 이미지" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover"/>
                                                                    <noscript>
                                                                        <img alt="모텔 피플 썸네일 이미지" srcSet="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsbfSz%2FbtrZ9MuS9Y1%2FWPUMKHHPHbZCZfUgB7IzW1%2Foriginal.jpeg&amp;w=80&amp;q=75 1x, /_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsbfSz%2FbtrZ9MuS9Y1%2FWPUMKHHPHbZCZfUgB7IzW1%2Foriginal.jpeg&amp;w=250&amp;q=75 2x" src="/_next/image?url=https%3A%2F%2Fdn-api1-kage.kakao.com%2Fdn%2FsbfSz%2FbtrZ9MuS9Y1%2FWPUMKHHPHbZCZfUgB7IzW1%2Foriginal.jpeg&amp;w=250&amp;q=75" decoding="async" data-nimg="fixed" style="position:absolute;top:0;left:0;bottom:0;right:0;box-sizing:border-box;padding:0;border:none;margin:auto;display:block;width:0;height:0;min-width:100%;max-width:100%;min-height:100%;max-height:100%;object-fit:cover" loading="lazy"/>
                                                                    </noscript>
                                                                </span>
                                                            </div>
                                                            <div class="flex flex-col order-2 flex-1">
                                                                <div class="flex">
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span>5</span>
                                                                    </div>
                                                                    <div class="flex flex-col flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <img class="mr-2 inline shrink-0" src="\\211.63.89.130\sharing\07.프로젝트\2차\3조\_next\static\icons/badge_list_new_s.svg" width="16" height="16" alt="new 뱃지"/>
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                                        <p class="truncate-webkit typo-sm1 text-grey60 !typo-sm2 mt-8 h-36" style="-webkit-line-clamp:2">전쟁이 끝나고 모텔에 수용된 사람들, 전쟁은 아직 끝나지 않았다.</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </article>
                                                    </a>
                                                </div>
                                            </div>
                                        </section>
                                    </div>
                                    <div class="flex flex-col col-[9/-1] ml-30">
                                        <section>
                                            <div class="flex flex-wrap w-full items-start desktop:items-center border-b-1 border-black pb-16">
                                                <h2 class="typo-lg3-b flex-1 break-normal desktop:typo-lg1 desktop:flex-initial">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </h2>
                                                <a class="typo-md3 ml-auto flex items-center text-black desktop:text-grey60" href="/project2/home/ranking_month(login).jsp">
                                                    <span class="mr-4 hidden desktop:inline">더보기</span>
                                                    <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg" role="img">
                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M11 8.00064L6.06282 13.0013L4.99541 11.9474L8.8921 8.00064L4.99541 4.05387L6.06282 3L11 8.00064Z" fill="currentColor"></path>
                                                    </svg>
                                                </a>
                                                <div class="flex ml-auto border-1 border-grey20">
                                                </div>
                                            </div>
                                            <div class="flex flex-col">
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">6</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">7</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">8</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">9</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="flex flex-col border-b-0 desktop:border-b-1 border-black/10 py-8 desktop:py-16 desktop:px-0  desktop:last-of-type:border-b-0 desktop:last-of-type:pb-0">
                                                    <div class="flex items-center flex-row" data-testid="skeleton">
                                                        <div class="relative overflow-hidden rounded-3 bg-grey10 w-64 desktop:w-56 h-98 desktop:h-88 mr-14"></div>
                                                                    <div class="flex flex-col typo-g-md1 items-center ml-16 mr-12 w-11 desktop:mx-8 desktop:w-26">
                                                                        <span style="transform: translateY(-100%);">10</span>
                                                                    </div>
                                                        <div class="flex flex-col w-full flex-1">
                                                                        <div class="typo-md2 flex items-center desktop:typo-md1 !typo-md2 mb-6 desktop:!typo-md3 desktop:mb-4">
                                                                            <span class="truncate">모텔 피플</span>
                                                                        </div>
                                                                        <div class="typo-sm2 flex text-grey70 typo-sm2 mb-8 text-grey70">
                                                                            <div class="truncate after:inline-block after:w-0">김하하하하</div>
                                                                        </div>
                                                                        <div class="flex flex-wrap items-center text-grey60">
                                                                            <span class="typo-sm2 flex items-center">
                                                                                조회<span class="typo-g-sm2 -mb-[0.2em] ml-4">86</span>
                                                                            </span>
                                                                            <span class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span>
                                                                            <span class="typo-sm2 flex items-center">
                                                                                관심<span class="typo-g-sm2 -mb-[0.2em] ml-4">2</span>
                                                                            </span>
                                                                        </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </section>
                                    </div>
<!-- 																	 -->
                                </div>
                               </div>
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