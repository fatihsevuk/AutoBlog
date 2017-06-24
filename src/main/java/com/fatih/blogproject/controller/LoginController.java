package com.fatih.blogproject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fatih.blogproject.model.LoginForm;
import com.fatih.blogproject.service.NotifiacationService;
import com.fatih.blogproject.service.UserService;

@Controller
public class LoginController {

	public static final String USERNAME_SESSION_KEY = "usernameSessionKey";

	private UserService userService;
	private NotifiacationService notifyService;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	public LoginController(UserService userService, NotifiacationService notifyService) {
		this.userService = userService;
		this.notifyService = notifyService;
	}

	@RequestMapping("/login")
	public ModelAndView loginPage() {

		return new ModelAndView("login", "loginForm", new LoginForm());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			notifyService.addErrorMessage("Lütfen formu hatasız doldurun!");
			return "login";
		} else if (!userService.loginAuthenticate(loginForm.getUsername(), loginForm.getPassword())) {

			notifyService.addErrorMessage("Kullanıcı adı yada parola hatalı.");
			return "login";

		} else {
			
			httpSession.setAttribute(USERNAME_SESSION_KEY, loginForm.getUsername());
			notifyService.addInfoMessage("Giriş başarılı");
			return "redirect:/";

		}

	}
	
	@RequestMapping(value = "/logout")
	public String logout(){
		
		httpSession.removeAttribute(USERNAME_SESSION_KEY);
		System.out.println(httpSession.getAttribute(USERNAME_SESSION_KEY));
		return "redirect:/login";
	}

}
