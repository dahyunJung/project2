<%@page import="novel.NewNovelDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script type="text/javascript">
	<%
	System.out.print(request.getParameter("num_novel"));
	NewNovelDAO nDAO=new NewNovelDAO();
	nDAO.deleteNovel(Integer.parseInt(request.getParameter("num_novel")));
	%>
	window.close();
</script>
	

</head>
<body>
	
</body>
</html>