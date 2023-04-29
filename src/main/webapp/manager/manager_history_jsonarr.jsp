<%@page import="ManagerVO.LoginHistoryVO"%>
<%@page import="ManagerDAO.ManageDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    ManageDAO mDAO = new ManageDAO();
try{
    //1. JSONArray를 생성
    JSONArray jsonArr = new JSONArray();
    
    //2. JSONObject 생성하여 조회 결과를 할당
    List<LoginHistoryVO> lhList = mDAO.selectHistory();
    
    JSONObject jsonObj = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /*기존 for문
    InjectionVO iVO = null;
    for( int i=0; i<list.size(); i++ ){
    	iVO = list.get(i);
    	jsonObj = new JSONObject();
    	jsonObj.put("id", iVO.getId() );
    	jsonObj.put("name", iVO.getName() );
    }//end for 
    */
    
  //개선된 for
  String result = "";
    for( LoginHistoryVO lhVO : lhList ){
    	jsonObj = new JSONObject();
    	jsonObj.put("id", lhVO.getId() );
    	jsonObj.put("DeviceOS", lhVO.getDeviceOS() );
    	jsonObj.put("ip", lhVO.getIp() );
    	jsonObj.put("loginDate", sdf.format(lhVO.getLoginDate()) );
        //3. JSONObject을 JSONArray 할당
        jsonArr.add(jsonObj);
    }
    
    out.print(jsonArr.toJSONString());
    
}catch(SQLException se){
	se.printStackTrace();
}
    //4. 출력

  
%>