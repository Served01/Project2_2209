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
		String sql = "insert into BOOK_INFO values(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, upper(?))";

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
		pstmt.setString(11, bBean.getBk_title());

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
				bBean.setBk_title_upper(rs.getString(12));
					
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
			
			String sql = "select * from book_info where bk_title_upper like upper(\'%"+search_word+"%\')";
			
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
				bBean.setBk_title_upper(rs.getString(12));
				
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
			
			String sql = "update book_info set bk_title=?, bk_writer=?, bk_publisher=?, bk_pubdate=?, bk_image=?, bk_local=?, bk_genre=?, bk_ebook=?, bk_detail=?, bk_title_upper = upper(?) where bk_number=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bBean.getBk_title());
			pstmt.setString(2, bBean.getBk_writer());
			pstmt.setString(3, bBean.getBk_publisher());
			pstmt.setString(4, bBean.getBk_pubdate());
			pstmt.setString(5, bBean.getBk_image());
			pstmt.setInt(6, bBean.getBk_local());
			pstmt.setInt(7, bBean.getBk_genre());
			pstmt.setInt(8, bBean.getBk_ebook());
			pstmt.setString(9, bBean.getBk_detail());
			pstmt.setString(10, bBean.getBk_title());
			pstmt.setInt(11, bBean.getBk_number());
			
			pstmt.executeUpdate();
			
			if(conn != null) {
				conn.commit();
				conn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//책 정보 삭제 기능
	public void deleteBook(int bk_number) {
		
		conn = getConnection();
		
		try {
			
				String sql = "delete from book_info where bk_number=?";
				
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setInt(1, bk_number);
				
				pstmt.executeQuery();
			
			if(conn != null) {
				conn.commit();
				conn.close();
				}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}	
	
	}
	
	//책 일련번호를 이용한 제목 조회
		public String selecttitleBook(int bk_number) {
			
			
			conn = getConnection();
			String bk_title = null;
			
			try {
				
				String sql = "select bk_title from book_info where bk_number = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bk_number);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					
					bk_title = rs.getString(1);						
				}
				
				if(conn != null) {
					conn.commit();
					conn.close();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return bk_title;
			
		}
		
		//메뉴용 책 리스트 조회
		public Vector<bkBean> selectMenuBookList(int bk_local, int bk_genre){

			Vector<bkBean> vec = new Vector<bkBean>();
			
			conn=getConnection();
			
			try {
				
				String sql = "select * from book_info where bk_local = ? and bk_genre = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bk_local);
				pstmt.setInt(2, bk_genre);
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
		
		
		//모든 책 리스트 조회
		public Vector<bkBean> selectAllBookList(){

			Vector<bkBean> vec = new Vector<bkBean>();
			
			conn=getConnection();
			
			try {
				
				String sql = "select * from book_info";
				
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
					bBean.setBk_title_upper(rs.getString(12));
					
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
		
		public int selectcheckBook(int bk_number) {
			
			int check = 0;
					
			conn = getConnection();
			
			try {
				
				String sql = "select * from book_info where bk_number = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bk_number);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					//데이터가 있는 경우
					check=1;
						
				}else {
					//데이터가 없는 경우
					check=-1;
				}
				
				if(conn != null) {
					conn.commit();
					conn.close();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return check;
			
		}
		
		
		//검색 책 게시판형태 X개당 Y페이지
				public Vector<bkBean> allselectBoard(int startRow, int endRow, String column, String value1) {
					
					conn=getConnection();
					
					String value = value1.toUpperCase();
					
					Vector<bkBean> bb  = new Vector<bkBean>(); 
					
					try {
						/*
						
						
						Rownum - query 결과로 나오게 되는 각각의 행들의 순서 값
								 특정 갯수의 그 이하 행 선택시 사용
						RowID - 테이블에 저장된 각 행들이 저장된 주소 값
								가장 최신 글 가져오기
								Rownum 기준으로 Rnum 별칭 사용하여 Rnum이 srtRow보다 크고 endRow보다 작은 경우에 해당하는 모든 레코드 가져오기
						
						
						*/
						if(column != "" || value != "") {
							String sql = "select * from (select A.*, Rownum Rnum from (select * from Book_info where " + column + " like ? order by Bk_number)A) where Rnum >= ? and Rnum <= ?";
							
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, '%' + value + '%');
							pstmt.setInt(2, startRow);
							pstmt.setInt(3, endRow);
						}else if(column == "" && value == "") {
							String sql = "select * from (select A.*, Rownum Rnum from (select * from Book_info order by BK_number)A) where Rnum >= ? and Rnum <= ?";
							
							pstmt = conn.prepareStatement(sql);
							pstmt.setInt(1, startRow);
							pstmt.setInt(2, endRow);
						}
						
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
							bBean.setBk_title_upper(rs.getString(12));
								
							bb.add(bBean);
							}
							
						}catch(Exception e) {
							e.printStackTrace();
						}		
						return bb;
				}
				
				
				//전체책수 파악 후 반환
				public int getAllcount(String column, String value){
					
					conn=getConnection();
					
					int count = 0;
					
					try {
						
						if(column != "" || value != "") {
						String sql = "select count(*) from Book_info where " + column + " like ?";
						
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, '%' + value + '%');
						
						}else if(column == "" && value == "") {
							String sql = "select count(*) from Book_info";
							
							pstmt = conn.prepareStatement(sql);
						}
						rs = pstmt.executeQuery();
						
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
				
				//모든 책 게시판형태 X개당 Y페이지
				public Vector<bkBean> allselectBoardbkall(int startRow, int endRow) {
					
					conn=getConnection();

					Vector<bkBean> bb  = new Vector<bkBean>(); 
					
					try {
						/*
						
						
						Rownum - query 결과로 나오게 되는 각각의 행들의 순서 값
								 특정 갯수의 그 이하 행 선택시 사용
						RowID - 테이블에 저장된 각 행들이 저장된 주소 값
								가장 최신 글 가져오기
								Rownum 기준으로 Rnum 별칭 사용하여 Rnum이 srtRow보다 크고 endRow보다 작은 경우에 해당하는 모든 레코드 가져오기
						
						
						*/
						String sql = "select * from (select A.*, Rownum Rnum from (select * from Book_info order by BK_number)A) where Rnum >= ? and Rnum <= ?";
							
							pstmt = conn.prepareStatement(sql);
							pstmt.setInt(1, startRow);
							pstmt.setInt(2, endRow);
						
						
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
								
							bb.add(bBean);
							}
							
						}catch(Exception e) {
							e.printStackTrace();
						}		
						return bb;
				}
				
				
				//전체책수 파악 후 반환
				public int getAllcountbkall(){
					
					conn=getConnection();
					
					int count = 0;
					
					try {
						
						String sql = "select count(*) from Book_info";
							
							pstmt = conn.prepareStatement(sql);
						
						rs = pstmt.executeQuery();
						
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
				
				
				//일련번호 중복확인
				public int duplecateBKnum(int bk_number){
					
					int check=0;
					conn=getConnection();
					
					try{
				    	
				        String sql = "SELECT * FROM BOOK_INFO WHERE bk_number = ?";
				        
				        pstmt = conn.prepareStatement(sql);
				       
				        pstmt.setInt(1, bk_number);       
				        
				        rs=pstmt.executeQuery();
				        
				        if(rs.next()){
				        	check=1;
				        } else{
					check=-1;
				    }}catch(Exception e){
				     	System.out.println("일련번호 중복 확인 실패 : " + e);
				    }//try end
					return check;
				}//duplecateID end
	
				
				//검색 책 게시판형태 X개당 Y페이지
				public Vector<bkBean> bkmenuselectBoard(int startRow, int endRow, String column1, int value1, String column2, int value2) {
					
					conn=getConnection();
					
					
					Vector<bkBean> bb  = new Vector<bkBean>(); 
					
					try {
						/*
						
						
						Rownum - query 결과로 나오게 되는 각각의 행들의 순서 값
								 특정 갯수의 그 이하 행 선택시 사용
						RowID - 테이블에 저장된 각 행들이 저장된 주소 값
								가장 최신 글 가져오기
								Rownum 기준으로 Rnum 별칭 사용하여 Rnum이 srtRow보다 크고 endRow보다 작은 경우에 해당하는 모든 레코드 가져오기
						
						
						*/
						if(column1 != "" || value1 != 0 || column2 != "" || value2 != 0) {
							String sql = "select * from (select A.*, Rownum Rnum from (select * from Book_info where " + column1 + " =? and "+ column2 +" =? order by Bk_number)A) where Rnum >= ? and Rnum <= ?";
							
							pstmt = conn.prepareStatement(sql);
							pstmt.setInt(1, value1);
							pstmt.setInt(2, value2);
							pstmt.setInt(3, startRow);
							pstmt.setInt(4, endRow);
						}else if(column1 == "" && value1 == 0 && column2 == "" && value2 == 0) {
							String sql = "select * from (select A.*, Rownum Rnum from (select * from Book_info order by BK_number)A) where Rnum >= ? and Rnum <= ?";
							
							pstmt = conn.prepareStatement(sql);
							pstmt.setInt(1, startRow);
							pstmt.setInt(2, endRow);
						}
						
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
							bBean.setBk_title_upper(rs.getString(12));
								
							bb.add(bBean);
							}
							
						}catch(Exception e) {
							e.printStackTrace();
						}		
						return bb;
				}
				
				
				//전체책수 파악 후 반환
				public int getbkmenucount(String column1, int value1, String column2, int value2){
					
					conn=getConnection();
					
					int count = 0;
					
					try {
						
						if(column1 != "" || value1 != 0 || column2 != "" || value2 != 0) {
						String sql = "select count(*) from Book_info where " + column1 + " =? and "+ column2 + " =?";
						
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, value1);
						pstmt.setInt(2, value2);
						
						}else if(column1 == "" && value1 == 0 && column2 == "" && value2 == 0) {
							String sql = "select count(*) from Book_info";
							
							pstmt = conn.prepareStatement(sql);
						}
						rs = pstmt.executeQuery();
						
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
				
				
}
