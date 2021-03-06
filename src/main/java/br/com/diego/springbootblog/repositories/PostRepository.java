package br.com.diego.springbootblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diego.springbootblog.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
