package club.adventurehunter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCTest {
	
	
	public static void main(String[] args) {
		
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://34.80.240.158:3306/wordpress", prop);
			System.out.println("ok4");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
