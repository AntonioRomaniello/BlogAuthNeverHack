package corso.java.dto;

import java.time.LocalDate;

import corso.java.entities.ArticleEntity;
import corso.java.entities.AuthorEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "with")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	
	
	private String title;
	
	private String content;
	
	private ArticleEntity article;
	
	private AuthorEntity author;
	

}
