package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DbConnection;

public class NovelListDAO {
	
	public NovelListVO selectNovel(String num_novel) throws SQLException {

		NovelListVO nVO=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" select n.photo, n.title, m.id, n.story ")
			.append(" from novel n ")
			.append(" join member m on n.num_member = m.num_member ")
			.append(" where n.num_novel = ? ");
				
			pstmt=con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, Integer.parseInt(num_novel));
				
			rs=pstmt.executeQuery();
				
			while(rs.next()) {
				nVO=new NovelListVO(rs.getString("photo"), rs.getString("title"), (rs.getString("id")), rs.getString("story"));
			}
				
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return nVO;
	}

}
