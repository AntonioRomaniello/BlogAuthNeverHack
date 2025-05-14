package corso.java.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.dto.AuthorDto;
import corso.java.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>{

	public Optional <AuthorEntity > findByUsername(String username);
}
