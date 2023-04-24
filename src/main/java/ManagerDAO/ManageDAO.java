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
		//1. JNDI 占쏙옙占� 占쏙옙체 占쏙옙占쏙옙
		//2. DataSource 占쏙옙占�
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//3. Connection 占쏙옙占�
			con=dbCon.getConn();
		//4. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙체 占쏙옙占�
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
			//5. 占쏙옙占싸듸옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
			
		//6. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쏙옙占�
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) { //占싯삼옙占쏙옙 占쏙옙占쌘드가 占쏙옙占쏙옙占싹댐옙?
				//VO占쏙옙 占쏙옙占쏙옙占싹울옙 占싯삼옙 占쏙옙占쏙옙占� 占쌀댐옙
				dVO = new DashboardVO( rs.getInt("memberCnt"), rs.getInt("novelCnt"), rs.getInt("todaySignUpCnt"), 
						rs.getInt("todayVisitCnt"), rs.getInt("todayCreateNovelCnt"), rs.getInt("todayCreateEpCnt") );
			}//end while			
			
		}finally {
			//7. 占쏙옙占쏙옙 占쏙옙占쏙옙
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return dVO;
	}//selectDash



public PastJoinVO selectsCnt() throws SQLException {
	
		PastJoinVO pVO = null;
		DbConnection dbCon = DbConnection.getInstance();
		//1. JNDI 占쏙옙占� 占쏙옙체 占쏙옙占쏙옙
		//2. DataSource 占쏙옙占�
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//3. Connection 占쏙옙占�
			con=dbCon.getConn();
		//4. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙체 占쏙옙占�
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
			//5. 占쏙옙占싸듸옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
			
		//6. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쏙옙占�
			rs=pstmt.executeQuery();
			
		
			
			
			if(rs.next()) { //占싯삼옙占쏙옙 占쏙옙占쌘드가 占쏙옙占쏙옙占싹댐옙?
				//VO占쏙옙 占쏙옙占쏙옙占싹울옙 占싯삼옙 占쏙옙占쏙옙占� 占쌀댐옙
				
				pVO = new PastJoinVO( rs.getInt("sCnt4"),  rs.getInt("sCnt3"),  rs.getInt("sCnt2"), rs.getInt("sCnt1"), rs.getInt("sCnt") );
			}//end while			
			
		}finally {
			//7. 占쏙옙占쏙옙 占쏙옙占쏙옙
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return pVO;
	}//selectsCnt



public PastVisitVO selectvCnt() throws SQLException {
	
	PastVisitVO vVO = null;
	DbConnection dbCon = DbConnection.getInstance();
	//1. JNDI 占쏙옙占� 占쏙옙체 占쏙옙占쏙옙
	//2. DataSource 占쏙옙占�
	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
	//3. Connection 占쏙옙占�
		con=dbCon.getConn();
	//4. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙체 占쏙옙占�
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
		//5. 占쏙옙占싸듸옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
		
	//6. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쏙옙占�
		rs=pstmt.executeQuery();
		
		if(rs.next()) { //占싯삼옙占쏙옙 占쏙옙占쌘드가 占쏙옙占쏙옙占싹댐옙?
			//VO占쏙옙 占쏙옙占쏙옙占싹울옙 占싯삼옙 占쏙옙占쏙옙占� 占쌀댐옙
			
			vVO = new PastVisitVO( rs.getInt("vCnt4"),  rs.getInt("vCnt3"),  rs.getInt("vCnt2"), rs.getInt("vCnt1"), rs.getInt("vCnt") );
		}//end while			
		
	}finally {
		//7. 占쏙옙占쏙옙 占쏙옙占쏙옙
		dbCon.dbClose(rs, pstmt, con);
	}//end finally
	
	return vVO;
}//selectvCnt
	
	
public PastAllMVO selectAcnt() throws SQLException {
	
	PastAllMVO aVO = null;
	DbConnection dbCon = DbConnection.getInstance();
	//1. JNDI 占쏙옙占� 占쏙옙체 占쏙옙占쏙옙
	//2. DataSource 占쏙옙占�
	Connection con  = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
	//3. Connection 占쏙옙占�
		con=dbCon.getConn();
	//4. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙체 占쏙옙占�
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
		//5. 占쏙옙占싸듸옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
		
	//6. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쏙옙占�
		rs=pstmt.executeQuery();
		
		if(rs.next()) { //占싯삼옙占쏙옙 占쏙옙占쌘드가 占쏙옙占쏙옙占싹댐옙?
			//VO占쏙옙 占쏙옙占쏙옙占싹울옙 占싯삼옙 占쏙옙占쏙옙占� 占쌀댐옙
			
			aVO = new PastAllMVO( rs.getInt("allMCNT4"),  rs.getInt("allMCNT3"),  rs.getInt("allMCNT2"), rs.getInt("allMCNT1"), rs.getInt("allMCNT") );
		}//end while			
		
	}finally {
		//7. 占쏙옙占쏙옙 占쏙옙占쏙옙
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
	while(rs.next()) { // 占쏙옙占쌘드가 占쏙옙占쏙옙占싹댐옙占쏙옙 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌕몌옙 占쏙옙占� 占쏙옙占쌘드를 占쏙옙占쏙옙占싶억옙 占싼댐옙.
		//커占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쌘드가 占쏙옙占쏙옙占싹몌옙 TRUE占쏙옙 占쏙옙환占싹울옙 커占쏙옙占쏙옙 占쏙옙치占쏙옙 占싣뤄옙占쏙옙 占싱듸옙
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
	 
	  
////占싹ㅓ댐옙 占쏙옙/.//////////////////////////////////
public List<MemberManageVO> selectMemberManage() throws SQLException {
	Connection con = null;
	PreparedStatement pstmt = null;
	List<MemberManageVO> mmList = new ArrayList<MemberManageVO>();
	ResultSet rs = null;
	
	DbConnection dbCon = DbConnection.getInstance();
	
	try {
		
	con=dbCon.getConn();
	

	
	StringBuilder selectMemberManage = new StringBuilder();
	selectMemberManage
	.append(" SELECT m.num_member, m.id, m.join, nvl(m.stop, sysdate-373752) stop, nvl(h.visit, sysdate-373752) visit, nvl(m.novelcnt, 0) novelcnt, nvl(n.reportcnt, 0) reportcnt ") //, m.num_member, m.num_member
	.append(" FROM member m ")
	.append(" left Outer JOIN novel n ON m.num_member = n.num_member ")
	.append(" left Outer JOIN report r ON n.num_member = r.num_member ")
	.append(" left Outer JOIN history h ON r.num_member = h.num_member ")
	.append(" order by m.num_member ");
	
	
	pstmt=con.prepareStatement(selectMemberManage.toString());
	rs = pstmt.executeQuery();
	

	MemberManageVO mmVO = null;
	while(rs.next()) { // 占쏙옙占쌘드가 占쏙옙占쏙옙占싹댐옙占쏙옙 占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌕몌옙 占쏙옙占� 占쏙옙占쌘드를 占쏙옙占쏙옙占싶억옙 占싼댐옙.
		//커占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쌘드가 占쏙옙占쏙옙占싹몌옙 TRUE占쏙옙 占쏙옙환占싹울옙 커占쏙옙占쏙옙 占쏙옙치占쏙옙 占싣뤄옙占쏙옙 占싱듸옙
		/*
		 * id=rs.getString("id"); pass=rs.getString("pass"); name=rs.getString("name");
		 * date=rs.getDate("input_date");
		 */
		
		//int novelCnt, int reportCnt占쏙옙 占쌍억옙占쏙옙求쨉占� 占쏙옙占쏙옙 db占쏙옙 占쌍억옙占쏙옙 占쏙옙占쏙옙 占십아쇽옙 占쌈시울옙占쏙옙占쏙옙 占쏙옙占� 占쌍억옙占� 占쏙옙占쏙옙 select占쏙옙占쏙옙 占쌕뀐옙占쏙옙占�
		mmVO = new MemberManageVO( rs.getString("id"), rs.getInt("num_member"), rs.getInt("novelcnt"), rs.getInt("reportcnt"),
				rs.getDate("visit"), rs.getDate("join"), rs.getDate("stop") );
		mmList.add(mmVO);
		
	}//end while

	}finally {
		dbCon.dbClose(rs, pstmt, con);
	}//end finally
		
	
	return mmList;
}//selectHistory	 



}

