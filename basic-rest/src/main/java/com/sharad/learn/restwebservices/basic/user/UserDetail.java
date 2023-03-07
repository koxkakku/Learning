/**
 * 
 */
package com.sharad.learn.restwebservices.basic.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * @author XY57013
 *
 */
@Entity(name = "user_detail")
public class UserDetail {
	/**
	 * 
	 */
	protected UserDetail() {
	}
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Integer userId;
	
	@Size(min=2, message = "Name should have at least 2 characters.")
	@Column(name="user_name")
	private String userName;
	
	@Column(name = "birth_date")
	@Past(message = "Birth Date should be in past.")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UserPost> posts;
	
	protected UserDetail(Integer userId, String userName, LocalDate birthDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.birthDate = birthDate;
	}
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @return the posts
	 */
	public List<UserPost> getPosts() {
		return posts;
	}
	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<UserPost> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", birthDate=" + birthDate + ", posts=" + posts + "]";
	}
	
	
}
