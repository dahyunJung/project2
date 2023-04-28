<%@page import="LoginDAO.LoginDAO"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("user_id");
String pw = request.getParameter("pw");
String pw_de = DataEncrypt.messageDigest("MD5",pw);
int update =0;

LoginDAO lDAO = new LoginDAO();
update = lDAO.updatePass(id, pw_de);

if(update == 0){
	%>
	<script>
	alert(<%=id%>);
	alert("데이터베이스 오류");
	history.back();
	</script>
	<%
}else{
	%>
	<script>
	alert("비밀번호가 변경되었습니다");
	window.close();
	</script>
	<%
}
%>