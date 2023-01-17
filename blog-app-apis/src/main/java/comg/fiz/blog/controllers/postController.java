package comg.fiz.blog.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comg.fiz.blog.entities.Post;
import comg.fiz.blog.payloads.ApiResponse;
import comg.fiz.blog.payloads.PostDto;
import comg.fiz.blog.payloads.PostResponse;
import comg.fiz.blog.repositories.PostRepo;
import comg.fiz.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class postController {
	

	@Autowired
	PostService postService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId, @PathVariable Integer categoryId)
	{
		PostDto createpost = this.postService.CreatePost(postDto, userId, categoryId);
		return new ResponseEntity(createpost,HttpStatus.CREATED);
	}
	
	// get post by user
	@GetMapping({"/user/{userId}/posts"})
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId)
	{
		List<PostDto>posts= this.postService.getPostByUser(userId);
		return new ResponseEntity(posts,HttpStatus.OK);
	}
	//get post by  user id 
	@GetMapping({"/category/{categoryId}/posts"})
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto>posts= this.postService.getPostByCategory(categoryId);
		return new ResponseEntity(posts,HttpStatus.OK);
	}
	//get all post 
	
	@GetMapping({"/posts"})
	public ResponseEntity<List<PostDto>> getAllpost(@RequestParam(value = "pageNumber" ,defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10",required=false) Integer pageSize,
			@RequestParam(value="sortBy",defaultValue = "postId",required = false) String sortBy,
			@RequestParam(value="sortDir",defaultValue = "asc",required = false) String sortDir
			)
	{
		
		PostResponse postResponse= this.postService.getAllpost(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity(postResponse,HttpStatus.OK);
	}
	
	@GetMapping({"/posts/{postId}"})
	public ResponseEntity<PostDto> getpostById(@PathVariable Integer postId)
	{
		PostDto postDto= this.postService.getPostById(postId);
		return new ResponseEntity(postDto,HttpStatus.OK);
	}
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId)
	{
		PostDto updateDto = this.postService.updatePost(postDto,postId);
		return new ResponseEntity(updateDto,HttpStatus.OK);
	}
	@DeleteMapping({"/posts/{postId}"})
	public ResponseEntity<ApiResponse> deletepostById(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		return ResponseEntity.ok(new ApiResponse("Post is Succesfully delete ",true));
	}
	
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable String keyword)
	{
		List<PostDto> posts = this.postService.searchPosts(keyword);
		return new  ResponseEntity(posts,HttpStatus.OK);
	}
}


