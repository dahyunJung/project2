package ManagerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ManagerVO.LoginVO;
import conn.DbConnection;

public class ManagerLoginDAO {
	
	public ManagerVO.LoginVO selectLogin( String id, String password )throws SQLException {
		
		LoginVO lVO = null;
		DbConnection dbCon = DbConnection.getInstance();
		//1. JNDI 사용 객체 생성
		//2. DataSource 얻기
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//3. Connection 얻기
			con=dbCon.getConn();
			//4. 쿼리문 생성 객체 얻기
			StringBuilder  selectInjection = new StringBuilder();
			selectInjection
			.append(" select id, password, create_date ")
			.append(" from manager ")
			.append(" where id=? and password=? ");
			
			pstmt = con.prepareStatement(selectInjection.toString());
			//5. 바인드 변수 값 설정
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			//6. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //검색된 레코드가 존재하니?
				//VO를 생성하여 검색 결과를 할당
				
				lVO = new LoginVO( id, password, rs.getDate("create_date") );
			}//end while			
			
		}finally {
			//7. 연결 끊기
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return lVO;
	}//selectLogin
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
