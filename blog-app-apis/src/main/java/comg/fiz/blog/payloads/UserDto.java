package comg.fiz.blog.payloads;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto{
	
	private int id;
	@NotEmpty
	@Size(min = 4,message = "Minimum size should be not less than 4 !!!")
	private String name;
	@Email (message = "Email Message is not valid !!!")
	private String email;
	@NotEmpty
	@Size(min = 3,max = 10 ,message = "Password should be of minim 3 and maximum size of 10")
	private String password;
	@NotEmpty
	private String about;
}