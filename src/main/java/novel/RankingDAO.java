package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DbConnection;

public class RankingDAO {

	public List<RankingVO> selectRanking()throws SQLException{
		List<RankingVO> list=new ArrayList<RankingVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" SELECT n.photo, n.age, n.title, m.id, COUNT(l.num_like) AS liken_count, n.visit, n.story, ")
			.append(" RANK() OVER (ORDER BY n.visit DESC) AS visit_rank ")
			.append(" FROM novel n JOIN member m ON n.num_member = m.num_member ")
			.append(" LEFT JOIN liken l ON n.num_novel = l.num_novel ")
			.append(" GROUP BY n.photo, n.age, n.title, m.id, n.visit, n.story ")
			.append(" ORDER BY n.visit DESC ");
				
			pstmt=con.prepareStatement(sb.toString());
				
			rs=pstmt.executeQuery();
			
			RankingVO rVO=null;
			
			while(rs.next()) {
				rVO=new RankingVO(rs.getString("photo"), rs.getString("title"), rs.getString("id"), rs.getString("story"),
						rs.getInt("age"), rs.getInt("liken_count"), rs.getInt("visit"), rs.getInt("visit_rank"));
				list.add(rVO);
			}
			
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return list;
	}
	
}
