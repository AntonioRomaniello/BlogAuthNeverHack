package corso.java.dto;

import java.time.LocalDate;
import java.util.List;

import corso.java.entities.AuthorEntity;
import corso.java.entities.Category;
import corso.java.entities.CommentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class ArticleDto {

	private String title;

	private String content;

	private AuthorEntity author;

	private Category category;

}
