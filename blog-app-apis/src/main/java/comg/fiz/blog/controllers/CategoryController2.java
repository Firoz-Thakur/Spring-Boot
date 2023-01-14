package comg.fiz.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comg.fiz.blog.payloads.ApiResponse;
import comg.fiz.blog.payloads.CategoryDto;
import comg.fiz.blog.services.CategoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController2 {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto createCategory =this.categoryService.createCategory(categoryDto);
		return ResponseEntity.ok(createCategory);
	}
	
	@PutMapping("/{cat_id}")
	public ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer cat_id)
	{
		CategoryDto createCategory =this.categoryService.updateCategory(categoryDto,cat_id);
		return ResponseEntity.ok(createCategory);
	}
	
	
	@GetMapping("/{cat_id}")
	public ResponseEntity<CategoryDto>getCategory(@PathVariable Integer cat_id)
	{
		CategoryDto createCategory =this.categoryService.getCategory(cat_id);
		return ResponseEntity.ok(createCategory);
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		List<CategoryDto> createCategory =this.categoryService.getAllCategory();
		return ResponseEntity.ok(createCategory);
	}
	@DeleteMapping("/{cat_id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer cat_id)
	{
		this.categoryService.deleteCategory(cat_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully !!",false),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
