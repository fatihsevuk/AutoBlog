package com.fatih.blogproject.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fatih.blogproject.entity.Post;
import com.fatih.blogproject.entity.User;
import com.fatih.blogproject.service.NotifiacationService;
import com.fatih.blogproject.service.PostService;
import com.fatih.blogproject.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

	private PostService postService;
	private UserService userService;
	private NotifiacationService notifyService;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	public HomeController(PostService postService, NotifiacationService notifyService, UserService userService) {
		this.notifyService = notifyService;
		this.postService = postService;
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {

		
		String loggedUser = (String) httpSession.getAttribute("usernameSessionKey");

		if (loggedUser != null) {

			User user = userService.findByUsername(loggedUser);

			if (user != null) {

				List<Post> userPosts = postService.findByAuthor(user);

				List<Post> latest5Posts = postService.findTop5ByAuthor(user);

				List<Post> latest3Posts = userPosts.stream().limit(3).collect(Collectors.toList());

				model.addAttribute("latest5Posts", latest5Posts);
				model.addAttribute("latest3Posts", latest3Posts);
				model.addAttribute("userPosts", userPosts);

				if (user.getTitle() != null) {
					model.addAttribute("title", user.getTitle());

				}

				if (user.getDescription() != null) {
					model.addAttribute("description", user.getDescription());
				}

				return "index";

			} else {
				notifyService.addInfoMessage("Lütfen giriş yap...");
				return "redirect:/login";
			}

		} else {
			notifyService.addInfoMessage("Lütfen giriş yap...");
			return "redirect:/login";
		}
	}

	@RequestMapping("/post/{id}")
	public String post(@PathVariable("id") Long id, Model model) {

		String loggedUser = (String) httpSession.getAttribute("usernameSessionKey");

		if (loggedUser != null) {

			User user = userService.findByUsername(loggedUser);

			List<Post> latest5Posts = postService.findTop5ByAuthor(user);
			Post post = postService.findById(id);

			if (post == null) {
				notifyService.addErrorMessage(id + " Id'li post bulunamadı!");

				return "redirect:/";

			} else {

				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String date = formatter.format(post.getDate());

				model.addAttribute("latest5Posts", latest5Posts);
				model.addAttribute("post", post);
				model.addAttribute("date", date);
				if (user.getTitle() != null) {
					model.addAttribute("title", user.getTitle());

				}

				if (user.getDescription() != null) {
					model.addAttribute("description", user.getDescription());
				}
				notifyService.addInfoMessage(id + " Id'liPost bulundu.");
				return "post";
			}

		} else {
			notifyService.addInfoMessage("Lütfen giriş yap");
			return "redirect:/login";
		}

	}
	
	
}
