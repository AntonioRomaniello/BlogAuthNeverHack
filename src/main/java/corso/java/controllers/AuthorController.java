package corso.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.dto.AuthorDto;
import corso.java.services.AuthorServiceImpl;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	
	@Autowired
	AuthorServiceImpl authorService;
	
	@GetMapping("/all")
	public ResponseEntity<List<AuthorDto>> getAllAuthors(){
		return ResponseEntity.ok(authorService.getAllAuthors());
	}
	
	@PostMapping
	public ResponseEntity<AuthorDto> addAuthors(@RequestBody AuthorDto a){
		authorService.addAuthor(a);
		return ResponseEntity.ok(a);
	}

}
