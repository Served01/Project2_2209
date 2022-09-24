package BKRV.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	public void insertBook(bkBean bBean) {
		
		conn=getConnection();
	try {
		String sql = "insert into BOOK_INFO values(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, bBean.getBk_number());
		pstmt.setString(2, bBean.getBk_title());
		pstmt.setString(3, bBean.getBk_writer());
		pstmt.setString(4, bBean.getBk_publisher());
		pstmt.setString(5, bBean.getBk_pubdate());
		pstmt.setString(6, bBean.getBk_image());
		pstmt.setInt(7, bBean.getBk_local());
		pstmt.setInt(8, bBean.getBk_genre());
		pstmt.setInt(9, bBean.getBk_ebook());
		pstmt.setString(10, bBean.getBk_detail());

		pstmt.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}
		
	}
	
	


	public bkBean selectBook() {
		
		bkBean bBean = new bkBean();
		conn = getConnection();
		
		try {
			
			String sql = "select * from book_info where bk_number = ?"
		}
		
		
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
