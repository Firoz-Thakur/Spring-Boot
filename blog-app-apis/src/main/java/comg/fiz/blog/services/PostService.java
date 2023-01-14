package comg.fiz.blog.services;

import java.util.List;

import comg.fiz.blog.entities.Post;
import comg.fiz.blog.payloads.PostDto;
import comg.fiz.blog.payloads.PostResponse;

public interface PostService {

	PostDto CreatePost(PostDto post,Integer userId, Integer CategoryId);

	PostDto updatePost(PostDto post, Integer postId);

	void deletePost(Integer postId);

	PostResponse getAllpost(Integer pageNumber,Integer pageSize);

	PostDto getPostById(Integer postId);

	// get all post by category, one category can have more post
	List<PostDto> getPostByCategory(Integer categoryId);

	// get all post by user
	List<PostDto> getPostByUser(Integer userId);

	List<PostDto> searchPosts(String keyword);
}
