package playdata.pb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import playdata.pb.model.vo.Quiz;

public class QuizDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Quiz selectQuiz() {//��ü ������ ���� ��ȸ
	    try {
	         connect();
	         String sql = "select * from quiz";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 Quiz q = new Quiz(rs.getInt("isbn"),
	        			 		   rs.getString("quiz"),
	        			 		   rs.getString("answer"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return null;
	}
	
	public boolean insertQuiz(Quiz q) {//������ ���� �Է�
	    try {
	         connect();
	         String sql = "insert into quiz values(?,?,?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, q.getIsbn());
	         pstmt.setString(2, q.getQuiz());
	         pstmt.setString(3, q.getAnswer());
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean updateQuiz(Quiz q) {//������ ���� ����  <--���� �ʿ��� �� ���
	    try {
	         connect();
	         String sql = "update quiz set quiz=?,answer=? where isbn=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, q.getQuiz());
	         pstmt.setString(2, q.getAnswer());
	         pstmt.setInt(3, q.getIsbn());
	         
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	
	
	public boolean deleteQuiz(int isbn) {//�ش� ���� ���� ����
	    try {
	         connect();
	         String sql = "delete from quiz where isbn=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, isbn);
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
