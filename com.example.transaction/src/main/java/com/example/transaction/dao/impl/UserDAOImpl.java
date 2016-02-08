package com.example.transaction.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.example.transaction.dao.UserDAO;
import com.example.transaction.model.User;

@Service
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public void setMyDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public void insertUser(User user) {
		getJdbcTemplate().update("INSERT INTO USERs (USERNAME, NAME) VALUES (?, ?)", new Object[] { user.getUsername(), user.getName() });
	}

	public User getUser(String username) {
		User user = getJdbcTemplate().queryForObject("SELECT * FROM USERs WHERE USERNAME = ?", new Object[] { username }, new UserMapper());
		return user;
	}

	public List<User> getUsers() {
		List<User> users = getJdbcTemplate().query("SELECT * FROM USERs", new UserMapper());
		return users;
	}

	private class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("ID"));
			user.setUsername(rs.getString("USERNAME"));
			user.setName(rs.getString("NAME"));
			return user;
		}

	}

}
