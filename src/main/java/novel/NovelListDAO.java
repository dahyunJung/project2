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
			sb.append(" select n.photo, n.title, m.id, n.story, n.age, n.end, n.open ")
			.append(" from novel n ")
			.append(" join member m on n.num_member = m.num_member ")
			.append(" where n.num_novel = ? ");
				
			pstmt=con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, Integer.parseInt(num_novel));
				
			rs=pstmt.executeQuery();
				
			while(rs.next()) {
				nVO=new NovelListVO(rs.getString("photo"), rs.getString("title"), (rs.getString("id")), rs.getString("story"), rs.getInt("age"), rs.getInt("end"), rs.getInt("open"));
			}
				
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return nVO;
	}
	
	public int selectChk(String num_novel) throws SQLException {
		int num_member=0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" select num_member ")
			.append(" from novel ")
			.append(" where num_novel = ? ");
				
			pstmt=con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, Integer.parseInt(num_novel));
				
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				num_member=rs.getInt("num_member");
			}
				
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return num_member;
	}

}
