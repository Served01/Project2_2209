package BKRV.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import BKRV.review.rvBean;

public class bkDAO {
	
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
	
	
public void insertReview(bkBean bBean) {
		
		getConnection();
		
		try {
			int ref = 0;	//글 그룹에서 가장 큰 값
			int re_step = 1;
			int re_level = 1;
			
			String refsql = "select max(ref) from Book_info";
			pstmt = conn.prepareStatement(refsql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ref = rs.getInt(1) + 1;
			}
			
			String sql = "insert into Book_info values"
					+ "(smartboard_num.nextval, ?, ?, ?, ?,sysdate, ?, ?, ?, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bBean.getNumber());
			pstmt.setInt(2, bBean.getBknumber());
			pstmt.setString(3, bBean.getId());
			pstmt.setString(4, bBean.getDate().toString());
			pstmt.setInt(5, bBean.getScore());
			pstmt.setString(6, bBean.getContent());
			
			pstmt.executeUpdate();
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}
			
		}catch(Exception e){
			
		}
	}
	

	public Vector<bkBean> allselectBook(){

		Vector<bkBean> vec = new Vector<>();
		
		getConnection();
		
		try {
			
			String sql = "select * from Book_info where BK_id = ? order by Date";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bkBean bbean = new bkBean();
				
				bbean.setNumber(rs.getInt(1));
				bbean.setBknumber(rs.getInt(2));
				bbean.setId(rs.getString(3));
				bbean.setDate(rs.getString(4));
				bbean.setScore(rs.getInt(5));
				bbean.setContent(rs.getString(6));
				
				vec.add(bbean);
			}
			if(conn != null) {
				conn.commit();
				conn.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vec;
	}
	
	public Vector<rvBean> allbookselectReview(){

		Vector<rvBean> vec = new Vector<rvBean>();
		
		getConnection();
		
		try {
			
			String sql = "select * from Review_info order by Date";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rvBean rbean = new rvBean();
				
				rbean.setRv_number(rs.getInt(1));
				rbean.setRv_bknumber(rs.getInt(2));
				rbean.setRv_id(rs.getString(3));
				rbean.setRv_date(rs.getString(4));
				rbean.setRv_score(rs.getInt(5));
				rbean.setRv_content(rs.getString(6));
				
				vec.add(rbean);
			}
			if(conn != null) {
				conn.commit();
				conn.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vec;
	}
	
}
