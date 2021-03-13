package com.app.demo.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;

import com.app.demo.model.response.User;

@Service
public class UserService {
	
	HashMap<String, User> users = null;
	
	public UserService() {
		users = new HashMap<>();
		users.put("1", new User("1", "Yogesh", "More", "moreyog@gmail.com"));
		users.put("2", new User("2", "Hrushi", "Bhadule", "hsb@gmail.com"));
		users.put("3", new User("3", "Sujay", "Reddi", "mmreddi@gmail.com"));
	}

	public User getUser(String userId) {
		return users.get(userId);
	}

	public User createUser(User user) {
		users.put(user.getUserId(),user);
		return user;
	}

	public User updateUser(String userId, User user) {
		users.put(userId,user);
		return user;
	}

	public boolean deleteUser(String userId) {
		return users.remove(userId) == null ? false:true;
	}
}
