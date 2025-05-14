package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.entities.ArticleEntity;
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

}
