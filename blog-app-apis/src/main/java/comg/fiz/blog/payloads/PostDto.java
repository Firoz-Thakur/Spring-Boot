package comg.fiz.blog.payloads;

import java.util.Date;

import comg.fiz.blog.entities.Category;
import comg.fiz.blog.entities.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private String postId;
	private String title;
	private String content;
	private String imageName;
	private Date date;
	private CategoryDto category;
	private UserDto user;	
}
