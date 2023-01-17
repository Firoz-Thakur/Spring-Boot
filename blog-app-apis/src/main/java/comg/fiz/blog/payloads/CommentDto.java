package comg.fiz.blog.payloads;

import comg.fiz.blog.entities.Post;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentDto {

	private Integer commentId;
	private String content;

}
