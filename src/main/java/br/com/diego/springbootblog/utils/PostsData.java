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
		post1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam quam massa, pretium eget sollicitudin et, commodo sit amet tortor. Maecenas vel varius metus. Nunc bibendum tortor purus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas elementum erat at quam efficitur ultrices. Nunc fermentum feugiat accumsan."
				+ "Fusce efficitur, libero eget accumsan dapibus, lacus nibh volutpat arcu, sed ultrices erat ex ac mi. Proin non vulputate est. Nullam mattis, ipsum euismod gravida feugiat, ex mauris elementum augue, eget auctor velit dolor quis augue. Donec et tempor mi. Donec elementum, nulla sed placerat maximus, libero nisl rhoncus ante, quis rutrum elit nulla non nulla. Nunc metus tortor, tristique ac mi malesuada, malesuada egestas risus. Duis risus diam, ullamcorper sit amet aliquet id, porttitor eu nisi. Maecenas porta accumsan scelerisque."
				+ "Nullam libero nibh, ornare nec dictum id, tristique at ante. Maecenas sagittis fringilla mattis. Donec consequat ut mi eget consequat. Duis dapibus porta ornare. Nulla eleifend sagittis feugiat. Quisque tincidunt urna eget velit porttitor fringilla. Phasellus sit amet semper nibh. Maecenas facilisis justo lorem. Donec rhoncus lorem dolor, dictum auctor erat condimentum ut. Curabitur nec tempor elit, at vestibulum ipsum. Nam non gravida arcu. Nulla tincidunt sapien non ex venenatis, non vulputate lectus bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ante magna, efficitur non sapien non, accumsan tempus dolor. Suspendisse ac nunc efficitur, ullamcorper sapien quis, consectetur felis." );
		
		Post post2 = new Post();
		post2.setAuthor("Daniel");
		post2.setDatePost(LocalDate.now());
		post2.setTitle("Sneackers");
		post2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam quam massa, pretium eget sollicitudin et, commodo sit amet tortor. Maecenas vel varius metus. Nunc bibendum tortor purus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas elementum erat at quam efficitur ultrices. Nunc fermentum feugiat accumsan."
				+ "Fusce efficitur, libero eget accumsan dapibus, lacus nibh volutpat arcu, sed ultrices erat ex ac mi. Proin non vulputate est. Nullam mattis, ipsum euismod gravida feugiat, ex mauris elementum augue, eget auctor velit dolor quis augue. Donec et tempor mi. Donec elementum, nulla sed placerat maximus, libero nisl rhoncus ante, quis rutrum elit nulla non nulla. Nunc metus tortor, tristique ac mi malesuada, malesuada egestas risus. Duis risus diam, ullamcorper sit amet aliquet id, porttitor eu nisi. Maecenas porta accumsan scelerisque."
				+ "Nullam libero nibh, ornare nec dictum id, tristique at ante. Maecenas sagittis fringilla mattis. Donec consequat ut mi eget consequat. Duis dapibus porta ornare. Nulla eleifend sagittis feugiat. Quisque tincidunt urna eget velit porttitor fringilla. Phasellus sit amet semper nibh. Maecenas facilisis justo lorem. Donec rhoncus lorem dolor, dictum auctor erat condimentum ut. Curabitur nec tempor elit, at vestibulum ipsum. Nam non gravida arcu. Nulla tincidunt sapien non ex venenatis, non vulputate lectus bibendum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec ante magna, efficitur non sapien non, accumsan tempus dolor. Suspendisse ac nunc efficitur, ullamcorper sapien quis, consectetur felis." );
		
		postList.add(post1);
		postList.add(post2);
		
		
		for(Post post: postList) {
			Post postSaved = postRepository.save(post);
			System.out.println(postSaved.getId());
		}
	}

}
