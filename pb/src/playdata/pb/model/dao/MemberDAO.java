package playdata.pb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import playdata.pb.model.vo.Member;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean loginCheck(String id, String pass) {// 1.로그인 2.회원정보 수정 시 현재 비밀번호와 같은지 check
		try {
			connect();
			String sql = "select count(*) from member  where id=? and pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			rs.next();
			int t = rs.getInt(1);
			if(t>0)
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean insertJoin(Member m) {// 회원가입
		try {
			connect();
			String sql = "insert into member (id,pass,ename,email,genre)"
					   + " values (?,?,?,?,?)"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPass());
			pstmt.setString(3, m.getEname());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getGenre());
			int t = pstmt.executeUpdate();
			if (t > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public Member findIdPass(String email) { //아이디, 비밀번호 찾기
	    try {
	         connect();
	         String sql = "select id,pass from member where email = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, email);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	 Member m = new Member();
	        	 	m.setId(rs.getString("id"));
	        	 	m.setPass(rs.getString("pass"));
	        	 return m;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return null;
	}

	public Member selectMypage(String id) { //마이페이지에 보일 이름, 등급, 포인트, 캐쉬
		try {
			connect();
			String sql = "select ename, egrade, point,cash from member"
						+ " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString("ename"),
								  rs.getInt("egrade"),
								  rs.getInt("point"), 
								  rs.getInt("cash"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public String selectGenre(String id) {//아이디에 해당하는 장르 뿌려주기
	    try {
	         connect();
	         String sql = "select genre from member where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         rs.next();
	         return rs.getString("genre");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return null;
	}
	
	public Member selectMemberInfo(String id) {//회원정보 수정 클릭시 보일 정보
		try {
			connect();
			String sql = "select ename, email,genre from member"
						+ " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member m  = new Member();
					   m.setId(id);
					   m.setEname(rs.getString("ename"));
					   m.setEmail(rs.getString("email"));
					   m.setGenre(rs.getString("genre"));
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public ArrayList<Member> selectMember(String id){
		ArrayList<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "select ename, email,genre from member"
						+ " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member m  = new Member();
					   m.setId(id);
					   m.setEname(rs.getString("ename"));
					   m.setEmail(rs.getString("email"));
					   m.setGenre(rs.getString("genre"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public ArrayList<Member> selectAllMember(){
		ArrayList<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "select id, ename, email,genre from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m  = new Member();
				m.setId(rs.getString("id"));
				m.setEname(rs.getString("ename"));
				m.setEmail(rs.getString("email"));
				m.setGenre(rs.getString("genre"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public boolean updateMemberInfo(String id,String pass) {//비밀번호 변경
	    try {
	         connect();
	         String sql = "update member set pass=? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, pass);
	         pstmt.setString(2, id);
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean dupliCheck(String checkStr) { //id나 email의 중복체크
	    String sql;
		try {
	         connect();
	         if(checkStr.contains("@")) {
	        	 sql = "select count(*) as count from member where email=?";	        	 
	         }else {
	        	 sql = "select count(*) as count from member where id=?";
	         }
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, checkStr);
	         rs = pstmt.executeQuery();
	         rs.next();
	       
	         int t = rs.getInt("count");
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	   return false;
	}
	
	public boolean updateGenre(String id,String genre) {//장르 변경 
	    try {
	         connect();
	         String sql = "update member set genre=? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, genre);
	         pstmt.setString(2, id);
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean updateCashCharge(String id,int cash) {//cash충전하기 
	    try {
	         connect();
	         String sql = "update member set cash=cash+? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, cash);
	         pstmt.setString(2, id);
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean updateAfterPay(Member m) {//id, cash,point 받아 업데이트하기
		try {
	         connect();
	         String sql = "update member set cash = cash-?, point = point-?"
	         		+ " where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, m.getCash());
	         pstmt.setInt(2, m.getPoint());
	         pstmt.setString(3, m.getId());
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }	
	    return false;
	}
	
	public int selectGrade(String id) {//아이디를 이용하여 등급 알아내기
	    try {
	         connect();
	         String sql = "select egrade from member where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	 return rs.getInt("egrade");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return 0;
	}
	
	public boolean updateGrade(String id, int egrade) {//아이디에 대한 등급 변경
	    try {
	         connect();
	         String sql = "update member set egrade=? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, egrade);
	         pstmt.setString(2, id);
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public void connect() {
		conn = MyClassDriver.getConnection();
		System.out.println("DB연결");
	}

	public void disconnect() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
