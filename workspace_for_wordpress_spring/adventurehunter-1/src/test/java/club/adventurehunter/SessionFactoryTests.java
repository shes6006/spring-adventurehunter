package club.adventurehunter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SessionFactoryTests {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testSessionFactory() {
		
		Session session = sessionFactory.openSession();
		
		List result = session.createNativeQuery("select * from dept").list(); //先select抓出所有
		
		for (Object obj: result) {
			Object[] array = (Object[]) obj;
			System.out.println("SessionFactory" + array[0]+ ":" + array[1]);
		}
	}
}
