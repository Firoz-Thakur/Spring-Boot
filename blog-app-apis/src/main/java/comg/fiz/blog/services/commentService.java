package comg.fiz.blog.services;

import comg.fiz.blog.payloads.CommentDto;

public interface commentService {

	
	public CommentDto createComment(CommentDto commentDto,Integer postId);
	public void deleteComment(Integer commentId);

	
}
