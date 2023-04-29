package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DbConnection;

public class SearchDAO {
	
	public List<SearchVO> selectNovelAll(String search) throws SQLException {
		List<SearchVO> list=new ArrayList<SearchVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			
			StringBuilder sb=new StringBuilder();
			sb.append(" select n.photo, n.title, m.id, n.num_novel, e.num_episodes, e.max_make, n.age, n.end ")
			.append(" from member m	")
			.append(" join novel n ON n.num_member = m.num_member ")
			.append(" LEFT JOIN (	")
			.append(" SELECT num_novel, COUNT(*) AS num_episodes, MAX(make) AS max_make	")
			.append(" FROM episode	")
			.append(" GROUP BY num_novel	")
			.append(" ) e ON n.num_novel = e.num_novel	")
			.append(" WHERE n.title LIKE '%")
			.append(search)
			.append("%' and n.open=1");
			
			pstmt=con.prepareStatement(sb.toString());

			rs=pstmt.executeQuery();
				
			SearchVO mVO=null;
			
			while(rs.next()) {
				 
				mVO=new SearchVO(rs.getString("photo"), rs.getString("title"), rs.getString("id"), rs.getInt("num_novel"), rs.getInt("num_episodes"), rs.getInt("age"), rs.getInt("end"), rs.getDate("max_make"));
				list.add(mVO);
			}
				
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return list;
	}

}
