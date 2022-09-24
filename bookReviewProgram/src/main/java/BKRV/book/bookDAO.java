package BKRV.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bookDAO {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

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
		
		//insert Book_info table
		public void insertBook(bookBean bBean) {

			try{

				conn=getConnection();

				String sql = "insert into bookreviewprogram values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";

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

}
