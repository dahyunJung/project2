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
		 ResultSet rs = null;
		
		 conn.DbConnection dbCon = conn.DbConnection.getInstance();
		 try {
			//1. JNDI 사용 객체 생성
				//2. DataSource 얻기
				//3. Connection 얻기
			 con=dbCon.getConn();
			//4. 쿼리문 생성 객체 얻기
			 StringBuilder insertInjection = new StringBuilder();
			 insertInjection
			 .append(" insert into manager(id, password, create_date) values(?,?,sysdate) ");
			 
			 pstmt=con.prepareStatement(insertInjection.toString());
			//5. 바인드 변수 값 설정
			 pstmt.setString(1, iVO.getId());
			 pstmt.setString(2, iVO.getPassword());

			 
			//6. 쿼리문 수행 후 결과 얻기
			 rs=pstmt.executeQuery(); //prepared에서는  update인데
		 }finally {
				//7. 연결 끊기
			 dbCon.dbClose(rs, pstmt, con);
		 }//end finally
}//insertInjection
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}//class
