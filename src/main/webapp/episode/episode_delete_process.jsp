<%@page import="java.sql.SQLException"%>
<%@page import="EpisodeDAO.MyPageDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	request.setCharacterEncoding("UTF-8");	
	
	int userNum = (Integer)session.getAttribute("userNum");
	int novelNum = Integer.parseInt(request.getParameter("novelNum")); 
	int epNum = Integer.parseInt(request.getParameter("epNum")); 


// 유저번호 값이 있는지 확인 (세션)
	if(userNum == 0){
%>
	<script type="text/javascript">
		alert("세션 userNum의 값이 없음");
		location.href="http://localhost/project2/login/loginpage.jsp";
		//response.sendRedirect("http://localhost/project2/login/loginpage.jsp");
	</script>
<%	}	

	if(novelNum == 0){
%>
	<script type="text/javascript">
		alert("파라미터 novelNum의 값이 없음");
		location.href="http://localhost/project2/novel/novel_list.jsp";
		//response.sendRedirect("http://localhost/project2/login/loginpage.jsp");
	</script>
<%	}	

	if(epNum == 0){
%>
	<script type="text/javascript">
		alert("파라미터 epNum의 값이 없음");
		location.href="http://localhost/project2/novel/novel_list.jsp";
		//response.sendRedirect("http://localhost/project2/login/loginpage.jsp");
	</script>
<%	}

	MyPageDAO mDAO = new MyPageDAO();
	try{
		int removeCnt = mDAO.deleteEpisode(userNum, novelNum, epNum);
		
		if(removeCnt <= 0){
			System.out.println(epNum+", "+removeCnt + ", 삭제 실패");
		}else{
			System.out.println(epNum+", "+removeCnt + ", 삭제 완료");
			// 창이 종료되는 거 만들어야됨
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
%>