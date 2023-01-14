package comg.fiz.blog.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PostResponse {
	
	List<PostDto>content;
	private int pageSize;
	private long totalPage;
	private int pageNumber;
	private long totalElement;
	private boolean lastPage;
}
