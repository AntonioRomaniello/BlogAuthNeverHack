package corso.java.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.GenerationTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Comment")
@Builder(setterPrefix = "with")
public class CommentEntity { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String title;
	@Column(length = 50, nullable = false)
	private String content;
	@ManyToOne
	private ArticleEntity article;
	@ManyToOne
	private AuthorEntity author;
	@Column(length = 50, nullable = false)
	private LocalDate date;
	
	

}
