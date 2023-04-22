package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.InjectionVO;

public class InjectionDAO {
	
	public void insertInjection( InjectionVO iVO )throws SQLException {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		
		 conn.DbConnection dbCon = conn.DbConnection.getInstance();
		 try {
		//1. JNDI ��� ��ü ����
		//2. DataSource ���
		//3. Connection ���
			 con=dbCon.getConn();
		//4. ������ ���� ��ü ���
			 StringBuilder insertInjection = new StringBuilder();
			 insertInjection
			 .append(" insert into manager(id, password, create_date) values(?,?,sysdate) ");
			 
			 pstmt=con.prepareStatement(insertInjection.toString());
		//5. ���ε� ���� �� ����
			 pstmt.setString(1, iVO.getId());
			 pstmt.setString(2, iVO.getPassword());

			 
		//6. ������ ���� �� ��� ���
			 pstmt.executeQuery(); //prepared������  update�ε�
		 }finally {
		//7. ���� ����
			 dbCon.dbClose(null, pstmt, con);
		 }//end finally
}//insertInjection
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}//class
