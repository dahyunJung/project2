<%@page import="EpisodeDAO.EpisodeDAO"%>
<%@page import="EpisodeVO.My.EditEpisodeVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="EpisodeDAO.EpisodeMyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<jsp:useBean id="lVO" class="EpisodeVO.User.LikeVO" scope="page"/>
<jsp:setProperty property="*" name="lVO"/>

<%
	request.setCharacterEncoding("UTF-8");
	
	int novelNum = Integer.parseInt(request.getParameter("num_novel"));
	//int userNum = (Integer)session.getAttribute("num_novel");
	int userNum = 7;
	
	System.out.println("좋아요할 소설번호: "+novelNum);
	
	String id = request.getParameter("id");
	String good = request.getParameter("good");
	
	EpisodeDAO episodeDAO = new EpisodeDAO();

	lVO.setNovelNum(novelNum);

	try{
		if("1".equals(good)){
			int insertLike = episodeDAO.insertLike(lVO);
			
			if(insertLike > 0){
				System.out.println(novelNum + ", " +userNum + ", 좋아요 완료 ");
				response.sendRedirect("/project2/episode/novel.jsp?num_novel=" + novelNum); 
			}else{
				System.out.println(novelNum + ", " +userNum + ", 좋아요 실패 ");
				response.sendRedirect("/project2/episode/novel.jsp?num_novel=" + novelNum); 
			}
			
		}else if("0".equals(good)){
			int deleteLike = episodeDAO.deleteLike(userNum, novelNum);
			if(deleteLike > 0){
				System.out.println(novelNum + ", " +userNum + ", 좋아요 취소 완료 ");
				response.sendRedirect("/project2/episode/novel.jsp?num_novel=" + novelNum);
			}else{
				System.out.println(novelNum + ", " +userNum + ", 좋아요 취소 실패 ");
				response.sendRedirect("/project2/episode/novel.jsp?num_novel=" + novelNum);
			}
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}
%>
<script type="text/javascript">
	if("<%=request.getMethod()%>" == "GET") {
		alert("정상적인 방식으로 요청하지 않았어요");
		location.href = "http://localhost/project2/episode/novel_.jsp?num_novel="+novelNum;
	}
</script>

