package playdata.pb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import playdata.pb.model.vo.History;

public class HistoryDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ArrayList<History> selectHistory(String id) { //멤버용 히스토리 내역 보여주기
	    ArrayList<History> list = new ArrayList<>();
		try {
	         connect();
	         String sql = "select * from history where id=? ";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 list.add(new History(rs.getString("id"),
	        			 			  rs.getInt("isbn"),
	        			 			  rs.getInt("price"),
	        			 			  rs.getInt("clear")));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
		return list;
	}
	
	public ArrayList<History> selectAllHistory() { //관리자용 전체 회원에 관한 히스토리
		 ArrayList<History> list = new ArrayList<>();
			try {
		         connect();
		         String sql = "select * from history";
		         pstmt = conn.prepareStatement(sql);
		         rs = pstmt.executeQuery();
		         while (rs.next()) {
		        	 list.add(new History(rs.getString("id"),
		        			 			  rs.getInt("isbn"),
		        			 			  rs.getInt("price"),
		        			 			  rs.getInt("clear")));
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         disconnect();
		      }
			return list;
	}
	
	public boolean insertHistory(History h) {//히스토리 정보를 받아서 추가
	    try {
	         connect();
	         String sql = "insert into history values (?,?,?,?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, h.getId());
	         pstmt.setInt(2, h.getIsbn());
	         pstmt.setInt(3, h.getPrice());
	         pstmt.setInt(4, h.getClear());
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean updateHistory(History h) {//히스토리 정보 받아서  회원 등급에 따른 price와 clear 업데이트
	    try {
	         connect();
	         String sql = "update history set price= ?, clear=? where id=? and isbn=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, h.getPrice());
	         pstmt.setInt(2, h.getClear());
	         pstmt.setString(3, h.getId());
	         pstmt.setInt(4, h.getIsbn());
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public int countClear(String id) {//해당 회원의 완독한 갯수 알려주기
	    try {
	         connect();
	         String sql = "select count(*) as count from history"
	         		+ " where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         rs.next();
	         return rs.getInt("count");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
		return 0;
	}
	
	public void connect() {
		conn = new MyClassDriver().getConnection();
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
