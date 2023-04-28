<%@page import="LoginDAO.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int update=0;

String id = request.getParameter("id");
String phone = request.getParameter("phone");

String email1 = request.getParameter("email1");
String email2 = request.getParameter("email2");
String email = email1+"@"+email2;
%>
<jsp:useBean id="uiVO" class="LoginVO.UpdateInfoVO" scope="page"/>
<jsp:setProperty property="id" name="uiVO" value="<%=id %>" /> 
<jsp:setProperty property="phone" name="uiVO" value="<%=phone %>" /> 
<jsp:setProperty property="email" name="uiVO" value="<%=email %>" /> 


<%
LoginDAO lDAO = new LoginDAO();
update = lDAO.updateInfo(uiVO);

if(update == 0){
	%>
	<script>
	alert("데이터베이스 연결 오류.");
	history.back();
	</script>
	<% 
}else{
	%>
	<script>
	alert("변경이 완료되었습니다.");
	window.location.href="my_page.jsp";
	</script>
	<%
}
%>
