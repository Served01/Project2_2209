package BKRV.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class mbDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConnection() {
		
		String Driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "bookrv";
		String dbpw = "1234";
		
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url,dbid,dbpw);
			System.out.println("데이터베이스 연동에 성공하였습니다");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연동에 실패하였습니다");
		} 
		return conn;
	}
	
	//새로운 회원정보 입력
	public void insertmember(mbBean Bean) {
		
		conn = getConnection();
		
		try {
		
			String sql = "insert into member_info values (?,?,?,?,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Bean.getMb_id());
			pstmt.setString(2, Bean.getMb_pw());
			pstmt.setString(3, Bean.getMb_name());
			pstmt.setString(4, Bean.getMb_nick());
			pstmt.setString(5, Bean.getMb_email());
			pstmt.setString(6, Bean.getMb_tel());
			pstmt.setString(7, Bean.getMb_gender());
			
			pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//회원정보 반환
	public Vector<mbBean> allselectmember() throws SQLException {
		
		Vector<mbBean> v = new Vector<mbBean>();
		String sql = "select * from member";
		
		
		try {
			getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mbBean Bean = new mbBean();
				Bean.setMb_id(rs.getString(1));
				Bean.setMb_pw(rs.getString(2));
				Bean.setMb_name(rs.getString(3));
				Bean.setMb_nick(rs.getString(4));
				Bean.setMb_email(rs.getString(5));
				Bean.setMb_tel(rs.getString(6));
				Bean.setMb_gender(rs.getString(7));
				v.add(Bean);
			}
			conn.commit();
			conn.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		
		return v;
		
	}

	//해당 id에 내용을 반환해 주는 메소드 호출
	public mbBean oneselectmember(String mb_id){
				
		mbBean Bean = new mbBean();
				
		try {
				getConnection();
				
			String sql = "select * from member where mb_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
					
				Bean.setMb_id(rs.getString(1));
				Bean.setMb_pw(rs.getString(2));
				Bean.setMb_name(rs.getString(3));
				Bean.setMb_nick(rs.getString(4));
				Bean.setMb_email(rs.getString(5));
				Bean.setMb_tel(rs.getString(6));
				Bean.setMb_gender(rs.getString(7));		
		}		
		conn.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return Bean;
	}

	//id에 해당하는 비밀번호를 찾아서 반환하는 메소드 호출 	
	public String getPassword(String id){		
		String password = null;		
		
		try {
			getConnection();			
			
			String sql = "select passwd1 from member where mb_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				password = rs.getString(1);
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return password;		
	}
	
	// id에 해당하는 회원정보를 수정합니다. 
	public void updatemember(mbBean Bean){
	
		try {
			conn = getConnection();
			
			String sql = "update member set mb_email=?, mb_tel=? where mb_id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Bean.getMb_email());
			pstmt.setString(2, Bean.getMb_nick());
			pstmt.setString(3, Bean.getMb_id());
			
			pstmt.executeUpdate();
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// id에 해당하는 회원정보 삭제
	public void deletemember(String mb_id){
		
		try {
			getConnection();
			
			String sql = "delete from member where mb_id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mb_id);			
			pstmt.executeUpdate();
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}