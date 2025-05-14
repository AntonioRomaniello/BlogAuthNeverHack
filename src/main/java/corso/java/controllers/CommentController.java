package corso.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import corso.java.dto.CommentDto;
import corso.java.services.CommentService;

@RestController
@RequestMapping ("/api/comment")

public class CommentController {
	@Autowired
	CommentService commentService; 
	@PostMapping ("/addComment")
	public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto comment) {
		return ResponseEntity.ok(commentService.addComment(comment));
	}
	;
	@GetMapping ("/showComment")
	public ResponseEntity <List<CommentDto>> showAllCommentsByArticleId(@RequestParam int id){
		return ResponseEntity.ok(commentService.showAllCommentsByArticleId(id));
		
	}

}
