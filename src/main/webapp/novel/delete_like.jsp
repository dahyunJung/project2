<%@page import="java.sql.SQLException"%>
<%@page import="novel.MyLikeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
%>
<%
MyLikeDAO mDAO=new MyLikeDAO();
try{
mDAO.deleteNovel(request.getParameter("num_novel"), session.getAttribute("id").toString());
}catch(SQLException se){
	se.printStackTrace();
}
response.sendRedirect("http://localhost/project2/login/like.jsp?search=");
%>