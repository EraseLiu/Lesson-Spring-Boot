package readinglist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity /* 注解表明它是一个 JPA 实体 */
public class Book {

	/* id 属性加了 @Id 和 @GeneratedValue注解, 说明这个字段是实体的唯一标识, 并且这个字段的值是自动生成的. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String reader;

	private String isbn;

	private String title;

	private String author;

	private String description;

	@Override
	public String toString() {
		return String.format("Book [id=%s, reader=%s, isbn=%s, title=%s, author=%s, description=%s]", id, reader, isbn,
				title, author, description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
