package corso.java.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {
	@Id
	private int id;
	private String email;
	private String password;
	private String username;
	private LocalDate birthday;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@OneToMany
	private List <ArticleEntity>articles;
	
	

}
