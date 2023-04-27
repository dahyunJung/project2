<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="프로필 사진 변경을 위한 DAO"
    %>
    <%
  //1. 저장디렉토리를 설정
    File saveDirectory=new File("D:/dev/workspace/jsp_prj/src/main/webapp/upload/");
    int totalMaxSize=1024*1024*500;
    int fileSize=1024*1024*10;
    //2. FileUpload Component 생성(multipartRequest) => 생성함과 동시에 파일이 업로드된다
    MultipartRequest mr =new MultipartRequest(request,saveDirectory.getAbsolutePath(),totalMaxSize,"UTF-8",new DefaultFileRenamePolicy());
    //3.FileUpload Component파라메터를 받는다
    
    %>

    