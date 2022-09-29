package BKRV.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class rvDAO {
	
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2  = null;
		
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
	
	
	//새로운 리뷰 데이터 입력
	public void insertReview(rvBean rBean) {
		
		conn=getConnection();
		
		try {
			
			String sql = "insert into Review_info values (review_num.nextval, ?, ?, sysdate, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rBean.getRv_bknumber());
			pstmt.setString(2, rBean.getRv_id());
			pstmt.setInt(3, rBean.getRv_score());
			pstmt.setString(4, rBean.getRv_content());
			
			pstmt.executeUpdate();
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//한 회원에 대한 모든 리뷰 표시
	public Vector<rvBean> allmemberselectReview(String Rv_id){

		Vector<rvBean> vec = new Vector<>();
		
		conn=getConnection();
		
		try {
			
			String sql = "select * from Review_info where RV_id = ? order by RV_date";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Rv_id);
			
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
		
		conn=getConnection();
		
		try {
			
			String sql = "select * from Review_info where RV_bknumber = ? order by RV_date";
			
			pstmt = conn.prepareStatement(sql);
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
	public rvBean updateOneSelectReview(int rv_number, int rv_bknumber, String rv_id) {
		rvBean rbean = new rvBean();
		
		try {
			conn=getConnection();
			
								
			String sql = "select * from Review_info where RV_number = ? and RV_bknumber = ? and RV_id = ? order by RV_date";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rv_number);
			pstmt.setInt(2, rv_bknumber);
			pstmt.setString(3, rv_id);
			
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
			conn=getConnection();
			
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
		public void deleteReview(int rv_number) {
			
			conn=getConnection();
			
			try {
				
				String sql  = "delete from Review_info where rv_number = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, rv_number);
				
				pstmt.executeUpdate();
				
				
				if(conn != null) {
					conn.commit();
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
	public Vector<rvBean> allselectBoard(int startRow, int endRow) {
			
		conn=getConnection();

		Vector<rvBean> rb  = new Vector<rvBean>(); 
		
		try {
			/*
			
			
			Rownum - query 결과로 나오게 되는 각각의 행들의 순서 값
					 특정 갯수의 그 이하 행 선택시 사용
			RowID - 테이블에 저장된 각 행들이 저장된 주소 값
					가장 최신 글 가져오기
					Rownum 기준으로 Rnum 별칭 사용하여 Rnum이 srtRow보다 크고 endRow보다 작은 경우에 해당하는 모든 레코드 가져오기
			
			
			*/
			
			String sql = "select * from (select A.*, Rownum Rnum from (select * from Review_info order by Rv_date)A) where Rnum >= ? and Rnum <= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rvBean rbean = new rvBean();
					
				rbean.setRv_number(rs.getInt(1));
				rbean.setRv_bknumber(rs.getInt(2));
				rbean.setRv_id(rs.getString(3));
				rbean.setRv_date(rs.getString(4));
				rbean.setRv_score(rs.getInt(5));
				rbean.setRv_content(rs.getString(6));
					
				rb.add(rbean);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}		
			return rb;
	}
	
	//각 서적별 평점 평균 구하기
	public double getScore(int bk_number){
		
		conn=getConnection();
		
		int sum = 0;
		int count =0;
		double average = 0;
		
		try {
			
			String sql = "select count(*) from review_info where rv_bknumber=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bk_number);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			if(rs.getInt(1)==0) {
				average=0;
			} else {
			count = rs.getInt(1);	
			
			
			String sql2 = "select sum(rv_score) from review_info where rv_bknumber = ?";
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, bk_number);
			rs2 = pstmt2.executeQuery();
			
			if(rs2.next()) {
				
				sum = rs2.getInt(1);
			}
			average = sum/count;
			}
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}
		}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return average;
	}
	
	
	//전체리뷰수 파악 후 반환(칼럼, 값 유무 판단)
			public int getAllcount(String column, String value){
				
				conn=getConnection();
				
				int count = 0;
				
				try {
					
					if(column != "" || value != "") {
						String sql = "select count(*) from Review_info where " + column + " = ?";
						
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1,value);
						rs = pstmt.executeQuery();
					}else if(column == "" && value == "") {
						String sql = "select count(*) from Review_info";
						
						pstmt = conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
					}
					if(rs.next()) {
						count = rs.getInt(1);
						
					}
					if(conn != null) {
						conn.commit();
						conn.close();
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return count;
			}
		
		
		//모든 리뷰 표시
		public Vector<rvBean> allselectReview() {

			Vector<rvBean> vec = new Vector<>();
			
			conn=getConnection();
			
			try {
				
				String sql = "select * from Review_info order by RV_number";
				
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
		
		
public Vector<rvBean> allselectBoard(int startRow, int endRow, String column, String value) {
			
			conn=getConnection();

			Vector<rvBean> rb  = new Vector<rvBean>(); 
			
			try {
				/*
				
				
				Rownum - query 결과로 나오게 되는 각각의 행들의 순서 값
						 특정 갯수의 그 이하 행 선택시 사용
				RowID - 테이블에 저장된 각 행들이 저장된 주소 값
						가장 최신 글 가져오기
						Rownum 기준으로 Rnum 별칭 사용하여 Rnum이 srtRow보다 크고 endRow보다 작은 경우에 해당하는 모든 레코드 가져오기
				
				
				*/
				if(column != "" || value != "") {
					String sql = "select * from (select A.*, Rownum Rnum from (select * from Review_info where " + column + " = ? order by Rv_date)A) where Rnum >= ? and Rnum <= ?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, value);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
				}else if(column == "" && value == "") {
					String sql = "select * from (select A.*, Rownum Rnum from (select * from Review_info order by Rv_date)A) where Rnum >= ? and Rnum <= ?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					rs = pstmt.executeQuery();
				}
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					rvBean rbean = new rvBean();
						
					rbean.setRv_number(rs.getInt(1));
					rbean.setRv_bknumber(rs.getInt(2));
					rbean.setRv_id(rs.getString(3));
					rbean.setRv_date(rs.getString(4));
					rbean.setRv_score(rs.getInt(5));
					rbean.setRv_content(rs.getString(6));
						
					rb.add(rbean);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}		
				return rb;
		}

		//모든 리뷰 데이터 유무 확인
		public int checkReview(int rv_number) {

			int check = 0;
			
			conn=getConnection();
			
			try {
				
				String sql = "select * from Review_info where rv_number=?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rv_number);
				rs = pstmt.executeQuery();
				
				
				if(rs.next()) {
					check=1;
				} else {
					check=-1;
				}
				if(conn != null) {
					conn.commit();
					conn.close();
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return check;
		}
}


