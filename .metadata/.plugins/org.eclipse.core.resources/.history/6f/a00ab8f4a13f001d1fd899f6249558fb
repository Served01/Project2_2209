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
	public void insertmember(mbBean mBean) {
		
		conn = getConnection();
		
		try {
		
			String sql = "insert into member_info values (?,?,?,?,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mBean.getMb_id());
			pstmt.setString(2, mBean.getMb_pw());
			pstmt.setString(3, mBean.getMb_name());
			pstmt.setString(4, mBean.getMb_nick());
			pstmt.setString(5, mBean.getMb_email());
			pstmt.setString(6, mBean.getMb_tel());
			pstmt.setString(7, mBean.getMb_gender());
			
			pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//회원정보 반환
	public Vector<mbBean> allselectmember(){
			
			Vector<mbBean> v = new Vector<mbBean>();
			String sql = "select * from member_info";
			
			
			try {
				getConnection();
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					mbBean mBean = new mbBean();
					mBean.setMb_id(rs.getString(1));
					mBean.setMb_pw(rs.getString(2));
					mBean.setMb_name(rs.getString(3));
					mBean.setMb_nick(rs.getString(4));
					mBean.setMb_email(rs.getString(5));
					mBean.setMb_tel(rs.getString(6));
					mBean.setMb_gender(rs.getString(7));
					v.add(mBean);
				}
				conn.commit();
				conn.close();
				} catch(Exception e){
					e.printStackTrace();
				}
			
			return v;
			
		}

	//해당 id에 내용을 반환해 주는 메소드 호출
		public mbBean oneselectmember(String id){
					
			mbBean mBean = new mbBean();
					
			try {
				getConnection();
					
				String sql = "select * from member_info where mb_id = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
			
				while(rs.next()) {
						
					mBean.setMb_id(rs.getString(1));
					mBean.setMb_pw(rs.getString(2));				
					mBean.setMb_name(rs.getString(3));
					mBean.setMb_nick(rs.getString(4));
					mBean.setMb_email(rs.getString(5));
					mBean.setMb_tel(rs.getString(6));
					mBean.setMb_gender(rs.getString(7));		
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
				
				String sql = "select mb_pw from member_info where mb_id = ?";
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
		public void updatemember(mbBean mBean){
		
			try {
				getConnection();
				
				String sql = "update member_info set mb_email=?, mb_nick=? where mb_id=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mBean.getMb_email());
				pstmt.setString(2, mBean.getMb_nick());
				pstmt.setString(3, mBean.getMb_id());
				
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
				
				String sql = "delete from member_info where mb_id=?";
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
		
		//비밀번호 변경 기능
		public void updatepass(String id, String pw){
			
			try {
				getConnection();
				
				String sql = "update member_info set mb_pw=? where mb_id=?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, pw);
				pstmt.setString(2, id);
				
				pstmt.executeUpdate();
				
				if(conn != null) {
					conn.commit();
					conn.close();
				}			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//로그인을 시도하는 하나의 함수
		public int login(String id, String pass) {

			String sql = "select mb_pw from member_info where mb_id =?";
			
			try {
				
				getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if(rs.getString(1).equals(pass)) {
						return 1; // 로그인성공
					}else {
						return 0; // 비밀번호 불일치
					}
				} else {
				return -1; // 아이디가 없음
				}
			} catch (Exception e) {
				e.printStackTrace();
				return -2; // 데이터베이스 오류
			}
			
		}
		
		
		//해당 id에 해당되는 데이터가 있는지 체크하는 기능
				public int onecheckmember(String id){
							
					int check = 0;
							
					try {
						getConnection();
							
						String sql = "select * from member_info where mb_id = ?";
						
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, id);
						
						rs = pstmt.executeQuery();
					
						if(rs.next()) {
							check = 1;
								
						}else {
							check=-1;
						}
					conn.commit();
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
					return check;
				}

	}