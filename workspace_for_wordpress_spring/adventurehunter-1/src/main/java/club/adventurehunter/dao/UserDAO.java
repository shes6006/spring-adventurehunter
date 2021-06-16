package club.adventurehunter.dao;
import java.util.Date;

import club.adventurehunter.domain.UserBean;

public interface UserDAO {
	public abstract UserBean select(String user_login);
	
	public abstract boolean update(Long ID, String user_login, String user_pass,
			String user_nicename,  String user_email, Date birth, String user_url,
			Date user_registered, String user_activation_key,
			Integer user_status, String display_name);
}