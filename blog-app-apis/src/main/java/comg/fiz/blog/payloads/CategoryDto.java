package comg.fiz.blog.payloads;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {

	
	private Integer categoryId;
	@NotEmpty
	@Size(min = 4,message = "minimum size shouyld be 4")
	private String categoryTitle;
	@NotEmpty
	@Size(min = 10,message = "minimum size should be 10")
	private String categoryDescription;
	
	
}
