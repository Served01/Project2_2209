package BKRV.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class bkDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs  = null;
	
	public Connection getConnection(){
		
	String Driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbid = "bookrv";
	String dbpw = "1234";
	
	try {
		Class.forName(Driver);
		conn = DriverManager.getConnection(url, dbid, dbpw);
		System.out.println("데이터베이스 연동에 성공하였습니다.");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("데이터베이스 연동에 실패하였습니다.");
	}
	
	return conn;
	
	}
	
	public void insertBook() {
		
		conn = getConnection();
		
		
	}
	
	


	public bkBean selectBook() {
		
		
		return null;
		
	}
	
	
	public Vector<bkBean> listBook() {
		
		
		return null;
		
	}
	
	public String getPassword() {
		
		
		return null;
		
	}
	
	
	public void updateBook(bkBean bBean) {
		
		
	}
	
	
	
}
