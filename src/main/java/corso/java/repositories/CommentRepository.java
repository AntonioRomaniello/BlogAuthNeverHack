package corso.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.entities.CommentEntity;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
	public List<CommentEntity> findAllByArticleId(int id);
	

}
