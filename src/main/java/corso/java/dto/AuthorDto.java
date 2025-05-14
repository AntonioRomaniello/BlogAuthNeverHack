package corso.java.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix="with")
public class AuthorDto {
	int id;
	String username;
	String email;
	String password;
	LocalDateTime BirthDate;
	Gender gender;
}
