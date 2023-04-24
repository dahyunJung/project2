package ManagerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ManagerVO.LoginVO;
import conn.DbConnection;

public class LoginDAO {
	
	public ManagerVO.LoginVO selectLogin( String id, String password )throws SQLException {
		
		LoginVO lVO = null;
		DbConnection dbCon = DbConnection.getInstance();
		//1. JNDI 占쏙옙占� 占쏙옙체 占쏙옙占쏙옙
		//2. DataSource 占쏙옙占�
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//3. Connection 占쏙옙占�
			con=dbCon.getConn();
		//4. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙체 占쏙옙占�
			StringBuilder  selectInjection = new StringBuilder();
			selectInjection
			.append(" select id, password, create_date ")
			.append(" from manager ")
			.append(" where id=? and password=? ");
			
			pstmt = con.prepareStatement(selectInjection.toString());
			//5. 占쏙옙占싸듸옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
			pstmt.setString(1, id);
			pstmt.setString(2, password);
		//6. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쏙옙占�
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //占싯삼옙占쏙옙 占쏙옙占쌘드가 占쏙옙占쏙옙占싹댐옙?
				//VO占쏙옙 占쏙옙占쏙옙占싹울옙 占싯삼옙 占쏙옙占쏙옙占� 占쌀댐옙
				
				lVO = new LoginVO( id, password, rs.getDate("create_date") );
			}//end while			
			
		}finally {
			//7. 占쏙옙占쏙옙 占쏙옙占쏙옙
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return lVO;
	}//selectLogin
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
