<%@page import="ManagerVO.MNovelVO"%>
<%@page import="ManagerDAO.ManagerDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    info="JSONArray"
    %><%
	ManagerDAO mDAO=new ManagerDAO();
    
    try{
	List<MNovelVO> list=mDAO.selectNovelManageAll();    
		
	//1. JSONArray 생성 
	JSONArray jsonArr=new JSONArray();
	//2. 데이터베이스에서 조회한 결과로 JSONObject을 생성하고 JSONArray에 추가
	JSONObject jsonTemp=null;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	for(MNovelVO mNovelVO:list){
		//JSONObject을 생성하고
		jsonTemp=new JSONObject();
		//생성된 JSONObject에 속성값을 넣는다.
		jsonTemp.put("novelTitle", mNovelVO.getNovelTitle());
		jsonTemp.put("id", mNovelVO.getId());
		jsonTemp.put("novelNum", mNovelVO.getNovelNum());
		jsonTemp.put("likeCnt", mNovelVO.getLikeCnt());
		jsonTemp.put("reportCnt", mNovelVO.getReportCnt()); 
		jsonTemp.put("createCnt", sdf.format(mNovelVO.getCreateDate()));
		
		//값을 가진 JSONObject을 JSONArray에 할당
		jsonArr.add(jsonTemp);
	}//end for
	
	//3. JSONArray 출력
	out.print(jsonArr.toJSONString());
	
    }catch(SQLException se){
    	se.printStackTrace();
    }//end catch
%>    
