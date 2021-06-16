package club.adventurehunter.controller;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import club.adventurehunter.domain.UserBean;
import club.adventurehunter.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource messageSource;
	@RequestMapping(path = { "/secure/login.controller" })
	public String method(String user_login, String user_pass, Model model, HttpSession session, Locale locale) {  //接受資料

		
	//驗證資料	
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		if(user_login==null || user_login.length()==0) {
			errors.put("username", 	messageSource.getMessage("login.username.required", null, locale ));
		}
		if(user_pass==null || user_pass.length()==0) {
			errors.put("password", 	messageSource.getMessage("login.password.required", null, locale ));
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "/secure/login";
		}
		//呼叫model
		UserBean bean = userService.login(user_login, user_pass);
		
		//根據model執行結果，導向view
		if(bean==null) {
			errors.put("password", messageSource.getMessage("login.failed", null, locale ));
			return "/secure/login";

		} else {
			session.setAttribute("user", bean);
			return "redirect:/index";
		}
		
	}

}