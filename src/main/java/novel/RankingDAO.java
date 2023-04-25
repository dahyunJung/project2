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
			sb.append(" SELECT n.photo, n.age, n.title, m.id, COUNT(l.num_like) AS liken_count, e.visit, n.story,	")
					.append("       RANK() OVER (ORDER BY e.visit DESC) AS episode_visit_rank	")
					.append("FROM novel n	")
					.append("JOIN member m ON n.num_member = m.num_member	")
					.append("LEFT JOIN liken l ON n.num_novel = l.num_novel	")
					.append("LEFT JOIN (	")
					.append("  SELECT num_novel, visit	")
					.append("  FROM episode e1	")
					.append("  WHERE make >= ADD_MONTHS(SYSDATE, -1)	")
					.append("  AND make = (	")
					.append("    SELECT MAX(make)	")
					.append("    FROM episode e2	")
					.append("    WHERE e1.num_novel = e2.num_novel	")
					.append("  )	")
					.append(") e ON n.num_novel = e.num_novel	")
					.append("GROUP BY n.photo, n.age, n.title, m.id, e.visit, n.story	")
					.append("ORDER BY e.visit DESC NULLS LAST; ");
				
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
