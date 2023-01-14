package comg.fiz.blog.services;

import java.util.List;

import comg.fiz.blog.entities.Category;
import comg.fiz.blog.payloads.CategoryDto;

public interface CategoryService {

	
	public CategoryDto createCategory(CategoryDto category);
	public CategoryDto getCategory(Integer categoryId);
	public List<CategoryDto> getAllCategory();
	public CategoryDto updateCategory(CategoryDto category,Integer cat_id);
	public void deleteCategory(Integer id);


	
	
	
	
}
