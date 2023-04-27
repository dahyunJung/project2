package EpisodeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EpisodeVO.LikeVO;
import EpisodeVO.ListEpisodeVO;
import EpisodeVO.LookNovelVO;
import EpisodeVO.ReportVO;
import conn.DbConnection;


public class EpisodeDAO {
	
	// 읽기 리스트 소설부분만 보여주기
	public LookNovelVO selectNovel(int novelNum) throws SQLException {
		LookNovelVO lnVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();
			
			StringBuilder selectEp = new StringBuilder();
			selectEp.append(" select n.title title, m.id id, n.story story, n.photo photo  ")
					.append(" from novel n, member m ")
					.append(" where n.num_member = m.num_member and n.num_novel = ? ");
				
			pstmt = con.prepareStatement(selectEp.toString());
			
			pstmt.setInt(1, novelNum);
				
			rs = pstmt.executeQuery();
				
			while(rs.next()) {
				lnVO = new LookNovelVO();
				lnVO.setNovelTitle(rs.getString("title"));
				lnVO.setId(rs.getString("id"));
				lnVO.setIntro(rs.getString("story"));
				lnVO.setThumbnail(rs.getString("photo"));
			}
			System.out.println("select novelNum" + novelNum);

		} finally {
			dbConnection.dbClose(null, pstmt, con);
		}
		
		return lnVO;
	}// selectNovel
	
	public int countEp(int novelNum) throws SQLException{
		int cnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();
		ResultSet rs = null;

		try {
			con = dbConnection.getConn();

			String countEp = " select count(*) from episode where num_novel=? ";

			pstmt = con.prepareStatement(countEp);

			pstmt.setInt(1, novelNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);			
			}

			System.out.print(countEp);
			System.out.println(novelNum + ", " + cnt + " 회차 개수");
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return cnt;
	}//countEp
	
	
	// 에피소드 회차 리스트
	public List<ListEpisodeVO> selectAllEp(int novelNum) throws SQLException{
		List<ListEpisodeVO> list = new ArrayList<ListEpisodeVO>();
		
		DbConnection dbConnection = DbConnection.getInstance();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dbConnection.getConn();
			StringBuilder selectallEp = new StringBuilder();
			selectallEp.append("	select num_novel, num_episode ,title, visit, make	")
			 			.append("	from episode ")
			 			.append("	where num_novel=? and open=1	");
			
			pstmt = con.prepareStatement(selectallEp.toString());

			pstmt.setInt(1, novelNum);
			
			rs = pstmt.executeQuery();
			
			ListEpisodeVO leVO = null;
			
			while(rs.next()) {
				leVO = new ListEpisodeVO();
				leVO.setNovelNum(novelNum);
				leVO.setEpNum(rs.getInt("num_episode"));
				leVO.setEpTitle(rs.getString("title"));
				leVO.setViewCnt(rs.getInt("visit"));
				leVO.setCreateDate(rs.getDate("make"));

				list.add(leVO);
			}			
		}finally {
			dbConnection.dbClose(rs, pstmt, con);
		}
		
		return list;
	} //selectAllEp
	
	
	// 좋아요 추가
	public int insertLike(LikeVO likeVO) throws SQLException {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();
		
		System.out.println("insert 좋아요 "+likeVO.getId()+", "+likeVO.getNovelNum() + ", " + likeVO.getUserNum());
		
		try {
			con = dbConnection.getConn();

			StringBuilder insertLike = new StringBuilder();
			
//			String selectMember = "select num_member from member where id=?";

			// epNum 자동증가, 에피소드 등록시 무조건 공개로 시작, 뷰수는 0,
			insertLike.append(" insert into liken(num_like,id,num_novel,num_member) ")
					  .append("	select num_like.nextval,?,?,? FROM DUAL	")
					  .append(" where NOT EXISTS (SELECT 0 FROM liken where num_member=? and num_novel=? ) ");
			
			pstmt = con.prepareStatement(insertLike.toString());

			// 5. 바인드 변수값 설정
			pstmt.setString(1, likeVO.getId());
			pstmt.setInt(2, likeVO.getNovelNum());
			pstmt.setInt(3, likeVO.getUserNum());
			pstmt.setInt(4, likeVO.getUserNum());
			pstmt.setInt(5, likeVO.getNovelNum());
			
			System.out.print("좋아요 추가");

			// 6. 쿼리문 수행 수 결과 얻기
			cnt = pstmt.executeUpdate();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return cnt;
	}
	
	// 좋아요 취소(삭제)
	public int deleteLike(int userNum, int novelNum) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			StringBuilder deleteEpisode = new StringBuilder();

			deleteEpisode.append(" delete from liken ")
						 .append(" where num_member=? and num_novel=? ");

			pstmt = con.prepareStatement(deleteEpisode.toString());

			// 5. 바인드 변수값 설정
			pstmt.setInt(1, userNum);
			pstmt.setInt(2, novelNum);

			System.out.println(deleteEpisode);
			System.out.println(userNum + ", " + novelNum);
			System.out.print("좋아요 삭제");

			// 6. 쿼리문 수행 수 결과 얻기
			cnt = pstmt.executeUpdate();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally

		return cnt;
	}//deleteLike
	
	// 좋아요되어 있으면 좋아요 화면에 표시
	public int confirmLike(int userNum, int novelNum) throws SQLException{
		int cnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();
		ResultSet rs = null;

		try {
			con = dbConnection.getConn();

			String selectLike = " select count(*) from liken where num_member=? and num_novel=? ";

			pstmt = con.prepareStatement(selectLike);

			pstmt.setInt(1, userNum);
			pstmt.setInt(2, novelNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);			
			}

			System.out.print(selectLike);
			System.out.println(", " + userNum + ", " + novelNum + ", " + cnt + " 좋아요 확인");
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return cnt;
	}
	
	
	// 신고 추가
	public void insertReport(ReportVO reportVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			StringBuilder insertReport = new StringBuilder();
			
			insertReport.append(" insert into report(num_report, num_member, num_novel, id, reason_code, report_date) ")
					  .append(" values (num_like.nextval,?,?,?,?,sysdate) ");

			pstmt = con.prepareStatement(insertReport.toString());

			pstmt.setInt(1, reportVO.getUserNum());
			pstmt.setInt(2, reportVO.getNovelNum());
			pstmt.setString(3, reportVO.getId());
			pstmt.setInt(4, reportVO.getReportCode());
			
			pstmt.executeQuery();
		} finally {
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
	}
		
	
//	public LookNovelVO selectFirstEp(int novelNum) {
//		
//	}
	
	
//	public LookNovelVO selectEp(int novelNum, int epNum) {
//		
//	}
//	
//	
//	public int likes(String id, int novelNum) {
//		
//	}
//	
//	
//	public int report(int novelNum) {
//		
//	}
	
	

}
