package com.example.transaction.dao;

import java.util.List;

import javax.sql.DataSource;

import com.example.transaction.model.User;

public interface UserDAO {

	void insertUser(User user);

	User getUser(String username);

	List<User> getUsers();

	void setMyDataSource(DataSource dataSource);
}
