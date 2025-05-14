package corso.java.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Article")
@Builder(setterPrefix = "with")
public class ArticleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String title;
	@Column(length = 50, nullable = false)
	private String content;
	
	@ManyToOne
	private AuthorEntity author;
	@Enumerated(EnumType.STRING)
	private Category category;
	@OneToMany(mappedBy="article")
	private List<CommentEntity> comments;
	@Column(nullable = false)
	private LocalDate publishDate;

}
