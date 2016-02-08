package com.example.transaction.user;

import java.util.List;

import javax.sql.DataSource;

import com.example.transaction.model.User;

public interface UserManager2 {

	void insertUser(User user, DataSource ds);

	User getUser(String username);

	List<User> getUsers();
}
