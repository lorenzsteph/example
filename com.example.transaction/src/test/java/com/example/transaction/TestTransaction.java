package com.example.transaction;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.transaction.model.User;
import com.example.transaction.user.UserManager;
import com.example.transaction.user.UserManager2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestTransaction {

	@Autowired
	private UserManager userManager;

	@Autowired
	private UserManager2 userManager2;

	@Test
	public void testInsert() {

		User user = new User();
		user.setUsername("userManager");
		user.setName("John Doe");

		//transazionale, commit quando esco dla metodo di insertUser
		userManager.insertUser(user);

		DataSource ds = this.newPooledDataSource();

		user = new User();
		user.setUsername("userManager2");
		user.setName("John Doe 2");

		//non è transazionale in quanto utilizzo una nuova connessione
		userManager2.insertUser(user, ds);

		Assert.assertTrue(true);

	}

	public DataSource newPooledDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/load");
		ds.setUsername("postgres");
		ds.setPassword("admin");

		return ds;
	}
}
