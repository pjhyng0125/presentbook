package playdata.pb.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyClassDriver {
	Connection conn = null;
	Properties pro;
	
	public MyClassDriver() {
		pro = new Properties();
			try {
				pro.load(new FileReader("conn/conn.properties"));
				Class.forName(pro.getProperty("driver"));
				conn = DriverManager.getConnection(pro.getProperty("url"), pro);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public Connection getConnection() {
		return conn;
	}
}
