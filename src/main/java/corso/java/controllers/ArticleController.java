package corso.java.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.dto.ArticleDto;
import corso.java.entities.ArticleEntity;
import corso.java.repositories.ArticleRepository;
import corso.java.services.ArticleService;

@RestController
@RequestMapping ("/api/article")
public class ArticleController {
	private ArticleService articleService;
	@PostMapping("/addArticle")
	public ResponseEntity<ArticleDto> addArticle(@RequestBody ArticleDto insertArticle) {
		return ResponseEntity.ok(articleService.addArticle(insertArticle));
				
	};
	
	@GetMapping ("/showAll")
	public ResponseEntity<List<ArticleDto>> showAllArticle(){
		return ResponseEntity.ok(articleService.showAllArticle());
		
		
		
	};
	

}
