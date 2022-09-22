package BKRV.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import BKRV.review.rvBean;

public class rvDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs  = null;
	
	public Connection getConnection() {
		String Driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hyun";
		String pass = "1234";
		
		try {
			 conn = DriverManager.getConnection(url, id, pass);
			System.out.println("데이터베이스 연동에 성공하였습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연동에 실패하였습니다.");
		}		
		return conn;		
	}
	
	
	//DB에 리뷰 새로이 입력
	public void insertReview(rvBean rBean) {
		
		getConnection();
		
		try {
			String sql = "insert into Review_info values (?, ?, ?, sysdate, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rBean.getRv_number());
			pstmt.setInt(2, rBean.getRv_bknumber());
			pstmt.setString(3, rBean.getRv_id());
			pstmt.setString(4, rBean.getRv_date().toString());
			pstmt.setInt(5, rBean.getRv_score());
			pstmt.setString(6, rBean.getRv_content());
			
			pstmt.executeUpdate();
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}
			
		}catch(Exception e){
			
		}
	}
	
	
	//한 회원에 대한 모든 리뷰 표시
	public Vector<rvBean> allmemberselectReview(int Rv_id){

		Vector<rvBean> vec = new Vector<>();
		
		getConnection();
		
		try {
			
			String sql = "select * from Review_info where RV_id = ? order by RV_Date";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			pstmt.setInt(1, Rv_id);
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
	
	
	//한 책에 대한 모든 리뷰 표시
	public Vector<rvBean> allbookselectReview(int Rv_bknumber){

		Vector<rvBean> vec = new Vector<rvBean>();
		
		getConnection();
		
		try {
			
			String sql = "select * from Review_info where RV_bknumber = ? order by RV_Date";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			pstmt.setInt(1, Rv_bknumber);
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
	
	
	//한 리뷰에 대한 수정을 위해 해당 리뷰 내용 로드
	public rvBean updateoneselectboard(int Rv_number, int Rv_bknumber, String Rv_id) {
		rvBean rbean = new rvBean();
		
		try {
			getConnection();
			
								
			String sql = "select * from Review_info where RV_number = ? and RV_bknumber = ? and RV_id = ? order by RV_date";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Rv_number);
			pstmt.setInt(2, Rv_bknumber);
			pstmt.setString(3, Rv_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				rbean.setRv_number(rs.getInt(1));
				rbean.setRv_bknumber(rs.getInt(2));
				rbean.setRv_id(rs.getString(3));
				rbean.setRv_date(rs.getString(4));
				rbean.setRv_score(rs.getInt(5));
				rbean.setRv_content(rs.getString(6));
				
			}
			if(conn != null) {
				conn.commit();
				conn.close();
			}		
		}catch(Exception e) {
			e.printStackTrace();
			}
		return rbean;
	}
	
	
	//한 리뷰에 대한 해당 리뷰 수정 적용
	public void updateReview(rvBean rBean) {
		try {
			getConnection();
			
			String sql  = "update Review_info set RV_score = ?, RV_content = ? where RV_number = ? and RV_bknumber = ? and RV_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rBean.getRv_score());
			pstmt.setString(2, rBean.getRv_content());
			pstmt.setInt(3, rBean.getRv_number());
			pstmt.setInt(4, rBean.getRv_bknumber());
			pstmt.setString(5, rBean.getRv_id());
			
			pstmt.executeUpdate();
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//한 리뷰에 대한 해당 리뷰 삭제
	public void deleteReview(int Rv_number, int Rv_bknumber, String Rv_id) {
		try {
			getConnection();
			
			String sql  = "delete from Review_info where RV_number = ? and RV_bknumber = ? and Rv_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Rv_number);
			pstmt.setInt(2, Rv_bknumber);
			pstmt.setString(3, Rv_id);
			
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
