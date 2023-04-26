<%@page import="EpisodeVO.EditEpisodeVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="EpisodeDAO.MyPageDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html lang="ko">
<head>
<script type="text/javascript">

</script>
</head>
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="lVO" class="EpisodeVO.LikeVO" scope="page"/>
<jsp:setProperty property="*" name="lVO"/>

<%
	// 공개여부 전환
	String good=request.getParameter("good");
	lVO.ge

	MyPageDAO mDAO = new MyPageDAO();

	try{
		int editCnt = mDAO.updateEpisode(lVO);
		
		if(editCnt > 0){
			System.out.println(editCnt + ", 수정 완료 ");
			
			response.sendRedirect("/project2/novel/novel_list.jsp");		
		}else{
			System.out.println(edVO.getEpNum()+", "+editCnt + ", 수정 실패");
			System.out.println("error");
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
%>


<body>

</body>
</html>