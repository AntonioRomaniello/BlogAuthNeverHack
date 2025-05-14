package corso.java.services;

import java.util.List;

import corso.java.dto.CommentDto;

public interface CommentService {
	public CommentDto addComment(CommentDto comment);
	public List<CommentDto> showAllCommentsByArticleId(int id);
	

}
