<%@page import="LoginDAO.LoginDAO"%>
<%@page import="LoginVO.LoginHistoryVO"%>
<%@page import="LoginVO.SessionVO"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String pw_de = DataEncrypt.messageDigest("MD5",pw);

String ip = request.getRemoteAddr();
String userAgent = request.getHeader("User-Agent");
String os = null;

if (userAgent != null) {
    if (userAgent.contains("Windows")) {
        os = "Windows";
    } else if (userAgent.contains("Mac")) {
        os = "Mac OS X";
    } else if (userAgent.contains("Linux")) {
        os = "Linux";
    } else if (userAgent.contains("Android")) {
        os = "Android";
    } else if (userAgent.contains("iPhone")) {
        os = "iOS";
    }
}

LoginDAO lDAO = new LoginDAO();
LoginHistoryVO lhVO = new LoginHistoryVO();

lhVO.setIp(ip);
lhVO.setOS(os);

SessionVO sVO = lDAO.selectLogin(id, pw_de,lhVO);

if(sVO.getId()==null){
	%>
	<script>
	alert("회원정보를 찾을 수 없습니다");
	history.back();
	</script>
<%	
}else{
	session.setAttribute("user_num_member", sVO.getNum_member());
	session.setAttribute("user_id", sVO.getId());
	session.setAttribute("user_name", sVO.getName());
	session.setAttribute("user_photo", sVO.getPhoto());
	session.setMaxInactiveInterval(60*60*1);
	System.out.println(sVO.getPhoto());
	
	 request.getRequestDispatcher("../home/main.jsp").forward(request, response); 
	  /* request.getRequestDispatcher("my_page.jsp").forward(request, response);   */

}
%>