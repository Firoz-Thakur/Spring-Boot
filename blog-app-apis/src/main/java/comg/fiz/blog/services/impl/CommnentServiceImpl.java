package comg.fiz.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comg.fiz.blog.entities.Comment;
import comg.fiz.blog.entities.Post;
import comg.fiz.blog.exceptions.ResourceNotFoundException;
import comg.fiz.blog.payloads.CommentDto;
import comg.fiz.blog.repositories.CommentRepo;
import comg.fiz.blog.repositories.PostRepo;
import comg.fiz.blog.services.PostService;
import comg.fiz.blog.services.commentService;

@Service
public class CommnentServiceImpl implements commentService {

	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		
		Post post = this.postRepo.findById(postId).orElseThrow(() ->new  ResourceNotFoundException("Post","post ID",postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		this.commentRepo.save(comment);
		return this.modelMapper.map(comment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(() ->new  ResourceNotFoundException("Comment","Comment ID",commentId));
		this.commentRepo.delete(comment);
	}

	
	
	
	
	
}
