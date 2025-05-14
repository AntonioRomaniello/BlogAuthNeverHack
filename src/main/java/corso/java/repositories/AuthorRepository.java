package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

}
