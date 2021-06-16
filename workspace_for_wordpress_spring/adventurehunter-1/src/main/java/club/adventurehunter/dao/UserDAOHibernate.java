package club.adventurehunter.dao;
import java.util.Date;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import club.adventurehunter.domain.UserBean;

@Repository
public class UserDAOHibernate implements UserDAO {

	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}

	@Override
	public UserBean select(String user_login) {
			if(user_login!=null) {
				return this.getSession().get(UserBean.class, user_login);
			}
			return null;	
		}

	@Override
	public boolean update(Long ID, String user_login, String user_pass, String user_nicename, String user_email,
			Date birth, String user_url, Date user_registered, String user_activation_key, Integer user_status,
			String display_name) {
			if(user_login!=null) {
				UserBean result = this.getSession().get(UserBean.class, user_login);
				if(result!=null) {
					result.setUser_pass(user_pass);
					result.setUser_nicename(user_nicename);
					result.setUser_email(user_email);
					result.setBirth(birth);
					result.setUser_url(user_url);
					result.setUser_registered(user_registered);
					result.setUser_activation_key(user_activation_key);
					result.setUser_status(user_status);
					result.setDisplay_name(display_name);
					return true;
				}	
		}
			return false;
	}

	
}
    
