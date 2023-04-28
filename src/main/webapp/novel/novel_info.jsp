<%@page import="java.sql.SQLException"%>
<%@page import="novel.NovelListVO"%>
<%@page import="novel.NovelListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charSet="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
<meta name="next-head-count" content="2" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="anonymous" />
<link rel="stylesheet" data-href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500,700&amp;display=swap" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css"	as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" data-n-g="" />
<link rel="stylesheet" type="text/css" href="/project2/_next/static/css/login.css" />
<noscript data-n-css=""></noscript>

</head>

<body>
	<div id="__next" data-reactroot="">
		<div
			style="display: none; background-color: canvas; color-scheme: light"></div>
		<div class="lightMode h-full">
			<div class="flex flex-col h-full">
				<div class="z-1">
<!-- header -->
	<div>
		<jsp:include page="../_next/header_user_login_search.jsp"/>
	</div>	
				</div>

				<main class="flex-1">
					<section
						class="flex mx-auto w-full max-w-default flex-row flex-wrap desktop:px-22">
						<div class="flex flex-col flex-1">
							<div class="mt-16 desktop:mb-48 desktop:mt-56">
								<div>
									<%
									NovelListDAO nDAO=new NovelListDAO();
									try{
										NovelListVO nVO=nDAO.selectNovel(request.getParameter("num_novel"));
									%>
									<div class="flex mb-4 items-end">
										<h1 class="typo-dp1 mr-40 flex-1 break-words"><%=nVO.getTitle() %></h1>
										<div class="flex shrink-0 items-center">
											<div class="relative overflow-visible"></div>
										</div>
									</div>
									<div class="flex typo-md3 items-center">
										<span><%=nVO.getId() %></span><span class="mx-4 text-10 mx-8 text-grey20"></span>
									</div>
									<div class="flex mt-30 items-center">
										<div
											class="flex relative shrink-0 items-start overflow-hidden mr-30 h-180 w-118 cursor-zoom-in"
											style="height: 180px;">
											<span
												style="box-sizing: border-box; display: inline-block; overflow: hidden; width: 118px; height: 180px; background: none; opacity: 1; border: 0px; margin: 0px; padding: 0px; position: relative;"><img
												srcset="/project2/_next/static/images/novel_thumb/<%=nVO.getPhoto() %>"
												src="/project2/_next/static/images/novel_thumb/<%=nVO.getPhoto() %>" decoding="async"
												data-nimg="fixed"
												style="position: absolute; inset: 0px; box-sizing: border-box; padding: 0px; border: none; margin: auto; display: block; width: 0px; height: 0px; min-width: 100%; max-width: 100%; min-height: 100%; max-height: 100%; object-fit: cover;"></span>
										</div>
										<div class="flex flex-col flex-1 self-stretch">
											<div
												class="typo-md3 text-14 text-grey70 desktop:max-w-[680px]">
												<span width="0"><span><span><%=nVO.getStory() %></span><br>
														<span></span><br> <span></span></span><span
													style="position: fixed; visibility: hidden; top: 0px; left: 0px;"><button
															class="font-bold">
															...<span class="ml-4 border-b-1 border-grey70">더보기</span>
														</button></span></span>
											</div>
											<div class="mt-auto">
												<div class="flex">
													<a href="2_10_12_novel_read.jsp"><button
															class="flex items-center justify-center border-1 appearance-none bg-black border-black text-white disabled:border-grey20 disabled:bg-grey20 disabled:text-grey60 px-28 py-12 typo-md2-b desktop:px-56 desktop:py-13 desktop:typo-lg2-b mr-5"
															type="button">첫회 읽기</button></a>
												</div>
											</div>
										</div>
									</div>
									<%
									}catch(SQLException se){
										se.printStackTrace();
									}
									%>
								</div>
							</div>
							<div class="px-18 desktop:px-0"></div>
							<div class="border-b-1 py-9 desktop:border-b-2 desktop:py-12">
								<div class="flex typo-md3 items-center justify-between">
									<div class="flex typo-lg3-b items-center desktop:typo-lg1">
										작품 회차<span
											class="typo-g-sm2 -mb-[0.2em] !typo-g-lg3 ml-2 desktop:ml-6 desktop:!typo-g-lg1 desktop:text-grey60">(2)</span>
									</div>
									<select class="w-full typo-sm1 desktop:text-grey70" style="right:40px;width: 100px"
													aria-controls="최신 업데이트 순">
													<option value="최신 업데이트 순">최신 업데이트 순</option>
													<option value="최신 업데이트 순">신작 순</option>
													<option value="최신 업데이트 순">오래된 순</option>
												</select>
								</div>
							</div>
							<section class="flex flex-col desktop:mb-96">
								<article>
									<a
										class="flex border-black/10 bg-white px-18 visited:bg-grey10 desktop:border-b-1 desktop:px-30 "
										href="2_10_12_novel_read.jsp"><div
											class="border-b-1 border-black/10 desktop:border-0 flex flex-1 py-16 desktop:py-22">
											<span
												class="typo-g-sm2 -mb-[0.2em] !typo-g-md2 mr-12 mt-1 desktop:mr-20 desktop:mt-3 desktop:!typo-g-lg2">2.</span>
											<div
												class="flex flex-col flex-1 justify-between desktop:mr-16 desktop:flex-row desktop:items-center">
												<div class="flex flex-col flex-1">
													<div
														class="flex mb-14 mt-0 flex-1 items-center desktop:mb-16 desktop:mt-2 typo-md2 text-black desktop:typo-lg2 max-h-[28px] overflow-hidden">
														<div class="truncate after:inline-block after:w-0 shrink">제목</div>
														<img alt="" class="ml-6 inline shrink-0 desktop:ml-8"
															src="/project2/_next/static/icons/badge_list_up_m.svg">
													</div>
													<div class="flex flex-wrap items-center text-grey60">
														<span class="typo-sm2 flex items-center">조회<span
															class="typo-g-sm2 -mb-[0.2em] ml-4">3</span></span><span
															class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span><span
															class="typo-sm2 flex items-center">좋아요<span
															class="typo-g-sm2 -mb-[0.2em] ml-4">0</span></span><span
															class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span><span
															class="typo-g-sm2 -mb-[0.2em]">2023.02.27</span>
													</div>
												</div>
											</div>
										</div></a>
								</article>
								<article>
									<a
										class="flex border-black/10 bg-white px-18 visited:bg-grey10 desktop:border-b-1 desktop:px-30 "
										href="2_10_12_novel_read.jsp"><div
											class="border-b-1 border-black/10 desktop:border-0 flex flex-1 py-16 desktop:py-22">
											<span
												class="typo-g-sm2 -mb-[0.2em] !typo-g-md2 mr-12 mt-1 desktop:mr-20 desktop:mt-3 desktop:!typo-g-lg2">1.</span>
											<div
												class="flex flex-col flex-1 justify-between desktop:mr-16 desktop:flex-row desktop:items-center">
												<div class="flex flex-col flex-1">
													<div
														class="flex mb-14 mt-0 flex-1 items-center desktop:mb-16 desktop:mt-2 typo-md2 text-black desktop:typo-lg2 max-h-[28px] overflow-hidden">
														<div class="truncate after:inline-block after:w-0 shrink">제목</div>
														<img alt="" class="ml-6 inline shrink-0 desktop:ml-8"
															src="/project2/_next/static/icons/badge_list_up_m.svg">
													</div>
													<div class="flex flex-wrap items-center text-grey60">
														<span class="typo-sm2 flex items-center">조회<span
															class="typo-g-sm2 -mb-[0.2em] ml-4">3</span></span><span
															class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span><span
															class="typo-sm2 flex items-center">좋아요<span
															class="typo-g-sm2 -mb-[0.2em] ml-4">0</span></span><span
															class="mx-4 text-10 !mx-6 mb-1 block text-black/10 desktop:!mx-8">|</span><span
															class="typo-g-sm2 -mb-[0.2em]">2023.02.27</span>
													</div>
												</div>
											</div>
										</div></a>
								</article>
								<div class="flex items-center justify-center py-8 mx-auto my-40">
									<a
										class="flex h-34 w-34 items-center justify-center pointer-events-none mr-20 !w-24 opacity-40"
										href="/novels/30275658?page=-1"><svg width="24"
											height="24" viewBox="0 0 24 24" fill="none"
											xmlns="http://www.w3.org/2000/svg" role="img"
											class="rotate-180" title="prev">
											<path fill-rule="evenodd" clip-rule="evenodd"
												d="M18.0605 12.0001L8.99989 21.0608L7.93923 20.0001L15.9392 12.0001L7.93923 4.00011L8.99989 2.93945L18.0605 12.0001Z"
												fill="currentColor"></path></svg></a><a
										class="flex h-34 w-34 items-center justify-center mx-4"
										href="/novels/30275658?page=0"><div
											class="flex typo-g-sm1 flex h-full w-full items-center justify-center rounded-full bg-black !font-bold text-white">1</div></a><a
										class="flex h-34 w-34 items-center justify-center pointer-events-none ml-20 !w-24 opacity-40"
										href="/novels/30275658?page=1"><svg width="24" height="24"
											viewBox="0 0 24 24" fill="none"
											xmlns="http://www.w3.org/2000/svg" role="img" title="next">
											<path fill-rule="evenodd" clip-rule="evenodd"
												d="M18.0605 12.0001L8.99989 21.0608L7.93923 20.0001L15.9392 12.0001L7.93923 4.00011L8.99989 2.93945L18.0605 12.0001Z"
												fill="currentColor"></path></svg></a>
								</div>
							</section>
						</div>
					</section>
				</main>
	<!-- footer -->
	<div>
		<jsp:include page="../_next/footer.jsp"/>
	</div>
</body>
</html>

