package novel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DbConnection;

public class MyNovelDAO {
	
	public List<MyNovelVO> selectNovelAll(String id,String type) throws SQLException {
		List<MyNovelVO> list=new ArrayList<MyNovelVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbCon=DbConnection.getInstance();
		
		
		try {
			con=dbCon.getConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" select n.num_novel, n.photo, n.title, n.age, n.open, n.end ")
			.append(" from novel n, member m ")
			.append(" where (n.num_member = m.num_member) and (m.id = '")
			.append(id)
			.append("') order by n.make");
			if(type.equals("0")) {
				sb.append(" desc");
			}
				
			pstmt=con.prepareStatement(sb.toString());
				
			rs=pstmt.executeQuery();
				
			MyNovelVO mVO=null;
				
			while(rs.next()) {
				mVO=new MyNovelVO(rs.getString("photo"), rs.getString("title"), (rs.getInt("age")==1), (rs.getInt("open")==1), rs.getInt("num_novel"), rs.getInt("end"));
				list.add(mVO);
			}
				
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return list;
	}

}
