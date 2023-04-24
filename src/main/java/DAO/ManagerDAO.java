package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import VO.MNovelLookVO;
import VO.MNovelVO;
import VO.MemberManageInfoVO;
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
			selectMemberInfo.append(" SELECT m.id, m.name, m.birth, m.phone, m.email, m.photo, m.join, m.stop, ")
					.append(" COUNT(n.num_novel) AS novel_cnt, COUNT(r.num_report) AS report_cnt, ")
					.append("  h.visit AS visitDate ").append(" FROM member m ")
					.append(" LEFT JOIN novel n ON n.num_member = m.num_member ")
					.append(" LEFT JOIN report r ON r.id = m.id ")
					.append(" LEFT JOIN history h ON h.num_member = m.num_member ").append(" WHERE m.id = ? ")
					.append(" GROUP BY m.id, m.name, m.birth, m.phone, m.email, m.photo, m.join, m.stop, h.visit ");

			pstmt = con.prepareStatement(selectMemberInfo.toString());

			// pstmt.setString(1, id);
			pstmt.setString(1, "haerin4");// 임시 아이디 지정
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

	public void forceStopMember(String id) throws SQLException {
		try {
			LocalDate currentDate = LocalDate.now();

			String query = " UPDATE member SET stop = ? WHERE id = ? ";

			Connection con = null;
			PreparedStatement pstmt = con.prepareStatement(query);
			DbConnection dbCon = DbConnection.getInstance();

			pstmt.setDate(1, java.sql.Date.valueOf(currentDate));
			pstmt.setString(2, id);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			System.out.println("Member with id " + id + " has been forcefully stopped.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 강제 중지
	public int forcedStop(String id) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
			con = dbCon.getConn();
			StringBuilder updateQuery = new StringBuilder();
			updateQuery.append(" UPDATE member SET stop = ? WHERE id = ? ");

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

//	// 강제 중지 해제
//	public int cancelStop(String id) {
//
//		return 0;
//	}// cancelStop

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
			selectAll.append("	select n.num_novel, n.title, n.likes, n.make, r.id, r.report_date, ")
					.append(" (select count(*) from report where num_novel = n.num_novel) as num_report	")
					.append("	from novel n		").append("	inner join report r on n.num_novel = r.num_novel	");

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

	// 소설 삭제,비공개
//	public List<MNovelLookVO> selectNovelLook(int ){//매개변수로 int소설번호 넣어야 되는데 VO에 없?
//		
//	}
//	
//	public int deleteNovel(int ){
//		
//	}//deleteNovel
//	
//	public int updateNovel(int ){
//		
//	}//updateNovel

	// 소설 신고 보기
	public MNovelLookVO selectReportInfo(String novel_title) throws SQLException {
		MNovelLookVO nVO = new MNovelLookVO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbConnection dbCon = DbConnection.getInstance();
		try {
			con = dbCon.getConn();
			StringBuilder selectReportInfo = new StringBuilder();
			selectReportInfo
					.append(" select novel_title, id, thumbnail, intro, age_able, report_reason, report_cnt ")
					.append(" from novel ")
					.append(" where novel_title = ? ");

			pstmt = con.prepareStatement(selectReportInfo.toString());
			pstmt.setString(1, "가나다라마바사");// 임시
			//pstmt.setString(1, novel_title);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				nVO.setNovelTitle(rs.getString("novel_title"));
				nVO.setId(rs.getString("id"));
				nVO.setThumbnail(rs.getString("thumbnail"));
				nVO.setIntro(rs.getString("intro"));
				nVO.setAgeAble(rs.getInt("age_able"));
				nVO.setReportReason(rs.getInt("report_reason"));
				nVO.setReportCnt(rs.getInt("report_cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		return nVO;
	}

//??????????????????
//	public int selectEpisode(int , int){
//	  
//	}//selectEpisode

}// class
