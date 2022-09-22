package kr.co.ezen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class memberDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs  = null;
	
	public Connection getConnection() {
		String Driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hyun";
		String pass = "1234";
		
		try {
			Class.forName(Driver);
			 conn = DriverManager.getConnection(url, id, pass);
			System.out.println("데이터베이스 연동에 성공하였습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연동에 실패하였습니다.");
		}		
		return conn;		
	}
	
	//insert member table
	public void insertmember(memberBean mBean) {
		
		try {
				getConnection();
				
			String  sql = "insert into camping_member values(?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mBean.getId());//id value
			pstmt.setString(2, mBean.getPasswd1());
			pstmt.setString(3, mBean.getName());
			pstmt.setString(4, mBean.getEmail());
			pstmt.setString(5, mBean.getTele());
			pstmt.setString(6, mBean.getHobby());
			pstmt.setString(7, mBean.getJob());
			pstmt.setString(8, mBean.getAge());
			pstmt.setString(9, mBean.getInfo());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//모든 회원 정보를 반환해주는 메소드 호출
	public Vector<memberBean> allselectmember() throws SQLException{
		
		Vector<memberBean> v = new Vector<memberBean>();
		
		String sql = "select * from camping_member";
		try {
			
				getConnection();
				
			pstmt = conn.prepareStatement(sql);
				
			rs = pstmt.executeQuery();
		
		while(rs.next()) {
			memberBean mBean = new memberBean();
			
			mBean.setId(rs.getString(1));
			mBean.setPasswd1(rs.getString(2));
			mBean.setName(rs.getString(3));
			mBean.setEmail(rs.getString(4));
			mBean.setTele(rs.getString(5));
			mBean.setHobby(rs.getString(6));
			mBean.setJob(rs.getString(7));
			mBean.setAge(rs.getString(8));
			mBean.setInfo(rs.getString(9));
			v.add(mBean);
			
		}		
		conn.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return v;
	}
	
	//해당 id에 내용을 반환해 주는 메소드 호출
	public memberBean oneselectmember(String id){
				
		memberBean mBean = new memberBean();
				
		try {
				getConnection();
				
			String sql = "select * from camping_member where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
					
				mBean.setId(rs.getString(1));
				mBean.setPasswd1(rs.getString(2));
				mBean.setName(rs.getString(3));
				mBean.setEmail(rs.getString(4));
				mBean.setTele(rs.getString(5));
				mBean.setHobby(rs.getString(6));
				mBean.setJob(rs.getString(7));
				mBean.setAge(rs.getString(8));
				mBean.setInfo(rs.getString(9));			
		}		
		conn.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return mBean;
	}

	//id에 해당하는 비밀번호를 찾아서 반환하는 메소드 호출 	
	public String getPassword(String id){		
		String password = null;		
		
		try {
			getConnection();			
			
			String sql = "select passwd1 from camping_member where id = ?";
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
	public void updatemember(memberBean mBean){
	
		try {
			getConnection();
			
			String sql = "update camping_member set email=?, tele=? where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mBean.getEmail());
			pstmt.setString(2, mBean.getTele());
			pstmt.setString(3, mBean.getId());
			
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
	public void deletemember(String id){
		
		try {
			getConnection();
			
			String sql = "delete from camping_member where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);			
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
