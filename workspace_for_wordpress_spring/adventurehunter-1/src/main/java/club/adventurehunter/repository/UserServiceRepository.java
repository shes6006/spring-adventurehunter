package club.adventurehunter.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.adventurehunter.domain.UserBean;

@Service
@Transactional
public class UserServiceRepository {
	@Autowired
	private UserRepository CustomerRepository = null;
	//	private CustomerDAO customerDao = null;
	public UserBean login(String username, String password) {
		Optional<UserBean> optional = CustomerRepository.findById(username);

		if (optional.isEmpty()) {
			UserBean bean = optional.get(); //從optional拿出bean
			if (password != null && password.length() != 0) {
				String pass = bean.getUser_pass();
				if (pass.equals(password)) {
					return bean;
				}
			}
		}
		return null;
	}

	public boolean changePassword(String username, String oldPassword, String newPassword) {
		UserBean bean = this.login(username, oldPassword);
		
		if (bean != null) {
			bean.setUser_pass(newPassword);
			bean = CustomerRepository.save(bean);
			return true;
		}	

		return false;
	}
}