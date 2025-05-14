package corso.java.services;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import corso.java.dto.AuthorDto;
import corso.java.entities.AuthorEntity;
import corso.java.repositories.AuthorRepository;
@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	private AuthorEntity costruisciDaDto(AuthorDto a) {
		return AuthorEntity.builder().withUsername(a.getUsername())
		.withEmail(a.getEmail())
		.withPassword(a.getPassword())
		.withId(a.getId())
		.withGender(a.getGender())
		.withBirthDate(a.getBirthDate())
		.build();
	}
	
	private AuthorDto costruisciDaEntity(AuthorEntity a) {
		return AuthorDto.builder().withUsername(a.getUsername())
		.withEmail(a.getEmail())
		.withPassword(a.getPassword())
		.withId(a.getId())
		.withGender(a.getGender())
		.withBirthDate(a.getBirthDate())
		.build();
	}
	
	
	@Override
	public void addAuthor(AuthorDto authorDto) {
		AuthorEntity author = costruisciDaDto(authorDto);
		authorRepository.save(author);
	}

	@Override
	public List<AuthorDto> getAllAuthors() {
		
		try {
			List<AuthorDto> authors = authorRepository.findAll().stream()
					.map(a -> costruisciDaEntity(a)).toList();
			return authors;
		}catch (Exception e) {
			throw new ServiceException("Error! The List is empty!");
		}

	}

	@Override
	public AuthorDto getAuthorByUsername(String username) {
		AuthorEntity author = authorRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Author not found!"));
		AuthorDto ae = costruisciDaEntity(author);
		return ae;
	}

	@Override
	public void updateAuthor(AuthorDto author) {
		AuthorEntity ae = authorRepository.findById(author.getId()).orElseThrow(() -> new RuntimeException("Author not found!"));
		ae.setEmail(author.getEmail());
		ae.setPassword(author.getPassword());
		authorRepository.save(ae);	
	}
	@Override
	public void deleteAuthor(int authorId) {
		try {
			authorRepository.deleteById(authorId);
		} catch (Exception e) {
			throw new ServiceException("Error! Author with ID: "+authorId+" Not Found!");
		}
	}
}
