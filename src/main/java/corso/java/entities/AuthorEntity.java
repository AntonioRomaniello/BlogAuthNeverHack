package corso.java.entities;

import java.time.LocalDateTime;
import java.util.List;

import corso.java.dto.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="authors")
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix="with")
public class AuthorEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(nullable = false, length = 25)
	String username;
	@Column(nullable = false, length = 50)
	String email;
	@Column(nullable = false, length = 25)
	String password;
	@Column(nullable = false)
	LocalDateTime BirthDate;
	@Column(nullable = false)
	Gender gender;
	@OneToMany(mappedBy="author", cascade = CascadeType.ALL)
	List<ArticleEntity> articles;
	 
	
}
