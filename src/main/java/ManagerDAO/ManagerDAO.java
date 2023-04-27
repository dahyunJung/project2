package ManagerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ManagerVO.MNovelLookVO;
import ManagerVO.MNovelVO;
import ManagerVO.MemberManageInfoVO;
import conn.DbConnection;

public class ManagerDAO {

	// 회원 정보 보기
	public MemberManageInfoVO selectMemberInfoAll(String id) throws SQLException {
		MemberManageInfoVO mVO = new MemberManageInfoVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
			con = dbCon.getConn();
			StringBuilder selectMemberInfo = new StringBuilder();
			selectMemberInfo
				.append("	select m.id, m.name, m.birth, m.phone, m.email, m.photo, m.join, m.stop, ")
				.append("	count(n.num_novel) as novel_cnt, count(r.num_report) as report_cnt, ")
				.append("	h.visit as visitdate ").append("	from member m ")
				.append("	left join novel n on n.num_member = m.num_member ")
				.append("	left join report r on r.id = m.id ")
				.append("	left join history h on h.num_member = m.num_member ")
				.append("	where m.id = ? ") 
				.append("	group by m.id, m.name, m.birth, m.phone, m.email, m.photo, m.join, m.stop, h.visit ");

			pstmt = con.prepareStatement(selectMemberInfo.toString());
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mVO.setThumbnail(rs.getString("photo"));
				mVO.setId(rs.getString("id"));
				mVO.setName(rs.getString("name"));
				mVO.setEmail(rs.getString("email"));
				mVO.setPhone(rs.getString("phone"));
				mVO.setBirthDate(rs.getDate("birth"));
				mVO.setVisitDate(rs.getDate("visitDate"));
				mVO.setJoinDate(rs.getDate("join"));
				mVO.setSusPeriod(rs.getDate("stop"));
				mVO.setNovelCnt(rs.getInt("novel_cnt"));
				mVO.setReportCnt(rs.getInt("report_cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		return mVO;
	}// selectMemberInfoAll

	// 강제 중지 61일
	public int forcedStop61(String id) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
	
			con = dbCon.getConn();
			StringBuilder updateQuery = new StringBuilder();
			//updateQuery.append(" update member set stop = ? where id = ? ");
			updateQuery.append(" update member set stop");
			updateQuery.append("=(select stop from member where id=? )+61 ");
			updateQuery.append(" where id = ? ");
			
			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();


			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		}
		return result;
	}// forcedStop
	
	//강제 중지 60일
	public int forcedStop60(String id) throws SQLException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
	
			con = dbCon.getConn();
			StringBuilder updateQuery = new StringBuilder();
			//updateQuery.append(" update member set stop = ? where id = ? ");
			updateQuery.append(" update member set stop");
			updateQuery.append("=(select stop from member where id=? )+60 ");
			updateQuery.append(" where id = ? ");
			
			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();


			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		}
		return result;
	}// forcedStop
	
	
	
	
	// 강제 중지 해체 //값 바꿔야함 -60이 아니라 강제중지 해제이면
	public int forcedStopClear(String id) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
			con = dbCon.getConn();
			StringBuilder updateQuery = new StringBuilder();
			//updateQuery.append(" update member set stop = ? where id = ? ");
			updateQuery.append(" update member set stop")
			.append("=sysdate-1 ")
			.append(" where id = ? ");
	
				
					

			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		}
		return result;
	}// forcedStop



	// 소설 관리
	public List<MNovelVO> selectNovelManageAll() throws SQLException {
		List<MNovelVO> list = new ArrayList<MNovelVO>();

		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dbCon.getConn();

			StringBuilder selectAll = new StringBuilder();
//			selectAll.append("	select n.num_novel, n.title, n.likes, n.make, r.id, r.report_date, ")
//			.append(" (select count(*) from report where num_novel = n.num_novel) as num_report	")
//			.append("	from novel n		")
//			.append("	inner join report r on n.num_novel = r.num_novel	");
			selectAll.append("	select distinct n.num_novel, n.title, n.likes, n.make, max(r.id) as id, max(r.report_date) as report_date, ")
					.append(" (select count(*) from report where num_novel = n.num_novel) as num_report	")
					.append("	from novel n		")
					.append("	left join report r on n.num_novel = r.num_novel	")
					.append("	group by n.num_novel, n.title, n.likes, n.make	");
		
			pstmt = con.prepareStatement(selectAll.toString());
			rs = pstmt.executeQuery();

			MNovelVO mNovelVO = null;
			while (rs.next()) {
				mNovelVO = new MNovelVO(rs.getString("title"), rs.getString("id"), rs.getInt("num_novel"),
						rs.getInt("likes"), rs.getInt("num_report"), rs.getDate("make"));
				list.add(mNovelVO);
			} // end while
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		} // end finally
		return list;
	}// selectNovelManageAll

	// 신고된 소설 삭제
	public void deleteNovel(int novelNum) throws SQLException {// 반환형 int?
		DbConnection dbCon = DbConnection.getInstance();
	    Connection con = null;
	    PreparedStatement stmt = null;
	    try {
	    	con = dbCon.getConn();
	        String deleteQuery= "	delete from novel where num_novel = ?	";
	        stmt = con.prepareStatement(deleteQuery);
	        stmt.setInt(1, novelNum); // 첫 번째 파라미터에 novelNum 값을 전달
	        stmt.executeUpdate(); 
	    } finally {
	        dbCon.dbClose(null, stmt, con);
	    }
	}//deleteNovel
	
//	public int deleteInjection( String name )throws SQLException {
//		int dcnt = 0;
//		 Connection con = null;
//		 PreparedStatement pstmt = null;
//		
//		 DbConnection dbCon = DbConnection.getInstance();
//		 try {
//			 con=dbCon.getConn();
//			 String deleteInjection = "delete from test_injection where name=? ";
//			 
//			 pstmt=con.prepareStatement(deleteInjection);
//			 pstmt.setString(1, name);
//			 dcnt=pstmt.executeUpdate();
//			
//		 }finally {
//			 dbCon.dbClose(null, pstmt, con);
//		 }//end finally
//		 return dcnt;
//}//deleteInjection

//	public int updateNovel(int ){
//		
//	}//updateNovel

	// 소설 신고 정보
	public MNovelLookVO selectReportInfo(String title) throws SQLException {//title novelNum으로 바꿔?
		MNovelLookVO nVO = new MNovelLookVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
			con = dbCon.getConn();
			StringBuilder selectReportInfo = new StringBuilder();
			selectReportInfo
					.append(" select distinct n.title , n.photo , n.story , n.age , count(r.num_report) as reportcnt, m.id , r.reason_code, n.num_novel ")
					.append(" from novel n ")
					.append(" join member m on n.num_member = m.num_member ")
					.append(" left join report r on n.num_novel = r.num_novel ")
					.append(" where n.title = ? ")
					.append(" group by n.title, n.photo, n.story, n.age, m.id, r.reason_code, n.num_novel  ");
			
			pstmt = con.prepareStatement(selectReportInfo.toString());
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				nVO.setNovelTitle(rs.getString("title"));
				nVO.setId(rs.getString("id"));
				nVO.setThumbnail(rs.getString("photo"));
				nVO.setIntro(rs.getString("story"));
				nVO.setAgeAble(rs.getInt("age"));
				nVO.setReportReason(rs.getInt("reason_code"));
				nVO.setReportCnt(rs.getInt("reportcnt"));
				nVO.setNovelNum(rs.getInt("num_novel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		return nVO;
	}//selectReportInfo

}// class
