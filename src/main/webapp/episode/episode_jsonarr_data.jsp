<%@page import="EpisodeVO.ListEpisodeVO"%>
<%@page import="EpisodeDAO.EpisodeDAO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" info="JSONArray" %><%
    
    /* String novel = request.getParameter("novelNum");
    int novelNum = Integer.parseInt(novel); */
    int novelNum = 23;
    
	EpisodeDAO epDAO = new EpisodeDAO();
    
    try{
    	// 에피소드 회차 출력
		List<ListEpisodeVO> list = epDAO.selectAllEp(novelNum);
    	
		/* private String epTitle;
		private int viewCnt;
		private Date createDate; */
		
		// 1. JSONArray 생성
		JSONArray jsonArr = new JSONArray();
		
		// 2. 데이터베이스에서 조회한 결과로 JSONObject 생성하고, JSONArray에 추가
		JSONObject jsonTemp = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		
		for(ListEpisodeVO leVO : list){
			// JSONObject을 생성하고
			jsonTemp = new JSONObject();
			
			// 생성된 JSONObject에 속성값을 넣는다.
			jsonTemp.put("epTitle", leVO.getEpTitle());
			jsonTemp.put("viewCnt", leVO.getViewCnt());
			jsonTemp.put("createDate", sdf.format(leVO.getCreateDate()));
			
			// 값을 가진 JSONObject을 JSONArray에 할당
			jsonArr.add(jsonTemp);
		}
		
		// 3. JSONArray 출력 
		out.print(jsonArr.toJSONString());
		System.out.print(jsonArr.toJSONString());
    	
    }catch(SQLException se){
    	se.printStackTrace();
    	out.print("조회가 되지 않습니다.");
    }catch(NullPointerException ne){
    	ne.printStackTrace();
    	out.print("값이 들어있지않습니다.");
    }
    
%>

    