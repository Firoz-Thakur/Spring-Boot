package comg.fiz.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import comg.fiz.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

	
}
