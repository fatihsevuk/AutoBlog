package com.fatih.blogproject.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fatih.blogproject.entity.Post;
import com.fatih.blogproject.entity.User;
import com.fatih.blogproject.model.CreatePostForm;
import com.fatih.blogproject.service.NotifiacationService;
import com.fatih.blogproject.service.PostService;
import com.fatih.blogproject.service.UserService;

@Controller
public class PostController {

	private NotifiacationService notifyService;
	private PostService postService;
	private UserService userService;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	public PostController(NotifiacationService notifyService, PostService postService, UserService userService) {
		this.notifyService = notifyService;
		this.postService = postService;
		this.userService = userService;
	}

	@RequestMapping("/create")
	public ModelAndView createPage() {

		return new ModelAndView("create", "createForm", new CreatePostForm());
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("createForm") CreatePostForm createForm, BindingResult bindingResult) {

		String loggedUser = (String) httpSession.getAttribute("usernameSessionKey");

		if (loggedUser != null) {

			User user = userService.findByUsername(loggedUser);

			if (user != null) {

				if (bindingResult.hasErrors()) {

					notifyService.addErrorMessage("Lütfen alanları hatasız doldurun.");

					return "create";

				} else {
					Post post = new Post();
					post.setAuthor(user);
					post.setBody(createForm.getBody());
					
					if(createForm.getCategory()==null || createForm.getCategory()==""){
						post.setCategory("Kategorisiz");
					}else{
						post.setCategory(createForm.getCategory());
					}
					
					
					System.out.println(createForm.getCategory());

					post.setDate(new Date());
					post.setDraft(createForm.isDraft());
					post.setTitle(createForm.getTitle());

					postService.create(post);

					notifyService.addInfoMessage("Yeni yazı yayınlandı");
					
					return "redirect:/";

				}

			} else {
				notifyService.addInfoMessage("Lütfen giriş yap...");
				return "redirect:/login";
			}

		}else{
			notifyService.addInfoMessage("Lütfen giriş yap...");
			return "redirect:/login";
		}

	}
}
