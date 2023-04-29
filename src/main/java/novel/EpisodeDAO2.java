package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EpisodeVO.ListEpisodeVO;
import EpisodeVO.User.LikeVO;
import EpisodeVO.User.LookEpisodeVO;
import EpisodeVO.User.LookNovelVO;
import EpisodeVO.User.PrevNextVO;
import EpisodeVO.User.ReportVO;
import conn.DbConnection;

public class EpisodeDAO2 {

	// 읽기 리스트 소설 윗부분만 보여주기
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

			while (rs.next()) {
				lnVO = new LookNovelVO();
				lnVO.setNovelTitle(rs.getString("title"));
				lnVO.setId(rs.getString("id"));
				lnVO.setIntro(rs.getString("story"));
				lnVO.setThumbnail(rs.getString("photo"));
			}
			
			System.out.println("읽기 리스트 소설 윗부분만 보여주기");
		} finally {
			dbConnection.dbClose(null, pstmt, con);
		}

		return lnVO;
	}// selectNovel

	
	// 에피소드 회차 리스트 보여주기
	public List<ListEpisodeVO2> selectAllEp(int novelNum) throws SQLException {
		List<ListEpisodeVO2> list = new ArrayList<ListEpisodeVO2>();
		ListEpisodeVO2 leVO = null;

		DbConnection dbConnection = DbConnection.getInstance();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dbConnection.getConn();
			StringBuilder selectallEp = new StringBuilder();
			selectallEp.append("	select num_novel, num_episode ,title, visit, make	")
					   .append("	from episode ")
					   .append("	where num_novel=?	")
					   .append("	order by num_episode desc	");

			pstmt = con.prepareStatement(selectallEp.toString());

			pstmt.setInt(1, novelNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				leVO = new ListEpisodeVO2();
				leVO.setNovelNum(novelNum);
				leVO.setEpNum(rs.getInt("num_episode"));
				leVO.setEpTitle(rs.getString("title"));
				leVO.setViewCnt(rs.getInt("visit"));
				leVO.setCreateDate(rs.getDate("make"));

				list.add(leVO);
			}
			System.out.println("에피소드 회차 리스트 보여주기");
		} finally {
			dbConnection.dbClose(rs, pstmt, con);
		}
		return list;
	} // selectAllEp

	
	// 에피소드 내용보여주는 창 (다른사용자)
	public LookEpisodeVO selectEpisode(int novelNum, int epNum) throws SQLException {
		LookEpisodeVO leVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dbConnection = DbConnection.getInstance();
		episodeCount(epNum); // 조회수 증가

		try {
			con = dbConnection.getConn();

			StringBuilder selectEpisode = new StringBuilder();
			selectEpisode.append(" select n.title novelTitle, e.title epTitle, e.story epDetail ")
						 .append(" from episode e, novel n ")
						 .append(" where n.num_novel=e.num_novel and e.num_novel=? and e.num_episode=? and e.open=1 ");

			pstmt = con.prepareStatement(selectEpisode.toString());

			pstmt.setInt(1, novelNum);
			pstmt.setInt(2, epNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				leVO = new LookEpisodeVO();
				leVO.setNovelTitle(rs.getString("novelTitle"));
				leVO.setEpTitle(rs.getString("epTitle"));
				leVO.setEpDetail(rs.getString("epDetail"));
			}
			System.out.println("해당 소설 보여주기 novelNum - " + novelNum + "epNum - " + epNum);

		} finally {
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return leVO;
	}// selectEpisode
	

	// 에피소드 개수 출력
	public int countEp(int novelNum) throws SQLException {
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

			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return cnt;
	}// countEp
	
	
	// 첫 에피소드 보여주기
	public int selectFirstEp(int novelNum) throws SQLException {
		int first = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			String selectFir = " select num_episode from episode where rownum=1 and num_novel=? and open=1 ORDER BY NUM_EPISODE ASC ";

			pstmt = con.prepareStatement(selectFir);
			pstmt.setInt(1, novelNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				first = rs.getInt(1);
			}

		} finally {
			dbConnection.dbClose(null, pstmt, con);
		}

		return first;
	}// selectFirstEp
	
	// 이전화 보여주기
	public int prevEp(int novelNum, int epNum) throws SQLException {

		PrevNextVO pnVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT * FROM " )
				.append(" (SELECT lag(NUM_EPISODE, 1, 0) over(ORDER BY NUM_EPISODE) AS prev, NUM_EPISODE ")
				.append(" FROM EPISODE WHERE num_novel=? and OPEN=1) WHERE NUM_EPISODE=? " ); 

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, novelNum);
			pstmt.setInt(2, epNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pnVO = new PrevNextVO();
				pnVO.setPrevEpNum(rs.getInt("prev"));
			}
			System.out.println("select novelNum" + novelNum + "prev " + pnVO.getPrevEpNum());

		} finally {
			dbConnection.dbClose(null, pstmt, con);
		}

		return pnVO.getPrevEpNum();
	}//prevEp
	
	// 다음화 보여주기
	public int nextEp(int novelNum, int epNum) throws SQLException {

		PrevNextVO pnVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT * FROM " )
				.append(" (SELECT lead(NUM_EPISODE, 1, 0) over(ORDER BY NUM_EPISODE) AS next, NUM_EPISODE ")
				.append(" FROM EPISODE WHERE num_novel=? and OPEN=1) WHERE NUM_EPISODE=? " ); 

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, novelNum);
			pstmt.setInt(2, epNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pnVO = new PrevNextVO();
				pnVO.setNextEpNum(rs.getInt("next"));
			}
			System.out.println("select novelNum" + novelNum + "prev " + pnVO.getNextEpNum());

		} finally {
			dbConnection.dbClose(null, pstmt, con);
		}

		return pnVO.getNextEpNum();
	}// nextEp
	
	
	// 에피소드 조회수 증가
	public void episodeCount(int episodeNum) throws SQLException {
		int cnt = 0; 
		
		Connection con = null;
		PreparedStatement pstmt = null;

		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();
		
			String view = " update episode set visit =(visit+1) where num_episode=? ";
			
			pstmt = con.prepareStatement(view);

			pstmt.setInt(1, episodeNum);
			cnt = pstmt.executeUpdate();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		
	}//episodeCount

	// 좋아요 추가
	public int insertLike(LikeVO likeVO) throws SQLException {
		int cnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			StringBuilder insertLike = new StringBuilder();

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

			System.out.println("아이디: "+ likeVO.getId() + ", 소설번호: " + likeVO.getNovelNum()+ ", 유저번호: " +likeVO.getUserNum()+" 좋아요 추가");

			// 6. 쿼리문 수행 수 결과 얻기
			cnt = pstmt.executeUpdate();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		System.out.println(cnt);
		return cnt;
	}// insertLike

	
	// 좋아요 취소(삭제)
	public int deleteLike(int userNum, int novelNum) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			String deleteLike = " delete from liken where num_member=? and num_novel=? ";

			pstmt = con.prepareStatement(deleteLike);

			// 5. 바인드 변수값 설정
			pstmt.setInt(1, userNum);
			pstmt.setInt(2, novelNum);

			System.out.println(deleteLike + ", " + userNum + ", " + novelNum + " 좋아요 삭제");

			// 6. 쿼리문 수행 수 결과 얻기
			cnt = pstmt.executeUpdate();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		
		System.out.println(cnt);

		return cnt;
	}// deleteLike
	
	
	// 좋아요 개수
	public int cntLike(int novelNum) throws SQLException{
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();
		ResultSet rs = null;

		try {
			con = dbConnection.getConn();

			String cntLike = " select count(*) from liken where num_novel=? ";

			pstmt = con.prepareStatement(cntLike);
			pstmt.setInt(1, novelNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return cnt;
	}

	
	// 좋아요되어 있으면 좋아요 화면에 표시
	public int confirmLike(int userNum, int novelNum) throws SQLException {
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

			if (rs.next()) {
				cnt = rs.getInt(1);
			}

			System.out.println(userNum + ", " + novelNum + ", 좋아요" + (cnt==0? "안함":"함"));
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return cnt;
	}


	// 신고 추가
	public int insertReport(ReportVO reportVO) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();

		System.out.println("insert 신고 userNum " + reportVO.getUserNum() + ", novelNum " + reportVO.getNovelNum() + ", "
				+ reportVO.getReportCode());

		try {
			con = dbConnection.getConn();
			
			String ids = "SELECT m.id FROM MEMBER m, NOVEL n  WHERE m.NUM_MEMBER =n.NUM_MEMBER AND n.NUM_NOVEL=? ";
			

			// epNum 자동증가, 에피소드 등록시 무조건 공개로 시작, 뷰수는 0,
			StringBuilder insertReport = new StringBuilder();
			insertReport.append(" insert into report(num_report, num_member, num_novel, id, reason_code, report_date) ")
			 			.append(" values (num_like.nextval,?,?,?,?,sysdate) ");

			pstmt = con.prepareStatement(insertReport.toString());

			// 5. 바인드 변수값 설정
			pstmt.setInt(1, reportVO.getUserNum());
			pstmt.setInt(2, reportVO.getNovelNum());
			pstmt.setString(3, reportVO.getId());
			pstmt.setInt(4, reportVO.getReportCode());

			// 6. 쿼리문 수행 수 결과 얻기
			cnt = pstmt.executeUpdate();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return cnt;
	}


}
