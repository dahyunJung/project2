package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DbConnection;

public class RankingDAO {

	public List<RankingVO> selectRanking(int type)throws SQLException{
		List<RankingVO> list=new ArrayList<RankingVO>();
		int i=0;
		switch(type) {
		case 0:i=1; break;
		case 1:i=7; break;
		case 2:i=30; break;
		}
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" SELECT n.num_novel, n.photo, n.age, n.end, n.title, m.id, COUNT(l.num_like) AS liken_count,	")
					.append("       e.visit, n.story, COUNT(ep.num_episode) AS episode_count, MAX(ep.make) AS max_make,	")
					.append("       RANK() OVER (ORDER BY e.visit DESC) AS visit_rank	")
					.append("	FROM novel n	")
					.append("	JOIN member m ON n.num_member = m.num_member	")
					.append("	LEFT JOIN liken l ON n.num_novel = l.num_novel	")
					.append("	LEFT JOIN (	")
					.append("  SELECT num_novel, MAX(visit) AS visit	")
					.append("  FROM episode	")
					.append("  WHERE make >= SYSDATE - ").append(i)
					.append("  GROUP BY num_novel	")
					.append("    ) e ON n.num_novel = e.num_novel	")
					.append("    LEFT JOIN episode ep ON n.num_novel = ep.num_novel AND e.visit = ep.visit	")
					.append("    WHERE n.make >= SYSDATE - ").append(i)
					.append("	AND e.visit IS NOT NULL and n.open=1	")
					.append("	GROUP BY n.num_novel, n.photo, n.age, n.title, m.id, e.visit, n.story, n.end	")
					.append("	ORDER BY e.visit DESC ");
				
			pstmt=con.prepareStatement(sb.toString());
				
			rs=pstmt.executeQuery();
			
			RankingVO rVO=null;
			
			while(rs.next()) {
				rVO=new RankingVO(rs.getInt("num_novel"),rs.getString("photo"), rs.getString("title"), rs.getString("id"), rs.getString("story"),
						rs.getInt("age"), rs.getInt("liken_count"), rs.getInt("visit"), rs.getInt("visit_rank"), rs.getInt("episode_count"), rs.getInt("end"));
				list.add(rVO);
			}
			
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return list;
	}
	
}
