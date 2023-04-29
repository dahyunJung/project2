<%@page import="oracle.net.aso.j"%>
<%@page import="LoginDAO.LoginDAO"%>
<%@page import="java.util.Date"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%
    request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="http://211.63.89.150/common/main_v20230217.css"/>
<style type="text/css">
#wrap{ width: 1000px; height: 1200px;margin: 0px auto; }
#header{  height: 200px; position: relative;
	background: #FFFFFF url(http://211.63.89.150/common/images/header_bg.png)  repeat-x;}

#logo{ position:absolute;top: 40px;left:100px; width: 150px; font-weight: bold; font-size: 40px;
	font-family: 고딕 ;}	
#naviBar{ position:absolute;top:140px;left:0px;height: 60px }	 
#container{ height: 900px;position: relative; }	 

#footer{ height: 100px;position: relative;  }	 
#flogo{ position:absolute;top:20px;left:100px;height: 60px;font-weight: bold; font-size: 20px;
	font-family: 고딕 ; color:#d7d7d7; text-align: right; width:100%;  }	 

</style>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- jQuery CDN 끝 -->
<script type="text/javascript">
if("<%= request.getMethod()%>"=="GET"){
	alert("정상적인 방식의 요청이 아닙니다");
	location.href="loginpage.jsp";
</script>

</head>
<body>
<div id="wrap"> 
<div id="header">
	<div id="logo">Class 4.</div>
	<div id="naviBar">navi ( 1000 x 60)</div>
</div>
<div id="container">
<% 
if("POST".equals(request.getMethod())){
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String birthDate = request.getParameter("birthDate");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date birth = format.parse(birthDate);
	String phone = request.getParameter("phone");
	String email1 = request.getParameter("email");
	String email2 = request.getParameter("email2");
	String email = email1 +'@'+ email2;
	
	

%>
<jsp:useBean id="jVO" class="LoginVO.JoinVO" scope="page"/>
<jsp:setProperty property="name" name="jVO" value="<%=name %>" /> 
<jsp:setProperty property="id" name="jVO" value="<%=id %>" /> 
<jsp:setProperty property="pw" name="jVO" value="<%=pw %>" /> 
<jsp:setProperty property="birthDate" name="jVO" value="<%=birth %>" /> 
<jsp:setProperty property="phone" name="jVO" value="<%=phone %>" /> 
<jsp:setProperty property="email" name="jVO" value="<%=email %>" /> 

<%
 jVO.setPw(DataEncrypt.messageDigest("MD5",jVO.getPw()));

/* DataEncrypt de = new DataEncrypt("FsRt4SfY4US0IWtK4JPJsw==");
jVO.setId(de.encryption(jVO.getId()));
jVO.setEmail(de.encryption(jVO.getEmail()));  */
jVO.setId(jVO.getId());
jVO.setEmail(jVO.getEmail()); 

try{
LoginDAO lDAO = new LoginDAO();
	
	boolean dupPhone = lDAO.selectPhoneDup(jVO.getPhone());

	if(!dupPhone){
		%>
		<script>alert("전화번호가 중복됩니다");
		history.back();
		</script>
		<% 
	}

	lDAO.insertMember(jVO);

response.sendRedirect("new_member3.jsp");

}catch(SQLException e){
	e.printStackTrace();
	
	} 
}%>
<form action="new_member3.jsp" method="post" id="frm" name="frm"></form>
</div>
<div id="footer">footer ( 1000 x 100)
	<div id="flogo"> Copyright &copy; Class 4. All rights reserved.</div>
</div>
</div>
</body>
</html>