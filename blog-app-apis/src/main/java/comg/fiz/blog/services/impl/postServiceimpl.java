package comg.fiz.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import comg.fiz.blog.entities.Category;
import comg.fiz.blog.entities.Post;
import comg.fiz.blog.entities.User;
import comg.fiz.blog.exceptions.ResourceNotFoundException;
import comg.fiz.blog.payloads.PostDto;
import comg.fiz.blog.payloads.PostResponse;
import comg.fiz.blog.repositories.CategoryRepo;
import comg.fiz.blog.repositories.PostRepo;
import comg.fiz.blog.repositories.UserRepo;
import comg.fiz.blog.services.PostService;

@Service
public class postServiceimpl implements PostService {

	@Autowired
	PostRepo postRepo;	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	
	@Override
	public PostDto CreatePost(PostDto postDto,Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","UserId",userId));
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		this.postRepo.save(post);
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
//		Post post = this.postRepo.findById(postId).orElseThrow(()->new  ResourceNotFoundException("Post","Id",postId);
//		post.setImageName("default.png");
//		post.setDate(new Date());
//		post.set
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle());
		this.postRepo.save(post);
		return this.modelMapper.map(post,PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
		this.postRepo.delete(post);  		
	}

	@Override
	public PostResponse getAllpost(Integer pageNumber, Integer pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost = this.postRepo.findAll(page);
		List<Post>posts=pagePost.getContent();
		List<PostDto> postDtos = posts.stream().map(post ->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse= new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setLastPage(pagePost.isLast());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setTotalElement(pagePost.getTotalElements());
		postResponse.setTotalPage(pagePost.getTotalPages());
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		
	   Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
	   return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category id",categoryId));
		List<Post>posts=this.postRepo.findByCategory(category);
		return posts.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
		List<Post>posts=this.postRepo.findByUser(user);
		return posts.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
