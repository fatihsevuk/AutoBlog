package com.fatih.blogproject.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.fatih.blogproject.entity.User;
import com.fatih.blogproject.model.RegisterForm;
import com.fatih.blogproject.service.NotifiacationService;
import com.fatih.blogproject.service.UserService;
import com.fatih.blogproject.utility.Hashing;

@Controller
public class RegisterController {

	private UserService userService;
	private NotifiacationService notifyService;

	public RegisterController(UserService userService, NotifiacationService notifyService) {
		this.userService = userService;
		this.notifyService = notifyService;
	}

	@RequestMapping("/register")
	public ModelAndView registerPage(){

		return new ModelAndView("register", "registerForm", new RegisterForm());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			notifyService.addErrorMessage("Lütfen formu hatasız doldurun!");

			return "register";

		} else if (!userService.registerAuthenticate(registerForm.getUsername(), registerForm.getEmail())) {

			notifyService.addErrorMessage("Bu kullanıcı adı yada email başka bir kullancıya ait!");

			return "register";

		} else {

			User user = new User();

			user.setUsername(registerForm.getUsername());

			user.setEmail(registerForm.getEmail());
			
			user.setTitle(registerForm.getTitle());
			
			user.setDescription(registerForm.getDescription());
			

			if (Objects.equals(registerForm.getPassword(), registerForm.getRePassword())) {

				String password = Hashing.hashPassword(registerForm.getPassword());

				user.setPasswordHash(password);

			} else {

				notifyService.addErrorMessage("Girilen parolalar uyuşmuyor.");

				return "register";
			}

			userService.create(user);

			notifyService.addInfoMessage("Kayıt başarılı lütfen giriş yap.");

			return "redirect:/login";

		}

	}

}
