<%@page import="EpisodeDAO.EpisodeDAO"%>
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

<jsp:useBean id="rVO" class="EpisodeVO.ReportVO" scope="page"/>
<jsp:setProperty property="*" name="rVO"/>

<%
	// 공개여부 전환
	String report = request.getParameter("report");

	 EpisodeDAO epDAO = new EpisodeDAO();

	/* try{
		int editCnt;
		
		if(editCnt > 0){
			System.out.println(editCnt + ", 수정 완료 ");
			
		}else{
			System.out.println(edVO.getEpNum()+", "+editCnt + ", 수정 실패");
			System.out.println("error");
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	} */
%>


<body>

</body>
</html>