package LoginDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import LoginVO.FindIdVO;
import LoginVO.FindPWVO;
import LoginVO.InfoVO;
import LoginVO.JoinVO;
import LoginVO.LoginHistoryVO;
import LoginVO.SessionVO;
import LoginVO.UpdateInfoVO;
import conn.DbConnection;


public class LoginDAO {
	
	
	public void insertMember(JoinVO jVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConnection dbCon = DbConnection.getInstance();
		// 1. JNDI 사용 객체 생성
		// 2. DataSource 얻기
		// 3. Connection 얻기
		try {
			con = dbCon.getConn();
			// 4. 쿼리문 객체 얻기
			StringBuilder insertSql = new StringBuilder();
			insertSql.append("insert into member(num_member,id,name,pw,birth,phone,email,join) values(num_member.nextval,?,?,?,?,?,?,sysdate)");

			pstmt = con.prepareStatement(insertSql.toString());
			
			
			// 5.바인드 변수 값 수정
			pstmt.setString(1, jVO.getId());
			pstmt.setString(2, jVO.getName());
			pstmt.setString(3, jVO.getPw());
			pstmt.setDate(4, new java.sql.Date(jVO.getBirthDate().getTime()));
			pstmt.setString(5, jVO.getPhone());
			pstmt.setString(6, jVO.getEmail());

			// 6. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);

		}
	}
	
	public String selectIdCheck(String id)throws SQLException {
		String resultId="";
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		DbConnection dbCon = DbConnection.getInstance();
		
		try {
			con = dbCon.getConn();
			String sql="select id from member where id=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				resultId=rs.getString("id");
			}
			
		}finally {
			dbCon.dbClose(null, pstmt, con);
		}
		
		return resultId;
	}
	public String selectIdFind(FindIdVO fiVO)throws SQLException {
		String resultFindId="";
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		DbConnection dbCon = DbConnection.getInstance();
		
		try {
			con = dbCon.getConn();
			String sql="select id from member where name=? and phone=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, fiVO.getName());
			pstmt.setInt(2, fiVO.getPhone());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				resultFindId=rs.getString("id");
			}
			
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return resultFindId;
	}
	
public boolean selectCheckPW(FindPWVO fpVO)throws SQLException {
	boolean idCheck=false;
	
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DbConnection dbCon =DbConnection.getInstance();
	
	try {
		con = dbCon.getConn();
		String sql = "select id from member where id=? and phone=? and email=? ";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, fpVO.getId());
		pstmt.setInt(2, fpVO.getPhone());
		pstmt.setString(3, fpVO.getEmail());
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			idCheck =true;
		}
	}finally {
		dbCon.dbClose(rs, pstmt, con);
	}
	
	return idCheck; // 아이디가 존재하면 true, 존재하지 않으면 false
}

public int updatePW(FindPWVO fpVO)throws SQLException {
	int passTemp=0;
	
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DbConnection dbCon =DbConnection.getInstance();
	
	try {
		con = dbCon.getConn();
	String sql = "update member set pw=?  where id=? ";
	
	pstmt=con.prepareStatement(sql);
	
	
	pstmt.setString(1, fpVO.getPassTemp());
	pstmt.setString(2, fpVO.getId());
	
	passTemp=pstmt.executeUpdate();
	
	
	}finally {
		
		dbCon.dbClose(rs, pstmt, con);
	}
	return passTemp;
}

public SessionVO selectLogin(String id,String pw,LoginHistoryVO lhVO)throws SQLException {
	
	int resultNum_member=0;
	String resultId = null;
	String resultName = null;
	String resultPhoto = null;
	
	
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	DbConnection dbCon = DbConnection.getInstance();
	
	try {
		con = dbCon.getConn();
		String sql="select num_member,id,name,photo from member where id=? and pw=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			resultNum_member=rs.getInt("num_member");
			resultId=rs.getString("id");
			resultName=rs.getString("name");
			resultPhoto=rs.getString("photo");
		}
		LoginDAO lDAO = new LoginDAO();
		
		lhVO.setNum_member(resultNum_member);
		lDAO.insertLoginHistory(lhVO);
		
	}finally {
		dbCon.dbClose(rs, pstmt, con);
	}
	return new SessionVO(resultNum_member,resultId,resultName,resultPhoto);	
}
public InfoVO selectInfo(String id)throws SQLException {
	
	String resultName = null;
	String resultId = null;
	String resultEmail = null;
	int resultPhone = 0;
	Date resultBirth = null;
	
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	DbConnection dbCon = DbConnection.getInstance();
	
	try {
		con = dbCon.getConn();
		String sql="select name,id,birth,phone,email from member where id=?";
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			resultName=rs.getString("name");
			resultId=rs.getString("id");
			resultBirth=rs.getDate("birth");
			resultPhone=rs.getInt("phone");
			resultEmail=rs.getString("email");
		}
		
	}finally {
		dbCon.dbClose(rs, pstmt, con);
	}
	return new InfoVO(resultName,resultId,resultEmail,resultBirth,resultPhone);
}

public int updateInfo(UpdateInfoVO uiVO)throws SQLException {
	int infoUpdate=0;
	
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DbConnection dbCon =DbConnection.getInstance();
	
	try {
		con = dbCon.getConn();
	String sql = "update member set phone=? , email=?  where id=? ";
	
	pstmt=con.prepareStatement(sql);
	
	
	pstmt.setInt(1,uiVO.getPhone() );
	pstmt.setString(2,uiVO.getEmail() );
	pstmt.setString(3,uiVO.getId() );
	
	infoUpdate=pstmt.executeUpdate();
	
	
	}finally {
		
		dbCon.dbClose(rs, pstmt, con);
	}
	return infoUpdate;
}
public int updatePass(String id, String pw)throws SQLException {
	int passUpdate=0;
	
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DbConnection dbCon =DbConnection.getInstance();
	
	try {
		con = dbCon.getConn();
		String sql = "update member set pw=? where id=? ";
		
		pstmt=con.prepareStatement(sql);
		
		
		pstmt.setString(1,pw );
		pstmt.setString(2,id );
		
		passUpdate=pstmt.executeUpdate();
		
		
	}finally {
		
		dbCon.dbClose(rs, pstmt, con);
	}
	return passUpdate;
}


  public void insertLoginHistory(LoginHistoryVO lhVO)throws SQLException { 


		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConnection dbCon =DbConnection.getInstance();
		
		try {
		con= dbCon.getConn();
		String sql = "insert into history(num_member,ip,visit,os) values(?,?,sysdate,?)";
		
		pstmt = con.prepareStatement(sql);
		System.out.println(lhVO.getNum_member()+" "+lhVO.getIp()+" "+lhVO.getOS());
		pstmt.setInt(1,lhVO.getNum_member());
		pstmt.setString(2,lhVO.getIp());
		pstmt.setString(3,lhVO.getOS());
		
		pstmt.executeUpdate();
		
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
		
		
  }
  
  public void updateProfile(String profile, int num) throws SQLException{
	  Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DbConnection dbCon =DbConnection.getInstance();
		
		try {
			con= dbCon.getConn();
			String sql = "update member set photo=? where num_member=?";
			
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,profile);
			pstmt.setInt(2,num);
			
			
			pstmt.executeUpdate();
			
		}finally {
			dbCon.dbClose(rs, pstmt, con);
		}
			
  }
}


