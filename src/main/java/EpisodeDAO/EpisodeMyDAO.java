package EpisodeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EpisodeVO.My.CreateEpisodeVO;
import EpisodeVO.My.EditEpisodeVO;
import conn.DbConnection;

public class EpisodeMyDAO {

	/*
	 * CreateEpisodeVO: novelNum, epNum, userNum, epTitle, detail, openStatus,
	 * views, createDate episode sql: num_episode, num_novel, num_member, title,
	 * story, open, visit, make
	 */
	
	  // 작성한 소설 제목 출력 (에피소드 작성 )
	public String selectNovelName(int novelNum) throws SQLException {
		String novelTitle = "";	  
		
		Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
		DbConnection dbConnection = DbConnection.getInstance();
		
		try { 
			con = dbConnection.getConn();
			StringBuilder selectNovelTitle = new StringBuilder();
			
			selectNovelTitle.append(" select title ")
							.append(" from novel ")
							.append(" where num_novel=?" );
	  
			pstmt = con.prepareStatement(selectNovelTitle.toString());
			pstmt.setInt(1, novelNum); 
			rs = pstmt.executeQuery();
			
			System.out.println(selectNovelTitle);
			System.out.println(novelNum);
	  
			if(rs.next()) { 
				novelTitle = rs.getString("title"); 
			}
		}finally { 
			dbConnection.dbClose(null, pstmt, con); 
		}// end finally
	 
		return novelTitle; 
	} // selectNovelName
	 

	// 에피소드 생성
	public void insertEpisode(CreateEpisodeVO ceVO) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();

		try {
			// 1. JNDI 사용객체 생성
			// 2. DataSource 얻기
			// 3. Connection 얻기
			con = dbConnection.getConn();

			// 4. 쿼리문 생성객체 얻기
			StringBuilder insertEpisode = new StringBuilder();
			
			// epNum 자동증가, 에피소드 등록시 무조건 공개로 시작, 뷰수는 0,
			insertEpisode.append(" insert into episode(num_episode,num_novel,num_member,title,story,open,visit,make) ")
						 .append(" values (num_episode.nextval,?,?,?,?,1,0,sysdate) ");

			pstmt = con.prepareStatement(insertEpisode.toString());

			// 5. 바인드 변수값 설정
			pstmt.setInt(1, ceVO.getNovelNum());
			pstmt.setInt(2, ceVO.getUserNum());
			pstmt.setString(3, ceVO.getEpTitle());
			pstmt.setString(4, ceVO.getDetail());
			
			System.out.println("INSERT novelNum: " + ceVO.getNovelNum()+", userNum: "+ ceVO.getUserNum());

			// 6. 쿼리문 수행 수 결과 얻기
			pstmt.executeQuery();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
	}// insertEpisode
	

	// 에피소드 수정, userNum은 세션, epNum은 파라미터
	public int updateEpisode(EditEpisodeVO edVO) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			StringBuilder editEpisode = new StringBuilder();

			editEpisode.append(" update episode ")
						.append(" set title=?,story=?,open=? ")
						.append(" where num_member=? and num_novel=? and num_episode=? ");

			pstmt = con.prepareStatement(editEpisode.toString());

			// 5. 바인드 변수값 설정
			pstmt.setString(1, edVO.getEpTitle());
			pstmt.setString(2, edVO.getDetail());
			pstmt.setBoolean(3, edVO.getOpenStatus());
			pstmt.setInt(4, edVO.getUserNum());
			pstmt.setInt(5, edVO.getNovelNum());
			pstmt.setInt(6, edVO.getEpNum());

			System.out.println(editEpisode);
			System.out.println(edVO.getUserNum() + ", " + edVO.getNovelNum() + ", " + edVO.getEpNum() + ", "
					+ edVO.getEpTitle() + ", " + edVO.getOpenStatus());

			// 6. 쿼리문 수행 수 결과 얻기
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally
		return cnt;
	}// updateEpisode

	
	// 에피소드 삭제
	public int deleteEpisode(int userNum, int novelNum, int epNum) throws SQLException {
		int cnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			StringBuilder deleteEpisode = new StringBuilder();

			deleteEpisode.append(" delete from episode ")
						.append(" where num_member=? and num_novel=? and num_episode=? ");

			pstmt = con.prepareStatement(deleteEpisode.toString());

			// 5. 바인드 변수값 설정
			pstmt.setInt(1, userNum);
			pstmt.setInt(2, novelNum);
			pstmt.setInt(3, epNum);

			System.out.println(deleteEpisode);
			System.out.println(userNum + ", " + novelNum + ", " + epNum);

			// 6. 쿼리문 수행 수 결과 얻기
			cnt = pstmt.executeUpdate();
		} finally {
			// 7. 연결 끊기
			dbConnection.dbClose(null, pstmt, con);
		} // end finally

		return cnt;
	}// deleteEpisode

	
	// 내 소설에 해당하는 모든 에피소드 리스트 가져오기
	public List<CreateEpisodeVO> selectEpisodeAll(int userNum, int novelNum) throws SQLException {
		List<CreateEpisodeVO> epList = new ArrayList<CreateEpisodeVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DbConnection dbConnection = DbConnection.getInstance();

		try {
			con = dbConnection.getConn();

			StringBuilder selectEpisodeAll = new StringBuilder();
			selectEpisodeAll.append(" select title,open,visit,make ")
					.append(" from episode where num_member=? and num_novel=?");

			pstmt = con.prepareStatement(selectEpisodeAll.toString());
			rs = pstmt.executeQuery();

			CreateEpisodeVO ceVO = null;

			while (rs.next()) {
				ceVO = new CreateEpisodeVO();
				ceVO.setEpTitle(rs.getString("title"));
				ceVO.setOpenStatus(rs.getBoolean("open"));
				ceVO.setViews(rs.getInt("view"));
				ceVO.setCreateDate(rs.getDate("make"));

				epList.add(ceVO);
			}

		} finally {
			dbConnection.dbClose(null, pstmt, con);
		}

		return epList;
	}// selectEpisodeAll

}// class
