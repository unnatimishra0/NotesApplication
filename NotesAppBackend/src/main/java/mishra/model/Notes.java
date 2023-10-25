package mishra.model;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="notes")
public class Notes {
	
	public Notes() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long  id;
//	private LocalDateTime createdAt;
	@Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
public Timestamp getCreated_at() {
		return createdAt;
	}
	public void setCreated_at(Timestamp created_at) {
		this.createdAt = created_at;
	}
	//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
	@Column(name="email")
	private  String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Notes(String title, String categories, String content,String email) {
		super();
		this.title = title;
		this.Categories = categories;
		this.Content = content;
		this.email=email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategories() {
		return Categories;
	}
	public void setCategories(String categories) {
		Categories = categories;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	@Column(name="title")
	private String title;
	@Column(name="categories")
	private String Categories;
	@Column(name="content")
	private String Content;

	

}
