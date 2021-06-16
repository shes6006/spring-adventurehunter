package club.adventurehunter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DataSourceTests {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testDataSource() throws SQLException{
		
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from wp_users");
		
		
		while(rset.next()) {
			String col1 = rset.getString(1);
			String col2 = rset.getString(2);
			System.out.println(col1+":"+col2);
			
		}
		
		rset.close();
		stmt.close();
		conn.close();
	}
}
