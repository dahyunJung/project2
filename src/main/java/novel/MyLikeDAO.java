package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DbConnection;

public class MyLikeDAO {
	
	public List<MyLikeVO> selectNovelAll(String id,String search) throws SQLException {
		List<MyLikeVO> list=new ArrayList<MyLikeVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			
			StringBuilder sb=new StringBuilder();
			sb.append(" select n.photo, n.title, m.id, n.num_novel ")
			.append(" from member m, novel n, liken l ")
			.append(" where (n.num_member=m.num_member and l.num_novel=n.num_novel) and (l.id=?) and (n.title like '%")
			.append(search)
			.append("%')")
			.append(" order by l.num_like ");
				
			pstmt=con.prepareStatement(sb.toString());

			pstmt.setString(1, id);
				
			rs=pstmt.executeQuery();
				
			MyLikeVO mVO=null;
			
			while(rs.next()) {
				 
				mVO=new MyLikeVO(rs.getString("photo"), rs.getString("title"), rs.getString("id"), rs.getInt("num_novel"));
				list.add(mVO);
			}
				
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return list;
	}
	public void deleteNovel(String num_novel,String id) throws SQLException {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" delete ")
			.append(" from liken ")
			.append(" where id=? and num_novel=? ");
			
			pstmt=con.prepareStatement(sb.toString());
			
			pstmt.setString(1, id);
			pstmt.setInt(2, Integer.parseInt(num_novel));
			
			pstmt.executeUpdate();
			
		}finally {
			dbCon.dbClose(null, pstmt, con);
		}
		
	}

}
