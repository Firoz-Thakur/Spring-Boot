package comg.fiz.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import comg.fiz.blog.payloads.ApiResponse;
import comg.fiz.blog.payloads.CommentDto;
import comg.fiz.blog.payloads.PostDto;
import comg.fiz.blog.services.commentService;

@Controller
@RequestMapping("/api")
public class commentController {

	@Autowired
	private commentService commentService;
	
	
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId)
	{
		
		CommentDto commentDto2 = this.commentService.createComment(commentDto,postId);
		return new  ResponseEntity(commentDto2,HttpStatus.CREATED);
	}
	
	@PostMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(
			@PathVariable Integer commentId)
	{
		
		this.commentService.deleteComment(commentId);
		return new  ResponseEntity( new ApiResponse("Delete successfull !!",true),HttpStatus.OK);
	}
	
	
	
	
}
