package br.com.diego.springbootblog.resource;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.diego.springbootblog.entities.Post;
import br.com.diego.springbootblog.services.PostService;

@Controller
@RequestMapping(value = "/blog")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/posts" , method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value = "/post/{id}" , method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = postService.findById(id);
		
		mv.addObject("post", post);
		return mv;
	}
	
	@RequestMapping(value = "/newPosts" , method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/savePost" , method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("messagem", "Verifique se os campos obrigatórios foram preenchidos");
			return "redirect:/blog/newPosts";
		}
		post.setDatePost(LocalDate.now());
		 postService.save(post);
		 return "redirect:/blog/posts";
	}

}
