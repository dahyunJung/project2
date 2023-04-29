package ManagerDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ManagerVO.DashboardVO;
import ManagerVO.LoginHistoryVO;
import ManagerVO.MemberManageVO;
import ManagerVO.PastAllMVO;
import ManagerVO.PastJoinVO;
import ManagerVO.PastVisitVO;
import conn.DbConnection;

public class ManageDAO {

public DashboardVO selectDash()throws SQLException {
		
	DashboardVO dVO = null;
		DbConnection dbCon = DbConnection.getInstance();
		//1. JNDI 사용 객체 생성
		//2. DataSource 얻기
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//3. Connection 얻기
			con=dbCon.getConn();
			//4. 쿼리문 생성 객체 얻기
			StringBuilder  selectDash = new StringBuilder();
			selectDash
			.append(" SELECT ")
			.append(" (SELECT COUNT(*) FROM member) AS memberCnt, ")
			.append("  (SELECT COUNT(*) FROM NOVEL) AS novelCnt, ")
			.append("  (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER) ) ")
			.append(" WHERE JOIN = TRUNC(SYSDATE)) AS todaySignUpCnt, ")
			.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(visit,'yyyy-MM-DD') visit FROM history) ) ")
			.append(" WHERE visit = TRUNC(SYSDATE) ) AS todayVisitCnt, ")
			.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(make,'yyyy-MM-DD') make FROM novel) ) ")
			.append(" WHERE make = TRUNC(SYSDATE)) AS todayCreateNovelCnt, ")
			.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(make,'yyyy-MM-DD') make FROM episode) ) ")
			.append(" WHERE make = TRUNC(SYSDATE)) AS todayCreateEpCnt  ")
			.append(" FROM dual ");
			

			pstmt = con.prepareStatement(selectDash.toString());
			//5. 바인드 변수 값 설정
			
			//6. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) { //검색된 레코드가 존재하니?
				//VO를 생성하여 검색 결과를 할당
				dVO = new DashboardVO( rs.getInt("memberCnt"), rs.getInt("novelCnt"), rs.getInt("todaySignUpCnt"), 
						rs.getInt("todayVisitCnt"), rs.getInt("todayCreateNovelCnt"), rs.getInt("todayCreateEpCnt") );
			}//end while			
			
		}finally {
			//7. 연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return dVO;
	}//selectDash



public PastJoinVO selectsCnt() throws SQLException {
	
		PastJoinVO pVO = null;
		DbConnection dbCon = DbConnection.getInstance();
		//1. JNDI 사용 객체 생성
				//2. DataSource 얻기
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//3. Connection 얻기
			con=dbCon.getConn();
			//4. 쿼리문 생성 객체 얻기
			StringBuilder selectsCnt = new StringBuilder();
			selectsCnt
			.append(" select ")
			.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER)) WHERE JOIN = TRUNC(SYSDATE-4)) AS sCnt4, ")
			.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER)) WHERE JOIN = TRUNC(SYSDATE-3)) AS sCnt3, ")
			.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER)) WHERE JOIN = TRUNC(SYSDATE-2)) AS sCnt2, ")
			.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER)) WHERE JOIN = TRUNC(SYSDATE-1)) AS sCnt1, ")
			.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER)) WHERE JOIN = TRUNC(SYSDATE)) AS sCnt ")
			.append(" from dual ");
					/*
					 * .append(" select (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT ")
					 * .append("  to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER) ) WHERE JOIN = TRUNC(SYSDATE-4)) AS SCnt4,  "
					 * ) .append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT ")
					 * .append("  to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER) ) WHERE JOIN = TRUNC(SYSDATE-3)) AS SCnt3, "
					 * ) .append("  (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT ")
					 * .append(" to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER) ) WHERE JOIN = TRUNC(SYSDATE-2)) AS SCnt2, "
					 * ) .append("   (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT ")
					 * .append("  to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER) ) WHERE JOIN = TRUNC(SYSDATE-1)) AS SCnt1, "
					 * ) .append("  (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT ")
					 * .append("  to_char(JOIN,'yyyy-MM-DD') JOIN FROM MEMBER) ) WHERE JOIN = TRUNC(SYSDATE)) AS SCnt "
					 * ) .append("   from dual ");
					 */
			
			
		

			pstmt = con.prepareStatement(selectsCnt.toString());
			//5. 바인드 변수 값 설정
			
			//6. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
		
			
			
			if(rs.next()) { //검색된 레코드가 존재하니?
				//VO를 생성하여 검색 결과를 할당
				
				pVO = new PastJoinVO( rs.getInt("sCnt4"),  rs.getInt("sCnt3"),  rs.getInt("sCnt2"), rs.getInt("sCnt1"), rs.getInt("sCnt") );
			}//end while			
			
		}finally {
			//7. 연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return pVO;
	}//selectsCnt



public PastVisitVO selectvCnt() throws SQLException {
	
	PastVisitVO vVO = null;
	DbConnection dbCon = DbConnection.getInstance();
	//1. JNDI 사용 객체 생성
		//2. DataSource 얻기
	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		//3. Connection 얻기
		con=dbCon.getConn();
		//4. 쿼리문 생성 객체 얻기
		StringBuilder selectvCnt = new StringBuilder();
		selectvCnt
		.append(" select ")
		.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(visit,'yyyy-MM-DD') visit FROM history)) WHERE visit = TRUNC(SYSDATE-4)) AS vCnt4, ")
		.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(visit,'yyyy-MM-DD') visit FROM history)) WHERE visit = TRUNC(SYSDATE-3)) AS vCnt3, ")
		.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(visit,'yyyy-MM-DD') visit FROM history)) WHERE visit = TRUNC(SYSDATE-2)) AS vCnt2, ")
		.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(visit,'yyyy-MM-DD') visit FROM history)) WHERE visit = TRUNC(SYSDATE-1)) AS vCnt1, ")
		.append(" (SELECT COUNT(*) FROM ( SELECT * FROM (SELECT to_char(visit,'yyyy-MM-DD') visit FROM history)) WHERE visit = TRUNC(SYSDATE)) AS vCnt ")
		.append(" from dual ");
	
		pstmt = con.prepareStatement(selectvCnt.toString());
		//5. 바인드 변수 값 설정
		
		//6. 쿼리문 수행 후 결과 얻기
		rs=pstmt.executeQuery();
		
		if(rs.next()) { //검색된 레코드가 존재하니?
			//VO를 생성하여 검색 결과를 할당
			
			vVO = new PastVisitVO( rs.getInt("vCnt4"),  rs.getInt("vCnt3"),  rs.getInt("vCnt2"), rs.getInt("vCnt1"), rs.getInt("vCnt") );
		}//end while			
		
	}finally {
		//7. 연결 끊기
		dbCon.dbClose(rs, pstmt, con);
	}//end finally
	
	return vVO;
}//selectvCnt
	
	
public PastAllMVO selectAcnt() throws SQLException {
	
	PastAllMVO aVO = null;
	DbConnection dbCon = DbConnection.getInstance();
	//1. JNDI 사용 객체 생성
		//2. DataSource 얻기
	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		//3. Connection 얻기
		con=dbCon.getConn();
		//4. 쿼리문 생성 객체 얻기
		StringBuilder selectaCnt = new StringBuilder();
		selectaCnt
		.append(" select ")
		.append(" (SELECT COUNT(*) FROM novel where make<(sysdate-4)) as allMCNT4, ")
		.append(" (SELECT COUNT(*) FROM novel where make<(sysdate-3)) as allMCNT3, ")
		.append(" (SELECT COUNT(*) FROM novel where make<(sysdate-2)) as allMCNT2, ")
		.append(" (SELECT COUNT(*) FROM novel where make<(sysdate-1)) as allMCNT1, ")
		.append(" (SELECT COUNT(*) FROM novel where make<(sysdate)) as allMCNT ")
		.append(" from dual ");

		
		pstmt = con.prepareStatement(selectaCnt.toString());
		//5. 바인드 변수 값 설정
		
		//6. 쿼리문 수행 후 결과 얻기
		rs=pstmt.executeQuery();
		
		if(rs.next()) { //검색된 레코드가 존재하니?
			//VO를 생성하여 검색 결과를 할당
			
			aVO = new PastAllMVO( rs.getInt("allMCNT4"),  rs.getInt("allMCNT3"),  rs.getInt("allMCNT2"), rs.getInt("allMCNT1"), rs.getInt("allMCNT") );
		}//end while			
		
	}finally {
		//7. 연결 끊기
		dbCon.dbClose(rs, pstmt, con);
	}//end finally
	
	return aVO;
}//selectAcnt	
	 
	
	  
public List<LoginHistoryVO> selectHistory() throws SQLException {
	Connection con = null;
	PreparedStatement pstmt = null;
	List<LoginHistoryVO> lhList = new ArrayList<LoginHistoryVO>();
	ResultSet rs = null;
	
	DbConnection dbCon = DbConnection.getInstance();
	
	try {
		
	con=dbCon.getConn();
	

	
	StringBuilder selectHistory = new StringBuilder();
	selectHistory
	.append(" select id, os, ip, visit ")
	.append(" from HISTORY h, member m ")
	.append(" where h.num_member = m.num_member ");
	
	
	pstmt=con.prepareStatement(selectHistory.toString());
	rs = pstmt.executeQuery();
	

	LoginHistoryVO lhVO = null;
	while(rs.next()) {// 레코드가 존재하는지 알 수 없지만 존재한 다면 모든 레코드를 가져와야 한다.
		//커서 다음에 레코드가 존재하면 TRUE를 반환하여 커서의 위치를 아래로 이동
		/*
		 * id=rs.getString("id"); pass=rs.getString("pass"); name=rs.getString("name");
		 * date=rs.getDate("input_date");
		 */
		
		
		lhVO = new LoginHistoryVO( rs.getString("id"),rs.getString("os"),rs.getString("ip"),rs.getDate("visit") );
		lhList.add(lhVO);
		
	}//end while

	}finally {
		dbCon.dbClose(rs, pstmt, con);
	}//end finally
		
	
	return lhList;
}//selectHistory	 
	 
	  
public List<MemberManageVO> selectMemberManage() throws SQLException {
	Connection con = null;
	PreparedStatement pstmt = null;
	List<MemberManageVO> mmList = new ArrayList<MemberManageVO>();
	ResultSet rs = null;
	
	DbConnection dbCon = DbConnection.getInstance();
	
	try {
		
	con=dbCon.getConn();
	

	//sysdate-373752
	StringBuilder selectMemberManage = new StringBuilder();
	selectMemberManage	
	.append(" SELECT m.id, m.num_member, ") //, m.num_member, m.num_member
	.append(" (SELECT COUNT(*) FROM novel where num_member=m.num_member) AS novelcnt, ")
	.append(" NVL((SELECT MAX(h.visit) FROM history h WHERE m.num_member = h.num_member),m.join) AS visit, ")
	.append(" m.join, NVL(m.stop, sysdate-1) AS stop FROM member m CROSS JOIN dual "); 
	
	
	pstmt=con.prepareStatement(selectMemberManage.toString());
	rs = pstmt.executeQuery();
	
		

	MemberManageVO mmVO = null;
	
	

	while(rs.next()) { // 레코드가 존재하는지 알 수 없지만 존재한 다면 모든 레코드를 가져와야 한다.
		//커서 다음에 레코드가 존재하면 TRUE를 반환하여 커서의 위치를 아래로 이동
		/*
		 * id=rs.getString("id"); pass=rs.getString("pass"); name=rs.getString("name");
		 * date=rs.getDate("input_date");
		 */
		
		mmVO = new MemberManageVO( rs.getString("id"), rs.getInt("num_member"), rs.getInt("novelcnt"), 
				rs.getDate("visit"), rs.getDate("join"), rs.getDate("stop") );
		mmList.add(mmVO);
		
	}//end while

	}finally {
		dbCon.dbClose(rs, pstmt, con);
	}//end finally
		
	
	return mmList;
}//selectHistory	 



}

