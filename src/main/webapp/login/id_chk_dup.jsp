<%@page import="LoginDAO.LoginDAO"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
#warp{width: 300px; height: 200px}
#header{width:300px;height: 40px; text-align: center;}
#body{text-align: left;}
#body{width:300px;  height: 160px;}
#id{margin-top: 50px }
</style>
<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- jQuery CDN 끝 -->
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		
		
		$("#frm").submit(); //스스로에게 POST방식으로 값 전달 request.getParameter 사용하기 위해. get도 가능하지만 보안상 이유
	});
});

function sendId(id){
	opener.window.document.frm.id.value=id;
	self.close();
}//sendId
</script>

</head>
<body>
<div id="warp">
<div id="header">
<br/>
<h1><label>아이디 중복 확인</label></h1><br/>
</div>
<form action="id_chk_dup.jsp" method="post" id="frm">
<div id="body">
<label>아이디</label>
<input type="text" id="id"  name="id" class="inputBox" autofocus="autofocus" style="width:150px"/>
<input type="button" class="btnBorder" value="중복확인" id="btn"/>
</div>
</form>
</div>
<%
String id=request.getParameter("id");
if("POST".equals(request.getMethod())&& !"".equals(id)){
	if(id.length() <7){
		%>
		7자 이상으로 작성해주세요
		<%
	}else{
	LoginDAO lDAO = new LoginDAO();
	try{
		/* DataEncrypt de = new DataEncrypt("FsRt4SfY4US0IWtK4JPJsw==");
		String id_de = de.encryption(id);
	String resultId=lDAO.selectIdCheck(id_de); */
	String resultId=lDAO.selectIdCheck(id);
	
%>
<div id="select_result">
<%
if("".equals(resultId)){ //데이터베이스 검색 결과 아이디 없음%>
하신 <span style="font-weight: bold; color: #0142BA;font-size: 20px" ><%=id %></span>는 사용 가능합니다<br/>
<a href="#void" onclick="sendId('<%=id %>')">아이디 사용</a>
	
<%}else{ // 아이디가 중복일 경우%>
 중복된 아이디입니다
<%}
}catch(SQLException e){
	e.printStackTrace();
	%>
	데이터 베이스 접근 오류
<%}%>

<%}
	} %>
</div>
</body>
</html>