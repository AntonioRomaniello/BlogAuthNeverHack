package corso.java.services;

import java.util.List;

import corso.java.dto.AuthorDto;

public interface AuthorService {
	
	public void addAuthor(AuthorDto authorDto);
	public List<AuthorDto> getAllAuthors();
	public AuthorDto getAuthorByUsername(String username);
	public void updateAuthor(AuthorDto author);
	public void deleteAuthor(int authorId);
	
}
