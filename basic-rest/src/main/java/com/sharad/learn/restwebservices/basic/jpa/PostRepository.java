/**
 * 
 */
package com.sharad.learn.restwebservices.basic.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sharad.learn.restwebservices.basic.user.UserPost;

/**
 * @author XY57013
 *
 */
public interface PostRepository extends JpaRepository<UserPost, Integer> {

	UserPost findByPostIdAndUserUserId(@Param("post_id")int postid, @Param("user_id")int id);

}
