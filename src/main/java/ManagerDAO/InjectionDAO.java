package ManagerDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InjectionDAO {
	
	public void insertInjection( ManagerVO.InjectionVO iVO )throws SQLException {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		
		 conn.DbConnection dbCon = conn.DbConnection.getInstance();
		 try {
		//1. JNDI 占쏙옙占� 占쏙옙체 占쏙옙占쏙옙
		//2. DataSource 占쏙옙占�
		//3. Connection 占쏙옙占�
			 con=dbCon.getConn();
		//4. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙체 占쏙옙占�
			 StringBuilder insertInjection = new StringBuilder();
			 insertInjection
			 .append(" insert into manager(id, password, create_date) values(?,?,sysdate) ");
			 
			 pstmt=con.prepareStatement(insertInjection.toString());
		//5. 占쏙옙占싸듸옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
			 pstmt.setString(1, iVO.getId());
			 pstmt.setString(2, iVO.getPassword());

			 
		//6. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占� 占쏙옙占�
			 pstmt.executeQuery(); //prepared占쏙옙占쏙옙占쏙옙  update占싸듸옙
		 }finally {
		//7. 占쏙옙占쏙옙 占쏙옙占쏙옙
			 dbCon.dbClose(null, pstmt, con);
		 }//end finally
}//insertInjection
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}//class
