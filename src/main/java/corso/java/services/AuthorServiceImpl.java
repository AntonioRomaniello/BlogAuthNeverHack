package corso.java.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import corso.java.dto.AuthorDto;
import corso.java.entities.AuthorEntity;
import corso.java.entities.Azienda_Entity;
import corso.java.repositories.AuthorRepository;

public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	
	@Override
	public void addAuthor(AuthorDto authorDto) {
		AuthorEntity author =AuthorEntity.builder()
				.withUsername(authorDto.getUsername())
				.withEmail(authorDto.getEmail())
				.withPassword(authorDto.getPassword())
				.withId(authorDto.getId())
				.withGender(authorDto.getGender())
				.withBirthDate(authorDto.getBirthDate())
				.build();
		authorRepository.save(author);
		
	}

	@Override
	public List<AuthorDto> getAllAuthors() {
		
		try {
			List<AuthorDto> authors = authorRepository.findAll().stream().map(a -> AuthorDto.builder().withUsername(a.getUsername())
					.withEmail(a.getEmail())
					.withPassword(a.getPassword())
					.withId(a.getId())
					.withGender(a.getGender())
					.withBirthDate(a.getBirthDate())
					.build()).toList();
			return authors;
		}catch (Exception e) {
			throw new ServiceException("Error!!!!");
		}

	}

	@Override
	public AuthorDto getAuthorByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAuthor(AuthorDto author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAuthor(int authorId) {
		// TODO Auto-generated method stub
		
	}

}
