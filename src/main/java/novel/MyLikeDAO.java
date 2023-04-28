package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DbConnection;

public class MyLikeDAO {
	
	public List<MyLikeVO> selectNovelAll(String num_member,String search,String type) throws SQLException {
		List<MyLikeVO> list=new ArrayList<MyLikeVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			
			StringBuilder sb=new StringBuilder();
			sb.append(" select n.photo, n.title, m.id, n.num_novel, n.age, n.end, e.num_episodes, e.max_make ")
			.append(" from member m	")
			.append(" join novel n ON n.num_member = m.num_member ")
			.append(" join liken l ON n.num_novel = l.num_novel ")
			.append(" LEFT JOIN (	")
			.append(" SELECT num_novel, COUNT(*) AS num_episodes, MAX(make) AS max_make	")
			.append(" FROM episode	")
			.append(" GROUP BY num_novel	")
			.append(" ) e ON n.num_novel = e.num_novel	")
			.append(" WHERE l.num_member = ? AND n.title LIKE '%")
			.append(search)
			.append("%'")
			.append(" order by e.max_make ");
			
			if(type.equals("0")) {
			sb.append(" DESC ");
			}
			
			pstmt=con.prepareStatement(sb.toString());

			pstmt.setString(1, num_member);
				
			rs=pstmt.executeQuery();
				
			MyLikeVO mVO=null;
			
			while(rs.next()) {
				 
				mVO=new MyLikeVO(rs.getString("photo"), rs.getString("title"), rs.getString("id"), rs.getInt("num_novel"), rs.getInt("num_episodes"), rs.getInt("age"), rs.getInt("end"), rs.getDate("max_make"));
				list.add(mVO);
			}
				
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return list;
	}
	public void deleteNovel(String num_novel,String num_member) throws SQLException {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" delete ")
			.append(" from liken ")
			.append(" where num_member=? and num_novel=? ");
			
			pstmt=con.prepareStatement(sb.toString());
			
			pstmt.setString(1, num_member);
			pstmt.setInt(2, Integer.parseInt(num_novel));
			
			pstmt.executeUpdate();
			
		}finally {
			dbCon.dbClose(null, pstmt, con);
		}
		
	}

}
