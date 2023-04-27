<%@page import="EpisodeDAO.EpisodeDAO"%>
<%@page import="EpisodeVO.My.EditEpisodeVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="EpisodeDAO.EpisodeMyDAO"%>
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

<jsp:useBean id="rVO" class="EpisodeVO.User.ReportVO" scope="page"/>
<jsp:setProperty property="*" name="rVO"/>

<%
	// 공개여부 전환
	int userNum = 3;
	//int novelNum = 23;
	
	String report = request.getParameter("report");
	String reportId = request.getParameter("reportId");
	
	//int userNum = Integer.parseInt(request.getParameter("userNum"));
	int novelNum = Integer.parseInt(request.getParameter("novelNum"));

	 EpisodeDAO epDAO = new EpisodeDAO();
	 
	 try{
		int reportCnt=0;
		
		System.out.println(reportId);
		if(reportCnt > 0){
			epDAO.insertReport(rVO);
			
			System.out.println(reportCnt + ", 신고 완료 ");
			
		}else{
			System.out.println(rVO.getNovelNum()+", "+reportCnt + ", 신고 실패");
			System.out.println("error");
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
%>


<body>

</body>
</html>