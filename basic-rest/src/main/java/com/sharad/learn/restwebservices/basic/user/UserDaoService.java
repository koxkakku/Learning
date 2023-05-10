/**
 * 
 */
package com.sharad.learn.restwebservices.basic.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


/**
 * @author koxkakku
 *
 */
@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	static {
		users.add(new User(++userCount,"Sharad",LocalDate.now().minusYears(35)));
		users.add(new User(++userCount,"Saurav",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Saswat",LocalDate.now().minusYears(27)));
		users.add(new User(++userCount,"Sayan",LocalDate.now().minusYears(33)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	public User findUserById(Integer id) {
		Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public void deleteUserById(int id) {
		Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
		users.removeIf(predicate);
	}
}
