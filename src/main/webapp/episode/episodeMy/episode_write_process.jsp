<%@page import="java.sql.SQLException"%>
<%@page import="EpisodeDAO.EpisodeMyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
   //POST방식
   request.setCharacterEncoding("UTF-8");
   %> 

<script type="text/javascript">
	if("<%=request.getMethod()%>" == "GET") {
		alert("정상적인 방식으로 요청하지 않았어요");
		location.href = "http://localhost/project2/episode/my_novel_list.jsp";
	}
</script>

<jsp:useBean id="ceVO" class="EpisodeVO.My.CreateEpisodeVO" scope="page"/>
<jsp:setProperty property="*" name="ceVO"/>

<%
EpisodeMyDAO emDAO = new EpisodeMyDAO();

	try{
		emDAO.insertEpisode(ceVO);
		response.sendRedirect("/project2/episode/my_novel_list.jsp");
		
	}catch(SQLException e){
		e.printStackTrace();
	}
%>
