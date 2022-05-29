package br.com.diego.springbootblog.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}
