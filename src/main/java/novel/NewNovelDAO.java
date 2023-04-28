package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DbConnection;

public class NewNovelDAO {
	
	public void insertNewNovel(NewNovelVO nVO) throws SQLException {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" insert into novel(num_novel,num_member,title,age,photo,story,open,end,visit,likes,make) ")
			.append(" values(num_novel.nextval,(SELECT num_member FROM member WHERE id = ?),?,?,?,?,?,0,0,0,sysdate) ");
				
			pstmt=con.prepareStatement(sb.toString());
			
			pstmt.setString(1, nVO.getId());
			pstmt.setString(2, nVO.getTitle());
			pstmt.setInt(3, nVO.getAge());
			pstmt.setString(4, nVO.getFilephoto());
			pstmt.setString(5, nVO.getStory());
			pstmt.setInt(6, nVO.getOpen());
				
			pstmt.executeQuery();
				
		}finally {
			dbCon.dbClose(null, pstmt, con);
		}
	}
	public NewNovelVO selectNovel(String id, int num_novel) throws SQLException {
		
		NewNovelVO nVO=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" select num_novel,title,age,photo,story,open,end from novel ")
			.append(" where num_novel=? ");
			
			pstmt=con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, num_novel);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				nVO=new NewNovelVO(id, rs.getString("title"), rs.getString("photo"), rs.getString("story"), rs.getInt("age"), rs.getInt("open"), rs.getInt("end"));
			}
			
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		return nVO;
	}
	public void editNovel(NewNovelVO nVO, String num_novel) throws SQLException {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" update novel set title=?,age=?,photo=?,story=?,open=?,end=? ")
			.append(" where num_novel=? ");
			
			pstmt=con.prepareStatement(sb.toString());
			
			pstmt.setString(1, nVO.getTitle());
			pstmt.setInt(2, nVO.getAge());
			pstmt.setString(3, nVO.getFilephoto());
			pstmt.setString(4, nVO.getStory());
			pstmt.setInt(5, nVO.getOpen());
			pstmt.setInt(6, nVO.getEnd());
			pstmt.setInt(7, Integer.parseInt(num_novel));
			
			pstmt.executeQuery();
			
		}finally {
			dbCon.dbClose(null, pstmt, con);
		}
	}
	public void deleteNovel(int num_novel) throws SQLException {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		try {
			con=dbCon.getConn();
			String str=(" delete from novel where num_novel=")+num_novel;
			
			pstmt=con.prepareStatement(str);
			pstmt.executeQuery();
			
		}finally {
			dbCon.dbClose(null, pstmt, con);
		}
	}

}
