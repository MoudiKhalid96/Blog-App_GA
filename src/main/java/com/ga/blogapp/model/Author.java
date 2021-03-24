package com.ga.blogapp.model;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="Author")
public class Author {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String emailAddress;
	
	@Column(length = 50)
	private String gender;
	
	private Date dateofBirth;
		
	/*	@OneToMany(mappedBy = "author") //because we want our application 1:M
	 * private Set<Article> articles; 
	 * Before it was one (author) to many (articles)
	 * */
	
	@ManyToMany(mappedBy = "authors") //because we want our application M:N
	private Set<Article> articles; // I want to have multiple-articles
	
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getDateofBirth() {
		return dateofBirth;
	}
	
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
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
	
	public Set<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
}