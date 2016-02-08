package com.example.transaction.user.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transaction.dao.UserDAO;
import com.example.transaction.model.User;
import com.example.transaction.user.UserManager2;

@Service
public class UserManagerImpl2 implements UserManager2 {

	@Autowired
	private UserDAO userDAO;

	@Transactional("transactionManagerXX")
	public void insertUser(User user, DataSource ds) {
		userDAO.setMyDataSource(ds);
		userDAO.insertUser(user);

		System.out.println("insert user, verify commit!");

	}

	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	public List<User> getUsers() {
		return userDAO.getUsers();
	}

}
