package comg.fiz.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import comg.fiz.blog.entities.Category;
import comg.fiz.blog.entities.Post;
import comg.fiz.blog.entities.User;

public interface PostRepo  extends JpaRepository<Post, Integer>{

     List<Post> findByUser(User user);
     List<Post> findByCategory(Category category);
}
