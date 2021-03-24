package com.ga.blogapp.model;


import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*; // I can do this instead of all these: table, column, ...

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "Articles")
public class Article {

	@Id //PK, so the generated value conn't be altered
	@GeneratedValue
	private int id;
	
	private String title;
	
	private String description;
	
	/* BEFORE: it was many (articles) to one (author), but to author it was one (author) to many (articles)
	 * @ManyToOne
	 * @JoinColumn(name = "FK_AuthorId")
	 * private Author author;	
	 * */
	
	@ManyToMany
	//				     new table name, constraints
	@JoinTable(name = "author_articles",
			   joinColumns= {@JoinColumn(name = "article_id")},
			   inverseJoinColumns = {@JoinColumn(name = "author_id")}) // create a join table (new table) between articles and author..
	private Set<Author> authors; // one rule: inverse column goes to owner..
	
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createAt;
	
	@Column(name="updatedat", nullable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

}

