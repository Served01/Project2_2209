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
	
	//DB 연결
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
	
	//책 상세정보 입력
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
		
		if(conn != null) {
			conn.commit();
			conn.close();
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
		
	}
	
	

	//책 상세정보 조회
	public bkBean selectBook(int bk_number) {
		
		bkBean bBean = new bkBean();
		conn = getConnection();
		
		try {
			
			String sql = "select * from book_info where bk_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bk_number);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				bBean.setBk_number(rs.getInt(1));
				bBean.setBk_title(rs.getString(2));
				bBean.setBk_writer(rs.getString(3));
				bBean.setBk_publisher(rs.getString(4));
				bBean.setBk_pubdate(rs.getDate(5).toString());
				bBean.setBk_image(rs.getString(6));
				bBean.setBk_local(rs.getInt(7));
				bBean.setBk_genre(rs.getInt(8));
				bBean.setBk_ebook(rs.getInt(9));
				bBean.setBk_infodate(rs.getDate(10).toString());
				bBean.setBk_detail(rs.getString(11));
					
			}
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return bBean;
		
	}
	
	//검색어에 따른 책 리스트 조회
	public Vector<bkBean> selectBookList(String search_word){

		Vector<bkBean> vec = new Vector<bkBean>();
		
		conn=getConnection();
		
		try {
			
			String sql = "select * from book_info where bk_title like \'%"+search_word+"%\'";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				bkBean bBean = new bkBean();
				
				bBean.setBk_number(rs.getInt(1));
				bBean.setBk_title(rs.getString(2));
				bBean.setBk_writer(rs.getString(3));
				bBean.setBk_publisher(rs.getString(4));
				bBean.setBk_pubdate(rs.getString(5));
				bBean.setBk_image(rs.getString(6));
				bBean.setBk_local(rs.getInt(7));
				bBean.setBk_genre(rs.getInt(8));
				bBean.setBk_ebook(rs.getInt(9));
				bBean.setBk_infodate(rs.getString(10));
				bBean.setBk_detail(rs.getString(11));
				
				vec.add(bBean);
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
	
	//책 상세정보 수정
	public void updateBook(bkBean bBean) {
		
		conn = getConnection();
		
		try {
			
			String sql = "update book_info set bk_title=?, bk_writer=?, bk_publisher=?, bk_pubdate=?, bk_local=?, bk_genre=?, bk_ebook=?, bk_detail=? where bk_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bBean.getBk_title());
			pstmt.setString(2, bBean.getBk_writer());
			pstmt.setString(3, bBean.getBk_publisher());
			pstmt.setString(4, bBean.getBk_pubdate());
			pstmt.setInt(5, bBean.getBk_local());
			pstmt.setInt(6, bBean.getBk_genre());
			pstmt.setInt(7, bBean.getBk_ebook());
			pstmt.setString(8, bBean.getBk_detail());
			pstmt.setInt(9, bBean.getBk_number());
			
			pstmt.executeUpdate();
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
