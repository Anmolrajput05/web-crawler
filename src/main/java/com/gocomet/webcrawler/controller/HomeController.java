package com.gocomet.webcrawler.controller;

import java.security.Principal;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gocomet.webcrawler.entity.Article;
import com.gocomet.webcrawler.entity.Role;
import com.gocomet.webcrawler.entity.User;
import com.gocomet.webcrawler.repository.ArticleRepository;
import com.gocomet.webcrawler.service.RoleService;
import com.gocomet.webcrawler.service.UserService;
import com.gocomet.webcrawler.service.WebsiteCrawlerService;

@Controller
public class HomeController {

	@Autowired
	private WebsiteCrawlerService websiteCrawlerService;

	@Autowired
	private ArticleRepository articleRepository;
	

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String list(Model model, Principal principal) {
		model.addAttribute("LoggedInUser", principal != null ? principal.getName() : null);
		return "index";
	}

	@RequestMapping("/medium")
	public String getArticlesByTag(Model model, Principal principal) {
		model.addAttribute("LoggedInUser", principal != null ? principal.getName() : null);
		return "list-articles";
	}

	@RequestMapping("/medium/search")
	public String getArticlesByTag(@RequestParam("tag") String tag, Model model, Principal principal) {
		model.addAttribute("LoggedInUser", principal != null ? principal.getName() : null);
		if (tag.trim().isEmpty()) {
			return "list-articles";
		} else {
			Set<Article> articles = websiteCrawlerService.getArticlesByTag(tag);
			model.addAttribute("Articles", articles);
			model.addAttribute("Tag", tag);
			return "list-articles";
		}
	}

	
	@RequestMapping(path="/res", method = RequestMethod.POST)
    public String registersave(@RequestParam("email") String useremail,@RequestParam("password") String userpassword) {
		Role r = new Role();	
		r.setName("USER");
		roleService.save(r);
		User u = new User();
		u.setUsername(useremail);
		u.setPassword(userpassword);
		userService.save(u);
        return "index";
    }
	
	@RequestMapping("/medium/view")
	public String getArticleByLink(@RequestParam("creator") String creator, @RequestParam("title") String title,
			Model model, Principal principal) {
		model.addAttribute("LoggedInUser", principal != null ? principal.getName() : null);
		Article article = websiteCrawlerService.fillArticle(articleRepository.getArticleByCreatorTitle(creator, title));
		model.addAttribute("Article", article);
		return "view-article";
	}
}
