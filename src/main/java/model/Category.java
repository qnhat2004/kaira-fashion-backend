package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column (nullable = false)
	private String name;
	
	@Column (nullable = false)
	private String slug;
	
	@Column (nullable = false)
	private String description;
	
	@Column
	private LocalDateTime created_at;
	
	@Column
	private LocalDateTime updated_at;
	
	@Column
	private LocalDateTime deleted_at;

	public Category() {}
	
	public Category(int id, String name, String slug, String description, LocalDateTime created_at, LocalDateTime updated_at,
			LocalDateTime deleted_at) {
		super();
		Id = id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public LocalDateTime getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(LocalDateTime deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	
}
