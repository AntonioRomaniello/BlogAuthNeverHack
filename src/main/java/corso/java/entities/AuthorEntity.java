package corso.java.entities;

import java.time.LocalDate;
import java.util.List;

public class AuthorEntity {
	private int id;
	private String email;
	private String password;
	private String username;
	private LocalDate birthday;
	private Gender gender;
	private List <ArticleEntity>articles;
	
	

}
