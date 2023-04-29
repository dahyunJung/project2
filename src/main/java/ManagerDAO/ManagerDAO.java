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
			StringBuilder selectMemberInfo = new StringBuilder();//필요없는 값이 있긴함 report_cnt빼도 됨
			selectMemberInfo.append("	SELECT m.id, m.name, m.birth, m.phone, m.email, m.photo, m.join, m.stop, ")
					.append("	NVL((SELECT COUNT(*) FROM report where num_member=m.num_member),0) AS report_cnt, ")
					.append("	 nvl((SELECT COUNT(*) FROM novel where num_member=m.num_member),0) AS novelcnt, ")
					.append("	NVL((SELECT MAX(h.visit) FROM history h WHERE m.num_member = h.num_member),m.join) AS visitdate ")
					.append("	FROM member m CROSS JOIN dual where m.id=? ");

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
				mVO.setNovelCnt(rs.getInt("novelcnt"));
				mVO.setReportCnt(rs.getInt("report_cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		return mVO;
	}// selectMemberInfoAll

	// 강제 중지 60일
	public int forcedStop60(String id) throws SQLException {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {

			con = dbCon.getConn();
			StringBuilder updateQuery = new StringBuilder();
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
	}// forcedStop61

	// 강제 중지
	public int forcedStop(String id) throws SQLException {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {

			con = dbCon.getConn();
			StringBuilder updateQuery = new StringBuilder();
			updateQuery.append(" update member set stop");
			updateQuery.append("=sysdate+60 ");
			updateQuery.append(" where id = ? ");

			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		}
		return result;
	}// forcedStop60

	// 강제 중지 해체 //값 바꿔야함 -60이 아니라 강제중지 해제이면
	public int forcedStopClear(String id) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
			con = dbCon.getConn();
			StringBuilder updateQuery = new StringBuilder();
			updateQuery.append(" update member set stop").append("=sysdate-1 ").append(" where id = ? ");

			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		}
		return result;
	}// forcedStopClear

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
			selectAll.append("	SELECT DISTINCT n.num_novel, n.title, ")
						.append("	 (SELECT COUNT(*) FROM liken WHERE num_novel = n.num_novel) AS likes ,n.make, m.id,	")
						.append("	 (SELECT MAX(report_date) FROM report WHERE num_novel = n.num_novel) AS report_date,	")
						.append("	(SELECT COUNT(*) FROM report WHERE num_novel = n.num_novel) AS num_report	")
						.append("	FROM novel n	")
						.append("	LEFT JOIN member m ON n.num_member = m.num_member	");
			
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
	public void deleteNovel(int novelNum) throws SQLException {
		if (novelNum <= 0) {
			return;
		}//end if
	    DbConnection dbCon = DbConnection.getInstance();
	    Connection con = null;
	    PreparedStatement stmt = null;
	    try {
	        con = dbCon.getConn();
	        
	        String deleteQuery= "	delete from novel where num_novel = ?	";
	        stmt = con.prepareStatement(deleteQuery);
	        stmt.setInt(1, novelNum);
	        stmt.executeUpdate(); 
	    } finally {
	        dbCon.dbClose(null, stmt, con);
	    }//end finally
	}//deleteNovel

	
	//신고된 소설 공개로 변환
	public void publicNovel(int novelNum) throws SQLException {//NOVEL OPEN(0 : 비공개, 1 : 공개) 
	    DbConnection dbCon = DbConnection.getInstance();
	    Connection con = null;
	    PreparedStatement stmt = null;
	    try {
	        con = dbCon.getConn();
	        
	        String updatePublicQuery = "	update novel set open = case when num_novel = ? then 1 else 0 end where num_novel = ?	";
	        stmt = con.prepareStatement(updatePublicQuery);
	        stmt.setInt(1, novelNum);
	        stmt.setInt(2, novelNum);
	        int rowsUpdated = stmt.executeUpdate(); 
	        if (rowsUpdated == 0) {
	            throw new SQLException("다시 시도해주세요. " + novelNum);
	        }
	    } finally {
	        dbCon.dbClose(null, stmt, con);
	    }//end finally
	}//publicNovel

	
	//신고된 소설 비공개로 변환
	public void privateNovel(int novelNum) throws SQLException{
	    DbConnection dbCon = DbConnection.getInstance();
	    Connection con = null;
	    PreparedStatement stmt = null;
	    try {
	        con = dbCon.getConn();
	        
	        String updatePrivateQuery = "	update novel set open = case when num_novel = ? then 0 else 1 end where num_novel = ?	";
	        stmt = con.prepareStatement(updatePrivateQuery);
	        stmt.setInt(1, novelNum);
	        stmt.setInt(2, novelNum);
	        int rowsUpdated = stmt.executeUpdate(); 
	        if (rowsUpdated == 0) {
	            throw new SQLException("다시 시도해주세요. " + novelNum);
	        }
	    } finally {
	        dbCon.dbClose(null, stmt, con);
	    }//end finally
	}//privateNovel
	
	
	// 소설 신고 정보
	public MNovelLookVO selectReportInfo(String title) throws SQLException {
		MNovelLookVO nVO = new MNovelLookVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
			con = dbCon.getConn();
			StringBuilder selectReportInfo = new StringBuilder();
			selectReportInfo
			.append("	select n.title, n.photo, n.story, n.age, m.id, ")
			.append("	(select reason_code from report where num_novel = n.num_novel group by reason_code order by count(*) desc fetch first 1 row only) as reason_code, ")
			.append("	(select count(*) from report where num_novel = n.num_novel) as reportcnt, ")
			.append("	n.num_novel ")
			.append("	from novel n ")
			.append("	join member m on n.num_member = m.num_member ")
			.append("	left join report r on n.num_novel = r.num_novel ")
			.append("	where n.title = ? ")
			.append("	group by n.title, n.photo, n.story, n.age, m.id, n.num_novel	");

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
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		return nVO;
	}//selectReportInfo

}// class
