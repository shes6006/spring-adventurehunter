package club.adventurehunter.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.adventurehunter.dao.UserDAO;
import club.adventurehunter.domain.UserBean;

//我是controller店員的主管，專門指導controller可以做什麼事情
//DAO做完Bean的分類後，我把流程製作出來，前面的controller會幫我跟客人聯繫，
//例如我會告訴controller如果客人連帳號密碼都沒有準備好的話，就叫他回去準備吧！
//或是客人真的想改密碼的話，沒關係，我就直接跟controller講給他換一下好了！


@Service
@Transactional
public class UserService {
	@Autowired
	private UserDAO userDAO = null;

	public UserBean login(String user_login, String user_pass) {
		UserBean bean = userDAO.select(user_login);
		if (bean != null) {
			if (user_pass != null && user_pass.length() != 0) {
				String pass = bean.getUser_pass();
				String temp = user_pass;
				if (pass.equals(temp)) {
					return bean;
				}
			}
		}
		return null;
	}

	public boolean changePassword(String user_login, String oldPassword, String newPassword) {
		UserBean bean = this.login(user_login, oldPassword);
		if (bean != null) {
			String temp = newPassword;
			return userDAO.update(bean.getID(), user_login, temp, bean.getUser_nicename(), 
					bean.getUser_email(), bean.getBirth(), bean.getUser_url(), bean.getUser_registered(), bean.getUser_activation_key(), 
					bean.getUser_status(), bean.getDisplay_name());
		}
		return false;
	}
}