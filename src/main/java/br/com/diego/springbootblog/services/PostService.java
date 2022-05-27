package br.com.diego.springbootblog.services;

import java.util.List;

import br.com.diego.springbootblog.entities.Post;

public interface PostService {
	
	List<Post> findAll();
	Post findById(Long id);
	Post save(Post post);
}
