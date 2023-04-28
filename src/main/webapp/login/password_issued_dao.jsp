<%@page import="LoginDAO.LoginDAO"%>
<%@page import="kr.co.sist.util.cipher.DataDecrypt"%>
<%@page import="java.util.Random"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 if("POST".equals(request.getMethod())){   //post로 들어왔을 때 작동 
	 String id = request.getParameter("id");
	 String phone = request.getParameter("phone");
	 
	 String email = request.getParameter("email");
LoginDAO lDAO = new LoginDAO();

/* DataEncrypt de= new DataEncrypt("FsRt4SfY4US0IWtK4JPJsw==");
String email= de.encryption(email1); */


%>
<jsp:useBean id="fpVO" class="LoginVO.FindPWVO" scope="page"/>
<jsp:setProperty property="id" name="fpVO" value="<%=id %>" /> 
<jsp:setProperty property="phone" name="fpVO" value="<%=phone %>" /> 
<jsp:setProperty property="email" name="fpVO" value="<%=email %>" /> 

<%

boolean result = lDAO.selectCheckPW(fpVO);

if(result){
	
	int length=10;//임시 비번 만들기
	String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	Random random = new Random();
    StringBuilder password = new StringBuilder();
    
    for (int i = 0; i < length; i++) {
        password.append(chars.charAt(random.nextInt(chars.length())));
    }
    String passwordTemp = password.toString(); // 이건 따로 사용자에게 보여줄 임시 비밀번호
    
    
    
    fpVO.setPassTemp(DataEncrypt.messageDigest("MD5",passwordTemp)); // fpVO 값에 넣기 암호화 해서
    
    if(lDAO.updatePW(fpVO) ==1){
    request.setAttribute("passwordTemp", passwordTemp);
    request.getRequestDispatcher("reset_password.jsp").forward(request, response);
    	
    }else{
    %>
    	<script>	alert("데이터베이스 접근 오류");
		history.back();
</script>
    	
 <% 
 }
	
	
}else{
	%>
	<script>	alert("일치하는 회원 정보를 찾을 수 없습니다");
				history.back();
	</script>
	<%
	
}

%>


 <%}%>