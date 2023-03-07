/**
 * 
 */
package com.sharad.learn.restwebservices.basic.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

/**
 * @author XY57013
 *
 */
@Entity(name= "user_post")
public class UserPost {

	/**
	 * 
	 */
	protected UserPost() {
	}

	@Id
	@GeneratedValue
	@Column(name="post_id")
	private Integer postId;
	
	@Size(min= 10)
	@Column(name="description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserDetail user;

	/**
	 * @param postId
	 * @param description
	 * @param user
	 */
	protected UserPost(Integer postId, @Size(min = 10) String description, UserDetail user) {
		super();
		this.postId = postId;
		this.description = description;
		this.user = user;
	}

	/**
	 * @return the postId
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the user
	 */
	public UserDetail getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDetail user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserPost [postId=" + postId + ", description=" + description + ", user=" + user + "]";
	}
	
	
}
