package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.LoginVO;
import conn.DbConnection;

public class LoginDAO {
	
	public LoginVO selectLogin( String id, String password )throws SQLException {
		
		LoginVO lVO = null;
		DbConnection dbCon = DbConnection.getInstance();
		//1. JNDI ��� ��ü ����
		//2. DataSource ���
		Connection con  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//3. Connection ���
			con=dbCon.getConn();
		//4. ������ ���� ��ü ���
			StringBuilder  selectInjection = new StringBuilder();
			selectInjection
			.append(" select id, password, create_date ")
			.append(" from manager ")
			.append(" where id=? and password=? ");
			
			pstmt = con.prepareStatement(selectInjection.toString());
			//5. ���ε� ���� �� ����
			pstmt.setString(1, id);
			pstmt.setString(2, password);
		//6. ������ ���� �� ��� ���
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //�˻��� ���ڵ尡 �����ϴ�?
				//VO�� �����Ͽ� �˻� ����� �Ҵ�
				
				lVO = new LoginVO( id, password, rs.getDate("create_date") );
			}//end while			
			
		}finally {
			//7. ���� ����
			dbCon.dbClose(rs, pstmt, con);
		}//end finally
		
		return lVO;
	}//selectLogin
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
