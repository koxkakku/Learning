/**
 * 
 */
package com.sharad.learn.restwebservices.basic.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharad.learn.restwebservices.basic.user.UserDetail;

/**
 * @author XY57013
 *
 */
public interface UserDetailsRepository extends JpaRepository<UserDetail, Integer> {

}
