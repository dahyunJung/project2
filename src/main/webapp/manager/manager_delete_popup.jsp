<%@page import="ManagerDAO.ManagerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charSet="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=0" />
<meta name="next-head-count" content="2" />
<link rel="preconnect" href="https://fonts.gstatic.com"
	crossorigin="anonymous" />
<link rel="stylesheet"
	data-href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:500,700&amp;display=swap" />
<link rel="preload"	href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css"	as="style" />
<link rel="stylesheet" href="https://pagestage-cdn.kakaoent.com/web/_next/static/css/6e5d8ba319c77348.css" data-n-g="" />
<link rel="stylesheet" type="text/css" href="/project2/_next/static/css/login.css" />

<style type="text/css">
#wrap {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}
</style>	
<script type="text/javascript" >
/* function deleteNovel(novelId) {
	  // novelId는 삭제할 소설의 ID입니다.
	  $.ajax({
	    type: 'POST',
	    url: 'delete_novel.jsp',
	    data: {
	      id: novelId
	    },
	    success: function(response) {
	      alert("소설이 삭제되었습니다.");
	      window.location.reload();
	    },
	    error: function(xhr, status, error) {
	      alert("소설 삭제에 실패했습니다. 다시 시도해주세요.");
	    }
	  });
	}

 */
</script>
</head>
<body>
<%
/* String novelNum = request.getParameter("novelNum"); // 제목 파라미터 받아오기
ManagerDAO mDAO = new ManagerDAO();
mDAO.deleteNovel(Integer.parseInt(novelNum)); // 소설 삭제하기 */

String novelNum = request.getParameter("novelNum");
if(novelNum != null && !novelNum.equals("")) {
    ManagerDAO mDAO = new ManagerDAO();
    mDAO.deleteNovel(Integer.parseInt(novelNum));
}
%> 
		<div 
			class="flex rounded-t-0 relative z-1 max-h-[70%] flex-col overflow-hidden bg-white"
			data-body-scroll-lock="ignore" style="width: 502px; height: 250px;">
			<div
				class="flex flex-col h-full overflow-hidden px-18 py-24 desktop:p-30">
				<div style="position: relative; top: 15px"
					class="flex-1 overflow-y-scroll scrollbar-hide desktop:px-10 desktop:pt-10">
					<div class="typo-md1 text-center desktop:typo-lg3 py-8">
						<div class="whitespace-pre-line"
							style="font-weight: bold; font-size: 20px">삭제하시겠습니까?</div>
					</div>
				</div>
			<form id="deleteForm" method="post" action="manager_delete_novel.jsp">
			  <input type="hidden" name="title" value="<%= request.getParameter("title") %>">
				<div class="w-full shrink-0" style="position: relative;bottom: 18px; top:20px">
					<div class="flex mt-24 desktop:mt-32">
						<!-- <button
							class="flex items-center justify-center border-1 appearance-none px-24 py-12 typo-md2-b mr-8 flex-1"
							type="button" style="font-weight: bold">취소</button>
						<button
							class="flex items-center justify-center border-1 appearance-none bg-black border-black text-white disabled:border-grey20 disabled:bg-grey20 disabled:text-grey60 px-24 py-12 typo-md2-b flex-1"
							type="button" style="font-weight: bold">삭제</button> -->
					  <button class="flex items-center justify-center border-1 appearance-none px-24 py-12 typo-md2-b mr-8 flex-1"
					    type="button" style="font-weight: bold" onclick="window.close()">취소</button>
					  <button class="flex items-center justify-center border-1 appearance-none bg-black border-black text-white disabled:border-grey20 disabled:bg-grey20 disabled:text-grey60 px-24 py-12 typo-md2-b flex-1"
					    type="submit" style="font-weight: bold" id="deleteButton">삭제</button>
					</form>

<script>
  function deletePop(title) {
    document.getElementsByName("title")[0].value = title;
    document.getElementById("deleteButton").removeAttribute("disabled");
    window.open("manager_delete_popup.jsp", "popup", "width=502;height=250,top="
      + (window.screenY + 100) + ",left=" + (window.screenX + 100));
  }
</script>
							
							
							
							
					</div>
				</div>
			</div>
		</div>
	
</body>
</html>