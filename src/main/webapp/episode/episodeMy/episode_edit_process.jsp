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

<jsp:useBean id="edVO" class="EpisodeVO.My.EditEpisodeVO" scope="page"/>
<jsp:setProperty property="*" name="edVO"/>

<%
	int userNum = (Integer)session.getAttribute("user_num_member");
	int num_novel = Integer.parseInt(request.getParameter("num_novel"));
	int epNum = Integer.parseInt(request.getParameter("epNum")); 
	

	// 공개여부 전환
	String open=request.getParameter("openStatus");
	edVO.setOpenStatus("1".equals(open));
	/* edVO.setNovelNum(num_novel); */

	EpisodeMyDAO emDAO = new EpisodeMyDAO();

	try{
		int editCnt = emDAO.updateEpisode(edVO);
		
		if(editCnt > 0){
			System.out.println(editCnt + ", 수정 완료 ");
			response.sendRedirect("../../novel/novel_list.jsp?num_novel="+num_novel);		
		}else{
			System.out.println(edVO.getEpNum()+", "+editCnt + ", 수정 실패");
			response.sendRedirect("../../novel/novel_list.jsp?num_novel="+num_novel);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
%>


<body>

</body>
</html>