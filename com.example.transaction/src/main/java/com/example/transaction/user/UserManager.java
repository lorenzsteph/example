package com.example.transaction.user;

import java.util.List;

import com.example.transaction.model.User;

public interface UserManager {

	void insertUser(User user);

	User getUser(String username);

	List<User> getUsers();
}
