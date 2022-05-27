package br.com.diego.springbootblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.diego.springbootblog.entities.Post;
import br.com.diego.springbootblog.repositories.PostRepository;

@Component
public class PostsData {
	
	@Autowired
	PostRepository postRepository;
	
	//@PostConstruct
	public void savePosts() {
		
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAuthor("Diego");
		post1.setDatePost(LocalDate.now());
		post1.setTitle("Diário");
		post1.setText(" A vida em meio a pandemia com escasses de dinheiro" );
		
		Post post2 = new Post();
		post2.setAuthor("Daniel");
		post2.setDatePost(LocalDate.now());
		post2.setTitle("Sneackers");
		post2.setText(" Hoje foi o dia de realizar a compra do meu segundo Jordan" );
		
		postList.add(post1);
		postList.add(post2);
		
		
		for(Post post: postList) {
			Post postSaved = postRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}

}
