<%@page import="ManagerVO.MemberManageVO"%>
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
    List<MemberManageVO> mmList = mDAO.selectMemberManage();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    JSONObject jsonObj = null;
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
    for( MemberManageVO mmVO : mmList ){
    	jsonObj = new JSONObject();
    	jsonObj.put("num_member", mmVO.getNum_member() );
    	jsonObj.put("id", mmVO.getId() );
    	jsonObj.put("novelCnt", mmVO.getNovelCnt() );
     	jsonObj.put("visitDate", sdf.format(mmVO.getVisitDate()) );
     	jsonObj.put("joinDate", sdf.format(mmVO.getJoinDate() ) );
    	jsonObj.put("stopDate", sdf.format(mmVO.getSusPeriod() ) ); 
        //3. JSONObject을 JSONArray 할당
        jsonArr.add(jsonObj);
    }
    
    out.print(jsonArr.toJSONString());
    
    
    //4. 출력
}catch(SQLException se){
	se.printStackTrace();
	out.print("조회가 되지 않습니다.");
}catch(NullPointerException ne){
	ne.printStackTrace();
	out.print("값이 들어있지않습니다.");
}

  
%>