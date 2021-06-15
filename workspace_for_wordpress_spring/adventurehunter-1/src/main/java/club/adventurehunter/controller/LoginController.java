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

//dispatcher變成controller 
//我是後面帶位進2樓的服務員
//我也會說多國語言喔！
//我主要是讓客人入場前做好一些身份驗證！

//LoginServlet 換成 LoginController 
//用作登入時先做第一部校驗
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
//			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			
//			String path = request.getContextPath();
//			response.sendRedirect(path+"/index.jsp");
			return "redirect:/index";
		}
		
	}

}